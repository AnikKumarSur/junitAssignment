import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class practiceWebform {

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
    public void visitUrl(){
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        //For get the title of the page
        String actualTitle = driver.getTitle();
        String expectedTitle = "Practice webform for learners | Digital Unite";
        Assertions.assertTrue(actualTitle.equals(expectedTitle));

    }
}
