import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class guestRegistrationForm {
    WebDriver driver;

    @BeforeAll
    public void setUp(){
        driver = new ChromeDriver();
        //For window size maximize
        driver.manage().window().maximize();
        //For create implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void fillUpUserForm() throws InterruptedException {
        driver.get("https://demo.wpeverest.com/user-registration/guest-registration-form/");
        //find tagName locator for every field
        Faker faker = new Faker();

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String phone = faker.phoneNumber().cellPhone();
        String password = faker.internet().password(12,16);
        List<WebElement> inputField = driver.findElements(By.tagName("input"));

        //Fill up the fields
        inputField.get(4).sendKeys(firstName);
        Thread.sleep(500);
        inputField.get(7).sendKeys(lastName);
        Thread.sleep(500);
        inputField.get(5).sendKeys(email);
        Thread.sleep(500);
        inputField.get(6).sendKeys(password);
        Thread.sleep(500);
        inputField.get(8).click();
        Select country = new Select(driver.findElement(By.id("country_1665629257")));//Country
        country.selectByVisibleText("Bangladesh");
        Thread.sleep(2000);


        inputField.get(11).click();
        //Select Month
        List<WebElement> selectMonth = driver.findElements(By.tagName("option"));
        selectMonth.get(254).click();
        Thread.sleep(1000);
        // Select year (input type=number)
        WebElement yearSelect = driver.findElement(By.className("numInput"));
        yearSelect.clear();
        yearSelect.sendKeys("1998");
        //SelectDay
        List<WebElement> selectDay = driver.findElements(By.className("flatpickr-day"));
        selectDay.get(10).click();
        Thread.sleep(1000);
        Thread.sleep(2000);
        inputField.get(16).sendKeys("Bangladeshi");
        Thread.sleep(2000);


        inputField.get(14).sendKeys("01743255525");
        Thread.sleep(500);
        driver.findElement(By.id("country_1665629257")).click();
        Thread.sleep(500);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1200)");
        Thread.sleep(2000);


        inputField.get(33).click();
        Thread.sleep(2000);


        driver.findElements(By.tagName("button")).get(4).click();
        Thread.sleep(2000);
        //for assert the confirmation message
        String actualConfirmation = driver.findElements(By.tagName("ul")).get(9).getText();
        String expectedConfirmation = "User successfully registered.";

        Assertions.assertEquals(expectedConfirmation, actualConfirmation);

    }

    @AfterAll
    public void tearDown(){
        //For close the browser
        driver.quit();
    }
}
