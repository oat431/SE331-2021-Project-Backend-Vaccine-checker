package se331.project.greenlake.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.project.greenlake.entity.Vaccine;
import se331.project.greenlake.repository.DoctorRepository;
import se331.project.greenlake.repository.PatientRepository;
import se331.project.greenlake.repository.NormalUserRepository;
import se331.project.greenlake.repository.VaccineRepository;

import javax.transaction.Transactional;

@Component
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    NormalUserRepository userRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    VaccineRepository vaccineRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent){
        Vaccine az,jj,pz,md,sv;
        az = vaccineRepository.save(
                Vaccine.builder()
                        .title("Aztrazeneca")
                        .short_title("AZ")
                        .build()
        );
        jj = vaccineRepository.save(
                Vaccine.builder()
                        .title("Johnson and Johnson")
                        .short_title("JJ")
                        .build()
        );
        pz = vaccineRepository.save(
                Vaccine.builder()
                        .title("Pfizer")
                        .short_title("PZ")
                        .build()
        );
        md = vaccineRepository.save(
                Vaccine.builder()
                        .title("Modena")
                        .short_title("MD")
                        .build()
        );
        sv = vaccineRepository.save(
                Vaccine.builder()
                        .title("Sinovax")
                        .short_title("SV")
                        .build()
        );
    }

}
