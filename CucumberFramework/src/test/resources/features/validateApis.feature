Feature: Api validations

  @GetCityWeatherApi
  Scenario Outline: Validate Get City Weather Api
    Given I invoke "getCityWeather" using below parameters with GET method
      |/<city>|
    And I verify that response has status code 200
    And I verify that "City" parameter in response contains "<city>"
  Examples:
  |city|
  |Hyderabad|
  |Chennai  |
  |Delhi    |