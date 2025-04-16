import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }
    @Test
    public void visitURL(){
        driver.get("https://demo.wpeverest.com/user-registration/guest-registration-form/");
        //For get the title of the page
        String actualTitle = driver.getTitle();
        String expectedTitle = "Guest Registration Form – User Registration";
        //For assert the title of the page
        Assertions.assertEquals(expectedTitle, actualTitle);
    }
    @Test
    public void fillUpUserForm() throws InterruptedException {
        driver.get("https://demo.wpeverest.com/user-registration/guest-registration-form/");
        //find tagName locator for every field
        List<WebElement> inputField = driver.findElements(By.tagName("input"));

        //Fill up the fields
        inputField.get(4).sendKeys("Test");
        Thread.sleep(2000);
        inputField.get(7).sendKeys("user");
        Thread.sleep(2000);
        inputField.get(5).sendKeys("testuser3@gmail.com");
        Thread.sleep(2000);
        inputField.get(6).sendKeys("bangla@anik03");
        Thread.sleep(2000);
        inputField.get(8).click();
        Thread.sleep(2000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
        Thread.sleep(2000);

        inputField.get(11).sendKeys("2025-05-04");
        Thread.sleep(2000);
        inputField.get(16).sendKeys("Bangladeshi");
        Thread.sleep(2000);

        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
        Thread.sleep(2000);

        inputField.get(14).sendKeys("1743255525");
        Thread.sleep(2000);
        driver.findElement(By.id("country_1665629257")).click();
        Thread.sleep(2000);


        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
        Thread.sleep(2000);
        inputField.get(15).sendKeys("1628734284");
        Thread.sleep(2000);
        inputField.get(17).sendKeys("2024-05-04");
        Thread.sleep(2000);


        inputField.get(20).sendKeys("30");
        Thread.sleep(2000);
        inputField.get(21).sendKeys("321 45");
        Thread.sleep(2000);
        JavascriptExecutor js3 = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
        Thread.sleep(2000);

        driver.findElement(By.id("textarea_1665630078")).sendKeys("There are several terms employers use when talking about someone’s professional experience. With so many ways to talk about experience.");
        Thread.sleep(5000);
        inputField.get(22).click();
        Thread.sleep(2000);

        inputField.get(24).click();
        Thread.sleep(2000);

        JavascriptExecutor js4 = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
        Thread.sleep(2000);

        inputField.get(28).click();
        Thread.sleep(2000);

        inputField.get(33).click();
        Thread.sleep(2000);

        JavascriptExecutor js5 = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
        Thread.sleep(2000);

        //driver.findElement(By.id("textarea_1665630078")).sendKeys("There are several terms employers use when talking about someone’s professional experience. With so many ways to talk about experience, it’s important to clearly understand the word \"occupation\" so you can speak about yours clearly and accurately.");
       // driver.findElements(By.className("ur-frontend-field")).get(15).sendKeys("Hey this is me");
        //Thread.sleep(2000);
        inputField.get(22).click();
        Thread.sleep(2000);

        JavascriptExecutor js6 = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
        Thread.sleep(2000);

        driver.findElements(By.tagName("button")).get(4).click();
        Thread.sleep(2000);






    }

    //@AfterAll
    public void tearDown(){
        //For close the browser
        driver.quit();
    }
}
