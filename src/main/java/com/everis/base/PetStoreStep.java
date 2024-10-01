package com.everis.base;

import com.everis.base.models.Order;
import net.serenitybdd.rest.SerenityRest;

import static io.restassured.RestAssured.given;

public class PetStoreStep {

    private String URL_BASE = "https://petstore.swagger.io/v2";
    private int codigoRespuesta;
    private Order respuestaOrder;

    public void crearOrder(int id, int petId, int quantity) {

        Order nuevaOrder = new Order(id, petId, quantity);

        codigoRespuesta = given()
                .baseUri(URL_BASE)
                .contentType("application/json")
                .body(nuevaOrder)
                .when()
                .post("/store/order")
                .then()
                .statusCode(200)
                .extract()
                .statusCode();

        respuestaOrder = given()
                .baseUri(URL_BASE)
                .when()
                .get("/store/order/" + id)
                .as(Order.class);

        System.out.println("ID Creado: " + respuestaOrder.getId());
        System.out.println("PetID Creado: " + respuestaOrder.getPetId());
        System.out.println("Quantity Creado: " + respuestaOrder.getQuantity());

    }

    public Order consultarOrder(int id) {

        respuestaOrder = given()
                .baseUri(URL_BASE)
                .when()
                .get("/store/order/" + id)
                .as(Order.class);

        System.out.println("ID Creado: " + respuestaOrder.getId());
        System.out.println("PetID Creado: " + respuestaOrder.getPetId());
        System.out.println("Quantity Creado: " + respuestaOrder.getQuantity());
        return respuestaOrder;
    }


    public void validarCodigoRespuesta(int codigoEsperdo) {
        if (codigoRespuesta != codigoEsperdo) {
            throw new AssertionError("Código esperado: " + codigoEsperdo + "Código Obtenido: " + codigoRespuesta);
        }
    }

    public Order obtenerRespuestaOrder() {
        return respuestaOrder;
    }
}

