package SeleTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import testing.WindowHandles;

import java.awt.*;

public class WinHandle {
    WindowHandles win = new WindowHandles();
    @Given("Navigate to window handle")
    public void navigateToWindowHandle() {
        win.OpenWebsite();
    }

    @When("Click on different types of window buttons")
    public void clickOnDifferentTypesOfWindowButtons() throws InterruptedException, AWTException {
        win.NewWindow();
        win.NewTab();
        win.MultipleWin();
        win.MultiWinTab();
    }
}
