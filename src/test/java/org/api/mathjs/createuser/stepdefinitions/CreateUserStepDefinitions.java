package org.api.mathjs.createuser.stepdefinitions;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.rest.SerenityRest;
import org.api.mathjs.createuser.models.CreateUser;

import java.util.List;

public class CreateUserStepDefinitions {

    @Cuando("^pepito envia la siguiente informacion del usuario al servio \"([^\"]*)\"$")
    public void pepitoEnviaLaSiguienteInformacionDelUsuarioAlServio(String url, List<CreateUser> listCreateUser) {
        String cuerpo ="" +
                "{\n" +
                "  \"id\": "+listCreateUser.get(0).getId()+",\n" +
                "  \"username\": \""+listCreateUser.get(0).getUsername()+"\",\n" +
                "  \"firstName\": \""+listCreateUser.get(0).getFirstName()+"\",\n" +
                "  \"lastName\": \""+listCreateUser.get(0).getLastName()+"\",\n" +
                "  \"email\": \""+listCreateUser.get(0).getEmail()
                +"\",\n" +
                "  \"password\": \"."+listCreateUser.get(0).getPassword()+"\",\n" +
                "  \"phone\": \""+listCreateUser.get(0).getPhone()+"\",\n" +
                "  \"userStatus\": "+listCreateUser.get(0).getUserStatus()+"\n" +
                "}";

        SerenityRest.given().body(cuerpo).baseUri(url).header("Content-type","application/json").post();
    }

    @Entonces("^valide que el codigo de status sea (\\d+)$")
    public void valideQueElCodigoDeStatusSea(int status) {
        SerenityRest.lastResponse().then().statusCode(status);
    }

}
