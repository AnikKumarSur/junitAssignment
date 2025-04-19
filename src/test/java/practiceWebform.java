import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class practiceWebform {

    WebDriver driver;

    @BeforeAll
    public void setUp(){
        driver = new ChromeDriver();
        //For window size maximize
        driver.manage().window().maximize();
        //For create implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }


    @Test
    public void fillUpUserForm() throws InterruptedException {
        //visit the Form URL
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        Thread.sleep(2000);

        //Find class selector for input field
        List<WebElement> txtFields = driver.findElements(By.className("form-control"));


        txtFields.get(0).sendKeys("Test User");
        Thread.sleep(2000);

        txtFields.get(1).sendKeys("01723456789");
        Thread.sleep(2000);

        txtFields.get(2).sendKeys("02112025");
        Thread.sleep(2000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
        Thread.sleep(2000);

        txtFields.get(3).sendKeys("testuser@test.com");
        Thread.sleep(2000);

        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
        Thread.sleep(2000);
        txtFields.get(4).sendKeys("i am a test Automation engineer and i am learning selenium java. I am also learning how to write test cases using Junit and TestNG. I am also learning how to use Page Object Model and Page Factory in selenium java. I am also learning how to use Maven and Gradle for dependency management. I am also learning how to use Git and GitHub for version control. I am also learning how to use Jenkins for continuous integration and continuous deployment. I am also learning how to use Docker for containerization. I am also learning how to use Kubernetes for orchestration.");
        Thread.sleep(2000);

        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
        Thread.sleep(2000);

        driver.findElement(By.id("edit-uploadocument-upload")).sendKeys("C:\\Users\\Apnik034\\OneDrive\\Desktop\\Testing.docx");
        Thread.sleep(2000);

        JavascriptExecutor js3 = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
        Thread.sleep(2000);

        List <WebElement> chkField = driver.findElements(By.tagName("input"));
        chkField.get(7).click();
        Thread.sleep(2000);
        chkField.get(11).click();
        Thread.sleep(2000);

        String actualConfirmation = driver.findElement(By.tagName("h1")).getText();
        String expectedConfirmation = "Thank you for your submission!";

        Assertions.assertEquals(expectedConfirmation, actualConfirmation);


    }
    @AfterAll
    public void tearDown() {
        //For close the browser
        driver.quit();
    }
}
