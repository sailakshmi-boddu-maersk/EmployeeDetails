import java.util.Scanner;


public class Main extends DBConnect{
	
	public static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		 
		Service s=new Service();
		int choice=	Integer.parseInt(args[0]);
//		System.out.println("enter choice");
//		System.out.println("1. create employee record");
//		System.out.println("2. select employee records");
//		System.out.println("3. update employee record");
//		System.out.println("4. delete employee record");
//		
//		int choice=sc.nextInt();
//		int choice=Integer.parseInt(args[0]);
//		int id=Integer.parseInt(args[1]);
//		String fname=args[2];
//		String lname=args[3];
//		float salary=Float.parseFloat(args[4]);
//		int a_id=Integer.parseInt(args[5]);
		
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
/*		if(choice==1) {
//			String strAr[]=new String [5] ;
//			for(int i=0;i<5;i++) {
//				strAr[i]=args[i+1];
//			}
			int id=Integer.parseInt(args[1]);
    		
			String fname=args[2];
			String lname=args[3];
			float salary=Float.parseFloat(args[4]);
			int a_id=Integer.parseInt(args[5]);
			employee1 em=new employee1(id,fname,lname,salary,a_id);
			s.createEmp(em);

//		s.createEmp(strAr);
		}
		if(choice==2) s.selectEmp();
		if(choice==3) {
			int id=Integer.parseInt(args[1]);
			int ch=Integer.parseInt(args[2]);
			String str=args[3];
			s.updateEmp(id,ch,str);
		}
		if(choice==4) {
			int id=Integer.parseInt(args[1]);
			s.deleteEmp(id);
		}
*/		
		
	}

}
