# language: en
@all
Feature: favourites
  Scenario: Add an ad to favorites from ad's page
    Given Open start page "https://www.reklama.lv/ru/"
    And choose a "Хозработы" category
    And checkFavoritesListIsClear
    And choose view type "cardView"
    Then open first ad in view "cardView"
    And scroll page down
    When Click on the 'add to favorites' button
    And open favorites page
    And Check that the ad has been added
    Then clear the favourite list

  Scenario: Add an ad to favorites from cardView
    Given Open start page "https://www.reklama.lv/ru/"
    And choose a "Хозработы" category
    And checkFavoritesListIsClear
    And choose view type "cardView"
    Then choose first ad in view "cardView" and click to favourite button
    When Click on the 'add to favorites' button
    And Check that the ad has been added
    Then clear the favourite list

  Scenario: Add an ad to favorites from textView
    Given Open start page "https://www.reklama.lv/ru/"
    And choose a "Хозработы" category
    And checkFavoritesListIsClear
    And choose view type "textView"
    Then choose first ad in view "textView" and click to favourite button
    When Click on the 'add to favorites' button
    And Check that the ad has been added
    Then clear the favourite list

  Scenario: Add an ad to favorites from tableView
    Given Open start page "https://www.reklama.lv/ru/"
    And choose a "Хозработы" category
    And checkFavoritesListIsClear
    And choose view type "tableView"
    Then choose first ad in view "tableView" and click to favourite button
    When Click on the 'add to favorites' button
    And Check that the ad has been added
    Then clear the favourite list

  Scenario: Add and remove ad from cardView
    Given Open start page "https://www.reklama.lv/ru/"
    And choose a "Хозработы" category
    And checkFavoritesListIsClear
    And choose view type "cardView"
    Then choose first ad in view "cardView" and click to favourite button
    And click remove from favourite in view "cardView"
    Then check that ad was not added

