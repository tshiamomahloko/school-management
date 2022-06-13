package SMS.schoolmanagementsystem.models;

public class UndergraduateCourses {

    SchoolComponent schoolComponent;

    public UndergraduateCourses(SchoolComponent schoolComponent) {
        this.schoolComponent = schoolComponent;
    }

    public void getSchoolComponentList() {
        schoolComponent.displayInfo();
    }
}
