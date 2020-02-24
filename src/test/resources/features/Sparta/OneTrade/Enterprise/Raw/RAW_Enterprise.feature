Feature: RAW_Enterprise

  Como usuario quiero ejecutar los flujos de Sparta pertenecientes al dominio de Enterprise, en el área de RAW y gobernando los datos para poder promociarlos al área de TRUSTED

  Background:
    Given Sparta operativo en la url "https://gts-sparta.sgcto-int.stratio.com/gts-sparta/appStatus"

    #####################################################################################
    @sparta_enterprise_raw
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company' sin gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.company', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company'

      Then Se ejecuta el workflow con Id "9feeef75-3a6a-450b-b78e-456cc45eb6ca"

    @sparta_enterprise_qrules_ok
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company' con gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.company', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company'

      When Se ejecuta el workflow con Id "9feeef75-3a6a-450b-b78e-456cc45eb6ca"
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

    @sparta_enterprise_qrules_ko
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company' con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "9feeef75-3a6a-450b-b78e-456cc45eb6ca"
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

    @sparta_enterprise_raw
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-activity' sin gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.company_activity', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_activity'

      Then Se ejecuta el workflow con Id "c5db523f-a8d1-4a2b-b5e6-09e1df39037b"

    @sparta_enterprise_qrules_ok
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-activity' con gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.company_activity', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_activity'

      When Se ejecuta el workflow con Id "c5db523f-a8d1-4a2b-b5e6-09e1df39037b"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyActivity.company_activity_id.PR.B.Completeness.PT.001      | OK |
        | OT.RF.Enterprise_EnterpriseCompanyActivity.company_global_id.PR.B.Completeness.PT.001        | OK |
        | OT.RF.Enterprise_EnterpriseCompanyActivity.isic_code_description.PR.B.Completeness.PT.001    | OK |
        | OT.RF.Enterprise_EnterpriseCompanyActivity.isic_code.PR.B.Completeness.PT.001                | OK |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_activity" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_activity"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_activity" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_activity"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_activity"


    @sparta_enterprise_qrules_ok
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-activity' con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "c5db523f-a8d1-4a2b-b5e6-09e1df39037b"
      Then Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyActivity.company_activity_id.PR.B.Completeness.PT.001      | KO |
        | OT.RF.Enterprise_EnterpriseCompanyActivity.company_global_id.PR.B.Completeness.PT.001        | KO |
        | OT.RF.Enterprise_EnterpriseCompanyActivity.isic_code_description.PR.B.Completeness.PT.001    | KO |
        | OT.RF.Enterprise_EnterpriseCompanyActivity.isic_code.PR.B.Completeness.PT.001                | KO |

    #####################################################################################
    @sparta_enterprise_raw
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-address' sin gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.company_address', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_address'

      Then Se ejecuta el workflow con Id "9f55d555-5074-4cae-af1f-a457a063c433"

    @sparta_enterprise_qrules_ok
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-address' con gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.company_address', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_address'

      When Se ejecuta el workflow con Id "9f55d555-5074-4cae-af1f-a457a063c433"
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

    @sparta_enterprise_qrules_ok
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-address con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "9f55d555-5074-4cae-af1f-a457a063c433"
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
    @sparta_enterprise_raw
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-address-type' sin gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.company_address_type', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_adress_type'

      Then Se ejecuta el workflow con Id "902cc796-bb01-4879-86f8-f76072e2d5af"

    @sparta_enterprise_qrules_ok
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-address-type' con gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.company_address_type', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_adress_type'

      When Se ejecuta el workflow con Id "902cc796-bb01-4879-86f8-f76072e2d5af"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyAddressType.company_address_type_id.PR.B.Completeness.PT.001    | OK |
        | OT.RF.Enterprise_EnterpriseCompanyAddressType.description.PR.B.Completeness.PT.001                | OK |
        | OT.RF.Enterprise_EnterpriseCompanyAddressType.description.PR.B.Completeness.PT.002                | OK |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_address_type" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_address_type"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_address_type" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_address_type"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_address_type"


    @sparta_enterprise_qrules_ko
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-address-type con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "902cc796-bb01-4879-86f8-f76072e2d5af"
      Then Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyAddressType.company_address_type_id.PR.B.Completeness.PT.001    | KO |
        | OT.RF.Enterprise_EnterpriseCompanyAddressType.description.PR.B.Completeness.PT.001                | KO |
        | OT.RF.Enterprise_EnterpriseCompanyAddressType.description.PR.B.Completeness.PT.002                | KO |

    #####################################################################################
    @sparta_enterprise_raw
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-cmc' sin gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.company_cmc', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_cmc'

      Then Se ejecuta el workflow con Id "482b4cff-2e5d-4ae3-960c-ffbafbf9e56f"

    @sparta_enterprise_qrules_ok
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-cmc' con gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.company_cmc', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_cmc'

      When Se ejecuta el workflow con Id "482b4cff-2e5d-4ae3-960c-ffbafbf9e56f"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyCmc.cmc.PR.B.Completeness.PT.001                                | OK |
        | OT.RF.Enterprise_EnterpriseCompanyCmc.company_global_id.PR.B.Completeness.PT.001                  | OK |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_cmc" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_cmc"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_cmc" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_cmc"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_cmc"

    @sparta_enterprise_qrules_ko
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-cmc con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "482b4cff-2e5d-4ae3-960c-ffbafbf9e56f"
      Then Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyCmc.cmc.PR.B.Completeness.PT.001                                | KO |
        | OT.RF.Enterprise_EnterpriseCompanyCmc.company_global_id.PR.B.Completeness.PT.001                  | KO |

    #####################################################################################
    @sparta_enterprise
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-contact' sin gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.company_contact', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_contact'

      Then Se ejecuta el workflow con Id "b071908b-7514-478e-a5db-17c7ad87e828"

    @sparta_enterprise_qrules_ok
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-contact' con gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.company_contact', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_contact'

      When Se ejecuta el workflow con Id "b071908b-7514-478e-a5db-17c7ad87e828"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyContact.company_contact_id.PR.B.Completeness.PT.001             | OK |
        | OT.RF.Enterprise_EnterpriseCompanyContact.company_contact_type_id.PR.B.Completeness.PT.001        | OK |
        | OT.RF.Enterprise_EnterpriseCompanyContact.company_global_id.PR.B.Completeness.PT.001              | OK |
        | OT.RF.Enterprise_EnterpriseCompanyContact.contact_data.PR.B.Completeness.PT.001                   | OK |
        | OT.RF.Enterprise_EnterpriseCompanyContact.is_preferred.PR.B.Completeness.PT.001                   | OK |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_contact" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_contact"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_contact" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_contact"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_contact"

    @sparta_enterprise_qrules_ko
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-contact con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "b071908b-7514-478e-a5db-17c7ad87e828"
      Then Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyContact.company_contact_id.PR.B.Completeness.PT.001             | KO |
        | OT.RF.Enterprise_EnterpriseCompanyContact.company_contact_type_id.PR.B.Completeness.PT.001        | KO |
        | OT.RF.Enterprise_EnterpriseCompanyContact.company_global_id.PR.B.Completeness.PT.001              | KO |
        | OT.RF.Enterprise_EnterpriseCompanyContact.contact_data.PR.B.Completeness.PT.001                   | KO |
        | OT.RF.Enterprise_EnterpriseCompanyContact.is_preferred.PR.B.Completeness.PT.001                   | KO |

    #####################################################################################
    @sparta_enterprise_raw
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-contact-type' sin gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.company_contact_type', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_contact_type'

      Then Se ejecuta el workflow con Id "64cec261-0eb5-4c82-83f8-2bdabc34fd24"

    @sparta_enterprise_qrules_ok
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-contact-type' con gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.company_contact_type', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_contact_type'

      When Se ejecuta el workflow con Id "64cec261-0eb5-4c82-83f8-2bdabc34fd24"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyContactType.company_contact_type_id.PR.B.Completeness.PT.001    | OK |
        | OT.RF.Enterprise_EnterpriseCompanyContactType.description.PR.B.Completeness.PT.001                | OK |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_contact_type" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_contact_type"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_contact_type" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_contact_type"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_contact_type"

    @sparta_enterprise_qrules_ko
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-contact-type con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "64cec261-0eb5-4c82-83f8-2bdabc34fd24"
      Then Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyContactType.company_contact_type_id.PR.B.Completeness.PT.001    | KO |
        | OT.RF.Enterprise_EnterpriseCompanyContactType.description.PR.B.Completeness.PT.001                | KO |

    #####################################################################################
    @sparta_enterprise_raw
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-country' sin gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.company_country', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_country'

      Then Se ejecuta el workflow con Id "bc1e03ae-130b-468e-b1e4-69a2ceac4e0c"

    @sparta_enterprise_qrules_ok
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-country' con gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.company_country', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_country'

      When Se ejecuta el workflow con Id "bc1e03ae-130b-468e-b1e4-69a2ceac4e0c"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyCountry.company_global_id.PR.B.Completeness.PT.001    | OK |
        | OT.RF.Enterprise_EnterpriseCompanyCountry.country_id.PR.B.Completeness.PT.001           | OK |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_country" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_country"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_country" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_country"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_country"

    @sparta_enterprise_qrules_ko
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-country con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "bc1e03ae-130b-468e-b1e4-69a2ceac4e0c"
      Then Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyCountry.company_global_id.PR.B.Completeness.PT.001    | KO |
        | OT.RF.Enterprise_EnterpriseCompanyCountry.country_id.PR.B.Completeness.PT.001           | KO |

    #####################################################################################
    @sparta_enterprise_raw
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-identification' sin gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.company_identification', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_identification'

      Then Se ejecuta el workflow con Id "b13b845f-2fa3-4dff-9d3a-e287a410fa96"

    @sparta_enterprise_qrules_ok
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-identification' con gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.company_identification', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_identification'

      When Se ejecuta el workflow con Id "b13b845f-2fa3-4dff-9d3a-e287a410fa96"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyIdentification.company_global_id.PR.B.Completeness.PT.001         | OK |
        | OT.RF.Enterprise_EnterpriseCompanyIdentification.company_identification_id.PR.B.Completeness.PT.001 | OK |
        | OT.RF.Enterprise_EnterpriseCompanyIdentification.document_number.PR.B.Completeness.PT.001           | OK |
        | OT.RF.Enterprise_EnterpriseCompanyIdentification.document_type.PR.B.Completeness.PT.001             | OK |
        | OT.RF.Enterprise_EnterpriseCompanyIdentification.document_type.PR.B.Completeness.PT.002             | OK |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_identification" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_identification"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_identification" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_identification"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_identification"

    @sparta_enterprise_qrules_ko
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-identification con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "b13b845f-2fa3-4dff-9d3a-e287a410fa96"
      Then Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyIdentification.company_global_id.PR.B.Completeness.PT.001         | KO |
        | OT.RF.Enterprise_EnterpriseCompanyIdentification.company_identification_id.PR.B.Completeness.PT.001 | KO |
        | OT.RF.Enterprise_EnterpriseCompanyIdentification.document_number.PR.B.Completeness.PT.001           | KO |
        | OT.RF.Enterprise_EnterpriseCompanyIdentification.document_type.PR.B.Completeness.PT.001             | KO |
        | OT.RF.Enterprise_EnterpriseCompanyIdentification.document_type.PR.B.Completeness.PT.002             | KO |

    #####################################################################################
    @sparta_enterprise_raw
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-permission' sin gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.company_permission', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_permission'

      Then Se ejecuta el workflow con Id "94fb415e-caad-45dd-bd6c-8737a3b8db66"

    @sparta_enterprise_qrules_ok
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-permission' con gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.company_permission', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_permission'

      When Se ejecuta el workflow con Id "94fb415e-caad-45dd-bd6c-8737a3b8db66"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyPermission.description.PR.B.Completeness.PT.001    | OK |
        | OT.RF.Enterprise_EnterpriseCompanyPermission.permissioin_id.PR.B.Completeness.PT.001 | OK |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_permission" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_permission"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_permission" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_permission"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_permission"

    @sparta_enterprise_qrules_ko
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-permission con gobierno del dato negativo

        Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

        When Se ejecuta el workflow con Id "94fb415e-caad-45dd-bd6c-8737a3b8db66"
        Then Se aplican las siguientes reglas de calidad con resultado
          | OT.RF.Enterprise_EnterpriseCompanyPermission.description.PR.B.Completeness.PT.001    | KO |
          | OT.RF.Enterprise_EnterpriseCompanyPermission.permissioin_id.PR.B.Completeness.PT.001 | KO |

    #####################################################################################
    @sparta_enterprise_raw
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-resource' sin gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.company_resource', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_resource'

      Then Se ejecuta el workflow con Id "a4e5df9e-c6f8-4f35-83c2-afc85e18a73b"

    @sparta_enterprise_qrules_ok
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-resource' con gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.company_resource', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_resource'

      When Se ejecuta el workflow con Id "a4e5df9e-c6f8-4f35-83c2-afc85e18a73b"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyResource.cmc.PR.B.Completeness.PT.001                      | OK |
        | OT.RF.Enterprise_EnterpriseCompanyResource.company_resource_id.PR.B.Completeness.PT.001      | OK |
        | OT.RF.Enterprise_EnterpriseCompanyResource.company_resource_type_id.PR.B.Completeness.PT.001 | OK |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_resource" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_resource"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_resource" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_resource"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_resource"

    @sparta_enterprise_qrules_ko
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-resource con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "a4e5df9e-c6f8-4f35-83c2-afc85e18a73b"
      Then Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyResource.cmc.PR.B.Completeness.PT.001                      | KO |
        | OT.RF.Enterprise_EnterpriseCompanyResource.company_resource_id.PR.B.Completeness.PT.001      | KO |
        | OT.RF.Enterprise_EnterpriseCompanyResource.company_resource_type_id.PR.B.Completeness.PT.001 | KO |

    #####################################################################################
    @sparta_enterprise_raw
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-resource-type' sin gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.company_resource_type', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_resource_type'

      Then Se ejecuta el workflow con Id "59a6e169-62d8-49e0-8db0-0164c40be4f5"

    @sparta_enterprise_qrules_ok
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-resource-type' con gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.company_resource_type', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_resource_type'

      When Se ejecuta el workflow con Id "59a6e169-62d8-49e0-8db0-0164c40be4f5"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyResourceType.company_resource_type_id.PR.B.Completeness.PT.001       | OK |
        | OT.RF.Enterprise_EnterpriseCompanyResourceType.description.PR.B.Completeness.PT.001                    | OK |
        | OT.RF.Enterprise_EnterpriseCompanyResourceType.name.PR.B.Completeness.PT.001                           | OK |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_resource_type" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_resource_type"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_resource_type" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_resource_type"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_resource_type"

    @sparta_enterprise_qrules_ok
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-resource-type' con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "59a6e169-62d8-49e0-8db0-0164c40be4f5"
      Then Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyResourceType.company_resource_type_id.PR.B.Completeness.PT.001       | KO |
        | OT.RF.Enterprise_EnterpriseCompanyResourceType.description.PR.B.Completeness.PT.001                    | KO |
        | OT.RF.Enterprise_EnterpriseCompanyResourceType.name.PR.B.Completeness.PT.001                           | KO |

    #####################################################################################
    @sparta_enterprise_raw
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-user' sin gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.company_user', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_user'

      Then Se ejecuta el workflow con Id "40756830-aece-488c-938f-3a4ad9ffea28"

    @sparta_enterprise_qrules_ok
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-user' con gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.company_user', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_user'

      When Se ejecuta el workflow con Id "40756830-aece-488c-938f-3a4ad9ffea28"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyUser.cmc.PR.B.Completeness.PT.001                     | OK |
        | OT.RF.Enterprise_EnterpriseCompanyUser.company_user_id.PR.B.Completeness.PT.001         | OK |
        | OT.RF.Enterprise_EnterpriseCompanyUser.internal_represent_user.PR.B.Completeness.PT.001 | OK |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_user" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_user"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_user" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot_et_rw_enterprise_company_user"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot_et_rw_enterprise_company_user"

    @sparta_enterprise_qrules_ko
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-user' con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "40756830-aece-488c-938f-3a4ad9ffea28"
      Then Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyUser.cmc.PR.B.Completeness.PT.001                     | KO |
        | OT.RF.Enterprise_EnterpriseCompanyUser.company_user_id.PR.B.Completeness.PT.001         | KO |
        | OT.RF.Enterprise_EnterpriseCompanyUser.internal_represent_user.PR.B.Completeness.PT.001 | KO |

    #####################################################################################
    @sparta_enterprise_raw
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-user-permission-resource' sin gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.company_user_permission_company_resource', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_user_permission_resource'

      Then Se ejecuta el workflow con Id "5086e8da-3006-4a83-b399-f14ae6bfd5ef"

    @sparta_enterprise_qrules_ok
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

    @sparta_enterprise_qrules_ko
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-company-user-permission-resource' con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "5086e8da-3006-4a83-b399-f14ae6bfd5ef"
      Then Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCompanyUserPermissionResource.company_resource_id.PR.B.Completeness.PT.001                                | KO |
        | OT.RF.Enterprise_EnterpriseCompanyUserPermissionResource.company_user_permission_company_resource_id.PR.B.Completeness.PT.001        | KO |
        | OT.RF.Enterprise_EnterpriseCompanyUserPermissionResource.permission_id.PR.B.Completeness.PT.001                                      | KO |

    #####################################################################################
    @sparta_enterprise_raw
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-country' con gobierno del dato

      El workflow recoge los datos de la tabla de Postgres 'onetradeenterprises.country', selecciona las columnas necesarias,
      añade el TS y vuelva los datos a la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_country'

      Then Se ejecuta el workflow con Id "3945861c-a58e-4589-a706-72595dc963ee"

    @sparta_enterprise_qrules_ok
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

    @sparta_enterprise_qrules_ok
    Scenario: Ejecución del workflow 'ot-et-rw-enterprise-country' con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "3945861c-a58e-4589-a706-72595dc963ee"
      Then Se aplican las siguientes reglas de calidad con resultado
        | OT.RF.Enterprise_EnterpriseCountry.country_id.PR.B.Completeness.PT.001       | KO |
        | OT.RF.Enterprise_EnterpriseCountry.name.PR.B.Completeness.PT.001             | KO |