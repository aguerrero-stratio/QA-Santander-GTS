Feature: RAW_Accounts

  Como usuario quiero ejecutar los flujos de Sparta pertenecientes al dominio de Accounts, en el área de RAW y gobernando los datos para poder promociarlos al área de TRUSTED

  Background:
    Given Sparta operativo en la url "https://gts-sparta.sgcto-int.stratio.com/gts-sparta/appStatus"

    @sparta_accounts_raw
    Scenario: Ejecución del workflow 'ot-ac-rw-accounts' sin gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeaccounts.account', castea las columnas esperadas,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/accounts_accounts'

      When Se ejecuta el workflow con Id "06012f6d-577c-46e3-b1fb-5c6d50f09abf"
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_ac_rw_accounts" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/accounts_accounts"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_ac_rw_accounts" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot_ac_rw_accounts"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_ac_rw_accounts"

    @sparta_accounts_raw_qrules_ok
    Scenario: Ejecución del workflow 'ot-ac-rw-accounts' con gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeaccounts.account', castea las columnas esperadas,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/accounts_accounts'

      When Se ejecuta el workflow con Id "06012f6d-577c-46e3-b1fb-5c6d50f09abf"
      Then Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Accounts_Accounts.last_update_main_balance.PR.B.Completeness.PT.001			  | OK |
        | OT.RF.Accounts_Accounts.currency_code_available_balance.PR.B.Domain.PT.001          | OK |
        | OT.RF.Accounts_Accounts.currency_code_overdraft_limit.PR.B.Completeness.PT.001      | OK |
        | OT.RF.Accounts_Accounts.currency_code_pending_balance.PR.B.Completeness.PT.001      | OK |
        | OT.RF.Accounts_Accounts.amount_overdraft_limit.PR.B.Completeness.PT.001             | OK |
        | OT.RF.Accounts_Accounts.last_update_pending_balance.PR.B.Completeness.PT.001        | OK |
        | OT.RF.Accounts_Accounts.last_update_overdraft_limit.PR.B.Completeness.PT.001        | OK |
        | OT.RF.Accounts_Accounts.bic.PR.B.Completeness.PT.001                                | OK |
        | OT.RF.Accounts_Accounts.country.PR.B.Domain.PT.001                                  | OK |
        | OT.RF.Accounts_Accounts.country.PR.B.Completeness.PT.001                            | OK |
        | OT.RF.Accounts_Accounts.alias.PR.B.Completeness.PT.001                              | OK |
        | OT.RF.Accounts_Accounts.account_id.PR.B.Completeness.PT.001                         | OK |
        | OT.RF.Accounts_Accounts.type.PR.B.Completeness.PT.001                               | OK |
        | OT.RF.Accounts_Accounts.last_transaction_date.PR.B.Completeness.PT.001              | OK |
        | OT.RF.Accounts_Accounts.currency_code_main_balance.PR.B.Domain.PT.001               | OK |
        | OT.RF.Accounts_Accounts.description.PR.B.Completeness.PT.001                        | OK |
        | OT.RF.Accounts_Accounts.amount_main_balance.PR.B.Completeness.PT.001                | OK |
        | OT.RF.Accounts_Accounts.currency_code_main_balance.PR.B.Completeness.PT.001         | OK |
        | OT.RF.Accounts_Accounts.amount_withholding_balance.PR.B.Completeness.PT.001         | OK |
        | OT.RF.Accounts_Accounts.currency_code_pending_balance.PR.B.Domain.PT.001            | OK |
        | OT.RF.Accounts_Accounts.amount_available_balance.PR.B.Completeness.PT.001           | OK |
        | OT.RF.Accounts_Accounts.currency_code_available_balance.PR.B.Completeness.PT.001    | OK |
        | OT.RF.Accounts_Accounts.currency_code_withholding_balance.PR.B.Completeness.PT.001  | OK |
        | OT.RF.Accounts_Accounts.currency_code_overdraft_limit.PR.B.Domain.PT.001            | OK |
        | OT.RF.Accounts_Accounts.amount_pending_balance.PR.B.Completeness.PT.001             | OK |
        | OT.RF.Accounts_Accounts.bic_description.PR.B.Completeness.PT.001                    | OK |
        | OT.RF.Accounts_Accounts.corporate_name.PR.B.Completeness.PT.001                     | OK |
        | OT.RF.Accounts_Accounts.subsidiary_name.PR.B.Completeness.PT.001                    | OK |
        | OT.RF.Accounts_Accounts.display_number.PR.B.Completeness.PT.001                     | OK |
        | OT.RF.Accounts_Accounts.last_update_available_balance.PR.B.Completeness.PT.001      | OK |
        | OT.RF.Accounts_Accounts.last_update_withholding_balance.PR.B.Completeness.PT.001    | OK |
        | OT.RF.Accounts_Accounts.currency_code_withholding_balance.PR.B.Domain.PT.001        | OK |
        | OT.RF.Accounts_Accounts.last_update_swift_payment.PR.B.Completeness.PT.001          | OK |
        | OT.RF.Accounts_Accounts.type.PR.B.Domain.PT.001                                     | OK |
        | OT.RF.Accounts_Accounts.status.PR.B.Completeness.PT.001                             | OK |
        | OT.RF.Accounts_Accounts.customer_id.PR.B.Completeness.PT.001                        | OK |

    @sparta_accounts_raw_qrules_ko
    Scenario: Ejecución del workflow 'ot-ac-rw-accounts' con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "06012f6d-577c-46e3-b1fb-5c6d50f09abf"
      Then Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Accounts_Accounts.last_update_main_balance.PR.B.Completeness.PT.001			  | KO |
        | OT.RF.Accounts_Accounts.currency_code_available_balance.PR.B.Domain.PT.001          | KO |
        | OT.RF.Accounts_Accounts.currency_code_overdraft_limit.PR.B.Completeness.PT.001      | KO |
        | OT.RF.Accounts_Accounts.currency_code_pending_balance.PR.B.Completeness.PT.001      | KO |
        | OT.RF.Accounts_Accounts.amount_overdraft_limit.PR.B.Completeness.PT.001             | KO |
        | OT.RF.Accounts_Accounts.last_update_pending_balance.PR.B.Completeness.PT.001        | KO |
        | OT.RF.Accounts_Accounts.last_update_overdraft_limit.PR.B.Completeness.PT.001        | KO |
        | OT.RF.Accounts_Accounts.bic.PR.B.Completeness.PT.001                                | KO |
        | OT.RF.Accounts_Accounts.country.PR.B.Domain.PT.001                                  | KO |
        | OT.RF.Accounts_Accounts.country.PR.B.Completeness.PT.001                            | KO |
        | OT.RF.Accounts_Accounts.alias.PR.B.Completeness.PT.001                              | KO |
        | OT.RF.Accounts_Accounts.account_id.PR.B.Completeness.PT.001                         | KO |
        | OT.RF.Accounts_Accounts.type.PR.B.Completeness.PT.001                               | KO |
        | OT.RF.Accounts_Accounts.last_transaction_date.PR.B.Completeness.PT.001              | KO |
        | OT.RF.Accounts_Accounts.currency_code_main_balance.PR.B.Domain.PT.001               | KO |
        | OT.RF.Accounts_Accounts.description.PR.B.Completeness.PT.001                        | KO |
        | OT.RF.Accounts_Accounts.amount_main_balance.PR.B.Completeness.PT.001                | KO |
        | OT.RF.Accounts_Accounts.currency_code_main_balance.PR.B.Completeness.PT.001         | KO |
        | OT.RF.Accounts_Accounts.amount_withholding_balance.PR.B.Completeness.PT.001         | KO |
        | OT.RF.Accounts_Accounts.currency_code_pending_balance.PR.B.Domain.PT.001            | KO |
        | OT.RF.Accounts_Accounts.amount_available_balance.PR.B.Completeness.PT.001           | KO |
        | OT.RF.Accounts_Accounts.currency_code_available_balance.PR.B.Completeness.PT.001    | KO |
        | OT.RF.Accounts_Accounts.currency_code_withholding_balance.PR.B.Completeness.PT.001  | KO |
        | OT.RF.Accounts_Accounts.currency_code_overdraft_limit.PR.B.Domain.PT.001            | KO |
        | OT.RF.Accounts_Accounts.amount_pending_balance.PR.B.Completeness.PT.001             | KO |
        | OT.RF.Accounts_Accounts.bic_description.PR.B.Completeness.PT.001                    | KO |
        | OT.RF.Accounts_Accounts.corporate_name.PR.B.Completeness.PT.001                     | KO |
        | OT.RF.Accounts_Accounts.subsidiary_name.PR.B.Completeness.PT.001                    | KO |
        | OT.RF.Accounts_Accounts.display_number.PR.B.Completeness.PT.001                     | KO |
        | OT.RF.Accounts_Accounts.last_update_available_balance.PR.B.Completeness.PT.001      | KO |
        | OT.RF.Accounts_Accounts.last_update_withholding_balance.PR.B.Completeness.PT.001    | KO |
        | OT.RF.Accounts_Accounts.currency_code_withholding_balance.PR.B.Domain.PT.001        | KO |
        | OT.RF.Accounts_Accounts.last_update_swift_payment.PR.B.Completeness.PT.001          | KO |
        | OT.RF.Accounts_Accounts.type.PR.B.Domain.PT.001                                     | KO |
        | OT.RF.Accounts_Accounts.status.PR.B.Completeness.PT.001                             | KO |
        | OT.RF.Accounts_Accounts.customer_id.PR.B.Completeness.PT.001                        | KO |

    @sparta_accounts_raw
    Scenario: Ejecución del workflow 'ot-ac-rw-company-member' sin gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeaccounts.company_member', castea las columnas esperadas,
      añade el TS y almacena los datos en la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/accounts_company_member'

      When Se ejecuta el workflow con Id "6f9ab168-22d4-4b5c-b73f-d531b71ae20b"
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_ac_rw_company_member" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/accounts_company_member"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_ac_rw_company_member" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_OK_ot_ac_rw_company_member"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_ac_rw_company_member"

    @sparta_accounts_raw_qrules_ok
    Scenario: Ejecución del workflow 'ot-ac-rw-company-member' con gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeaccounts.company_member', castea las columnas esperadas,
      añade el TS y almacena los datos en la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/accounts_company_member'

      When Se ejecuta el workflow con Id "6f9ab168-22d4-4b5c-b73f-d531b71ae20b"
      Then Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Accounts_Company_Member.company_id.PR.B.Completeness.PT.001         | OK |
        | OT.RF.Accounts_Company_Member.company_member_id.PR.B.Completeness.PT.001  | OK |
        | OT.RF.Accounts_Company_Member.role_id.PR.B.Completeness.PT.001            | OK |

    @sparta_accounts_raw_qrules_ko
    Scenario: Ejecución del workflow 'ot-ac-rw-company-member' con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "6f9ab168-22d4-4b5c-b73f-d531b71ae20b"
      Then Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Accounts_Company_Member.company_id.PR.B.Completeness.PT.001         | KO |
        | OT.RF.Accounts_Company_Member.company_member_id.PR.B.Completeness.PT.001  | KO |
        | OT.RF.Accounts_Company_Member.role_id.PR.B.Completeness.PT.001            | KO |

    @sparta_accounts_raw
    Scenario: Ejecución del workflow 'ot-ac-rw-company-member-account' sin gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeaccounts.company_member_account', castea las columnas esperadas,
      añade el TS y almacena los datos en la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/accounts_company_member_account'

      When Se ejecuta el workflow con Id "c687c329-bcf1-441d-94be-20c68bd24e4c"
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_ac_rw_company_member_account" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/accounts_company_member_account"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_ac_rw_company_member_account" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot_ac_rw_company_member_account"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_ac_rw_company_member_account"

    @sparta_accounts_raw_qrules_ok
    Scenario: Ejecución del workflow 'ot-ac-rw-company-member-account' con gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeaccounts.company_member_account', castea las columnas esperadas,
      añade el TS y almacena los datos en la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/accounts_company_member_account'

      When Se ejecuta el workflow con Id "c687c329-bcf1-441d-94be-20c68bd24e4c"
      Then Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Accounts_Company_Member_Account.account_country_id.PR.B.Completeness.PT.001        | OK |
        | OT.RF.Accounts_Company_Member_Account.company_member_account_id.PR.B.Completeness.PT.001 | OK |
        | OT.RF.Accounts_Company_Member_Account.company_member_id.PR.B.Completeness.PT.001         | OK |

    @sparta_accounts_raw_qrules_ko
    Scenario: Ejecución del workflow 'ot-ac-rw-company-member-account' con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "c687c329-bcf1-441d-94be-20c68bd24e4c"
      Then Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Accounts_Company_Member_Account.account_country_id.PR.B.Completeness.PT.001        | KO |
        | OT.RF.Accounts_Company_Member_Account.company_member_account_id.PR.B.Completeness.PT.001 | KO |
        | OT.RF.Accounts_Company_Member_Account.company_member_id.PR.B.Completeness.PT.001         | KO |