package com.mapsynq.test.desktop.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mapsynq.test.testbase.TestBase;
import com.mapsynq.test.util.ProfileGenerator;
import com.mapsynq.test.util.RandomProfile;

public class RegisterPage extends TestBase {

	// Page Factory / Object Repository of RegisterPage

	@FindBy(how = How.ID, using = "profile_first_name")
	WebElement firstname;

	@FindBy(how = How.ID, using = "profile_last_name")
	WebElement lastname;

	@FindBy(how = How.ID, using = "profile_country")
	WebElement country;

	@FindBy(how = How.ID, using = "profile_address")
	WebElement address;

	@FindBy(how = How.ID, using = "profile_contact_no")
	WebElement contactNo;

	@FindBy(how = How.ID, using = "profile_gender_M")
	WebElement radioButtonMale;

	@FindBy(how = How.ID, using = "profile_gender_F")
	WebElement radioButtonFemale;

	@FindBy(how = How.ID, using = "profile_dob")
	WebElement dobField;

	@FindBy(how = How.ID, using = "profile_email")
	WebElement email;

	@FindBy(how = How.ID, using = "user_name")
	WebElement username;

	@FindBy(how = How.ID, using = "password")
	WebElement password;

	@FindBy(how = How.ID, using = "identity[password_confirmation]")
	WebElement confirmPassword;

	@FindBy(how = How.ID, using = "profile_subscribe_to_newsletter")
	WebElement subscribeToNewsletter;

	@FindBy(how = How.ID, using = "chk_agree")
	WebElement termsAndConditions;

	@FindBy(how = How.XPATH, using = "//input[@value='Create Profile']")
	WebElement createProfileButton;

	/**
	 * Initialize the RegisterPage, page factory using PageFactory class initElement
	 * method
	 */
	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * get register page title
	 * 
	 * @return register page title
	 */
	public String validateRegisterPageTitle() {
		return driver.getTitle();
	}

	/**
	 * create a new profile
	 */
	public void createProfile() {
		// Get random profile details using RandomPrfile and ProfileGenerator classes of
		// util package
		RandomProfile profile = ProfileGenerator.getRandomProfile();

		// Fill register page fields using random profile details
		firstname.sendKeys(profile.getFirstName());
		lastname.sendKeys(profile.getLastName());

		Select countryDropDown = new Select(country);
		countryDropDown.selectByVisibleText(profile.getCountry());

		address.sendKeys(profile.getAddress());
		contactNo.sendKeys(profile.getContact());

		// Fill gender field according to the random profile data
		if (profile.isGender()) {
			radioButtonMale.click();
		} else {
			radioButtonFemale.click();
		}

		dobField.sendKeys(profile.getDob());
		email.sendKeys(profile.getEmail());
		password.sendKeys(profile.getPassword());
		confirmPassword.sendKeys(profile.getPassword());

		// Check 'I agree to terms and conditions' check box
		termsAndConditions.click();

		// Click create profile button
		createProfileButton.click();

	}

}
