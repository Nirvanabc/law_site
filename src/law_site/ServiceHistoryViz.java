package law_site;

import java.sql.Timestamp;

public class ServiceHistoryViz {
	private String client_name;
	private String service_name;
	private Timestamp from_time;
	private Timestamp to_time;
	
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	public String getService_name() {
		return service_name;
	}
	public void setService_name(String service_name) {
		this.service_name = service_name;
	}
	
	public Timestamp getFrom_time() {
		return from_time;
	}
	public void setFrom_time(Timestamp from_time) {
		this.from_time = from_time;
	}
	public Timestamp getTo_time() {
		return to_time;
	}
	public void setTo_time(Timestamp to_time) {
		this.to_time = to_time;
	}
	
	public void print() {
		System.out.println(this.client_name);
		System.out.println(this.service_name);
		System.out.println(this.from_time);
		System.out.println(this.to_time);
	}
}
