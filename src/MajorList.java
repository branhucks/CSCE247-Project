import java.util.ArrayList;

public class MajorList {
    private static MajorList majors;
    private ArrayList<Major> majorList;

    private MajorList() {
        majorList = DataLoader.getMajors();
    }

    public static MajorList getInstance() {
        if (majors == null) {
            majors = new MajorList();
        }
        return majors;
    }

    public boolean haveMajor(String majorName) {
        for (Major major : majorList) {
            if (major.getMajorName().equals(majorName)) {
                return true;
            }
        }
        return false;
    }

    public Major getMajor(String majorName) {
        for (Major major : majorList) {
            if (major.getMajorName().equals(majorName)) {
                return major;
            }
        }
        return null;
    }

    public ArrayList<Major> getMajors() {
        return majorList;
    }

    public boolean addMajor(String majorName, ArrayList<Course> requiredCourses, int hoursNeeded) {
        if (haveMajor(majorName))
            return false;
        majorList.add(new Major(majorName, requiredCourses, hoursNeeded));
        return true;
    }

    public void saveMajors() {
        DataWriter.saveMajors();
    }
}
