package course;

/**
 * Create a class for student
 *
 * @author Christian Paul David
 */
public class Student {

    private String name;
    private int id;

    /**
     * default constructor
     *
     * @param name name of the student
     * @param id id of the student
     */
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    /**
     * Copy constructor for student
     *
     * @param anotherStudent another student object
     */
    public Student(Student anotherStudent) {
        this.name = anotherStudent.name;
        this.id = anotherStudent.id;
    }

    /**
     * getter for student name
     *
     * @return the student name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for student name
     *
     * @param name name of the student
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter for student id
     *
     * @return the student id
     */
    public int getId() {
        return id;
    }

    /**
     * setter for student id
     *
     * @param id sets the student id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * compare two student and see if they are the same or not
     *
     * @param anotherStudent the student to be compared to
     * @return whether the two students are the same
     */
    public boolean isEquals(Student anotherStudent) {
        return this.name.equals(anotherStudent.name)
                && this.id == anotherStudent.id;
    }

    /**
     * To string for student class
     *
     * @return a string of student and id
     */
    @Override
    public String toString() {
        String strOut = "";

        strOut += String.format("%-12d", id);
        strOut += String.format("%-20s", name);

        return strOut;
    }

}
