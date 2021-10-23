package se331.project.greenlake.service.Implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se331.project.greenlake.dao.DoctorDao;
import se331.project.greenlake.entity.Doctor;
import se331.project.greenlake.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    DoctorDao doctorDao;

    @Override
    public Doctor getDoctor(Long id) {
        return doctorDao.getDoctor(id);
    }
}
