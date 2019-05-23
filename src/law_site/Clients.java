package law_site;

import java.util.Set;

public class Clients {

	private Integer id;
	private String client_name;
	private Set<ServiceHistory> service_history;
	private Set<ClientContacts> client_contacts;
 	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getClient_name() {
		return client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	public Set<ServiceHistory> getService_history() {
		return service_history;
	}

	public void setService_history(Set<ServiceHistory> service_history) {
		this.service_history = service_history;
	}

	public Set<ClientContacts> getClient_contacts() {
		return client_contacts;
	}

	public void setClient_contacts(Set<ClientContacts> client_contacts) {
		this.client_contacts = client_contacts;
	}
}
