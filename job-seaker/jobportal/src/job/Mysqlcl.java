package job;

import java.sql.Connection;
import java.sql.DriverManager;

public class Mysqlcl {
	Connection c=null;
		
		Mysqlcl(){
			try {
			Class.forName("com.mysql.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/job","root","usman2661");
		//	System.out.print("connection successed");
			
			}catch(Exception a) {
				//a.printStackTrace();
				System.out.println("error "+a.getMessage());
			}
		}

	/*	public static void main(String[] args) {
			Mycon obj=new Mycon();

		}*/

	 }


