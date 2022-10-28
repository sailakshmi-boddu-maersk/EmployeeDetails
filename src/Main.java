
public class Main extends DBConnect{
	
	public static void main(String[] args) {
		 
		Service s=new Service();
		int choice=	Integer.parseInt(args[0]);

		switch(choice) {
		case 1:
            int id=Integer.parseInt(args[1]);
			String fname=args[2];
			String lname=args[3];
			float salary=Float.parseFloat(args[4]);
			int a_id=Integer.parseInt(args[5]);
			employee1 em=new employee1(id,fname,lname,salary,a_id);
			s.createEmp(em);
			break;
		case 2:
			s.selectEmp();
			break;
		case 3:
			int id1=Integer.parseInt(args[1]);
			int ch=Integer.parseInt(args[2]);
			String str=args[3];
			s.updateEmp(id1,ch,str);
			break;
		case 4:
			int id2=Integer.parseInt(args[1]);
			s.deleteEmp(id2);
			break;
			
		}
	}
}
