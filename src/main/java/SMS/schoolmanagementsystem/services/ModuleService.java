package SMS.schoolmanagementsystem.services;

import SMS.schoolmanagementsystem.models.Module;
import SMS.schoolmanagementsystem.repositories.ModuleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ModuleService {

    @Autowired
    private  ModuleRepository moduleRepository;

    public List<Module> getAllModules() {
        return moduleRepository.findAll();
    }

}
