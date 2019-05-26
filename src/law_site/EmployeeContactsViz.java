package law_site;

public class EmployeeContactsViz {
	private String person_name;
	private String person_surname;
	private String person_patronymic;
	private String adress;
	private String position;
	
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getPerson_name() {
		return person_name;
	}
	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}
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

	public void print() {
		System.out.println(this.person_name);
		System.out.println(this.person_surname);
		System.out.println(this.person_patronymic);
		System.out.println(this.adress);
		System.out.println(this.position);
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
}
