

		import java.sql.*;
		import java.util.Vector;

		public class MyDb{

		static Connection con;
		ResultSet rs;
		PreparedStatement ps;
		

		public static void connect() throws Exception{

		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con = DriverManager.getConnection("jdbc:odbc:citlogin1","admin","admin");		
				}

	public boolean checkLogin(String f1,String f2) throws Exception{
		connect();
		boolean b = false;
   ps = con.prepareStatement("select * from student where uid=? and pwd=?");
			ps.setString(1,f1);
			ps.setString(2,f2);
		      rs = ps.executeQuery();
			while(rs.next()){
				b = true;
				}
			con.close();
			return b;
			}
	public int insertData(String f1,String f2,String f3,String f4) {	

		int i=0;

			try{
				try{
			connect();
	ps = con.prepareStatement("insert into student values(?,?,?,?)");		
			ps.setString(1,f1);
			ps.setString(2,f2);
			ps.setString(3,f3);
			ps.setString(4,f4);
		
		 i = ps.executeUpdate();
				
			
				}
				finally{
					con.close();

					}
				}
				catch(Exception e){

	javax.swing.JOptionPane.showMessageDialog(null,"User_id is already exists");
				}
			return i;
			}

		public boolean checkUser(String f1) throws Exception{
			connect();
			
			boolean b =false;
	ps = con.prepareStatement("select * from student where uid=?");
			ps.setString(1,f1);
			rs = ps.executeQuery();
			while(rs.next()){
				b = true;
			
				}
			con.close();
			return b;
				}
		public Vector<String> getDetails(String f1) throws Exception{
			connect();
		Vector<String> v = new Vector<String>();
		ps = con.prepareStatement("select * from student where uid=?");
			ps.setString(1,f1);
			rs = ps.executeQuery();
			while(rs.next()){
		String fN = rs.getString(3);
		String lN = rs.getString(4);
			v.add(fN);
			v.add(lN);
				}
			con.close();
			return v;

				}
		public int update(String f1,String f2,String f3)throws Exception{
			connect();
      ps = con.prepareStatement("update student set fn=?,ln=? where uid=?");		
			ps.setString(1,f1);
			ps.setString(2,f2);
			ps.setString(3,f3);
			
		int i = ps.executeUpdate();
			con.close();
				return i;
				}

	public int delete(String f1)throws Exception{
			connect();
      ps = con.prepareStatement("delete * from student where uid=?");		
			ps.setString(1,f1);
			
		int i = ps.executeUpdate();
			con.close();
				return i;
				}
		
		
		}


