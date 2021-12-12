package job;
import java.sql.*;

public class Mycon {
Connection c=null;
	
	Mycon(){
		try {
		Class.forName("com.mysql.jdbc.Driver");
		c=DriverManager.getConnection("jdbc:mysql://localhost:3306/job","root","");
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