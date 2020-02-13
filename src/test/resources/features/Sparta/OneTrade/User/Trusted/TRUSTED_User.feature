Feature: TRUSTED_User

  Como usuario quiero ejecutar los flujos de Sparta pertenecientes al dominio de User, en el área de TRSUTED y gobernando los datos para poder promociarlos al área de ONEVIEW

  Background:
    Given Sparta operativo en la url "https://gts-sparta.sgcto-int.stratio.com/gts-sparta/swagger/appStatus"

    #####################################################################################
    Scenario: Ejecución del workflow 'ot-us-tt-user-company' con gobierno del dato

      El workflow recoge los datos de RAW-HDFS, hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/user/user_company, se seleccionan las columnas necesarias con el formato establecido,
      añade el TS y vuelca los datos en la ruta de TRUSTED-HDFS hdfs://gts-hdfs/gts/data/trusted/onetrade/user/user_company

      When Se ejecuta el workflow con Id "50de7782-7876-48e6-8667-27f8dd802d9d"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OK                                                                  |
        | OT.T.User_Company.cmc.PR.B.Completeness.PT.001                      |
        | OT.T.User_Company.company_global_id.PR.B.Completeness.PT.001        |
        | OT.T.User_Company.company_id.PR.B.Completeness.PT.001               |
        | OT.T.User_Company.country_name.PR.B.Completeness.PT.001             |
        | OT.T.User_Company.global_id.PR.B.Completeness.PT.001                |
        | OT.T.User_Company.internal_represent_user.PR.B.Completeness.PT.001  |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot-us-tt-user-company" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/onetrade/user/user_company"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot-us-tt-user-company" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot-us-tt-user-company"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot-us-tt-user-company"


    @Manual
    Scenario: Ejecución del workflow 'ot-us-tt-user-company' con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

        When Se ejecuta el workflow con Id "50de7782-7876-48e6-8667-27f8dd802d9d"
        Then Se aplican las siguientes reglas de calidad con resultado
          | KO                                                                  |
          | OT.T.User_Company.cmc.PR.B.Completeness.PT.001                      |
          | OT.T.User_Company.company_global_id.PR.B.Completeness.PT.001        |
          | OT.T.User_Company.company_id.PR.B.Completeness.PT.001               |
          | OT.T.User_Company.country_name.PR.B.Completeness.PT.001             |
          | OT.T.User_Company.global_id.PR.B.Completeness.PT.001                |
          | OT.T.User_Company.internal_represent_user.PR.B.Completeness.PT.001  |

    #####################################################################################
    Scenario: Ejecución del workflow 'ot-us-tt-user-company-country' con gobierno del dato

    El workflow recoge los datos de RAW-HDFS, hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/user/user_company_country, durante el proceso se descartan los paises que no cumplen
    con el formato establecido (ISO2), añade el TS y vuelca los datos en la ruta de TRUSTED-HDFS hdfs://gts-hdfs/gts/data/trusted/onetrade/user/user_company_country

      When Se ejecuta el workflow con Id "32ec5a60-b56a-4eb5-ab84-6f6805ed6e5e"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OK                                                                   |
        | OT.T.User_CompanyCountry.company_country_id.PR.B.Completeness.PT.001 |
        | OT.T.User_CompanyCountry.company_id.PR.B.Completeness.PT.001         |
        | OT.T.User_CompanyCountry.country_id.PR.B.Completeness.PT.001         |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot-us-tt-user-company-country" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/onetrade/user/user_company_country"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot-us-tt-user-company-country" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot-us-tt-user-company-country"
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot-us-tt-user-company-country_company_country_currencies_refusals" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/onetrade/user/company_country_currencies_refusals"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot-us-tt-user-company-country_company_country_currencies_refusals" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot-us-tt-user-company-country_company_country_currencies_refusals"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot-us-tt-user-company-country"
      And  Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot-us-tt-user-company-country_company_country_currencies_refusals"

    @Manual
    Scenario: Ejecución del workflow 'ot-us-tt-user-company-country' con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "32ec5a60-b56a-4eb5-ab84-6f6805ed6e5e"
      Then Se aplican las siguientes reglas de calidad con resultado
        | KO                                                                  |
        | OT.T.User_CompanyCountry.company_country_id.PR.B.Completeness.PT.001 |
        | OT.T.User_CompanyCountry.company_id.PR.B.Completeness.PT.001         |
        | OT.T.User_CompanyCountry.country_id.PR.B.Completeness.PT.001         |

    #####################################################################################
    Scenario: Ejecución del workflow 'ot-us-tt-user-contact' con gobierno del dato

      El workflow recoge los datos de RAW-HDFS, hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/user/user_contact, se seleccionan las columnas necesarias con el formato establecido,
      añade el TS y vuelca los datos en la ruta de TRUSTED-HDFS hdfs://gts-hdfs/gts/data/trusted/onetrade/user/user_contact

      When Se ejecuta el workflow con Id "14ef70c6-f583-400a-b1ee-d51d65bff315"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OK                                                                  |
        | OT.T.User_Contact.contact_data.PR.B.Completeness.PT.001             |
        | OT.T.User_Contact.contact_id.PR.B.Completeness.PT.001               |
        | OT.T.User_Contact.contact_type.PR.B.Completeness.PT.001             |
        | OT.T.User_Contact.global_id.PR.B.Completeness.PT.001                |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot-us-tt-user-contact" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/onetrade/user/user_contact"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot-us-tt-user-contact" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot-us-tt-user-contact"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot-us-tt-user-contact"


      @Manual
      Scenario: Ejecución del workflow 'ot-us-tt-user-contact' con gobierno del dato negativo

        Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

        When Se ejecuta el workflow con Id "14ef70c6-f583-400a-b1ee-d51d65bff315"
        Then Se aplican las siguientes reglas de calidad con resultado
          | KO                                                                  |
          | OT.T.User_Contact.contact_data.PR.B.Completeness.PT.001             |
          | OT.T.User_Contact.contact_id.PR.B.Completeness.PT.001               |
          | OT.T.User_Contact.contact_type.PR.B.Completeness.PT.001             |
          | OT.T.User_Contact.global_id.PR.B.Completeness.PT.001                |

    #####################################################################################
    Scenario: Ejecución del workflow 'ot-us-tt-user-country' con gobierno del dato

      El workflow recoge los datos de RAW-HDFS, hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/user/user_country, durante el proceso se descartan las divisas que no cumplen
      con el formato establecido (ISO2), añade el TS y vuelca los datos en la ruta de TRUSTED-HDFS hdfs://gts-hdfs/gts/data/trusted/onetrade/user/user_country

      When Se ejecuta el workflow con Id "2ff5acca-a84a-4c5d-88be-61e57c11100b"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OK                                                                   |
        | OT.T.User_Country.country_id.PR.B.Completeness.PT.001                |
        | OT.T.User_Country.country_name.PR.B.Completeness.PT.001              |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot-us-tt-user-country" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/onetrade/user/user_country"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot-us-tt-user-country" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot-us-tt-user-country"
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot-us-tt-user-country_country_currencies_refusals" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/onetrade/user/country_currencies_refusals"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot-us-tt-user-country_country_currencies_refusals" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot-us-tt-user-country_country_currencies_refusals"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot-us-tt-user-country"
      And  Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot-us-tt-user-country_country_currencies_refusals"

    @Manual
    Scenario: Ejecución del workflow 'ot-us-tt-user-country' con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "2ff5acca-a84a-4c5d-88be-61e57c11100b"
      Then Se aplican las siguientes reglas de calidad con resultado
        | KO                                                                  |
        | OT.T.User_Country.country_id.PR.B.Completeness.PT.001               |
        | OT.T.User_Country.country_name.PR.B.Completeness.PT.001             |

    #####################################################################################
    Scenario: Ejecución del workflow 'ot-us-tt-user-user' con gobierno del dato

      El workflow recoge los datos de RAW-HDFS, hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/user/user_user, se seleccionan las columnas necesarias con el formato establecido,
      añade el TS y vuelca los datos en la ruta de TRUSTED-HDFS hdfs://gts-hdfs/gts/data/trusted/onetrade/user/user_user

      When Se ejecuta el workflow con Id "14ef70c6-f583-400a-b1ee-d51d65bff315"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OK                                                            |
        | OT.T.User_User.document_country.PR.B.Completeness.PT.001      |
        | OT.T.User_User.document_description.PR.B.Completeness.PT.001  |
        | OT.T.User_User.document_id.PR.B.Completeness.PT.0011          |
        | OT.T.User_User.document_number.PR.B.Completeness.PT.001       |
        | OT.T.User_User.first_name.PR.B.Completeness.PT.001            |
        | OT.T.User_User.global_id.PR.B.Completeness.PT.001             |
        | OT.T.User_User.last_name.PR.B.Completeness.PT.001             |
        | OT.T.User_User.relationship_type.PR.B.Completeness.PT.001     |
        | OT.T.User_User.type_disposition.PR.B.Completeness.PT.001      |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot-us-tt-user-user" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/trusted/onetrade/user/user_user"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot-us-tt-user-user" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot-us-tt-user-user"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot-us-tt-user-user"


    @Manual
    Scenario: Ejecución del workflow 'ot-us-tt-user-user' con gobierno del dato negativo

    Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "14ef70c6-f583-400a-b1ee-d51d65bff315"
      Then Se aplican las siguientes reglas de calidad con resultado
        | KO                                                            |
        | OT.T.User_User.document_country.PR.B.Completeness.PT.001      |
        | OT.T.User_User.document_description.PR.B.Completeness.PT.001  |
        | OT.T.User_User.document_id.PR.B.Completeness.PT.0011          |
        | OT.T.User_User.document_number.PR.B.Completeness.PT.001       |
        | OT.T.User_User.first_name.PR.B.Completeness.PT.001            |
        | OT.T.User_User.global_id.PR.B.Completeness.PT.001             |
        | OT.T.User_User.last_name.PR.B.Completeness.PT.001             |
        | OT.T.User_User.relationship_type.PR.B.Completeness.PT.001     |
        | OT.T.User_User.type_disposition.PR.B.Completeness.PT.001      |