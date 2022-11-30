package SeleTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import testing.Waits;

public class MyStepdefs {
    Waits wt = new Waits();
    @Given("Navigate to waits demo")
    public void navigateToWaitsDemo() {
        wt.MainWaits();
    }

    @When("Click on testbox")
    public void clickOnTestbox() throws InterruptedException {
        wt.WaitsPractice();

    }


}
