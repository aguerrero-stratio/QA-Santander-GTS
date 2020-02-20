Feature: RAW_Enterprise

  Como usuario quiero ejecutar los flujos de Sparta pertenecientes al dominio de Enterprise, en el área de RAW y gobernando los datos para poder promociarlos al área de TRUSTED

  Background:
    Given Sparta operativo en la url "https://gts-sparta.sgcto-int.stratio.com/gts-sparta/swagger/appStatus"

    #####################################################################################
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company' con gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.company', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company'

      When Se ejecuta el workflow con Id "5fed0639-6b46-4499-b6c2-7d106f3e0e34"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompany.entity.PR.B.Completeness.PT.001                           | OK |
        | OT.RF.Enterprise_EnterpriseCompany.company_global_id.PR.B.Completeness.PT.001                | OK |
        | OT.RF.Enterprise_EnterpriseCompany.company_name.PR.B.Completeness.PT.001                     | OK |
        | OT.RF.Enterprise_EnterpriseCompany.country_incorporation.PR.B.Completeness.PT.001            | OK |
        | OT.RF.Enterprise_EnterpriseCompany.entity.PR.B.Completeness.PT.001                           | OK |
        | OT.RF.Enterprise_EnterpriseCompany.identification_legal_customer.PR.B.Completeness.PT.001    | OK |
        | OT.RF.Enterprise_EnterpriseCompany.ind_cash_nexus.PR.B.Completeness.PT.001                   | OK |
        | OT.RF.Enterprise_EnterpriseCompany.ind_virtual_company.PR.B.Completeness.PT.001              | OK |
        | OT.RF.Enterprise_EnterpriseCompany.parent_company_id.PR.B.Completeness.PT.001                | OK |
        | OT.RF.Enterprise_EnterpriseCompany.trade_name.PR.B.Completeness.PT.001                       | OK |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_et_rw_enterprise_company" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_et_rw_enterprise_company" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot_et_rw_enterprise_company"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_et_rw_enterprise_company"


    @Manual
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company' con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "5fed0639-6b46-4499-b6c2-7d106f3e0e34"
      Then Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompany.entity.PR.B.Completeness.PT.001                           | KO |
        | OT.RF.Enterprise_EnterpriseCompany.company_global_id.PR.B.Completeness.PT.001                | KO |
        | OT.RF.Enterprise_EnterpriseCompany.company_name.PR.B.Completeness.PT.001                     | KO |
        | OT.RF.Enterprise_EnterpriseCompany.country_incorporation.PR.B.Completeness.PT.001            | KO |
        | OT.RF.Enterprise_EnterpriseCompany.entity.PR.B.Completeness.PT.001                           | KO |
        | OT.RF.Enterprise_EnterpriseCompany.identification_legal_customer.PR.B.Completeness.PT.001    | KO |
        | OT.RF.Enterprise_EnterpriseCompany.ind_cash_nexus.PR.B.Completeness.PT.001                   | KO |
        | OT.RF.Enterprise_EnterpriseCompany.ind_virtual_company.PR.B.Completeness.PT.001              | KO |
        | OT.RF.Enterprise_EnterpriseCompany.parent_company_id.PR.B.Completeness.PT.001                | KO |
        | OT.RF.Enterprise_EnterpriseCompany.trade_name.PR.B.Completeness.PT.001                       | KO |

    #####################################################################################
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-activity' con gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.company_activity', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_activity'

      When Se ejecuta el workflow con Id "2687952d-1bcf-4dc4-9886-35c0a2627153"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyActivity.company_activity_id.PR.B.Completeness.PT.001      | OK |
        | OT.RF.Enterprise_EnterpriseCompanyActivity.company_global_id.PR.B.Completeness.PT.001        | OK |
        | OT.RF.Enterprise_EnterpriseCompanyActivity.isic_code_description.PR.B.Completeness.PT.001    | OK |
        | OT.RF.Enterprise_EnterpriseCompanyActivity.isic_code.PR.B.Completeness.PT.001                | OK |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_activity" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_activity"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_activity" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_activity"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_activity"


      @Manual
      Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-activity' con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

        When Se ejecuta el workflow con Id "2687952d-1bcf-4dc4-9886-35c0a2627153"
        Then Se aplican las siguientes reglas de calidad con resultado
          | OT.RF.Enterprise_EnterpriseCompanyActivity.company_activity_id.PR.B.Completeness.PT.001      | KO |
          | OT.RF.Enterprise_EnterpriseCompanyActivity.company_global_id.PR.B.Completeness.PT.001        | KO |
          | OT.RF.Enterprise_EnterpriseCompanyActivity.isic_code_description.PR.B.Completeness.PT.001    | KO |
          | OT.RF.Enterprise_EnterpriseCompanyActivity.isic_code.PR.B.Completeness.PT.001                | KO |

    #####################################################################################
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-address' con gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.company_address', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_address'

      When Se ejecuta el workflow con Id "5bf6da46-471f-42c4-91e7-99b53e2a1b97"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyAddress.building_name.PR.B.Completeness.PT.001                  | OK |
        | OT.RF.Enterprise_EnterpriseCompanyAddress.company_address_id.PR.B.Completeness.PT.001             | OK |
        | OT.RF.Enterprise_EnterpriseCompanyAddress.company_address_type_id.PR.B.Completeness.PT.001        | OK |
        | OT.RF.Enterprise_EnterpriseCompanyAddress.company_global_id.PR.B.Completeness.PT.001              | OK |
        | OT.RF.Enterprise_EnterpriseCompanyAddress.country_identification.PR.B.Completeness.PT.001         | OK |
        | OT.RF.Enterprise_EnterpriseCompanyAddress.country.PR.B.Completeness.PT.001                        | OK |
        | OT.RF.Enterprise_EnterpriseCompanyAddress.department.PR.B.Completeness.PT.001                     | OK |
        | OT.RF.Enterprise_EnterpriseCompanyAddress.district_name.PR.B.Completeness.PT.001                  | OK |
        | OT.RF.Enterprise_EnterpriseCompanyAddress.floor.PR.B.Completeness.PT.001                          | OK |
        | OT.RF.Enterprise_EnterpriseCompanyAddress.location.PR.B.Completeness.PT.001                       | OK |
        | OT.RF.Enterprise_EnterpriseCompanyAddress.post_code_identification.PR.B.Completeness.PT.001       | OK |
        | OT.RF.Enterprise_EnterpriseCompanyAddress.post_office_box.PR.B.Completeness.PT.001                | OK |
        | OT.RF.Enterprise_EnterpriseCompanyAddress.province.PR.B.Completeness.PT.001                       | OK |
        | OT.RF.Enterprise_EnterpriseCompanyAddress.region_identification.PR.B.Completeness.PT.001          | OK |
        | OT.RF.Enterprise_EnterpriseCompanyAddress.state.PR.B.Completeness.PT.001                          | OK |
        | OT.RF.Enterprise_EnterpriseCompanyAddress.street_building_identification.PR.B.Completeness.PT.001 | OK |
        | OT.RF.Enterprise_EnterpriseCompanyAddress.street_name.PR.B.Completeness.PT.001                    | OK |
        | OT.RF.Enterprise_EnterpriseCompanyAddress.subdepartment.PR.B.Completeness.PT.001                  | OK |
        | OT.RF.Enterprise_EnterpriseCompanyAddress.town_name.PR.B.Completeness.PT.001                      | OK |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_et_rw_enterprise_company-address" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_address"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_et_rw_enterprise_company-address" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot_et_rw_enterprise_company-address"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_et_rw_enterprise_company-address"


    @Manual
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-address con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "5bf6da46-471f-42c4-91e7-99b53e2a1b97"
      Then Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyAddress.building_name.PR.B.Completeness.PT.001                  | KO |
        | OT.RF.Enterprise_EnterpriseCompanyAddress.company_address_id.PR.B.Completeness.PT.001             | KO |
        | OT.RF.Enterprise_EnterpriseCompanyAddress.company_address_type_id.PR.B.Completeness.PT.001        | KO |
        | OT.RF.Enterprise_EnterpriseCompanyAddress.company_global_id.PR.B.Completeness.PT.001              | KO |
        | OT.RF.Enterprise_EnterpriseCompanyAddress.country_identification.PR.B.Completeness.PT.001         | KO |
        | OT.RF.Enterprise_EnterpriseCompanyAddress.country.PR.B.Completeness.PT.001                        | KO |
        | OT.RF.Enterprise_EnterpriseCompanyAddress.department.PR.B.Completeness.PT.001                     | KO |
        | OT.RF.Enterprise_EnterpriseCompanyAddress.district_name.PR.B.Completeness.PT.001                  | KO |
        | OT.RF.Enterprise_EnterpriseCompanyAddress.floor.PR.B.Completeness.PT.001                          | KO |
        | OT.RF.Enterprise_EnterpriseCompanyAddress.location.PR.B.Completeness.PT.001                       | KO |
        | OT.RF.Enterprise_EnterpriseCompanyAddress.post_code_identification.PR.B.Completeness.PT.001       | KO |
        | OT.RF.Enterprise_EnterpriseCompanyAddress.post_office_box.PR.B.Completeness.PT.001                | KO |
        | OT.RF.Enterprise_EnterpriseCompanyAddress.province.PR.B.Completeness.PT.001                       | KO |
        | OT.RF.Enterprise_EnterpriseCompanyAddress.region_identification.PR.B.Completeness.PT.001          | KO |
        | OT.RF.Enterprise_EnterpriseCompanyAddress.state.PR.B.Completeness.PT.001                          | KO |
        | OT.RF.Enterprise_EnterpriseCompanyAddress.street_building_identification.PR.B.Completeness.PT.001 | KO |
        | OT.RF.Enterprise_EnterpriseCompanyAddress.street_name.PR.B.Completeness.PT.001                    | KO |
        | OT.RF.Enterprise_EnterpriseCompanyAddress.subdepartment.PR.B.Completeness.PT.001                  | KO |
        | OT.RF.Enterprise_EnterpriseCompanyAddress.town_name.PR.B.Completeness.PT.001                      | KO |

    #####################################################################################
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-address-type' con gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.company_address_type', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_adress_type'

      When Se ejecuta el workflow con Id "ade52773-1fd9-4c03-ac45-46245cb1ec0d"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyAddressType.company_address_type_id.PR.B.Completeness.PT.001    | OK |
        | OT.RF.Enterprise_EnterpriseCompanyAddressType.description.PR.B.Completeness.PT.001                | OK |
        | OT.RF.Enterprise_EnterpriseCompanyAddressType.description.PR.B.Completeness.PT.002                | OK |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_address_type" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_address_type"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_address_type" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_address_type"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_address_type"


    @Manual
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-address-type con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "ade52773-1fd9-4c03-ac45-46245cb1ec0d"
      Then Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyAddressType.company_address_type_id.PR.B.Completeness.PT.001    | KO |
        | OT.RF.Enterprise_EnterpriseCompanyAddressType.description.PR.B.Completeness.PT.001                | KO |
        | OT.RF.Enterprise_EnterpriseCompanyAddressType.description.PR.B.Completeness.PT.002                | KO |

    #####################################################################################
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-cmc' con gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.company_cmc', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_cmc'

      When Se ejecuta el workflow con Id "1c5e9add-4b52-44ff-b17b-929b11641f1e"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyCmc.cmc.PR.B.Completeness.PT.001                                | OK |
        | OT.RF.Enterprise_EnterpriseCompanyCmc.company_global_id.PR.B.Completeness.PT.001                  | OK |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_cmc" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_cmc"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_cmc" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_cmc"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_cmc"


    @Manual
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-cmc con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "1c5e9add-4b52-44ff-b17b-929b11641f1e"
      Then Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyCmc.cmc.PR.B.Completeness.PT.001                                | KO |
        | OT.RF.Enterprise_EnterpriseCompanyCmc.company_global_id.PR.B.Completeness.PT.001                  | KO |

    #####################################################################################
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-contact' con gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.company_contact', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_contact'

      When Se ejecuta el workflow con Id "3c1cb3fc-74fd-419a-b11a-b335db539cd4"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyContact.company_contact_id.PR.B.Completeness.PT.001             | OK |
        | OT.RF.Enterprise_EnterpriseCompanyContact.company_contact_type_id.PR.B.Completeness.PT.001        | OK |
        | OT.RF.Enterprise_EnterpriseCompanyContact.company_global_id.PR.B.Completeness.PT.001              | OK |
        | OT.RF.Enterprise_EnterpriseCompanyContact.contact_data.PR.B.Completeness.PT.001                   | OK |
        | OT.RF.Enterprise_EnterpriseCompanyContact.is_preferred.PR.B.Completeness.PT.001                   | OK |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_contact" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_contact"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_contact" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_contact"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_contact"


    @Manual
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-contact con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "3c1cb3fc-74fd-419a-b11a-b335db539cd4"
      Then Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyContact.company_contact_id.PR.B.Completeness.PT.001             | KO |
        | OT.RF.Enterprise_EnterpriseCompanyContact.company_contact_type_id.PR.B.Completeness.PT.001        | KO |
        | OT.RF.Enterprise_EnterpriseCompanyContact.company_global_id.PR.B.Completeness.PT.001              | KO |
        | OT.RF.Enterprise_EnterpriseCompanyContact.contact_data.PR.B.Completeness.PT.001                   | KO |
        | OT.RF.Enterprise_EnterpriseCompanyContact.is_preferred.PR.B.Completeness.PT.001                   | KO |

    #####################################################################################
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-contact-type' con gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.company_contact_type', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_contact_type'

      When Se ejecuta el workflow con Id "fe879014-4caf-4672-906a-4a41d1720455"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyContactType.company_contact_type_id.PR.B.Completeness.PT.001    | OK |
        | OT.RF.Enterprise_EnterpriseCompanyContactType.description.PR.B.Completeness.PT.001                | OK |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_contact_type" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_contact_type"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_contact_type" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_contact_type"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_contact_type"


    @Manual
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-contact-type con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "fe879014-4caf-4672-906a-4a41d1720455"
      Then Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyContactType.company_contact_type_id.PR.B.Completeness.PT.001    | KO |
        | OT.RF.Enterprise_EnterpriseCompanyContactType.description.PR.B.Completeness.PT.001                | KO |


    #####################################################################################
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-country' con gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.company_country', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_country'

      When Se ejecuta el workflow con Id "b4d75079-7350-4765-b92e-b45a893b43b4"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyCountry.company_global_id.PR.B.Completeness.PT.001    | OK |
        | OT.RF.Enterprise_EnterpriseCompanyCountry.country_id.PR.B.Completeness.PT.001           | OK |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_country" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_country"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_country" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_country"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_country"


    @Manual
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-country con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "b4d75079-7350-4765-b92e-b45a893b43b4"
      Then Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyCountry.company_global_id.PR.B.Completeness.PT.001    | KO |
        | OT.RF.Enterprise_EnterpriseCompanyCountry.country_id.PR.B.Completeness.PT.001           | KO |

    #####################################################################################
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-identification' con gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.company_identification', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_identification'

      When Se ejecuta el workflow con Id "cbca027d-8776-4962-8be3-ebbcb5e689a2"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyIdentification.company_global_id.PR.B.Completeness.PT.001         | OK |
        | OT.RF.Enterprise_EnterpriseCompanyIdentification.company_identification_id.PR.B.Completeness.PT.001 | OK |
        | OT.RF.Enterprise_EnterpriseCompanyIdentification.document_number.PR.B.Completeness.PT.001           | OK |
        | OT.RF.Enterprise_EnterpriseCompanyIdentification.document_type.PR.B.Completeness.PT.001             | OK |
        | OT.RF.Enterprise_EnterpriseCompanyIdentification.document_type.PR.B.Completeness.PT.002             | OK |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_identification" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_identification"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_identification" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_identification"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_identification"


    @Manual
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-identification con gobierno del dato negativo

    Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "cbca027d-8776-4962-8be3-ebbcb5e689a2"
      Then Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyIdentification.company_global_id.PR.B.Completeness.PT.001         | KO |
        | OT.RF.Enterprise_EnterpriseCompanyIdentification.company_identification_id.PR.B.Completeness.PT.001 | KO |
        | OT.RF.Enterprise_EnterpriseCompanyIdentification.document_number.PR.B.Completeness.PT.001           | KO |
        | OT.RF.Enterprise_EnterpriseCompanyIdentification.document_type.PR.B.Completeness.PT.001             | KO |
        | OT.RF.Enterprise_EnterpriseCompanyIdentification.document_type.PR.B.Completeness.PT.002             | KO |

    #####################################################################################
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-permission' con gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.company_permission', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_permission'

      When Se ejecuta el workflow con Id "5c2103e4-4fc6-46cd-8707-245491eb2ee2"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyPermission.description.PR.B.Completeness.PT.001    | OK |
        | OT.RF.Enterprise_EnterpriseCompanyPermission.permissioin_id.PR.B.Completeness.PT.001 | OK |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_permission" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_permission"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_permission" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_permission"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_permission"


    @Manual
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-permission con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

        When Se ejecuta el workflow con Id "5c2103e4-4fc6-46cd-8707-245491eb2ee2"
        Then Se aplican las siguientes reglas de calidad con resultado
          | OT.RF.Enterprise_EnterpriseCompanyPermission.description.PR.B.Completeness.PT.001    | KO |
          | OT.RF.Enterprise_EnterpriseCompanyPermission.permissioin_id.PR.B.Completeness.PT.001 | KO |

    #####################################################################################
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-resource' con gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.company_resource', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_resource'

      When Se ejecuta el workflow con Id "9b562ae7-f65c-4d99-a6e4-6df4b684b38e"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyResource.cmc.PR.B.Completeness.PT.001                      | OK |
        | OT.RF.Enterprise_EnterpriseCompanyResource.company_resource_id.PR.B.Completeness.PT.001      | OK |
        | OT.RF.Enterprise_EnterpriseCompanyResource.company_resource_type_id.PR.B.Completeness.PT.001 | OK |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_resource" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_resource"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_resource" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_resource"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_resource"


    @Manual
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-resource con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

        When Se ejecuta el workflow con Id "9b562ae7-f65c-4d99-a6e4-6df4b684b38e"
        Then Se aplican las siguientes reglas de calidad con resultado
          | OT.RF.Enterprise_EnterpriseCompanyResource.cmc.PR.B.Completeness.PT.001                      | KO |
          | OT.RF.Enterprise_EnterpriseCompanyResource.company_resource_id.PR.B.Completeness.PT.001      | KO |
          | OT.RF.Enterprise_EnterpriseCompanyResource.company_resource_type_id.PR.B.Completeness.PT.001 | KO |

    #####################################################################################
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-resource-type' con gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.company_resource_type', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_resource_type'

      When Se ejecuta el workflow con Id "00cf7e85-51a3-4ebe-ad60-ff340aba9ef6"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyResourceType.company_resource_type_id.PR.B.Completeness.PT.001       | OK |
        | OT.RF.Enterprise_EnterpriseCompanyResourceType.description.PR.B.Completeness.PT.001                    | OK |
        | OT.RF.Enterprise_EnterpriseCompanyResourceType.name.PR.B.Completeness.PT.001                           | OK |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_resource_type" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_resource_type"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_resource_type" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_resource_type"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_resource_type"


    @Manual
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-resource-type' con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "00cf7e85-51a3-4ebe-ad60-ff340aba9ef6"
      Then Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyResourceType.company_resource_type_id.PR.B.Completeness.PT.001       | KO |
        | OT.RF.Enterprise_EnterpriseCompanyResourceType.description.PR.B.Completeness.PT.001                    | KO |
        | OT.RF.Enterprise_EnterpriseCompanyResourceType.name.PR.B.Completeness.PT.001                           | KO |


    #####################################################################################
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-user' con gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.company_user', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_user'

      When Se ejecuta el workflow con Id "a89784ee-5d5d-475d-be8a-85589465d61d"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyUser.cmc.PR.B.Completeness.PT.001                     | OK |
        | OT.RF.Enterprise_EnterpriseCompanyUser.company_user_id.PR.B.Completeness.PT.001         | OK |
        | OT.RF.Enterprise_EnterpriseCompanyUser.internal_represent_user.PR.B.Completeness.PT.001 | OK |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_user" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_user"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_user" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_user"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_user"


    @Manual
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-user' con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "a89784ee-5d5d-475d-be8a-85589465d61d"
      Then Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyUser.cmc.PR.B.Completeness.PT.001                     | KO |
        | OT.RF.Enterprise_EnterpriseCompanyUser.company_user_id.PR.B.Completeness.PT.001         | KO |
        | OT.RF.Enterprise_EnterpriseCompanyUser.internal_represent_user.PR.B.Completeness.PT.001 | KO |

    #####################################################################################
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-user-permission-resource' con gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.company_user_permission_company_resource', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_user_permission_resource'

      When Se ejecuta el workflow con Id "5086e8da-3006-4a83-b399-f14ae6bfd5ef"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyUserPermissionResource.company_resource_id.PR.B.Completeness.PT.001                                | OK |
        | OT.RF.Enterprise_EnterpriseCompanyUserPermissionResource.company_user_permission_company_resource_id.PR.B.Completeness.PT.001        | OK |
        | OT.RF.Enterprise_EnterpriseCompanyUserPermissionResource.permission_id.PR.B.Completeness.PT.001                                      | OK |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_user_permission_resource" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_user_permission_resource"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_user_permission_resource" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_user_permission_resource"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_user_permission_resource"


    @Manual
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-user-permission-resource' con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "5086e8da-3006-4a83-b399-f14ae6bfd5ef"
      Then Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyUserPermissionResource.company_resource_id.PR.B.Completeness.PT.001                                | KO |
        | OT.RF.Enterprise_EnterpriseCompanyUserPermissionResource.company_user_permission_company_resource_id.PR.B.Completeness.PT.001        | KO |
        | OT.RF.Enterprise_EnterpriseCompanyUserPermissionResource.permission_id.PR.B.Completeness.PT.001                                      | KO |

    #####################################################################################
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-country' con gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.country', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_country'

      When Se ejecuta el workflow con Id "3945861c-a58e-4589-a706-72595dc963ee"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCountry.country_id.PR.B.Completeness.PT.001       | OK |
        | OT.RF.Enterprise_EnterpriseCountry.name.PR.B.Completeness.PT.001             | OK |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_et_rw_enterprise_country" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_country"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_et_rw_enterprise_country" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot_et_rw_enterprise_country"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_et_rw_enterprise_country"


    @Manual
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-country' con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

        When Se ejecuta el workflow con Id "3945861c-a58e-4589-a706-72595dc963ee"
        Then Se aplican las siguientes reglas de calidad con resultado
          | OT.RF.Enterprise_EnterpriseCountry.country_id.PR.B.Completeness.PT.001       | KO |
          | OT.RF.Enterprise_EnterpriseCountry.name.PR.B.Completeness.PT.001             | KO |