package SMS.schoolmanagementsystem.mappers;


import SMS.schoolmanagementsystem.models.Grade;
import SMS.schoolmanagementsystem.models.dto.OverallStudentGradeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface GradesToOverallStudentGrade {

    @Mapping(target = "name", source = "grade.gradeId.enrolmentId.userId.name")
    @Mapping(target = "surname", source = "grade.gradeId.enrolmentId.userId.surname")
    @Mapping(target = "email", source = "grade.gradeId.enrolmentId.userId.emailAddress")
    @Mapping(target = "moduleName", source = "grade.gradeId.enrolmentId.moduleId.moduleName")
    OverallStudentGradeDto mapFromGrade(Grade grade);



}
