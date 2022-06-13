Feature: HepsiBurada
  @register
  Scenario: User registers by successfully completing the registration form
    Given a web browser is at the Hepsiburada home page
    When the user click dropdown
    And user clicks on the login item
    Then user sees the login form
    And user enters the mail
    And user click login button
    And user enters password
    And user click Login2 button
    And HepsiBurada text click
    And search product
    And Take first product
    And Enter new tab
    And Take First Product Store Name
    And Return Old Tab
    And Take Second Product
    And Go to Basket
    And Control Basket



