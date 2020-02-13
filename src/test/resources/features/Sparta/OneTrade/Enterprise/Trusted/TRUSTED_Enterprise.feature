Feature: TRUSTED_Enterprise

  Como usuario quiero ejecutar los flujos de Sparta pertenecientes al dominio de Enterprise, en el área de TRSUTED y gobernando los datos para poder promociarlos al área de ONEVIEW

  Background:
    Given Sparta operativo en la url "https://gts-sparta.sgcto-int.stratio.com/gts-sparta/swagger/appStatus"

    #####################################################################################
    Scenario: Ejecución del workflow 'ot-et-tt-enterprise-company' con gobierno del dato

      El workflow recoge los datos de la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company, selecciona las columnas necesarias,
      descarta los datos que no cumplen las reglas de validacion y vuelca los datos en el hdfs asociado al area de TRUSTED

      When Se ejecuta el workflow con Id "69301367-8f13-4f2e-8366-eb6ed3e9586f"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OK                                                                                       |
        | OT.T.Enterprise_EnterpriseCompany.agent.PR.B.Completeness.MF.001                         |
        | OT.T.Enterprise_EnterpriseCompany.company_global_id.PR.B.Completeness.MF.001             |
        | OT.T.Enterprise_EnterpriseCompany.company_name.PR.B.Completeness.MF.001                  |
        | OT.T.Enterprise_EnterpriseCompany.country_incorporation.PR.B.Completeness.MF.001         |
        | OT.T.Enterprise_EnterpriseCompany.entity.PR.B.Completeness.MF.001                        |
        | OT.T.Enterprise_EnterpriseCompany.identification_legal_customer.PR.B.Completeness.MF.001 |
        | OT.T.Enterprise_EnterpriseCompany.ind_cash_nexus.PR.B.Completeness.MF.001                |
        | OT.T.Enterprise_EnterpriseCompany.ind_virtual_company.PR.B.Completeness.MF.001           |
        | OT.T.Enterprise_EnterpriseCompany.trade_name.PR.B.Completeness.MF.001                    |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot-et-tt-enterprise-company" con el hdfs-output del workflow "hdfs://gts-hdfs//gts/data/trusted/onetrade/enterprise/enterprise_company"
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot-et-tt-enterprise-company_bic_refusals" con el hdfs-output del workflow "hdfs://gts-hdfs//gts/data/trusted/onetrade/enterprise/enterprise_company_bic_refusals"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot-et-tt-enterprise-company" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot-et-rw-enterprise-company"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot-et-tt-enterprise-company_bic_refusals" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot-et-rw-enterprise-company_bic_refusals"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot-et-tt-enterprise-company"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot-et-tt-enterprise-company_bic_refusals"


    @Manual
    Scenario: Ejecución del workflow 'ot-et-tt-enterprise-company' con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "69301367-8f13-4f2e-8366-eb6ed3e9586f"
      Then Se aplican las siguientes reglas de calidad con resultado
        | KO                                                                                       |
        | OT.T.Enterprise_EnterpriseCompany.agent.PR.B.Completeness.MF.001                         |
        | OT.T.Enterprise_EnterpriseCompany.company_global_id.PR.B.Completeness.MF.001             |
        | OT.T.Enterprise_EnterpriseCompany.company_name.PR.B.Completeness.MF.001                  |
        | OT.T.Enterprise_EnterpriseCompany.country_incorporation.PR.B.Completeness.MF.001         |
        | OT.T.Enterprise_EnterpriseCompany.entity.PR.B.Completeness.MF.001                        |
        | OT.T.Enterprise_EnterpriseCompany.identification_legal_customer.PR.B.Completeness.MF.001 |
        | OT.T.Enterprise_EnterpriseCompany.ind_cash_nexus.PR.B.Completeness.MF.001                |
        | OT.T.Enterprise_EnterpriseCompany.ind_virtual_company.PR.B.Completeness.MF.001           |
        | OT.T.Enterprise_EnterpriseCompany.trade_name.PR.B.Completeness.MF.001                    |


    #####################################################################################
    Scenario: Ejecución del workflow 'ot-et-tt-enterprise-company-activity' con gobierno del dato

      El workflow recoge los datos de la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_activity, selecciona las columnas necesarias,
      añade el TS y vuelca los datos en el hdfs asociado al area de TRUSTED

      When Se ejecuta el workflow con Id "832d401b-1727-4d16-b443-8b9a6607cb73"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OK                                                                                       |
        | OT.T.Enterprise_EnterpriseCompanyActivity.company_activity_id.PR.B.Completeness.MF.001   |
        | OT.T.Enterprise_EnterpriseCompanyActivity.company_global_id.PR.B.Completeness.MF.001     |
        | OT.T.Enterprise_EnterpriseCompanyActivity.isic_code.PR.B.Completeness.MF.001             |

      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot-et-tt-enterprise-company-activity" con el hdfs-output del workflow "hdfs://gts-hdfs//gts/data/trusted/onetrade/enterprise/enterprise_company_activity"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot-et-tt-enterprise-company-activity" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot-et-rw-enterprise-company-activity"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot-et-tt-enterprise-company-activity"


    @Manual
    Scenario: Ejecución del workflow 'ot-et-tt-enterprise-company-activity' con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "832d401b-1727-4d16-b443-8b9a6607cb73"
      Then Se aplican las siguientes reglas de calidad con resultado
        | KO                                                                                       |
        | OT.T.Enterprise_EnterpriseCompanyActivity.company_activity_id.PR.B.Completeness.MF.001   |
        | OT.T.Enterprise_EnterpriseCompanyActivity.company_global_id.PR.B.Completeness.MF.001     |
        | OT.T.Enterprise_EnterpriseCompanyActivity.isic_code.PR.B.Completeness.MF.001             |

    #####################################################################################
    Scenario: Ejecución del workflow 'ot-et-tt-enterprise-company-address' con gobierno del dato

      El workflow recoge los datos de la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_address, selecciona las columnas necesarias,
      añade el TS y vuelca los datos en el hdfs asociado al area de TRUSTED

      When Se ejecuta el workflow con Id "a8001fa1-e68f-41a8-bff6-4d544800b1d3"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OK                                                                                               |
        | OT.T.Enterprise_EnterpriseCompanyAddress.building_name.PR.B.Completeness.MF.001                  |
        | OT.T.Enterprise_EnterpriseCompanyAddress.company_address_id.PR.B.Completeness.MF.001             |
        | OT.T.Enterprise_EnterpriseCompanyAddress.company_address_type_id.PR.B.Completeness.MF.001        |
        | OT.T.Enterprise_EnterpriseCompanyAddress.company_global_id.PR.B.Completeness.MF.001              |
        | OT.T.Enterprise_EnterpriseCompanyAddress.country.PR.B.Completeness.MF.001                        |
        | OT.T.Enterprise_EnterpriseCompanyAddress.county_identification.PR.B.Completeness.MF.001          |
        | OT.T.Enterprise_EnterpriseCompanyAddress.department.PR.B.Completeness.MF.001                     |
        | OT.T.Enterprise_EnterpriseCompanyAddress.district_name.PR.B.Completeness.MF.001                  |
        | OT.T.Enterprise_EnterpriseCompanyAddress.floor.PR.B.Completeness.MF.001                          |
        | OT.T.Enterprise_EnterpriseCompanyAddress.location.PR.B.Completeness.MF.001                       |
        | OT.T.Enterprise_EnterpriseCompanyAddress.post_code_identification.PR.B.Completeness.MF.001       |
        | OT.T.Enterprise_EnterpriseCompanyAddress.post_office_box.PR.B.Completeness.MF.001                |
        | OT.T.Enterprise_EnterpriseCompanyAddress.province.PR.B.Completeness.MF.001                       |
        | OT.T.Enterprise_EnterpriseCompanyAddress.region_identification.PR.B.Completeness.MF.001          |
        | OT.T.Enterprise_EnterpriseCompanyAddress.state.PR.B.Completeness.MF.001                          |
        | OT.T.Enterprise_EnterpriseCompanyAddress.street_building_identification.PR.B.Completeness.MF.001 |
        | OT.T.Enterprise_EnterpriseCompanyAddress.street_name.PR.B.Completeness.MF.001                    |
        | OT.T.Enterprise_EnterpriseCompanyAddress.subdepartment.PR.B.Completeness.MF.001                  |
        | OT.T.Enterprise_EnterpriseCompanyAddress.town_name.PR.B.Completeness.MF.001                      |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot-et-tt-enterprise-company-address" con el hdfs-output del workflow "hdfs://gts-hdfs//gts/data/trusted/onetrade/enterprise/enterprise_company_address"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot-et-tt-enterprise-company-address" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot-et-rw-enterprise-company-address"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot-et-tt-enterprise-company-address"


    @Manual
    Scenario: Ejecución del workflow 'ot-et-tt-enterprise-company-address' con gobierno del dato negativo

     Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "a8001fa1-e68f-41a8-bff6-4d544800b1d3"
      Then Se aplican las siguientes reglas de calidad con resultado
        | KO                                                                                               |
        | OT.T.Enterprise_EnterpriseCompanyAddress.building_name.PR.B.Completeness.MF.001                  |
        | OT.T.Enterprise_EnterpriseCompanyAddress.company_address_id.PR.B.Completeness.MF.001             |
        | OT.T.Enterprise_EnterpriseCompanyAddress.company_address_type_id.PR.B.Completeness.MF.001        |
        | OT.T.Enterprise_EnterpriseCompanyAddress.company_global_id.PR.B.Completeness.MF.001              |
        | OT.T.Enterprise_EnterpriseCompanyAddress.country.PR.B.Completeness.MF.001                        |
        | OT.T.Enterprise_EnterpriseCompanyAddress.county_identification.PR.B.Completeness.MF.001          |
        | OT.T.Enterprise_EnterpriseCompanyAddress.department.PR.B.Completeness.MF.001                     |
        | OT.T.Enterprise_EnterpriseCompanyAddress.district_name.PR.B.Completeness.MF.001                  |
        | OT.T.Enterprise_EnterpriseCompanyAddress.floor.PR.B.Completeness.MF.001                          |
        | OT.T.Enterprise_EnterpriseCompanyAddress.location.PR.B.Completeness.MF.001                       |
        | OT.T.Enterprise_EnterpriseCompanyAddress.post_code_identification.PR.B.Completeness.MF.001       |
        | OT.T.Enterprise_EnterpriseCompanyAddress.post_office_box.PR.B.Completeness.MF.001                |
        | OT.T.Enterprise_EnterpriseCompanyAddress.province.PR.B.Completeness.MF.001                       |
        | OT.T.Enterprise_EnterpriseCompanyAddress.region_identification.PR.B.Completeness.MF.001          |
        | OT.T.Enterprise_EnterpriseCompanyAddress.state.PR.B.Completeness.MF.001                          |
        | OT.T.Enterprise_EnterpriseCompanyAddress.street_building_identification.PR.B.Completeness.MF.001 |
        | OT.T.Enterprise_EnterpriseCompanyAddress.street_name.PR.B.Completeness.MF.001                    |
        | OT.T.Enterprise_EnterpriseCompanyAddress.subdepartment.PR.B.Completeness.MF.001                  |
        | OT.T.Enterprise_EnterpriseCompanyAddress.town_name.PR.B.Completeness.MF.001                      |

    #####################################################################################
    Scenario: Ejecución del workflow 'ot-et-tt-enterprise-company-address-type' con gobierno del dato

      El workflow recoge los datos de la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_address_type, selecciona las columnas necesarias,
      añade el TS y vuelca los datos en el hdfs asociado al area de TRUSTED

      When Se ejecuta el workflow con Id "9e04dbba-02d5-4be1-bd71-42f92ff968b3"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OK                                                                                            |
        | OT.T.Enterprise_EnterpriseCompanyAddressType.company_address_type_id.PR.B.Completeness.MF.001 |
        | OT.T.Enterprise_EnterpriseCompanyAddressType.description.PR.B.Completeness.MF.001             |
        | OT.T.Enterprise_EnterpriseCompanyAddressType.description.PR.B.Domain.MF.002                   |

      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot-et-tt-enterprise-company-address-type" con el hdfs-output del workflow "hdfs://gts-hdfs//gts/data/trusted/onetrade/enterprise/enterprise_company_address_type"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot-et-tt-enterprise-company-address-type" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot-et-rw-enterprise-company-address-type"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot-et-tt-enterprise-company-address-type"


    @Manual
    Scenario: Ejecución del workflow 'ot-et-tt-enterprise-company-address-type' con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "9e04dbba-02d5-4be1-bd71-42f92ff968b3"
      Then Se aplican las siguientes reglas de calidad con resultado
        | KO                                                                                            |
        | OT.T.Enterprise_EnterpriseCompanyAddressType.company_address_type_id.PR.B.Completeness.MF.001 |
        | OT.T.Enterprise_EnterpriseCompanyAddressType.description.PR.B.Completeness.MF.001             |
        | OT.T.Enterprise_EnterpriseCompanyAddressType.description.PR.B.Domain.MF.002                   |

    #####################################################################################
    Scenario: Ejecución del workflow 'ot-et-tt-enterprise-company-cmc' con gobierno del dato

      El workflow recoge los datos de la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_cmc, selecciona las columnas necesarias,
      añade el TS y vuelca los datos en el hdfs asociado al area de TRUSTED

      When Se ejecuta el workflow con Id "2a91c6fd-9a81-45ca-ad96-fab42aec3f2d"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OK                                                                              |
        | OT.T.Enterprise_EnterpriseCompanyCmc.cmc.PR.B.Completeness.MF.001               |
        | OT.T.Enterprise_EnterpriseCompanyCmc.company_global_id.PR.B.Completeness.MF.001 |

      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot-et-tt-enterprise-company-cmc" con el hdfs-output del workflow "hdfs://gts-hdfs//gts/data/trusted/onetrade/enterprise/enterprise_company_cmc"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot-et-tt-enterprise-company-cmc" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot-et-rw-enterprise-company-cmc"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot-et-tt-enterprise-company-cmc"


    @Manual
    Scenario: Ejecución del workflow 'ot-et-tt-enterprise-company-cmc' con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "2a91c6fd-9a81-45ca-ad96-fab42aec3f2d"
      Then Se aplican las siguientes reglas de calidad con resultado
        | KO                                                                              |
        | OT.T.Enterprise_EnterpriseCompanyCmc.cmc.PR.B.Completeness.MF.001               |
        | OT.T.Enterprise_EnterpriseCompanyCmc.company_global_id.PR.B.Completeness.MF.001 |

    #####################################################################################
    Scenario: Ejecución del workflow 'ot-et-tt-enterprise-company-contact' con gobierno del dato

      El workflow recoge los datos de la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_contact, selecciona las columnas necesarias,
      añade el TS y vuelca los datos en el hdfs asociado al area de TRUSTED

      When Se ejecuta el workflow con Id "851d9c69-cf8b-400b-bd3b-58a71b9924fe"
      And  Se aplican las siguientes reglas de calidad con resultado
          | OK                                                                                        |
          | OT.T.Enterprise_EnterpriseCompanyContact.company_contact_id.PR.B.Completeness.MF.001      |
          | OT.T.Enterprise_EnterpriseCompanyContact.company_contact_type_id.PR.B.Completeness.MF.001 |
          | OT.T.Enterprise_EnterpriseCompanyContact.company_global_id.PR.B.Completeness.MF.001       |
          | OT.T.Enterprise_EnterpriseCompanyContact.contact_data.PR.B.Completeness.MF.001            |
          | OT.T.Enterprise_EnterpriseCompanyContact.is_preferred.PR.B.Completeness.MF.001            |

    Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot-et-tt-enterprise-company-contact" con el hdfs-output del workflow "hdfs://gts-hdfs//gts/data/trusted/onetrade/enterprise/enterprise_company_contact"
    And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot-et-tt-enterprise-company-contact" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot-et-rw-enterprise-company-contact"
    Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot-et-tt-enterprise-company-contact"


    @Manual
    Scenario: Ejecución del workflow 'ot-et-tt-enterprise-company-contact' con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "851d9c69-cf8b-400b-bd3b-58a71b9924fe"
      Then Se aplican las siguientes reglas de calidad con resultado
        | KO                                                                                        |
        | OT.T.Enterprise_EnterpriseCompanyContact.company_contact_id.PR.B.Completeness.MF.001      |
        | OT.T.Enterprise_EnterpriseCompanyContact.company_contact_type_id.PR.B.Completeness.MF.001 |
        | OT.T.Enterprise_EnterpriseCompanyContact.company_global_id.PR.B.Completeness.MF.001       |
        | OT.T.Enterprise_EnterpriseCompanyContact.contact_data.PR.B.Completeness.MF.001            |
        | OT.T.Enterprise_EnterpriseCompanyContact.is_preferred.PR.B.Completeness.MF.001            |

    #####################################################################################
    Scenario: Ejecución del workflow 'ot-et-tt-enterprise-company-country' con gobierno del dato

      El workflow recoge los datos de la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_country, selecciona las columnas necesarias,
      añade el TS y vuelca los datos en el hdfs asociado al area de TRUSTED

        When Se ejecuta el workflow con Id "a4c50393-bfa3-4306-b5f6-78b3c7fcab7a"
        And  Se aplican las siguientes reglas de calidad con resultado
          | OK                                                                                   |
          | OT.T.Enterprise_EnterpriseCompanyCountry.company_global_id.PR.B.Completeness.MF.001  |
          | OT.T.Enterprise_EnterpriseCompanyCountry.country_id.PR.B.Completeness.MF.001         |
        Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot-et-tt-enterprise-company-country" con el hdfs-output del workflow "hdfs://gts-hdfs//gts/data/trusted/onetrade/enterprise/enterprise_company_country"
        And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot-et-tt-enterprise-company-country" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot-et-rw-enterprise-company-country"
        Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot-et-tt-enterprise-company-country"


    @Manual
    Scenario: Ejecución del workflow 'ot-et-tt-enterprise-company-contact' con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "a4c50393-bfa3-4306-b5f6-78b3c7fcab7a"
      Then Se aplican las siguientes reglas de calidad con resultado
        | KO                                                                                   |
        | OT.T.Enterprise_EnterpriseCompanyCountry.company_global_id.PR.B.Completeness.MF.001  |
        | OT.T.Enterprise_EnterpriseCompanyCountry.country_id.PR.B.Completeness.MF.001         |

    #####################################################################################
    Scenario: Ejecución del workflow 'ot-et-tt-enterprise-company-identification' con gobierno del dato

      El workflow recoge los datos de la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_identification, selecciona las columnas necesarias,
      añade el TS y vuelca los datos en el hdfs asociado al area de TRUSTED

      When Se ejecuta el workflow con Id "46a9ea2d-09cb-4e3d-864f-1b6df96833cf"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OK                                                                                                 |
        | OT.T.Enterprise_EnterpriseCompanyIdentification.company_global_id.PR.B.Completeness.MF.001         |
        | OT.T.Enterprise_EnterpriseCompanyIdentification.company_identification_id.PR.B.Completeness.MF.001 |
        | OT.T.Enterprise_EnterpriseCompanyIdentification.document_number.PR.B.Completeness.MF.001           |
        | OT.T.Enterprise_EnterpriseCompanyIdentification.document_type.PR.B.Completeness.MF.001             |
        | OT.T.Enterprise_EnterpriseCompanyIdentification.document_type.PR.B.Completeness.MF.002             |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot-et-tt-enterprise-company-identification" con el hdfs-output del workflow "hdfs://gts-hdfs//gts/data/trusted/onetrade/enterprise/enterprise_company_identification"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot-et-tt-enterprise-company-identification" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot-et-rw-enterprise-company-identification"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot-et-tt-enterprise-company-identification"


    @Manual
    Scenario: Ejecución del workflow 'ot-et-tt-enterprise-company-identification' con gobierno del dato negativo

    Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "46a9ea2d-09cb-4e3d-864f-1b6df96833cf"
      Then Se aplican las siguientes reglas de calidad con resultado
        | KO                                                                                   |
        | OT.T.Enterprise_EnterpriseCompanyIdentification.company_global_id.PR.B.Completeness.MF.001         |
        | OT.T.Enterprise_EnterpriseCompanyIdentification.company_identification_id.PR.B.Completeness.MF.001 |
        | OT.T.Enterprise_EnterpriseCompanyIdentification.document_number.PR.B.Completeness.MF.001           |
        | OT.T.Enterprise_EnterpriseCompanyIdentification.document_type.PR.B.Completeness.MF.001             |
        | OT.T.Enterprise_EnterpriseCompanyIdentification.document_type.PR.B.Completeness.MF.002             |

    #####################################################################################
    Scenario: Ejecución del workflow 'ot-et-tt-enterprise-company-permission' con gobierno del dato

      El workflow recoge los datos de la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_permission, selecciona las columnas necesarias,
      añade el TS y vuelca los datos en el hdfs asociado al area de TRUSTED

      When Se ejecuta el workflow con Id "32c31964-db70-4385-a83f-ac30aa0a206e"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OK                                                                                  |
        | OT.T.Enterprise_EnterpriseCompanyPermission.description.PR.B.Completeness.MF.001    |
        | OT.T.Enterprise_EnterpriseCompanyPermission.permission_id.PR.B.Completeness.MF.001  |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot-et-tt-enterprise-company-permission" con el hdfs-output del workflow "hdfs://gts-hdfs//gts/data/trusted/onetrade/enterprise/enterprise_company_permission"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot-et-tt-enterprise-company-permission" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot-et-rw-enterprise-company-permission"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot-et-tt-enterprise-company-permission"


    @Manual
    Scenario: Ejecución del workflow 'ot-et-tt-enterprise-company-permission' con gobierno del dato negativo

    Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "32c31964-db70-4385-a83f-ac30aa0a206e"
      Then Se aplican las siguientes reglas de calidad con resultado
        | KO                                                                                  |
        | OT.T.Enterprise_EnterpriseCompanyPermission.description.PR.B.Completeness.MF.001    |
        | OT.T.Enterprise_EnterpriseCompanyPermission.permission_id.PR.B.Completeness.MF.001  |

    #####################################################################################
    Scenario: Ejecución del workflow 'ot-et-tt-enterprise-company-resource' con gobierno del dato

      El workflow recoge los datos de la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_resource, selecciona las columnas necesarias,
      añade el TS y vuelca los datos en el hdfs asociado al area de TRUSTED

      When Se ejecuta el workflow con Id "1208d215-a4d4-4767-98a1-56b078efb3a2"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OK                                                                                          |
        | OT.T.Enterprise_EnterpriseCompanyResource.cmc.PR.B.Completeness.MF.001                      |
        | OT.T.Enterprise_EnterpriseCompanyResource.company_resource_id.PR.B.Completeness.MF.001      |
        | OT.T.Enterprise_EnterpriseCompanyResource.company_resource_type_id.PR.B.Completeness.MF.001 |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot-et-tt-enterprise-company-resource" con el hdfs-output del workflow "hdfs://gts-hdfs//gts/data/trusted/onetrade/enterprise/enterprise_company_resource"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot-et-tt-enterprise-company-resource" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot-et-rw-enterprise-company-resource"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot-et-tt-enterprise-company-resource"


    @Manual
    Scenario: Ejecución del workflow 'ot-et-tt-enterprise-company-resource' con gobierno del dato negativo

    Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "1208d215-a4d4-4767-98a1-56b078efb3a2"
      Then Se aplican las siguientes reglas de calidad con resultado
        | KO                                                                                          |
        | OT.T.Enterprise_EnterpriseCompanyResource.cmc.PR.B.Completeness.MF.001                      |
        | OT.T.Enterprise_EnterpriseCompanyResource.company_resource_id.PR.B.Completeness.MF.001      |
        | OT.T.Enterprise_EnterpriseCompanyResource.company_resource_type_id.PR.B.Completeness.MF.001 |

    #####################################################################################
    Scenario: Ejecución del workflow 'ot-et-tt-enterprise-company-resource-type' con gobierno del dato

      El workflow recoge los datos de la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_resource_type, selecciona las columnas necesarias,
      añade el TS y vuelca los datos en el hdfs asociado al area de TRUSTED

      When Se ejecuta el workflow con Id "09a42e90-0a80-4bc0-9f81-dcbc02eeab8b"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OK                                                                                              |
        | OT.T.Enterprise_EnterpriseCompanyResourceType.company_resource_type_id.PR.B.Completeness.MF.001 |
        | OT.T.Enterprise_EnterpriseCompanyResourceType.description.PR.B.Completeness.MF.001              |
        | OT.T.Enterprise_EnterpriseCompanyResourceType.name.PR.B.Completeness.MF.001                     |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot-et-tt-enterprise-company-resource-type" con el hdfs-output del workflow "hdfs://gts-hdfs//gts/data/trusted/onetrade/enterprise/enterprise_company_resource_type"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot-et-tt-enterprise-company-resource-type" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot-et-rw-enterprise-company-resource-type"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot-et-tt-enterprise-company-resource-type"


    @Manual
    Scenario: Ejecución del workflow 'ot-et-tt-enterprise-company-resource-type' con gobierno del dato negativo

    Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "09a42e90-0a80-4bc0-9f81-dcbc02eeab8b"
      Then Se aplican las siguientes reglas de calidad con resultado
        | KO                                                                                              |
        | OT.T.Enterprise_EnterpriseCompanyResourceType.company_resource_type_id.PR.B.Completeness.MF.001 |
        | OT.T.Enterprise_EnterpriseCompanyResourceType.description.PR.B.Completeness.MF.001              |
        | OT.T.Enterprise_EnterpriseCompanyResourceType.name.PR.B.Completeness.MF.001                     |

    #####################################################################################
    Scenario: Ejecución del workflow 'ot-et-tt-enterprise-company-user' con gobierno del dato

    El workflow recoge los datos de la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_user, selecciona las columnas necesarias,
    añade el TS y vuelca los datos en el hdfs asociado al area de TRUSTED

      When Se ejecuta el workflow con Id "87c8a5bb-9b01-4726-b3a1-d68793304bb7"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OK                                                                                     |
        | OT.T.Enterprise_EnterpriseCompanyUser.cmc.PR.B.Completeness.MF.001                     |
        | OT.T.Enterprise_EnterpriseCompanyUser.company_user_id.PR.B.Completeness.MF.001         |
        | OT.T.Enterprise_EnterpriseCompanyUser.global_id.PR.B.Completeness.MF.001               |
        | OT.T.Enterprise_EnterpriseCompanyUser.internal_represent_user.PR.B.Completeness.MF.001 |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot-et-tt-enterprise-company-user" con el hdfs-output del workflow "hdfs://gts-hdfs//gts/data/trusted/onetrade/enterprise/enterprise_company_user"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot-et-tt-enterprise-company-user" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot-et-rw-enterprise-company-user"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot-et-tt-enterprise-company-user"


    @Manual
    Scenario: Ejecución del workflow 'ot-et-tt-enterprise-company-user' con gobierno del dato negativo

    Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "87c8a5bb-9b01-4726-b3a1-d68793304bb7"
      Then Se aplican las siguientes reglas de calidad con resultado
        | KO                                                                                     |
        | OT.T.Enterprise_EnterpriseCompanyUser.cmc.PR.B.Completeness.MF.001                     |
        | OT.T.Enterprise_EnterpriseCompanyUser.company_user_id.PR.B.Completeness.MF.001         |
        | OT.T.Enterprise_EnterpriseCompanyUser.global_id.PR.B.Completeness.MF.001               |
        | OT.T.Enterprise_EnterpriseCompanyUser.internal_represent_user.PR.B.Completeness.MF.001 |

    #####################################################################################
    Scenario: Ejecución del workflow 'ot-et-tt-enterprise-company-user-permission-resource' con gobierno del dato

      El workflow recoge los datos de la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company_user_permission_resource, selecciona las columnas necesarias,
      añade el TS y vuelca los datos en el hdfs asociado al area de TRUSTED

      When Se ejecuta el workflow con Id "c21c47c5-1c50-4559-a222-6bf79c5d7f6b"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OK                                                                                                                           |
        | OT.T.Enterprise_EnterpriseCompanyUserPermissionResource.company_resource_id.PR.B.Completeness.MF.001                         |
        | OT.T.Enterprise_EnterpriseCompanyUserPermissionResource.company_user_id.PR.B.Completeness.MF.001                             |
        | OT.T.Enterprise_EnterpriseCompanyUserPermissionResource.company_user_permission_company_resource_id.PR.B.Completeness.MF.001 |
        | OT.T.Enterprise_EnterpriseCompanyUserPermissionResource.permission_id.PR.B.Completeness.MF.001                               |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot-et-tt-enterprise-company-user-permission-resource" con el hdfs-output del workflow "hdfs://gts-hdfs//gts/data/trusted/onetrade/enterprise/enterprise_company_user_permission_resource"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot-et-tt-enterprise-company-user-permission-resource" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot-et-rw-enterprise-company-user-permission-resource"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot-et-tt-enterprise-company-user-permission-resource"


    @Manual
    Scenario: Ejecución del workflow 'ot-et-tt-enterprise-company-user-permission-resource' con gobierno del dato negativo

    Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "c21c47c5-1c50-4559-a222-6bf79c5d7f6b"
      Then Se aplican las siguientes reglas de calidad con resultado
        | KO                                                                                     |
        | OT.T.Enterprise_EnterpriseCompanyUserPermissionResource.company_resource_id.PR.B.Completeness.MF.001                         |
        | OT.T.Enterprise_EnterpriseCompanyUserPermissionResource.company_user_id.PR.B.Completeness.MF.001                             |
        | OT.T.Enterprise_EnterpriseCompanyUserPermissionResource.company_user_permission_company_resource_id.PR.B.Completeness.MF.001 |
        | OT.T.Enterprise_EnterpriseCompanyUserPermissionResource.permission_id.PR.B.Completeness.MF.001                               |

    #####################################################################################
    Scenario: Ejecución del workflow 'ot-et-tt-enterprise-country' con gobierno del dato

      El workflow recoge los datos de la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_country, selecciona las columnas necesarias,
      añade el TS y vuelca los datos en el hdfs asociado al area de TRUSTED

      When Se ejecuta el workflow con Id "2f008976-0968-4cd5-9067-f01b7421ae31"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OK                                                                     |
        | OT.T.Enterprise_EnterpriseCountry.country_id.PR.B.Completeness.MF.001  |
        | OT.T.Enterprise_EnterpriseCountry.name.PR.B.Completeness.MF.001        |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot-et-tt-enterprise-country" con el hdfs-output del workflow "hdfs://gts-hdfs//gts/data/trusted/onetrade/enterprise/enterprise_country"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot-et-tt-enterprise-country" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot-et-rw-enterprise-country"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot-et-tt-enterprise-country"


    @Manual
    Scenario: Ejecución del workflow 'ot-et-tt-enterprise-country' con gobierno del dato negativo

    Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "2f008976-0968-4cd5-9067-f01b7421ae31"
      Then Se aplican las siguientes reglas de calidad con resultado
        | KO                                                                     |
        | OT.T.Enterprise_EnterpriseCountry.country_id.PR.B.Completeness.MF.001  |
        | OT.T.Enterprise_EnterpriseCountry.name.PR.B.Completeness.MF.001        |