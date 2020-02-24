@Accounts
Feature: POST_Search accounts

  Como usuario quiero tener en el dominio de Accounts un endpoint para realizar distintas consultas de Cuentas mediante el par [AccountId, Pais] para poder ver el detalle de las mismas

  Background:
    Given El dominio de accounts esta levantado

    Scenario Outline: Casuisticas de busquedas de cuentas

      Como usuario quiero realizar satisfactoriamente distintas casuísticas de búsqueda para validar que la respuesta es correcta

      When Se realiza una peticion "POST" al endpoint accounts con el body "Accounts/Input/POST_Search_accounts/<jsonInputBody>"
      Then El servicio de accounts nos devuelve la respuesta "Accounts/Output/POST_Search_accounts/<jsonOutputBody>"
      Examples:
        | jsonInputBody               | jsonOutputBody              |
        | oneExistingAccount.json     | oneExistingAccount.json     |
        | someExistingAccounts.json   | someExistingAccounts.json   |
        | oneNoExistingAccount.json   | oneNoExistingAccount.json   |
        | someNoExistingAccounts.json | someNoExistingAccounts.json |

    @ErrorRequest
    Scenario Outline: Control de errores

    Como usuario quiero validar el control de errores del endpoint para validar el desarrollo del mismo

      When Se realiza una peticion "POST" erronea "<errorRequest>" al dominio "accounts" con el endpoint "/search"
      Then El servicio nos devuelve la respuesta con informacion del error correspondiente a "<errorRequest>"
      Examples:
        | errorRequest       |
        | Bad Request        |
        | Method Not Allowed |
