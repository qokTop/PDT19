package com.addressbook.tests;


public class ContactData implements Comparable<ContactData> {
	
	public String firstName;
	public String lastName;
	public String address;
	public String home;
	public String mobile;
	public String work;
	public String email;
	public String email2;
	public String birthDay;
	public String birthMonth;
	public String birthYear;
	public String group;
	public String secondaryAddress;
	public String secondaryHome;
	
	public ContactData() {		
	}

	@Override
	public int compareTo(ContactData other) {
		return this.lastName.toLowerCase().compareTo(other.lastName.toLowerCase());
	}

	@Override
	public String toString() {
		return "ContactData [lastName=" + lastName + "]";
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

}