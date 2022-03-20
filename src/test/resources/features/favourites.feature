# language: en
@all
Feature: favourites
  Scenario: Add an ad to favorites from ad page
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

#TO DO
# Scenario: Add and remove ad
# Scenario: check that ad was saved after close tab
