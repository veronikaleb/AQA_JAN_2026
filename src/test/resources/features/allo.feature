Feature: Allo Price Sync

  Scenario: Search and sync iphone prices
    When I search for "iphone" on allo.ua
    Then I sync first 3 prices with database