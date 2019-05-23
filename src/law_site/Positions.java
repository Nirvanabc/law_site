package law_site;

import java.util.Set;

public class Positions {
	private Integer id;
	private String position_name;
	private Integer salary;
	private Set<Employees> employees;
	
	public Positions() {
	}
	
	public Set<Employees> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employees> employees) {
		this.employees = employees;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getPosition_name() {
		return position_name;
	}
	
	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}
	
	public Integer getSalary() {
		return salary;
	}
	
	public void setSalary(Integer salary) {
		this.salary = salary;
	}

}
