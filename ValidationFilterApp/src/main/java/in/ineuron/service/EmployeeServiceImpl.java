package in.ineuron.service;

import in.ineuron.dao.IEmployeeDao;
import in.ineuron.daofactory.EmployeeDaoFactory;
import in.ineuron.dto.Employee;

public class EmployeeServiceImpl implements IEmployeeService {

	private IEmployeeDao employeeDao = null;

	@Override
	public String insert(Employee employee) {
		employeeDao = EmployeeDaoFactory.getEmployeeDao();
		return employeeDao.insert(employee);
	}

}
