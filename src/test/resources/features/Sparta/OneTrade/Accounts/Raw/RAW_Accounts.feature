Feature: RAW_Accounts

  Como usuario quiero ejecutar los flujos de Sparta pertenecientes al dominio de Accounts, en el área de RAW y gobernando los datos para poder promociarlos al área de TRUSTED

  Background:
    Given Sparta esta operativo

    Scenario: Ejecución del workflow 'ot-ac-rw-accounts' con gobierno del dato
    El workflow recoge los datos de la tabla de Postgres 'onetradeaccounts.account', castea las columnas esperadas,
    añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/accounts_accounts'

      When Se ejecuta el workflow con Id "06012f6d-577c-46e3-b1fb-5c6d50f09abf"
      And  Se aplican las reglas de calidad "OT.RF.Accounts_Accounts.type.PR.B.Domain.PT.001/OT.RF.Accounts_Accounts.display_number.PR.B.Completeness.PT.001/OT.RF.Accounts_Accounts.type.PR.B.Completeness.PT.001" y el resultado es "OK"
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot-ac-rw-accounts" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/accounts_accounts"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot-ac-rw-accounts" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot-ac-rw-accounts"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot-ac-rw-accounts"


      @Manual
    Scenario Outline: Ejecución del workflow 'ot-ac-rw-accounts' con gobierno del dato negativo
    Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se introduce un juego de datos que no cumplan las QR
      Then Se ejecuta el workflow con Id "06012f6d-577c-46e3-b1fb-5c6d50f09abf"
      And  Se aplican las reglas de calidad "<qrName>"
      And  Se comprueba que el resultado de las QR es 'KO'
      Examples:
        | qrName                                                          |
        | OT.RF.Accounts_Accounts.type.PR.B.Domain.PT.001                 |
        | OT.RF.Accounts_Accounts.display_number.PR.B.Completeness.PT.001 |
        | OT.RF.Accounts_Accounts.type.PR.B.Completeness.PT.001           |


    Scenario: Ejecución del workflow 'ot-ac-rw-accounts' sin gobierno del dato
    El workflow recoge los datos de la tabla de Postgres 'onetradeaccounts.account', castea las columnas esperadas,
    añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/accounts_accounts'

      When Se ejecuta el workflow con Id "06012f6d-577c-46e3-b1fb-5c6d50f09abf"
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot-ac-rw-accounts" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/accounts_accounts"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot-ac-rw-accounts" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot-ac-rw-accounts"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot-ac-rw-accounts"


    Scenario Outline: Ejecución del workflow 'ot-ac-rw-company-member' con gobierno del dato
    El workflow recoge los datos de la tabla de Postgres 'onetradeaccounts.company_member', castea las columnas esperadas,
    añade el TS y almacena los datos en la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/accounts_company_member'

      When Se ejecuta el workflow con Id "6f9ab168-22d4-4b5c-b73f-d531b71ae20b"
      And  Se aplican las reglas de calidad "<qrName>"
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot-ac-rw-company-member" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/accounts_company_member"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot-ac-rw-company-member" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot-ac-rw-company-member"
      And  Se comprueba que el resultado de las QR es 'OK'
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot-ac-rw-company-member"
      Examples:
        | qrName                                                                   |
        | OT.RF.Accounts_Company_Member.company_id.PR.B.Completeness.PT.001        |
        | OT.RF.Accounts_Company_Member.company_member_id.PR.B.Completeness.PT.001 |
        | OT.RF.Accounts_Company_Member.role_id.PR.B.Completeness.PT.001           |


    @Manual
    Scenario Outline: Ejecución del workflow 'ot-ac-rw-company-member' con gobierno del dato negativo
    Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se introduce un juego de datos que no cumplan las QR
      Then Se ejecuta el workflow con Id "6f9ab168-22d4-4b5c-b73f-d531b71ae20b"
      And  Se aplican las reglas de calidad "<qrName>"
      And  Se comprueba que el resultado de las QR es 'KO'
      Examples:
        | qrName                                                                   |
        | OT.RF.Accounts_Company_Member.company_id.PR.B.Completeness.PT.001        |
        | OT.RF.Accounts_Company_Member.company_member_id.PR.B.Completeness.PT.001 |
        | OT.RF.Accounts_Company_Member.role_id.PR.B.Completeness.PT.001           |


    Scenario Outline: Ejecución del workflow 'ot-ac-rw-company-member-account' con gobierno del dato
    El workflow recoge los datos de la tabla de Postgres 'onetradeaccounts.company_member_account', castea las columnas esperadas,
    añade el TS y almacena los datos en la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/accounts_company_member_account'

      When Se ejecuta el workflow con Id "c687c329-bcf1-441d-94be-20c68bd24e4c"
      And  Se aplican las reglas de calidad "<qrName>"
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot-ac-rw-company-member-account" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/accounts_company_member_account"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot-ac-rw-company-member-account" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot-ac-rw-company-member-account"
      And  Se comprueba que el resultado de las QR es 'OK'
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot-ac-rw-company-member-account"
      Examples:
        | qrName                                                                                  |
        | OT.RF.Accounts_Company_Member_Account.account_country_id.PR.B.Completeness.PT.001       |
        | OT.RF.Accounts_Company_Member_Account.company_member_account_id.PR.B.Completeness.PT.001|
        | OT.RF.Accounts_Company_Member_Account.company_member_id.PR.B.Completeness.PT.001        |


    @Manual
    Scenario Outline: Ejecución del workflow 'ot-ac-rw-company-member-account' con gobierno del dato negativo
    Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se introduce un juego de datos que no cumplan las QR
      Then Se ejecuta el workflow con Id "c687c329-bcf1-441d-94be-20c68bd24e4c"
      And  Se aplican las reglas de calidad "<qrName>"
      And  Se comprueba que el resultado de las QR es 'KO'
      Examples:
        | qrName                                                                                  |
        | OT.RF.Accounts_Company_Member_Account.account_country_id.PR.B.Completeness.PT.001       |
        | OT.RF.Accounts_Company_Member_Account.company_member_account_id.PR.B.Completeness.PT.001|
        | OT.RF.Accounts_Company_Member_Account.company_member_id.PR.B.Completeness.PT.001        |
