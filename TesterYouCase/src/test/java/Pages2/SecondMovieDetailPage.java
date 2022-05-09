package Pages2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pages.AwardsPage;
import Pages.HomePage;

public class SecondMovieDetailPage {
	
	WebDriver driver;
	private NewHomePage newhomepage;
	
	@FindBy(xpath="//div[@data-testid='title-pc-wide-screen']//div[@class='ipc-metadata-list-item__content-container']")
	WebElement directorInfoTxt;

	@FindBy(xpath="//div[@data-testid='title-pc-wide-screen']//li[2]//div[@class='ipc-metadata-list-item__content-container']")
	WebElement writerInfoTxt;

	@FindBy(xpath="//div[@data-testid='title-pc-wide-screen']//li[3]//div[@class='ipc-metadata-list-item__content-container']")
	WebElement starsInfoTxt;

	@FindBy(id="home_img_holder")
	WebElement imdbHomeBtn;

	public SecondMovieDetailPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public SecondMovieDetailPage scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
        return this;
	}
	
	public WebElement saveDirectorsInfoText() {
		directorInfoTxt.getText();
		return directorInfoTxt;
	}

	public WebElement saveWritersInfoText() {  
		writerInfoTxt.getText();
		return writerInfoTxt;
	}

	public WebElement saveStarsInfoText() {
		starsInfoTxt.getText();
		return starsInfoTxt;
	}

	public NewHomePage clickImdbHomeBtn() throws InterruptedException {
		Thread.sleep(3000);
		imdbHomeBtn.click();
		return newhomepage;
	}
}
