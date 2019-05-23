package law_site;

import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class TestLawSiteDAO {
	
	private boolean equals(Object a, Object b) {
		if (a == b) {
			return true;
		}
		if ((a == null) || (b == null)) {
			return false;
		}
		return a.equals(b);
	}
	
	@Test(dataProvider = "peopleTestData")
	public void PeopleTest(String s1, String s2, String s3, boolean exc) {
		LawSiteDAO ls = new LawSiteDAO();
		
		Integer rows = null;
		
		try {
			rows = ls.getAllPeople().size();
		} catch (Exception e) {
			assert(false);
		}
		
		assert(rows != null);
	  
		People person = new People();
		person.setPerson_name(s1);
		person.setPerson_surname(s2);
		person.setPerson_patronymic(s3);
		  
		try {
			ls.storePeople(person);
		} catch (Exception e) {
			System.out.println("++");
			assert(exc);
			return;
		}
		
		try {
			People tmp = ls.loadPeople(person.getId());
			assert(tmp != null);
			assert(equals(tmp.getPerson_name(), s1));
			assert(equals(tmp.getPerson_surname(), s2));
			assert(equals(tmp.getPerson_patronymic(), s3));
			tmp.setPerson_name(s2);
			tmp.setPerson_surname(s1);
			ls.updatePeople(tmp);
			tmp = ls.loadPeople(person.getId());
			assert(tmp != null);
			assert(equals(tmp.getPerson_name(), s2));
			assert(equals(tmp.getPerson_surname(), s1));
			assert(equals(tmp.getPerson_patronymic(), s3));
			ls.deletePeople(tmp);
		} catch (Exception e) {
			System.out.println("**");
			assert(exc);
			ls.deletePeople(person);
		}
		
		boolean wasExc = false;

		try {
			ls.loadPeople(person.getId());
		} catch (Exception e) {
			System.out.println("--");
			wasExc = true;
		}
		
		assert(wasExc);
		assert(rows.equals(ls.getAllPeople().size()));
	}

	@DataProvider
	public Object[][] peopleTestData() {
		return new Object[][] {
			new Object[] { "TEST1", "TEST2", "TEST3", false },
			new Object[] { "TEST1", "TEST2", null, false },
			new Object[] { "TEST1", null, "TEST3", true },
			new Object[] { null, "TEST2", "TEST3", true },
			new Object[] { null, null, "TEST3", true },
			new Object[] { null, "TEST2", null, true },
			new Object[] { "TEST1", null, null, true },
			new Object[] { null, null, null, true },
		};
	}
	
	@Test(dataProvider = "clientsTestData")
	public void ClientsTest(String s1, String s2, boolean exc) {
		LawSiteDAO ls = new LawSiteDAO();
		Integer rows = null;
		
		try {
			rows = ls.getAllClients().size();
		} catch (Exception e) {
			System.out.println("++");
			assert(false);
		}
		
		assert(rows != null);
	  
		Clients client = new Clients();
		client.setClient_name(s1);
		  
		try {
			ls.storeClient(client);
		} catch (Exception e) {
			System.out.println("**");
			assert(exc);
			return;
		}
		
		try {
			Clients tmp = ls.loadClient(client.getId());
			assert(tmp != null);
			assert(equals(tmp.getClient_name(), s1));
			tmp.setClient_name(s2);
			ls.updateClient(tmp);
			tmp = ls.loadClient(client.getId());
			assert(tmp != null);
			assert(equals(tmp.getClient_name(), s2));
			ls.deleteClient(tmp);
		} catch (Exception e) {
			System.out.println("@@");
			ls.deleteClient(client);
			assert(exc);
		}
		
		boolean wasExc = false;
		
		try {
			ls.loadClient(client.getId());
		} catch (Exception e) {
			System.out.println("##");
			wasExc = true;
		}
		
		System.out.println("^^");
		assert(wasExc);
		System.out.println("00");
		assert(rows.equals(ls.getAllClients().size()));
	}

	@DataProvider
	public Object[][] clientsTestData() {
		return new Object[][] {
			new Object[] { "TEST1", "TEST2", false },
			new Object[] { "TEST1", null, true },
			new Object[] { null, "TEST2", true },
			new Object[] { null, null, true }, 
		};
	}

	@Test(dataProvider = "educationTestData")
	public void EducationTest(String s1, String s2, boolean exc) {
		LawSiteDAO ls = new LawSiteDAO();
		
		Integer rows = null;
		
		try {
			rows = ls.getAllEducation().size();
		} catch (Exception e) {
			assert(false);
		}
		
		assert(rows != null);
	  
		Education education = new Education();
		education.setEducation_name(s1);
		  
		try {
			ls.storeEducation(education);
		} catch (Exception e) {
			System.out.println("**");
			assert(exc);
			return;
		}
		
		Education tmp = ls.loadEducation(education.getId());
		try {			
			assert(tmp != null);
			assert(equals(tmp.getEducation_name(), s1));
			tmp.setEducation_name(s2);
			ls.updateEducation(tmp);
			tmp = ls.loadEducation(education.getId());
			assert(tmp != null);
			assert(equals(tmp.getEducation_name(), s2));
			ls.deleteEducation(tmp);
		} catch (Exception e) {
			ls.deleteEducation(tmp);
			System.out.println("@@");
			assert(exc);
		}
		
		System.out.println("^^");
		assert(rows.equals(ls.getAllEducation().size()));
	}

	@DataProvider
	public Object[][] educationTestData() {
		return new Object[][] {
			new Object[] { "TEST1", "TEST2", false },
			new Object[] { "TEST1", null, true },
			new Object[] { null, "TEST2", true },
			new Object[] { null, null, true },
		};
	}
	
	@Test(dataProvider = "emailsTestData")
	public void EmailsTest(String s1, String s2, boolean exc) {
		LawSiteDAO ls = new LawSiteDAO();
		
		Integer rows = null;
		
		try {
			rows = ls.getAllEmails().size();
		} catch (Exception e) {
			assert(false);
		}
		
		assert(rows != null);
	  
		Emails email = new Emails();
		email.setEmail(s1);
		email.setPerson_id(1);
		
		boolean wasExc = false;
		  
		try {
			ls.storeEmail(email);
		} catch (Exception e) {
			System.out.println("**");
			assert(exc);
			return;
		}

		Emails tmp = ls.loadEmail(email.getId());
		try {
			assert(tmp != null);
			assert(equals(tmp.getEmail(), s1));
			tmp.setEmail(s2);
			ls.updateEmail(tmp);
			tmp = ls.loadEmail(email.getId());
			assert(tmp != null);
			assert(equals(tmp.getEmail(), s2));
			ls.deleteEmail(tmp);
		} catch (Exception e) {
			ls.deleteEmail(tmp);
			System.out.println("@@");
			assert(exc);
		}
		
		wasExc = false;
		
		try {
			ls.loadEmail(email.getId());
		} catch (Exception e) {
			System.out.println("##");
			wasExc = true;
		}
		
		System.out.println("^^");
		assert(wasExc);
		System.out.println("00");
		assert(rows.equals(ls.getAllEmails().size()));
	}

	@DataProvider
	public Object[][] emailsTestData() {
		return new Object[][] {
			new Object[] { "TEST1", "TEST2", false },
			new Object[] { "TEST1", null, true },
			new Object[] { null, "TEST2", true },
			new Object[] { null, null, true },
		};
	}
	
	@Test(dataProvider = "positionsTestData")
	public void PositionsTest(String s1, String s2, boolean exc) {
		LawSiteDAO ls = new LawSiteDAO();
		
		Integer rows = null;
		
		try {
			rows = ls.getAllPositions().size();
		} catch (Exception e) {
			assert(false);
		}
		
		assert(rows != null);
	  
		Positions pos = new Positions();
		pos.setPosition_name(s1);
		pos.setSalary(1);
		
		boolean wasExc = false;
		  
		try {
			ls.storePosition(pos);
		} catch (Exception e) {
			System.out.println("**");
			assert(exc);
			return;
		}

		Positions tmp = ls.loadPosition(pos.getId());
		try {
			assert(tmp != null);
			assert(equals(tmp.getPosition_name(), s1));
			tmp.setPosition_name(s2);
			ls.updatePosition(tmp);
			tmp = ls.loadPosition(pos.getId());
			assert(tmp != null);
			assert(equals(tmp.getPosition_name(), s2));
			ls.deletePosition(tmp);
		} catch (Exception e) {
			ls.deletePosition(tmp);
			System.out.println("@@");
			assert(exc);
		}
		
		wasExc = false;
		
		try {
			ls.loadPosition(pos.getId());
		} catch (Exception e) {
			System.out.println("##");
			wasExc = true;
		}
		
		System.out.println("^^");
		assert(wasExc);
		System.out.println("00");
		assert(rows.equals(ls.getAllPositions().size()));
	}

	@DataProvider
	public Object[][] positionsTestData() {
		return new Object[][] {
			new Object[] { "TEST1", "TEST2", false },
			new Object[] { "TEST1", null, true },
			new Object[] { null, "TEST2", true },
			new Object[] { null, null, true },
		};
	}
	
	@Test(dataProvider = "empClientsTestData")
	public void EmployeesClientsTest(String s1) {
		LawSiteDAO ls = new LawSiteDAO();
		List<String> employeeEmails = null;
		
		try {
			employeeEmails = ls.getClientsByEmployeeSurname(s1);
			System.out.println(s1);
			for(String e : employeeEmails) {
	            System.out.println(e);
	        }
		} catch (Exception e) {
			System.out.println("^^");
			e.printStackTrace();
			assert(false);
		}
	}
	
	@DataProvider
	public Object[][] empClientsTestData() {
		return new Object[][] {
			new Object[] { "Илюшин" },
			new Object[] { "Петров" },
			new Object[] { "Гусев" },
		};
	}
	
	@Test(dataProvider = "empClientsTestData2")
	public void EmployeesClientsTest2(String s1, String s2) {
		LawSiteDAO ls = new LawSiteDAO();
		List<String> employeeEmails = null;
		
		try {
			employeeEmails = ls.getClientsByEmployeeNameSurname(s1, s2);
			System.out.println(s1);
			System.out.println(s2);
			for(String e : employeeEmails) {
	            System.out.println(e);
	        }
		} catch (Exception e) {
			System.out.println("^^");
			e.printStackTrace();
			assert(false);
		}
	}
	
	@DataProvider
	public Object[][] empClientsTestData2() {
		return new Object[][] {
			new Object[] {"Григорий", "Илюшин"},
			new Object[] {"Александр", "Илюшин"},
			new Object[] {"Борис", "Гусев"},
		};
	}
	
	@Test(dataProvider = "empContactsTestData")
	public void EmployeesContactsTest(String s1) {
		LawSiteDAO ls = new LawSiteDAO();
		List<EmployeeContacts> employeeContacts = null;
		
		try {
			employeeContacts = ls.getEmployeeContacts(s1);
			System.out.println(s1);
			for(EmployeeContacts e : employeeContacts) {
	            e.print();
	        }

		} catch (Exception e) {
			System.out.println("^^");
			e.printStackTrace();
			assert(false);
		}
	}
	
	@DataProvider
	public Object[][] empContactsTestData() {
		return new Object[][] {
			new Object[] { "TEST1" },
			new Object[] { "Илюшин" },
			new Object[] { "Плющева" },
			new Object[] { "Гусев" },
		};
	}
	
	@Test(dataProvider = "clientContactsTestData")
	public void ClientContactsTest(String s1) {
		LawSiteDAO ls = new LawSiteDAO();
		List<ClientContactsViz> clientContacts = null;
		
		try {
			clientContacts = ls.getClientContacts(s1);
			for(ClientContactsViz e : clientContacts) {
				e.print();
			}
		} catch (Exception e) {
			System.out.println("^^");
			e.printStackTrace();
			assert(false);
		}
	}
	
	@DataProvider
	public Object[][] clientContactsTestData() {
		return new Object[][] {
			new Object[] { "ООО меньше налогов" },
			new Object[] { "ОАО консультации юристов" },
			new Object[] { "ИП Игнатьев" },
		};
	}
	
	@Test(dataProvider = "clientServiceTestData")
	public void ClientServiceTest(String s1) {
		LawSiteDAO ls = new LawSiteDAO();
		List<ServiceHistoryViz> clientContacts = null;
		
		try {
			clientContacts = ls.getClientServices(s1);
			for(ServiceHistoryViz e : clientContacts) {
				e.print();
			}
		} catch (Exception e) {
			System.out.println("^^");
			e.printStackTrace();
			assert(false);
		}
	}
	
	@DataProvider
	public Object[][] clientServiceTestData() {
		return new Object[][] {
			new Object[] { "ООО меньше налогов" },
			new Object[] { "ОАО консультации юристов" },
			new Object[] { "ИП Игнатьев" },
		};
	}
	
	@Test(dataProvider = "clientsByServiceTestData")
	public void ClientsByServiceTest(String s1) {
		LawSiteDAO ls = new LawSiteDAO();
		List<String> clients = null;
		
		try {
			clients = ls.getClientsByService(s1);
			System.out.println(s1);
			for(String s : clients) {
				System.out.println(s);
			}
		} catch (Exception e) {
			System.out.println("^^");
			e.printStackTrace();
			assert(false);
		}
	}
	
	@DataProvider
	public Object[][] clientsByServiceTestData() {
		return new Object[][] {
			new Object[] { "создание документа" },
			new Object[] { "восстановление документа" },
			new Object[] { "сопровождение документа" },
		};
	}
	
	@Test(dataProvider = "clientServicesByTimeTestData")
	public void ClientServicesByTimeTest(String s1, String start, String end) {
		LawSiteDAO ls = new LawSiteDAO();
		List<ServiceHistoryViz> clients = null;
		
		try {
			clients = ls.getClientServicesByTime(s1, start, end);
			System.out.println(s1);
			for(ServiceHistoryViz s : clients) {
				s.print();
			}
		} catch (Exception e) {
			System.out.println("^^");
			e.printStackTrace();
			assert(false);
		}
	}
	
	@DataProvider
	public Object[][] clientServicesByTimeTestData() {
		return new Object[][] {
			new Object[] { "ООО меньше налогов", "2018-01-01 10:30:00", "2019-01-01 10:30:00" },
			new Object[] { "ООО меньше налогов", "2019-01-01 10:30:00", "2019-01-01 10:30:00" },
			new Object[] { "ОАО консультации юристов", "2018-01-01 10:30:00", "2019-01-01 10:30:00" },
		};
	}
	
	@Test(dataProvider = "servicesByTimeTestData")
	public void ServicesByTimeTest(String s1, String start, String end) {
		LawSiteDAO ls = new LawSiteDAO();
		List<ServiceHistoryViz> clients = null;
		
		try {
			clients = ls.getServicesByTime(s1, start, end);
			System.out.println(s1);
			for(ServiceHistoryViz s : clients) {
				s.print();
			}
		} catch (Exception e) {
			System.out.println("^^");
			e.printStackTrace();
			assert(false);
		}
	}
	
	@DataProvider
	public Object[][] servicesByTimeTestData() {
		return new Object[][] {
			new Object[] { "создание документа", "2018-01-01 10:30:00", "2019-01-01 10:30:00" },
			new Object[] { "восстановление документа", "2019-01-01 10:30:00", "2019-01-01 10:30:00" },
			new Object[] { "сопровождение документа", "2018-01-01 10:30:00", "2019-01-01 10:30:00" },
		};
	}
	
	@Test(dataProvider = "empProfileTestData")
	public void EmployeeProfile(Integer id) {
		LawSiteDAO ls = new LawSiteDAO();
		List<EmployeeContactsViz> emp = null;
		
		try {
			emp = ls.getPersonPrifile(id);
			System.out.println(id);
			for(EmployeeContactsViz e : emp) {
				e.print();
			}
		} catch (Exception e) {
			System.out.println("^^");
			e.printStackTrace();
			assert(false);
		}
	}
	
	@DataProvider
	public Object[][] empProfileTestData() {
		return new Object[][] {
			new Object[] { 1 },
			new Object[] { 2 },
			new Object[] { 10 },
		};
	}
	
}

