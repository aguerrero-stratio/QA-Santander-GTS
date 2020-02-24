Feature: TRUSTED_User

  Como usuario quiero ejecutar los flujos de Sparta pertenecientes al dominio de User, en el área de TRSUTED y gobernando los datos para poder promociarlos al área de ONEVIEW

  Background:
    Given Sparta operativo en la url "https://gts-sparta.sgcto-int.stratio.com/gts-sparta/appStatus"

    #####################################################################################
    @sparta_user
    Scenario: Ejecución del workflow 'ot-us-tt-user-company' sin gobierno del dato

      El workflow recoge los datos de RAW-HDFS, hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/user/user_company, se seleccionan las columnas necesarias con el formato establecido,
      añade el TS y vuelca los datos en la ruta de TRUSTED-HDFS hdfs://gts-hdfs/gts/data/trusted/onetrade/user/user_company

      Then Se ejecuta el workflow con Id "50de7782-7876-48e6-8667-27f8dd802d9d"

    @sparta_user_qrules_ok
    Scenario: Ejecución del workflow 'ot-us-tt-user-company' con gobierno del dato

        El workflow recoge los datos de RAW-HDFS, hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/user/user_company, se seleccionan las columnas necesarias con el formato establecido,
        añade el TS y vuelca los datos en la ruta de TRUSTED-HDFS hdfs://gts-hdfs/gts/data/trusted/onetrade/user/user_company

        When Se ejecuta el workflow con Id "50de7782-7876-48e6-8667-27f8dd802d9d"
        And  Se aplican las siguientes reglas de calidad con resultado
          | OT.T.User_Company.cmc.PR.B.Completeness.PT.001                      | OK |
          | OT.T.User_Company.company_global_id.PR.B.Completeness.PT.001        | OK |
          | OT.T.User_Company.company_id.PR.B.Completeness.PT.001               | OK |
          | OT.T.User_Company.country_name.PR.B.Completeness.PT.001             | OK |
          | OT.T.User_Company.global_id.PR.B.Completeness.PT.001                | OK |
          | OT.T.User_Company.internal_represent_user.PR.B.Completeness.PT.001  | OK |
        Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_us_tt_user_company" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/onetrade/user/user_company"
        And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_us_tt_user_company" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot_us_tt_user_company"
        Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_us_tt_user_company"

    @sparta_user_qrules_ko
    Scenario: Ejecución del workflow 'ot-us-tt-user-company' con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

        When Se ejecuta el workflow con Id "50de7782-7876-48e6-8667-27f8dd802d9d"
        Then Se aplican las siguientes reglas de calidad con resultado
          | OT.T.User_Company.cmc.PR.B.Completeness.PT.001                      | KO |
          | OT.T.User_Company.company_global_id.PR.B.Completeness.PT.001        | KO |
          | OT.T.User_Company.company_id.PR.B.Completeness.PT.001               | KO |
          | OT.T.User_Company.country_name.PR.B.Completeness.PT.001             | KO |
          | OT.T.User_Company.global_id.PR.B.Completeness.PT.001                | KO |
          | OT.T.User_Company.internal_represent_user.PR.B.Completeness.PT.001  | KO |

    #####################################################################################
    @sparta_user
    Scenario: Ejecución del workflow 'ot-us-tt-user-company-country' sin gobierno del dato

      El workflow recoge los datos de RAW-HDFS, hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/user/user_company_country, durante el proceso se descartan los paises que no cumplen
      con el formato establecido (ISO2), añade el TS y vuelca los datos en la ruta de TRUSTED-HDFS hdfs://gts-hdfs/gts/data/trusted/onetrade/user/user_company_country

      Then Se ejecuta el workflow con Id "32ec5a60-b56a-4eb5-ab84-6f6805ed6e5e"

    @sparta_user_qrules_ok
    Scenario: Ejecución del workflow 'ot-us-tt-user-company-country' con gobierno del dato

      El workflow recoge los datos de RAW-HDFS, hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/user/user_company_country, durante el proceso se descartan los paises que no cumplen
      con el formato establecido (ISO2), añade el TS y vuelca los datos en la ruta de TRUSTED-HDFS hdfs://gts-hdfs/gts/data/trusted/onetrade/user/user_company_country

      When Se ejecuta el workflow con Id "32ec5a60-b56a-4eb5-ab84-6f6805ed6e5e"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OT.T.User_CompanyCountry.company_country_id.PR.B.Completeness.PT.001 | OK |
        | OT.T.User_CompanyCountry.company_id.PR.B.Completeness.PT.001         | OK |
        | OT.T.User_CompanyCountry.country_id.PR.B.Completeness.PT.001         | OK |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_us_tt_user_company_country" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/onetrade/user/user_company_country"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_us_tt_user_company_country" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot_us_tt_user_company_country"
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_us_tt_user_company_country_company_country_currencies_refusals" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/onetrade/user/company_country_currencies_refusals"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_us_tt_user_company_country_company_country_currencies_refusals" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot_us_tt_user_company_country_company_country_currencies_refusals"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_us_tt_user_company_country"
      And  Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_us_tt_user_company_country_company_country_currencies_refusals"

    @sparta_user_qrules_ko
    Scenario: Ejecución del workflow 'ot-us-tt-user-company-country' con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "32ec5a60-b56a-4eb5-ab84-6f6805ed6e5e"
      Then Se aplican las siguientes reglas de calidad con resultado
        | OT.T.User_CompanyCountry.company_country_id.PR.B.Completeness.PT.001 | KO |
        | OT.T.User_CompanyCountry.company_id.PR.B.Completeness.PT.001         | KO |
        | OT.T.User_CompanyCountry.country_id.PR.B.Completeness.PT.001         | KO |

    #####################################################################################
    @sparta_user
    Scenario: Ejecución del workflow 'ot-us-tt-user-contact' sin gobierno del dato

      El workflow recoge los datos de RAW-HDFS, hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/user/user_contact, se seleccionan las columnas necesarias con el formato establecido,
      añade el TS y vuelca los datos en la ruta de TRUSTED-HDFS hdfs://gts-hdfs/gts/data/trusted/onetrade/user/user_contact

      Then Se ejecuta el workflow con Id "14ef70c6-f583-400a-b1ee-d51d65bff315"

    @sparta_user_qrules_ok
    Scenario: Ejecución del workflow 'ot-us-tt-user-contact' con gobierno del dato

      El workflow recoge los datos de RAW-HDFS, hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/user/user_contact, se seleccionan las columnas necesarias con el formato establecido,
      añade el TS y vuelca los datos en la ruta de TRUSTED-HDFS hdfs://gts-hdfs/gts/data/trusted/onetrade/user/user_contact

      When Se ejecuta el workflow con Id "14ef70c6-f583-400a-b1ee-d51d65bff315"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OT.T.User_Contact.contact_data.PR.B.Completeness.PT.001             | OK |
        | OT.T.User_Contact.contact_id.PR.B.Completeness.PT.001               | OK |
        | OT.T.User_Contact.contact_type.PR.B.Completeness.PT.001             | OK |
        | OT.T.User_Contact.global_id.PR.B.Completeness.PT.001                | OK |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_us_tt_user_contact" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/onetrade/user/user_contact"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_us_tt_user_contact" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot_us_tt_user_contact"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_us_tt_user_contact"

    @sparta_user_qrules_ko
    Scenario: Ejecución del workflow 'ot-us-tt-user-contact' con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "14ef70c6-f583-400a-b1ee-d51d65bff315"
      Then Se aplican las siguientes reglas de calidad con resultado
        | OT.T.User_Contact.contact_data.PR.B.Completeness.PT.001             | KO |
        | OT.T.User_Contact.contact_id.PR.B.Completeness.PT.001               | KO |
        | OT.T.User_Contact.contact_type.PR.B.Completeness.PT.001             | KO |
        | OT.T.User_Contact.global_id.PR.B.Completeness.PT.001                | KO |

    #####################################################################################
    @sparta_user
    Scenario: Ejecución del workflow 'ot-us-tt-user-country' sin gobierno del dato

      El workflow recoge los datos de RAW-HDFS, hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/user/user_country, durante el proceso se descartan las divisas que no cumplen
      con el formato establecido (ISO2), añade el TS y vuelca los datos en la ruta de TRUSTED-HDFS hdfs://gts-hdfs/gts/data/trusted/onetrade/user/user_country

      Then Se ejecuta el workflow con Id "2ff5acca-a84a-4c5d-88be-61e57c11100b"

    @sparta_user_qrules_ok
    Scenario: Ejecución del workflow 'ot-us-tt-user-country' con gobierno del dato

      El workflow recoge los datos de RAW-HDFS, hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/user/user_country, durante el proceso se descartan las divisas que no cumplen
      con el formato establecido (ISO2), añade el TS y vuelca los datos en la ruta de TRUSTED-HDFS hdfs://gts-hdfs/gts/data/trusted/onetrade/user/user_country

      When Se ejecuta el workflow con Id "2ff5acca-a84a-4c5d-88be-61e57c11100b"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OT.T.User_Country.country_id.PR.B.Completeness.PT.001                | OK |
        | OT.T.User_Country.country_name.PR.B.Completeness.PT.001              | OK |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_us_tt_user_country" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/onetrade/user/user_country"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_us_tt_user_country" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot_us_tt_user_country"
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_us_tt_user_country_country_currencies_refusals" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/onetrade/user/country_currencies_refusals"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_us_tt_user_country_country_currencies_refusals" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot_us_tt_user_country_country_currencies_refusals"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_us_tt_user_country"
      And  Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_us_tt_user_country_country_currencies_refusals"

    @sparta_user_qrules_ko
    Scenario: Ejecución del workflow 'ot-us-tt-user-country' con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "2ff5acca-a84a-4c5d-88be-61e57c11100b"
      Then Se aplican las siguientes reglas de calidad con resultado
        | OT.T.User_Country.country_id.PR.B.Completeness.PT.001               | KO |
        | OT.T.User_Country.country_name.PR.B.Completeness.PT.001             | KO |

    #####################################################################################
    @sparta_user
    Scenario: Ejecución del workflow 'ot-us-tt-user-user' con gobierno del dato

      El workflow recoge los datos de RAW-HDFS, hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/user/user_user, se seleccionan las columnas necesarias con el formato establecido,
      añade el TS y vuelca los datos en la ruta de TRUSTED-HDFS hdfs://gts-hdfs/gts/data/trusted/onetrade/user/user_user

      Then Se ejecuta el workflow con Id "72ff9655-eca9-4510-b077-8de300ef63e8"

    @sparta_user_qrules_ok
    Scenario: Ejecución del workflow 'ot-us-tt-user-user' con gobierno del dato

      El workflow recoge los datos de RAW-HDFS, hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/user/user_user, se seleccionan las columnas necesarias con el formato establecido,
      añade el TS y vuelca los datos en la ruta de TRUSTED-HDFS hdfs://gts-hdfs/gts/data/trusted/onetrade/user/user_user

      When Se ejecuta el workflow con Id "72ff9655-eca9-4510-b077-8de300ef63e8"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OT.T.User_User.document_country.PR.B.Completeness.PT.001      | OK |
        | OT.T.User_User.document_description.PR.B.Completeness.PT.001  | OK |
        | OT.T.User_User.document_id.PR.B.Completeness.PT.0011          | OK |
        | OT.T.User_User.document_number.PR.B.Completeness.PT.001       | OK |
        | OT.T.User_User.first_name.PR.B.Completeness.PT.001            | OK |
        | OT.T.User_User.global_id.PR.B.Completeness.PT.001             | OK |
        | OT.T.User_User.last_name.PR.B.Completeness.PT.001             | OK |
        | OT.T.User_User.relationship_type.PR.B.Completeness.PT.001     | OK |
        | OT.T.User_User.type_disposition.PR.B.Completeness.PT.001      | OK |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_us_tt_user_user" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/onetrade/user/user_user"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_us_tt_user_user" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot_us_tt_user_user"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_us_tt_user_user"

    @sparta_user_qrules_ok
    Scenario: Ejecución del workflow 'ot-us-tt-user-user' con gobierno del dato negativo

    Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "72ff9655-eca9-4510-b077-8de300ef63e8"
      Then Se aplican las siguientes reglas de calidad con resultado
        | OT.T.User_User.document_country.PR.B.Completeness.PT.001      | KO |
        | OT.T.User_User.document_description.PR.B.Completeness.PT.001  | KO |
        | OT.T.User_User.document_id.PR.B.Completeness.PT.0011          | KO |
        | OT.T.User_User.document_number.PR.B.Completeness.PT.001       | KO |
        | OT.T.User_User.first_name.PR.B.Completeness.PT.001            | KO |
        | OT.T.User_User.global_id.PR.B.Completeness.PT.001             | KO |
        | OT.T.User_User.last_name.PR.B.Completeness.PT.001             | KO |
        | OT.T.User_User.relationship_type.PR.B.Completeness.PT.001     | KO |
        | OT.T.User_User.type_disposition.PR.B.Completeness.PT.001      | KO |