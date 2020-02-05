@Migracion
Feature: Validación migración

  Scenario: Workflow de QA
    Given Ejecutamos el workflow "94e3ab9b-281b-4aaa-b2ae-a78de32d0a3c"
    Given Ejecutamos el workflow "61a36032-62f7-493b-9d9f-12384661f06e" con parametro NAME "TABLA" y VALUE "onetradeaccounts.company_member"
    And Creamos la tabla en crossdata "GTS_ONETRADE.QAAutomatizacion" del workflow con la ruta de parquet "/gts/qa/automatizacionQA/automatizacionQA"
    And Creamos la tabla en crossdata "GTS_ONETRADE.QAAutomatizacion2" del workflow con la ruta de parquet "/gts/qa/automatizacionQA/automatizacionQA2"
    Given Obtenemos el output del workflow actual "GTS_ONETRADE.QAAutomatizacion"
    Given Obtenemos el output del workflow esperado "GTS_ONETRADE.QAAutomatizacion2"
    Then Comparamos ambos y el resultado coincide








