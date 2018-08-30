Feature: Testing https://reqres.in/ swagger services

  Scenario:
    When I request to do 'get' operation to get a user by:
      | id | 2 |
    Then I should get a response with:
      | first_name | Janet                                                              |
      | last_name  | Weaver                                                             |
      | avatar     | https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg |
    And The status code must be 200