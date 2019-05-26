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
	
	public static class E{
		private String name1;
		public String getname1() {
			return name1;
		}
		public void setname1(String s) {
			this.name1 = s;
		}
	}
	
	public static class NewEmp{
		private String name;
		private String surname;
		private String patron;
		private String adress;
		private int position_id;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPatron() {
			return patron;
		}
		public void setPatron(String patron) {
			this.patron = patron;
		}
		public String getSurname() {
			return surname;
		}
		public void setSurname(String surname) {
			this.surname = surname;
		}
		public String getAdress() {
			return adress;
		}
		public void setAdress(String adress) {
			this.adress = adress;
		}
		public int getPosition_id() {
			return position_id;
		}
		public void setPosition_id(int position_id) {
			this.position_id = position_id;
		}
	}
	
	public static class NewData{
		private String name;
		private String surname;
		private String patron;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPatron() {
			return patron;
		}
		public void setPatron(String patron) {
			this.patron = patron;
		}
		public String getSurname() {
			return surname;
		}
		public void setSurname(String surname) {
			this.surname = surname;
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
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public String getemployees(ModelMap model) {
		model.addAttribute("newemp", new NewEmp()); 
		model.addAttribute("idemp", new IdClient());
		model.addAttribute("changeemp", new NewEmp());
		try {
			List<Employees> employees = dao.getAllEmployees();
			model.addAttribute("employees", employees);
		} catch (HibernateException e) {
			return "error";
		}
		return "employees";
	}
	
	@RequestMapping(value = "/employees", method = RequestMethod.POST)
	public String emps_post(@ModelAttribute("newemp") NewEmp nc, @ModelAttribute("idemp") IdClient ic, 
			ModelMap model) {
		try {
			List<Employees> employees = dao.getAllEmployees();
			if(nc.name != null && nc.name.length() >= 1 && nc.surname != null && 
					nc.surname.length() >= 1) {
				People p = new People();
				p.setPerson_name(nc.name);
				p.setPerson_surname(nc.surname);
				p.setPerson_patronymic(nc.patron);
				dao.storePeople(p);
				Employees emp = new Employees();
				emp.setPerson_id(p.getId());
				emp.setPosition_id(nc.position_id);
				emp.setAdress(nc.adress);
				dao.storeEmployee(emp);
				employees = dao.getAllEmployees();
			}
				else if(ic.clientid != 0) {
					Employees d = dao.loadEmployee(ic.clientid);
					dao.deleteEmployee(d);
					employees = dao.getAllEmployees();
				}
				
			model.addAttribute("employees", employees);
		}	catch(HibernateException e) {
			return "error";
		}
		return "employees";
	}
	
	
	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	public String getClients(ModelMap model) {
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
	public String clients_post(@ModelAttribute("newclient") ClientName nc, @ModelAttribute("idclient") IdClient ic, 
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
	
	@RequestMapping(value = "/person", method = RequestMethod.GET)
	public String getPerson(@RequestParam("id") int person_id, ModelMap model) {
		try {
			People person = dao.loadPeople(person_id);
			model.addAttribute("person", person);
			model.addAttribute("newphone", new ClientName());
			model.addAttribute("newdata", new NewData());
			model.addAttribute("newemail", new E());
			List<String> phones = dao.getPersonPhones(person_id);
			List<String> emails = dao.getPersonEmails(person_id);
			model.addAttribute("phones", phones);
			model.addAttribute("emails", emails);
		} catch (HibernateException e) {
			return "error";
		}
		return "person";
	}
	
	@RequestMapping(value = "/person", method = RequestMethod.POST)
	public String Person_post(@RequestParam("id") int person_id,
			@ModelAttribute("newdata") NewData data,
			@ModelAttribute("newphone") ClientName newphone,
			@ModelAttribute("newemail") E newemail,
			ModelMap model) {
		try {
			model.addAttribute("newdata", new NewData());
			model.addAttribute("newphone", new ClientName());
			model.addAttribute("newemail", new E());
			List<String> phones = dao.getPersonPhones(person_id);
			List<String> emails = dao.getPersonEmails(person_id);
			People person = dao.loadPeople(person_id);
			model.addAttribute("person", person);
			if(data.name != null && data.name.length() >= 1 && data.surname != null && data.surname.length() >= 1 ) {
				person.setPerson_name(data.name);
				person.setPerson_surname(data.surname);
				person.setPerson_patronymic(data.patron);
				dao.updatePeople(person);
				person = dao.loadPeople(person_id);
			} else if (newphone.name != null && newphone.name.length() >= 1) {
				System.out.println(newphone.name);
				System.out.println(newemail.name1);
				Phones p = new Phones();
				p.setPhone(newphone.name);
				p.setPerson_id(person_id);
				dao.storePhone(p);
				phones = dao.getPersonPhones(person_id);
			} else if (newemail.name1 != null && newemail.name1.length() >= 1) {
				System.out.println(newphone.name);
				System.out.println(newemail.name1);
				Emails e = new Emails();
				e.setEmail(newemail.name1);
				e.setPerson_id(person_id);
				dao.storeEmail(e);
				emails = dao.getPersonEmails(person_id);
			}
			model.addAttribute("phones", phones);
			model.addAttribute("emails", emails);
		} catch (HibernateException e) {
			return "error";
		}
		return "person";
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
				cc = dao.getClientContacts(client.getClient_name());
			} else if(nn.name != null && nn.name.length() >= 1) {
				client.setClient_name(nn.name);
				dao.updateClient(client);
				client = dao.loadClient(client_id);
				cc = dao.getClientContacts(client.getClient_name());
			}
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