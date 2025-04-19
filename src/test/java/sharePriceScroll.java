import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class sharePriceScroll {
    WebDriver driver;
    @BeforeAll
    public void setUP(){
        driver = new ChromeDriver();
        //For window size maximize
        driver.manage().window().maximize();
        //For create implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

    @Test
    public void dataScrapFromWebTable() throws IOException {
        driver.get("https://dsebd.org/latest_share_price_scroll_by_value.php");

        WebElement table = driver.findElement(By.className("table-responsive"));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/src/test/resources/ScrapData.txt"))) {

            //Extract and Print table header
            List<WebElement> allHeaders = driver.findElements(By.xpath("//th[not(contains(@class, 'floatThead-col'))]"));

            //System.out.println("Main Table Headers:");
            for (WebElement header : allHeaders) {
                String text = header.getText().trim();
                if (!text.isEmpty()) {
                    System.out.print(text);
                    writer.write(text+"  ");
                }
            }
            // Extract and print data rows

            List<WebElement> dataRows = table.findElements(By.tagName("tr"));
            int rowIndex = 0;
            for (WebElement row : dataRows) {
                List<WebElement> cells = row.findElements(By.tagName("td"));
                if (!cells.isEmpty()) {
                    rowIndex++;
                    //writer.write(" + rowIndex + );
                    writer.newLine();
                    for (WebElement cell : cells) {
                        String cellText = cell.getText();
                        System.out.println(cellText+"  ");
                        writer.write(cellText+"  ");
                        //writer.newLine();
                    }
                }
            }

        System.out.println("Data written to ScrapData.txt successfully.");
    }


    catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }


        }



    @AfterAll
    public void tearDown(){
        //For close the browser
        driver.quit();
    }
}
