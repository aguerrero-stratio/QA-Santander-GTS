Feature: GET_ACCOUNT

  Background:
    Given El servicio esta levantado

  Scenario: Bad Request
    When Hago una llamada al endpoint ACCOUNTS con método GET con ID de Usuario 'XX' que no existe en BBDD
    Then El endpoint me devuelve respuesta de error 400 'Bad request' con el siguiente esquema

              {
              "code": "string",
              "title": "string",
              "description": "string"
              }

    Scenario: Forbidden
      When Hago una llamada al endpoint ACCOUNTS a través de rutas que correspondan a directorios del sistema de ficheros
      Then El endpoint me devuelve respuesta de error 403 'Forbidden' con el siguiente esquema

              {
              "code": "string",
              "title": "string",
              "description": "string"
              }

      Scenario: Method not allowed
        When Hago una llamada al endpoint ACCOUNTS con método distinto a GET con ID de Usuario 'XX' que existe o no en BBDD
        Then El endpoint me devuelve respuesta de error 405 'Method not allowed' con el siguiente esquema

              {
              "code": "string",
              "title": "string",
              "description": "string"
              }

        Scenario: Persona con una 1 cuenta
          When Hago una llamada al endpoint ACCOUNTS con método GET con ID de Usuario 'XX' que tiene una cuenta asociada
          Then El endpoint me devuelve la cuenta del Usuario 'XX'
          And El formato de la respuesta es el correcto segun el siguiente esquema:
              {
              "accountsList": [
              {
              "accountId": "string",
              "displayNumber": "string",
              "alias": "string",
              "type": "string",
              "description": "string",
              "status": "string",
              "country": "string",
              "bic": "string",
              "bicDescription": "string",
              "corporateName": "string",
              "subsidiaryName": "string",
              "lastTransactionDate": "string",
              "amountMainBalance": 0,
              "currencyCodeMainBalance": "string",
              "lastUpdateMainBalance": "string",
              "amountAvailableBalance": 0,
              "currencyCodeAvailableBalance": "string",
              "lastUpdateAvailableBalance": "string",
              "amountPendingBalance": 0,
              "currencyCodePendingBalance": "string",
              "lastUpdatePendingBalance": "string",
              "amountWithHoldingBalance": 0,
              "currencyCodeWithHoldingBalance": "string",
              "lastUpdateWithHoldingBalance": "string",
              "amountOverdraftLimit": 0,
              "currencyCodeOverdraftLimit": "string",
              "lastUpdateOverdraftLimit": "string"
              }
              ]
              }

          Scenario: Persona con mas de 1 cuenta
            Given Hago una llamada al endpoint ACCOUNTS con método GET con ID de Usuario 'XX'  que tiene varias cuentas asociadas
            Then El endpoint me devuelve el listado de las cuentas del Usuario 'XX'
            And El formato de la respuesta es el correcto segun el siguiente esquema:
                {
                  "accountsList": [
                    {
                    "accountId": "string",
                    "displayNumber": "string",
                    "alias": "string",
                    "type": "string",
                    "description": "string",
                    "status": "string",
                    "country": "string",
                    "bic": "string",
                    "bicDescription": "string",
                    "corporateName": "string",
                    "subsidiaryName": "string",
                    "lastTransactionDate": "string",
                    "amountMainBalance": 0,
                    "currencyCodeMainBalance": "string",
                    "lastUpdateMainBalance": "string",
                    "amountAvailableBalance": 0,
                    "currencyCodeAvailableBalance": "string",
                    "lastUpdateAvailableBalance": "string",
                    "amountPendingBalance": 0,
                    "currencyCodePendingBalance": "string",
                    "lastUpdatePendingBalance": "string",
                    "amountWithHoldingBalance": 0,
                    "currencyCodeWithHoldingBalance": "string",
                    "lastUpdateWithHoldingBalance": "string",
                    "amountOverdraftLimit": 0,
                    "currencyCodeOverdraftLimit": "string",
                    "lastUpdateOverdraftLimit": "string"
                    }
                ]

            Scenario: Persona existente en BBDD pero sin cuentas asociadas
              When Hago una llamada al endpoint ACCOUNTS con método GET con ID de Usuario 'XX' que existe en BBDD pero no tiene cuentas asociadas
              Then El endpoint me devuelve la respuesta vacia

              Scenario: Persona que no está dada de alta en BBDD
                When Hago una llamada al endpoint ACCOUNTS con método GET con ID de Usuario 'XX' que no existe en BBDD
                Then El endpoint me devuelve respuesta de error 404 'Not Found'

                Scenario: Unauthorized
                  When Hago una llamada al endpoint ACCOUNTS con método GET con ID de Usuario 'XX' que existe en BBDD pero con un token de autorización incorrecto
                  Then El endpoint me devuelve respuesta de error 401 'Unauthorized' con el siguiente esquema

                      {
                      "code": "string",
                      "title": "string",
                      "description": "string"
                      }

