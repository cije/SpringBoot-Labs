package com.ce.lab5apidocswaggerknife4j.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * // @EnableSwagger2 标记项目启用 Swagger API 接口文档
 *
 * @author c__e
 * @date Created in 2020/9/25 16:01
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket createRestApi() {
        // 创建Docket对象
        //文档类型，使用Swagger2
        return new Docket(DocumentationType.SWAGGER_2)
                // 设置API信息
                .apiInfo(this.apiInfo())
                // 扫描Controlelr 包路径，获得API信息
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ce.lab5apidocswaggerknife4j.controller"))
                .paths(PathSelectors.any())
                // 构建出Docket对象
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("测试接口文档示例")
                .description("我是一段描述")
                // 版本号
                .version("1.0.0")
                // 联系人
                .contact(new Contact("c__e", "https://github.com/cije", "an37500@163.com"))
                .build();
    }
}
