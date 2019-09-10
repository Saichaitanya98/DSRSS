package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.applyBean;
import util.DBConnection;

public class applyDao {
	public String apply(applyBean applybean)
	 {
	 String title = applybean.getTitle();
	 String firstname = applybean.getFirstname();
	 String middlename = applybean.getMiddlename();
	 String lastname = applybean.getLastname();
	 Connection con = null;
	 PreparedStatement ps = null;
	 try
	 {
	 con = DBConnection.createConnection();
	 String query ="insert into Preetam(title,firstname,middlename,lastname) values(?,?,?,?)";
	 ps.setString(1,title);
	 ps.setString(2,firstname);
	 ps.setString(3,middlename);
	 ps.setString(4,lastname);
	 int i= ps.executeUpdate();
	 if (i!=0) {
		 return "SUCCESS"; 
		 }
		 else
		 {
			 return "failed";
		 }
	 
	 
	 
	 
      }catch(Exception e)
	 {
	 System.out.println(e);
}

return "hi";

}
}
