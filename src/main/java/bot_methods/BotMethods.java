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
	static List<String> followersList = new ArrayList();
	static List<String> followingList = new ArrayList();
	static List<String> notFollowingBack = new ArrayList();

	public static void setLogin(String username, String password) {
		USER = username;
		PASSWORD = password;
	}

	private static void sleep(final int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void setPosition(WebDriver driver) {
		Point target = new Point(-8, 0);
		driver.manage().window().setPosition(target);
	}

	public static void getPosition(WebDriver driver) {
		sleep(5000);
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
		sleep(3000);
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
		sleep(4000);
		driver.findElement(By.xpath("//button[contains(text(), 'Agora não')]")).click();
	}

	public static void clickOnPerfil(WebDriver driver) {
		sleep(2000);
		WebElement perfil = driver.findElement(By.xpath("//a[@href=\"/" + USER + "/\"]"));
		perfil.click();
	}

	public static void clickOnFollowers(WebDriver driver) {
		sleep(3000);
		WebElement followers = driver.findElement(By.xpath("//a[@href=\"/" + USER + "/followers/\"]"));
		followers.click();
	}

	// TODO Remove this method from the coode.
	public static void fillListOfFollowers(WebDriver driver) {
		List<WebElement> users = new ArrayList();
		users = driver.findElements(By.className("FPmhX notranslate  _0imsa "));
		for (WebElement user : users) {
			if (user.getText() != "") {
				System.out.println(user.getText());
				followersList.add(user.getText());
			}
		}
	}

	// TODO Modify the code. Make the scroll method dinamic.
	public static void scrollTheFollowersAndGetNames(WebDriver driver) {
		sleep(1500);

		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		WebElement scrollBox = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]"));

		for (int i = 0; i < 18; i++) {
			javascriptExecutor.executeScript("arguments[0].scrollBy(0,arguments[0].scrollHeight)", scrollBox);
			sleep(1500);
		}

		List<WebElement> followers = scrollBox.findElements(By.tagName("a"));
		for (WebElement follower : followers) {
			if (!follower.getText().isEmpty()) {
				followersList.add(follower.getText());
				System.out.println(follower.getText());
			}
		}

	}

	public static void GetFollowing(WebDriver driver) {
		sleep(1500);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement scrollBox = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]"));

		for (int i = 0; i < 24; i++) {
			jsExecutor.executeScript("arguments[0].scrollBy(0, arguments[0].scrollHeight)", scrollBox);
			sleep(2000);
		}

		List<WebElement> following = scrollBox.findElements(By.tagName("a"));
		for (WebElement user : following) {
			if (!user.getText().isEmpty()) {
				followingList.add(user.getText());
				System.out.println(user.getText());
			}
		}
	}
	
	public static void closeFollowers(WebDriver driver) {
		sleep(3000);
		WebElement closeButton = driver.findElement(By.cssSelector("[aria-label=\"Fechar\"]"));
		closeButton.click();
	}

	public static void clickOnFollowing(WebDriver driver) {
		sleep(3000);
		WebElement following = driver.findElement(By.xpath("//a[@href=\"/" + USER + "/following/\"]"));
		following.click();
	}

	public static void getSizeOfFollowersList() {
		System.out.println("_________________________________");
		System.out.println("Size of the followers list: " + followersList.size());
		System.out.println("_________________________________");
	}
	
	public static void getSizeOfFollowingList() {
		System.out.println("_________________________________");
		System.out.println("Size of the following list: " + followingList.size());
		System.out.println("_________________________________");
	}
	
	public static void compareFollowers() {
		for (String user : followingList) {
		  if (!followersList.contains(user)) {
			  notFollowingBack.add(user);
		  }
		}
		System.out.println("_______________________________________");
		System.out.println("Size of the not following back list: " + notFollowingBack.size());
		System.out.println("_______________________________________");
	}
	
	public static void printNamesOfNotFollowingBack () {
		for (String user : notFollowingBack) {
			System.out.println(user);
		}
	}

}
