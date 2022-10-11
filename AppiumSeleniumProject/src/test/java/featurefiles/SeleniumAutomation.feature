#Author: mohammedirfan.shaik878@gmail.com
@Web
Feature: Selenium Automation Scenarios

  Background: 
    Given Go to JqueryUi Website

  Scenario: Selenium scenario 1
    And Select 'Dropabble' option from Left menu
    Then Drag 'Drag me to my target' component to 'Drop here' component

  Scenario: Selenium scenario 2
    And Select 'Selectable' option from Left menu
    Then Select Multiple Items
    
  Scenario: Selenium scenario 3
    And Select 'Controlgroup' option from Left menu under Widgets
    Then Select Multiple options  
