package com.cjh.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;


@Configuration
//注解开启 swagger2 功能
@EnableSwagger2
public class Swagger2Config {

    /*是否开启swagger，项目上线时关闭*/
    private Boolean enable = true;

    /**
     * @Description:swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
     */
    @Bean
    public Docket createRestApi() {
    /*    // 为swagger添加header参数可供输入
        ParameterBuilder userTokenHeader = new ParameterBuilder();
        ParameterBuilder userIdHeader = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        userTokenHeader.name("headerUserToken").description("userToken")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build();
        userIdHeader.name("headerUserId").description("userId")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build();
        pars.add(userTokenHeader.build());
        pars.add(userIdHeader.build());*/
        List<Parameter> pars = new ArrayList<Parameter>();
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                //是否开启swagger，正式环境一般是需要关闭的
                .enable(enable)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cjh.demo.controller"))
                .paths(PathSelectors.any()).build()
                .globalOperationParameters(pars);
    }

    /**
     *
     * - swagger.title=标题
     * - swagger.description=描述
     * - swagger.version=版本
     * - swagger.license=许可证
     * - swagger.licenseUrl=许可证URL
     * - swagger.termsOfServiceUrl=服务条款URL
     * - swagger.contact.name=维护人
     * - swagger.contact.url=维护人URL
     * - swagger.contact.email=维护人email
     * - swagger.base-package=swagger扫描的基础包，默认：全扫描
     * - swagger.base-path=需要处理的基础URL规则，默认：/**
     * - swagger.exclude-path=需要排除的URL规则，默认：空
     * - swagger.host=文档的host信息，默认：空
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //设置文档标题
                .title("SpringBoot整合Swagger2")
                //文档描述
                .description("测试Swagger2")
                //服务条款URL
                .termsOfServiceUrl("http://127.0.0.1:8080/")
                //联系信息
                .contact(".3.")
                //版本号
                .version("9527")
                .build();
    }

}
