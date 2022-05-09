package Pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PhotoGalleryPage {

	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath="//div[@class='article']")
	WebElement imgFrame;

	@FindBy(xpath="//a[@class='prevnext']")
	WebElement nextBtn;

	public PhotoGalleryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public PhotoGalleryPage checkIfImageIsLoaded() throws IOException, InterruptedException {
		List<WebElement> images = imgFrame.findElements(By.tagName("img"));
		System.out.println("Total images: " + images.size());
		for(int i=0; i<images.size(); i++) {
			WebElement element = images.get(i);
			String url = element.getAttribute("src");
			URL link = new URL(url);
			HttpURLConnection httpCon = (HttpURLConnection) link.openConnection();
			httpCon.connect();

			int rescode = httpCon.getResponseCode();
			if(rescode >= 400) {
				System.out.println(url + "-" + "is broken link");
			}
			else {
				System.out.println(url + "-" + "is valid link");
			}
		}
		nextBtn.click();
		return this;
	}
	public PhotoGalleryPage checkIfSecondPartOfImageIsLoaded() throws IOException, InterruptedException {
		List<WebElement> images = imgFrame.findElements(By.tagName("img"));
		System.out.println("Total images: " + images.size());
		for(int i=0; i<images.size(); i++) {
			WebElement element = images.get(i);
			String url = element.getAttribute("src");
			URL link = new URL(url);
			HttpURLConnection httpCon = (HttpURLConnection) link.openConnection();
			httpCon.connect();

			int rescode = httpCon.getResponseCode();
			if(rescode >= 400) {
				System.out.println(url + "-" + "is broken link");
			}
			else {
				System.out.println(url + "-" + "is valid link");
			}
		}
		return this;
	}
}