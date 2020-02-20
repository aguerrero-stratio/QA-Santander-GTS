Feature: RAW_User

  Como usuario quiero ejecutar los flujos de Sparta pertenecientes al dominio de User, en el área de RAW y gobernando los datos para poder promociarlos al área de TRUSTED

  Background:
    Given Sparta operativo en la url "https://gts-sparta.sgcto-int.stratio.com/gts-sparta/swagger/appStatus"

    #####################################################################################
    Scenario: Ejecución del workflow 'ot-us-rw-user-company' con gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeusers.company', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/user/user_company'

      When Se ejecuta el workflow con Id "3ed1aa38-2c52-4cb3-825a-5c23d3c72e82"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.User_Company.cmc.PR.B.Completeness.PT.001                     | OK |
        | OT.RF.User_Company.company_global_id.PR.B.Completeness.PT.001       | OK |
        | OT.RF.User_Company.company_id.PR.B.Completeness.PT.001              | OK |
        | OT.RF.User_Company.country_name.PR.B.Completeness.PT.001            | OK |
        | OT.RF.User_Company.global_id.PR.B.Completeness.PT.001               | OK |
        | OT.RF.User_Company.internal_represent_user.PR.B.Completeness.PT.001 | OK |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_us_rw_user_company" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/user/user_company"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_us_rw_user_company" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot_us_rw_user_company"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_us_rw_user_company"


    @Manual
    Scenario: Ejecución del workflow 'oot-us-rw-user-company' con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

        When Se ejecuta el workflow con Id "3ed1aa38-2c52-4cb3-825a-5c23d3c72e82"
        Then Se aplican las siguientes reglas de calidad con resultado
          | OT.RF.User_Company.cmc.PR.B.Completeness.PT.001                     | KO |
          | OT.RF.User_Company.company_global_id.PR.B.Completeness.PT.001       | KO |
          | OT.RF.User_Company.company_id.PR.B.Completeness.PT.001              | KO |
          | OT.RF.User_Company.country_name.PR.B.Completeness.PT.001            | KO |
          | OT.RF.User_Company.global_id.PR.B.Completeness.PT.001               | KO |
          | OT.RF.User_Company.internal_represent_user.PR.B.Completeness.PT.001 | KO |

    #####################################################################################
    Scenario: Ejecución del workflow 'ot-us-rw-user-company-country' con gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeusers.company_country', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/user/user_company_country'

        When Se ejecuta el workflow con Id "ab690467-c7a4-40f3-bbe3-6f7bbb4fb237"
        And  Se aplican las siguientes reglas de calidad con resultado
          | OT.RF.User_CompanyCountry.country_id.PR.B.Completeness.PT.001         | OK |
          | OT.RF.User_CompanyCountry.company_id.PR.B.Completeness.PT.001         | OK |
          | OT.RF.User_CompanyCountry.company_country_id.PR.B.Completeness.PT.001 | OK |
        Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_us_rw_user_company_country" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/user/user_company_country"
        And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_us_rw_user_company_country" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot_us_rw_user_company_country"
        Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_us_rw_user_company_country"


      @Manual
      Scenario: Ejecución del workflow 'ot-us-rw-user-company-country-country' con gobierno del dato negativo

       Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

        When Se ejecuta el workflow con Id "ab690467-c7a4-40f3-bbe3-6f7bbb4fb237"
        Then Se aplican las siguientes reglas de calidad con resultado
          | OT.RF.User_CompanyCountry.country_id.PR.B.Completeness.PT.001         | KO |
          | OT.RF.User_CompanyCountry.company_id.PR.B.Completeness.PT.001         | KO |
          | OT.RF.User_CompanyCountry.company_country_id.PR.B.Completeness.PT.001 | KO |

  #####################################################################################
  Scenario: Ejecución del workflow 'ot-us-rw-user-contact' con gobierno del dato

    El workflow recoge los datos de la tabla de Postgres 'onetradeusers.contact', selecciona las columnas necesarias,
    añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/user/user_contact'

    When Se ejecuta el workflow con Id "9e62b352-ae61-4fe0-8ff3-d759eb7e54a4"
    And  Se aplican las siguientes reglas de calidad con resultado
      | OT.RF.User_Contact.contact_data.PR.B.Completeness.PT.001  | OK |
      | OT.RF.User_Contact.contact_id.PR.B.Completeness.PT.001    | OK |
      | OT.RF.User_Contact.contact_type.PR.B.Completeness.PT.001  | OK |
      | OT.RF.User_Contact.global_id.PR.B.Completeness.PT.001     | OK |
    Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_us_rw_user_contact" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/user/user_contact"
    And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_us_rw_user_contact" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot_us_rw_user_contact"
    Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_us_rw_user_contact"


  @Manual
  Scenario: Ejecución del workflow 'ot-us-rw-user-contact' con gobierno del dato negativo

    Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

    When Se ejecuta el workflow con Id "9e62b352-ae61-4fe0-8ff3-d759eb7e54a4"
    Then Se aplican las siguientes reglas de calidad con resultado
      | OT.RF.User_Contact.contact_data.PR.B.Completeness.PT.001  | KO |
      | OT.RF.User_Contact.contact_id.PR.B.Completeness.PT.001    | KO |
      | OT.RF.User_Contact.contact_type.PR.B.Completeness.PT.001  | KO |
      | OT.RF.User_Contact.global_id.PR.B.Completeness.PT.001     | KO |

    #####################################################################################
    Scenario: Ejecución del workflow 'ot-us-rw-user-country' con gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeusers.country', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/user/user_country'

      When Se ejecuta el workflow con Id "c40bd8a2-d2d0-410c-8249-45dcd37c40dc"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.User_Country.country_id.PR.B.Completeness.PT.001    | OK |
        | OT.RF.User_Country.country_name.PR.B.Completeness.PT.001  | OK |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_us_rw_user_country" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/user/user_country"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_us_rw_user_country" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot_us_rw_user_country"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_us_rw_user_country"


    @Manual
    Scenario: Ejecución del workflow 'ot-us-rw-user-contact' con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "c40bd8a2-d2d0-410c-8249-45dcd37c40dc"
      Then Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.User_Country.country_id.PR.B.Completeness.PT.001    | KO |
        | OT.RF.User_Country.country_name.PR.B.Completeness.PT.001  | KO |

    #####################################################################################
    Scenario: Ejecución del workflow 'ot-us-rw-user-user' con gobierno del dat0

      El workflow recoge los datos de la tabla de Postgres 'onetradeusers.user', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/user/user_user'

      When Se ejecuta el workflow con Id "febab635-2db6-4040-b239-9a15d57e7a4f"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.User_User.document_country.PR.B.Completeness.PT.001     | OK |
        | OT.RF.User_User.document_description.PR.B.Completeness.PT.001 | OK |
        | OT.RF.User_User.document_id.PR.B.Completeness.PT.001          | OK |
        | OT.RF.User_User.document_number.PR.B.Completeness.PT.001      | OK |
        | OT.RF.User_User.first_name.PR.B.Completeness.PT.001           | OK |
        | OT.RF.User_User.global_id.PR.B.Completeness.PT.001            | OK |
        | OT.RF.User_User.last_name.PR.B.Completeness.PT.001            | OK |
        | OT.RF.User_User.relationship_type.PR.B.Completeness.PT.001    | OK |
        | OT.RF.User_User.type_disposition.PR.B.Completeness.PT.0011    | OK |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_us_rw_user_user" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/user/user_user"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_us_rw_user_user" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot_us_rw_user_user"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_us_rw_user_user"


    @Manual
    Scenario: Ejecución del workflow 'ot-us-rw-user-user' con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "febab635-2db6-4040-b239-9a15d57e7a4f"
      Then Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.User_User.document_country.PR.B.Completeness.PT.001     | KO |
        | OT.RF.User_User.document_description.PR.B.Completeness.PT.001 | KO |
        | OT.RF.User_User.document_id.PR.B.Completeness.PT.001          | KO |
        | OT.RF.User_User.document_number.PR.B.Completeness.PT.001      | KO |
        | OT.RF.User_User.first_name.PR.B.Completeness.PT.001           | KO |
        | OT.RF.User_User.global_id.PR.B.Completeness.PT.001            | KO |
        | OT.RF.User_User.last_name.PR.B.Completeness.PT.001            | KO |
        | OT.RF.User_User.relationship_type.PR.B.Completeness.PT.001    | KO |
        | OT.RF.User_User.type_disposition.PR.B.Completeness.PT.0011    | KO |