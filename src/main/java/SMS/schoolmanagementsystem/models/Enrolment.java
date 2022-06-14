package SMS.schoolmanagementsystem.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Enrolment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EnrolmentID")
    private int enrolmentId;

    @ManyToOne
    @JoinColumn(name = "UserID")
    private Users userId;

    @ManyToOne
    @JoinColumn(name = "ModuleID")
    private Module moduleId;

    @Column(name = "Term")
    private String term;
    
}
