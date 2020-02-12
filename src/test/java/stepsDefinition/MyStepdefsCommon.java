package stepsDefinition;

import cucumber.api.java.en.Given;
import utils.UtilsCommon;

public class MyStepdefsCommon {

    public MyStepdefsCommon() {
    }

    @Given("^El dominio de \"([^\"]*)\" esta levantado$")
    public void elDominioDeEstaLevantado(String domain){

        UtilsCommon.serviceIsUp(domain);

    }


}
