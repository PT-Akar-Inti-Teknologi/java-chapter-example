package org.ait.project.aitboilerplate.config.documentation;

import lombok.RequiredArgsConstructor;
import org.ait.project.aitboilerplate.shared.commons.properties.ApplicationProperties;
import org.ait.project.aitboilerplate.shared.constant.GlobalConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableWebMvc
@Profile({"!prod"})
@RequiredArgsConstructor
public class DocumentationConfig extends WebMvcConfigurationSupport {

    private final ApplicationProperties applicationProperties;

    /** Documentation per module */
    @Bean
    public Docket customerModule() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(
                        RequestHandlerSelectors.basePackage(
                                applicationProperties.getSpring().getApplication().getGroupId() + "." +
                                        applicationProperties.getSpring().getApplication().getArtifactId() + "." +
                                        GlobalConstant.documentationPackageCustomer))
                .paths(PathSelectors.regex(GlobalConstant.anyPath))
                .build()
                .enable(true)
                .genericModelSubstitutes(ResponseEntity.class)
                .groupName(GlobalConstant.documentationGroupCustomer)
                .apiInfo(metaData());
    }
    @Bean
    public Docket itemModule() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(
                        RequestHandlerSelectors.basePackage(
                                applicationProperties.getSpring().getApplication().getGroupId() + "." +
                                        applicationProperties.getSpring().getApplication().getArtifactId() + "." +
                                        GlobalConstant.documentationPackageItem))
                .paths(PathSelectors.regex(GlobalConstant.anyPath))
                .build()
                .enable(true)
                .genericModelSubstitutes(ResponseEntity.class)
                .groupName(GlobalConstant.documentationGroupItem)
                .apiInfo(metaData());
    }
    @Bean
    public Docket orderModule() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(
                        RequestHandlerSelectors.basePackage(
                                applicationProperties.getSpring().getApplication().getGroupId() + "." +
                                        applicationProperties.getSpring().getApplication().getArtifactId() + "." +
                                        GlobalConstant.documentationPackageOrder))
                .paths(PathSelectors.regex(GlobalConstant.anyPath))
                .build()
                .enable(true)
                .genericModelSubstitutes(ResponseEntity.class)
                .groupName(GlobalConstant.documentationGroupOrder)
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title(applicationProperties.getSpring().getApplication().getName())
                .description(applicationProperties.getSpring().getApplication().getDescription())
                .version(applicationProperties.getSpring().getApplication().getVersion())
                .build();
    }
}
