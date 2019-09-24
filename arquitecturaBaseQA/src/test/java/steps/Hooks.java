package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * Hooks
 * Class that define what has to execute Before and After feature or scenario
 *
 *
 */
public class Hooks {

    @Before
    public void beforeScenario(){

        System.out.println("Se empieza con la ejecución del Scenario");

    }

    @After
    public void afterScenario(){

        System.out.println("Se ha terminado con la ejecución del Scenario");

    }

}
