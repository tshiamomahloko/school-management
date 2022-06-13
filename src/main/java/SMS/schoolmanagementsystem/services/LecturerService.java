package SMS.schoolmanagementsystem.services;

import SMS.schoolmanagementsystem.models.Lecturer;
import SMS.schoolmanagementsystem.repositories.LecturerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class LecturerService {

    private final LecturerRepository lecturerRepository;

    public Lecturer getLecturer(Long id) {
        return lecturerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        String.format("Lecturer with id %d does not exist", id)
                ));
    }

    public Lecturer addNewLecturer(Lecturer lecturer) {
        // TODO validation
        return lecturerRepository.save(lecturer);
    }

    public void deactivateLecturer(Long id) {
        if (!lecturerRepository.existsById(id)) {
            throw new IllegalStateException(
                    String.format("Lecturer with id %d does not exist", id)
            );
        }
        // TODO deactivate lecturer account
    }

    public void updateLecturer(Long id, Lecturer updatedLecturer) {
        Lecturer lecturer = lecturerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        String.format("Lecturer with id %d does not exist", id)
                ));
        // TODO update Lecturer
    }

    // TODO any other info a lecturer can do
    // TODO get all info regarding a course lecturer teaches
    // TODO create an exam
}
