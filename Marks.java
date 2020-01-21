/*Program to the fallowing situation
Recieves the marks of students by keeping the fallowing rules in mind
  i. marks are supposed to be in 3 diff category CA, MTE, ETE
  ii. Marks should be out of 100
  iii. There are two different stream of student, BCA and MCA
  iv. for BCA the weightage of CA is 40%, MTE 30%, ETE 20%
  v. for MCA CA 30%, MTE 30%, ETE 40% 
bellow 40: Failed
40-59: Pass
60-79: First Division
above 80: Merit
*/
import java.util.*;
interface Calculate
{
	void BCA();
	void MCA();
	void grade();
	
}
class totalException extends Exception
{
	public totalException(String s)
    {
        // Call constructor of parent Exception
        super(s);
    }
}
class Student implements Calculate 
{
	private int reg;
	private int ca;
	private int mte;
	private int ete;
	private int total;
	private String cmnt;
	int flag=0;
	public Student()
	{
		reg=0;
		ca=0;
		mte=0;
		ete=0;
		total=0;
		cmnt="";
	}
	
	public void getData()
	{
		Scanner sc=new Scanner(System.in);
		try
		{
			System.out.println("Enter your Registration Number:");
			reg=sc.nextInt();
			System.out.println("Enter your CA marks in three subject out of 100:");
			for(int i=0;i<3;i++)
			{
				ca=ca+sc.nextInt();
			}
			if(ca>300)
			{
				throw new totalException("Total can't be greater than 300");
			}
			System.out.println("Enter your MTE marks in three subject out of 100:");
			for(int i=0;i<3;i++)
			{
				mte=mte+sc.nextInt();
			}
			if(mte>300)
			{
				throw new totalException("Total can't be greater than 300");
			}
			System.out.println("Enter your ETE marks in three subject out of 100:");
			for(int i=0;i<3;i++)
			{
				ete=ete+sc.nextInt();
			}
			if(ca>300)
			{
				throw new totalException("Total can't be greater than 300");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public void showData()
	{
		if(flag==1)
		{
			System.out.println("Stream: MCA");
		}
		else
		{
			System.out.println("Stream: BCA");
		}
		System.out.println("Registration Number: "+ reg);
		System.out.println("Total CA marks as per weightage : "+ ca);
		System.out.println("Total MTE marks as per weightage :: "+ mte);
		System.out.println("Total ETE marks as per weightage :: "+ ca);
		System.out.println("Total marks out of 100: "+ total);
		System.out.println("Comment: "+ cmnt);
		
		
	}
	public void grade()
	{
		if(total<40)
		{
			cmnt="Fail";
		}
		else if(total>=40&&total<=59)
		{
			cmnt="Pass";
		}
		else if(total>=60&&total<79)
		{
			cmnt="First Division";
		}
		else if(total>=80)
		{
			cmnt="Merit";
		}
		else
		{
			cmnt="Invalid";
		}
	}
	public void BCA()
	{
		getData();
		ca=((ca/3)*40)/100;
		mte=((mte/3)*30)/100;
		ete=((ete/3)*30)/100;
		total=ca+mte+ete;
		grade();
		showData();
	}
	public void MCA()
	{
		getData();
		ca=((ca/3)*30)/100;
		mte=((mte/3)*30)/100;
		ete=((ete/3)*40)/100;
		total=ca+mte+ete;
		grade();
		flag=1;
		showData();
		
	}
}
class Marks
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		Student student=new Student();
		int ch=1;
		do
		{
			System.out.println("Enter Your Choice:");
			System.out.println("1. BCA");
			System.out.println("2. MCA");
			System.out.println("3. Exit:");
			ch=sc.nextInt();
			if(ch==1)
			{
				student.BCA();
			}
			else if(ch==2)
			{
				student.MCA();
			}
			else if(ch==3)
			{
				System.exit(0);
			}
			else
			{
				System.out.println("Please Enter a valid choice");
			}
		
		}while(ch!=3);
	}
} 
