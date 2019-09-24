Feature: HU_003_Ingesta de la tabla tc_matches_opportunities en Trusted

  As Data Analyst I Want to ingest data table tc_matches_opportunities in the Trusted area So I will transform and validate the data table

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
        | Date_of_Match Format Check           |
        | Date_of_Outcome Format Check         |
        | Date of Outcome Implies Date of Match|
        | Granted is not null                  |
        | Match Type is not null               |
        | Only Granted OR Rejected             |
        | Rejected is not null                 |
        | Granted in 0/1                       |
        | Rejected in 0/1                      |


      Scenario: Volumetría y metadatado correcta
        When Se aplica la comparación de Volumetria y metadatado de la tabla "tc_matches_opportunities"
        Then La comparacion es correcta