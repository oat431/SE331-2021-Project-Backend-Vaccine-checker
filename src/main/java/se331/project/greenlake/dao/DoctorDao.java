package se331.project.greenlake.dao;

import org.springframework.data.domain.Page;
import se331.project.greenlake.entity.Doctor;
import se331.project.greenlake.entity.Patient;

public interface DoctorDao {
    Integer getDoctorSize();
    Page<Doctor> getDoctors(Integer pageSize,Integer page);
    Doctor getDoctor(Long id);
    Doctor save(Doctor doctor);
    Patient giveComment(String content, Doctor comment_by, Patient comment_to);
}
