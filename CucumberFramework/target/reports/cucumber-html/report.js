$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/login.feature");
formatter.feature({
  "line": 1,
  "name": "Login to rediff.com",
  "description": "",
  "id": "login-to-rediff.com",
  "keyword": "Feature"
});
formatter.before({
  "duration": 115843088,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Login to rediiff.com using user id and password",
  "description": "",
  "id": "login-to-rediff.com;login-to-rediiff.com-using-user-id-and-password",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@Login"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I open firefox",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I navigate to rediffHomePage",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "I click on login",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I wait for 3000 milliseconds",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I enter writetoprabha in userId text field",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I enter password1 in password text field",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I click on go",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I verify that page contains text",
  "rows": [
    {
      "cells": [
        "Temporary error occured[#5001], please try again."
      ],
      "line": 13
    }
  ],
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "firefox",
      "offset": 7
    }
  ],
  "location": "StepDefinitions.openBrowser(String)"
});
formatter.result({
  "duration": 155448962,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "rediffHomePage",
      "offset": 14
    }
  ],
  "location": "GenericSteps.navigateTo(String)"
});
formatter.result({
  "duration": 37877178719,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "login",
      "offset": 11
    }
  ],
  "location": "GenericSteps.clickOnElement(String)"
});
formatter.result({
  "duration": 5323888669,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3000",
      "offset": 11
    }
  ],
  "location": "GenericSteps.wait(int)"
});
formatter.result({
  "duration": 3001764400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "writetoprabha",
      "offset": 8
    },
    {
      "val": "userId",
      "offset": 25
    }
  ],
  "location": "GenericSteps.enterTextInTextField(String,String)"
});
formatter.result({
  "duration": 120100569,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "password1",
      "offset": 8
    },
    {
      "val": "password",
      "offset": 21
    }
  ],
  "location": "GenericSteps.enterTextInTextField(String,String)"
});
formatter.result({
  "duration": 103362474,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "go",
      "offset": 11
    }
  ],
  "location": "GenericSteps.clickOnElement(String)"
});
formatter.result({
  "duration": 2926545001,
  "status": "passed"
});
formatter.match({
  "location": "GenericSteps.verifyPageContainstext(String\u003e)"
});
formatter.result({
  "duration": 100385099,
  "status": "passed"
});
formatter.after({
  "duration": 6253057689,
  "status": "passed"
});
});