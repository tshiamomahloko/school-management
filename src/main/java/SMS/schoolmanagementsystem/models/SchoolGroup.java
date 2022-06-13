package SMS.schoolmanagementsystem.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "SchoolGroup")
public class SchoolGroup extends SchoolComponent {

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    private SchoolComponent schoolGroup;

    @OneToMany(mappedBy = "schoolGroup", cascade = CascadeType.ALL)
    @ToString.Exclude
    List<SchoolComponent> groupComponents = new ArrayList<>();

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
