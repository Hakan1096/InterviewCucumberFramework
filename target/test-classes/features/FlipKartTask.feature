Feature:FlipKart task

  @wip
  Scenario: FlipKart Automation Task
    Given go to FlipKart page
    When search the "lg-soundbar"
    And click to Brand and search "Lg"
    And take all the product's names with prices on the page
    Then sort of the all products via price