Feature: POST_Search accounts

  Background:
    Given El dominio de "Accounts" esta levantado

    Scenario: Busqueda de una cuenta existente en BBDD
      When Se realiza la request "POST" con el body "/Accounts/Input/oneExistingAccount.json"
      Then El servicio nos devuelve la respuesta "/Accounts/Output/oneExistingAccount.json"