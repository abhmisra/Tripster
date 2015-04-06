package project550;
import java.sql.*;

public class ConnectDb {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://gunterhall.cph7rtgiusym.us-west-2.rds.amazonaws.com:3306/Gunter4040";
	   //  Database credentials
	static final String USER = "saar_gunterhall";
	static final String PASS = "mastermind";
	Connection conn = null;
	 public ConnectDb(){
	 
		
		 try {
			 Class.forName(JDBC_DRIVER);
			 //STEP 3: Open a connection
			 System.out.println("Connecting to database...");
			 conn = DriverManager.getConnection(DB_URL,USER,PASS);

			 //insertAndExtract();
		 } catch (ClassNotFoundException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
		 } catch (SQLException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
		 }
	 }
	 
	   public ResultSet insertAndExtract()
	   {
//		   String ins="INSERT INTO BUSINESS VALUES('2', 'abc', 'sdf', 'tgh', 'ret', 4.0" +
//		   		", 5.3, 4.3, 5, true, false, false)";
		   String sql="SELECT * FROM BUSINESS";
		//   String del="DELETE FROM BUSINESS";
		   try {
			Statement st=conn.createStatement();
			//st.executeUpdate(del);
			ResultSet rs=st.executeQuery(sql);
			System.out.println("Query executed");
			/*(rs.next())
			{
				System.out.println(rs.getString(1));
				break;
			}*/
			//st.close();
			//conn.close();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;   
	   }

	
}
