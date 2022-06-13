package SMS.schoolmanagementsystem.repositories;

import SMS.schoolmanagementsystem.models.Module;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ModuleRepository extends JpaRepository<Module, Long> {
    @Query(value = "select m from Module m")
    public List<Module> getAllModules();
}