$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/login.feature");
formatter.feature({
  "line": 1,
  "name": "Login to rediff.com",
  "description": "",
  "id": "login-to-rediff.com",
  "keyword": "Feature"
});
formatter.before({
  "duration": 4776698690,
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
  "duration": 79306659,
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
  "duration": 33855239336,
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
  "duration": 5391739330,
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
  "duration": 3001276236,
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
  "duration": 125646612,
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
  "duration": 107797906,
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
  "duration": 2966840188,
  "status": "passed"
});
formatter.match({
  "location": "GenericSteps.verifyPageContainstext(String\u003e)"
});
formatter.result({
  "duration": 92484852,
  "status": "passed"
});
formatter.after({
  "duration": 7744340919,
  "status": "passed"
});
formatter.before({
  "duration": 3867984534,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "Login to rediiff.com using user id and password",
  "description": "",
  "id": "login-to-rediff.com;login-to-rediiff.com-using-user-id-and-password",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 16,
      "name": "@Login"
    }
  ]
});
formatter.step({
  "line": 18,
  "name": "I open firefox",
  "keyword": "Given "
});
formatter.step({
  "line": 19,
  "name": "I navigate to rediffHomePage",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "I click on login",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "I wait for 3000 milliseconds",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "I enter writetoprabha in userId text field",
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "I enter password1 in password text field",
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "I click on go",
  "keyword": "And "
});
formatter.step({
  "line": 25,
  "name": "I verify that page contains text",
  "rows": [
    {
      "cells": [
        "Temporary error ocured[#5001], please try again."
      ],
      "line": 26
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
  "duration": 143161,
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
  "duration": 33286850546,
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
  "duration": 5318138875,
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
  "duration": 3000697052,
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
  "duration": 121313206,
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
  "duration": 108909089,
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
  "duration": 2930222178,
  "status": "passed"
});
formatter.match({
  "location": "GenericSteps.verifyPageContainstext(String\u003e)"
});
formatter.result({
  "duration": 20279281485,
  "status": "passed"
});
formatter.after({
  "duration": 8603846827,
  "status": "passed"
});
});