import java.util.*;
public class Inheritance {
    public static void main(String args[]) {
        Undergrad jit = new Undergrad();
        //jit.ClassAdd("nah",30,85); //(String CourseName, int Credits, int FinalGrade)
        //Uncomment this line when you want to add a course to the list as a Student or any of its subclasses
        System.out.println(jit);
        
        //System.out.print(jit.courseList());
        //Uncomment this line when you want to see the list of courses a Student or its subclasses are taking
    }
}

class Person{
    private String name;
    private String address;
    private int phoneNumber;
    
    public Person(){
        name = "John Doe";
        address = "123 Rainbow Road";
        phoneNumber = 12345678;
    }
    
    public Person(String n, String a, int pn){
        name = n;
        address = a;
        phoneNumber = pn;
    }
    
    public String toString(){
        return "Name- "+name+", Address- "+address+", Phone Number- "+phoneNumber;
    }
}

class Course{
    private String courseName;
    private int credits;
    private int finalGrade;
    
    public Course(){
        courseName = "Computer Science";
        credits = 3;
        finalGrade = (int)(Math.random()*50+51);//Gives numbers between 50 and 100
    }
    
    public Course(String cn, int c, int fg){
        courseName = cn;
        credits = c;
        finalGrade = fg;
    }
    
    //Returns Final Grade for GPA avg in Student
    public int finalGrade(){
        return finalGrade;
    }
    
    //Getter for credits used in Student
    public int credits(){
        return credits;
    }
    
    public String toString(){
        return "Course Name- "+courseName+", Credits- "+credits+", Final Grade- "+finalGrade;
    }
}

class Employee extends Person{
    private int ID;
    private int OfficeNumber;
    private int Salary;
    private String dateHired;
    private String Department;
    
    public Employee(){
        super();
        ID = 14;
        OfficeNumber = 35;
        Salary = 67000;
        dateHired = "January 1st";
        Department = "Math";
    }
    
    public Employee(String n, String a, int pn, int i, int o, int s, String dh, String d){
        super(n,a,pn);
        ID = i;
        OfficeNumber = o;
        Salary = s;
        dateHired = dh;
        Department = d;
    }
    
    public String toString(){
        return super.toString()+", ID- "+ID+", Office Number- "+OfficeNumber+", Salary- "+Salary+", Date Hired- "+dateHired+", Department- "+Department;
    }
}

class Student extends Person{
    private List<Course> Courses = new ArrayList<Course>();
    private int gpa = 0;
    private String degree;
    
    public Student(){
        degree = "Computer Science";
        Courses.add(new Course());//Adds a random class
    }
    
    public Student(String n, String a, int pn, String d){
        super(n,a,pn);
        degree = d;
        Courses.add(new Course());
    }
    
    //Adds a class to the List of classes
    public void ClassAdd(String name, int credits, int finalGrade){
        Courses.add(new Course(name,credits,finalGrade));
    }
    
    //Removes a class from the List of classes
    public void ClassRemove(int id){
        Courses.remove(id);
    }
    
    //Calculates Average GPA
    public int GPA(){
        int t = 0;
        for(int i=0; i<Courses.size(); i++){
            t+=Courses.get(i).finalGrade();
        }
        return t/Courses.size();
    }
    
    //Prints List of Courses
    public String courseList(){
        String text = "\nCourse List\n";
        for(int i=0; i<Courses.size(); i++){
            text+=Courses.get(i).toString()+"\n";
        }
        return text;
    }
    
    //Sums the total amount of credits for underGrad
    public int creditCount(){
        int c = 0;
        for(int i=0; i<Courses.size(); i++){
            c+=Courses.get(i).credits();
        }
        return c;
    }
    
    public String toString(){
        return super.toString()+", Degree- "+degree+", GPA- "+GPA();
    }
}

class Faculty extends Employee{
    private boolean prof;
    public Faculty(){
        super();
        prof = true;
    }
    
    public Faculty(String n, String a, int pn, int i, int o, int s, String dh, String d, boolean p){
        super(n,a,pn,i,o,s,dh,d);
        prof = p;
    }
    
    //Checks if professor or assoc. professor
    public String profCheck(){
        if(prof)
            return "Professor";
        return "Associate Professor";
    }
    
    public String toString(){
        return super.toString()+", Type- "+profCheck();
    }
}

class Staff extends Employee{
    String[] Role = {"Regular","Support","Technician","Admin","Manager"};
    int rNum;//Any number from 0-4 to get a role within the array of roles
    public Staff(){
        super();
        rNum = 0;
    }
    
    public Staff(String n, String a, int pn, int i, int o, int s, String dh, String d,int r){
        super(n,a,pn,i,o,s,dh,d);
        rNum = r;
    }
    
    //Used to change a Staff Members role
    public void roleChange(int n){
        rNum = n;
    }
    
    //Takes the role number and returns its string counter-part
    public String roleCheck(){
        return Role[rNum];
    }
    
    public String toString(){
        return super.toString()+", Role- "+roleCheck();
    }
}

class Grad extends Student{
    public Grad(){
        super();
    }
    
    public Grad(String n, String a, int pn, String d){
        super(n,a,pn,d);
    }
    
    public String distinctionCheck(){
        if(GPA()>=85)
            return "True";
        return "False";
    }
    
    public String toString(){
        return super.toString()+", Will Graduate With Distinction- "+distinctionCheck();
    }
}

class Undergrad extends Student{
    public Undergrad(){
        super();
    }
    
    public Undergrad(String n, String a, int pn, String d){
        super(n,a,pn,d);
    }
    
    //Checks Grade Expectation
    public String Expectation(){
        if(GPA()>=85)
            return "cum laude";
        if(GPA()>=90)
            return "magna cum laude";
        if(GPA()>=95)
            return "summa cum laude";
        return "None";
    }
    
    //Checks Grade
    public String Grade(){
        if(creditCount()<=30)
            return "Freshman";
        if(creditCount()<=60)
            return "Sophomore";
        if(creditCount()<=90)
            return "Junior";
        return "Senior";
    }
    
    public String toString(){
        return super.toString()+", Grade- "+Grade()+", Degree Expectation- "+Expectation();
    }
}
