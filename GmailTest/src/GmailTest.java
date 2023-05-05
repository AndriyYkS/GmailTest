import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GmailTest {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // Set up the webdriver and navigate to Gmail login page
        System.setProperty("chromeoptions.args", "--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "C:/Users/ZenBook/git/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://mail.google.com/");

        // Instantiate LoginPage and call login method
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("mailboxfortest@gmail.com", "123456789");

        // Instantiate ComposeEmailPage and call composeEmail method
        ComposeEmailPage composeEmailPage = new ComposeEmailPage(driver);
        composeEmailPage.composeEmail("mailboxfortest@gmail.com", "Test Email", "This is a test email.");

        // Verify email received
        WebElement inboxLink = driver.findElement(By.xpath("//a[contains(@href, 'inbox')]"));
        inboxLink.click();
        WebElement emailSubject = driver.findElement(By.xpath("//span[text()='Test Email']"));
        String actualSubject = emailSubject.getText();
        WebElement emailBody = driver.findElement(By.xpath("//span[text()='This is a test email.']"));
        String actualBody = emailBody.getText();

        // Verify the email subject and body are correct
        if (actualSubject.equals("Test Email") && actualBody.equals("This is a test email.")) {
            System.out.println("Email received with correct subject and body.");
        } else {
            System.out.println("Error: Email not received or incorrect subject and body.");
        }

        // Instantiate LoginPage and call logout method
        LoginPage logoutPage = new LoginPage(driver);
        logoutPage.logout();

        driver.quit();
    }

}
