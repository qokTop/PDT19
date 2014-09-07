package com.addressbook.tests;


public class ContactData implements Comparable<ContactData> {
	
	private String firstName;
	private String lastName;
	private String address;
	private String home;
	private String mobile;
	private String work;
	private String email;
	private String email2;
	private String birthDay;
	private String birthMonth;
	private String birthYear;
	private String group;
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getHome() {
		return home;
	}

	public String getMobile() {
		return mobile;
	}

	public String getWork() {
		return work;
	}

	public String getEmail() {
		return email;
	}

	public String getEmail2() {
		return email2;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public String getBirthMonth() {
		return birthMonth;
	}

	public String getBirthYear() {
		return birthYear;
	}

	public String getGroup() {
		return group;
	}

	public String getSecondaryAddress() {
		return secondaryAddress;
	}

	public String getSecondaryHome() {
		return secondaryHome;
	}

	private String secondaryAddress;
	private String secondaryHome;
	
	public ContactData() {		
	}

	@Override
	public int compareTo(ContactData other) {
		return this.lastName.toLowerCase().compareTo(other.lastName.toLowerCase());
	}

	@Override
	public String toString() {
		return "ContactData [firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", home=" + home + ", mobile="
				+ mobile + ", work=" + work + ", email=" + email + ", email2="
				+ email2 + ", birthDay=" + birthDay + ", birthMonth="
				+ birthMonth + ", birthYear=" + birthYear + ", group=" + group
				+ ", secondaryAddress=" + secondaryAddress + ", secondaryHome="
				+ secondaryHome + "]";
	}

	@Override
	public int hashCode() {
		//final int prime = 31;
		int result = 1;
		/*result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());*/
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	public ContactData withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	
	public ContactData withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	
	public ContactData withAddress(String address) {
		this.address = address;
		return this;
	}
	
	public ContactData withHome(String home) {
		this.home = home;
		return this;
	}
	
	public ContactData withMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}
	
	public ContactData withWork(String work) {
		this.work = work;
		return this;
	}
	
	public ContactData withEmail(String email) {
		this.email = email;
		return this;
	}
	
	public ContactData withEmail2(String email2) {
		this.email2 = email2;
		return this;
	}

	public ContactData withBirthDay(String birthDay) {
		this.birthDay = birthDay;
		return this;
	}
	
	public ContactData withBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
		return this;
	}
	
	public ContactData withBirthYear(String birthYear) {
		this.birthYear = birthYear;
		return this;
	}
	
	public ContactData withSecondaryAddress(String secondaryAddress) {
		this.secondaryAddress = secondaryAddress;
		return this;
	}
	
	public ContactData withSecondaryHome(String secondaryHome) {
		this.secondaryHome = secondaryHome;
		return this;
	}

	public ContactData withGroup(String group) {
		this.group = group;
		return this;	
	}

}