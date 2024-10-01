package com.everis.base;

import com.everis.base.PetStoreStep;
import com.everis.base.models.Order;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PetStoreSD {

    @Steps
    PetStoreStep petStore;
    @Given("dado que estoy en la pagina web")
    public void dadoQueEstoyEnLaPaginaWeb() {
    }

    @When("creo una orden con id{int}, petId{int}, quantity{int}")
    public void creoUnaOrdenConIdIdPetIdPetIdQuantityQuantity(int id, int petId, int quantity){
        petStore.crearOrder(id,petId, quantity);
    }

    @Then("el código de estado de la respuesta debe ser {int}")
    public void elCódigoDeEstadoDeLaRespuestaDebeSerCodigo(int codigo) {
        petStore.validarCodigoRespuesta(codigo);
    }

    @And("la respuesta debe contener el id{int}, petId{int}, quantity{int}")
    public void laRespuestaDebeContenerElIdIdPetIdPetIdQuantityQuantity(int id, int petId, int quantity) {
        Order order = petStore.obtenerRespuestaOrder();
        assertNotNull(order);
        assertEquals(id, order.getId());
        assertEquals(petId, order.getPetId());
        assertEquals(quantity, order.getQuantity());
    }

    @Given("dado que estoy en la página web")
    public void dadoQueEstoyEnLaPáginaWeb() {
    }

    @When("consulto con la orden con el ID {int}")
    public void consultoElOrderConIDId(int id) {
        petStore.consultarOrder(id);
    }

    @Then("el código de estado de la respuesta debería ser {int}")
    public void elCódigoDeEstadoDeLaRespuestaDeberíaSerCodigo(int codigo) {
        petStore.validarCodigoRespuesta(codigo);
    }

    @And("la respuesta debe obtener el id {int}")
    public void laRespuestaDebeObtenerElIdIdPetIdPetIdQuantityQuantity(int id) {
        Order order = petStore.consultarOrder(id);
        assertNotNull(order);
        assertEquals(id, order.getId());
    }

}
