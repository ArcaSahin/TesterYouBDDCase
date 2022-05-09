package StepDefinitions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.AwardsPage;
import Pages.HomePage;
import Pages.LandingPage;
import Pages.MovieDetailPage;
import Pages.NewMovieDetailPage;
import Pages.OscarsPage;
import Pages.PhotoGalleryPage;
import Pages.ResultsPage;
import Pages2.AllEventsPage;
import Pages2.GrammyAwardsPage;
import Pages2.NewHomePage;
import Pages2.NewPhotoGalleryPage;
import Pages2.NewResultsPage;
import Pages2.NewSecondMovieDetailPage;
import Pages2.SecondLandingPage;
import Pages2.SecondMovieDetailPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class EndToEndTest {
	
	WebDriver driver = null;
	
	//for The Circus Movie
	LandingPage landingp;
	OscarsPage oscarsp;
	AwardsPage awardsp;
	MovieDetailPage moviedetailp;
	HomePage homep;
	ResultsPage resultsp;
	NewMovieDetailPage newmoviedetailp;
	PhotoGalleryPage photogalleryp;
	
	//for The Jazz Singer Movie
	SecondLandingPage secondlandingp;
	AllEventsPage alleventsp;
	GrammyAwardsPage grammyawardsp;
	SecondMovieDetailPage secondmoviedetailp;
	NewHomePage newhomep;
	NewResultsPage newresultsp;
	NewSecondMovieDetailPage newsecondmoviedetailp;
	NewPhotoGalleryPage newphotogalleryp;

	@Given("^browser is open$")
	public void browser_is_open() throws Throwable {
		//boni garcia method
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@And("^user is on landing page$")
	public void user_is_on_landing_page() {
		driver.navigate().to("https://www.imdb.com/");
	}

	@When("^user clicks on menu button$")
	public void user_clicks_on_menu_button() {
		landingp = new LandingPage(driver);
		landingp.clickMenuBtn();	
	}

	@And("^user clicks on oscars button from under the title of Award & Events and goes to the oscars page$")
	public void user_clicks_on_oscars_button_from_under_the_title_of_award_events_and_goes_to_the_oscars_page() {
		oscarsp = landingp.clickOscarsLink();
	}

	@And("^user selects the year from event history title and goes to the awards page$")
	public void user_selects_the_year_from_event_history_title_and_goes_to_the_awards_page() {
		oscarsp = new OscarsPage(driver);
		awardsp = oscarsp.clickYearBtn();
	}

	@And("^user selects the movie from under the title of Honorary Award and goes to the movie detail page$")
	public void user_selects_the_movie_from_under_the_title_of_honorary_award_and_goes_to_the_movie_detail_page() {
		awardsp = new AwardsPage(driver);
		awardsp.scrollDownAndFindMovie();
		moviedetailp = awardsp.clickMovieTitle();
	}

	@And("^user saves informations and clicks on IMDb button and goes back to the home page$")
	public void user_saves_informations_and_clicks_on_imdb_button_and_goes_back_to_the_home_page() throws InterruptedException {
		moviedetailp = new MovieDetailPage(driver);
		homep = moviedetailp.clickImdbHomeBtn();
	}

	@And("^user enters \"([^\"]*)\" on textbox and clicks search button and goes the results page$")
	public void user_enters_something_on_textbox_and_clicks_search_button_and_goes_the_results_page(String txt) {
		homep = new HomePage(driver);
		homep.entersTxt(txt);
		resultsp = homep.goToResultsPage();
	}

	@And("^user selects the movie goes to the new movie detail page$")
	public void user_selects_the_movie_goes_to_the_new_movie_detail_page() {
		resultsp = new ResultsPage(driver);
		newmoviedetailp = resultsp.goToNewMovieDetailPage();
	}

	@SuppressWarnings("deprecation")
	@And("^user checks if the information of director, writer and stars of the movie are matched$")
	public void user_checks_if_the_information_of_director_writer_and_stars_of_the_movie_are_matched() {
		newmoviedetailp = new NewMovieDetailPage(driver);
		Assert.assertEquals(moviedetailp.saveDirectorsInfoText(), newmoviedetailp.saveNewDirectorsInfoText());
		Assert.assertEquals(moviedetailp.saveWritersInfoText(), newmoviedetailp.saveNewWritersInfoText());
		Assert.assertEquals(moviedetailp.saveStarsInfoText(), newmoviedetailp.saveNewStarsInfoText());
		System.out.println("All Matched !");
	}

	@Then("^user clicks on photos link and goes to the photo gallery page and checks if there is any broken image$")
	public void user_clicks_on_photos_link_and_goes_to_the_photo_gallery_page_and_checks_if_there_is_any_broken_images() throws IOException, InterruptedException {
		photogalleryp = newmoviedetailp.goToPhotos();
		photogalleryp = new PhotoGalleryPage(driver);
		photogalleryp.checkIfImageIsLoaded();
		photogalleryp.checkIfSecondPartOfImageIsLoaded();
	}
	
	
	@When("^user clicks menu button$")
	public void user_clicks_menu_button() {
		secondlandingp = new SecondLandingPage(driver);
		secondlandingp.clickMenuBtn();	
	}
	
	@And("user clicks on all events from under the title of Award & Events and goes to the all events page")
	public void user_clicks_on_all_events_from_under_the_title_of_award_events_and_goes_to_the_all_events_page() {
		alleventsp = secondlandingp.clickAllEventsLink();
	}

	@And("user selects the grammy awards title and goes to the grammy awards page")
	public void user_selects_the_grammy_awards_title_and_goes_to_the_grammy_awards_page() throws InterruptedException {
		alleventsp = new AllEventsPage(driver);
		grammyawardsp = alleventsp.goToGrammyAwards();
	}

	@And("user selects the movie from under the title of Event History")
	public void user_selects_the_movie_from_under_the_title_of_event_history() {
		grammyawardsp = new GrammyAwardsPage(driver);
		grammyawardsp.clickYearBtn();
	}

	@And("user selects the movie and goes to the second movie detail page")
	public void user_selects_the_movie_and_goes_to_the_second_movie_detail_page() {
		secondmoviedetailp = grammyawardsp.clickMovieTitle();
	}

	@When("user saves second informations and clicks on IMDb button and goes back to the new home page")
	public void user_saves_second_informations_and_clicks_on_im_db_button_and_goes_back_to_the_new_home_page() throws InterruptedException {
		secondmoviedetailp = new SecondMovieDetailPage(driver);
		secondmoviedetailp.scrollDown();
		newhomep = secondmoviedetailp.clickImdbHomeBtn();
	}

	@And("user enters {string} on textbox and clicks search button and goes the new results page")
	public void user_enters_on_textbox_and_clicks_search_button_and_goes_the_new_results_page(String txt) {
		newhomep = new NewHomePage(driver);
		newresultsp = newhomep.entersTxtAndSearch(txt);
	}

	@And("user selects the movie goes to the new second movie detail page")
	public void user_selects_the_movie_goes_to_the_new_second_movie_detail_page() {
		newresultsp = new NewResultsPage(driver);
		newsecondmoviedetailp = newresultsp.goToNewMovieDetailPage();
	}

	@SuppressWarnings("deprecation")
	@When("user checks if the new information of director, writer and stars of the movie are matched")
	public void user_checks_if_the_new_information_of_director_writer_and_stars_of_the_movie_are_matched() {
		newsecondmoviedetailp = new NewSecondMovieDetailPage(driver);
		newsecondmoviedetailp.scrollDown();
		Assert.assertEquals(secondmoviedetailp.saveDirectorsInfoText(), newsecondmoviedetailp.saveDirectorsInfoText());
		Assert.assertEquals(secondmoviedetailp.saveWritersInfoText(), newsecondmoviedetailp.saveWritersInfoText());
		Assert.assertEquals(secondmoviedetailp.saveStarsInfoText(), newsecondmoviedetailp.saveStarsInfoText());
		System.out.println("All Matched !");
	}

	@Then("user clicks on photos link and goes to the new photo gallery page and checks if there is any broken image")
	public void user_clicks_on_photos_link_and_goes_to_the_new_photo_gallery_page_and_checks_if_there_is_any_broken_image() throws IOException, InterruptedException {
		newphotogalleryp = newsecondmoviedetailp.goToPhotos();
		newphotogalleryp = new NewPhotoGalleryPage(driver);
		newphotogalleryp.checkIfImageIsLoaded();
	}

	@After
	public void browserTeardown() {
		driver.close();
		driver.quit();
	}


	

}
