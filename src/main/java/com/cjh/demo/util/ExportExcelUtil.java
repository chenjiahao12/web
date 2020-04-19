package com.cjh.demo.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.*;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * excel导出工具类
 * @author 伺机
 *
 */
public class ExportExcelUtil {

	// 2007 版本以上 最大支持1048576行
	public  final static String  EXCEl_FILE_2007 = "2007";
	// 2003 版本 最大支持65536 行
	public  final static String  EXCEL_FILE_2003 = "2003";
	
	/**
	 * 下载excel 默认为2007版本
	 * @param response
	 * @param title
	 * @param headMap
	 * @param datas
	 * @param dateFormate
	 */
	public static void exportExcel(HttpServletResponse response, String title, Map<String, String> headMap, 
			List<? extends Object> datas, String dateFormate) {
		try {
			response.setContentType("application/vnd.ms-excel");  
			response.addHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(title, "UTF-8") + ".xlsx");
			
			if (StringUtils.isEmpty(dateFormate)) {
				dateFormate = "yyyy-MM-dd HH:mm:ss";
			}
			exportExcel2007(title, headMap, datas, response.getOutputStream(), dateFormate);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 下载excel 默认为2007版本
	 * @param response
	 * @param title
	 * @param headMap
	 * @param datas
	 * @param dateFormate
	 */
	public static void exportExcel(HttpServletResponse response, String title, Map<String, String> headMap, 
			List<? extends Object> datas, String dateFormate, String version) {
		try {
			response.setContentType("application/vnd.ms-excel");
			
			if (StringUtils.isEmpty(version) || EXCEl_FILE_2007.equals(version.trim())) {
				response.addHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(title, "UTF-8") + ".xlsx");
				exportExcel2007(title, headMap, datas, response.getOutputStream(), dateFormate);
			} else {
				response.addHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(title, "UTF-8") + ".xls");
				exportExcel2003(title, headMap, datas, response.getOutputStream(), dateFormate);
			}
			
			
			if (StringUtils.isEmpty(dateFormate)) {
				dateFormate = "yyyy-MM-dd HH:mm:ss";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 导出带有头部标题行的Excel
	 * @param title 表格标题
	 * @param headMap 头部标签集合
	 * @param datas 数据集合
	 * @param out 输出流
	 * @param dateFormate 时间格式
	 * @param version 2003 或者 2007，不传时默认生成2003版本
	 * @throws Exception 
	 */
	public static void exportExcel(String title, Map<String, String> headMap, List<? extends Object> datas,
			 OutputStream out, String dateFormate, String version) {
		
		if (StringUtils.isEmpty(dateFormate)) {
			dateFormate = "yyyy-MM-dd HH:mm:ss";
		}
		
		if(StringUtils.isEmpty(version) || EXCEl_FILE_2007.equals(version.trim())){
			exportExcel2007(title, headMap, datas, out, dateFormate);
		}else{
			exportExcel2003(title, headMap, datas, out, dateFormate);
		}
	}
	
	/**
	 * 导出自定义时间格式的表格
	 * @param title 表格标题
	 * @param headMap 头部标签集合
	 * @param datas 数据集合
	 * @param out 输出流
	 * @param dateFormate 时间格式
	 * @throws Exception 
	 */
	public static void exportExcel(String title, Map<String, String> headMap, List<? extends Object> datas,
			OutputStream out, String dateFormate) throws Exception {
		exportExcel2007(title, headMap, datas, out, dateFormate);
	}
	
	private static void exportExcel2007(String title, Map<String, String> headMap, List<? extends Object> datas,
			OutputStream out, String dateFromat) {
		
		XSSFWorkbook workbook = null;
		try {
			// 声明一个工作薄
			workbook = new XSSFWorkbook();
			
			// 生成一个表格
			XSSFSheet sheet = workbook.createSheet(title);
			// 设置表格默认列宽度为15个字节
			sheet.setDefaultColumnWidth(20);
			//设置样式
			XSSFCellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(new XSSFColor(java.awt.Color.gray));
			style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
			style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			style.setBorderRight(XSSFCellStyle.BORDER_THIN);
			style.setBorderTop(XSSFCellStyle.BORDER_THIN);
			style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
			
			// 生成一个字体
			XSSFFont font = workbook.createFont();
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontName("宋体"); 
			font.setColor(new XSSFColor(java.awt.Color.BLACK));
			font.setFontHeightInPoints((short) 11);
			// 把字体应用到当前的样式
			style.setFont(font);
			// 生成并设置另一个样式
			XSSFCellStyle style2 = workbook.createCellStyle();
			style2.setFillForegroundColor(new XSSFColor(java.awt.Color.WHITE));
			style2.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
			style2.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			style2.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			style2.setBorderRight(XSSFCellStyle.BORDER_THIN);
			style2.setBorderTop(XSSFCellStyle.BORDER_THIN);
			style2.setAlignment(XSSFCellStyle.ALIGN_CENTER);
			style2.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
			// 生成另一个字体
			XSSFFont font2 = workbook.createFont();
			font2.setBoldweight(XSSFFont.BOLDWEIGHT_NORMAL);
			// 把字体应用到当前的样式
			style2.setFont(font2);
			
			// 产生表格标题行
			XSSFRow row = sheet.createRow(0);
			XSSFCell cellHeader;
			Set<String> keySet = headMap.keySet();
			
			int headerIndex = 0;
			for (String key : keySet) {
				cellHeader = row.createCell(headerIndex);
				cellHeader.setCellStyle(style);
				cellHeader.setCellValue(new XSSFRichTextString(key));
				headerIndex++;
			}
			
			XSSFCell cell;
			int dataIndex = 1;
			
			for (Object data : datas) {
				int dataCellIndex = 0;
				row = sheet.createRow(dataIndex);
				dataIndex ++;
				for (String key : keySet) {
					cell = row.createCell(dataCellIndex);
					cell.setCellStyle(style2);
					
					Field field = data.getClass().getDeclaredField(headMap.get(key));
					field.setAccessible(true);
					Object value = field.get(data);
					setCellValue(value, cell, dateFromat);
					dataCellIndex++;
				}
			}
			workbook.write(out);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	

	private static void exportExcel2003(String title, Map<String, String> headrMap, List<? extends Object> datas,
			OutputStream out, String dateFromat) {
		HSSFWorkbook workbook = null;
		
		try {
			// 声明一个工作薄
			workbook = new HSSFWorkbook();
			// 生成一个表格
			HSSFSheet sheet = workbook.createSheet(title);
			// 设置表格默认列宽度为15个字节
			sheet.setDefaultColumnWidth(20);
			// 生成一个样式
			HSSFCellStyle style = workbook.createCellStyle();
			// 设置这些样式
			style.setFillForegroundColor(HSSFColor.GREY_50_PERCENT.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			style.setBorderRight(HSSFCellStyle.BORDER_THIN);
			style.setBorderTop(HSSFCellStyle.BORDER_THIN);
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			// 生成一个字体
			HSSFFont font = workbook.createFont();
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			font.setFontName("宋体"); 
			font.setColor(HSSFColor.WHITE.index);
			font.setFontHeightInPoints((short) 11);
			// 把字体应用到当前的样式
			style.setFont(font);
			// 生成并设置另一个样式
			HSSFCellStyle style2 = workbook.createCellStyle();
			style2.setFillForegroundColor(HSSFColor.WHITE.index);
			style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
			style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
			style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			// 生成另一个字体
			HSSFFont font2 = workbook.createFont();
			font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
			// 把字体应用到当前的样式
			style2.setFont(font2);
			
			//表格标题行
			HSSFRow row = sheet.createRow(0);
			HSSFCell cellHeader;
			int headIndex = 0;
			Set<String> keySet = headrMap.keySet();
			for (String key : keySet) {
				cellHeader = row.createCell(headIndex);
				cellHeader.setCellStyle(style);
				cellHeader.setCellValue(key);
			}
			
			// 遍历集合数据，产生数据行
			int dataIndet = 1;
			Field field;
			HSSFCell cell;
			Object value;
			
			for (Object data : datas) {
				row = sheet.createRow(dataIndet);
				dataIndet ++;
				int dataCellIndex = 0;
				
				for (String key : keySet) {
					cell = row.createCell(dataCellIndex);
					cell.setCellStyle(style2);
					field = data.getClass().getDeclaredField(headrMap.get(key));
					field.setAccessible(true);
					value = field.get(data);
					//设值
					setCellValue(value, cell, dateFromat);
					dataCellIndex ++;
				}
			}
			workbook.write(out);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void setCellValue(Object value, Cell cell, String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Pattern p = Pattern.compile("^//d+(//.//d+)?$");
		
		// 判断值的类型后进行强制类型转换
		String textValue = null;
		if (value instanceof Integer) {
			cell.setCellValue((Integer) value);
		} else if (value instanceof Float) {
			textValue = String.valueOf((Float) value);
			cell.setCellValue(textValue);
		} else if (value instanceof Double) {
			textValue = String.valueOf((Double) value);
			cell.setCellValue(textValue);
		} else if (value instanceof Long) {
			cell.setCellValue((Long) value);
		}
		if (value instanceof Boolean) {
			textValue = "是";
			if (!(Boolean) value) {
				textValue = "否";
			}
		} else if (value instanceof Date) {
			textValue = sdf.format((Date) value);
		} else {
			// 其它数据类型都当作字符串简单处理
			if (value != null) {
				textValue = value.toString();
			}
		}
		if (textValue != null) {
			Matcher matcher = p.matcher(textValue);
			if (matcher.matches()) {
				// 是数字当作double处理
				cell.setCellValue(Double.parseDouble(textValue));
			} else {
				if (cell instanceof HSSFCell){
					HSSFRichTextString richString = new HSSFRichTextString(textValue);
					cell.setCellValue(richString);
				} else if (cell instanceof XSSFCell){
					XSSFRichTextString richString = new XSSFRichTextString(textValue);
					cell.setCellValue(richString);
				}
			}
		}
	}
}
