import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest {
    @Test
    public void zipCodeShouldAccept5Digits() {
        //открытие страницы https://www.sharelane.com/cgi-bin/register.py
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        //ввести 5 цифр

        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");

        //нажимаем кнопку Continue
        WebElement continueButton = driver.findElement(By.cssSelector("[value = Continue]"));
        continueButton.click();
        //должны убедиться, что мы на странице sing up
        boolean isDisplayed = driver.findElement(By.cssSelector("[value = Register]")).isDisplayed();
        Assert.assertEquals(isDisplayed, true);
        //закрыть браузер
        driver.quit();
    }

    @Test
    public void zipCodeShouldAccept6Digits(){
        // Открытие страницы https://www.sharelane.com/cgi-bin/register.py
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        //ввести 6 цифр
        WebElement zipCodeInput  = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("123456");
        //нажимаем кнопку Continue;
        WebElement continueButton = driver.findElement(By.cssSelector("[value = Continue]"));
        continueButton.click();
        //убедиться,что мы не перешли на страничку sign up в свяхи с ошибкой
        boolean isDisplayed  = driver.findElement(By.cssSelector("<span class=\"error_message\">Oops, error on page. ZIP code should have 5 digits</span>")).isDisplayed();
        Assert.assertEquals(isDisplayed,false);
        //закрыть браузер
        driver.quit();
    }

    @Test
    public void zipCodeShouldAccept4Digits(){

        //Открытие страницы https://www.sharelane.com/cgi-bin/register.py
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        //Ввести 4 цифры
        WebElement zipCodeInput4 = driver.findElement(By.name("zip_code"));
        zipCodeInput4.sendKeys("1234");
        //Нажать кнопку Continue
        WebElement continueButton4 = driver.findElement(By.cssSelector("[value = Continue]"));
        continueButton4.click();
        //убедиться, что мы не перешли еа страничку sign up в связи с ошибкой
        boolean isDisplayed4 =  driver.findElement(By.cssSelector("[class = error_message]")).isDisplayed();
        Assert.assertEquals(isDisplayed4, true);
        //закрыть браузер
        driver.quit();

    }


}