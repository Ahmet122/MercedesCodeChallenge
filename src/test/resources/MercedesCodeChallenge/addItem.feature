Feature: N11 E-Commerce

  Scenario: Open N11 website and add item to basket then logout

    Given Open page "https://www.n11.com/"
    Then Click the "//*[@class='btnSignIn']"
    Then Click item "//*[@class='dn-slide-deny-btn']" in order 0
    Then Enter "ahmetugurtest@hotmail.com" to "//input[@id='email']"
    Then Enter "Ahmet-Test/555" to "//input[@id='password']"
    Then Click the "//*[@id='loginButton']"
    And Wait for element "//*[@class='iconsBasketWhite']"
    When Enter "Laptop" to "//input[@id='searchData']" and press enter
    And Take the names of items "//*[@class='productName']" 0 and 2, add items "//*[@class='btnBasket']" to basket, click "//*[@class='iconsBasketWhite']" and compare the names "//*[@class='prodDescription']" 1
    Then Click the "/html/body/div[1]/div[4]/div/div[1]/div[1]/div[3]/section/table[2]/tbody/tr/td[1]/div[3]/div[2]/div/span[1]"
    And The number of element "//*[@class='quantity'][@value='2']"
    And Click item "//*[@title='Sil']" in order 0
    Then Click the "//*[@id='deleteBtnDFLB']"
    And Click item "//*[@title='Sil']" in order 0
    Then Click the "//*[@id='deleteBtnDFLB']"
    Then Click the "/html/body/div[1]/header/div/div/div/div[1]/a"
    And Hover "//*[@class='user']" element
    Then Click the "//*[@class='logoutBtn']"
    And Close page

