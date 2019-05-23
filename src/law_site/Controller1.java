package law_site;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class Controller1 {
	
	private static LawSiteDAO dao = new LawSiteDAO();
	
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