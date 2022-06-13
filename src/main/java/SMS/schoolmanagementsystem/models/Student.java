package SMS.schoolmanagementsystem.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Locale;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "Student")
@Table(name = "Student")
public class Student extends SchoolComponent {

    private String firstName;
    private String middleName;
    private String lastName;
    private String email;

    @OneToOne(targetEntity = SchoolGroup.class)
    private SchoolComponent course;

    public Student(String firstName, String middleName, String lastName, String email, SchoolComponent course) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.course = course;
    }

    @Override
    public void add(SchoolComponent module) {
        course.add(module);
    }

    @Override
    public void delete(SchoolComponent module) {
        course.delete(module);
    }

    @Override
    public SchoolComponent getComponent(int componentIndex) {
        return course.getComponent(componentIndex);
    }

    @Override
    public String getName() {
        return getFirstName().toUpperCase(Locale.ROOT).charAt(0) + "." +
                getMiddleName().toUpperCase(Locale.ROOT).charAt(0) + " " +
                getLastName();
    }

    @Override
    public void displayInfo() {
        System.out.println(getName() + "\n\tCourse:" + course.getName() + "\n\tModules:");

        SchoolGroup courses = (SchoolGroup) course;
        for (SchoolComponent module : courses.getGroupComponents()) {
            module.displayInfo();
        }
    }
}
