package a;
import java.sql.*;
import a.customer2;
public class LoginDao {
//emmmm
public int Login(customer2 a) {
	String uname="root";
	String upwd="123456";
	String DB_URL="jdbc:mysql://localhost:3306/education?useSSL=false&serverTimezone=UTC";
	Connection connection=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try {	
		Class.forName("com.mysql.cj.jdbc.Driver");
	    
		connection=DriverManager.getConnection(DB_URL, uname, upwd);
		String sql="select * from customer where uname=? and upwd=?";
	    pstmt= connection.prepareStatement(sql);
	    pstmt.setString(1, a.getUname());
	    pstmt.setString(2,a.getUpwd());
	    
	    
	    rs = pstmt.executeQuery();

	   if(rs.next()){
		  return 1;
	   }
	   else{
		   return 0;
	   }
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
		return -1;
	}
	catch(Exception e) {
		e.printStackTrace();
		return -1;
	}finally {
		try {
			if(rs!=null)rs.close();
			if(pstmt!=null) pstmt.close();	
			if(connection!=null)connection.close();
	    }
		
		catch(SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
}
}
