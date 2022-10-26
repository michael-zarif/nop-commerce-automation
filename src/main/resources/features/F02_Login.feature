@smoke @login
  Feature: F02_Login | Users could use login functionality to use their accounts

    Scenario: User could login with valid email and password
      Given User go to login page
      When User login with valid email "test@example.com" and password "P@ssw0rd"
      When User press on login button
      Then User login to the system successfully

    Scenario: User should not be able to login with invalid email and valid password
      Given User go to login page
      When User login with invalid "wrong@example.com" and "P@ssw0rd"
      When User press on login button
      Then User could not login to the system