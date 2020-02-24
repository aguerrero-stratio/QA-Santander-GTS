@Max
Feature: GET_Payments MT103

  Como usuario quiero tener en el dominio de Payments un endpoint para realizar la consulta de los mensajes MT103 ingestados a través del PaymentID para poder ver el detalle de los mismos

  Background:
    Given El dominio de payments esta levantado

  Scenario Outline: Casuisticas de búsqueda de MT103 asociados a una Cuenta

  Como usuario quiero realizar satisfactoriamente distintas casuísticas de búsqueda para validar que la respuesta es correcta

    When Se realiza un request "GET" al endpoint payments MT103 con el parametro "<paymentId>"
    Then El servicio de payments MT103 nos devuelve la respuesta "/Payments/Output/GET_Payments_MT103/<jsonOutputBody>"
    Examples:
      | paymentId                               | jsonOutputBody        |
      | 00L1DjW4-ac3c-462a-bd47-8a7ec5194b62    | paymentIdValid.json   |
      | 12300L1DjW4-ac3c-462a-bd47-8a7ec5194b62 | paymentIdInvalid.json |


  Scenario: Ingesta de MT103 y validacion posterior

  Como usuario quiero ingestar un mensaje MT103 a través de la cola MQ y validar que se ha persistido correctamente en nuestro dominio

    When Se realiza la ingesta de un mensaje MT103 al AccountID "AccountID"
    When Se realiza un request "GET" con el parametro "<paymentId>"
    Then El servicio nos devuelve la respuesta "<jsonOutputBody>"

  @ErrorRequest
  Scenario Outline: Control de errores

  Como usuario quiero validar el control de errores del endpoint para validar el desarrollo del mismo

    When Se realiza una peticion "GET" erronea "<errorRequest>" al dominio "payments" con el endpoint "/payments"
    Then El servicio nos devuelve la respuesta con informacion del error correspondiente a "<errorRequest>"
    Examples:
      | errorRequest       |
      | Bad Request        |
      | Method Not Allowed |
