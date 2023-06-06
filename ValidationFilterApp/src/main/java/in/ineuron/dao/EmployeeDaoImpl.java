package in.ineuron.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.ineuron.dto.Employee;
import in.ineuron.util.JdbcUtil;

public class EmployeeDaoImpl implements IEmployeeDao {

	private Connection connection = null;
	private PreparedStatement pstmt = null;

	@Override
	public String insert(Employee employee) {
		
		String sqlInsertQuery = "INSERT INTO employees(eid, ename, eage, email, mobile) values(?,?,?,?,?)";
		
		try {
			connection = JdbcUtil.getJdbcConnection();
			 if(connection != null)
				 pstmt  = connection.prepareStatement(sqlInsertQuery);
			if(pstmt != null) {
				pstmt.setString(1, employee.getEid());
				pstmt.setString(2, employee.getEname());
				pstmt.setInt(3, employee.getEage());
				pstmt.setString(4, employee.getEmail());
				pstmt.setString(5, employee.getMobile());
				
				int rowCount = pstmt.executeUpdate();
				if(rowCount == 1) {
					return "success";
				}
			}
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return "failure";
	}

}
