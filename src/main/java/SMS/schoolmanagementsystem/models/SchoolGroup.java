package SMS.schoolmanagementsystem.models;

import SMS.schoolmanagementsystem.repositories.SchoolGroupRepository;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "SchoolGroup")
public class SchoolGroup extends SchoolComponent {

    @ElementCollection
    @OneToMany(mappedBy = "schoolGroup", cascade = CascadeType.ALL)
    private Set<SchoolComponent> groupComponents = new HashSet<>();

    private String groupName;
    private String groupDescription;

    public SchoolGroup(String groupName, String groupDescription) {
        this.groupName = groupName;
        this.groupDescription = groupDescription;
    }

    @Override
    public String getName() {
        return groupName.toUpperCase(Locale.ROOT) + "(" + getGroupDescription() + ")";
    }

    @Override
    public void add(SchoolComponent schoolComponent) {
        groupComponents.add(schoolComponent);
        schoolComponent.setSchoolGroup(this);
    }

    @Override
    public void delete(SchoolComponent schoolComponent) {
        groupComponents.remove(schoolComponent);
    }

    @Override
    public void displayInfo() {
        System.out.println(getName());

        for (SchoolComponent schoolComponent: groupComponents) {
            schoolComponent.displayInfo();
        }
    }
}
