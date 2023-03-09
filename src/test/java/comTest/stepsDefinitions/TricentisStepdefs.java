package comTest.stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import static comTest.stepsDefinitions.Hooks.driver;

public class TricentisStepdefs {

    Timestamp timeNoParse=  new Timestamp(System.currentTimeMillis());
    String timeParse= new SimpleDateFormat("mmDDyyyy").format(timeNoParse);
    @Given(": un client  sur le site demo {string}")
    public void unClientSurLeSiteDemo(String urlSite) throws InterruptedException {
        driver.get(urlSite);
        Thread.sleep(3000);
    }

    @When(": il saisit  son firstName sur le device {string}")
    public void ilSaisitSonFirstNameSurLeDevice(String firstName) throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys(firstName);
        Thread.sleep(3000);

    }
    @And(": il saisit son LastName sur le device {string}")
    public void ilSaisitSonLastNameSurLeDevice(String lastName){
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys(lastName);
    }

//    @And(": il saisit son Email sur le device {string}")
//    public void ilSaisitSonEmailSurLeDevice(String emailTest) {
//        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailTest);
//    }

    @And(": il saisit son Email sur le device {string} {string}")
    public void ilSaisitSonEmailSurLeDevice(String emailBefore, String emailAfter) {

        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailBefore+timeParse+emailAfter);
        System.out.println(emailBefore+timeParse+emailAfter);
    }

    @And(": il saisit son Password sur le device {string}")
    public void ilSaisitSonPasswordSurLeDevice(String passwordTest) {
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(passwordTest);
    }

    @And(": il saisit le same Password sur le device {string}")
    public void ilSaisitLeSamePasswordSurLeDevice(String passwordTest) throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys(passwordTest);
        Thread.sleep(2000);
    }

    @And(": il clique sur le bouton register")
    public void ilCliqueSurLeBoutonRegister() {
        driver.findElement(By.xpath("//input[@id='register-button']")).click();
    }

    @Then(":le message {string} s'affiche avec le bouton continue en dessous")
    public void leMessageSAfficheAvecLeBoutonContinueEnDessous(String messageCongrats) throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='result']")).equals(messageCongrats);
        Thread.sleep(3000);
    }


}
