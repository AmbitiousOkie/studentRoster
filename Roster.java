package wgu.c169;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.InputMismatchException;
import java.lang.IndexOutOfBoundsException;


/**
 * @author Kristopher Wall WGU - C169 - VGT Task 1
 */
public class Roster {

    // Creates a scanner called in 
    Scanner in = new Scanner(System.in);
    int indexToRemove = -1;

    /**
     *  WGU - VGT Task 1 - A
     *  Add personal information as the last item of the students array
     */
    String[] students = {"1,John,Smith,John1989@gmail.com,20,88,79,59",
        "2,Suzan,Erickson,Erickson_1990@gmailcom,19,91,72,85",
        "3,Jack,Napoli,The_lawyer99yahoo.com,19,85,84,87",
        "4,Erin,Black,Erin.black@comcast.net,22,91,98,82",
        "5,Kristopher,Wall,kwall50@wgu.edu,30,100,98,99"};

    List<Student> studentArrayList = new ArrayList<Student>();

    /**
     * Roster() method
     * Instantiates the roster object
     * Instantiates the students
     * Creates a loop to remove students once selection is finished
     * Catches errors thrown by the menus
     */
    public Roster() {
        convertArrayList(students);
        System.out.println("Roster loaded.");
        
        int count = 0;
        while (count < 5){
            try {
                mainMenu();
                count = 5;
            } catch (InputMismatchException e){
                String errorSelect = "";
                if (count < 4) {
                    System.out.println(e.getMessage());
                    System.out.printf("\n\nNot found.\nContinue? (Y/N): ");
                    errorSelect = in.next();
                }
                if (errorSelect.equals("y") || errorSelect.equals("Y")){
                    count++;
                } else {
                    count = 5;
                    System.out.println("Exiting." + errorSelect);
                }
                
                if (count == 5) {
                    System.out.printf("\n\nClosing.\n");
                }
            } catch (IndexOutOfBoundsException e){
                String errorSelect = "";
                if (count < 4) {
                    System.out.println(e.getMessage());
                    System.out.printf("\n\nNot found.\nContinue? (Y/N): ");
                    errorSelect = in.next();
                }
                if (errorSelect.equals("y") || errorSelect.equals("Y")){
                    count++;
                } else {
                    count = 5;
                    System.out.println("Exiting." + errorSelect);
                }
                
                if (count == 5) {
                    System.out.printf("\n\nClosing.\n");
                }
            }
        }
        
        
    }

    /**
     * Instantiates the roster class
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        new Roster();
    }

    /**
     * WGU - VGT Task 1 - B3a (add() method)
     * Adds a student with individual variables passed in
     * 
     * @param studentID student's ID
     * @param firstname student's first name
     * @param lastname student's last name
     * @param emailaddress student's email address
     * @param age student's age
     * @param grade1 student's 1st exam grade
     * @param grade2 student's 2nd exam grade
     * @param grade3 student's 3rd exam grade
     */
    public void add(int studentID, String firstname, String lastname, String emailaddress, int age, int grade1, int grade2, int grade3) {
        studentArrayList.add(new Student(studentID, firstname, lastname, emailaddress, age, grade1, grade2, grade3));
    }

    /**
     * WGU - VGT Task 1 - B3b (remove() method)
     * @param studentID ID of student to remove
     */
    public void remove(int studentID) {
        studentArrayList.remove(studentID);
    }

    /**
     * WGU - VGT Task 1 - B
     * Converts the students array into student objects
     * @param studentArray the initialized student array
     */
    public void convertArrayList(String[] studentArray) {

        for (String student : studentArray) {
            String[] studentAttributes = student.split(",");
            studentArrayList.add(new Student(studentAttributes));
        }
    }

    /**
     * WGU - VGT Task 1 - B3c (print_all() method)
     * @param studentArray Array of students to pass to the student print method
     */
    public static void print_all(List<Student> studentArray) {
        System.out.printf("\n\n%s  %-15s   %-16s    %-25s   %-3s    %-3s    %-3s    %-3s    %-5s\n", "ID", "First", "Last", "Email", "Age", "G1", "G2", "G3", "GPA");
        for (Student student : studentArray) {
            student.print();
        }
    }

    /**
     * WGU - VGT Task 1 - B3d (print_average_grade() method)
     * @param student the student object used to retrieve the GPA
     */
    public static void print_average_grade(Student student) {
        System.out.printf("ID: %-3d - GPA: %-3.2f",student.getStudentID(),student.getGPA());
    }
    
    /**
     * WGU - VGT Task 1 - B3e (print_invalid_emails() method)
     * Uses an regex matching utility built into the Java libraries
     */
    public void print_invalid_emails() {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        
        Pattern pattern = Pattern.compile(regex);
 
        System.out.printf("\n\nInvalid email addresses\n");
        for(Student student : studentArrayList){
            Matcher matcher = pattern.matcher(student.getEmailAddress());
            
            if (matcher.matches() == false) {
                System.out.println(student.getEmailAddress());
            }
        }
    }

    /**
     * Main menu
     * 
     * Allows the user to select the appropriate action
     * 
     * @throws InputMismatchException
     * @throws IndexOutOfBoundsException 
     */
    public void mainMenu() throws InputMismatchException, IndexOutOfBoundsException {

        int i = 0;
        while (i < 1) {

            if (indexToRemove >= 0) {
                System.out.println("Removing student ID: " + (indexToRemove + 1));
                remove(indexToRemove);
                indexToRemove = -1;
            }

            System.out.println();
            System.out.println("1) Print student roster");
            System.out.println("2) Print student");
            System.out.println("3) Add student");
            System.out.println("4) Remove student");
            System.out.println("5) Print student's GPA");
            System.out.println("6) Print invalid emails");
            System.out.println("0) Quit");
            System.out.print("Choose an option: ");

            int mainMenu1 = in.nextInt();
            switch (mainMenu1) {
                case 1:
                    print_all(studentArrayList);
                    break;
                case 2:
                    Student studentToPrint = studentArrayList.get(selectStudentMenu());
                    studentToPrint.print();
                    break;
                case 3:
                    addStudentMenu();
                    break;
                case 4:
                    indexToRemove = selectStudentMenu();
                    break;
                case 5:
                    Student gpaToPrint = studentArrayList.get(selectStudentMenu());
                    print_average_grade(gpaToPrint);
                    break;
                case 6:
                    print_invalid_emails();
                    break;
                case 0:
                    i++; // Exits loop
                    break;
                default:
                    i = 0; // Repeats loop
                    break;
            }
        }

    }

    /**
     * Student Selection Menu
     * 
     * Returns the selected student for further processing
     * 
     * @return the selected student object
     */
    public int selectStudentMenu() {
        System.out.println();
        System.out.printf("Enter a student ID: ");
        int selectStudentMenu1 = in.nextInt();
        int count;

        for (count = 0; count < studentArrayList.size(); count++) {
            Student student = studentArrayList.get(count);
            if (student.getStudentID() == selectStudentMenu1) {
                System.out.printf("Selected %s %s\n\n", student.getFirstName(), student.getLastName());
                break;
            } 
            
            if (count == studentArrayList.size() && student.getStudentID() != selectStudentMenu1) {
                throw new InputMismatchException("Not found.");
            }
            
        }
        
        return count;
    }
    
    /**
     * Add Student Menu
     * Creates a new student by collecting the attributes and calling the 
     * add() method to add the student
     */
    public void addStudentMenu(){
        int count = 0;
        for (Student student : studentArrayList) {
            count++;
        }
        
        int ID = count + 1;
        
        System.out.print("Enter the student's first name: ");
        String firstName = in.next();
        
        System.out.print("Enter the student's last name: ");
        String lastName = in.next();
        
        System.out.print("Enter the student's email address: ");
        String email = in.next();
        
        System.out.print("Enter the student's age: ");
        int age = in.nextInt();
        
        System.out.print("Enter the student's 1st grade: ");
        int g1 = in.nextInt();
        
        System.out.print("Enter the student's 2nd grade: ");
        int g2 = in.nextInt();
        
        System.out.print("Enter the student's 3rd grade: ");
        int g3 = in.nextInt();
        
        add(ID, firstName, lastName, email, age, g1, g2, g3);
    }

}
