package se331.project.greenlake.service.Implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import se331.project.greenlake.dao.DoctorDao;
import se331.project.greenlake.entity.Doctor;
import se331.project.greenlake.entity.Patient;
import se331.project.greenlake.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    DoctorDao doctorDao;

    @Override
    public Integer getDoctorSize() {
        return doctorDao.getDoctorSize();
    }

    @Override
    public Page<Doctor> getDoctors(Integer pageSize, Integer page) {
        return doctorDao.getDoctors(pageSize,page);
    }

    @Override
    public Page<Patient> getPatientInCares(Doctor doctor,Integer pageSize, Integer page) {
        return doctorDao.getPatientInCares(doctor,pageSize,page);
    }

    @Override
    public Doctor getDoctor(Long id) {
        return doctorDao.getDoctor(id);
    }

    @Override
    public Doctor save(Doctor doctor) {
        return doctorDao.save(doctor);
    }

    @Override
    public Patient giveComment(String content, Doctor comment_by, Patient comment_to) {
        return doctorDao.giveComment(content,comment_by,comment_to);
    }


}
