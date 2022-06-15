package SMS.schoolmanagementsystem.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
<<<<<<< HEAD
@ToString
=======
@Getter
@ToString
@Entity(name = "Users")
>>>>>>> ff2bd92427e256152321373e92c0181857827e7d
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

    @OneToOne
    @JoinColumn(name = "UserTypeID")
    private  UserType userTypeId;

}

