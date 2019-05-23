package law_site;

import java.util.Set;

public class People {
	private Integer id;
	private String person_name;
	private String person_surname;
	private String person_patronymic;

	private Set<Phones> phones;
	private Set<Employees> employees;
	private Set<ClientContacts> client_contacts;
	private Set<Emails> emails;
	public String getPerson_surname() {
		return person_surname;
	}

	public void setPerson_surname(String person_surname) {
		this.person_surname = person_surname;
	}

	public String getPerson_patronymic() {
		return person_patronymic;
	}

	public void setPerson_patronymic(String person_patronymic) {
		this.person_patronymic = person_patronymic;
	}
	
	public String getPerson_name() {
		return person_name;
	}

	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}

	public Set<Employees> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employees> employees) {
		this.employees = employees;
	}


	public Set<ClientContacts> getClient_contacts() {
		return client_contacts;
	}

	public void setClient_contacts(Set<ClientContacts> client_contacts) {
		this.client_contacts = client_contacts;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Phones> getPhones() {
		return phones;
	}

	public void setPhones(Set<Phones> phones) {
		this.phones = phones;
	}

	public Set<Emails> getEmails() {
		return emails;
	}

	public void setEmails(Set<Emails> emails) {
		this.emails = emails;
	}
	

}
