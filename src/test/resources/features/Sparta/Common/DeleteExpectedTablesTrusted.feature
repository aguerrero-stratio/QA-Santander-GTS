@Environment_delete_trusted
Feature: Delete_QA_Expected_Results

  @trusted_accounts_sparta_delete_expected_table
  Scenario: TRUSTED_ACCOUNTS Borrrado de las tablas QA_EXPECTED para las pruebas de automatizacion
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_ac_tt_accounts"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_ac_tt_accounts_currencies_refusals"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_ac_tt_accounts_bics_refusals"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_ac_tt_accounts_countries_refusals"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_ac_tt_company_member"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_ac_tt_company_member_account"

  @trusted_enterprise_sparta_delete_expected_table
  Scenario: TRUSTED_ENTRERPRISE Borrrado de las tablas QA_EXPECTED para las pruebas de automatizacion
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_et_tt_enterprise_company"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_et_tt_enterprise_company_bic_refusals"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_et_tt_enterprise_company_activity"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_et_tt_enterprise_company_address"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_et_tt_enterprise_company_address_type"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_et_tt_enterprise_company_cmc"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_et_tt_enterprise_company_contact"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_et_tt_enterprise_company_country"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_et_tt_enterprise_company_identification"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_et_tt_enterprise_company_permission"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_et_tt_enterprise_company_resource"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_et_tt_enterprise_company_resource_type"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_et_tt_enterprise_company_user"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_et_tt_enterprise_company_user_permission_resource"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_et_tt_enterprise_country"


  @trusted_transactions_sparta_delete_expected_table
  Scenario: TRUSTED_TRANSACTIONS Borrrado de las tablas QA_EXPECTED para las pruebas de automatizacion
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_tr_tt_transaction_company_account"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_tr_tt_transaction_company_account_transaction_country_refusals"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_tr_tt_transaction_company_account_bics_refusals"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_tr_tt_transaction"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_tr_tt_transaction_transaction_amount_currency_refusals"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_tr_tt_transaction_transaction_balance_amount_currency_refusals"

  @trusted_user_sparta_delete_expected_table
  Scenario: TRUSTED_USER Borrrado de las tablas QA_EXPECTED para las pruebas de automatizacion
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_us_tt_user_company"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_us_tt_user_company_country"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_us_tt_user_company_country_company_country_currencies_refusals"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_us_tt_user_contact"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_us_tt_user_country"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_us_tt_user_country_country_currencies_refusals"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_us_tt_user_user"






