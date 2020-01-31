Feature: Onboarding Masivo

  Como QA Quiero reproducir el flujo completo del onboarding masivo Para validar el desarrollo

  Scenario: Recepcion archivos de banca local y envio a GTS CORE
    Given La banca local envia el archivo "onboardingEspañaQA.json" a la ruta NFS "/gts/onetrade/Onboarding/ES/original" y lo recogemos con el workflow "IdWorkflow"
    And Realizamos el update de las tablas Process, User y Process Log  y añadimos tradeID y companyGlobalID al json original con el workflow "IdWorkflow"
    Then Realizamos la validación del fichero para dividir los OKs y KOs con el workflow "IdWorkflow"
    And Enviamos el archivo con los OKs a GTS CORE
    And Generamos un archivo de backup

    Scenario: Recepcion de archivos de GTS CORE y Salesforce y envio al dominio de Onboarding
      Given GTS CORE envia el archivo "KOs_GTS_CORE.json" a la ruta NFS "/gts/onetrade/Onboarding/ES/original"
      Then Enviamos mediante una cola Kafka la información al dominio de Onboarding
      When Saleforce envia el archivo "OKs_KOs_Saleforce.json" a la ruta NFS "/gts/onetrade/Onboarding/ES/original"
      Then Enviamos mediante una cola Kafka la información de los KOs al dominio de Onboarding
      And Mediante un HTTP POST enviamos la información de los OKs al flujo de Conductor

      Scenario: Envio de logs a bancas locales
