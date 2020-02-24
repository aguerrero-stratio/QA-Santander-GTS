@Enterprise
Feature: GET_Enterprise

  Como usuario final quiero poder consultar una empresa para poder conocer los datos de la misma registrados en el sistema

  Background:
    Given El dominio de enterprises esta levantado

  Scenario Outline: Casuisticas de busquedas de empresas

    Como usuario quiero realizar distintas casuísticas del endpoint para que me devuelva la respuesta esperada

    When Realizamos una peticion "GET" al endpoint Enterprise con "<companyGlobalId>"
    Then Nos devuelve la respuesta "/Enterprise/Output/<jsonOutputBody>"
  Examples:
    | companyGlobalId   | jsonOutputBody      |
    | XXX               | oneEnterprise.json  |

  Scenario Outline: Casuisticas de busquedas de empresas erroneo

  Como usuario quiero realizar distintas casuísticas del endpoint para que me devuelva la respuesta esperada

    When Realizamos una peticion "GET" al endpoint Enterprise con "<companyGlobalId>" invalido
    Then Nos devuelve la respuesta "/Enterprise/Output/<jsonOutputBody>"
    Examples:
      | companyGlobalId   | jsonOutputBody      |
      | 1                 | noneEnterprise.json  |

  @ErrorRequest
  Scenario Outline: Control de errores

  Como usuario quiero validar el control de errores del endpoint para validar el desarrollo del mismo

    When Se realiza una peticion "GET" erronea "<errorRequest>" al dominio "enterprise" con el endpoint "/enterprise"
    Then El servicio nos devuelve la respuesta con informacion del error correspondiente a "<errorRequest>"
    Examples:
      | errorRequest       |
      | Bad Request        |
      | Method Not Allowed |