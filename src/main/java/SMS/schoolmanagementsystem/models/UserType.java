package SMS.schoolmanagementsystem.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "UserTypeID")
    private int userTypeId;

    @Column(name = "UserTypeName")
    private String userTypeName;
}
