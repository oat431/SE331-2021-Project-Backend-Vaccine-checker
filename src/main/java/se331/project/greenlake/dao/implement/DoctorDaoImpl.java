package se331.project.greenlake.dao.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import se331.project.greenlake.dao.DoctorDao;
import se331.project.greenlake.entity.Comment;
import se331.project.greenlake.entity.Doctor;
import se331.project.greenlake.entity.Patient;
import se331.project.greenlake.repository.CommentRepository;
import se331.project.greenlake.repository.DoctorRepository;
import se331.project.greenlake.repository.PatientRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.GregorianCalendar;

@Repository
public class DoctorDaoImpl implements DoctorDao {
    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PatientRepository patientRepository;

    @Override
    public Integer getDoctorSize() {
        return Math.toIntExact(doctorRepository.count());
    }

    @Override
    public Page<Doctor> getDoctors(Integer pageSize, Integer page) {
        return doctorRepository.findAll(PageRequest.of(page-1,pageSize));
    }

    @Override
    public Doctor getDoctor(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    @Override
    public Doctor save(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Patient giveComment(String content, Doctor comment_by, Patient comment_to) {
        commentRepository.save(
                Comment.builder()
                        .comment_when(new GregorianCalendar().getTime())
                        .content(content)
                        .comment_by(comment_by)
                        .comment_to(comment_to)
                        .build()
        );
        return patientRepository.save(comment_to);
    }
}
