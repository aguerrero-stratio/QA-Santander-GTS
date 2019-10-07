Feature: HU_001_Preparacion entorno de pruebas QA

  As QA I want start with the QA Framework So I will test

  Scenario Outline: Sparta esta disponible
    Given Sparta esta operativo
    And La autentificacion con la plataforma es correcta
    When Realizamos llamadas a "<endpoint>"

    Examples:
      |endpoint  |
      |appStatus |
