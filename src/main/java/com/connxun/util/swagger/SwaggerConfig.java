package com.connxun.util.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author：luoxiaosheng
 * @Date：2017-09-15 12:02
 * @Comments：swagger配置类
 */
@EnableWebMvc
@EnableSwagger2
@Configuration
@PropertySource("classpath:application.properties")
public class SwaggerConfig {

    //swagger title
    @Value("${swagger.title}")
    private String SWAGGER_TITLE;
    //swagger description
    @Value("${swagger.description}")
    private String SWAGGER_DESCRIPTION;
    //swagger termsOfServiceUrl
    @Value("${swagger.termsOfServiceUrl}")
    private String SWAGGER_TERM;
    //swagger contact
    @Value("${swagger.contact}")
    private String SWAGGER_CONTACT;
    //swagger version
    @Value("${swagger.version}")
    private String SWAGGER_VERSION;

//    static{
//        OpeProperties opeProperties=new OpeProperties();
//        SWAGGER_TITLE= opeProperties.GetValueByKey("","swagger.title").trim();
//        SWAGGER_DESCRIPTION=opeProperties.GetValueByKey("","swagger.description").trim();;
//        SWAGGER_TERM=opeProperties.GetValueByKey("","swagger.termsOfServiceUrl").trim();
//        SWAGGER_CONTACT=opeProperties.GetValueByKey("","swagger.contact").trim();;
//        SWAGGER_VERSION=opeProperties.GetValueByKey("","swagger.version").trim();
//    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("housekeep api")
                .apiInfo(apiInfo())
                .select()
//                .apis(RequestHandlerSelectors.any())    //所有API
                .apis(RequestHandlerSelectors.basePackage("com.connxun.app.controller")) // 注意修改此处的包名
                .paths(PathSelectors.any()) //
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(SWAGGER_TITLE) // 任意，请稍微规范点
                .description(SWAGGER_DESCRIPTION) // 任意，请稍微规范点
                .termsOfServiceUrl(SWAGGER_TERM) // 将“url”换成自己的ip:port
                .contact(SWAGGER_CONTACT) // 无所谓（这里是作者的别称）
                .version(SWAGGER_VERSION)
                .build();
    }

//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("家政频道接口列表 v1.1.0") // 任意，请稍微规范点
//                .description("  接口调用请求说明  " +
//                        "  http请求方式：GET/POST/FORM\n" +
//                        "  编码方式：UTF-8  ") // 任意，请稍微规范点
//                .termsOfServiceUrl("http://localhost:8080/swagger-ui.html") // 将“url”换成自己的ip:port
//                .contact("luoxiaosheng") // 无所谓（这里是作者的别称）
//                .version("1.1.0")
//                .build();
//    }


}
