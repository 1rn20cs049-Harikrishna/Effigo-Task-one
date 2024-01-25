package FirstAssignment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
	
	// To check the valid format of the date
	public static boolean isValidFormat(String dateStr) {
		Pattern DatePattern = Pattern.compile("^\\d{2}-\\d{2}-\\d{4}");
		if(DatePattern.matcher(dateStr).matches()){
			return true;
		}
		return false;
	}
	
	  // To display all the employees
	  public static void DisplayEmployees(List<Employee> empList) {
		  int idx  = 1 ;
		  for(Employee emp : empList) {
			  System.out.println("sl No : " + idx  + " " + emp);
			  idx++;
		  }
	  }
	
	

@SuppressWarnings("finally")
public static Date PatternChecker(String date) {
	   
	  String pattern = "dd-MM-yyyy";
	  Date dateObject = null;

       try {
           SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            dateObject = sdf.parse(date);                    
            
            // for strict parsing
            sdf.setLenient(false);

           
       } catch (ParseException e) {
    //       e.printStackTrace(); // Handle parsing exception as needed
           System.out.print("There is some error in pattern matching");
       }
	    finally {
	    	//System.out.println("There are no errors during pattern check");
	    	return dateObject;
	    }
	 
	   
   }
   
   public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);

	   
	   System.out.println("Here, we can create the new Employees");
	   System.out.println("Enter the number of employees to be created\n");
	   
	   int n = sc.nextInt();
	   
	   //creating list to add the employees
	   List<Employee> empList = new ArrayList<>();
	   
	   while(n-- > 0) {
		   System.out.print("Enter the new Employee details :\n ");
		   System.out.print(" Name : ");
		   String name = sc.next();
		   
		   System.out.print("\nDate of Birth(dd-MM-yyyy) : ");
		   String dob = sc.next();		   
		   boolean dobValid = isValidFormat(dob);
		  
		   
		   // Asking for user to provide the valid format (by providing other chance if makes any mistake"
		   while(!dobValid) {
			   System.out.println("Provided date format(DOB) is wrong, Kindly provide the correct format");
			    dob = sc.next();
			    dobValid = isValidFormat(dob);			    			  
		   }
		   Date dobObject = PatternChecker(dob);
		   
		   
		   System.out.print("\nDate of joining(dd-MM-yyyy) : ");
		   String doj = sc.next();
		   boolean dojValid = isValidFormat(doj);

		   while(!dojValid) {
			   System.out.println("Provided date format(DOJ) is wrong, Kindly provide the correct format");
			    doj = sc.next();
			    dojValid = isValidFormat(doj);			    			  
		   }
		   Date dojObject = PatternChecker(doj);
		   empList.add(new Employee(name,dobObject,dojObject));
		   
		   
	   }
	   
	   System.out.println();
	   System.out.println("Enter the attribute to sort by (name, dob, doj):  \n if No proper input provided then default sorting happens based on name");
       String sortBy = sc.next();
	   EmployeeComparator OrderForSort = new  EmployeeComparator(sortBy);
	   
	   Collections.sort(empList,OrderForSort);
	   
//	   System.out.println("\n A for Ascending and D for  Descending order type(A or D)");	   
//	   String order = sc.next();
//	   
//	   while(!order.equals("A") && !order.equals("D")) {
//		   System.out.println("Enter the valid input");
//		   order = sc.next();
//	   }
//	   // reverse the order 
//	   if(order == "D") {
//		   Collections.sort(empList,Collections.reverseOrder());
//	   }
	   
	   
	   
	   
	   // Displaying the employees
	   System.out.println("\n List of Employees : ");
	   DisplayEmployees(empList);	    
	   
      // closing the scanner Object
	   sc.close();
	   
   }
}
