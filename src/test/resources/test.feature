Feature: test

  @seleniumdev
  Scenario: Un client remplie et valide le formulaire d'inscription sur le device
    Given : un client  sur le site demo "https://demowebshop.tricentis.com/register"
    When : il saisit  son firstName sur le device "Yohan"
    And : il saisit son LastName sur le device "Pire"
    And : il saisit son Email sur le device "yop" "@yopmail.com"
    And : il saisit son Password sur le device "testtest"
    And : il saisit le same Password sur le device "testtest"
    And : il clique sur le bouton register
    Then :le message "Your registration completed" s'affiche avec le bouton continue en dessous

  @seleniumdev2
    Scenario: Etant connecté je check que les éléments de la liste de gauche est apparente
      Given : Un client sur le site démo "https://demowebshop.tricentis.com/"
      Then : Je veux voir toutes les catégories

