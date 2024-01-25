package FirstAssignment;


import java.util.Comparator;
import java.util.Date;

public class Employee {
	
	private String name;	
	private Date dob;
	private Date doj;
	
	
	public Employee(String name, Date dob, Date doj) {
		this.name = name;
		this.dob = dob;
		this.doj = doj;
	}	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	
	//To print the Employee
	@Override
	public String toString() {
		return "Employee [ Name = " + name + ", Date of Birth = " + dob + ",  Date of Joining = " + doj + "]";
	} 
	

}


class EmployeeComparator implements Comparator<Employee> {

    private String sortBy;

    public EmployeeComparator(String sortBy) {
        this.sortBy = sortBy;
    }
    
    //compareTo method works with Wrapper classes, primitive types can be automatically convert to Wrapper classes by AutoBoxing

    @Override
    public int compare(Employee emp1, Employee emp2) {
        switch (sortBy) {
            case "name":
                return emp1.getName().compareTo(emp2.getName());
            case "dob":
                return emp1.getDob().compareTo(emp2.getDob());
            case "doj":
                return emp1.getDoj().compareTo(emp2.getDoj());
            default:
            	return emp1.getName().compareTo(emp2.getName());
//            	throw new IllegalArgumentException("Invalid attribute for sorting: " + sortBy);
        }   
    }
}

