@CICD
Feature: HU_001_Validacion workflow QA

  As QA I Want to validate the workflow dummie So I do my work

  Scenario: Ejecución del workflow de QA correcto
    When El workflow con nombre "c1a1a30e-c15a-4c12-8acf-3cb641904d6d" se ejecuta
    Then El resultado del workflow "c1a1a30e-c15a-4c12-8acf-3cb641904d6d" es "Finished"

  Scenario Outline: Quality rule correcta
    When Se aplica la QR "<Quality Rule>"
    Then La QR "<Quality Rule>" funciona correctamente
    Examples:
      | Quality Rule                                   |
      | c1a1a30e-c15a-4c12-8acf-3cb641904d6d           |
