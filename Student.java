package wgu.c169;

/**
 *
 * @author Kristopher Wall
 * WGU - C169
 * 
 * Welcome to the student class.  This class allows for the construction,
 * setting values, determining GPA, and printing of the student object.
 */
public class Student {
    /**
     * WGU - VGT Task 1 - B1
     * Create the student instance variables inside the student object
     */
    private int studentID, age, grade1, grade2, grade3;
    private String firstName, lastName, emailAddress;


    /**
     * WGU - VGT Task 1 - B2c (Constructor)
     * Constructs the student object from a passed array
     * 
     * @param student array of values passed into the student object
     */
    public Student(String [] student){
        setStudentID(Integer.parseInt(student[0]));
        setFirstName(student[1]);
        setLastName(student[2]);
        setEmailAddress(student[3]);
        setAge(Integer.parseInt(student[4]));
        setGrade1(Integer.parseInt(student[5]));
        setGrade2(Integer.parseInt(student[6]));
        setGrade3(Integer.parseInt(student[7]));
    }
    
    /**
     * WGU - VGT Task 1 - B2c (Constructor)
     * Constructs the student object from passed variables
     * @param ID sets the student's ID 
     * @param firstname sets the student's first name
     * @param lastname sets the student's last name
     * @param email sets the student's email address
     * @param studentAge sets the student's age
     * @param g1 sets the student's 1st exam grade
     * @param g2 sets the student's 2nd exam grade
     * @param g3 sets the student's 3rd exam grade
     */
    public Student(int ID, String firstname, String lastname, String email, int studentAge, int g1, int g2, int g3){
        setStudentID(ID);
        setFirstName(firstname);
        setLastName(lastname);
        setEmailAddress(email);
        setAge(studentAge);
        setGrade1(g1);
        setGrade2(g2);
        setGrade3(g3);
    }
    
    /**
     * WGU - VGT Task 1 - B2d (print() method)
     * Prints the student object to the console
     */
    public void print(){
        System.out.printf("%d  %-16s   %-16s    %-25s   %-3d    %-3d    %-3d    %-3d    %-4.2f\n",
                    this.getStudentID(),
                    this.getFirstName(),
                    this.getLastName(),
                    this.getEmailAddress(),
                    this.getAge(),
                    this.getGrade1(),
                    this.getGrade2(),
                    this.getGrade3(),
                    this.getGPA()
                    );
    }

    /** 
     * WGU - VGT Task 1 - B2a (Accessor)
     * @return the student's ID
     */
    public int getStudentID() {
        return studentID;
    }
    
    /**
     * WGU - VGT Task 1 - B2b (Mutator)
     * @param studentID sets the student's ID
     */
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    /**
     * WGU - VGT Task 1 - B2a (Accessor)
     * @return the student's age
     */
    public int getAge() {
        return age;
    }

    /**
     * WGU - VGT Task 1 - B2b (Mutator)
     * @param age sets the student's age
     */
    public void setAge(int age) {
        this.age = age;
    }
    
    /**
     * WGU - VGT Task 1 - B2a (Accessor)
     * @return the student's 1st exam grade
     */
    public int getGrade1() {
        return grade1;
    }

    /**
     * WGU - VGT Task 1 - B2b (Mutator)
     * @param grade1 sets the student's 1st exam grade
     */
    public void setGrade1(int grade1) {
        this.grade1 = grade1;
    }

    /**
     * WGU - VGT Task 1 - B2a (Accessor)
     * @return the student's 2nd exam grade
     */
    public int getGrade2() {
        return grade2;
    }

    /**
     * WGU - VGT Task 1 - B2b (Mutator)
     * @param grade2 sets the student's 2st exam grade
     */
    public void setGrade2(int grade2) {
        this.grade2 = grade2;
    }

    /**
     * WGU - VGT Task 1 - B2a (Accessor)
     * @return the student's 3rd exam grade
     */
    public int getGrade3() {
        return grade3;
    }

    /**
     * WGU - VGT Task 1 - B2b (Mutator)
     * @param grade3 sets the student's 3rd exam grade
     */
    public void setGrade3(int grade3) {
        this.grade3 = grade3;
    }

    /**
     * WGU - VGT Task 1 - B2a (Accessor)
     * @return the student's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * WGU - VGT Task 1 - B2b (Mutator)
     * @param firstName sets the student's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * WGU - VGT Task 1 - B2a (Accessor)
     * @return the student's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * WGU - VGT Task 1 - B2b (Mutator)
     * @param lastName sets the student's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * WGU - VGT Task 1 - B2a (Accessor)
     * @return the student's email address
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * WGU - VGT Task 1 - B2b (Mutator)
     * @param emailaddress sets the student's email address
     */
    public void setEmailAddress(String emailaddress) {
        this.emailAddress = emailaddress;
    }
    
    /**
     * @return the student's GPA
     */
    public double getGPA(){
        double gpa = (grade1 + grade2 + grade3) / 3.00;
        return gpa;
    }
    
    
}
