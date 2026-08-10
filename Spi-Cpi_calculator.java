import java.util.Scanner;

class Student
{
	String name,enrollment_no;
	
	double cgpa[]=new double[8];
	double sgpa[]=new double[8];
	double m_sem1[],m_sem2[],m_sem3[],m_sem4[],m_sem5[],m_sem6[],m_sem7[],m_sem8[];//Marks Array
		
	Scanner sc=new Scanner(System.in);

	// Helper method: checks if a string is a valid number (integer or decimal).
	// Allows optional leading minus sign, digits, and at most one dot.
	// Returns true if valid, false otherwise.
	boolean isValidNumber(String input)
	{
		if(input==null || input.length()==0)
		{
			return false;
		}
		int startIndex=0;
		// Allow a leading minus sign for negative numbers
		if(input.charAt(0)=='-')
		{
			startIndex=1;
		}
		// After a minus sign, there must be at least one character
		if(startIndex>=input.length())
		{
			return false;
		}
		int dotCount=0;
		for(int i=startIndex;i<input.length();i++)
		{
			char c=input.charAt(i);
			if(c=='.')
			{
				dotCount++;
				if(dotCount>1)
				{
					return false;
				}
			}
			else if(c<'0' || c>'9')
			{
				return false;
			}
		}
		return true;
	}

	// Helper method: checks if a string is a valid integer (no dot allowed).
	// Allows optional leading minus sign.
	boolean isValidInteger(String input)
	{
		if(input==null || input.length()==0)
		{
			return false;
		}
		int startIndex=0;
		if(input.charAt(0)=='-')
		{
			startIndex=1;
		}
		if(startIndex>=input.length())
		{
			return false;
		}
		for(int i=startIndex;i<input.length();i++)
		{
			char c=input.charAt(i);
			if(c<'0' || c>'9')
			{
				return false;
			}
		}
		return true;
	}

	void setStudentDetail(int n)		//n= serial number of student.
	{
		// --- Name Validation ---
		while(true)
		{
			System.out.println("Enter name of student "+n+": ");
			name=sc.nextLine();

			// Check: name must not be empty
			if(name.length()==0)
			{
				System.out.println("Invalid name. Name cannot be empty. Enter again:");
				continue;
			}

			// Check: name must not contain digits or special characters (only letters and spaces allowed)
			boolean nameValid=true;
			for(int i=0;i<name.length();i++)
			{
				char c=name.charAt(i);
				// Allow letters (a-z, A-Z) and spaces only
				if(!((c>='a' && c<='z') || (c>='A' && c<='Z') || c==' '))
				{
					nameValid=false;
					break;
				}
			}

			if(nameValid==false)
			{
				System.out.println("Invalid name. Name should not contain numbers or special characters. Enter again:");
				continue;
			}

			// Name is valid, exit loop
			break;
		}

		// --- Enrollment Number Validation (existing logic preserved + improved with nextLine) ---
		System.out.println("Enter Enrollment number of student"+n+": ");
		char c;
		boolean b=true;
		while(true)
		{
			this.enrollment_no=sc.nextLine().trim();
			if(this.enrollment_no.length()!=14)
			{
				System.out.println("Enrollment number must be of 14 digits.Enter again:");
				continue;
			}
			else
			{
				b=false;
				for(int i=0;i<14;i++)
				{
					c=this.enrollment_no.charAt(i);
					if(c<'0' || c>'9')
					{
						System.out.println("Invalid enrollment number.It must have only digits.Enter again:");
						b=true;
						break;
					}
				}
				if(b==false)
				{
					break;
				}
			}
		}
		System.out.println();
		System.out.println("^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_");
		System.out.println();
	}

	void Marksdetails(String s[],double m[])
	{
		for(int i=0;i<s.length;i++)
		{
			System.out.println("Enter marks of "+s[i]+" :");
			while(true)
			{
				String input=sc.nextLine().trim();

				// Check: input must not be empty
				if(input.length()==0)
				{
					System.out.println("Input cannot be empty. Enter marks between 0 to 100.");
					continue;
				}

				// Check: input must be a valid number (digits and at most one dot, optional leading minus)
				if(isValidNumber(input)==false)
				{
					System.out.println("Invalid input. Please enter a numeric value between 0 to 100.");
					continue;
				}

				// Now it is safe to parse
				m[i]=Double.parseDouble(input);

				// Check: range validation (existing logic preserved)
				if(m[i]<0 || m[i]>100)
				{
					System.out.println("Enter marks between 0 to 100.");
				}
				else
				{
					break;
				}
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_");
		System.out.println();
		System.out.println();
	}
	
	void sortByCGPA(Student obj[])
	{
		Student obj1=new Student();
		for(int i=0;i<obj.length;i++)
		{
			for(int j=i;j<obj.length;j++)
			{
				if(obj[i].cgpa[7]<obj[j].cgpa[7])
				{
					obj1=obj[i];
					obj[i]=obj[j];
					obj[j]=obj1;
				}
			}
		}
	}
	
	void sortBySGPA(Student obj[],int sn)
	{
		Student obj1=new Student();
		for(int i=0;i<obj.length;i++)
		{
			for(int j=i;j<obj.length;j++)
			{
				if(obj[i].sgpa[sn-1]<obj[j].sgpa[sn-1])
				{
					obj1=obj[i];
					obj[i]=obj[j];
					obj[j]=obj1;
				}
			}
		}
	}
	
}

class Run
{
	Scanner sc=new Scanner(System.in);
	
	static String s_sem1[],s_sem2[],s_sem3[],s_sem4[],s_sem5[],s_sem6[],s_sem7[],s_sem8[];//Subjects Array
	
	static double credit_sem1[],credit_sem2[],credit_sem3[],credit_sem4[],credit_sem5[],credit_sem6[],credit_sem7[],credit_sem8[];//Credit array
	
	Student s[];

	// Helper method: checks if a string is a valid integer (no dot allowed).
	// Allows optional leading minus sign.
	boolean isValidInteger(String input)
	{
		if(input==null || input.length()==0)
		{
			return false;
		}
		int startIndex=0;
		if(input.charAt(0)=='-')
		{
			startIndex=1;
		}
		if(startIndex>=input.length())
		{
			return false;
		}
		for(int i=startIndex;i<input.length();i++)
		{
			char c=input.charAt(i);
			if(c<'0' || c>'9')
			{
				return false;
			}
		}
		return true;
	}
	
	double calulateSGPA(double m[],double c[])
	{
		double sum=0,c_total=0;
		for(int i=0;i<m.length;i++)
		{
			sum+=m[i]*c[i];
			c_total+=c[i];
		}
		return (sum/c_total)/10;
	}
	
	double calulateCGPA(double d[],int sn)
	{
		double sum=0;
		for(int i=0;i<sn;i++)
		{
			sum+=d[i];
		}
		return sum/sn;
	}
	
	void displayDetails(Student []s,int sn)		//sn=A Semester number which, faculty want to see
	{
		for(int i=0;i<s.length;i++)
		{
			System.out.println("Name of student "+(i+1)+ " is=  "+s[i].name);
			System.out.println();
			System.out.println("enrollment no of student "+(i+1)+ " is= "+s[i].enrollment_no);
			System.out.println();
			System.out.println("SGPA of SEM-"+sn+"  is= "+s[i].sgpa[sn-1]);
			System.out.println();
			System.out.println("CGPA until SEM-"+sn+"  is= "+s[i].cgpa[sn-1]);
			System.out.println();
			System.out.println("**********************************************************************");
			System.out.println();
		}
	}
	
	Student[] sortByCGPA(Student obj[])
	{
		Student obj1=new Student();
		obj1.sortByCGPA(obj);
		return obj;
	}
	
	Student[] sortBySGPA(Student obj[],int sn)
	{
		Student obj1=new Student();
		obj1.sortBySGPA(obj,sn);
		return obj;
	}
	
}

class CSE extends Run
{
	CSE()
	{
		s_sem1=new String[]{"Mathematics-1","Java-1","Software Engineering","IOT-Workshop","Computer-Workshop","Physics","Environmental Science"};
		credit_sem1=new double[]{6,6,4,2,2,4,0};
		
		s_sem2=new String[]{"Mathematics-2","Java-2","Data Structures","Database Management System","Fundamental of Electronics and Electrical Engineering"};
		credit_sem2=new double[]{5,6,6,6,4};
		
		s_sem3=new String[]{"Digital Electronics","Full Stack Development-1","Introduction to Probability Theory and Stichastic Processes","Python-1","Effective Technical Communication","Constitution of India"};
		credit_sem3=new double[]{5,6,5,5,3,0};
		
		s_sem4=new String[]{" Python - 2","Discrete Mathematics","Full Stack Development -2","Computer Organization & Architecture","Theory of Computation"};
		credit_sem4=new double[]{5,4,6,5,5};
		
		s_sem5=new String[]{"Project-I"};
		credit_sem5=new double[]{5};
		
		s_sem6=new String[]{"Project-II"};
		credit_sem6=new double[]{5};
		
		s_sem7=new String[]{"Project-III"};
		credit_sem7=new double[]{5};
		
		s_sem8=new String[]{"Project-IV"};
		credit_sem8=new double[]{5};
		
	}
	
	public void Data()
	{
		// --- Number of Students Validation ---
		int n=0;
		while(true)
		{
			System.out.println("Enter number of students.");
			String input=sc.nextLine().trim();

			// Check: input must not be empty
			if(input.length()==0)
			{
				System.out.println("Input cannot be empty. Please enter a positive integer.");
				continue;
			}

			// Check: input must be a valid integer (no dot, no letters)
			if(isValidInteger(input)==false)
			{
				System.out.println("Invalid input. Please enter a positive integer.");
				continue;
			}

			// Now safe to parse
			n=Integer.parseInt(input);

			// Check: must be positive
			if(n<=0)
			{
				System.out.println("Number of students must be greater than 0. Please enter again.");
				continue;
			}

			// Valid number of students
			break;
		}

		s=new Student[n];
		System.out.println();
		
		for(int i=0;i<s.length;i++)
		{
			s[i]=new Student();
			s[i].setStudentDetail(i+1);
			
			System.out.println("For SEM-1");
			s[i].m_sem1=new double[credit_sem1.length];
			s[i].Marksdetails(s_sem1,s[i].m_sem1);
			s[i].sgpa[0]=calulateSGPA(s[i].m_sem1,credit_sem1);
			s[i].cgpa[0]=calulateCGPA(s[i].sgpa,1);
			
			System.out.println("For SEM-2");
			s[i].m_sem2=new double[credit_sem2.length];
			s[i].Marksdetails(s_sem2,s[i].m_sem2);
			s[i].sgpa[1]=calulateSGPA(s[i].m_sem2,credit_sem2);
			s[i].cgpa[1]=calulateCGPA(s[i].sgpa,2);
			
			
			System.out.println("For SEM-3");
			s[i].m_sem3=new double[credit_sem3.length];
			s[i].Marksdetails(s_sem3,s[i].m_sem3);
			s[i].sgpa[2]=calulateSGPA(s[i].m_sem3,credit_sem3);
			s[i].cgpa[2]=calulateCGPA(s[i].sgpa,3);
			
			System.out.println("For SEM-4");
			s[i].m_sem4=new double[credit_sem4.length];
			s[i].Marksdetails(s_sem4,s[i].m_sem4);
			s[i].sgpa[3]=calulateSGPA(s[i].m_sem4,credit_sem4);
			s[i].cgpa[3]=calulateCGPA(s[i].sgpa,4);
			
			System.out.println("For SEM-5");
			s[i].m_sem5=new double[credit_sem5.length];
			s[i].Marksdetails(s_sem5,s[i].m_sem5);
			s[i].sgpa[4]=calulateSGPA(s[i].m_sem5,credit_sem5);
			s[i].cgpa[4]=calulateCGPA(s[i].sgpa,5);
			
			System.out.println("For SEM-6");
			s[i].m_sem6=new double[credit_sem6.length];
			s[i].Marksdetails(s_sem6,s[i].m_sem6);
			s[i].sgpa[5]=calulateSGPA(s[i].m_sem6,credit_sem6);
			s[i].cgpa[5]=calulateCGPA(s[i].sgpa,6);
			
			System.out.println("For SEM-7");
			s[i].m_sem7=new double[credit_sem7.length];
			s[i].Marksdetails(s_sem7,s[i].m_sem7);
			s[i].sgpa[6]=calulateSGPA(s[i].m_sem7,credit_sem7);
			s[i].cgpa[6]=calulateCGPA(s[i].sgpa,7);
			
			System.out.println("For SEM-8");
			s[i].m_sem8=new double[credit_sem8.length];
			s[i].Marksdetails(s_sem8,s[i].m_sem8);
			s[i].sgpa[7]=calulateSGPA(s[i].m_sem8,credit_sem8);
			s[i].cgpa[7]=calulateCGPA(s[i].sgpa,8);
			
		}
	}
	
	void displayDetails(int sn)
	{
		if(sn>0 && sn<9)
		{
			super.displayDetails(s,sn);
		}
		else
		{
			System.out.println("You have entered Invalid choice.");
		}
	}
	
	void sortByCGPA()
	{
		s=super.sortByCGPA(s);
	}
	
	void sortBySGPA(int sn)
	{
		s=super.sortBySGPA(s,sn);
	}
	
	void findStudent(String en)
	{
		boolean b=false;
		for(int i=0;i<s.length;i++)
		{
			if(en.equals(s[i].enrollment_no))
			{
				displayStudent(s[i]);
				b=true;
			}
		}
		if(b==false)
		{
			System.out.println("No such enrollment number found.");
		}
	}
	
	void displayStudent(Student obj)
	{
		System.out.println("Name of student is=  "+obj.name);
		System.out.println();
		System.out.println("enrollment no of student is= "+obj.enrollment_no);
		System.out.println();
		for(int i=0;i<s_sem1.length;i++)
		{
			System.out.println("Subject: "+s_sem1[i]);
			System.out.println("Mark: "+obj.m_sem1[i]);
			System.out.println();
		}
		System.out.println("SGPA of sem 1: "+obj.sgpa[0]);
		System.out.println("CGPA until sem 1: "+obj.cgpa[0]);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		for(int i=0;i<s_sem2.length;i++)
		{
			System.out.println("Subject: "+s_sem2[i]);
			System.out.println("Mark: "+obj.m_sem2[i]);
			System.out.println();
		}
		System.out.println("SGPA of sem 2: "+obj.sgpa[1]);
		System.out.println("CGPA until sem 2: "+obj.cgpa[1]);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		for(int i=0;i<s_sem3.length;i++)
		{
			System.out.println("Subject: "+s_sem3[i]);
			System.out.println("Mark: "+obj.m_sem3[i]);
			System.out.println();
		}
		System.out.println("SGPA of sem 3: "+obj.sgpa[2]);
		System.out.println("CGPA until sem 3: "+obj.cgpa[2]);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		for(int i=0;i<s_sem4.length;i++)
		{
			System.out.println("Subject: "+s_sem4[i]);
			System.out.println("Mark: "+obj.m_sem4[i]);
			System.out.println();
		}
		System.out.println("SGPA of sem 4: "+obj.sgpa[3]);
		System.out.println("CGPA until sem 4: "+obj.cgpa[3]);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		for(int i=0;i<s_sem5.length;i++)
		{
			System.out.println("Subject: "+s_sem5[i]);
			System.out.println("Mark: "+obj.m_sem5[i]);
			System.out.println();
		}
		System.out.println("SGPA of sem 5: "+obj.sgpa[4]);
		System.out.println("CGPA until sem 5: "+obj.cgpa[4]);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		for(int i=0;i<s_sem6.length;i++)
		{
			System.out.println("Subject: "+s_sem6[i]);
			System.out.println("Mark: "+obj.m_sem6[i]);
			System.out.println();
		}
		System.out.println("SGPA of sem 6: "+obj.sgpa[5]);
		System.out.println("CGPA until sem 6: "+obj.cgpa[5]);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		for(int i=0;i<s_sem7.length;i++)
		{
			System.out.println("Subject: "+s_sem7[i]);
			System.out.println("Mark: "+obj.m_sem7[i]);
			System.out.println();
		}
		System.out.println("SGPA of sem 7: "+obj.sgpa[6]);
		System.out.println("CGPA until sem 7: "+obj.cgpa[6]);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		for(int i=0;i<s_sem8.length;i++)
		{
			System.out.println("Subject: "+s_sem8[i]);
			System.out.println("Mark: "+obj.m_sem8[i]);
			System.out.println();
		}
		System.out.println("SGPA of sem 8: "+obj.sgpa[7]);
		System.out.println("CGPA until sem 8: "+obj.cgpa[7]);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
	}
	
}

class Mechanical extends Run
{
	Scanner sc=new Scanner(System.in);
	
	Mechanical()
	{
		s_sem1=new String[]{"Physics","Mathematics - I","Workshop Practice - Laboratory","Engineering Graphics - I","Python Programming"};
		credit_sem1=new double[]{4,4,4,4,5};
		
		s_sem2=new String[]{"Mathematics - II","Engineering Mechanics ","Electrical and Electronics Engineering ","Engineering Graphics - II","Environmental Science "};
		credit_sem2=new double[]{5,6,4,4,0};
		
		s_sem3=new String[]{"Conventional Machining Processes","Mathematics-III","Python Programming","Thermodynamics 1","Strength of Materials ","Kinematics of Machines ","Effective Technical Communication","Constitution of India"};
		credit_sem3=new double[]{5,5,5,4,5,6,3,0};
		
		s_sem4=new String[]{"Fluid Mechanics","Material Science and Metallurgy","Thermodynamics 2","Design of Machine Elements","Design of Machine Elements"};
		credit_sem4=new double[]{6,3,5,6,5};
		
		s_sem5=new String[]{"Engineering Aptitude","Technical English-I","Heat Transfer","Modern Manufacturing Processes and Systems","Machine Design 1","Applied Thermofluid"};
		credit_sem5=new double[]{3,1,6,5,6,5};
		
		s_sem6=new String[]{"Oil Hydraulics and Pneumatics","Quality and Reliability Engineering ","Dynamics of Machinery"};
		credit_sem6=new double[]{4,3,5};
		
		s_sem7=new String[]{"Project-I"};
		credit_sem7=new double[]{5};
		
		s_sem8=new String[]{"Project-II"};
		credit_sem8=new double[]{5};
		
	}
	public void Data()
	{
		// --- Number of Students Validation ---
		int n=0;
		while(true)
		{
			System.out.println("Enter number of students.");
			String input=sc.nextLine().trim();

			// Check: input must not be empty
			if(input.length()==0)
			{
				System.out.println("Input cannot be empty. Please enter a positive integer.");
				continue;
			}

			// Check: input must be a valid integer (no dot, no letters)
			if(isValidInteger(input)==false)
			{
				System.out.println("Invalid input. Please enter a positive integer.");
				continue;
			}

			// Now safe to parse
			n=Integer.parseInt(input);

			// Check: must be positive
			if(n<=0)
			{
				System.out.println("Number of students must be greater than 0. Please enter again.");
				continue;
			}

			// Valid number of students
			break;
		}

		s=new Student[n];
		System.out.println();
		
		for(int i=0;i<s.length;i++)
		{
			s[i]=new Student();
			s[i].setStudentDetail(i+1);
			
			System.out.println("For SEM-1");
			s[i].m_sem1=new double[credit_sem1.length];
			s[i].Marksdetails(s_sem1,s[i].m_sem1);
			s[i].sgpa[0]=calulateSGPA(s[i].m_sem1,credit_sem1);
			s[i].cgpa[0]=calulateCGPA(s[i].sgpa,1);
			
			System.out.println("For SEM-2");
			s[i].m_sem2=new double[credit_sem2.length];
			s[i].Marksdetails(s_sem2,s[i].m_sem2);
			s[i].sgpa[1]=calulateSGPA(s[i].m_sem2,credit_sem2);
			s[i].cgpa[1]=calulateCGPA(s[i].sgpa,2);
			
			
			System.out.println("For SEM-3");
			s[i].m_sem3=new double[credit_sem3.length];
			s[i].Marksdetails(s_sem3,s[i].m_sem3);
			s[i].sgpa[2]=calulateSGPA(s[i].m_sem3,credit_sem3);
			s[i].cgpa[2]=calulateCGPA(s[i].sgpa,3);
			
			System.out.println("For SEM-4");
			s[i].m_sem4=new double[credit_sem4.length];
			s[i].Marksdetails(s_sem4,s[i].m_sem4);
			s[i].sgpa[3]=calulateSGPA(s[i].m_sem4,credit_sem4);
			s[i].cgpa[3]=calulateCGPA(s[i].sgpa,4);
			
			System.out.println("For SEM-5");
			s[i].m_sem5=new double[credit_sem5.length];
			s[i].Marksdetails(s_sem5,s[i].m_sem5);
			s[i].sgpa[4]=calulateSGPA(s[i].m_sem5,credit_sem5);
			s[i].cgpa[4]=calulateCGPA(s[i].sgpa,5);
			
			System.out.println("For SEM-6");
			s[i].m_sem6=new double[credit_sem6.length];
			s[i].Marksdetails(s_sem6,s[i].m_sem6);
			s[i].sgpa[5]=calulateSGPA(s[i].m_sem6,credit_sem6);
			s[i].cgpa[5]=calulateCGPA(s[i].sgpa,6);
			
			System.out.println("For SEM-7");
			s[i].m_sem7=new double[credit_sem7.length];
			s[i].Marksdetails(s_sem7,s[i].m_sem7);
			s[i].sgpa[6]=calulateSGPA(s[i].m_sem7,credit_sem7);
			s[i].cgpa[6]=calulateCGPA(s[i].sgpa,7);
			
			System.out.println("For SEM-8");
			s[i].m_sem8=new double[credit_sem8.length];
			s[i].Marksdetails(s_sem8,s[i].m_sem8);
			s[i].sgpa[7]=calulateSGPA(s[i].m_sem8,credit_sem8);
			s[i].cgpa[7]=calulateCGPA(s[i].sgpa,8);
			
		}
	}
	
	void displayDetails(int sn)
		{
			if(sn>0 && sn<9)
			{
				super.displayDetails(s,sn);
			}
			else
			{
				System.out.println("You have entered Invalid choice.");
			}
		}
	
	
	void sortByCGPA()
	{
		s=super.sortByCGPA(s);
	}
	
	void sortBySGPA(int sn)
	{
		s=super.sortBySGPA(s,sn);
	}
	
	void findStudent(String en)
	{
		boolean b=false;
		for(int i=0;i<s.length;i++)
		{
			if(en.equals(s[i].enrollment_no))
			{
				displayStudent(s[i]);
				b=true;
			}
		}
		if(b==false)
		{
			System.out.println("No such enrollment number found.");
		}
	}
	
	void displayStudent(Student obj)
	{
		System.out.println("Name of student is=  "+obj.name);
		System.out.println();
		System.out.println("enrollment no of student is= "+obj.enrollment_no);
		System.out.println();
		for(int i=0;i<s_sem1.length;i++)
		{
			System.out.println("Subject: "+s_sem1[i]);
			System.out.println("Mark: "+obj.m_sem1[i]);
			System.out.println();
		}
		System.out.println("SGPA of sem 1: "+obj.sgpa[0]);
		System.out.println("CGPA until sem 1: "+obj.cgpa[0]);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		for(int i=0;i<s_sem2.length;i++)
		{
			System.out.println("Subject: "+s_sem2[i]);
			System.out.println("Mark: "+obj.m_sem2[i]);
			System.out.println();
		}
		System.out.println("SGPA of sem 2: "+obj.sgpa[1]);
		System.out.println("CGPA until sem 2: "+obj.cgpa[1]);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		for(int i=0;i<s_sem3.length;i++)
		{
			System.out.println("Subject: "+s_sem3[i]);
			System.out.println("Mark: "+obj.m_sem3[i]);
			System.out.println();
		}
		System.out.println("SGPA of sem 3: "+obj.sgpa[2]);
		System.out.println("CGPA until sem 3: "+obj.cgpa[2]);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		for(int i=0;i<s_sem4.length;i++)
		{
			System.out.println("Subject: "+s_sem4[i]);
			System.out.println("Mark: "+obj.m_sem4[i]);
			System.out.println();
		}
		System.out.println("SGPA of sem 4: "+obj.sgpa[3]);
		System.out.println("CGPA until sem 4: "+obj.cgpa[3]);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		for(int i=0;i<s_sem5.length;i++)
		{
			System.out.println("Subject: "+s_sem5[i]);
			System.out.println("Mark: "+obj.m_sem5[i]);
			System.out.println();
		}
		System.out.println("SGPA of sem 5: "+obj.sgpa[4]);
		System.out.println("CGPA until sem 5: "+obj.cgpa[4]);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		for(int i=0;i<s_sem6.length;i++)
		{
			System.out.println("Subject: "+s_sem6[i]);
			System.out.println("Mark: "+obj.m_sem6[i]);
			System.out.println();
		}
		System.out.println("SGPA of sem 6: "+obj.sgpa[5]);
		System.out.println("CGPA until sem 6: "+obj.cgpa[5]);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		for(int i=0;i<s_sem7.length;i++)
		{
			System.out.println("Subject: "+s_sem7[i]);
			System.out.println("Mark: "+obj.m_sem7[i]);
			System.out.println();
		}
		System.out.println("SGPA of sem 7: "+obj.sgpa[6]);
		System.out.println("CGPA until sem 7: "+obj.cgpa[6]);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		for(int i=0;i<s_sem8.length;i++)
		{
			System.out.println("Subject: "+s_sem8[i]);
			System.out.println("Mark: "+obj.m_sem8[i]);
			System.out.println();
		}
		System.out.println("SGPA of sem 8: "+obj.sgpa[7]);
		System.out.println("CGPA until sem 8: "+obj.cgpa[7]);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
	}
	
}

class Civil extends Run
{
	Scanner sc=new Scanner(System.in);
	
	Civil()
	{
		s_sem1=new String[]{"Python Programming","Basic Civil Engineering","Mathematics-I","Physics"};
		credit_sem1=new double[]{5,5,4,4};
		
		s_sem2=new String[]{"Mathematics-II","Basic Electrical Engineering","Engineering Graphics","Workshop Practice-Laboratory","Environmental Science"};
		credit_sem2=new double[]{4,5,6,2,0};
		
		s_sem3=new String[]{"Mathematics-III","Mechanics of Solids","Building and Town Planning","Geotechnical Engineering","Effective Technical Communication","Constitution of India"};
		credit_sem3=new double[]{5,5,4,5,3,0};
		
		s_sem4=new String[]{"Mathematics-IV","Structural Mechanics-I","Mechanics of Fluids","Concrete Technology","Surveying"};
		credit_sem4=new double[]{5,5,5,4,4};
		
		s_sem5=new String[]{"Project-I"};
		credit_sem5=new double[]{5};
		
		s_sem6=new String[]{"Project-II"};
		credit_sem6=new double[]{5};
		
		s_sem7=new String[]{"Project-III"};
		credit_sem7=new double[]{5};
		
		s_sem8=new String[]{"Project-IV"};
		credit_sem8=new double[]{5};
		
	}
	
	public void Data()
	{
		// --- Number of Students Validation ---
		int n=0;
		while(true)
		{
			System.out.println("Enter number of students.");
			String input=sc.nextLine().trim();

			// Check: input must not be empty
			if(input.length()==0)
			{
				System.out.println("Input cannot be empty. Please enter a positive integer.");
				continue;
			}

			// Check: input must be a valid integer (no dot, no letters)
			if(isValidInteger(input)==false)
			{
				System.out.println("Invalid input. Please enter a positive integer.");
				continue;
			}

			// Now safe to parse
			n=Integer.parseInt(input);

			// Check: must be positive
			if(n<=0)
			{
				System.out.println("Number of students must be greater than 0. Please enter again.");
				continue;
			}

			// Valid number of students
			break;
		}

		s=new Student[n];
		System.out.println();
		
		for(int i=0;i<s.length;i++)
		{
			s[i]=new Student();
			s[i].setStudentDetail(i+1);
			
			System.out.println("For SEM-1");
			s[i].m_sem1=new double[credit_sem1.length];
			s[i].Marksdetails(s_sem1,s[i].m_sem1);
			s[i].sgpa[0]=calulateSGPA(s[i].m_sem1,credit_sem1);
			s[i].cgpa[0]=calulateCGPA(s[i].sgpa,1);
			
			System.out.println("For SEM-2");
			s[i].m_sem2=new double[credit_sem2.length];
			s[i].Marksdetails(s_sem2,s[i].m_sem2);
			s[i].sgpa[1]=calulateSGPA(s[i].m_sem2,credit_sem2);
			s[i].cgpa[1]=calulateCGPA(s[i].sgpa,2);
			
			
			System.out.println("For SEM-3");
			s[i].m_sem3=new double[credit_sem3.length];
			s[i].Marksdetails(s_sem3,s[i].m_sem3);
			s[i].sgpa[2]=calulateSGPA(s[i].m_sem3,credit_sem3);
			s[i].cgpa[2]=calulateCGPA(s[i].sgpa,3);
			
			System.out.println("For SEM-4");
			s[i].m_sem4=new double[credit_sem4.length];
			s[i].Marksdetails(s_sem4,s[i].m_sem4);
			s[i].sgpa[3]=calulateSGPA(s[i].m_sem4,credit_sem4);
			s[i].cgpa[3]=calulateCGPA(s[i].sgpa,4);
			
			System.out.println("For SEM-5");
			s[i].m_sem5=new double[credit_sem5.length];
			s[i].Marksdetails(s_sem5,s[i].m_sem5);
			s[i].sgpa[4]=calulateSGPA(s[i].m_sem5,credit_sem5);
			s[i].cgpa[4]=calulateCGPA(s[i].sgpa,5);
			
			System.out.println("For SEM-6");
			s[i].m_sem6=new double[credit_sem6.length];
			s[i].Marksdetails(s_sem6,s[i].m_sem6);
			s[i].sgpa[5]=calulateSGPA(s[i].m_sem6,credit_sem6);
			s[i].cgpa[5]=calulateCGPA(s[i].sgpa,6);
			
			System.out.println("For SEM-7");
			s[i].m_sem7=new double[credit_sem7.length];
			s[i].Marksdetails(s_sem7,s[i].m_sem7);
			s[i].sgpa[6]=calulateSGPA(s[i].m_sem7,credit_sem7);
			s[i].cgpa[6]=calulateCGPA(s[i].sgpa,7);
			
			System.out.println("For SEM-8");
			s[i].m_sem8=new double[credit_sem8.length];
			s[i].Marksdetails(s_sem8,s[i].m_sem8);
			s[i].sgpa[7]=calulateSGPA(s[i].m_sem8,credit_sem8);
			s[i].cgpa[7]=calulateCGPA(s[i].sgpa,8);
			
		}
	}
	
	void displayDetails(int sn)
		{
			if(sn>0 && sn<9)
			{
				super.displayDetails(s,sn);
			}
			else
			{
				System.out.println("You have entered Invalid choice.");
			}
		}
	
	
	void sortByCGPA()
	{
		s=super.sortByCGPA(s);
	}
	
	void sortBySGPA(int sn)
	{
		s=super.sortBySGPA(s,sn);
	}
	
	void findStudent(String en)
	{
		boolean b=false;
		for(int i=0;i<s.length;i++)
		{
			if(en.equals(s[i].enrollment_no))
			{
				displayStudent(s[i]);
				b=true;
			}
		}
		if(b==false)
		{
			System.out.println("No such enrollment number found.");
		}
	}
	
	void displayStudent(Student obj)
	{
		System.out.println("Name of student is=  "+obj.name);
		System.out.println();
		System.out.println("enrollment no of student is= "+obj.enrollment_no);
		System.out.println();
		for(int i=0;i<s_sem1.length;i++)
		{
			System.out.println("Subject: "+s_sem1[i]);
			System.out.println("Mark: "+obj.m_sem1[i]);
			System.out.println();
		}
		System.out.println("SGPA of sem 1: "+obj.sgpa[0]);
		System.out.println("CGPA until sem 1: "+obj.cgpa[0]);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		for(int i=0;i<s_sem2.length;i++)
		{
			System.out.println("Subject: "+s_sem2[i]);
			System.out.println("Mark: "+obj.m_sem2[i]);
			System.out.println();
		}
		System.out.println("SGPA of sem 2: "+obj.sgpa[1]);
		System.out.println("CGPA until sem 2: "+obj.cgpa[1]);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		for(int i=0;i<s_sem3.length;i++)
		{
			System.out.println("Subject: "+s_sem3[i]);
			System.out.println("Mark: "+obj.m_sem3[i]);
			System.out.println();
		}
		System.out.println("SGPA of sem 3: "+obj.sgpa[2]);
		System.out.println("CGPA until sem 3: "+obj.cgpa[2]);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		for(int i=0;i<s_sem4.length;i++)
		{
			System.out.println("Subject: "+s_sem4[i]);
			System.out.println("Mark: "+obj.m_sem4[i]);
			System.out.println();
		}
		System.out.println("SGPA of sem 4: "+obj.sgpa[3]);
		System.out.println("CGPA until sem 4: "+obj.cgpa[3]);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		for(int i=0;i<s_sem5.length;i++)
		{
			System.out.println("Subject: "+s_sem5[i]);
			System.out.println("Mark: "+obj.m_sem5[i]);
			System.out.println();
		}
		System.out.println("SGPA of sem 5: "+obj.sgpa[4]);
		System.out.println("CGPA until sem 5: "+obj.cgpa[4]);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		for(int i=0;i<s_sem6.length;i++)
		{
			System.out.println("Subject: "+s_sem6[i]);
			System.out.println("Mark: "+obj.m_sem6[i]);
			System.out.println();
		}
		System.out.println("SGPA of sem 6: "+obj.sgpa[5]);
		System.out.println("CGPA until sem 6: "+obj.cgpa[5]);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		for(int i=0;i<s_sem7.length;i++)
		{
			System.out.println("Subject: "+s_sem7[i]);
			System.out.println("Mark: "+obj.m_sem7[i]);
			System.out.println();
		}
		System.out.println("SGPA of sem 7: "+obj.sgpa[6]);
		System.out.println("CGPA until sem 7: "+obj.cgpa[6]);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		for(int i=0;i<s_sem8.length;i++)
		{
			System.out.println("Subject: "+s_sem8[i]);
			System.out.println("Mark: "+obj.m_sem8[i]);
			System.out.println();
		}
		System.out.println("SGPA of sem 8: "+obj.sgpa[7]);
		System.out.println("CGPA until sem 8: "+obj.cgpa[7]);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
	}
	
}

class Main
{
	// Helper method: checks if a string is a valid integer (no dot allowed).
	// Allows optional leading minus sign.
	static boolean isValidInteger(String input)
	{
		if(input==null || input.length()==0)
		{
			return false;
		}
		int startIndex=0;
		if(input.charAt(0)=='-')
		{
			startIndex=1;
		}
		if(startIndex>=input.length())
		{
			return false;
		}
		for(int i=startIndex;i<input.length();i++)
		{
			char c=input.charAt(i);
			if(c<'0' || c>'9')
			{
				return false;
			}
		}
		return true;
	}

	// Helper method: validates enrollment number (must be exactly 14 digits).
	static boolean isValidEnrollment(String en)
	{
		if(en==null || en.length()!=14)
		{
			return false;
		}
		for(int i=0;i<14;i++)
		{
			char c=en.charAt(i);
			if(c<'0' || c>'9')
			{
				return false;
			}
		}
		return true;
	}

	public static void main(String args [])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Select branch: Enter 1 for CSE, 2 for Mechanical,3 for Civil.");
		int choice=0;
		String en;
		
		while(true)
		{
			// --- Branch Choice Validation ---
			String branchInput=sc.nextLine().trim();

			// Check: branch input must not be empty
			if(branchInput.length()==0)
			{
				System.out.println("Input cannot be empty. Enter valid Choice:");
				continue;
			}

			// Check: must be a valid integer
			if(isValidInteger(branchInput)==false)
			{
				System.out.println("Invalid input. Enter valid Choice:");
				continue;
			}

			// Now safe to parse
			choice=Integer.parseInt(branchInput);

			if(choice==1)
			{
				CSE cs=new CSE();
				cs.Data();
				int n=0;
				while(true)
				{
					System.out.println("Enter your choice according to given option:");
					System.out.println("press 1 for Display all student's CGPA and SGPA:");
					System.out.println("press 2 for sort students by CGPA of last semester:");
					System.out.println("press 3 for sort students by SGPA:");
					System.out.println("press 4 for display any one student's detail:");
					System.out.println("press 5 for exit:");
					
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

					// --- Menu Choice Validation ---
					String menuInput=sc.nextLine().trim();

					// Check: menu input must not be empty
					if(menuInput.length()==0)
					{
						System.out.println("Input cannot be empty. Please enter a choice between 1 to 5.");
						continue;
					}

					// Check: must be a valid integer
					if(isValidInteger(menuInput)==false)
					{
						System.out.println("Invalid input. Please enter a choice between 1 to 5.");
						continue;
					}

					// Now safe to parse
					n=Integer.parseInt(menuInput);

					// Check: must be between 1 and 5
					if(n<1 || n>5)
					{
						System.out.println("Invalid choice. Please enter a choice between 1 to 5.");
						continue;
					}
					
					if(n==5)
					{
						break;
					}
					switch(n)
					{
						case 1:
								System.out.println("Enter the semester number that you want to display detail");

								// --- Semester Number Validation ---
								int semNum1=0;
								while(true)
								{
									String semInput=sc.nextLine().trim();

									if(semInput.length()==0)
									{
										System.out.println("Input cannot be empty. Enter semester number between 1 to 8:");
										continue;
									}

									if(isValidInteger(semInput)==false)
									{
										System.out.println("Invalid input. Enter semester number between 1 to 8:");
										continue;
									}

									semNum1=Integer.parseInt(semInput);

									if(semNum1<1 || semNum1>8)
									{
										System.out.println("You have entered Invalid sem number. Enter semester number between 1 to 8:");
										continue;
									}

									// Valid semester number
									break;
								}
								cs.displayDetails(semNum1);
								break;
						case 2:
								
								cs.sortByCGPA();
								break;
						case 3:
								System.out.println("Enter the semester number by which you want to sort detail");

								// --- Semester Number Validation ---
								int semNum2=0;
								while(true)
								{
									String semInput=sc.nextLine().trim();

									if(semInput.length()==0)
									{
										System.out.println("Input cannot be empty. Enter semester number between 1 to 8:");
										continue;
									}

									if(isValidInteger(semInput)==false)
									{
										System.out.println("Invalid input. Enter semester number between 1 to 8:");
										continue;
									}

									semNum2=Integer.parseInt(semInput);

									if(semNum2<1 || semNum2>8)
									{
										System.out.println("You have entered Invalid sem number. Enter semester number between 1 to 8:");
										continue;
									}

									// Valid semester number
									break;
								}
								cs.sortBySGPA(semNum2);
								break;
						case 4:
								System.out.println("Enter Enrollment no: ");

								// --- Enrollment Number Validation for Search ---
								while(true)
								{
									en=sc.nextLine().trim();

									if(isValidEnrollment(en)==false)
									{
										if(en.length()==0)
										{
											System.out.println("Enrollment number cannot be empty. Enter a valid 14-digit enrollment number:");
										}
										else if(en.length()!=14)
										{
											System.out.println("Enrollment number must be exactly 14 digits. Enter again:");
										}
										else
										{
											System.out.println("Invalid enrollment number. It must contain only digits. Enter again:");
										}
										continue;
									}

									// Valid enrollment number
									break;
								}
								cs.findStudent(en);
								break;
					}
				}
				break;
			}
			else if(choice==2)
			{
				Mechanical mn=new Mechanical();
				mn.Data();
				int n=0;
				while(true)
				{
					System.out.println("Enter your choice according to given option:");
					System.out.println("press 1 for Display all student's CGPA and SGPA:");
					System.out.println("press 2 for sort students by CGPA of last semester:");
					System.out.println("press 3 for sort students by SGPA:");
					System.out.println("press 4 for display any one student's detail:");
					System.out.println("press 5 for exit:");
					
					// --- Menu Choice Validation ---
					String menuInput=sc.nextLine().trim();

					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

					// Check: menu input must not be empty
					if(menuInput.length()==0)
					{
						System.out.println("Input cannot be empty. Please enter a choice between 1 to 5.");
						continue;
					}

					// Check: must be a valid integer
					if(isValidInteger(menuInput)==false)
					{
						System.out.println("Invalid input. Please enter a choice between 1 to 5.");
						continue;
					}

					// Now safe to parse
					n=Integer.parseInt(menuInput);

					// Check: must be between 1 and 5
					if(n<1 || n>5)
					{
						System.out.println("Invalid choice. Please enter a choice between 1 to 5.");
						continue;
					}
					
					if(n==5)
					{
						break;
					}
					switch(n)
					{
						case 1:
								System.out.println("Enter the semester number that you want to display detail");

								// --- Semester Number Validation ---
								int semNum1=0;
								while(true)
								{
									String semInput=sc.nextLine().trim();

									if(semInput.length()==0)
									{
										System.out.println("Input cannot be empty. Enter semester number between 1 to 8:");
										continue;
									}

									if(isValidInteger(semInput)==false)
									{
										System.out.println("Invalid input. Enter semester number between 1 to 8:");
										continue;
									}

									semNum1=Integer.parseInt(semInput);

									if(semNum1<1 || semNum1>8)
									{
										System.out.println("You have entered Invalid sem number. Enter semester number between 1 to 8:");
										continue;
									}

									// Valid semester number
									break;
								}
								mn.displayDetails(semNum1);
								break;
						case 2:
								mn.sortByCGPA();
								break;
						case 3:
								System.out.println("Enter the semester number by which you want to sort detail");

								// --- Semester Number Validation ---
								int semNum2=0;
								while(true)
								{
									String semInput=sc.nextLine().trim();

									if(semInput.length()==0)
									{
										System.out.println("Input cannot be empty. Enter semester number between 1 to 8:");
										continue;
									}

									if(isValidInteger(semInput)==false)
									{
										System.out.println("Invalid input. Enter semester number between 1 to 8:");
										continue;
									}

									semNum2=Integer.parseInt(semInput);

									if(semNum2<1 || semNum2>8)
									{
										System.out.println("You have entered Invalid sem number. Enter semester number between 1 to 8:");
										continue;
									}

									// Valid semester number
									break;
								}
								mn.sortBySGPA(semNum2);
								break;
						case 4:
								System.out.println("Enter Enrollment no: ");

								// --- Enrollment Number Validation for Search ---
								while(true)
								{
									en=sc.nextLine().trim();

									if(isValidEnrollment(en)==false)
									{
										if(en.length()==0)
										{
											System.out.println("Enrollment number cannot be empty. Enter a valid 14-digit enrollment number:");
										}
										else if(en.length()!=14)
										{
											System.out.println("Enrollment number must be exactly 14 digits. Enter again:");
										}
										else
										{
											System.out.println("Invalid enrollment number. It must contain only digits. Enter again:");
										}
										continue;
									}

									// Valid enrollment number
									break;
								}
								mn.findStudent(en);
								break;
					}
				}
				break;
			}
			else if(choice==3)
			{
				Civil cv=new Civil();
				cv.Data();
				int n=0;
				while(true)
				{
					System.out.println("Enter your choice according to given option:");
					System.out.println("press 1 for Display all student's CGPA and SGPA:");
					System.out.println("press 2 for sort students by CGPA of last semester:");
					System.out.println("press 3 for sort students by SGPA:");
					System.out.println("press 4 for display any one student's detail:");
					System.out.println("press 5 for exit:");
					
					// --- Menu Choice Validation ---
					String menuInput=sc.nextLine().trim();

					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

					// Check: menu input must not be empty
					if(menuInput.length()==0)
					{
						System.out.println("Input cannot be empty. Please enter a choice between 1 to 5.");
						continue;
					}

					// Check: must be a valid integer
					if(isValidInteger(menuInput)==false)
					{
						System.out.println("Invalid input. Please enter a choice between 1 to 5.");
						continue;
					}

					// Now safe to parse
					n=Integer.parseInt(menuInput);

					// Check: must be between 1 and 5
					if(n<1 || n>5)
					{
						System.out.println("Invalid choice. Please enter a choice between 1 to 5.");
						continue;
					}
					
					if(n==5)
					{
						break;
					}
					switch(n)
					{
						case 1:
								System.out.println("Enter the semester number that you want to display detail");

								// --- Semester Number Validation ---
								int semNum1=0;
								while(true)
								{
									String semInput=sc.nextLine().trim();

									if(semInput.length()==0)
									{
										System.out.println("Input cannot be empty. Enter semester number between 1 to 8:");
										continue;
									}

									if(isValidInteger(semInput)==false)
									{
										System.out.println("Invalid input. Enter semester number between 1 to 8:");
										continue;
									}

									semNum1=Integer.parseInt(semInput);

									if(semNum1<1 || semNum1>8)
									{
										System.out.println("You have entered Invalid sem number. Enter semester number between 1 to 8:");
										continue;
									}

									// Valid semester number
									break;
								}
								cv.displayDetails(semNum1);
								break;
						case 2:
								cv.sortByCGPA();
								break;
						case 3:
								System.out.println("Enter the semester number by which you want to sort detail");

								// --- Semester Number Validation ---
								int semNum2=0;
								while(true)
								{
									String semInput=sc.nextLine().trim();

									if(semInput.length()==0)
									{
										System.out.println("Input cannot be empty. Enter semester number between 1 to 8:");
										continue;
									}

									if(isValidInteger(semInput)==false)
									{
										System.out.println("Invalid input. Enter semester number between 1 to 8:");
										continue;
									}

									semNum2=Integer.parseInt(semInput);

									if(semNum2<1 || semNum2>8)
									{
										System.out.println("You have entered Invalid sem number. Enter semester number between 1 to 8:");
										continue;
									}

									// Valid semester number
									break;
								}
								cv.sortBySGPA(semNum2);
								break;
						case 4:
								System.out.println("Enter Enrollment no: ");

								// --- Enrollment Number Validation for Search ---
								while(true)
								{
									en=sc.nextLine().trim();

									if(isValidEnrollment(en)==false)
									{
										if(en.length()==0)
										{
											System.out.println("Enrollment number cannot be empty. Enter a valid 14-digit enrollment number:");
										}
										else if(en.length()!=14)
										{
											System.out.println("Enrollment number must be exactly 14 digits. Enter again:");
										}
										else
										{
											System.out.println("Invalid enrollment number. It must contain only digits. Enter again:");
										}
										continue;
									}

									// Valid enrollment number
									break;
								}
								cv.findStudent(en);
								break;
					}
				}
				break;
			}
			else
			{
				System.out.println("Enter valid Choice:");
			}
		}
		
	}
}

	