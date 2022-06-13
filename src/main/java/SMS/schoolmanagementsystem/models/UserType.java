package SMS.schoolmanagementsystem.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "UserTypeID")
    private int userTypeId;

    @Column(name = "UserTypeName")
    private String userTypeName;
}
