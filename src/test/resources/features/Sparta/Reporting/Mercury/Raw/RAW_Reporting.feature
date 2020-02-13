Feature: RAW_Mercury

  Como usuario quiero ejecutar flujos de Sparta pertenecientes a Mercury, para promocionarlos desde RAW al area de TRUSTED
  Como usuario quiero aplicar Gobierno del dato a los flujos de Sparta ejecutados.

  Background:
    Given Sparta operativo en la url "https://gts-sparta.sgcto-int.stratio.com/gts-sparta/swagger/appStatus"

  Scenario: Ejecución del workflow 'rp-mr-ru-unformatted' sin gobierno del dato

  El workflow recoge los ficheros de un origen y los copia a una carpeta destino RAW-unformatted para su posterior formateo

    When Se ejecuta el workflow con Id "397c0611-f071-4198-afc7-94648d5cd092"
    Then Se recogen los ficheros de la carpeta origen "hdfs://gts-hdfs/gts/data/sources/reporting/samples/"
    And  Se copian a una carpeta destino "hdfs://gts-hdfs/gts/data/raw/unformatted/reporting/Mercury/"
    Then Se comprueba que todos los ficheros de la "listadeficheros" han sido copiados en el destino "hdfs://gts-hdfs/gts/data/raw/unformatted/reporting/Mercury/"


  Scenario: Ejecución del workflow 'rp-mr-rf-product' con gobierno del dato

  El workflow procesa los ficheros almacenados en RAW-unformatted para que estos sean formateados,tratados y registrados en el area de  RAW-formatted.

    When Se ejecuta el workflow con Id "b3e3916d-078e-462a-9562-89b374244778"
    And  Se aplican las siguientes reglas de calidad con resultado
      | OK                                                      |
      | RC.RF.Mercury-Product.index.PR.B.Completness.PT.001     |
      | RC.RF.Mercury-Product.source_id.PR.B.Completness.MF.001 |
      | RC.RF.Mercury-Product.source.PR.B.Completness.MF.001    |
      | RC.RF.Mercury-Product.timed_out.PR.B.Completness.PT.001 |
      | RC.RF.Mercury-Product.total.PR.B.Completness.PT.001     |
      | RC.RF.Mercury-Product.ts.PR.B.Completness.PT.001        |
      | RC.RF.Mercury-Product.uid.PR.B.Completness.PT.001       |
    Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_rp-mr-rf-product" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/reporting/Mercury/Product"
    And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_rp-mr-rf-product" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_rp-mr-rf-product"
    Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_rp-mr-rf-product"


  Scenario: Ejecución del workflow 'rp-mr-rf-product' para comprobar si existen ficheros nuevos no registrados o no existen/nulos.

  El workflow comprueba al procesar los ficheros desde RAW-unformatted a RAW-formatted la presencia de nuevos ficheros o si algunos se encuentran vacios o no han sido remitidos.

    When Se ejecuta el workflow con Id "b3e3916d-078e-462a-9562-89b374244778"
    Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_rp-mr-rf-product_validation" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/reporting/Mercury/validation/Json_warning"
    And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_rp-mr-rf-product_validation" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_rp-mr-rf-product_validation"
    Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_rp-mr-rf-product_validation"


  Scenario: Ejecución del workflow 'rp-mr-rf-product' con gobierno del dato negativo

  Con un juego de datos de entrada que no cumplan las Quality Rules, validamos que el resultado de estas es 'KO'

    When Se ejecuta el workflow con Id "b3e3916d-078e-462a-9562-89b374244778"
    Then Se aplican las siguientes reglas de calidad con resultado
      | KO                                                      |
      | RC.RF.Mercury-Product.index.PR.B.Completness.PT.001     |
      | RC.RF.Mercury-Product.source_id.PR.B.Completness.MF.001 |
      | RC.RF.Mercury-Product.source.PR.B.Completness.MF.001    |
      | RC.RF.Mercury-Product.timed_out.PR.B.Completness.PT.001 |
      | RC.RF.Mercury-Product.total.PR.B.Completness.PT.001     |
      | RC.RF.Mercury-Product.ts.PR.B.Completness.PT.001        |
      | RC.RF.Mercury-Product.uid.PR.B.Completness.PT.001       |


  Scenario: Ejecución del workflow 'rp-mr-rw-intralayer' para comprobar si la volumetria es correcta en la capa RAW

  El workflow compara los eventos ultimo y penultimo por producto procesados informando si se produce una discrepancia entre ambas medidas de volumetria RC.R.Mercury_Product.NA.PR.F.Volume.PT.001

    When Se crea en XDATA la tabla "GTS.QA_ACTUAL_rp-mr-rf-product" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/reporting/Mercury/Product"
    Then Se ejecuta el workflow con Id "ea37cfce-67b7-415d-bc7a-745c2623bcce" seleccionando como input las tablas:
      | GTS.QA_ACTUAL_rp-mr-rf-product |
    And  Se crea en XDATA la tabla "GTS.QA_ACTUAL_rp-mr-rw-intralayer_volume" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/qr_results/reporting/volume/volume"
    Then Se comprueba el "valor de validacion" del ultimo resultado almacenado en la tabla de XDATA "GTS.QA_ACTUAL_rp-mr-rw-intralayer_volume"
    And  Se borra la tabla de XDATA "GTS.QA_ACTUAL_rp-mr-rw-intralayer_volume"