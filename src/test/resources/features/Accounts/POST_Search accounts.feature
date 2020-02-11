@Manual
Feature: POST_Search accounts

  Como usuario quiero tener en el dominio de Accounts un endpoint para realizar distintas consultas de Cuentas mediante el par [AccountId, Pais] para poder ver el detalle de las mismas

  Background:
    Given El dominio de "Accounts" esta levantado

    Scenario Outline: Casuisticas de busquedas de cuentas

      Como usuario quiero realizar satisfactoriamente distintas casuísticas de búsqueda para validar que la respuesta es correcta

      When Se realiza un request "POST" con el body "/Accounts/Input/POST_Search_accounts/<jsonInputBody>"
      Then El servicio nos devuelve la respuesta "/Accounts/Output/POST_Search_accounts/<jsonOutputBody>"
      Examples:
        | jsonInputBody              | jsonOutputBody             |
        | oneExistingAccount.json    | oneExistingAccount.json    |
        | someExistingAccounts.json  | someExistingAccounts.json  |
        | oneNoExistingAccount.json  | oneNoExistingAccount.json  |
        | someNoExistingAccount.json | someNoExistingAccount.json |

    Scenario Outline: Control de errores

    Como usuario quiero validar el control de errores del endpoint para validar el desarrollo del mismo

      When Se realiza un request erronea "<errorRequest>"
      Then El servicio nos devuelve la respuesta "/errorResponse/<errorResponse>"
      Examples:
        | errorRequest       | errorResponse         |
        | Bad Request        | badRequest.json       |
        | Unauthorized       | unauthorized.json     |
        | Forbidden          | forbidden.json        |
        | Not found          | notFound.json         |
        | Method nor allowed | methodNotAllowed.json |


