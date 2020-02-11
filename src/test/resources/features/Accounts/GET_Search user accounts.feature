@Manual
Feature: GET_Search user accounts

  Como usuario quiero tener en el dominio de Accounts un endpoint para realizar la consulta de las Cuentas asociadas a un Usuario mediante el parámetros de 'User global id' para poder ver el detalle de las mismas

  Background:
    Given El dominio de "accounts" esta levantado

    Scenario Outline: Casuisticas de busqueda de cuentas de usuarios

      Como usuario quiero realizar satisfactoriamente distintas casuísticas de búsqueda para validar que la respuesta es correcta

      When Se realiza un request "GET" con el parametro "/Accounts/Output/GET_Search_user_accounts/<userGlobalId>"
      Then El servicio nos devuelve la respuesta "<jsonOutputBody>"
      Examples:
        | userGlobalId | jsonOutputBody            |
        | 0006         | userWithOneAccount.json   |
        | 0001         | userWithSomeAccounts.json |
        | 0002         | userWithNoAccount.json    |
        | 0003         | userNoBBDD.json           |

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


