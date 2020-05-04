package insta_bot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import bot_methods.BotMethods;

public class Bot {

	public static void run(String username, String password) {
		WebDriver driver = null;
		try {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://instagram.com");
			BotMethods.setLogin(username, password);
			BotMethods.setSize(driver);
			BotMethods.setPosition(driver);
			BotMethods.fillTheForm(driver);
			BotMethods.clickOnNotNow(driver);
			BotMethods.clickOnPerfil(driver);
			BotMethods.clickOnFollowers(driver);
			BotMethods.scrollTheFollowersAndGetNames(driver);
			BotMethods.getSizeOfFollowersList();
			BotMethods.closeFollowers(driver);
			BotMethods.clickOnFollowing(driver);
			BotMethods.GetFollowing(driver);
			BotMethods.getSizeOfFollowingList();
			BotMethods.compareFollowers();
			BotMethods.printNamesOfNotFollowingBack();
			BotMethods.closeBrowser(driver);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if(driver != null) {
				driver.close();
			}
		}

	}

}
