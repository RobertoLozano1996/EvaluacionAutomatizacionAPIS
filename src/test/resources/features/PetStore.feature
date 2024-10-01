@Todos
Feature: Gestión de ordenes de la tienda
    @CrearOrder
    Scenario Outline: Crear una nueva orden
      Given dado que estoy en la pagina web
      When creo una orden con id<id>, petId<petId>, quantity<quantity>
      Then el código de estado de la respuesta debe ser <codigo>
      And la respuesta debe contener el id<id>, petId<petId>, quantity<quantity>
      Examples:
      |id|petId|quantity|codigo|
      |222|5   |4       |200   |
      |333|6   |5       |200   |
      |444|7   |6       |200   |
      |555|8   |7       |200   |

    @ConsultarOrder
    Scenario Outline: Consulta de las ordenes de la tienda
      Given dado que estoy en la página web
      When consulto con la orden con el ID <id>
      Then el código de estado de la respuesta debería ser <codigo>
      And la respuesta debe obtener el id <id>
      Examples:
      | id   | codigo |
      | 201  | 200    |
      | 202  | 200    |
      | 202  | 200    |
