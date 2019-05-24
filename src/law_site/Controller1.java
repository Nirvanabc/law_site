package law_site;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/")
public class Controller1 {
	
	private static LawSiteDAO dao = new LawSiteDAO();
	
	public static class NewClient{
		private String name;
		public String getname() {
			return name;
		}
		public void setname(String s) {
			this.name = s;
		}
	}
	
	
	public static class ClientInfo{
		private String name;
		public String getname() {
			return name;
		}
		public void setname(String s) {
			this.name = s;
		}
	}
	
	public static class CourseName{
		private String cname;
		public String getcname() {
			return cname;
		}
		public void setcname(String s) {
			this.cname = s;
		}
	}
	
	public static class ClientId{
		private int clientid;
		public int getclientid() {
			return clientid;
		}
		public void setclientid(int clientid) {
			this.clientid = clientid;
		}
	}
	
	@RequestMapping(value = "/client_represent", method = RequestMethod.GET)
	public String getClientRepresent(@RequestParam("client_id") int client_id, 
			@RequestParam("represent_id") int represent_id, ModelMap model) {
		model.addAttribute("clientinfo", new ClientInfo());
		try {
			Clients client = dao.loadClient(client_id);
			model.addAttribute("client", client);
			List<ClientContactsViz> cc = dao.getClientContacts(client.getClient_name());
			model.addAttribute("cc", cc);
		} catch (HibernateException e) {
			return "error";
		}
		return "client";
	}
	
	@RequestMapping(value = "/client", method = RequestMethod.GET)
	public String getClient(@RequestParam("id") int client_id, ModelMap model) {
		model.addAttribute("clientinfo", new ClientInfo());
		try {
			Clients client = dao.loadClient(client_id);
			model.addAttribute("client", client);
			List<ClientContactsViz> cc = dao.getClientContacts(client.getClient_name());
			model.addAttribute("cc", cc);
		} catch (HibernateException e) {
			return "error";
		}
		return "client";
	}
	
	@RequestMapping(value = "/client", method = RequestMethod.POST)
	public String client_post(@RequestParam("id") Integer client_id, 
			@ModelAttribute("clientinfo") ClientInfo cin, 
			ModelMap model) {
		try {
			Clients client = dao.loadClient(client_id);
			model.addAttribute("client", client);
			String name = client.getClient_name();
			List<ClientContactsViz> cc = dao.getClientContacts(client.getClient_name());
			model.addAttribute("name", name);
			model.addAttribute("сс", cc);
		}	catch(HibernateException e) {
			return "error";
		}
		return "client";
	}
	
	@RequestMapping(value = "/123", method = RequestMethod.GET)
	public String get123(ModelMap model) {
		return "123";
	}
	
	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	public String getClients(ModelMap model) {

		try {
			List<Clients> clients = dao.getAllClients();
			model.addAttribute("clients", clients);
			model.addAttribute("clientid", new ClientId());
			model.addAttribute("newclient", new NewClient());
		} catch (HibernateException e) {
			return "error";
		}
		return "clients";
	}
	
	@RequestMapping(value = "/clients", method = RequestMethod.POST)
	public String clients_post(@ModelAttribute("newclient") NewClient nc, 
			@ModelAttribute("clientid") ClientId ci, ModelMap model) {
		try {
			List<Clients> clients = dao.getAllClients();
			
			if(nc.name != null && nc.name != null && nc.name.length() >= 1) {
				Clients client = new Clients();
				client.setClient_name(nc.name);
				dao.storeClient(client);
				clients = dao.getAllClients();
			} else if(ci.clientid != 0) {
				Clients deleted = dao.loadClient(ci.clientid);
				dao.deleteClient(deleted);
				clients = dao.getAllClients();
			}
			model.addAttribute("clients", clients);
		} catch(HibernateException e) {
			return "error";
		}
		return "clients";
 
	}
	
	
}