package course;

/**
 * Create a class for student grade record
 * @author Christian Paul David
 */
public class StudentGradeRecord {

    private double[] grades;// = new double[8];
    private Student student;

    /**
     * Constructor for studentgraderecord that initializes it with students 
     * with their grades
     * @param student the student
     * @param grade the grades of the student
     */
    public StudentGradeRecord(Student student, double[] grade) {
        this.student = student;
        this.grades = grade;
    }

    /**
     * Computes and return the final grade of the student
     * @param assessmentWeights how much each assessments weigh
     * @return the final grade
     */
    public double computeFinalGrade(double[] assessmentWeights) {
        double finalGrade = 0;
        double assSum = 0;

        for (int i = 0; i < assessmentWeights.length; i++) {
            assSum += assessmentWeights[i];
        }

        for (int i = 0; i < assessmentWeights.length; i++) {
            finalGrade += (grades[i] * assessmentWeights[i]) / assSum;
        }
        return finalGrade;
    }

    /**
     * Getter for grade
     * @param k the index of the grade needed
     * @return the grade where the index is indicated
     */
    public double getGrade(int k) {
        if (k < 0 || k > grades.length) {
            throw new IllegalArgumentException();

        } else {
            return grades[k];

        }
    }

    /**
     * setter for grade
     * @param grade the grade in the index
     * @param k index of the grade
     */
    public void setGrade(int k, double grade) {
        if (k < 0 || k > this.grades.length) {
            throw new IllegalArgumentException();

        } else {
            this.grades[k] = grade;
        }
    }

    /**
     * getter for all the grades
     * @return an array of the grades
     */
    public double[] getAllGrades() {
        double[] newGradesList = new double[this.grades.length];

        for (int i = 0; i < this.grades.length; i++) {
            newGradesList[i] = this.grades[i];
        }
        return newGradesList;
    }

    /**
     * Sets all the grades
     * @param allGrades all the grade in the array
     */
    public void setAllGrades(double[] allGrades) {
        this.grades = allGrades;
    }

    /**
     * Getter for student
     * @return the student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Setter for the student
     * @param student the student
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * Gets the number of assessments
     * @return the number of assessments
     */
    public int getNumberOfAssessments() {
        return grades.length;
    }

    /**
     * Check whether the two objects are the same or not
     * @param obj the object to be compared
     * @return whether they are the same or not
     */
    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }

    /**
     * to string for StudentGradeRecord
     * @return a string for studentgraderecord
     */
    @Override
    public String toString() {
        String strOut = "";
        
        strOut += String.format("%-10s", student);
        for (int i = 0; i < grades.length; i++) {
            strOut += String.format("%-5d", grades);
        }
        
        
        return strOut;
    }

    /**
     * Computes the letter grade of the student
     * @param fin final grade of the student
     * @return the letter grade of the student
     */
    public static char computerLetterGrade(double fin) {
        if (fin >= 90) {
            return 'A';
        } else if (fin >= 80) {
            return 'B';
        } else if (fin >= 70) {
            return 'C';
        } else if (fin >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

}
