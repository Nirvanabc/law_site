package law_site;


import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.transform.Transformers;


public class LawSiteDAO {
	private static SessionFactory sessions = null;

	public LawSiteDAO() {
		if (sessions == null) {
			Configuration configuration = new Configuration();
			configuration.configure();
			sessions = configuration.buildSessionFactory();
		}
	}
	
	public ClientContacts loadClientContact(Integer id) {
		Session session = sessions.openSession();
		session.beginTransaction();
		ClientContacts clientContact = (ClientContacts) session.load(ClientContacts.class, id);
		session.getTransaction().commit();
		session.close();
		return clientContact;
	}
	
	public void storeClientContact(ClientContacts clientContact) {
		Session session = null;
		
		try {
			session = sessions.openSession();
			session.beginTransaction();
			session.save(clientContact);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
		}
		finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
	
	public void deleteClientContact(ClientContacts clientContact) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.delete(clientContact);
		session.getTransaction().commit();
		session.close();
	}

	public void updateClientContact(ClientContacts clientContact) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.update(clientContact);
		session.getTransaction().commit();
		session.close();
	}
	
	public List<Clients> getAllClients() {
		Session session = sessions.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Clients> list = session.createCriteria(Clients.class).list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	public Clients loadClient(Integer id) {
		Session session = sessions.openSession();
		session.beginTransaction();
		Clients client = (Clients) session.load(Clients.class, id);
		session.getTransaction().commit();
		session.close();
		return client;
	}
	
	public void storeClient(Clients client) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.save(client);
		session.getTransaction().commit();
		session.close();
	}
	
	public void deleteClient(Clients client) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.delete(client);
		session.getTransaction().commit();
		session.close();
	}

	public void updateClient(Clients client) {
		
		Session session = null;
		
		try {
		session = sessions.openSession();
		session.beginTransaction();
		session.update(client);
		session.getTransaction().commit();
		}
		finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
	
	public List<Education> getAllEducation() {
		Session session = sessions.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Education> list = session.createCriteria(Education.class).list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	
	public Education loadEducation(Integer id) {
		Session session = sessions.openSession();
		session.beginTransaction();
		Education education = (Education) session.load(Education.class, id);
		session.getTransaction().commit();
		session.close();
		return education;
	}
	
	public void storeEducation(Education education) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.save(education);
		session.getTransaction().commit();
		session.close();
	}
	
	public void deleteEducation(Education education) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.delete(education);
		session.getTransaction().commit();
		session.close();
	}

	public void updateEducation(Education education) {
		Session session = null;
		
		try {
			session = sessions.openSession();
			session.beginTransaction();
			session.update(education);
			session.getTransaction().commit();
		}
		finally {
			if (session != null && session.isOpen()) {
			session.close();
			}
		}
	}
	
	public List<Emails> getAllEmails() {
		Session session = sessions.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Emails> list = session.createCriteria(Emails.class).list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	
	public Emails loadEmail(Integer id) {
		Session session = sessions.openSession();
		session.beginTransaction();
		Emails email = (Emails) session.load(Emails.class, id);
		session.getTransaction().commit();
		session.close();
		return email;
	}
	
	public void storeEmail(Emails email) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.save(email);
		session.getTransaction().commit();
		session.close();
	}
	
	public void deleteEmail(Emails email) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.delete(email);
		session.getTransaction().commit();
		session.close();
	}

	public void updateEmail(Emails email) {
		
		Session session = null;
		try {
			session = sessions.openSession();
			session.beginTransaction();
			session.update(email);
			session.getTransaction().commit();
		}
		finally {
			if (session != null && session.isOpen()) {
			session.close();
			}
		}
	}
	
	public List<Employees> getAllEmployees() {
		Session session = sessions.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Employees> list = session.createCriteria(Employees.class).list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	
	public Employees loadEmployee(Integer id) {
		Session session = sessions.openSession();
		session.beginTransaction();
		Employees employee = (Employees) session.load(Employees.class, id);
		session.getTransaction().commit();
		session.close();
		return employee;
	}
	
	public void storeEmployee(Employees employee) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
		session.close();
	}
	
	public void deleteEmployee(Employees employee) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.delete(employee);
		session.getTransaction().commit();
		session.close();
	}

	public void updateEmployee(Employees employee) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.update(employee);
		session.getTransaction().commit();
		session.close();
	}
	
	public List<EmployeesInService> getAllEmployeesInService() {
		Session session = sessions.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<EmployeesInService> list = session.createCriteria(EmployeesInService.class).list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	
	public EmployeesInService loadEmployeeInService(Integer id) {
		Session session = sessions.openSession();
		session.beginTransaction();
		EmployeesInService employeeInService = (EmployeesInService) session.load(EmployeesInService.class, id);
		session.getTransaction().commit();
		session.close();
		return employeeInService;
	}
	
	public void storeEmployeeInService(EmployeesInService employeeInService) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.save(employeeInService);
		session.getTransaction().commit();
		session.close();
	}
	
	public void deleteEmployeeInService(EmployeesInService employeeInService) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.delete(employeeInService);
		session.getTransaction().commit();
		session.close();
	}

	public void updateEmployeeInService(EmployeesInService employeeInService) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.update(employeeInService);
		session.getTransaction().commit();
		session.close();
	}
	
	public List<People> getAllPeople() {
		Session session = sessions.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<People> list = session.createCriteria(People.class).list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	
	public People loadPeople(Integer id) {
		Session session = sessions.openSession();
		session.beginTransaction();
		People person = (People) session.load(People.class, id);
		session.getTransaction().commit();
		session.close();
		return person;
	}
	
	public void storePeople(People person) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.save(person);
		session.getTransaction().commit();
		session.close();
	}
	
	public void deletePeople(People person) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.delete(person);
		session.getTransaction().commit();
		session.close();
	}

	public void updatePeople(People person) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.update(person);
		session.getTransaction().commit();
		session.close();
	}
	
	public List<Positions> getAllPositions() {
		Session session = sessions.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Positions> list = session.createCriteria(Positions.class).list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	
	public Positions loadPosition(Integer id) {
		Session session = sessions.openSession();
		session.beginTransaction();
		Positions position = (Positions) session.load(Positions.class, id);
		session.getTransaction().commit();
		session.close();
		return position;
	}
	
	public void storePosition(Positions position) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.save(position);
		session.getTransaction().commit();
		session.close();
	}
	
	public void deletePosition(Positions position) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.delete(position);
		session.getTransaction().commit();
		session.close();
	}

	public void updatePosition(Positions position) {
		
		Session session = null;
		try {
			session = sessions.openSession();
			session.beginTransaction();
			session.update(position);
			session.getTransaction().commit();
		}
		finally {
			if (session != null && session.isOpen()) {
			session.close();
			}
		}
	}
	
	public List<Phones> getAllPhones() {
		Session session = sessions.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Phones> list = session.createCriteria(Phones.class).list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	
	public Phones loadPhone(Integer id) {
		Session session = sessions.openSession();
		session.beginTransaction();
		Phones phone = (Phones) session.load(Phones.class, id);
		session.getTransaction().commit();
		session.close();
		return phone;
	}
	
	public void storePhone(Phones phone) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.save(phone);
		session.getTransaction().commit();
		session.close();
	}
	
	public void deletePhone(Phones phone) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.delete(phone);
		session.getTransaction().commit();
		session.close();
	}

	public void updatePhone(Phones phone) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.update(phone);
		session.getTransaction().commit();
		session.close();
	}
	
	public List<ServiceHistory> getAllServiceHistory() {
		Session session = sessions.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<ServiceHistory> list = session.createCriteria(ServiceHistory.class).list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	
	public ServiceHistory loadServiceHistory(Integer id) {
		Session session = sessions.openSession();
		session.beginTransaction();
		ServiceHistory serviceHistory = (ServiceHistory) session.load(ServiceHistory.class, id);
		session.getTransaction().commit();
		session.close();
		return serviceHistory;
	}
	
	public void storeServiceHistory(ServiceHistory serviceHistory) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.save(serviceHistory);
		session.getTransaction().commit();
		session.close();
	}
	
	public void deleteServiceHistory(ServiceHistory serviceHistory) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.delete(serviceHistory);
		session.getTransaction().commit();
		session.close();
	}

	public void updateServiceHistory(ServiceHistory ServiceHistory) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.update(ServiceHistory);
		session.getTransaction().commit();
		session.close();
	}
	
	public List<ServiceTypes> getAllServiceTypes() {
		Session session = sessions.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<ServiceTypes> list = session.createCriteria(ServiceTypes.class).list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	
	public ServiceTypes loadServiceType(Integer id) {
		Session session = sessions.openSession();
		session.beginTransaction();
		ServiceTypes serviceType = (ServiceTypes) session.load(ServiceTypes.class, id);
		session.getTransaction().commit();
		session.close();
		return serviceType;
	}
	
	public void storeServiceType(ServiceTypes serviceType) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.save(serviceType);
		session.getTransaction().commit();
		session.close();
	}
	
	public void deleteServiceType(ServiceTypes serviceType) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.delete(serviceType);
		session.getTransaction().commit();
		session.close();
	}

	public void updateServiceType(ServiceTypes ServiceType) {
		Session session = sessions.openSession();
		session.beginTransaction();
		session.update(ServiceType);
		session.getTransaction().commit();
		session.close();
	}
	
	public List<String> getClientsByEmployeeSurname(String employee_surname) {
		Session session = sessions.openSession();
		session.beginTransaction();
		String sql = "select distinct client_name " +
				"from people inner join employees on people.id = employees.person_id " +
				"inner join employees_in_service on employees.id = employees_in_service.employee_id " +
				"inner join service_history on service_history.id = employees_in_service.service_id " +
				"inner join clients on clients.id = service_history.client_id " +
				"where people.person_surname like :surname";
		Query query = session.createSQLQuery(sql).setParameter("surname", employee_surname);
		session.getTransaction().commit();
		@SuppressWarnings("unchecked")
		List<String> list = query.list();
		session.close();
		return list;
	}
	
	public List<String> getClientsByEmployeeNameSurname(String employee_name, 
														String employee_surname) {
		Session session = sessions.openSession();
		session.beginTransaction();
		String sql = "select distinct client_name " +
				"from people inner join employees on people.id = employees.person_id " +
				"inner join employees_in_service on employees.id = employees_in_service.employee_id " +
				"inner join service_history on service_history.id = employees_in_service.service_id " +
				"inner join clients on clients.id = service_history.client_id " +
				"where people.person_surname like :surname " +
				"and people.person_name like :name";
		Query query = session.createSQLQuery(sql).setParameter("surname", employee_surname)
				.setParameter("name", employee_name);
		session.getTransaction().commit();
		@SuppressWarnings("unchecked")
		List<String> list = query.list();
		session.close();
		return list;
	}
	
	public List<ClientContactsViz> getClientContacts(String client_name) {
		Session session = sessions.openSession();
		session.beginTransaction();
		String sql = "select clients.client_name, adress as client_work_adress, " +
				"person_name as client_represent_name, " +
				"people.id as client_represent_id, " +
				"person_surname as client_represent_surname, " +
				"person_patronymic as client_represent_patronymic " +
				"from clients inner join client_contacts on client_contacts.client_id = clients.id " +
			    "inner join people on people.id = client_contacts.person_id " +
				"where clients.client_name like :client_name";
		Query query = session.createSQLQuery(sql).setParameter("client_name", client_name)
					.setResultTransformer(Transformers.aliasToBean(ClientContactsViz.class));
		session.getTransaction().commit();
		@SuppressWarnings("unchecked")
		List<ClientContactsViz> list = query.list();
		session.close();
		return list;
	}
	
	public List<ServiceHistoryViz> getServicesByTime(String start_time, String end_time) {
		Session session = sessions.openSession();
		session.beginTransaction();
		String sql = "select client_name, service_name, from_time, to_time " +
				"from clients inner join service_history on clients.id = service_history.client_id " +
				"inner join service_types on service_types.id = service_history.service_type " +
				"where from_time >= :from_time " +
				"and to_time <= :to_time ";
		Query query = session.createSQLQuery(sql)
				.setParameter("from_time", start_time)
				.setParameter("to_time", end_time)
				.setResultTransformer(Transformers.aliasToBean(ServiceHistoryViz.class));
		session.getTransaction().commit();
		@SuppressWarnings("unchecked")
		List<ServiceHistoryViz> list = query.list();
		session.close();
		return list;
	}
	
	
	public List<ServiceHistoryViz> getServicesByTime(
			String service_name, 
			String start_time, 
			String end_time) {
		Session session = sessions.openSession();
		session.beginTransaction();
		String sql = "select client_name, service_name, from_time, to_time " +
				"from clients inner join service_history on clients.id = service_history.client_id " +
				"inner join service_types on service_types.id = service_history.service_type " +
				"where from_time >= :from_time " +
				"and to_time <= :to_time " +
				"and service_name like :service_name";
		Query query = session.createSQLQuery(sql)
				.setParameter("service_name", service_name)
				.setParameter("from_time", start_time)
				.setParameter("to_time", end_time)
				.setResultTransformer(Transformers.aliasToBean(ServiceHistoryViz.class));
		session.getTransaction().commit();
		@SuppressWarnings("unchecked")
		List<ServiceHistoryViz> list = query.list();
		session.close();
		return list;
	}
	
	
	public List<ServiceHistoryViz> getClientServicesByTime(String client_name, 
														   String start_time, 
														   String end_time) {
		Session session = sessions.openSession();
		session.beginTransaction();
		String sql = "select client_name, service_name, from_time, to_time " +
				"from clients inner join service_history on clients.id = service_history.client_id " +
			    "inner join service_types on service_types.id = service_history.service_type " +
			    "where from_time >= :from_time " +
			    "and to_time <= :to_time " +
			    "and client_name like :client_name";
		Query query = session.createSQLQuery(sql)
				.setParameter("client_name", client_name)
				.setParameter("from_time", start_time)
				.setParameter("to_time", end_time)
			    .setResultTransformer(Transformers.aliasToBean(ServiceHistoryViz.class));
		session.getTransaction().commit();
		@SuppressWarnings("unchecked")
		List<ServiceHistoryViz> list = query.list();
		session.close();
		return list;
	}
	
	public List<ServiceHistoryViz> getClientServices(String client_name) {
		Session session = sessions.openSession();
		session.beginTransaction();
		String sql = "select client_name, service_name, from_time, to_time " +
				"from clients inner join service_history on clients.id = service_history.client_id " +
			    "inner join service_types on service_types.id = service_history.service_type " +
			    "where client_name like :client_name";
		Query query = session.createSQLQuery(sql)
				.setParameter("client_name", client_name)
				.setResultTransformer(Transformers.aliasToBean(ServiceHistoryViz.class));
		session.getTransaction().commit();
		@SuppressWarnings("unchecked")
		List<ServiceHistoryViz> list = query.list();
		session.close();
		return list;
	}
	
	public List<String> getClientsByService(String service_name) {
		Session session = sessions.openSession();
		session.beginTransaction();
		String sql = "select distinct client_name " +
				"from clients inner join service_history on clients.id = service_history.client_id " +
			    "inner join service_types on service_types.id = service_history.service_type " +
				"where service_name like :service_name";
		Query query = session.createSQLQuery(sql)
				.setParameter("service_name", service_name);
		session.getTransaction().commit();
		@SuppressWarnings("unchecked")
		List<String> list = query.list();
		session.close();
		return list;
	}
	
	public List<EmployeeContactsViz> getPersonPrifile(Integer id) {
		Session session = sessions.openSession();
		session.beginTransaction();
		String sql = "select person_name, person_surname, person_patronymic, adress, email, phone " +
				"from people left join phones on phones.person_id = people.id " +
				"left join emails on emails.person_id = people.id " +
				"left join employees on employees.person_id = people.id " +
				"where people.id = :person_id";
		Query query = session.createSQLQuery(sql).setParameter("person_id", id)
					.setResultTransformer(Transformers.aliasToBean(EmployeeContactsViz.class));
		session.getTransaction().commit();
		@SuppressWarnings("unchecked")
		List<EmployeeContactsViz> list = query.list();
		session.close();
		return list;
	}
	
}



