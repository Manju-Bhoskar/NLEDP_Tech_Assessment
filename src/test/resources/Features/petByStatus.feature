Feature: To identify Pets which are available and has name Doggie


  Scenario: To check status of pets with available status and "Doggie" name using real application/URL

    Given The real petstore is running
    When user finds pets by status
    Then the array size of available pets is returned
    And the number of pets with status available and the name doggie



  Scenario: To check status of pets with available status and "Doggie" name using wiremock/JsonFile

    Given The mock petstore is running
    When user finds pets by status
    Then the array size of available pets is returned
    And the number of pets with status available and the name doggie

