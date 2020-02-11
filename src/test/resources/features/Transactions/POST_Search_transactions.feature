@Transaction
Feature: POST_Search transactions

  Como usuario final quiero poder consultar las transacciones para poder conocer los movimientos realizados en mis cuentas bancarias

  Background:
    Given El dominio de "transactions" esta levantado

  Scenario Outline: Casuisticas de busquedas de transacciones

    Como usuario quiero realizar distintas casuísticas del endpoint para que me devuelva la respuesta esperada

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

  @Ignore
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

