package Pages2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.AwardsPage;
import Pages.MovieDetailPage;

public class GrammyAwardsPage {

	WebDriver driver;
	private SecondMovieDetailPage secondmoviedetailpage;
	WebDriverWait wait;
	
	@FindBy(xpath="//a[@href='/title/tt0080948/?ref_=ev_nom']")
	WebElement movieTitle;
		
	public GrammyAwardsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public GrammyAwardsPage clickYearBtn() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/event/ev0000301/1982/1/?ref_=ev_eh']"))).click();
		return this;
	}
	
	public GrammyAwardsPage scrollDownAndFindMovie() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1500)");
        return this;
	}
	
	public SecondMovieDetailPage clickMovieTitle() {
		movieTitle.click();
		return secondmoviedetailpage;
	}
}
