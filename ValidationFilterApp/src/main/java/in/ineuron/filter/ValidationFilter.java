package in.ineuron.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import in.ineuron.dto.Employee;

public class ValidationFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String eid_err_msg = "", ename_err_msg = "", eage_err_msg = "", email_err_msg = "", mobile_err_msg = "";
		boolean flag = true;

		PrintWriter out = response.getWriter();
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
		
		
		if (eid == null || eid.equals("")) {
			eid_err_msg = "Employee id is reqired";
			flag = false;
		} else if (!eid.startsWith("iNeuron-")) {
			eid_err_msg = "Employee id should start with iNeuron-";
			flag = false;
		}

		if (ename == null || ename.equals("")) {
			ename_err_msg = "Employee name is reqired";
			flag = false;
		} else if (ename.length() <= 3) {
			ename_err_msg = "Employee name length should not be less than 3";
			flag = false;
		}

		if (eage == null || eage.equals("")) {
			eage_err_msg = "Employee eage is reqired";
			flag = false;
		} else if (Integer.parseInt(eage) < 20 || Integer.parseInt(eage) > 30) {
			eage_err_msg = "Employee age should be within 20 to 30";
			flag = false;
		}

		if (email == null || email.equals("")) {
			email_err_msg = "Employee email is reqired";
			flag = false;
		} else if (!email.endsWith("@ineuron.ai")) {
			email_err_msg = "Employee email should ends with @ineuron.ai";
			flag = false;
		}

		if (mobile == null || mobile.equals("")) {
			mobile_err_msg = "Employee mobile is reqired";
			flag = false;
		} else if (!mobile.startsWith("91-")) {
			mobile_err_msg = "Employee mobile should starts with 91-";
			flag = false;
		}

		if (flag == true) {
			chain.doFilter(request, response);
		} else {
			request.setAttribute("employee", employee);
			request.setAttribute("eid_err_msg", eid_err_msg);
			request.setAttribute("ename_err_msg", ename_err_msg);
			request.setAttribute("eage_err_msg", eage_err_msg);
			request.setAttribute("email_err_msg", email_err_msg);
			request.setAttribute("mobile_err_msg", mobile_err_msg);
			
			RequestDispatcher rd = request.getRequestDispatcher("/display2Empl.jsp");
			rd.forward(request, response);
		}
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}
}
