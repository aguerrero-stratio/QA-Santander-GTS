@Transaction
Feature: POST_Search transactions

  Como usuario final quiero poder consultar las transacciones para poder conocer los movimientos realizados en mis cuentas bancarias

  Background:
    Given El dominio de "transaction" esta levantado

  Scenario Outline: Casuisticas de busquedas de transacciones
    When Realizamos una peticion "POST" al endpoint Transaction con el body "/Transaction/Input/<jsonInputBody>"
    Then Nos devuelve la respuesta "/Transaction/Output/<jsonOutputBody>"
  Examples:
    | jsonInputBody                    | jsonOutputBody                 |
    | noneTransactions.json            | noneTransactions.json          |
    | oneTransaction.json              | oneTransaction.json            |
    | searchByAccountsCountries.json   | searchByAccountsCountries.json |
    | searchByAllFields.json           | searchByAllFields.json         |
    | searchByAmountCurrencies.json    | searchByAmountCurrencies.json  |
    | searchByAmountTypes.json         | searchByAmountTypes.json       |
    | searchByClientReference.json     | searchByClientReference.json   |
    | searchByDescription.json         | searchByDescription.json       |
    | searchBySwiftCodes.json          | searchBySwiftCodes.json        |
    | searchFromToAmount.json          | searchFromToAmount.json        |
    | searchFromToDate.json            | searchFromToDate.json          |
    | someTransactions.json            | someTransactions.json          |

  Scenario Outline: Control de errores

  Como usuario quiero validar el control de errores del endpoint para validar el desarrollo del mismo

    When Se realiza una request erronea "<errorRequest>"
    Then El servicio nos devuelve la respuesta "<errorResponse>"
    Examples:
      | errorRequest       | errorResponse                        |
      | Bad Request        | /errorResponse/badRequest.json       |
      | Unauthorized       | /errorResponse/unauthorized.json     |
      | Forbidden          | /errorResponse/forbidden.json        |
      | Not found          | /errorResponse/notFound.json         |
      | Method nor allowed | /errorResponse/methodNotAllowed.json |