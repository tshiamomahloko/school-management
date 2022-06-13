package SMS.schoolmanagementsystem.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Slf4j
@Entity(name = "Module")
@Table(name = "Module")
public class CourseModule extends SchoolComponent {

    private String name;
    @Column(length = 1024)
    private String description;

    private int credits;

    public CourseModule(String name, String description, int credits) {
        this.name = name;
        this.description = description;
        this.credits = credits;
    }

    @Override
    public void displayInfo() {
        System.out.println("\tModule: " + getName() + " (" + getCredits() + "Credits)\n\t\t" + getDescription());
    }
}
