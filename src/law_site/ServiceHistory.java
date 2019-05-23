package law_site;

import java.sql.Date;
import java.util.Set;

public class ServiceHistory {
	private Integer id;
	private Integer service_type;
	private Integer client_id;
	private Date from_time;
	private Date to_time;
	private Set<EmployeesInService> employees_in_service;
	
	public Integer getService_type() {
		return service_type;
	}

	public void setService_type(Integer service_type) {
		this.service_type = service_type;
	}

	public Integer getClient_id() {
		return client_id;
	}

	public void setClient_id(Integer client_id) {
		this.client_id = client_id;
	}

	public Date getFrom_time() {
		return from_time;
	}

	public void setFrom_time(Date from_time) {
		this.from_time = from_time;
	}

	public Date getTo_time() {
		return to_time;
	}

	public void setTo_time(Date to_time) {
		this.to_time = to_time;
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
}
