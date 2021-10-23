package se331.project.greenlake.service;

import org.springframework.data.domain.Page;
import se331.project.greenlake.entity.Doctor;

public interface DoctorService {
    Integer getDoctorSize();
    Page<Doctor> getDoctors(Integer pageSize, Integer page);
    Doctor getDoctor(Long id);
    Doctor save(Doctor doctor);
}
