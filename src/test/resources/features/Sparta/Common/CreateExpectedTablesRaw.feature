@Environment_create_raw
Feature: Create_QA_Expected_Results

  @raw_accounts_sparta_create_expected_table
  Scenario: RAW_ACCOUNTS Creacion de las tablas QA_EXPECTED para las pruebas de automatizacion
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_ac_rw_accounts" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/accounts_accounts"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_ac_rw_company_member" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/accounts_company_member"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_ac_rw_company_member_account" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/accounts_company_member_account"

  @raw_enterprise_sparta_create_expected_table
  Scenario: RAW_ENTRERPRISE Creacion de las tablas QA_EXPECTED para las pruebas de automatizacion
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_et_rw_enterprise_company" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_activity" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_activity"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_et_rw_enterprise_company-address" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_address"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_address_type" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_address_type"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_cmc" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_cmc"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_contact" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_contact"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_contact_type" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_contact_type"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_country" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_country"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_identification" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_identification"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_permission" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_permission"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_resource" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_resource"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_resource_type" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_resource_type"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_user" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_user"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_user_permission_resource" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_user_permission_resource"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_et_rw_enterprise_country" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_country"

  @raw_transactions_sparta_create_expected_table
  Scenario: RAW_TRANSACTIONS Creacion de las tablas QA_EXPECTED para las pruebas de automatizacion
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_tr_rw_company_account" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/transactions/transaction_company_account"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_tr_rw_transaction" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/transactions/transaction"

  @raw_user_sparta_create_expected_table
  Scenario: RAW_USER Creacion de las tablas QA_EXPECTED para las pruebas de automatizacion
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_us_rw_user_company" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/user/user_company"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_us_rw_user_company_country" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/user/user_company_country"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_us_rw_user_contact" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/user/user_contact"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_us_rw_user_country" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/user/user_country"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_us_rw_user_user" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/user/user_user"
