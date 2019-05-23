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
	
	public static class ClientInfo{
		private String name;
		public String getname() {
			return name;
		}
		public void setname(String s) {
			this.name = s;
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
	
	@RequestMapping(value = "/client", method = RequestMethod.GET)
	public String getLesson(@RequestParam("id") int client_id, ModelMap model) {
		model.addAttribute("clientinfo", new ClientInfo());
		model.addAttribute("idstudent", new ClientId());
		try {
			Clients client = dao.loadClient(client_id);
			model.addAttribute("client", client);
		} catch (HibernateException e) {
			return "error";
		}
		return "client";
	}
	
	@RequestMapping(value = "/client", method = RequestMethod.POST)
	public String lesson_post(@RequestParam("id") Integer client_id, @ModelAttribute("clientinfo") ClientInfo cin, 
		ModelMap model) {
		try {
			Clients client = dao.loadClient(client_id);
			model.addAttribute("client", client);
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
		} catch (HibernateException e) {
			return "error";
		}
		return "clients";
	}
	
	@RequestMapping(value = "/clients", method = RequestMethod.POST)
	public String clients_post(ModelMap model) {
		try {
			List<Clients> clients = dao.getAllClients();
			model.addAttribute("clients", clients);
		} catch(HibernateException e) {
			return "error";
		}
		return "clients";
 
	}
	
	
}