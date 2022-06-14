package SMS.schoolmanagementsystem.models.dto;

import SMS.schoolmanagementsystem.models.Module;
import SMS.schoolmanagementsystem.models.Users;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
public class EnrolmentDto {
    private String term;
    private int userId;
    private int moduleId;


}
