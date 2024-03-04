import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * A MajorList class (Singeton Design Pattern)
 * Provides method to access and modify majors in the list
 */
public class MajorList {
    private static MajorList majors;
    private ArrayList<Major> majorList;

    /**
     * Creates a new MajorList instance
     */
    private MajorList() {
        majorList = DataLoader.getMajors();
    }

    /**
     * Gets an instance of the MajorList
     * 
     * @return | MajorList instance
     */
    public static MajorList getInstance() {
        if (majors == null) {
            majors = new MajorList();
        }
        return majors;
    }

    /**
     * Validates whether the major exists
     * 
     * @param majorName | the major's name to search
     * @return | true or false depending on if it exists
     */
    public boolean haveMajor(String majorName) {
        for (Major major : majorList) {
            if (major.getMajorName().equals(majorName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get a Major by the major's name
     * 
     * @param courseID | the major's name to search
     * @return | the Major object with given name
     */
    public Major getMajor(String majorName) {
        for (Major major : majorList) {
            if (major.getMajorName().equals(majorName)) {
                return major;
            }
        }
        return null;
    }

    /**
     * Get all majors
     * 
     * @return | list of all majors
     */
    public ArrayList<Major> getMajors() {
        return majorList;
    }

    /**
     * Add a Major to the list
     * 
     * @param majorName       | the major's name
     * @param requiredCourses | the major's required courses
     * @param hoursNeeded     | the major's required hours
     * @return
     */
    public boolean addMajor(String majorName, ArrayList<String> requiredCourses,
            HashMap<ElectiveType, Electives> electives, ApplicationArea applicationArea, int creditsRequired) {
        if (haveMajor(majorName))
            return false;
        majorList.add(new Major((UUID.randomUUID()).toString(), majorName, requiredCourses, electives, applicationArea,
                creditsRequired));
        return true;
    }

    /**
     * Save the majors in the list to the data file
     */
    public void saveMajors() {
        DataWriter.saveMajors();
    }
}
