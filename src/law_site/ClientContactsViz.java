package law_site;

public class ClientContactsViz {
	private String client_name;
	private String client_work_adress;
	private String client_represent_name;
	private String client_represent_surname;
	private String client_represent_patronymic;
	private String email;
	private String phone;
	
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	public String getClient_work_adress() {
		return client_work_adress;
	}
	public void setClient_work_adress(String client_work_adress) {
		this.client_work_adress = client_work_adress;
	}
	public String getClient_represent_name() {
		return client_represent_name;
	}
	public void setClient_represent_name(String client_represent_name) {
		this.client_represent_name = client_represent_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getClient_represent_surname() {
		return client_represent_surname;
	}
	public void setClient_represent_surname(String client_represent_surname) {
		this.client_represent_surname = client_represent_surname;
	}
	public String getClient_represent_patronymic() {
		return client_represent_patronymic;
	}
	public void setClient_represent_patronymic(String client_represent_patronymic) {
		this.client_represent_patronymic = client_represent_patronymic;
	}
	
	public void print() {
		System.out.println(this.client_name);
		System.out.println(this.client_represent_name);
		System.out.println(this.client_represent_surname);
		System.out.println(this.client_represent_patronymic);
		System.out.println(this.client_work_adress);
		System.out.println(this.email);
		System.out.println(this.phone);
	}
}
