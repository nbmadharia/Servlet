package practical6;

import java.sql.*;
import java.util.Scanner;

public class Practical6 {

    static void insert(String name, String desgn, String doj, long salary) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/info","root","");
            Statement sm = con.createStatement();
            sm.executeUpdate("INSERT INTO `employees` (`EmpID`, `EmpName`, `EmpDesg`, `EmpJDate`, `EmpSalary`) VALUES (NULL, '"+name+"', '"+desgn+"', '"+doj+"', '"+salary+"');");
        }catch(Exception E){
            System.out.println(E);
        }            
    }
    
    static void show(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/info","root","220214");
            Statement sm = con.createStatement();
            ResultSet res = sm.executeQuery("select * from employees");
            System.out.println("Id Name Designation Doj Salary");
            while(res.next()){
                System.out.println(res.getString(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getString(4)+" "+res.getString(5));
            }
        }catch(Exception E){
            System.out.println(E);
        }
    }
    
    static void delete(int id){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/info","root","");
            Statement sm = con.createStatement();
            sm.executeUpdate("delete from employees where empid = "+id);
            System.out.println("Id Deleted From Employee Table");
        }catch(Exception E){
            System.out.println(E);
        }
    }
    
    static void update(int id,String desg){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/info","root","");
            Statement sm = con.createStatement();
            sm.executeUpdate("update employees set EmpDesg = '"+desg+"' where empid = "+id);
        }catch(Exception E){
            System.out.println(E);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner scan = new Scanner(System.in).useDelimiter("\n");
        while(true){
            boolean exit = false;
            System.out.println("1. Insert");
            System.out.println("2. View");
            System.out.println("3. Delete");
            System.out.println("4. Update ");
            System.out.println("5. Exit");
            System.out.print("Enter Option: ");
            int op = sc.nextInt();
            switch(op){
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scan.next();
                    System.out.print("Enter Designation: ");
                    String desg = scan.next();
                    System.out.print("Enter Date of Joining: ");
                    String doj = sc.next();
                    System.out.print("Enter Salary: ");
                    long salary = sc.nextLong();
                    insert(name,desg,doj,salary);
                    break;
                case 2:
                    show();
                    break;
                case 3:
                    System.out.print("Enter id of the employee to be deleted: ");
                    int id = sc.nextInt();
                    delete(id);
                    break;
                case 4:
                    System.out.print("Enter id whose designation has to be changed: ");
                    int upId = sc.nextInt();
                    System.out.print("Enter change in designation: ");
                    String upDesg = scan.next();
                    update(upId,upDesg);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Enter valid number!!!");
                    break;
            }
            System.out.println();
            if(exit) break;
        }
    }

}

