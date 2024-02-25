import java.util.ArrayList;

public class MajorList {
    private static MajorList majors;
    private ArrayList<Major> majorList;

    private MajorList() {

    }

    public static MajorList getInstance() {
        return null;
    }

    public boolean haveMajor() {
        return false;
    }

    public User getMajor() {
        return null;
    }

    public ArrayList<Major> getMajors() {
        return majorList;
    }

    public boolean addMajor() {
        return true;
    }

    public void saveMajors() {

    }
}
