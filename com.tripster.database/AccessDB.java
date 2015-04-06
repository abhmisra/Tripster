import java.sql.*;
public class AccessDB {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://gunterhall.cph7rtgiusym.us-west-2.rds.amazonaws.com:3306/Gunter4040";
	   //  Database credentials
	   static final String USER = "saar_gunterhall";
	   static final String PASS = "mastermind";
	   Connection conn = null;
	  // Statement stmt = null;
	   public AccessDB()
	   {
		   try {
			Class.forName(JDBC_DRIVER);
			 //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      //createTables();
		      //testQuery();
		      //insertAndExtract();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	   
	   public void insertAndExtract()
	   {
		   String ins="INSERT INTO BUSINESS VALUES('2', 'abc', 'sdf', 'tgh', 'ret', 4.0" +
		   		", 5.3, 4.3, 5, true, false, false)";
		   String sql="SELECT * FROM BUSINESS";
		   String del="DELETE FROM BUSINESS";
		   try {
			Statement st=conn.createStatement();
			//st.executeUpdate(del);
			ResultSet rs=st.executeQuery(sql);
			System.out.println("Query executed");
			while(rs.next())
			{
				System.out.println(rs.getString(1));
			}
			st.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
	   }
	   public void createTables()
	   {
		  try {
			Statement stmt=conn.createStatement();
			String business="CREATE TABLE BUSINESS (" +
					"businessId VARCHAR(500), " +
					"NAME VARCHAR(1000), " +
					"full_address VARCHAR(1000), " +
					"city VARCHAR(100), " +
					"state VARCHAR(100), " +
					"latitude FLOAT, " +
					"longitude FLOAT, " +
					"stars FLOAT, " +
					"review_count INTEGER, " +
					"isRestaurant BOOLEAN, " +
					"isBar BOOLEAN, " +
					"isDep BOOLEAN, " +
					"PRIMARY KEY(businessId)) ";
			String user="CREATE TABLE USER (" +
					"userId VARCHAR(100), " +
					"name VARCHAR(60), " +
					"reviewCount VARCHAR(150), " +
					"PRIMARY KEY(userId)) ";
			String Timings="CREATE TABLE TIMINGS (" +
					"businessId VARCHAR(500), " +
					"day VARCHAR(8), " +
					"open TIME, " +
					"close TIME, " +
					"PRIMARY KEY(businessId, day), " +
					"FOREIGN KEY (businessId) REFERENCES BUSINESS ON DELETE CASCADE)";
			stmt.executeUpdate(Timings);
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	   }
	   
	   public ResultSet testQuery()
	   {
		   String query="SELECT * FROM BUSINESS";
		   try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			int i=0;
			while(rs.next()&&i<1)
			{
			System.out.println(rs.getString(2));
			++i;
			}
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   return null;
		   
	   }
	   
	/*public void populateBusiness()
	{
		String insertStatement="insert into Business values (?,?,?,?,?,?,?,?,?,?,?,?)";
	try {
		PreparedStatement businessInsert=conn.prepareStatement(insertStatement);
		int rowCount=businessId.size();
		for(int i=0;i<rowCount;i++)
		{
			businessInsert.setString(1, businessId.get(i));
			businessInsert.setString(2, name.get(i));
			businessInsert.setString(3, fullAddress.get(i));
			businessInsert.setString(4, city.get(i));
			businessInsert.setString(5, state.get(i));
			businessInsert.setFloat(6, latitude.get(i));
			businessInsert.setFloat(7, longitude.get(i));
			businessInsert.setFloat(8, stars.get(i));
			businessInsert.setInt(9, reviewCount.get(i));
			businessInsert(isRestaurant.get(i));
			businessInsert(isBar.get(i));
			businessInsert(isDep.get(i));
			businessInsert.addBatch();
		}
		businessInsert.executeBatch();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	}
	
	public void populateReview()
	{
		String insertStatement="insert into Business values (?,?,?,?,?)";
		try {
			PreparedStatement reviewInsert=conn.prepareStatement(insertStatement);
			int rowCount=reviewId.size();
			for(int i=0;i<rowCount;i++)
			{
				reviewInsert.setString(1, reviewId.get(i));
				reviewInsert.setString(2, businessId.get(i));
				reviewInsert.setString(3, userId.get(i));
				reviewInsert.setInt(5, reviewCount.get(i));
				reviewInsert.setString(4, stars.get(i));
				
				reviewInsert.addBatch();
			}
			reviewInsert.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void populateUser()
	{
		String insertStatement="insert into Business values (?,?,?)";
		try {
			PreparedStatement userInsert=conn.prepareStatement(insertStatement);
			int rowCount=userId.size();
			for(int i=0;i<rowCount;i++)
			{
				userInsert.setString(1, userId.get(i));
				userInsert.setString(2, name.get(i));
				userInsert.setInt(3, reviewCount.get(i));
				
				userInsert.addBatch();
			}
			userInsert.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void populateTimings()
	{
		String insertStatement="insert into Business values (?,?,?,?)";
		try {
			PreparedStatement timingsInsert=conn.prepareStatement(insertStatement);
			int rowCount=businessId.size();
			for(int i=0;i<rowCount;i++)
			{
				timingsInsert.setString(1, businessId.get(i));
				timingsInsert.setString(2, name.get(i));
				timingsInsert.setTime(3, open.get(i));
				timingsInsert.setTime(4, close.get(i));
				timingsInsert.addBatch();
			}
			timingsInsert.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}*/
	   
	  /* public static void main(String []args)
	   {
		   AccessDB dp=new AccessDB();
		   dp.testQuery();
	   }*/
	
}
