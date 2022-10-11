#Author: your.email@your.domain.com
@mobile
Feature: Mobile Automation Scenarios

Background: 
Given Launch Application

  Scenario: Appium Scenario 1
    And I Verify the title
    Then I Verify the elements on the screen
    
  Scenario:  Appium Scenario 2
  		And Tap on 'EN Button'
  		Then Select Option 'No, no' and Check if HomePage is displayed
  		
  Scenario: Appium Scenario 3
  	And Tap on ChromeLogoButton
  	And Verify the Title and Verify the Text 'Hello, Can you'
  	Then Enter your name in text box and Select Prefered car as 'Mercedes'
  	And Tap on 'Send me your name' and Verify the text 'This is My'
  	Then Verify your name and Prefered car selected from the previous screen
  	Then Click on Link 'here' at the bottom and Check if Default prefered car is 'Volvo'
  	
  Scenario: Appium Scenario 4
  		When I Tap on File logo button i should navigate to next page
  		And Verify Text 'Welcome to' and Verify the elements on screen
  		And Check Name Field is pre-populated with 'Mr. Burns' and Check if Ruby is selected
  		Then Fill in the fields with new Values and Select 'I accept ads'
  		And Tap on Register User and Verify the user details on the next screen
  		When I tap on Register user check if the screen navigates to homescreen
  		
  	Scenario: Appium Scenario 5
  			When i tap on 'show progres button' wait for loader to disappear
  			Then Verify the Elements on the user registration screen
  			
  	Scenario: Appium Scenario 6
  				When I tap on Displays a toast button
  				Then Verify the Text		
  			
  	Scenario: Appium Scenario 7
  			When I tap on Display popup button
  			Then Click on Dismiss 		
