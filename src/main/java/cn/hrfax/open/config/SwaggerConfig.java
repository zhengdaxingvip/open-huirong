package cn.hrfax.open.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author chenpw
 * @version 1.0
 * @date 2018/12/4 14:57
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig{

//    @Override  extends WebMvcConfigurerAdapter
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }

    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("huirong-api")
                .apiInfo(apiInfo())
                .select()
                //为当前包路径
                //.apis(RequestHandlerSelectors.basePackage("carloan.loan.controller")) // 这个包指的是我们在哪些类中使用swagger2来测试。
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))// 扫描使用注解@ApiOperation的方法。
                .paths(PathSelectors.any())
                .build();

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("惠瀜系统对外开放接口平台")
                //描述
                .description("外部机构对接接口")
                //创建人
                .contact("浙江惠瀜网络科技有限公司")
                //版本号
                .version("1.0.0")
                .build();

    }

}
