package law_site;

import java.util.Set;
import java.util.HashSet;

public class Education {
	private Integer id;
	private String education_name;
	private Set<Employees> employees = new HashSet<Employees>();
	
	
	public String getEducation_name() {
		return education_name;
	}

	public void setEducation_name(String education_name) {
		this.education_name = education_name;
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
}
