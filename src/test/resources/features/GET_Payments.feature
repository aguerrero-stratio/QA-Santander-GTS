@Payments
Feature: Dominio Payments endpoint GET Payments

  Como QA Quiero validar el correcto funcionamiento del endpoint GET Payment Para poder dar OK a la regresión

  Background:
    Given El dominio de Payment esta levantado

    Scenario: Endpoint GET payment respuesta correcta
      When Realizamos una petición al endpoint GET Payment
      Then Nos devuelve la respuesta correcta

      Scenario: Endpoint GET payment con criterio de busqueda PaymentID
        When Realizamos una petición al endpoint con el criterio de busqueda PaymentID "20ae626e-5747-4377-91a5-52e0f95122c8"
        Then Nos devuelve la respuesta con el criterio de busqueda PaymentID "20ae626e-5747-4377-91a5-52e0f95122c8"

        Scenario: Endpoint GET payment con criterio de busqueda User account_id
          When Realizamos una petición al endpoint con el criterio de busqueda User account_id "ES5500490072012110458301"
          Then Nos devuelve la respuesta con el criterio de busqueda User account id "ES5500490072012110458301"

          @PruebaOutline
          Scenario Outline: Endpoint GET payment con criterio de busqueda PaymentID
            When Realizamos una petición al endpoint con el criterio de busqueda PaymentID "<idWorkflow>"
            Then Nos devuelve la respuesta con el criterio de busqueda PaymentID "<respuesta>"
            Examples:
              | idWorkflow | respuesta |
              | 20ae626e-5747-4377-91a5-52e0f95122c8 | 20ae626e-5747-4377-91a5-52e0f95122c8 |
              | 20ae626e-5747-4377-91a5-52e0f95122c8 | 20ae626e-5747-4377-91a5-52e0f95122 |
              | 20ae626e-5747-4377-91a5-52e0f95122 | 20ae626e-5747-4377-91a5-52e0f95122c8 |