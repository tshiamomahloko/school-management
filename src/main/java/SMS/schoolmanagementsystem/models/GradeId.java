package SMS.schoolmanagementsystem.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class GradeId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "EnrolmentID")
    private Enrolment enrolmentId;

    @ManyToOne
    @JoinColumn(name = "AssessmentID")
    private Assessment assessmentId;

    public GradeId() {
    }

    public GradeId(Enrolment enrolmentId, Assessment assessmentId) {
        this.enrolmentId = enrolmentId;
        this.assessmentId = assessmentId;
    }

}
