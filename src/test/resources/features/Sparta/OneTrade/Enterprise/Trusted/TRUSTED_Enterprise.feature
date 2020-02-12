Feature: TRUSTED_Enterprise

  Como usuario quiero ejecutar los flujos de Sparta pertenecientes al dominio de Enterprise, en el área de TRSUTED y gobernando los datos para poder promociarlos al área de ONEVIEW

  Background:
    Given Sparta operativo en la url "https://gts-sparta.sgcto-int.stratio.com/gts-sparta/swagger/appStatus"

    #####################################################################################
    Scenario: Ejecución del workflow 'ot-et-tt-enterprise-company' con gobierno del dato

      El workflow recoge los datos de la ruta de parquet 'hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company, selecciona las columnas necesarias,
      descarta los datos que no cumplen los requisitos y vuelva los datos en el area de TRUSTED

      When Se ejecuta el workflow con Id "5fed0639-6b46-4499-b6c2-7d106f3e0e34"
      And  Se aplican las siguientes reglas de calidad con resultado
        | OK                                                                                           |
        | OT.RF.Enterprise_EnterpriseCompany.entity.PR.B.Completeness.PT.001                           |
        | OT.RF.Enterprise_EnterpriseCompany.company_global_id.PR.B.Completeness.PT.001                |
        | OT.RF.Enterprise_EnterpriseCompany.company_name.PR.B.Completeness.PT.001                     |
        | OT.RF.Enterprise_EnterpriseCompany.country_incorporation.PR.B.Completeness.PT.001            |
        | OT.RF.Enterprise_EnterpriseCompany.entity.PR.B.Completeness.PT.001                           |
        | OT.RF.Enterprise_EnterpriseCompany.identification_legal_customer.PR.B.Completeness.PT.001    |
        | OT.RF.Enterprise_EnterpriseCompany.ind_cash_nexus.PR.B.Completeness.PT.001                   |
        | OT.RF.Enterprise_EnterpriseCompany.ind_virtual_company.PR.B.Completeness.PT.001              |
        | OT.RF.Enterprise_EnterpriseCompany.parent_company_id.PR.B.Completeness.PT.001                |
        | OT.RF.Enterprise_EnterpriseCompany.trade_name.PR.B.Completeness.PT.001                       |
      Then Se crea en XDATA la tabla "GTS.QA_ACTUAL_ot-et-rw-enterprise-company" con el hdfs-output del workflow "hdfs://gts-hdfs/gts/data/raw/formatted/onetrade/enterprise/enterprise_company"
      And  Se comprueba que el resultado obtenido "GTS.QA_ACTUAL_ot-et-rw-enterprise-company" coincide con el resultado esperado en XDATA "GTS.QA_EXPECTED_ot-et-rw-enterprise-company"
      Then Se borra la tabla de XDATA "GTS.QA_ACTUAL_ot-et-rw-enterprise-company"


    @Manual
    Scenario: Ejecución del workflow 'ot-et-tt-enterprise-company' con gobierno del dato negativo

      Con un juego de datos de entrada que no cumplan las Quality Rules, validar que el resultado de estas es 'KO'

      When Se ejecuta el workflow con Id "5fed0639-6b46-4499-b6c2-7d106f3e0e34"
      Then Se aplican las siguientes reglas de calidad con resultado
        | KO                                                                                           |
        | OT.RF.Enterprise_EnterpriseCompany.entity.PR.B.Completeness.PT.001                           |
        | OT.RF.Enterprise_EnterpriseCompany.company_global_id.PR.B.Completeness.PT.001                |
        | OT.RF.Enterprise_EnterpriseCompany.company_name.PR.B.Completeness.PT.001                     |
        | OT.RF.Enterprise_EnterpriseCompany.country_incorporation.PR.B.Completeness.PT.001            |
        | OT.RF.Enterprise_EnterpriseCompany.entity.PR.B.Completeness.PT.001                           |
        | OT.RF.Enterprise_EnterpriseCompany.identification_legal_customer.PR.B.Completeness.PT.001    |
        | OT.RF.Enterprise_EnterpriseCompany.ind_cash_nexus.PR.B.Completeness.PT.001                   |
        | OT.RF.Enterprise_EnterpriseCompany.ind_virtual_company.PR.B.Completeness.PT.001              |
        | OT.RF.Enterprise_EnterpriseCompany.parent_company_id.PR.B.Completeness.PT.001                |
        | OT.RF.Enterprise_EnterpriseCompany.trade_name.PR.B.Completeness.PT.001                       |

