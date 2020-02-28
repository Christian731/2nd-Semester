package course;

import java.util.Arrays;

/**
 * Create a class for coursegradebook
 * 
 * @author Christian Paul David
 */
public class CourseGradeBook {

    private String[] caNames;
    private double[] caWeights;
    private Course course;
    private StudentGradeRecord[] gradeList;
    private int gradesRecordCount;

    /**
     * Constructor that initialized canames, caweight and course
     *
     * @param caNames name of assessments
     * @param caWeights weight of assessments
     * @param course the course
     */
    public CourseGradeBook(Course course, String[] caNames, double[] caWeights) {
        if (caNames.length != caWeights.length) {
            throw new IllegalArgumentException();
        } else {
            this.caNames = caNames;
            this.caWeights = caWeights;
            this.course = course;
            gradesRecordCount = 0;
            gradeList = new StudentGradeRecord[1];
        }
    }

    /**
     * Checks whether the array is full or not
     *
     * @return whether the array is full or not
     */
    public boolean isFull() {
        return gradesRecordCount == gradeList.length;
    }

    /**
     * Adds a student record with the name and the grades and doubles the array
     * if needed
     *
     * @param student the student
     * @param grade grades of the student
     */
    public void addGradeRecord(Student student, double... grade) {
        if (isFull()) {
            doubleGradeListCapacity();
        }
        gradeList[gradesRecordCount] = new StudentGradeRecord(student, grade);
        gradesRecordCount++;
    }

    /**
     * doubles the capacity of the array fro grades
     */
    public void doubleGradeListCapacity() {
        StudentGradeRecord[] newGradeList
                = new StudentGradeRecord[gradeList.length * 2];
        for (int i = 0; i < gradesRecordCount; i++) {
            newGradeList[i] = gradeList[i];
        }
        gradeList = newGradeList;
    }

    /**
     * Computes the sum of the array
     *
     * @param numbers the array of numbers
     * @return the sum of the array
     */
    public static double findArraySum(double[] numbers) {
        int num = 0;
        for (int i = 0; i < numbers.length; i++) {
            num += numbers[i];
        }
        return num;
    }

    /**
     * Checks the array for the maximum
     *
     * @param numbers the array of numbers
     * @return the maximum number in the array
     */
    public static double findArrayMaximum(double[] numbers) {
        double max = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    /**
     * Checks the array for the minimum
     *
     * @param numbers the array of numbers
     * @return the minimum number in the array
     */
    public static double findArrayMinimum(double[] numbers) {
        double min = numbers[0];

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }

    /**
     * computes the array for the average
     *
     * @param numbers the array of numbers
     * @return the average of grades in the array
     */
    public static double findArrayAverage(double[] numbers) {
        double avg = 0;
        for (int i = 0; i < numbers.length; i++) {
            avg += numbers[i];
        }
        return avg /= numbers.length;
    }

    /**
     * computes the standard deviation of the array
     * @param numbers the array of numbers
     * @return the standard deviation of the array
     */
    public double findArrayStandardDeviation(double[] numbers) {
        double standardDev;
        double sum = 0;
        double avg = findArrayAverage(numbers);

        for (double numbers1 : numbers) {
            sum += Math.pow(numbers1 - avg, 2);
        }

        standardDev = Math.sqrt(sum / numbers.length);
        return standardDev;
    }

    /**
     * gets the final grades of all students.
     *
     * @return An array of all students final grades.
     */
    private double[] getFinalsArray() {
        double[] tempFinalArray = new double[gradesRecordCount];
        for (int count = 0; count < gradesRecordCount; count++) {
            tempFinalArray[count] = gradeList[count].computeFinalGrade(caWeights);
        }
        return tempFinalArray;
    }

    /**
     * Computes the total weight of the courses
     * @return the sum of the weight of course
     */
    public double computeTotalWeight() {
        double sum = 0;
        for (int i = 0; i < caWeights.length; i++) {
            sum += caWeights[i];
        }
        return sum;
    }

    /**
     * Determines the largest grade of all the k'th assessments.
     *
     * @param k The assessment index.
     * @return The largest k'th assessment garde.
     */
    private double findMaxAssessment(int k) {
        if (k < 0 || k >= this.caNames.length) {
            throw new IllegalArgumentException("findMaxAssessment: bad "
                    + "assessment index " + k);
        }

        double[] temp = getAssessmentArray(k);
        double max = findArrayMaximum(temp);
        return max;

    }

    /**
     * searches for the minimum of the array
     *
     * @param k The assessment index.
     * @return the minimum of the array
     */
    private double findMinAssessment(int k) {
        if (k < 0 || k >= this.caNames.length) {
            throw new IllegalArgumentException("findMaxAssessment: bad "
                    + "assessment index " + k);
        }

        double[] temp = getAssessmentArray(k);
        double min = findArrayMinimum(temp);
        return min;
    }

    /**
     * computes the average of the grades
     *
     * @param k The assessment index.
     * @return the average of the grades
     */
    private double findAvgAssessment(int k) {
        if (k < 0 || k >= this.caNames.length) {
            throw new IllegalArgumentException("findMaxAssessment: bad "
                    + "assessment index " + k);
        }

        double[] temp = getAssessmentArray(k);
        double avg = findArrayAverage(temp);
        return avg;
    }

    /**
     * Computes the standard deviation of all grades in the assessments.
     *
     * @param k The assessment index.
     * @return The standard deviation assessment grade.
     */
    private double findStdevAssessment(int k) {
        if (k < 0 || k >= this.caNames.length) {
            throw new IllegalArgumentException("findMaxAssessment: bad "
                    + "assessment index " + k);
        }

        double[] temp = getAssessmentArray(k);
        double stDev = findArrayStandardDeviation(temp);
        return stDev;
    }

    /**
     * returns an array of all the k'th assessment gardes of all students
     * @param k the index of the assessment
     * @return the array of all the k'th assessments of all students
     */
    private double[] getAssessmentArray(int k) {
        if (k < 0 || k >= this.caNames.length) {
            throw new IllegalArgumentException("getAssessmentArray: bad "
                    + "assessment index " + k);
        }

        double[] tempArray = new double[this.gradesRecordCount];
        for (int count = 0; count < gradesRecordCount; count++) {
            tempArray[count] = gradeList[count].getGrade(k);
        }
        return tempArray;
    }

    /**
     * to string for maximum for assessments
     * @return a string for the maximum of the assessments
     */
    public String toStringMaxAssessments() {
        String strOut = "";
        strOut += String.format("%32s", "Max:     ");

        for (int i = 0; i < caNames.length; i++) {
            strOut += String.format("%-5.0f", findMaxAssessment(i));
        }

        double[] finalsArray = getFinalsArray();
        strOut += String.format("%-5.0f", findArrayMaximum(finalsArray));

        strOut += String.format("%-5c", StudentGradeRecord.
                computerLetterGrade(findArrayMaximum(finalsArray)));

        return strOut;
    }

    /**
     * to string for minimum for assessments
     * @return a string for the minimum of the assessments
     */
    public String toStringMinAssessments() {
        String strOut = "";
        strOut += String.format("%32s", "Min:     ");

        for (int i = 0; i < caNames.length; i++) {
            strOut += String.format("%-5.0f", findMinAssessment(i));
        }

        double[] finalsArray = getFinalsArray();
        strOut += String.format("%-5.0f", findArrayMinimum(finalsArray));

        strOut += String.format("%-5c", StudentGradeRecord.computerLetterGrade(findArrayMinimum(finalsArray)));

        return strOut;
    }

    /**
     * to string for average assessments
     * @return the string of average assessments
     */
    public String toStringAvgAssessments() {
        String strOut = "";
        strOut += String.format("%32s", "Average:     ");

        for (int i = 0; i < caNames.length; i++) {
            strOut += String.format("%-5.0f", findAvgAssessment(i));
        }

        double[] finalsArray = getFinalsArray();
        strOut += String.format("%-5.0f", findArrayAverage(finalsArray));

        strOut += String.format("%-5c", StudentGradeRecord.computerLetterGrade(findArrayAverage(finalsArray)));

        return strOut;
    }

    /**
     * to string for standard deviation
     * @return string of standard deviation
     */
    public String toStringStDevAssessments() {
        String strOut = "";
        strOut += String.format("%32s", "Standard Deviation:     ");
        for (int i = 0; i < caNames.length; i++) {
            strOut += String.format("%-5.0f", findStdevAssessment(i));
        }

        double[] finalsArray = getFinalsArray();
        strOut += String.format("%-5.0f", findArrayStandardDeviation(finalsArray));

        return strOut;
    }

    /**
     * equals method
     * @param anotherCourseGradeBook the object to be compared
     * @return whether they are equal or not
     */
    public boolean equals(CourseGradeBook anotherCourseGradeBook) {
        return Arrays.equals(caNames, anotherCourseGradeBook.caNames)
                && Arrays.equals(caWeights, anotherCourseGradeBook.caWeights)
                && this.course == anotherCourseGradeBook.course
                && Arrays.equals(gradeList, anotherCourseGradeBook.gradeList)
                && gradesRecordCount == gradesRecordCount;
    }

    /**
     * To string for course gradebook
     * @return a string of the object
     */
    @Override
    public String toString() {
        String strOut = "";
        strOut += String.format("%55s\n", "Student Grade Table");
        strOut += "------------------------------------------------------------"
                + "---------------------\n";
        strOut += String.format("%-12s %-16s", "ID Number", "Student Name");
        for (int i = 0; i < caNames.length; i++) {
            strOut += String.format("%5s", "A" + (i + 1));
        }
        strOut += String.format("%5s %4s\n", "fin", "grd");
        strOut += "------------------------------------------------------------"
                + "---------------------\n";

        for (int i = 0; i < gradesRecordCount; i++) {
            strOut += String.format("%s", gradeList[i].getStudent().toString());
            for (int j = 0; j < caWeights.length; j++) {
                strOut += String.format("%-5.0f", gradeList[i].getGrade(j));
            }
            strOut += String.format("%-5.0f",
                    gradeList[i].computeFinalGrade(caWeights));
            strOut += StudentGradeRecord.computerLetterGrade(gradeList[i].
                    computeFinalGrade(caWeights));
            strOut += "\n";
        }
        strOut += "------------------------------------------------------------"
                + "---------------------";
        return strOut;
    }

    /**
     * To string for assessment legends
     * @return a string for assessment legends
     */
    public String toStringAssessmentLegend() {
        String strOut = "";

        strOut += "\n";
        strOut += "Legends\n";
        strOut += "---------------------------------------------------\n";
        strOut += String.format("%-15s %-10s %s/%-7.1f %s%%\n", "Assessment",
                "Name", "Weight", computeTotalWeight(), "Wieght");
        strOut += "---------------------------------------------------\n";

        for (int i = 0; i < caNames.length; i++) {
            strOut += String.format("%s%-15d", "A", i + 1);
            strOut += String.format("%-18s", caNames[i]);
            strOut += String.format("%-10.0f", caWeights[i]);
            strOut += String.format("%.1f%%\n", (caWeights[i]
                    / computeTotalWeight()) * 100);
        }

        strOut += "---------------------------------------------------\n";
        strOut += String.format("%-15s %s\n", "fin", "final grade");
        strOut += String.format("%-15s %s\n", "grd", "letter grade");

        return strOut;
    }

    /**
     * Copy constructor
     * @param cgb The new coursegradebook
     */
    public CourseGradeBook(CourseGradeBook cgb) {
        System.arraycopy(cgb.caNames, 0, caNames, 0, caNames.length);
        System.arraycopy(cgb.caWeights, 0, caWeights, 0, caWeights.length);
        System.arraycopy(cgb.gradeList, 0, gradeList, 0, gradeList.length);
        course = cgb.course;
    }
}
