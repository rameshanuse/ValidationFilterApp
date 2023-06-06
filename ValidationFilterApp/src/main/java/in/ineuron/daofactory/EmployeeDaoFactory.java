package in.ineuron.daofactory;

import in.ineuron.dao.EmployeeDaoImpl;
import in.ineuron.dao.IEmployeeDao;

public class EmployeeDaoFactory {
	private EmployeeDaoFactory() {};
	
	private static IEmployeeDao employeeDao = null;
	
	public static IEmployeeDao getEmployeeDao() {
		if(employeeDao == null) {
			employeeDao = new EmployeeDaoImpl();
		}
		return employeeDao;
	}
}
