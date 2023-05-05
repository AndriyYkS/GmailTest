import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ComposeEmailPage {
    private WebDriver driver;

    public ComposeEmailPage(WebDriver driver) {
        this.driver = driver;
    }

    // Compose new email
    public void composeEmail(String recipientEmail, String subject, String body) {

        WebElement composeButton = driver.findElement(By.xpath("//div[text()='Compose']"));
        composeButton.click();
        WebElement toInput = driver.findElement(By.name("to"));
        toInput.sendKeys(recipientEmail);
        WebElement subjectInput = driver.findElement(By.name("subjectbox"));
        subjectInput.sendKeys(subject);
        WebElement bodyInput = driver.findElement(By.xpath("//div[@aria-label='Message Body']"));
        bodyInput.sendKeys(body);
        WebElement sendButton = driver.findElement(By.xpath("//div[text()='Send']"));
        sendButton.click();
    }
}
