package bot_methods;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BotMethods {

	// TODO Swap all Threads for the WebDriverWait class.
	private static String USER = "";
	private static String PASSWORD = "";
	static List<String> followers = new ArrayList();

	public static void setLogin(String username, String password) {
		USER = username;
		PASSWORD = password;
	}

	public static void setPosition(WebDriver driver) {
		Point target = new Point(-8, 0);
		driver.manage().window().setPosition(target);
	}

	public static void getPosition(WebDriver driver) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(driver.manage().window().getPosition());
	}

	public static void setSize(WebDriver driver) {
		Dimension dimension = new Dimension(1094, 871);
		driver.manage().window().setSize(dimension);
	}

	public static void clickLoginButton(WebDriver driver) {
		WebElement conect = driver.findElement(By.xpath("//a[contains(text(), 'Conecte-se')]"));
		conect.click();
	}

	public static void fillTheForm(WebDriver driver) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement login = driver.findElement(By.name("username"));
		login.submit();
		login.sendKeys(USER);
		WebElement password = driver.findElement(By.name("password"));
		password.click();
		password.sendKeys(PASSWORD);
		WebElement submit = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
		submit.submit();
	}

	public static void clickOnNotNow(WebDriver driver) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//button[contains(text(), 'Agora não')]")).click();
	}

	public static void clickOnPerfil(WebDriver driver) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement perfil = driver.findElement(By.xpath("//a[@href=\"/" + USER + "/\"]"));
		perfil.click();
	}

	public static void clickOnFollowers(WebDriver driver) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement followers = driver.findElement(By.xpath("//a[@href=\"/" + USER + "/followers/\"]"));
		followers.click();
	}

	// TODO Modify the code, the code isn't working.
	public static void fillListOfFollowers(WebDriver driver) {
		List<WebElement> users = new ArrayList();
		users = driver.findElements(By.className("FPmhX notranslate  _0imsa "));
		for (WebElement user : users) {
			if (user.getText() != "") {
				System.out.println(user.getText());
				followers.add(user.getText());
			}
		}
	}

	// TODO Modify the code. Make the scroll method dinamic.
	public static void scrollTheFollowers(WebDriver driver) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		for (int i = 0; i < 17; i++) {
			WebElement scrollBox = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]"));
			JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
			javascriptExecutor.executeScript("arguments[0].scrollBy(0,arguments[0].scrollHeight)", scrollBox);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
