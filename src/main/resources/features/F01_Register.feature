@smoke @register
  Feature: F01_Register | User could register with new accounts

    Scenario: Guest user could register with valid data successfully
      Given User go to register page
      When User selects gender type
      When User enters first name "automation" and last name "tester"
      When User enters date of birth "12" "February" "2000"
      When User enters email "test4@example.com"
      When User fills Password fields "P@ssw0rd"
      When User clicks on register button
      Then Successful registration message "Your registration completed" is displayed