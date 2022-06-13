package SMS.schoolmanagementsystem.controllers;

import SMS.schoolmanagementsystem.models.SchoolGroup;
import SMS.schoolmanagementsystem.services.SchoolGroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping(path = "api/v1/groups") @RequiredArgsConstructor @Slf4j
public class SchoolGroupController {

    private final SchoolGroupService service;

    @GetMapping(path = "get_group/{id}")
    public ResponseEntity<SchoolGroup> getGroup(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getSchoolGroup(id));
    }
}
