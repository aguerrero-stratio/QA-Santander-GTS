Feature: Enterprise

  Scenario: Detalle de la empresa a traves del company_id

    Endpoint get que nos da el detalle de la empresa que corresponda al company_id introducido en la llamada

    Given El dominio de "Enterprise" esta levantado
    When Realizamos una petición al endpoint de "Enterprise" con CompanyID "<string>"
    Then Nos devuelve la respuesta con el criterio de CompanyID "<string>"

  Scenario: Bad request del endpoint GET

    El endpoint nos da una respuesta 400 "Bad request"

    Given El dominio de "Enterprise" esta levantado
    When Realizamos una petición al endpoint de "Enterprise" con CompanyID "<string>"
    Then Nos devuelve la respuesta con el criterio de CompanyID "<string>"

  Scenario: Unauthorized del endpoint GET

    El endpoint nos da una respuesta 400 "Bad request"

    Given El dominio de "Enterprise" esta levantado
    When Realizamos una petición al endpoint de "Enterprise" con CompanyID "<string>"
    Then Nos devuelve la respuesta con el criterio de CompanyID "<string>"