Feature: GET_Enterprise

  Como usuario final quiero poder consultar una empresa para poder conocer los datos de la misma registrados en el sistema

  Background:
    Given El dominio de "Enterpise" esta levantado

  Scenario Outline: Casuisticas de busquedas de empresas
    When Realizamos una peticion "GET" al endpoint Enterprise con "<companyGlobalId>"
    Then Nos devuelve la respuesta "/Enterprise/Output/<jsonOutputBody>"
  Examples:
    | companyGlobalId   | jsonOutputBody      |
    | XXX               | oneEnterprise.json  |
    | 1                 | noneEnterprise.json  |

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