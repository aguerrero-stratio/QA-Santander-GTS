Feature: HU_003_Ingesta de la tabla tc-company-registration en Trusted

  As Data Analyst I Want to ingest data table tc-company-registration in the Trusted area So I will transform and validate the data table

  Background:
    Given Sparta esta operativo

  Scenario: Ejecución del workflow de ingesta correcta
    When El workflow con nombre "strNombre" se ejecuta
    Then El resultado del workflow es "Stopped"

    Scenario Outline: Quality rule correcta
      When Se aplica la QR "<Quality Rule>"
      Then La QR funciona correctamente
      Examples:
        | Quality Rule                                     |
        | Company_ID or Company_VAT not null               |
        | Country_ISO is Upper Case and Appropriate Length |
        | Country_ISO is not 0                             |
        | Country_ISO is not NA                            |
        | Country_ISO is not null                          |

      Scenario: Volumetría y metadatado correcta
        When Se aplica la comparación de Volumetria y metadatado de la tabla "tc-company-registration"
        Then La comparacion es correcta