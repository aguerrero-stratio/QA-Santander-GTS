@Environment_delete_raw
Feature: Delete_QA_Expected_Results

  @raw_accounts_sparta_delete_expected_table
  Scenario: RAW_ACCOUNTS Borrrado de las tablas QA_EXPECTED para las pruebas de automatizacion
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_ac_rw_accounts"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_ac_rw_company_member"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_ac_rw_company_member_account"

  @raw_enterprise_sparta_delete_expected_table
  Scenario: RAW_ENTRERPRISE Borrrado de las tablas QA_EXPECTED para las pruebas de automatizacion
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_et_rw_enterprise_company"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_activity"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_et_rw_enterprise_company-address"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_address_type"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_cmc"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_contact"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_contact_type"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_country"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_identification"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_permission"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_resource"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_resource_type"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_user"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_user_permission_resource"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_et_rw_enterprise_country"

  @raw_transactions_sparta_delete_expected_table
  Scenario: RAW_TRANSACTIONS Borrrado de las tablas QA_EXPECTED para las pruebas de automatizacion
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_tr_rw_company_account"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_tr_rw_transaction"

  @raw_user_sparta_delete_expected_table
  Scenario: RAW_USER Borrrado de las tablas QA_EXPECTED para las pruebas de automatizacion
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_us_rw_user_company"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_us_rw_user_company_country"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_us_rw_user_contact"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_us_rw_user_country"
     Then Se borra la tabla de XDATA "GTS.QA_EXPECTED_ot_us_rw_user_user"






