package SMS.schoolmanagementsystem.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Grade {

    @EmbeddedId
    private GradeId gradeId;

    @Column(name = "GradeObtained")
    private float gradeObtained;

}
