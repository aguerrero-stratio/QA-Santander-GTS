Feature: TRUSTED_Mercury

  Como usuario quiero ejecutar flujos de Sparta pertenecientes a Mercury en el area de TRUSTED
  Como usuario quiero aplicar Gobierno del dato a los flujos de Sparta ejecutados.

  Background:
    Given Sparta operativo en la url "https://gts-sparta.sgcto-int.stratio.com/gts-sparta/appStatus"

  @sparta_reporting_mercury_trusted
  Scenario: Ejecución del workflow 'rp-mr-tt-transaction' sin gobierno del dato

    El workflow recoge los datos almacenados en RAW formatted, los castea en campos correctos y los progresa al area de TRUSTED

    When Se ejecuta el workflow con Id "06a3d2f9-982f-4766-892c-528366b26e10"
    Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_rp_mr_tt_transaction" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/reporting/Mercury/Transaction"
    And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_rp_mr_tt_transaction" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_rp_mr_tt_transaction"
    Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_rp_mr_tt_transaction"

  @sparta_reporting_mercury_trusted
  Scenario: Ejecución del workflow 'rp-mr-tt-interlayer' sin gobierno del dato

    El workflow comprueba si hay variacion entre la volumetria RC.T.Mercury_Transaction.NA.PR.B.Volume.PT.001 registrada en RAW es y la progresada a TRUSTED
    El workflow cuenta los eventos registrados en la ultima carga de RAW con los eventos registrados en el area de TRUSTED calculando si hay variacion o no entre ellos.

    When Se crea en XDATA la tabla "GTS.QA_ACTUAL_rp_mr_rf_product" con la ruta hdfs "hdfs://gts-hdfs/gts/data/raw/formatted/reporting/Mercury/Product"
    When Se crea en XDATA la tabla "GTS.QA_ACTUAL_rp_mr_tt_transaction" con la ruta hdfs "hdfs://gts-hdfs/gts/data/trusted/reporting/Mercury/Transaction"
    Then Se ejecuta el workflow con Id "a9c8e5c5-2492-4e06-a272-15f4005147e3"
    And  Se crea en XDATA la tabla "GTS.QA_ACTUAL_rp_mr_tt_interlayer" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/qr_results/reporting/volume/volume"
    Then Se comprueba el valor de validacion de la regla de volumetria "RC.T.Mercury_Transaction.NA.PR.B.Volume.PT.001" almacenado en la tabla de XDATA "GTS.QA_ACTUAL_rp_mr_tt_interlayer"
    And Se borra la tabla de XDATA "GTS.QA_ACTUAL_rp_mr_tt_interlayer"
    And Se borra la tabla de XDATA "GTS.QA_ACTUAL_rp_mr_rf_product"
    And Se borra la tabla de XDATA "GTS.QA_ACTUAL_rp_mr_tt_transaction"

  @sparta_reporting_mercury_trusted
  Scenario: Ejecución del workflow 'rp-mr-tt-intralayer' para comprobar si la volumetria es correcta en la capa TRUSTED

    El workflow compara los eventos ultimo y penultimo por producto procesados informando si se produce una discrepancia entre ambas medidas de volumetria RC.T.Mercury_Transaction.NA.PR.F.Volume.PT.002

    When Se crea en XDATA la tabla "GTS.QA_ACTUAL_rp_mr_tt_transaction" con la ruta hdfs "hdfs://gts-hdfs/gts/data/trusted/reporting/Mercury/Transaction"
    Then Se ejecuta el workflow con Id "a60074cd-4b30-4c3d-9af2-9687979fd147"
    And  Se crea en XDATA la tabla "GTS.QA_ACTUAL_rp_mr_tt_intralayer_volume" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/qr_results/reporting/volume/volume"
    Then Se comprueba el valor de validacion de la regla de volumetria "RC.T.Mercury_Transaction.NA.PR.F.Volume.PT.002" almacenado en la tabla de XDATA "GTS.QA_ACTUAL_rp_mr_tt_intralayer_volume"
    And  Se borra la tabla de XDATA "GTS.QA_ACTUAL_rp_mr_tt_intralayer"
    And  Se borra la tabla de XDATA "GTS.QA_ACTUAL_rp_mr_tt_transaction"

  @sparta_reporting_mercury_trusted
  Scenario: Ejecución del workflow 'rp-mr-tt-new-fields' para detectar la inclusion de nuevos campos en los registros progresados entre las capas de RAW y TRUSTED

    El workflow compara los registros entre las capas de RAW y TRUSTED para descubrir si hay nuevos campos en los registros procesados

    When Se crea en XDATA la tabla "GTS.QA_ACTUAL_rp_mr_rf_product" con la ruta hdfs "hdfs://gts-hdfs/gts/data/raw/formatted/reporting/Mercury/Product"
    When Se crea en XDATA la tabla "GTS.QA_ACTUAL_rp_mr_tt_transaction" con la ruta hdfs "hdfs://gts-hdfs/gts/data/trusted/reporting/Mercury/Transaction"
    Then Se ejecuta el workflow con Id "4d0af59f-0a21-4c56-8aa0-53d7561e8c7b"
    And  Se crea en XDATA la tabla "GTS.QA_ACTUAL_rp_mr_tt_new_fields" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/reporting/Mercury/validation/New_fields"
    And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_rp_mr_tt_new_fields" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_rp_mr_tt_new_fields"
    Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_rp_mr_rf_product"
    Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_rp_mr_tt_transaction"
    Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_rp_mr_tt_new_fields"