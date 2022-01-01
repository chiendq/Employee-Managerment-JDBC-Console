package fa.training.problem02.main;

import fa.training.problem02.entities.Department;
import fa.training.problem02.entities.Employee;
import fa.training.problem02.service.IDepartmentService;
import fa.training.problem02.service.IEmployeeService;
import fa.training.problem02.service.impl.DepartmentServiceImpl;
import fa.training.problem02.service.impl.EmployeeServiceImpl;

import java.sql.Date;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while (true){
            menu();
            System.out.print("Your option: ");
            try{
                int option = Integer.parseInt(sc.nextLine());
                switch (option) {
                    case 1 -> employeeManager();
                    case 2 -> departmentManagement();
                    case 3 -> {
                        System.out.println("Bye!");
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid option!");
                }
            }catch (NumberFormatException e){
                System.out.println("Invalid option!");
            }
        }
    }

    private static void employeeManager(){
        while (true){
            System.out.println(
                    """
                            1. Add a new Employee
                            2. Update a specific Employee
                            3. Find an employee by emp_no
                            4. Add the working history
                            5. Find all the employees by working period of time
                            6. RETURN""");
            try {
                System.out.print("Your option:");
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice){
                    case 1:
                        addEmployee();
                        break;
                    case 2:
                        updateEmployee();
                        break;
                    case 3:
                        findByID();
                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    case 6:
                        return;
                    default:
                        System.err.println("Invalid option");
                }
            }catch (Exception e){
                System.err.println("Invalid option");
            }
        }
    }

    private static void addEmployee(){
        System.out.print("Enter employee no: ");
        int empNo = Integer.parseInt(sc.nextLine());
        System.out.print("Enter birth date (YYYY-MM-DD) : ");
        String birthDate = sc.nextLine();
        System.out.print("Enter first name: ");
        String firstName = sc.nextLine();
        System.out.print("Enter last name: ");
        String lastName = sc.nextLine();
        System.out.print("Enter gender: ");
        String gender = sc.nextLine();
        System.out.print("Enter hire date (YYYY-MM-DD) : ");
        String hireDate = sc.nextLine();

        IEmployeeService employeeService = new EmployeeServiceImpl();
        Employee employee = new Employee(empNo, Date.valueOf(birthDate), firstName, lastName,gender, Date.valueOf(hireDate));
        employeeService.save(employee);
    }

    private static void updateEmployee(){
        System.out.print("Enter employee no: ");
        int empNo = Integer.parseInt(sc.nextLine());
        System.out.print("Enter birth date (YYYY-MM-DD) : ");
        String birthDate = sc.nextLine();
        System.out.print("Enter first name: ");
        String firstName = sc.nextLine();
        System.out.print("Enter last name: ");
        String lastName = sc.nextLine();
        System.out.print("Enter gender: ");
        String gender = sc.nextLine();
        System.out.print("Enter hire date (YYYY-MM-DD) : ");
        String hireDate = sc.nextLine();
        IEmployeeService employeeService = new EmployeeServiceImpl();
        Employee employeeUpdate = new Employee(empNo, Date.valueOf(birthDate), firstName, lastName,gender, Date.valueOf(hireDate));
        employeeService.update(employeeUpdate);
    }
    private static void findByID() {
        System.out.print("Enter employee no: ");
        int emp_no = Integer.parseInt(sc.nextLine());
        IEmployeeService employeeService = new EmployeeServiceImpl();
        Employee employee = (Employee) employeeService.findById(emp_no);
    }
    private static void departmentManagement(){
        while (true){
            try {
                System.out.println("1. Add a new department\n2. RETURN");
                System.out.print("Your option: ");
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice){
                    case 1:
                        addDepartment();
                        break;
                    case 2:
                        return;
                    default:
                        System.err.println("Invalid option");
                }
            }catch (Exception e){
                System.err.println("Invalid option");
            }
        }
    }

    private static void addDepartment(){
        System.out.print("Enter department no: ");
        int deptNo = Integer.parseInt(sc.nextLine());
        System.out.print("Enter department name: ");
        String deptName =  sc.nextLine();
        System.out.print("Enter from date: ");
        String description = sc.nextLine();
        Department department = new Department(deptNo, deptName, description);
        IDepartmentService departmentService = new DepartmentServiceImpl();
        departmentService.save(department);
    }

    private static void menu(){
        System.out.println(
            "1. Employee management\n" +
            "\ta. Add a new Employee\n" +
            "\tb. Update a specific Employee\n" +
            "\tc. Find an employee by emp_no\n" +
            "\td. Add the working history\n" +
            "\te. Find all the employees by working period of time\n" +
            "2. Department management\n" +
            "\ta. Add a new department\n" +
            "3. Close program"
        );
    }

}
