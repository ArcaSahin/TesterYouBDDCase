package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewMovieDetailPage {
	
	WebDriver driver;
	private PhotoGalleryPage photogallerypage;
	
	@FindBy(xpath="//div[@data-testid='title-pc-wide-screen']//div[@class='ipc-metadata-list-item__content-container']")
	WebElement directorInfoTxt;

	@FindBy(xpath="//div[@data-testid='title-pc-wide-screen']//li[2]//div[@class='ipc-metadata-list-item__content-container']")
	WebElement writerInfoTxt;

	@FindBy(xpath="//div[@data-testid='title-pc-wide-screen']//li[3]//div[@class='ipc-metadata-list-item__content-container']")
	WebElement starsInfoTxt;
	
	@FindBy(xpath="//*[@class='ipc-title__text' and contains(text(), 'Photos')]")
	WebElement photosTitle;

	public NewMovieDetailPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement saveNewDirectorsInfoText() {
		directorInfoTxt.getText();
		return directorInfoTxt;
	}
	
	public WebElement saveNewWritersInfoText() {  
		writerInfoTxt.getText();
		return writerInfoTxt;
	}
	
	public WebElement saveNewStarsInfoText() {
		starsInfoTxt.getText();
		return starsInfoTxt;
	}
	
	public PhotoGalleryPage goToPhotos() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		photosTitle.click();
		return photogallerypage;
	}
}
