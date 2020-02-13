package com.lhx.charity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 *  http://localhost:8078/swagger-ui.html#!/
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {


    @Bean
    public Docket createRestApi() {


//        //添加head参数start
//        ParameterBuilder tokenPar = new ParameterBuilder();
//        List<Parameter> pars = new ArrayList<>();
//        tokenPar.name("Authorization").description("令牌")
//                .modelRef(new ModelRef("string")).parameterType("header")
//                .required(false).defaultValue("5p6X5rGJ6b6ZOkEwMTczOTo5MjU2NDg2NzI4NzM0NTk3MTI=").build();
//        pars.add(tokenPar.build());
//        //添加head参数end



        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
//                .globalOperationParameters(pars)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lhx.charity.controller"))
//                .paths(PathSelectors.regex("/test/.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("xxx慈善机构 API")
                .description("xxx慈善机构 API")
                .termsOfServiceUrl("http://192.168.65.123:8078/swagger-ui.html#!/")
                .contact("李恒新")
                .version("1.0")
                .build();
    }

}
