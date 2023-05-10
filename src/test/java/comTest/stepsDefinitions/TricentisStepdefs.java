package comTest.stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.List;

import static comTest.stepsDefinitions.Hooks.driver;

public class TricentisStepdefs {

    //je déclare mon timestamp pas encore parsé comme je le désire , il est par défaut
    Timestamp timeNoParse = new Timestamp(System.currentTimeMillis());
    //je le pars dans un format unique afin de pouvoir avoir un email unique lors du test
    String timeParse = new SimpleDateFormat("mmDDyyyy").format(timeNoParse);

    //parti random pour l'email entre 0 et 100
    int randomNum = (int) (Math.random() * 101);

    // partie duration pour pouvoir utiliser le wait
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));

    public void waitForElement(String locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    @Given(": un client  sur le site demo {string}")
    public void unClientSurLeSiteDemo(String urlSite) throws InterruptedException {
        driver.get(urlSite);

    }

    @When(": il saisit son firstName sur le device {string}")
    public void ilSaisitSonFirstNameSurLeDevice(String firstName) throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys(firstName);
    }

    @And(": il saisit son LastName sur le device {string}")
    public void ilSaisitSonLastNameSurLeDevice(String lastName) {
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys(lastName);
    }

//    @And(": il saisit son Email sur le device {string}")
//    public void ilSaisitSonEmailSurLeDevice(String emailTest) {
//        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailTest);
//    }

    @And(": il saisit son Email sur le device {string} {string}")
    public void ilSaisitSonEmailSurLeDevice(String emailBefore, String emailAfter) {
        //avec un random timeStamp
        //driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailBefore+timeParse+emailAfter);

        // avec un random Integer
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailBefore + randomNum + emailAfter);
        System.out.println(emailBefore + randomNum + emailAfter);
    }

    @And(": il saisit son Password sur le device {string}")
    public void ilSaisitSonPasswordSurLeDevice(String passwordTest) {
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(passwordTest);
    }

    @And(": il saisit le same Password sur le device {string}")
    public void ilSaisitLeSamePasswordSurLeDevice(String passwordTest) throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys(passwordTest);

    }

    @And(": il clique sur le bouton register")
    public void ilCliqueSurLeBoutonRegister() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='register-button']")));
        driver.findElement(By.xpath("//input[@id='register-button']")).click();
    }

    @Then(":le message {string} s'affiche avec le bouton continue en dessous")
    public void leMessageSAfficheAvecLeBoutonContinueEnDessous(String messageCongrats) {
        // attend jusqua ce qu'une condition de visibilité soit trouvé via le xpath avec un temps/duration déclaré plus haute
        waitForElement("//div[@class='result']");
        driver.findElement(By.xpath("//div[@class='result']")).equals(messageCongrats);

    }

    @Given(": Un client sur le site démo {string}")
    public void unClientSurLeSiteDémo(String urlSite) {
        driver.get(urlSite);
    }

    @Then(": Je veux voir toutes les catégories")
    public void jeVeuxVoirToutesLesCatégories() {
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='block block-category-navigation']//div[@class='listbox']/ul/li[5]"));

        for (WebElement element : elements) {
            System.out.println("Paragraph text:" + element.getText());
        }
    }
}
