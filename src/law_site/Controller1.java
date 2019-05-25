package law_site;

import java.text.ParseException;
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
	
	public static class ClientName{
		private String name;
		public String getname() {
			return name;
		}
		public void setname(String s) {
			this.name = s;
		}
	}
	
	public static class NewRepresent{
		private String name;
		private String surname;
		private String patron;
		private String adress;
		
		public String getname() {
			return name;
		}
		public void setname(String s) {
			this.name = s;
		}
		public String getSurname() {
			return surname;
		}
		public void setSurname(String surname) {
			this.surname = surname;
		}
		public String getPatron() {
			return patron;
		}
		public void setPatron(String patron) {
			this.patron = patron;
		}
		public String getAdress() {
			return adress;
		}
		public void setAdress(String adress) {
			this.adress = adress;
		}
	}
	
	public static class IdClient{
		private int clientid;
		public int getclientid() {
			return clientid;
		}
		public void setclientid(int clientid) {
			this.clientid = clientid;
		}
	}
	
	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	public String getLessons(ModelMap model) {
		model.addAttribute("newclient", new ClientName()); 
		model.addAttribute("idclient", new IdClient());
		model.addAttribute("clientname", new ClientName());
		try {
			List<Clients> clients = dao.getAllClients();
			model.addAttribute("clients", clients);
		} catch (HibernateException e) {
			return "error";
		}
		return "clients";
	}
	
	@RequestMapping(value = "/clients", method = RequestMethod.POST)
	public String lessons_post(@ModelAttribute("newclient") ClientName nc, @ModelAttribute("idclient") IdClient ic, 
			@ModelAttribute("clientname") ClientName cn,  ModelMap model) {
		try {
			List<Clients> clients = dao.getAllClients();
			if(nc.name != null && nc.name.length() >= 1) {
				Clients client = new Clients();
				client.setClient_name(nc.name);
				dao.storeClient(client);
				clients = dao.getAllClients();
			}
				else if(ic.clientid != 0) {
					Clients deleted = dao.loadClient(ic.clientid);
					dao.deleteClient(deleted);
					clients = dao.getAllClients();
				}
				
			model.addAttribute("clients", clients);
		}	catch(HibernateException e) {
			return "error";
		}
		return "clients";
 
	}
	
	@RequestMapping(value = "/client_represent", method = RequestMethod.GET)
	public String getClientRepresent(@RequestParam("client_id") int client_id, 
			@RequestParam("represent_id") int represent_id, ModelMap model) {
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
	
	@RequestMapping(value = "/client_represent", method = RequestMethod.POST)
	public String ClientRepresent_post(@RequestParam("client_id") int client_id, 
			@RequestParam("represent_id") int represent_id, ModelMap model) {
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
		try {
			Clients client = dao.loadClient(client_id);
			model.addAttribute("client", client);
			model.addAttribute("newrepr", new NewRepresent());
			model.addAttribute("newclientname", new ClientName());
			List<ClientContactsViz> cc = dao.getClientContacts(client.getClient_name());
			model.addAttribute("cc", cc);
		} catch (HibernateException e) {
			return "error";
		}
		return "client";
	}
	
	@RequestMapping(value = "/client", method = RequestMethod.POST)
	public String client_post(@RequestParam("id") int client_id,
			@ModelAttribute("newclientname") ClientName nn,
			@ModelAttribute("newrepr") NewRepresent nr,
			ModelMap model) {
		try {
			Clients client = dao.loadClient(client_id);
			model.addAttribute("client", client);
			model.addAttribute("newrepr", new NewRepresent());
			model.addAttribute("newclientname", new ClientName());
			String name = client.getClient_name();
			List<ClientContactsViz> cc = dao.getClientContacts(client.getClient_name());
			model.addAttribute("name", name);
			
		    if(nr.name != null && nr.name.length() >= 1 && nr.surname != null && nr.surname.length() >= 1 ) {
				People person = new People();
				person.setPerson_name(nr.name);
				person.setPerson_surname(nr.surname);
				person.setPerson_patronymic(nr.patron);
				dao.storePeople(person);
				ClientContacts ncc = new ClientContacts();
				ncc.setAdress(nr.adress);
				ncc.setClient_id(client_id);
				ncc.setPerson_id(person.getId());
				dao.storeClientContact(ncc);
			} else if(nn.name != null && nn.name.length() >= 1) {
				client.setClient_name(nn.name);
				dao.updateClient(client);
				client = dao.loadClient(client_id);
			}
			cc = dao.getClientContacts(client.getClient_name());
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

}