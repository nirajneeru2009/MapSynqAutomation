package com.mapsynq.test.desktop.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mapsynq.test.testbase.TestBase;

public class HomePage extends TestBase {

	// Page Factory / Object Repository of HomePage

	@FindBy(how = How.XPATH, using = "//a[text()='Sign in']")
	WebElement signinLink;

	@FindBy(how = How.XPATH, using = "//a[text()='Register ']")
	WebElement registerLink;

	@FindBy(how = How.XPATH, using = "//a[@href='/home/profile']")
	WebElement loggedUserLink;

	@FindBy(how = How.XPATH, using = "//div[@id='ad_toggle']")
	WebElement adToggle;

	@FindBy(how = How.XPATH, using = "//div[@id='galactio_ad']")
	WebElement galactioAd;

	// Web elements of map buttons
	@FindBy(how = How.XPATH, using = "//div[@id='OpenLayers.Control.Panel_682']//div[@title='Traffic Speed']")
	WebElement mapTrafficButton;

	@FindBy(how = How.XPATH, using = "//div[@id='OpenLayers.Control.Panel_682']//div[@title='Incidents/Alerts']")
	WebElement mapIncidentsButton;

	@FindBy(how = How.XPATH, using = "//div[@id='OpenLayers.Control.Panel_682']//div[@title='Parking']")
	WebElement mapParkingButton;

	@FindBy(how = How.XPATH, using = "//div[@id='OpenLayers.Control.Panel_682']//div[@title='Traffic Camera']")
	WebElement mapCameraButton;

	@FindBy(how = How.XPATH, using = "//div[@id='OpenLayers.Control.Panel_682']//div[@title='Toll']")
	WebElement mapTollButton;

	// Info panel buttons
	// Info-Live panel buttons
	@FindBy(how = How.XPATH, using = "//a[@data-tabid='2']")
	WebElement infoPanelLiveButton;

	@FindBy(how = How.XPATH, using = "//*[@id='news_menu']/div[1]/label[3]")
	WebElement infoPanelLiveTollsButton;

	@FindBy(how = How.XPATH, using = "//*[@id='news_menu']/div[1]/label[2]")
	WebElement infoPanelLiveCamerasButton;

	@FindBy(how = How.XPATH, using = "//*[@id='news_menu']/div[1]/label[1]")
	WebElement infoPanelLiveIncidentsButton;

	/**
	 * Initialize the HomePage page factory using PageFactory class initElement
	 * method
	 */
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * get home page title
	 * 
	 * @return home page title
	 */
	public String getHomePageTitle() {
		return driver.getTitle();
	}

	/**
	 * click on sign in link
	 * 
	 * @return sign in page object
	 */
	public SigninPage clickSigninLink() {
		signinLink.click();
		return new SigninPage();
	}

	/**
	 * get logged user's email
	 * 
	 * @return logged user's email
	 */
	public String getLoggedUser() {
		return loggedUserLink.getText();
	}

	/**
	 * close home page ad
	 */
	public void closeAd() {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.attributeContains(adToggle, "class", "ad_bar_collapse"));

		if (adToggle.getAttribute("class").contains("ad_bar_collapse")) {
			wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.attributeContains(galactioAd, "style", "right: 0px;"));
			adToggle.click();
		}
	}

	/**
	 * click register page link on home page
	 * 
	 * @return register page object
	 */
	public RegisterPage clickRegisterLink() {
		registerLink.click();
		return new RegisterPage();
	}

	/**
	 * click on traffic button
	 */
	public void clickMapTrafficViewButton() {
		mapTrafficButton.click();
	}

	/**
	 * click on incident button
	 */
	public void clickMapIncidentsViewButton() {
		mapIncidentsButton.click();
	}

	/**
	 * click on parking button
	 */
	public void clickMapParkingViewButton() {
		mapParkingButton.click();
	}

	/**
	 * click on camera button
	 */
	public void clickMapCameraViewButton() {
		mapCameraButton.click();
	}

	/**
	 * click on toll button
	 */
	public void clickMapTollViewButton() {
		mapTollButton.click();
	}

	/**
	 * verify if traffic view legend displayed after click on map traffic button
	 * 
	 * @return true if traffic view legend displayed false if traffic view legend
	 *         not displayed
	 */
	public boolean validateMapTrafficView() {
		return driver.findElement(By.xpath("//div[@id='OpenLayers.Control.Panel_676']")).isDisplayed();
	}

	/**
	 * check no of incident icons displayed on map after click on map incident
	 * button
	 * 
	 * @return no of incident icons
	 */
	public int validateMapIncidentsView() {
		int incidentCount = 0;

		int orangeConeCount = driver.findElements(By.xpath(
				"//*[@*=\"http://s3-ap-southeast-1.amazonaws.com/buckets.mapsynq.com.assets/assets/mapicons/orange_cone.png\"]"))
				.size();
		int clusIncidentCount = driver.findElements(By.xpath(
				"//*[@*=\"http://s3-ap-southeast-1.amazonaws.com/buckets.mapsynq.com.assets/assets/mapicons/clus_incident.png\"]"))
				.size();
		int tyreRedCount = driver.findElements(By.xpath(
				"//*[@*=\"http://s3-ap-southeast-1.amazonaws.com/buckets.mapsynq.com.assets/assets/mapicons/tyre_red.png\"]"))
				.size();
		int redCrossCount = driver.findElements(By.xpath(
				"//*[@*=\"http://s3-ap-southeast-1.amazonaws.com/buckets.mapsynq.com.assets/assets/mapicons/red_cross.png\"]"))
				.size();
		int roadJamCount = driver.findElements(By.xpath(
				"//*[@*=\"http://s3-ap-southeast-1.amazonaws.com/buckets.mapsynq.com.assets/assets/mapicons/road_jam.png\"]"))
				.size();

		incidentCount = orangeConeCount + clusIncidentCount + tyreRedCount + redCrossCount + roadJamCount;
		return incidentCount;

	}

	/**
	 * check no of parking icons displayed on map after click on map parking button
	 * 
	 * @return no of incident icons displayed
	 */
	public int validateMapParkingView() {
		return driver.findElements(By.xpath(
				"//*[@*=\"http://s3-ap-southeast-1.amazonaws.com/buckets.mapsynq.com.assets/assets/mapicons/clus_parking.png\"]"))
				.size();
	}

	/**
	 * check no of camera icons displayed on map after click on map camera button
	 * 
	 * @return no of camera icons displayed
	 */
	public int validateMapCameraView() {
		int clusterCameras = 0;
		int cameras = 0;
		// Find no of cluster cameras
		clusterCameras = driver.findElements(By.xpath(
				"//*[@*=\"http://s3-ap-southeast-1.amazonaws.com/buckets.mapsynq.com.assets/assets/mapicons/clus_camera.png\"]"))
				.size();

		// Find no of cameras
		cameras = driver.findElements(By.xpath(
				"//*[@*=\"http://s3-ap-southeast-1.amazonaws.com/buckets.mapsynq.com.assets/assets/mapicons/camera.png\"]"))
				.size();

		return clusterCameras + cameras;
	}

	/**
	 * check no of toll icons displayed on map after click on map toll button
	 * 
	 * @return no of toll icons displayed on map
	 */
	public int validateMapTollView() {
		int cluserTolls = 0;
		int tolls = 0;

		// Find no of cluster tolls
		cluserTolls = driver.findElements(By.xpath(
				"//*[@*=\"http://s3-ap-southeast-1.amazonaws.com/buckets.mapsynq.com.assets/assets/mapicons/clus_ERP-4b93c26202f935aa18f21d679db115c8.png\"]"))
				.size();

		// Find no of tolls
		tolls = driver.findElements(By.xpath(
				"//*[@*=\"http://s3-ap-southeast-1.amazonaws.com/buckets.mapsynq.com.assets/assets/mapicons/erp-d1f02ca6e1165ee8cd3d5ab7d75319e3.png\"]"))
				.size();

		return cluserTolls + tolls;

	}

	/**
	 * click info panel live button
	 */
	public void clickInfopanelLiveButton() {
		infoPanelLiveButton.click();
	}

	/**
	 * click live tolls button
	 */
	public void clickLiveTollsButton() {
		infoPanelLiveTollsButton.click();
	}

	/**
	 * click live camera button
	 */
	public void clickLiveCamerasButton() {
		infoPanelLiveCamerasButton.click();
	}

	/**
	 * click live incident button
	 */
	public void clickLiveIncidentsButton() {
		infoPanelLiveIncidentsButton.click();
	}

	/**
	 * select a toll from tolls list
	 * 
	 * @param tollName
	 */
	public void selectToll(String tollName) {
		// Click on toll name link --> opens a pop up window on iframe
		driver.findElement(By.linkText(tollName)).click();
	}

	/**
	 * check whether toll pop up displayed with matching toll name
	 * 
	 * @param tollname
	 * @return true toll pop up displayed with matching toll name, false toll pop up
	 *         displayed with different toll name
	 */
	public boolean validateLiveTolls(String tollname) {
		boolean tollPopupDisplayed = false;

		// points driver to iframe and verify toll name on pop up
		// iframe name is myDropdownList
		driver.switchTo().frame("myDropdownList");

		tollPopupDisplayed = driver.findElement(By.xpath("/html/body/label")).getText().equalsIgnoreCase(tollname);
		return tollPopupDisplayed;
	}

	/**
	 * select a camera from cameras list
	 * 
	 * @param cameraName
	 */
	public void selectCamera(String cameraName) {
		// Click on toll name link --> opens a pop up window on iframe
		driver.findElement(By.linkText(cameraName)).click();
	}

	/**
	 * check whether camera pop up displayed with matching camera name
	 * 
	 * @param cameraname
	 * @return true if camera pop up displayed with matching camera name, false if
	 *         camera pop up displayed with non matching camera name
	 */
	public boolean validateLiveCameras(String cameraname) {
		boolean cameraPopupDisplayed = false;

		// points driver to iframe and verify toll name on pop up
		// iframe name is myDropdownList
		driver.switchTo().frame("ifCam");

		cameraPopupDisplayed = driver.findElement(By.xpath("/html/body/div/label/b")).getText().contains(cameraname);
		return cameraPopupDisplayed;
	}

	/**
	 * select an incident from incident list
	 */
	public void selectIncident() {
		// Click on first incident of incident list --> opens a pop up window on iframe
		driver.findElement(By.xpath("//a[@id=\"Incidents0\"]")).click();
	}

	/**
	 * check whether incident pop up displayed with matching incident description
	 * 
	 * @return true if incident pop up displayed with matching incident description,
	 *         false if incident pop up displayed with matching incident description
	 */
	public boolean validateLiveIncident() {
		boolean incidentPopupDisplayed = false;
		incidentPopupDisplayed = driver.findElement(By.xpath("//*[@id='popup_contentDiv']")).getText()
				.contains(driver.findElement(By.xpath("//*[@id=\"Incidents0\"]/div")).getText());
		return incidentPopupDisplayed;
	}

}
