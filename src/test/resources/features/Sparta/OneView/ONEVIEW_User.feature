@oneview
Feature: ONEVIEW_User

  Como usuario quiero ejecutar los flujos de Sparta pertenecientes al dominio de User en el area de ONEVIEW pàra aplicar reglas de negocio y almacenarlos en postgres.

  Background:
    Given Sparta operativo en la url "https://gts-sparta.sgcto-int.stratio.com/gts-sparta/appStatus"

    #####################################################################################
    @sparta_user_oneview
    Scenario: Ejecución del workflow 'ot-us-ov-user-channels' sin gobierno del dato

      El workflow recoge los datos de fuentes TRUSTED-HDFS, se aplican reglas de negocio y se selecciona la informacion necesaria para despues almacenarla en postgre
      con los resultados obtenidos.

      When Se ejecuta el workflow con Id "9b06ecb3-92e4-4e58-add7-ad8e0672cd7d"
      Then El resultado obtenido se guarda en la BBDD "onetrade.aci_03ccr_channels_ot_sp4"
      And  Se comprueba que el resultado almacenado en BBDD "onetrade.aci_03ccr_channels_ot_sp4" coincide con el resultado esperado en BBDD "onetrade.expected_aci_03ccr_channels_ot_sp4"

    #####################################################################################
    @sparta_user_oneview
    Scenario: Ejecución del workflow 'ot-us-ov-user-company-datas' sin gobierno del dato

      El workflow recoge los datos de fuentes TRUSTED-HDFS, se aplican reglas de negocio y se selecciona la informacion necesaria para despues almacenarla en postgre
      con los resultados obtenidos.

      When Se ejecuta el workflow con Id "50bb283b-5be0-4534-ba92-4fbc4b71f880"
      Then El resultado obtenido se guarda en la BBDD "onetrade.aci_01cap_company_datas_ot_sp4"
      And  Se comprueba que el resultado almacenado en BBDD "onetrade.aci_01cap_company_datas_ot_sp4" coincide con el resultado esperado en BBDD "onetrade.expected_aci_01cap_company_datas_ot_sp4"

    #####################################################################################
    @sparta_user_oneview
    Scenario: Ejecución del workflow 'ot-us-ov-user-dc-uc-relation' sin gobierno del dato

      El workflow recoge los datos de fuentes TRUSTED-HDFS, se aplican reglas de negocio y se selecciona la informacion necesaria para despues almacenarla en postgre
      con los resultados obtenidos.

      When Se ejecuta el workflow con Id "5df1e499-35e7-4f2a-a89f-9a808f6b7a33"
      Then El resultado obtenido se guarda en la BBDD "onetrade.aci_06cha_dc_uc_relationships_ot_sp4"
      And  Se comprueba que el resultado almacenado en BBDD "onetrade.aci_06cha_dc_uc_relationships_ot_sp4" coincide con el resultado esperado en BBDD "onetrade.expected_aci_06cha_dc_uc_relationships_ot_sp4"

    #####################################################################################
    @sparta_user_oneview
    Scenario: Ejecución del workflow 'ot-us-ov-user-persons' sin gobierno del dato

      El workflow recoge los datos de fuentes TRUSTED-HDFS, se aplican reglas de negocio y se selecciona la informacion necesaria para despues almacenarla en postgre
      con los resultados obtenidos.

      When Se ejecuta el workflow con Id "ad7236bf-e52b-4235-99c2-97c2fdea180c"
      Then El resultado obtenido se guarda en la BBDD "onetrade.aci_03ccr_persons_ot_sp4"
      And  Se comprueba que el resultado almacenado en BBDD "onetrade.aci_03ccr_persons_ot_sp4" coincide con el resultado esperado en BBDD "onetrade.expected_aci_03ccr_persons_ot_sp4"

    #####################################################################################
    @sparta_user_oneview
    Scenario: Ejecución del workflow 'ot-us-ov-user-persons-types' sin gobierno del dato

      El workflow recoge los datos de fuentes TRUSTED-HDFS, se aplican reglas de negocio y se selecciona la informacion necesaria para despues almacenarla en postgre
      con los resultados obtenidos.

        When Se ejecuta el workflow con Id "d7a4ec18-3673-496c-b8cc-72de79926b93"
        Then El resultado obtenido se guarda en la BBDD "onetrade.aci_03ccr_persons_types_ot_sp4"
        And  Se comprueba que el resultado almacenado en BBDD "onetrade.aci_03ccr_persons_types_ot_sp4" coincide con el resultado esperado en BBDD "onetrade.expected_aci_03ccr_persons_types_ot_sp4"

    #####################################################################################
    @sparta_user_oneview
    Scenario: Ejecución del workflow 'ot-us-ov-user-pref-channel' sin gobierno del dato

      El workflow recoge los datos de fuentes TRUSTED-HDFS, se aplican reglas de negocio y se selecciona la informacion necesaria para despues almacenarla en postgre
      con los resultados obtenidos.

        When Se ejecuta el workflow con Id "82da65fe-2b36-4722-b48f-24911a5ac053"
        Then El resultado obtenido se guarda en la BBDD "onetrade.aci_03ccr_preference_channels_ot_sp4"
        And  Se comprueba que el resultado almacenado en BBDD "onetrade.aci_03ccr_preference_channels_ot_sp4" coincide con el resultado esperado en BBDD "onetrade.expected_aci_03ccr_preference_channels_ot_sp4"

    #####################################################################################
    @sparta_user_oneview
    Scenario: Ejecución del workflow 'ot-us-ov-user-roles' sin gobierno del dato

      El workflow recoge los datos de fuentes TRUSTED-HDFS, se aplican reglas de negocio y se selecciona la informacion necesaria para despues almacenarla en postgre
      con los resultados obtenidos.

        When Se ejecuta el workflow con Id "139ff04d-e180-4671-9d7b-232b0e308e47"
        Then El resultado obtenido se guarda en la BBDD "onetrade.aci_03ccr_roles_ot_sp4"
        And  Se comprueba que el resultado almacenado en BBDD "onetrade.aci_03ccr_roles_ot_sp4" coincide con el resultado esperado en BBDD "onetrade.expected_aci_03ccr_roles_ot_sp4"