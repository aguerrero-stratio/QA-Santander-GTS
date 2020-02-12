Feature: TRUSTED_Transactions

  Como usuario quiero ejecutar los flujos de Sparta pertenecientes al dominio de Transactions, en el área de TRUSTED y gobernando los datos para poder promociarlos desde el area de RAW rechazando los registros
  que no cumplen con los formatos establecidos.

  Background:
    Given Sparta operativo en la url "https://gts-sparta.sgcto-int.stratio.com/gts-sparta/swagger/appStatus"

    Scenario: Ejecución del workflow 'ot-tr-tt-transaction-company-account' sin gobierno del dato

    El workflow recoge los datos de RAW-HDFS, hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/transactions/transaction_company_account, durante el proceso se descartan los registros bic y pais que no cumplen
    con el formato establecido, añade el TS y vuelca los datos en la ruta de TRUSTED-HDFS hdfs://gts-hdfs/gts/data/trusted/formatted/onetrade/transactions/transaction_company_account

      When Se ejecuta el workflow con Id "8d89ba81-521c-4a33-b25d-c3bd1400943f"
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot-tr-tt-transaction-company-account" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/formatted/onetrade/transactions/transaction_company_account"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot-tr-tt-transaction-company-account" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot-tr-tt-transaction-company-account"
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot-tr-tt-transaction-company-account_transaction_country_refusals" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/formatted/onetrade/transactions/transaction_country_refusals"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot-tr-tt-transaction-company-account_transaction_country_refusals" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot-tr-tt-transaction-company-account_transaction_country_refusals"
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot-tr-tt-transaction-company-account_bics_refusals" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/formatted/onetrade/transactions/transaction_bic_refusals"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot-tr-tt-transaction-company-account_transaction_bics_refusals" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot-tr-tt-transaction-company-account_transaction_bics_refusals"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot-tr-tt-transaction-company-account"
      And  Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot-tr-tt-transaction-company-account_transaction_country_refusals"
      And  Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot-tr-tt-transaction-company-account_transaction_bics_refusals"

    @Manual
    Scenario: Ejecución del workflow 'ot-tr-tt-transaction' sin gobierno del dato
    El workflow recoge los datos de RAW-HDFS, hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/transactions/transaction, durante el proceso se descartan los registros de balance y
    cantidad que contengan el formato de moneda incorrecto, añade el TS y vuelca los datos en la ruta de TRUSTED-HDFS hdfs://gts-hdfs/gts/data/trusted/formatted/onetrade/transactions/transaction

      When Se ejecuta el workflow con Id "b3fd3ee2-2a25-49cf-aee7-6d1f5a0ae0d5"
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot-tr-tt-transaction" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/formatted/onetrade/transactions/transaction"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot-tr-tt-transaction" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot-tr-tt-transaction_transaction"
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot-tr-tt-transaction_transaction_amount_currency_refusals" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/formatted/onetrade/transactions/transaction_amount_currency_refusals"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot-tr-tt-transaction_transaction_amount_currency_refusals" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot-tr-tt-transaction_transaction_amount_currency_refusals"
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot-tr-tt-transaction_transaction_balance_amount_currency_refusals" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/formatted/onetrade/transactions/transaction_balance_amount_currency_refusals"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot-tr-tt-transaction_transaction_balance_amount_currency_refusals" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot-tr-tt-transaction_transaction_balance_amount_currency_refusals"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot-tr-tt-transaction"
      And  Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot-tr-tt-transaction_transaction_amount_currency_refusals"
      And  Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot-tr-tt-transaction_transaction_balance_amount_currency_refusals"