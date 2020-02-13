Feature: TRUSTED_Accounts

  Como usuario quiero ejecutar los flujos de Sparta pertenecientes al dominio de Accounts, en el área de TRUSTED y gobernando los datos para poder promociarlos al área de ONEVIEW

  Background:
    Given Sparta operativo en la url "https://gts-sparta.sgcto-int.stratio.com/gts-sparta/swagger/appStatus"

    Scenario: Ejecución del workflow 'ot-ac-tt-accounts' sin gobierno del dato

      El workflow recoge los datos de RAW-HDFS, hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/accounts_accounts, durante el proceso se descartan los registros incorrectos de bics,paises y monedas
      añade el TS y vuelca los datos en la ruta de TRUSTED-HDFS 'hdfs://gts-hdfs/gts/data/trusted/onetrade/accounts/accounts_accounts'

      When Se ejecuta el workflow con Id "bad96dff-ed6d-44b8-b5ec-0b370cc018fb"
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot-ac-tt-accounts" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/onetrade/accounts/accounts_accounts"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot-ac-tt-accounts" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot-ac-tt-accounts"
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot-ac-tt-accounts_currencies_refusals" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/onetrade/accounts/accounts_currencies_refusals"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot-ac-tt-accounts_currencies_refusals" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot-ac-tt-accounts_currencies_refusals"
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot-ac-tt-accounts_bics_refusals" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/onetrade/accounts/accounts_bics_refusals"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot-ac-tt-accounts_bics_refusals" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot-ac-tt-accounts_bics_refusals"
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot-ac-tt-accounts_countries_refusals" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/onetrade/accounts/accounts_countries_refusals"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot-ac-tt-accounts_countries_refusals" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot-ac-tt-accounts_countries_refusals"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot-ac-tt-accounts"
      And  Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot-ac-tt-accounts_bics_refusals"
      And  Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot-ac-tt-accounts_currencies_refusals"
      And  Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot-ac-tt-accounts_countries_refusals"

    Scenario: Ejecución del workflow 'ot-ac-tt-company-member' con gobierno del dato

      El workflow recoge los datos de RAW-HDFS, hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/accounts_company_member, durante el proceso castea correctamente los datos,
      añade el TS y vuelca los datos en la ruta de TRUSTED-HDFS 'hdfs://gts-hdfs/gts/data/trusted/onetrade/accounts/accounts_company_member'

      When Se ejecuta el workflow con Id "b5059de1-6c16-40ad-8b83-29f4089da304"
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot-ac-tt-company-member" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/onetrade/accounts/accounts_company_member"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot-ac-tt-company-member" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot-ac-tt-company-member"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot-ac-tt-company-member"

    Scenario: Ejecución del workflow 'ot-ac-tt-company-member-account' con gobierno del dato

      El workflow recoge los datos de RAW-HDFS, hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/accounts_company_member_accounts, durante el proceso castea correctamente los datos,
      añade el TS y vuelca los datos en la ruta de TRUSTED-HDFS 'hdfs://gts-hdfs/gts/data/trusted/onetrade/accounts/accounts_company_member_accounts'

      When Se ejecuta el workflow con Id "c28e00de-48ff-47b0-a62a-0cb7d7f57c45"
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot-ac-tt-company-member-account" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/onetrade/accounts/accounts_company_member_account"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot-ac-tt-company-member-account" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot-ac-tt-company-member-account"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot-ac-tt-company-member-account"
