Feature: HU_002_Ingesta de la tabla tc_matches_opportunities en Landing

  As Data Analyst I Want to ingest data table tc_matches_opportunities in the Landing area So I will transform and validate the data table

  Background:
    Given Sparta esta operativo

  Scenario: Ejecución del workflow de ingesta correcta
    When El workflow con nombre "strNombre" se ejecuta
    Then El resultado del workflow es "Stopped"

    Scenario Outline: Quality rule correcta
      When Se aplica la QR "<Quality Rule>"
      Then La QR funciona correctamente
      Examples:
        | Quality Rule                         |
        | Company A is not null                |
        | Company_B is not null                |
        | Correct Match Type                   |
        | Date_of_Outcome Format Check         |
        | Granted is not null                  |
        | Match Type is not null               |
        | Only Granted OR Rejected             |
        | Rejected is not null                 |
        | Granted in 0/1                       |
        | Rejected in 0/1                      |

      Scenario: Volumetría y metadatado correcta
        When Se aplica la comparación de Volumetria y metadatado de la tabla "tc_matches_opportunities"
        Then La comparacion es correcta