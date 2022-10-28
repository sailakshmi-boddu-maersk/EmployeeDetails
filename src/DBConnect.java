import java.sql.*;
import java.util.Scanner;

interface DB{
    void connectionDb();
	void createEmpRecord(employee1 em);
	void selectEmpRecords();
	void updateEmpRecord(int id,int ch,String st);
	void deleteEmpRecord(int id);
	
}

public class DBConnect implements DB{
	public static Connection connection=null;
	public static Scanner sc=new Scanner(System.in);
	
	
	public void connectionDb(){
		try {
			
			Class.forName("org.postgresql.Driver");
			connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","2323");
			if(connection!=null) {
				System.out.println("connection established succesfully");	
			}
			else {
				System.out.println("Failed  to connect");
			}
       }
		catch(Exception e) {
			System.out.println(e);
	}
		
	}
	
	
	public void createEmpRecord(employee1 em){
		try {
			
		String query="insert into employee(emp_id,first_name,last_name,salary,address_id) values(?,?,?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(query);
        preparedStatement.setInt(1,em.id);
		preparedStatement.setString(2,em.fname);
		preparedStatement.setString(3,em.lname);
		preparedStatement.setFloat(4,em.salary);
		preparedStatement.setInt(5,em.a_id);
		

		int rows=preparedStatement.executeUpdate();
		if(rows>0) {
			System.out.println("Record inserted sucessfully!!");
		}
		
		
        
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void selectEmpRecords() {
		try {
			String s="SELECT emp.emp_id, emp.first_Name,emp.last_name,emp.salary,emp.address_id,ad.address "
					+ "FROM employee emp LEFT JOIN address ad ON emp.address_id =ad.ad_id";
				
			Statement statement=connection.createStatement();
			ResultSet r=statement.executeQuery(s);
			while(r.next()) {
			System.out.print(r.getString(1)+" ");
			System.out.print(r.getString(2)+" ");
			System.out.print(r.getString(3)+" ");
			System.out.print(r.getString(4)+" ");
			System.out.print(r.getString(5)+" ");
			System.out.println(r.getString(6)+" ");
			} 
		  
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void updateEmpRecord(int id,int ch,String st) {
		try {
			PreparedStatement preparedStatement;
			  int r3;
			   
			   String s="select * from employee where emp_id= "+id;
				Statement statement=connection.createStatement();
				ResultSet r=statement.executeQuery(s);
				
				if(r.next()) {
				System.out.print(r.getString(1)+" ");
				System.out.print(r.getString(2)+" ");
				System.out.print(r.getString(3)+" ");
				System.out.print(r.getString(4)+" ");
				System.out.println(r.getString(5)+" ");
				
				String str="update employee set ";

				switch(ch) {
				case 1:
					
					str=str+"first_name =? where emp_id = "+id;
					preparedStatement=connection.prepareStatement(str);
					preparedStatement.setString(1,st);
					r3=preparedStatement.executeUpdate();
				    if(r3>0) {
				    	System.out.println("first name updated successfully!!");
				    }
				    else {
				    	System.out.println("something wrong!!");
				    }
				   break;
				case 2:
					str=str+"last_name =? where emp_id = "+id;
					preparedStatement=connection.prepareStatement(str);
					preparedStatement.setString(1,st);
					r3=preparedStatement.executeUpdate();
				    if(r3>0) {
				    	System.out.println("last name updated successfully!!");
				    }
				    else {
				    	System.out.println("something wrong!!");
				    }
				    break;
				case 3:
					str=str+"salary =? where emp_id = "+id;
					preparedStatement=connection.prepareStatement(str);
					preparedStatement.setFloat(1, Float.parseFloat(st));
					r3=preparedStatement.executeUpdate();
				    if(r3>0) {
				    	System.out.println("salary updated successfully!!");
				    }
				    else {
				    	System.out.println("something went wrong!!");
				    }
				    break;
				case 4:
					str=str+"address_id =? where emp_id = "+id;
					preparedStatement=connection.prepareStatement(str);
					preparedStatement.setFloat(1, Integer.parseInt(st));
					r3=preparedStatement.executeUpdate();
				    if(r3>0) {
				    	System.out.println("address updated successfully!!");
				    }
				    else {
				    	System.out.println("something wrong!!");
				    }
				    break;
				 default:
					 break;
				}
				}
				
				
				else {
					System.out.println("Record not Found!!");
				}
		  
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void deleteEmpRecord(int id) {
		try {
			String sql="delete from employee where emp_id= "+id;
			PreparedStatement preparedstatement=connection.prepareStatement(sql);
		    int r=preparedstatement.executeUpdate();
		    if(r>0) {
		    	System.out.println("record deleted successfully!!");
		    }
		    else {
		    	System.out.println("something went wrong!!");
		    }
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
