package payrollsystem.java;
import java.util.*;
abstract class employee{
    private String name;
    private int id;
    public employee(String name,int id){
        this.name=name;
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public abstract double calculatesalary();
    @Override
    public String toString(){         //this overriding is used because we want desired output and we also know what is overriding ie it,s is refrance of polymorphysm
        return "employee[name="+name+",id="+id+",salary="+calculatesalary()+"]";
    }
}
class fulltimeemployee extends employee {
    private double monthlyselary;

    public fulltimeemployee(String name, int id, double monthlyselary) {
        super(name, id);
        this.monthlyselary = monthlyselary;
    }

    @Override
    public double calculatesalary() {
        return monthlyselary;
    }
}
    class parttimeemployee extends employee {
        private int hourworked;
        double hourlyrate;

        public parttimeemployee(String name, int id, double hourlyrate, int hourworked) {
            super(name, id);
            this.hourlyrate = hourlyrate;
            this.hourworked = hourworked;

        }

        @Override
        public double calculatesalary() {
            return hourlyrate * hourworked;
        }
    }
        class payrolesystem{
            private ArrayList<employee> employeeArrayList;
            public payrolesystem(){
                employeeArrayList=new ArrayList<>();
            }
            public void addEmployee(employee emp){
                employeeArrayList.add(emp);

            }
            public void removeemployee(int id) {
                employee employeeremove = null;
                for (employee emp : employeeArrayList) {
                    if (emp.getId() == id) {
                        employeeremove = emp;
                        break;
                    }
                }
                if (employeeremove != null) {
                    employeeArrayList.remove(employeeremove);
                }
            }
                public void displayemployee(){
                    for(employee emp:employeeArrayList){
                        System.out.println(emp);
                    }
                }
            }
public class Main {
    public static void main(String args[]) {
        payrolesystem payrolsystem = new payrolesystem();
        fulltimeemployee emp1 = new fulltimeemployee("Ankit", 1, 20000);
        parttimeemployee emp2 = new parttimeemployee("aru", 2, 50, 20);
        payrolsystem.addEmployee(emp1);
        payrolsystem.addEmployee(emp2);
        System.out.println("initial employee details");
        payrolsystem.displayemployee();
        System.out.println("remove employee");
        payrolsystem.removeemployee(2);
        System.out.println("employee details");
        payrolsystem.displayemployee();
    }
}
