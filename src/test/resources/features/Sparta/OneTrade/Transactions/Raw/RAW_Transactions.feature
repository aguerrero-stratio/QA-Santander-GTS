Feature: RAW_Transactions

  Como usuario quiero ejecutar los flujos de Sparta pertenecientes al dominio de Transactions, en el área de RAW y gobernando los datos para poder promociarlos al área de TRUSTED

  Background:
    Given Sparta esta operativo

    Scenario Outline: Ejecución del workflow 'ot-tr-rw-company-account' con gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradetransactions.transaction_company_account', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/transactions/transaction_company_account'

      When Se ejecuta el workflow con Id "3ed1aa38-2c52-4cb3-825a-5c23d3c72e82"
      And  Se aplican las reglas de calidad "<qrName>"
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot-tr-rw-company-account" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/transactions/transaction_company_account"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot-tr-rw-company-account" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot-tr-rw-company-account"
      And  Se comprueba que el resultado de las QR es 'OK'
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot-tr-rw-company-account"
      Examples:
        | qrName                                                                                 |
        | OT.RF.Transaction_TransactionCompanyAccount.account_id.PR.B.Completeness.PT.001        |
        | OT.RF.Transaction_TransactionCompanyAccount.agent.PR.B.Completeness.PT.001             |
        | OT.RF.Transaction_TransactionCompanyAccount.alias.PR.B.Completeness.PT.001             |
        | OT.RF.Transaction_TransactionCompanyAccount.company_global_id.PR.B.Completeness.PT.001 |
        | OT.RF.Transaction_TransactionCompanyAccount.country.PR.B.Completeness.PT.001           |
        | OT.RF.Transaction_TransactionCompanyAccount.display_number.PR.B.Completeness.PT.001    |

    @Manual
    Scenario Outline: Ejecución del workflow 'ot-tr-rw-company-account' con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

        When Se introduce un juego de datos que no cumplan las QR
        Then Se ejecuta el workflow con Id "3ed1aa38-2c52-4cb3-825a-5c23d3c72e82"
        And  Se aplican las reglas de calidad "<qrName>"
        And  Se comprueba que el resultado de las QR es 'KO'
        Examples:
          | qrName                                                                                 |
          | OT.RF.Transaction_TransactionCompanyAccount.account_id.PR.B.Completeness.PT.001        |
          | OT.RF.Transaction_TransactionCompanyAccount.agent.PR.B.Completeness.PT.001             |
          | OT.RF.Transaction_TransactionCompanyAccount.alias.PR.B.Completeness.PT.001             |
          | OT.RF.Transaction_TransactionCompanyAccount.company_global_id.PR.B.Completeness.PT.001 |
          | OT.RF.Transaction_TransactionCompanyAccount.country.PR.B.Completeness.PT.001           |
          | OT.RF.Transaction_TransactionCompanyAccount.display_number.PR.B.Completeness.PT.001    |

    Scenario Outline: Ejecución del workflow 'ot-tr-rw-transaction' con gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradetransactions.transaction', castea las columnas esperadas,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/transactions/transaction'

        When Se ejecuta el workflow con Id "e1ee2077-efbc-4aa2-882f-01b50a0ac2fd"
        And  Se aplican las reglas de calidad "<qrName>"
        Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot-tr-rw-transaction" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/transactions/transaction"
        And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot-tr-rw-transaction" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot-tr-rw-transaction"
        And  Se comprueba que el resultado de las QR es 'OK'
        Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot-tr-rw-transaction"
        Examples:
          | qrName                                                                                     |
          | OT.RF.Transaction_Transaction.accounting_date.PR.B.Completeness.PT.001                     |
          | OT.RF.Transaction_Transaction.creation_date.PR.B.Completeness.PT.001                       |
          | OT.RF.Transaction_Transaction.processed_date.PR.B.Completeness.PT.001                      |
          | OT.RF.Transaction_Transaction.swift_code.PR.B.Completeness.PT.001                          |
          | OT.RF.Transaction_Transaction.transaction_amount_currency.PR.B.Completeness.PT.001         |
          | OT.RF.Transaction_Transaction.transaction_balance_amount_currency.PR.B.Completeness.PT.001 |
          | OT.RF.Transaction_Transaction.transaction_id.PR.B.Completeness.PT.001                      |

  @Manual
    Scenario Outline: Ejecución del workflow 'ot-tr-rw-transaction' con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

        When Se introduce un juego de datos que no cumplan las QR
        Then Se ejecuta el workflow con Id "e1ee2077-efbc-4aa2-882f-01b50a0ac2fd"
        And  Se aplican las reglas de calidad "<qrName>"
        And  Se comprueba que el resultado de las QR es 'KO'
        Examples:
          | qrName                                                                                     |
          | OT.RF.Transaction_Transaction.accounting_date.PR.B.Completeness.PT.001                     |
          | OT.RF.Transaction_Transaction.creation_date.PR.B.Completeness.PT.001                       |
          | OT.RF.Transaction_Transaction.processed_date.PR.B.Completeness.PT.001                      |
          | OT.RF.Transaction_Transaction.swift_code.PR.B.Completeness.PT.001                          |
          | OT.RF.Transaction_Transaction.transaction_amount_currency.PR.B.Completeness.PT.001         |
          | OT.RF.Transaction_Transaction.transaction_balance_amount_currency.PR.B.Completeness.PT.001 |
          | OT.RF.Transaction_Transaction.transaction_id.PR.B.Completeness.PT.001                      |
