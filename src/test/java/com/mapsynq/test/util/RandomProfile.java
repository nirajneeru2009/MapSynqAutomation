package com.mapsynq.test.util;

public class RandomProfile {
	String firstName;
	String lastName;
	String country;
	String address;
	String contact;
	boolean gender;
	String dob;
	String email;
	String username;
	String password;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", country='" + country + '\''
				+ ", address='" + address + '\'' + ", contact='" + contact + '\'' + ", gender=" + gender + ", dob='"
				+ dob + '\'' + ", email='" + email + '\'' + ", username='" + username + '\'' + ", password='" + password
				+ '\'';
	}
}
