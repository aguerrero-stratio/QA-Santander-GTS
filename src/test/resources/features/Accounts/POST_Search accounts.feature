@Manual
Feature: POST_Search accounts

  Como usuario quiero tener en el dominio de Accounts un endpoint para realizar distintas consultas de Cuentas mediante el par [AccountId, Pais] para poder ver el detalle de las mismas

  Background:
    Given El dominio de "Accounts" esta levantado

    Scenario Outline: Casuisticas de busquedas de cuentas

      Como usuario quiero realizar satisfactoriamente distintas casuísticas de búsqueda para validar que la respuesta es correcta

      When Se realiza un request "POST" con el body "<jsonInputBody>"
      Then El servicio nos devuelve la respuesta "<jsonOutputBody>"
      Examples:
        | jsonInputBody                                                   | jsonOutputBody                                                   |
        | /Accounts/Input/POST_Search_accounts/oneExistingAccount.json    | /Accounts/Output/POST_Search_accounts/oneExistingAccount.json    |
        | /Accounts/Input/POST_Search_accounts/someExistingAccounts.json  | /Accounts/Output/POST_Search_accounts/someExistingAccounts.json  |
        | /Accounts/Input/POST_Search_accounts/oneNoExistingAccount.json  | /Accounts/Output/POST_Search_accounts/oneNoExistingAccount.json  |
        | /Accounts/Input/POST_Search_accounts/someNoExistingAccount.json | /Accounts/Output/POST_Search_accounts/someNoExistingAccount.json |

      Scenario Outline: Control de errores

        Como usuario quiero validar el control de errores del endpoint para validar el desarrollo del mismo

        When Se realiza un request erronea "<errorRequest>"
        Then El servicio nos devuelve la respuesta "<errorResponse>"
        Examples:
          | errorRequest       | errorResponse                        |
          | Bad Request        | /errorResponse/badRequest.json       |
          | Unauthorized       | /errorResponse/unauthorized.json     |
          | Forbidden          | /errorResponse/forbidden.json        |
          | Not found          | /errorResponse/notFound.json         |
          | Method nor allowed | /errorResponse/methodNotAllowed.json |


