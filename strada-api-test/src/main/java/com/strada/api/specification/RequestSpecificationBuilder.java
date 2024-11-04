package com.strada.api.specification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RequestSpecificationBuilder {

    @Value("${service.baseUri}")
    protected String baseUriService;

    @Value("${service.basePath}")
    protected String basePath;

    public RequestSpecification build() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(baseUriService);
        requestSpecBuilder.setBasePath(basePath);
        return requestSpecBuilder.build();
    }
}
