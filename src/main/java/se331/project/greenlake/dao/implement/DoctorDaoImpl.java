package se331.project.greenlake.dao.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import se331.project.greenlake.dao.DoctorDao;
import se331.project.greenlake.entity.Doctor;
import se331.project.greenlake.repository.DoctorRepository;

@Repository
public class DoctorDaoImpl implements DoctorDao {
    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public Doctor getDoctor(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }
}
