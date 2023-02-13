Feature: N11 E-Commerce

  Scenario: Change birthday

    Given Open page "https://www.n11.com/"
    Then Click the "//*[@class='btnSignIn']"
    Then Click item "//*[@class='dn-slide-deny-btn']" in order 0
    Then Enter "ahmetugurtest@hotmail.com" to "//input[@id='email']"
    Then Enter "Ahmet-Test/555" to "//input[@id='password']"
    Then Click the "//*[@id='loginButton']"
    And Hover "//*[@class='user']" element
    Then Click the "/html/body/div[1]/header/div/div/div/div[2]/div[5]/div[2]/div/a[9]"
    When Move to center "//*[@id='birthDay']"
    Then Click the "//*[@id='birthDay']"
    And Select date "//*[@value='"
    Then Click the "//*[@id='birthMonth']"
    And Select month "//*[@value='"
    Then Click the "//*[@id='birthYear']"
    Then Select year "//*[@value='"
    Then Click the "//*[@id='updatePersonalInfoBtn']"
    Then Click the "/html/body/div[13]/div/div/span"
    And Hover "//*[@class='user']" element
    Then Click the "//*[@class='logoutBtn']"
    And Close page