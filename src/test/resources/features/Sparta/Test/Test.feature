Feature: Test

  Como usuario quiero ejecutar los flujos de Sparta pertenecientes al dominio de Accounts, en el área de RAW y gobernando los datos para poder promociarlos al área de TRUSTED

  Background:
    Given Sparta operativo en la url "https://gts-sparta.sgcto-int.stratio.com/gts-sparta/appStatus"

    Scenario: Ejecución del workflow 'ot-ac-rw-accounts' con gobierno del dato
    El workflow recoge los datos de la tabla de Postgres 'onetradeaccounts.account', castea las columnas esperadas,
    añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/accounts/accounts_accounts'

      When Se ejecuta el workflow con Id "06012f6d-577c-46e3-b1fb-5c6d50f09abf"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Accounts_Accounts.account_id.PR.B.Completeness.PT.001                        | OK |
        | OT.RF.Accounts_Accounts.alias.PR.B.Completeness.PT.001                             | OK |
        | OT.RF.Accounts_Accounts.amount_available_balance.PR.B.Completeness.PT.001          | KO |
        | OT.RF.Accounts_Accounts.amount_main_balance.PR.B.Completeness.PT.001               | OK |
        | OT.RF.Accounts_Accounts.amount_overdraft_limit.PR.B.Completeness.PT.001            | KO |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_ac_rw_accounts" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/accounts_accounts"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_ac_rw_accounts" coincide con el resultado esperado en XDATA "GTS.QA_ACTUAL_ot_ac_rw_accounts"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_ac_rw_accounts"


    Scenario: Ejecución del workflow 'ot-ac-rw-accounts' con gobierno del dato negativo
    Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "06012f6d-577c-46e3-b1fb-5c6d50f09abf"
      Then Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Accounts_Accounts.account_id.PR.B.Completeness.PT.001                        | KO |
        | OT.RF.Accounts_Accounts.alias.PR.B.Completeness.PT.001                             | KO |
        | OT.RF.Accounts_Accounts.amount_available_balance.PR.B.Completeness.PT.001          | KO |
        | OT.RF.Accounts_Accounts.amount_main_balance.PR.B.Completeness.PT.001               | KO |
        | OT.RF.Accounts_Accounts.amount_overdraft_limit.PR.B.Completeness.PT.001            | KO |
        | OT.RF.Accounts_Accounts.amount_pending_balance.PR.B.Completeness.PT.001            | KO |
        | OT.RF.Accounts_Accounts.amount_withholding_balance.PR.B.Completeness.PT.001        | KO |
        | OT.RF.Accounts_Accounts.bic_description.PR.B.Completeness.PT.001                   | KO |
        | OT.RF.Accounts_Accounts.bic.PR.B.Completeness.PT.001                               | KO |
        | OT.RF.Accounts_Accounts.corporate_name.PR.B.Completeness.PT.001                    | KO |
        | OT.RF.Accounts_Accounts.country.PR.B.Completeness.PT.001                           | KO |
        | OT.RF.Accounts_Accounts.country.PR.B.Domain.PT.001                                 | KO |
        | OT.RF.Accounts_Accounts.currency_code_available_balance.PR.B.Completeness.PT.001   | KO |
        | OT.RF.Accounts_Accounts.currency_code_available_balance.PR.B.Domain.PT.001         | KO |
        | OT.RF.Accounts_Accounts.currency_code_main_balance.PR.B.Completeness.PT.001        | KO |
        | OT.RF.Accounts_Accounts.currency_code_main_balance.PR.B.Domain.PT.001              | KO |
        | OT.RF.Accounts_Accounts.currency_code_overdraft_limit.PR.B.Completeness.PT.001     | KO |
        | OT.RF.Accounts_Accounts.currency_code_overdraft_limit.PR.B.Domain.PT.001           | KO |
        | OT.RF.Accounts_Accounts.currency_code_pending_balance.PR.B.Completeness.PT.001     | KO |
        | OT.RF.Accounts_Accounts.currency_code_pending_balance.PR.B.Domain.PT.001           | KO |
        | OT.RF.Accounts_Accounts.currency_code_withholding_balance.PR.B.Completeness.PT.001 | KO |
        | OT.RF.Accounts_Accounts.currency_code_withholding_balance.PR.B.Domain.PT.001       | KO |
        | OT.RF.Accounts_Accounts.customer_id.PR.B.Completeness.PT.001                       | KO |
        | OT.RF.Accounts_Accounts.description.PR.B.Completeness.PT.001                       | KO |
        | OT.RF.Accounts_Accounts.display_number.PR.B.Completeness.PT.001                    | KO |
        | OT.RF.Accounts_Accounts.last_transaction_date.PR.B.Completeness.PT.001             | KO |
        | OT.RF.Accounts_Accounts.last_update_available_balance.PR.B.Completeness.PT.001     | KO |
        | OT.RF.Accounts_Accounts.last_update_main_balance.PR.B.Completeness.PT.001          | KO |
        | OT.RF.Accounts_Accounts.last_update_overdraft_limit.PR.B.Completeness.PT.001       | KO |
        | OT.RF.Accounts_Accounts.last_update_pending_balance.PR.B.Completeness.PT.001       | KO |
        | OT.RF.Accounts_Accounts.last_update_swift_payment.PR.B.Completeness.PT.001         | KO |
        | OT.RF.Accounts_Accounts.last_update_withholding_balance.PR.B.Completeness.PT.001   | KO |
        | OT.RF.Accounts_Accounts.status.PR.B.Completeness.PT.001                            | KO |
        | OT.RF.Accounts_Accounts.subsidiary_name.PR.B.Completeness.PT.001                   | KO |
        | OT.RF.Accounts_Accounts.type.PR.B.Completeness.PT.001                              | KO |
        | OT.RF.Accounts_Accounts.type.PR.B.Domain.PT.001                                    | KO |


  Scenario: Ejecución del workflow 'ot-ac-rw-accounts' con gobierno del dato
  El workflow recoge los datos de la tabla de Postgres 'onetradeaccounts.account', castea las columnas esperadas,
  añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/accounts/accounts_accounts'

    When Se ejecuta el workflow con Id "06012f6d-577c-46e3-b1fb-5c6d50f09abf"
    And  Se aplican las siguientes reglas de calidad con resultado
         | OT.RF.Accounts_Accounts.account_id.PR.B.Completeness.PT.001                        | OK |
    Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_ac_rw_accounts" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/accounts_accounts"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_ac_rw_accounts" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/accounts_accounts"
    And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_ac_rw_accounts" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot_ac_rw_accounts"
    Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_ac_rw_accounts"
    Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_ac_rw_accounts"


  Scenario: Ejecución del workflow 'rp-mr-rw-intralayer' para comprobar si la volumetria es correcta en la capa RAW

  El workflow compara los eventos ultimo y penultimo por producto procesados informando si se produce una discrepancia entre ambas medidas de volumetria RC.R.Mercury_Product.NA.PR.F.Volume.PT.001

    When Se crea en XDATA la tabla "GTS.QA_ACTUAL_rp_mr_rf_product" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/reporting/Mercury/Product"
    Then Se ejecuta el workflow con Id "263fe2a9-9a14-4032-ae62-99d70fa1ed50"
    And  Se crea en XDATA la tabla "GTS.QA_ACTUAL_rp_mr_rw_intralayer_volume" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/qr_results/reporting/volume/volume"
    Then Se comprueba el valor de validacion de la regla de volumetria "RC.T.Mercury_Transaction.NA.PR.F.Volume.PT.002" almacenado en la tabla de XDATA "GTS.QA_ACTUAL_rp_mr_rw_intralayer_volume"
    And  Se borra la tabla de XDATA "GTS.QA_ACTUAL_rp_mr_rw_intralayer_volume"
    And Se borra la tabla de XDATA "GTS.QA_ACTUAL_rp_mr_rf_product"



  Scenario: Ejecución del workflow 'rp-mr-tt-interlayer' sin gobierno del dato

  El workflow comprueba si hay variacion entre la volumetria RC.T.Mercury_Transaction.NA.PR.B.Volume.PT.001 registrada en RAW es y la progresada a TRUSTED
  El workflow cuenta los eventos registrados en la ultima carga de RAW con los eventos registrados en el area de TRUSTED calculando si hay variacion o no entre ellos.

    When Se crea en XDATA la tabla "GTS.QA_ACTUAL_rp_mr_rf_product" con la ruta hdfs "hdfs://gts-hdfs/gts/data/raw/formatted/reporting/Mercury/Product"
    When Se crea en XDATA la tabla "GTS.QA_ACTUAL_rp_mr_tt_transaction" con la ruta hdfs "hdfs://gts-hdfs/gts/data/trusted/reporting/Mercury/Transaction"
    Then Se ejecuta el workflow con Id "a9c8e5c5-2492-4e06-a272-15f4005147e3"
    And  Se crea en XDATA la tabla "GTS.QA_ACTUAL_rp_mr_tt_interlayer" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/qa/qr_results/reporting/volume/volume"
    Then Se comprueba el valor de validacion de la regla de volumetria "RC.T.Mercury_Transaction.NA.PR.B.Volume.PT.001" almacenado en la tabla de XDATA "GTS.QA_ACTUAL_rp_mr_tt_interlayer"
    And Se borra la tabla de XDATA "GTS.QA_ACTUAL_rp_mr_tt_interlayer"
    And Se borra la tabla de XDATA "GTS.QA_ACTUAL_rp_mr_rf_product"
    And Se borra la tabla de XDATA "GTS.QA_ACTUAL_rp_mr_tt_transaction"


 Scenario: Ejecución del workflow 'ot-et-rw-enterprise-country' con gobierno del dato

 El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.country', selecciona las columnas necesarias,
 añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_country'

   Then Se ejecuta el workflow con Id "06012f6d-577c-46e3-b1fb-5c6d50f09abf"

  @Alex_test
  Scenario: Ejecución del workflow 'ot-tr-rw-transaction' con gobierno del dato

  El workflow recoge los datos de la tabla de Postgres 'onetradetransactions.transaction', castea las columnas esperadas,
  añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/transactions/transaction'

    When Se ejecuta el workflow con Id y parametros
      |id        |e1ee2077-efbc-4aa2-882f-01b50a0ac2fd|
      |YYYY-MM-DD|2019-10-10|
    And  Se aplican las siguientes reglas de calidad con resultado
      | OT.RF.Transaction_Transaction.accounting_date.PR.B.Completeness.PT.001                     | OK |
      | OT.RF.Transaction_Transaction.creation_date.PR.B.Completeness.PT.001                       | OK |
      | OT.RF.Transaction_Transaction.processed_date.PR.B.Completeness.PT.001                      | OK |
      | OT.RF.Transaction_Transaction.swift_code.PR.B.Completeness.PT.001                          | OK |
      | OT.RF.Transaction_Transaction.transaction_amount_currency.PR.B.Completeness.PT.001         | OK |
      | OT.RF.Transaction_Transaction.transaction_balance_amount_currency.PR.B.Completeness.PT.001 | OK |
      | OT.RF.Transaction_Transaction.transaction_id.PR.B.Completeness.PT.001                      | OK |
    Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_tr_rw_transaction" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/transactions/transaction"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_tr_rw_transaction" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/transactions/transaction"
    And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_tr_rw_transaction" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot_tr_rw_transaction"
    Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_tr_rw_transaction"
    Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_tr_rw_transaction"