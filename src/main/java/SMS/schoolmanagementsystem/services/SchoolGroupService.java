package SMS.schoolmanagementsystem.services;

import SMS.schoolmanagementsystem.models.SchoolGroup;
import SMS.schoolmanagementsystem.repositories.SchoolGroupRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class SchoolGroupService {

    private final SchoolGroupRepository schoolGroupRepository;

    public SchoolGroup getSchoolGroup(Long id) {
        return schoolGroupRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        String.format("Group with id %d does not exist", id)
                ));
    }
}
