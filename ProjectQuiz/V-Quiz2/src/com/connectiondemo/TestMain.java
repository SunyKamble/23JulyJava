package com.connectiondemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class TestMain {

	public static void main(String[] args) throws SQLException {
		
		 
		Quiz que= new Quiz();
		que.addQuetions();

	}

}

class Quiz{
	

	
	public void addQuetions() throws SQLException{
	Connection connection=null;
	 PreparedStatement pre=null;
    int correctAnsCount=0;
    int wrongAnsCount=0;
  
    
	Scanner sc= new Scanner(System.in);
	Quetions q1= new Quetions("In which of the following is toString() method defined?","A.java.lang.Object","B.java.lang.String","C.java.lang.util","D.None");
	Quetions q2= new Quetions("\r\n"
			+ "Arrays in java are","A.Object references","B.Objects","C.Primitive data type","D.None");
	Quetions q3= new Quetions("\r\n"
			+ "\r\n"
			+ "What is the size of float and double in java?","A.32 and 64","B.32 and 32","C.64 and 64","D.64 and 32");
	Quetions q4= new Quetions("\r\n"
			+ "\r\n"
			+ "Automatic type conversion is possible in which of the possible cases?","A.Byte to int","B.int to long","C.long to int","D.short to int");
	Quetions q5= new Quetions("\r\n"
			+ "\r\n"
			+ "Identify the return type of a method that does not return any value.","A.int","B.double","C.float","D.void");
	Quetions q6= new Quetions("\r\n"
			+ "\r\n"
			+ "Where does the system stores parameters and local variables whenever a method is invoked?","A.Heap","B.Array","C.Stack","D.None");
	Quetions q7= new Quetions("\r\n"
			+ "\r\n"
			+ "What is the variables declared in a class for the use of all methods of the class called?","A.Object","B.Instance Variable","C.Reference Variable","D.None");
	Quetions q8= new Quetions("\r\n"
			+ "\r\n"
			+ "\r\n"
			+ "When is the finalize() method called?","A.Before Garbage collection","B.Before an object out of scope","C.Before a variable out of scope","D.None");
	Quetions q9= new Quetions("\r\n"
			+ "\r\n"
			+ "What is Runnable?","A.Abstract class","B.Interface","C.Class","D.Method");
	
	
	Map<Quetions,Character> map= new HashMap<Quetions,Character>();
	map.put(q1, 'A');  //key has >> a Question
	map.put(q2, 'B');   //value will be the >> a answer
	map.put(q3, 'A');
	map.put(q4, 'B');
	map.put(q5, 'D');
	map.put(q6, 'C');
	map.put(q7, 'B');
	map.put(q8, 'A');
	map.put(q9, 'B');
	
	     
	
	        for(int i=1;i<2;i++) {
			System.out.println("Enter Your Name>> ");
			String studentName=sc.next();
	        
	         Set<Entry<Quetions, Character>> set = map.entrySet();
	           
	             for(Entry<Quetions, Character> entry:set) { 
	        	 System.out.println(entry.getKey().getQue_Statement());   //Question 1 will be print
	        	 System.out.println(entry.getKey().getA());             
	        	 System.out.println(entry.getKey().getB());
	        	 System.out.println(entry.getKey().getC());
	        	 System.out.println(entry.getKey().getD());
	        	 
	        	 System.out.println("Enter the Answer>>");
	        	 Character ans=sc.next().charAt(0); 
	        	
	        	 
	        	 int cans= Character.compare(ans, entry.getValue());
	        	 if(cans==0) {
	        		 System.out.println("Correct");
	        		 correctAnsCount++;
	        	 }
	        	 else {
	        		 System.out.println("Wrong");
	        		 wrongAnsCount++;
	        	 }
	        	 
	        	 
	         }
	                      
	         System.out.println();
	         System.out.println("---------Result---------");
	        
	         System.out.println(studentName);
	         System.out.println("Total Quetions: "+map.size());
	         System.out.println("Correct Answer Count Quetions>> "+correctAnsCount);
	         System.out.println("Wrong Answer Count Quetions>> "+wrongAnsCount);
	         System.out.println(""+correctAnsCount/map.size());
	        // float percentage=(correctAnsCount*100f)/map.size();
	         //System.out.println("Percentage>> "+percentage);
	         
	         /*Class A- 8-10
                  Class B- 6-8
                     Class C- 5
                     Class D- <5 then its fail.*/
	        
	        
	         if(correctAnsCount>8) {
	        	 System.out.println("your Grade Is>> ");
	        	 System.out.println("Class A");
	        	 
	        	
	         }
	         else if(correctAnsCount>=6 && correctAnsCount<=8) {
	        	 System.out.println("your Grade Is>> ");
	        	 System.out.println("Class B");
	        	 
	         }
	         else if(correctAnsCount<=6 && correctAnsCount>=5) {
	        	 System.out.println("your Grade Is>> ");
	        	 System.out.println("Class C");
	        	
	         }
	         else if (correctAnsCount<5){
	        	 System.out.println("---Fail----");
	        	 System.out.println("-----Best Luck-----!");
	        	  
	         }
	         
	       
			try {
					Class.forName("com.mysql.jdbc.Driver");
					 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "123456");
					 pre = connection.prepareStatement("INSERT INTO student_test (student_name,Marks) VALUES (?,?)");
					pre.setString(1, studentName);
					pre.setInt(2, correctAnsCount);
					
					int in = pre.executeUpdate();
					System.out.println();
					System.out.println("Your Test is submitted " + in);
					System.out.println("Thanks for participation");
					} catch(Exception e) {
						System.out.println(e);
						e.printStackTrace();
					} finally {
						connection.close();
						pre.close();
					}

	     }
	}
}
