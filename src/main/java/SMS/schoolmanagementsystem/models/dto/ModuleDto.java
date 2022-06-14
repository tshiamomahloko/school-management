package SMS.schoolmanagementsystem.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ModuleDto {

    private String moduleName;
    private String moduleDescription;
    private int courseID;

}
