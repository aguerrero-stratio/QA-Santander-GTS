Feature: Onboarding Masivo

  Como usuario quiero realizar el proceso completo para realizar el onboarding de usuarios

  Scenario: Recepcion archivos de banca local y envio a GTS CORE

    Se reciben los archivos .json de los distintos bancos locales mediante NFS, se procesan, filtran y se envian a GTS Core los registros OKs.

    Given La banca local envia el archivo "onboardingEspañaQA.json" a la ruta NFS "/gts/onetrade/Onboarding/ES/original" y lo recogemos con el workflow "IdWorkflow"
    And Realizamos el update de las tablas Process, User y Process Log  y añadimos tradeID y companyGlobalID al json original con el workflow "IdWorkflow"
    Then Realizamos la validación del fichero para dividir los OKs y KOs con el workflow "IdWorkflow"
    And Enviamos el archivo con los OKs a GTS CORE
    And Generamos un archivo de backup

    Scenario: Recepcion de archivos de GTS CORE, Salesforce y envio al dominio de Onboarding

      GTS Core y Salesforce nos envian su filtrado de registros, los procesamos y actualizamos el dominio de onboarding mediante conductor

      Given GTS CORE envia el archivo "KOs_GTS_CORE.json" a la ruta NFS "/gts/onetrade/Onboarding/ES/original"
      Then Enviamos mediante una cola Kafka la información al dominio de Onboarding
      When Saleforce envia el archivo "OKs_KOs_Saleforce.json" a la ruta NFS "/gts/onetrade/Onboarding/ES/original"
      Then Enviamos mediante una cola Kafka la información de los KOs al dominio de Onboarding
      And Mediante un HTTP POST enviamos la información de los KOs al flujo de Conductor
      Then Se actualiza el dominio de Onboarding

      Scenario: Envio de logs a bancas locales

        Se envian mediante NFS los logs generados durante todo el proceso a las bancas locales

        Given Ejecutamos el workflow "IdWorkflow" que vuelca el resumen de los logs del proceso a NFS
        Then El fichero se ha cargado correctamente en NFS
