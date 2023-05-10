package comTest.stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static comTest.stepsDefinitions.Hooks.driver;

public class demoQAStepdefs {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
    JavascriptExecutor js = (JavascriptExecutor) driver;
    public void waitForElement(String locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        //essai commit intellij3

    }

    @Given(": Un utilisateur se rend sur le site demo {string}")
    public void unUtilisateurSeRendSurLeSiteDemo(String locator) {
        driver.get(locator);
    }

    @When(": Il clique sur la categorie Interactions")
    public void ilCliqueSurLaCategorieInteractions() throws InterruptedException {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Droppable']")));
        WebElement el = driver.findElement(By.cssSelector("div.category-cards .card:nth-child(5)"));
        js.executeScript("arguments[0].scrollIntoView(true);", el);
        Thread.sleep(2000);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.cssSelector("div.category-cards .card:nth-child(5)"))).perform();
        System.out.println("done");
        Thread.sleep(20000);

    }

    @And(": attendre que son sous menu apparaisse avec {string}")
    public void attendreQueSonSousMenuApparaisseAvec(String arg0) {
    }

    @And(": Il clique sur la sous categorie {string}")
    public void ilCliqueSurLaSousCategorie(String arg0) {
    }
}
