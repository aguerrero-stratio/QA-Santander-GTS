Feature: HU_003_Ingesta de la tabla tp_interests_hscode en Trusted

  As Data Analyst I Want to ingest data table tp_interests_hscode in the Trusted area So I will transform and validate the data table

  Background:
    Given Sparta esta operativo

  Scenario: Ejecución del workflow de ingesta correcta
    When El workflow con nombre "strNombre" se ejecuta
    Then El resultado del workflow es "Stopped"

    Scenario Outline: Quality rule correcta
      When Se aplica la QR "<Quality Rule>"
      Then La QR funciona correctamente
      Examples:
        | Quality Rule           |
        | Company_ID is not null |
        | Numero_HS is not null  |
        | Tracked_At Format Check|
        | Tracked_At is not null |

      Scenario: Volumetría y metadatado correcta
        When Se aplica la comparación de Volumetria y metadatado de la tabla "tp_interests_hscode"
        Then La comparacion es correcta