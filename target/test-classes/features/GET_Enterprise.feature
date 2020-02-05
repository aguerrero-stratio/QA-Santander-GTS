Feature: GET_Enterprise

  Background:
    Given El dominio de "Enterprise" esta levantado


  Scenario: Detalle de la empresa a traves del company_id

    Endpoint get que nos da el detalle de la empresa que corresponda al company_id introducido en la llamada

    When Realizamos una petición al endpoint de "Enterprise" con CompanyID "string"
    Then Nos devuelve la respuesta con el criterio de CompanyID "string"

  Scenario: Bad request del endpoint GET

    El endpoint nos da una respuesta 400 "Bad request"

    When Realizamos una petición bad request
    Then Nos devuelve la respuesta 400 "Bad request"

  Scenario: Unauthorized del endpoint GET

    El endpoint nos da una respuesta 401 "Unauthorized"

    When Realizamos una petición Unauthorized
    Then Nos devuelve la respuesta 401 "Unauthorized"

  Scenario: Forbidden del endpoint GET

  El endpoint nos da una respuesta 403 "Forbidden"

    When Realizamos una petición Forbidden
    Then Nos devuelve la respuesta 403 "Forbidden"

  Scenario: Not found del endpoint GET

  El endpoint nos da una respuesta 404 "Not found"

    When Realizamos una petición Not found
    Then Nos devuelve la respuesta 404 "Not found"

  Scenario: Method not allowed del endpoint GET

  El endpoint nos da una respuesta 405 "Method not allowed"

    When Realizamos una petición Method not allowed
    Then Nos devuelve la respuesta 405 "Method not allowed"