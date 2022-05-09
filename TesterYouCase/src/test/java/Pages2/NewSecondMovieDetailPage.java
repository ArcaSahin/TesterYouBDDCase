package Pages2;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pages.PhotoGalleryPage;

public class NewSecondMovieDetailPage {
	
	WebDriver driver;
	private NewPhotoGalleryPage newphotogallerypage;
	
	@FindBy(xpath="//div[@data-testid='title-pc-wide-screen']//div[@class='ipc-metadata-list-item__content-container']")
	WebElement directorInfoTxt;

	@FindBy(xpath="//div[@data-testid='title-pc-wide-screen']//li[2]//div[@class='ipc-metadata-list-item__content-container']")
	WebElement writerInfoTxt;

	@FindBy(xpath="//div[@data-testid='title-pc-wide-screen']//li[3]//div[@class='ipc-metadata-list-item__content-container']")
	WebElement starsInfoTxt;
	
	@FindBy(xpath="//*[@class='ipc-title__text' and contains(text(), 'Photos')]")
	WebElement photosTitle;

	public NewSecondMovieDetailPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public NewSecondMovieDetailPage scrollDown() {
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
	
	public NewPhotoGalleryPage goToPhotos() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		photosTitle.click();
		return newphotogallerypage;
	}

}
