package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultsPage {
	
	WebDriver driver;
	WebDriverWait wait;
	private NewMovieDetailPage newmoviedetailpage;
	
	@FindBy(partialLinkText="The Circus")
	WebElement movieTitle;

	public ResultsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public NewMovieDetailPage goToNewMovieDetailPage() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(movieTitle)).click();
		return newmoviedetailpage;
	}
}
