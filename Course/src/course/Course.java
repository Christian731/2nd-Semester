package course;

/**
 * Create a course class
 *
 * @author Christian Pauld David
 */
public class Course {

    private String name;
    private String number;
    private String section;
    private String semester;
    private int year;
    private String teacher;
    private String room;

    /**
     * constructor with all of the data members
     *
     * @param name name of the course
     * @param number number of the course
     * @param section section of the course
     * @param semester semester for the course
     * @param year what year is the course given
     * @param teacher who is the teacher for the course
     * @param room what room is for the course
     */
    public Course(String name, String number, String section, String semester,
            int year, String teacher, String room) {
        this.name = name;
        this.number = number;
        this.section = section;
        this.semester = semester;
        this.year = year;
        this.teacher = teacher;
        this.room = room;
    }

    /**
     * Copy constructor
     *
     * @param anotherCourse the object to be duplicate
     */
    public Course(Course anotherCourse) {
        this.name = anotherCourse.name;
        this.number = anotherCourse.number;
        this.section = anotherCourse.section;
        this.semester = anotherCourse.semester;
        this.year = anotherCourse.year;
        this.teacher = anotherCourse.teacher;
        this.room = anotherCourse.room;
    }

    /**
     * getter for name
     *
     * @return the name of the course
     */
    public String getName() {
        return name;
    }

    /**
     * setter for the name
     *
     * @param name sets the name of the course
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter for number
     *
     * @return the number of the course
     */
    public String getNumber() {
        return number;
    }

    /**
     * setter for number
     *
     * @param number set the number for the course
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * getter for section
     *
     * @return returns the section for the course
     */
    public String getSection() {
        return section;
    }

    /**
     * setter for section
     *
     * @param section sets the section for the course
     */
    public void setSection(String section) {
        this.section = section;
    }

    /**
     * getter for semester
     *
     * @return the semester for the course
     */
    public String getSemester() {
        return semester;
    }

    /**
     * setter for semester
     *
     * @param semester sets the semester of the course
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    /**
     * getter for the year
     *
     * @return returns the year of the course
     */
    public int getYear() {
        return year;
    }

    /**
     * setter for the year
     *
     * @param year returns the year of the course
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * getter for teacher
     *
     * @return returns the teacher of the course
     */
    public String getTeacher() {
        return teacher;
    }

    /**
     * setter for teacher
     *
     * @param teacher sets the teacher for the course
     */
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    /**
     * getter for room
     *
     * @return the room of the course
     */
    public String getRoom() {
        return room;
    }

    /**
     * setter for room
     *
     * @param room sets the room for the course
     */
    public void setRoom(String room) {
        this.room = room;
    }

    /**
     * compare two courses and see if they are the same
     *
     * @param anotherCourse the course that is gonna get compared
     * @return whether they are the same or not
     */
    public boolean isEqual(Course anotherCourse) {
        return this.name.equals(anotherCourse.name)
                && this.number.equals(anotherCourse.number)
                && this.section.equals(anotherCourse.section)
                && this.semester.equals(anotherCourse.semester)
                && this.year == anotherCourse.year
                && this.teacher.equals(anotherCourse.teacher)
                && this.room.equals(anotherCourse.room);
    }

    /**
     * to string for course class
     *
     * @return a string for the data values
     */
    @Override
    public String toString() {
        String strOut = "";

        strOut += String.format("Course Information\n");
        strOut += String.format("-----------------------\n");
        strOut += String.format("%s: %-15s\n", "Title", name);
        strOut += String.format("%s: %-15s\n", "Number", number);
        strOut += String.format("%s: %-15s\n", "Section", section);
        strOut += String.format("%s: %-15s\n", "Semester", semester);
        strOut += String.format("%s: %-15d\n", "Year", year);
        strOut += String.format("%s: %-15s\n", "Teacher", teacher);
        strOut += String.format("%s: %-15s\n", "Room", room);

        return strOut;
    }

}
