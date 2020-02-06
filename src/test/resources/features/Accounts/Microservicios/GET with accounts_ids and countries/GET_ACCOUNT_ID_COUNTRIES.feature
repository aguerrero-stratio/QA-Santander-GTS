Feature: GET_ACCOUNT_ID_COUNTRIES

  Background:
    Given El servicio esta levantado

    Scenario: Busqueda con metodo no permitido - 405 - Method not allowed
      When Se realiza una llamada con metodo no permitido al endpoint ACCOUNTS con los parametros accounts_ids y countries permitidos.
      Then El endpoint devuelve el mensaje 405 'Method not allowed' con el siguiente esquema.

          {
          "code": 405,
          "title": "Method not allowed",
          "description": "string"
          }

      Scenario: Busqueda con peticion mal formada - 400 - Bad Request
        When Se realiza una llamada GET al endpoint ACCOUNTS con los parametros accounts_ids y countries no coherentes
        Then El endpoint devuelve el mensaje 400 Bad Request con el siguiente esquema.

          {
          "code": 400,
          "title": "Bad request",
          "description": "string"
          }

        Scenario: Busqueda con token no permitido - 401 - Unauthorized
          When Se realiza una llamada GET al endpoint ACCOUNTS mediante un token de seguridad no valido con los parametros accounts_ids y countries coherentes.
          Then El endpoint devuelve el mensaje 401 'Unauthorized' con el siguiente esquema.

          {
          "code": 401,
          "title": "Unauthorized",
          "description": "string"
          }

          Scenario: Busqueda de una cuenta en varios paises
            When Se realiza una llamada GET al endpoint ACCOUNTS con los parametros account_ids y countries
            Then El endpoint devuelve en un listado los resultados de la busqueda que cumplan con los parametros account_ids y countries

            {
            "accountsList": [
            {
            "accountId": "string",
            "alias": "string",
            "amountAvailableBalance": 0,
            "amountMainBalance": 0,
            "amountOverdraftLimit": 0,
            "amountPendingBalance": 0,
            "amountWithHoldingBalance": 0,
            "bic": "string",
            "bicDescription": "string",
            "corporateName": "string",
            "country": "string",
            "currencyCodeAvailableBalance": "string",
            "currencyCodeMainBalance": "string",
            "currencyCodeOverdraftLimit": "string",
            "currencyCodePendingBalance": "string",
            "currencyCodeWithHoldingBalance": "string",
            "description": "string",
            "displayNumber": "string",
            "isSwift": true,
            "lastTransactionDate": "string",
            "lastUpdateAvailableBalance": "string",
            "lastUpdateMainBalance": "string",
            "lastUpdateOverdraftLimit": "string",
            "lastUpdatePendingBalance": "string",
            "lastUpdateSwiftPayment": "string",
            "lastUpdateWithHoldingBalance": "string",
            "status": "string",
            "subsidiaryName": "string",
            "type": "string"
            },    {
            "accountId": "string",
            "alias": "string",
            "amountAvailableBalance": 0,
            "amountMainBalance": 0,
            "amountOverdraftLimit": 0,
            "amountPendingBalance": 0,
            "amountWithHoldingBalance": 0,
            "bic": "string",
            "bicDescription": "string",
            "corporateName": "string",
            "country": "string",
            "currencyCodeAvailableBalance": "string",
            "currencyCodeMainBalance": "string",
            "currencyCodeOverdraftLimit": "string",
            "currencyCodePendingBalance": "string",
            "currencyCodeWithHoldingBalance": "string",
            "description": "string",
            "displayNumber": "string",
            "isSwift": true,
            "lastTransactionDate": "string",
            "lastUpdateAvailableBalance": "string",
            "lastUpdateMainBalance": "string",
            "lastUpdateOverdraftLimit": "string",
            "lastUpdatePendingBalance": "string",
            "lastUpdateSwiftPayment": "string",
            "lastUpdateWithHoldingBalance": "string",
            "status": "string",
            "subsidiaryName": "string",
            "type": "string"
            }
            ]
            }

            Scenario: Busqueda de una cuenta no existente en un pais
