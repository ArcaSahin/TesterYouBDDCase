package Pages2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.NewMovieDetailPage;

public class NewResultsPage {

	WebDriver driver;
	WebDriverWait wait;
	private NewSecondMovieDetailPage newsecondmoviedetailpage;
	
	@FindBy(partialLinkText="The Jazz Singer")
	WebElement movieTitle;

	public NewResultsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public NewSecondMovieDetailPage goToNewMovieDetailPage() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(movieTitle)).click();
		return newsecondmoviedetailpage;
	}
}
