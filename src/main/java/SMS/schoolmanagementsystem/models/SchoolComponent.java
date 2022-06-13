package SMS.schoolmanagementsystem.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public abstract class SchoolComponent {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "school_component_sequence")
    @SequenceGenerator(name = "school_component_sequence", sequenceName = "school_component_sequence", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "school_group_id")
    private SchoolComponent schoolGroup;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SchoolComponent getSchoolGroup() {
        return schoolGroup;
    }

    public void setSchoolGroup(SchoolGroup schoolGroup) {
        this.schoolGroup = schoolGroup;
    }

    public void add(SchoolComponent schoolComponent) {
        throw new UnsupportedOperationException();
    }

    public void edit(SchoolComponent schoolComponent) {
        throw new UnsupportedOperationException();
    }

    public void delete(SchoolComponent schoolComponent) {
        throw new UnsupportedOperationException();
    }

    public SchoolComponent search(SchoolComponent schoolComponent) {
        throw new UnsupportedOperationException();
    }

    public SchoolComponent getComponent(int componentIndex) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public void displayInfo() {
        throw new UnsupportedOperationException();
    }
}
