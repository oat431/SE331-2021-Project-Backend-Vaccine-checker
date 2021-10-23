package se331.project.greenlake.dao.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import se331.project.greenlake.dao.UserDao;
import se331.project.greenlake.entity.Doctor;
import se331.project.greenlake.entity.Patient;
import se331.project.greenlake.repository.DoctorRepository;
import se331.project.greenlake.repository.PatientRepository;
import se331.project.greenlake.security.entity.Authority;
import se331.project.greenlake.security.entity.AuthorityName;
import se331.project.greenlake.security.entity.User;
import se331.project.greenlake.security.repository.UserRepository;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientRepository patientRepository;

    //PasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public Integer getUserSize() {
        return Math.toIntExact(userRepository.count());
    }

    @Override
    public Page<User> getUsers(Integer pageSize, Integer page) {
        return userRepository.findAll(PageRequest.of(page-1,pageSize));
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Page<User> getUsers(String username, Pageable pageable) {
        return userRepository.findByUsernameIgnoreCaseContainingOrFirstnameIgnoreCaseContaining(username,username,pageable);
    }

    @Override
    public Page<User> getUnVerifyUsers(Pageable pageable) {
        return userRepository.findByVerifyIsFalse(pageable);
    }

    @Override
    public Doctor getVerifyAsDoctor(User user) {
        Authority role_doctor = Authority.builder().name(AuthorityName.ROLE_DOCTOR).build();
        String tempFirstName = user.getFirstname();
        String tempLastName = user.getLastname();
        String tempUsername = user.getUsername();
        String tempPassword = user.getPassword();
        String tempHomeTown = user.getHometown();
        String temEmail = user.getEmail();
        String tempSex = user.getSex();
        Date tempDateofBirth = user.getDate_of_birth();
        userRepository.delete(user);

        Doctor doctor = new Doctor();
        doctor.setUsername(tempUsername);
        doctor.setPassword(tempPassword);
        doctor.setEmail(temEmail);
        doctor.setSex(tempSex);
        doctor.setFirstname(tempFirstName);
        doctor.setLastname(tempLastName);
        doctor.setHometown(tempHomeTown);
        doctor.setDate_of_birth(tempDateofBirth);
        doctor.setEnabled(true);
        doctor.setVerify(true);
        doctor.getAuthorities().add(role_doctor);
        return doctorRepository.save(doctor);
    }

    @Override
    public Patient getVerifyAsPatient(User user) {
        Authority role_patient = Authority.builder().name(AuthorityName.ROLE_PATIENT).build();
        String tempFirstName = user.getFirstname();
        String tempLastName = user.getLastname();
        String tempUsername = user.getUsername();
        String tempPassword = user.getPassword();
        String tempHomeTown = user.getHometown();
        String temEmail = user.getEmail();
        String tempSex = user.getSex();
        Date tempDateofBirth = user.getDate_of_birth();
        userRepository.delete(user);

        Patient patient = new Patient();
        patient.setUsername(tempUsername);
        patient.setPassword(tempPassword);
        patient.setEmail(temEmail);
        patient.setSex(tempSex);
        patient.setFirstname(tempFirstName);
        patient.setLastname(tempLastName);
        patient.setHometown(tempHomeTown);
        patient.setDate_of_birth(tempDateofBirth);
        patient.setEnabled(true);
        patient.setVerify(true);
        patient.getAuthorities().add(role_patient);
        return patientRepository.save(patient);
    }
}
