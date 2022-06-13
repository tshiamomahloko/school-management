package SMS.schoolmanagementsystem.controllers;

import SMS.schoolmanagementsystem.models.Lecturer;
import SMS.schoolmanagementsystem.models.Student;
import SMS.schoolmanagementsystem.services.LecturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping(path = "api/v1/lecturers") @RequiredArgsConstructor
public class LecturerController {

    private final LecturerService lecturerService;

    @GetMapping(path = "get_lecturer/{id}")
    public ResponseEntity<Lecturer> getLecturer(@PathVariable("id") Long id) {
        return ResponseEntity.ok(lecturerService.getLecturer(id));
    }

    @PostMapping(name = "add_lecturer")
    public ResponseEntity<Lecturer> addNewLecturer(@RequestBody Lecturer lecturer) {
        return ResponseEntity.ok(lecturerService.addNewLecturer(lecturer));
    }

    @PatchMapping(path = "update_lecturer_info/{id}")
    public void updateStudent(@PathVariable("id") Long id,
                              @RequestBody(required = false) Lecturer lecturer) {
        // TODO update student information
    }
}
