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
@Entity(name = "Lecturer")
@Table(name = "Lecturer")
public class Lecturer extends SchoolComponent {

    private String firstName;
    private String middleName;
    private String lastName;
    private String email;

    @OneToOne(targetEntity = SchoolGroup.class)
    private SchoolComponent courses;

    public Lecturer(String firstName, String middleName, String lastName, String email, SchoolComponent courses) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.courses = courses;
    }

    @Override
    public void add(SchoolComponent course) {
        courses.add(course);
    }

    @Override
    public void delete(SchoolComponent course) {
        courses.delete(course);
    }

    @Override
    public SchoolComponent getComponent(int componentIndex) {
        return courses.getComponent(componentIndex);
    }

    @Override
    public String getName() {
        return getFirstName().toUpperCase(Locale.ROOT).charAt(0) + "." +
                getMiddleName().toUpperCase(Locale.ROOT).charAt(0) + " " +
                getLastName();
    }

    @Override
    public void displayInfo() {
        System.out.println();
    }
}
