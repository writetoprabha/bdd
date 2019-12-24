package com.seleniumcucumber.steps;

import com.seleniumcucumber.webdriver.WebConnector;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import java.util.List;

public class Apis {
    WebConnector connector;
    public Apis (WebConnector connector) {
        this.connector = connector;
    }

    @Given("^I invoke \"([^\"]*)\" using below parameters with GET method$")
    public void i_invoke_using_below_parameters_with_GET_method(String apiName, List<String> params) {
        connector.invokeApiUsingGetMethod(apiName, params);
    }

    @And("^I verify that \"([^\"]*)\" parameter in response contains \"([^\"]*)\"$")
    public void i_verify_that_parameter_in_response_contains(String param, String value) throws ParseException {
        connector.validateResponseParam(param, value);
    }

    @And("^I verify that response has status code (\\d+)$")
    public void i_verify_that_response_has_status_code(int statusCode) {
        boolean result = connector.validateResponseStatusCode(statusCode);
    }

}
