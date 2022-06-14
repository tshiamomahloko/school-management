package SMS.schoolmanagementsystem.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Data
public class Grade {

    @EmbeddedId
    private GradeId gradeId;

    @Column(name = "GradeObtained")
    private float gradeObtained;

}
