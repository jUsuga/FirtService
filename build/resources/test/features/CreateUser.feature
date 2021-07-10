#language:es
Característica: Crear un nuevo usuario

  Escenario: Envio el usuario exitosa
    Cuando pepito envia la siguiente informacion del usuario al servio "https://petstore.swagger.io/v2/user"
      |  id | username | firstName | lastName |         email         | password  |   phone   |userStatus |
      | 457 | pcamilo  |  Camilo   |  Caro    | camilo.car@gmail.com  | kuwe36haf | 3190892367|    200    |
    Entonces valide que el codigo de status sea 200