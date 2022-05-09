package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MovieDetailPage {

	WebDriver driver;
	private HomePage homepage;
	
	@FindBy(xpath="//div[@data-testid='title-pc-wide-screen']//div[@class='ipc-metadata-list-item__content-container']")
	WebElement directorInfoTxt;

	@FindBy(xpath="//div[@data-testid='title-pc-wide-screen']//li[2]//div[@class='ipc-metadata-list-item__content-container']")
	WebElement writerInfoTxt;

	@FindBy(xpath="//div[@data-testid='title-pc-wide-screen']//li[3]//div[@class='ipc-metadata-list-item__content-container']")
	WebElement starsInfoTxt;

	@FindBy(id="home_img_holder")
	WebElement imdbHomeBtn;

	public MovieDetailPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
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

	public HomePage clickImdbHomeBtn() throws InterruptedException {
		Thread.sleep(3000);
		imdbHomeBtn.click();
		return homepage;
	}
}
