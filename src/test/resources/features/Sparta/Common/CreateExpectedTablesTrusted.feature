@Environment_create_trusted
Feature: Create_QA_Expected_Results

  @trusted_accounts_sparta_create_expected_table
  Scenario: TRUSTED_ACCOUNTS Creacion de las tablas QA_EXPECTED para las pruebas de automatizacion
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_ac_tt_accounts" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/onetrade/accounts_accounts"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_ac_tt_accounts_currencies_refusals" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/onetrade/accounts_currencies_refusals"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_ac_tt_accounts_bics_refusals" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/onetrade/accounts_bics_refusals"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_ac_tt_accounts_countries_refusals" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/onetrade/accounts_countries_refusals"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_ac_tt_company_member" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/onetrade/accounts_company_member"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_ac_tt_company_member_account" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/onetrade/accounts_company_member_account"

  @trusted_enterprise_sparta_create_expected_table
  Scenario: TRUSTED_ENTRERPRISE Creacion de las tablas QA_EXPECTED para las pruebas de automatizacion
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_et_tt_enterprise_company" con el hdfs-output del workflow "hdfs://gts-hdfs//gts/data/trusted/onetrade/enterprise/enterprise_company"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_et_tt_enterprise_company_bic_refusals" con el hdfs-output del workflow "hdfs://gts-hdfs//gts/data/trusted/onetrade/enterprise/enterprise_company_bic_refusals"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_et_tt_enterprise_company_activity" con el hdfs-output del workflow "hdfs://gts-hdfs//gts/data/trusted/onetrade/enterprise/enterprise_company_activity"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_et_tt_enterprise_company_address" con el hdfs-output del workflow "hdfs://gts-hdfs//gts/data/trusted/onetrade/enterprise/enterprise_company_address"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_et_tt_enterprise_company_address_type" con el hdfs-output del workflow "hdfs://gts-hdfs//gts/data/trusted/onetrade/enterprise/enterprise_company_address_type"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_et_tt_enterprise_company_cmc" con el hdfs-output del workflow "hdfs://gts-hdfs//gts/data/trusted/onetrade/enterprise/enterprise_company_cmc"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_et_tt_enterprise_company_contact" con el hdfs-output del workflow "hdfs://gts-hdfs//gts/data/trusted/onetrade/enterprise/enterprise_company_contact"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_et_tt_enterprise_company_country" con el hdfs-output del workflow "hdfs://gts-hdfs//gts/data/trusted/onetrade/enterprise/enterprise_company_country"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_et_tt_enterprise_company_identification" con el hdfs-output del workflow "hdfs://gts-hdfs//gts/data/trusted/onetrade/enterprise/enterprise_company_identification"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_et_tt_enterprise_company_permission" con el hdfs-output del workflow "hdfs://gts-hdfs//gts/data/trusted/onetrade/enterprise/enterprise_company_permission"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_et_tt_enterprise_company_resource" con el hdfs-output del workflow "hdfs://gts-hdfs//gts/data/trusted/onetrade/enterprise/enterprise_company_resource"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_et_tt_enterprise_company_resource_type" con el hdfs-output del workflow "hdfs://gts-hdfs//gts/data/trusted/onetrade/enterprise/enterprise_company_resource_type"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_et_tt_enterprise_company_user" con el hdfs-output del workflow "hdfs://gts-hdfs//gts/data/trusted/onetrade/enterprise/enterprise_company_user"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_et_tt_enterprise_company_user_permission_resource" con el hdfs-output del workflow "hdfs://gts-hdfs//gts/data/trusted/onetrade/enterprise/enterprise_company_user_permission_resource"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_et_tt_enterprise_country" con el hdfs-output del workflow "hdfs://gts-hdfs//gts/data/trusted/onetrade/enterprise/enterprise_country"

  @trusted_transactions_sparta_create_expected_table
  Scenario: TRUSTED_TRANSACTIONS Creacion de las tablas QA_EXPECTED para las pruebas de automatizacion
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_tr_tt_transaction_company_account" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/onetrade/transactions/transaction_company_account"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_tr_tt_transaction_company_account_transaction_country_refusals" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/onetrade/transactions/transaction_country_refusals"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_tr_tt_transaction_company_account_bics_refusals" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/onetrade/transactions/transaction_bic_refusals"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_tr_tt_transaction" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/onetrade/transactions/transaction"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_tr_tt_transaction_transaction_amount_currency_refusals" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/onetrade/transactions/transaction_amount_currency_refusals"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_tr_tt_transaction_transaction_balance_amount_currency_refusals" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/onetrade/transactions/transaction_balance_amount_currency_refusals"

  @trusted_user_sparta_create_expected_table
  Scenario: TRUSTED_USER Creacion de las tablas QA_EXPECTED para las pruebas de automatizacion
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_us_tt_user_company" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/onetrade/user/user_company"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_us_tt_user_company_country" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/onetrade/user/user_company_country"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_us_tt_user_company_country_company_country_currencies_refusals" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/onetrade/user/company_country_currencies_refusals"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_us_tt_user_contact" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/onetrade/user/user_contact"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_us_tt_user_country" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/onetrade/user/user_country"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_us_tt_user_country_country_currencies_refusals" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/onetrade/user/country_currencies_refusals"
    Then Se crea en XDATA la tabla "GTS.QA_EXPECTED_ot_us_tt_user_user" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/onetrade/user/user_user"





