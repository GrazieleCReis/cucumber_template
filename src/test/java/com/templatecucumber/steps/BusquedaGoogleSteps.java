package com.templatecucumber.steps;

import com.templatecucumber.core.Config;
import com.templatecucumber.pages.actions.GooglePageActions;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.junit.Assert;

import static com.templatecucumber.core.DriverManager.getDriver;

public class BusquedaGoogleSteps {

    private GooglePageActions googleActons = new GooglePageActions();
    String textSeach = null;
    String TXT_SEARCH = null;

    @Dado("que me encuentro en la página principal de Google")
    public void queMeEncuentroEnLaPaginaPrincipalDeGoogle() {
        getDriver().get(Config.URI_TEST);
        Assert.assertTrue(googleActons.verifyImg());
    }
    @Cuando("busco {string} en la barra de búsqueda")
    public void buscoEnLaBarraDeBusqueda(String text) {
        TXT_SEARCH = text;
        googleActons.sendKeysSearchField(TXT_SEARCH);
    }
    @Entonces("me redirige a la página de resultados de la búsqueda")
    public void meRedirigeALaPaginaDeResultadosDeLaBusqueda() {
        Assert.assertTrue(googleActons.getTextSearchField().contains(TXT_SEARCH));
        Assert.assertEquals("Cucumber-JVM", googleActons.getFirstResult());
    }
}
