import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Login to Gmail
    public void login(String email, String password) {

        WebElement emailInput = driver.findElement(By.id("identifierId"));
        emailInput.sendKeys(email);
        WebElement nextButton = driver.findElement(By.id("identifierNext"));
        nextButton.click();
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys(password);
        WebElement signInButton = driver.findElement(By.id("passwordNext"));
        signInButton.click();
    }

    public void logout() {
    }
}
