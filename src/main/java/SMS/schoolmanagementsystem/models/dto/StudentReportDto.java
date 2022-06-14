package SMS.schoolmanagementsystem.models.dto;

import SMS.schoolmanagementsystem.models.Enrolment;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

@Getter
@Setter
public class StudentReportDto {


    private String name;
    private String surname;
    private String email;
    private HashMap<String, List<HashMap>> courses;

    public StudentReportDto(String name, String surname, String email, HashMap<String, List<HashMap>> courses) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.courses = courses;
    }
}
