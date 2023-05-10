Feature: test_DemoQA

  @seleniumdev3
  Scenario: Un utilisateur veut test le draganddrop sur le device
    Given : Un utilisateur se rend sur le site demo "https://demoqa.com/"
    When : Il clique sur la categorie Interactions
    And : attendre que son sous menu apparaisse avec "Droppable"
    And : Il clique sur la sous categorie "Droppable"


#    Actions action= new Actions(driver);
#    action.moveToElement(driver.findElement(buttonLogin)).perform;
