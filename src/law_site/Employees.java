package law_site;

import java.util.Set;

public class Employees {
	private Integer id;
	private Integer person_id;
	private Integer position_id;
	private String adress;
	private Set<EmployeesInService> employees_in_service;
	
	public Integer getPerson_id() {
		return person_id;
	}

	public void setPerson_id(Integer person_id) {
		this.person_id = person_id;
	}

	public Integer getPosition_id() {
		return position_id;
	}

	public void setPosition_id(Integer position_id) {
		this.position_id = position_id;
	}

	public Set<EmployeesInService> getEmployees_in_service() {
		return employees_in_service;
	}

	public void setEmployees_in_service(Set<EmployeesInService> employees_in_service) {
		this.employees_in_service = employees_in_service;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getAdress() {
		return adress;
	}
	
	public void setAdress(String adress) {
		this.adress = adress;
	}

}
