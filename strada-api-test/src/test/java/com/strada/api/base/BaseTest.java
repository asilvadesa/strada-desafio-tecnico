package com.strada.api.base;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerAdapter;
import com.strada.api.specification.RequestSpecificationBuilder;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners(ExtentITestListenerAdapter.class)
public class BaseTest extends AbstractTestNGSpringContextTests {

    @Autowired
    protected RequestSpecificationBuilder requestSpecBuilder;

    protected static RequestSpecification requestSpecification;

    @BeforeClass(alwaysRun = true)
    protected void before() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        requestSpecification = requestSpecBuilder.build();

    }
}
