interface emp{
	void createEmp(employee1 em);
	void selectEmp();
	void updateEmp(int id,int ch,String st);
	void deleteEmp(int id);
}
class employee1{
	int id;
	String fname;
	String lname;
	float salary;
	int a_id;
	public employee1(int id, String fname, String lname, float salary, int a_id) {
//		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.salary = salary;
		this.a_id = a_id;
	}
}
public class Service implements emp{
    
	DBConnect ob=new DBConnect();
	public void createEmp(employee1 em) {
		ob.connectionDb();
		ob.createEmpRecord(em);
	}
	
	public void selectEmp() {
		ob.connectionDb();
		ob.selectEmpRecords();
	}
	
	public void updateEmp(int id,int ch,String st) {
		ob.connectionDb();
		ob.updateEmpRecord(id,ch,st);
	}
	
	public void deleteEmp(int id) {
		ob.connectionDb();
		ob.deleteEmpRecord(id);
		
	}

}
