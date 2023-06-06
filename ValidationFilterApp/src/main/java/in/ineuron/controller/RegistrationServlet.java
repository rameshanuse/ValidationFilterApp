package in.ineuron.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ineuron.dto.Employee;
import in.ineuron.service.IEmployeeService;
import in.ineuron.servicefactory.EmployeeServiceFactory;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String eid = request.getParameter("eid");
		String ename = request.getParameter("ename");
		String eage = request.getParameter("eage");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		Employee employee = new Employee();
		employee.setEid(eid);
		employee.setEname(ename);
		employee.setEage(Integer.parseInt(eage));
		employee.setEmail(email);
		employee.setMobile(mobile);
		
		IEmployeeService employeeService = EmployeeServiceFactory.getEmployeeService();
		String status = employeeService.insert(employee);
		
		request.setAttribute("status", status);
		request.setAttribute("employee", employee);
		RequestDispatcher rd = request.getRequestDispatcher("/displayEmp.jsp");
		rd.forward(request, response);
	}

}
