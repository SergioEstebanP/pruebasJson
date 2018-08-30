$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/test.feature");
formatter.feature({
  "name": "Testing https://reqres.in/ swagger services",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I request to do \u0027get\u0027 operation to get a user by:",
  "rows": [
    {
      "cells": [
        "id",
        "2"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "StepsDefinitions.iRequestToDoOperationToGetAuser(String,String,String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should get a response with:",
  "rows": [
    {
      "cells": [
        "first_name",
        "Janet"
      ]
    },
    {
      "cells": [
        "last_name",
        "Weaver"
      ]
    },
    {
      "cells": [
        "avatar",
        "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg"
      ]
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "StepsDefinitions.iShouldGetAResponseWith(String,String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The status code must be 200",
  "keyword": "And "
});
formatter.match({
  "location": "StepsDefinitions.theStatusCodeMustBe(int)"
});
formatter.result({
  "status": "passed"
});
});