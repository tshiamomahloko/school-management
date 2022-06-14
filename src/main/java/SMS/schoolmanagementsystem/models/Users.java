package SMS.schoolmanagementsystem.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@ToString
@Entity(name = "Users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private int userId;

    @Column(name = "Name", nullable = false, columnDefinition = "TEXT")
    private String name;

    @Column(name = "Surname", nullable = false, columnDefinition = "TEXT")
    private String surname;

    @Column(name = "Email", nullable = false, columnDefinition = "TEXT")
    private String emailAddress;

    @ManyToOne
    @JoinColumn(name = "UserTypeID")
    private  UserType userTypeId;

}

