package se331.project.greenlake.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import se331.project.greenlake.entity.*;
import se331.project.greenlake.repository.*;
import se331.project.greenlake.security.entity.Authority;
import se331.project.greenlake.security.entity.AuthorityName;
import se331.project.greenlake.security.entity.User;
import se331.project.greenlake.security.repository.AuthorityRepository;
import se331.project.greenlake.security.repository.UserRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Component
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    UserRepository userRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    VaccineRepository vaccineRepository;

    @Autowired
    VaccinatedListRepository vaccinatedListRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    AuthorityRepository authorityRepository;

    Vaccine az,jj,pz,md,sv,nv;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent){

        addVaccine();
        addUser();
        updateVaccine();
        addComment();

    }

    private void addVaccine(){
        az = vaccineRepository.save(
                Vaccine.builder()
                        .title("AstraZeneca")
                        .short_title("AZ")
                        .build()
        );
        jj = vaccineRepository.save(
                Vaccine.builder()
                        .title("Johnson & Johnson's Janssen")
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
                        .title("Sinovac")
                        .short_title("SV")
                        .build()
        );
        nv = vaccineRepository.save(
                Vaccine.builder()
                        .title("Novavax")
                        .short_title("NV")
                        .build()
        );
    }

    private void updateVaccine(){
        vaccinatedListRepository.save(
                VaccinatedList.builder()
                        .injected_vaccine(az)
                        .vaccinated_patient(mockPatient[0])
                        .vaccinated_when(new GregorianCalendar(2021, 7, 12).getTime())
                        .build()
        );

        vaccinatedListRepository.save(
                VaccinatedList.builder()
                        .injected_vaccine(az)
                        .vaccinated_patient(mockPatient[0])
                        .vaccinated_when(new GregorianCalendar(2021, 10, 4).getTime())
                        .build()
        );

        vaccinatedListRepository.save(
                VaccinatedList.builder()
                        .injected_vaccine(pz)
                        .vaccinated_patient(mockPatient[1])
                        .vaccinated_when(new GregorianCalendar(2021, 4, 29).getTime())
                        .build()
        );

        vaccinatedListRepository.save(
                VaccinatedList.builder()
                        .injected_vaccine(pz)
                        .vaccinated_patient(mockPatient[1])
                        .vaccinated_when(new GregorianCalendar(2021, 5, 16).getTime())
                        .build()
        );

        vaccinatedListRepository.save(
                VaccinatedList.builder()
                        .injected_vaccine(nv)
                        .vaccinated_patient(mockPatient[2])
                        .vaccinated_when(new GregorianCalendar(2021, 7, 15).getTime())
                        .build()
        );

        vaccinatedListRepository.save(
                VaccinatedList.builder()
                        .injected_vaccine(nv)
                        .vaccinated_patient(mockPatient[2])
                        .vaccinated_when(new GregorianCalendar(2021, 8, 5).getTime())
                        .build()
        );

        vaccinatedListRepository.save(
                VaccinatedList.builder()
                        .injected_vaccine(az)
                        .vaccinated_patient(mockPatient[3])
                        .vaccinated_when(new GregorianCalendar(2021, 4, 28).getTime())
                        .build()
        );

        vaccinatedListRepository.save(
                VaccinatedList.builder()
                        .injected_vaccine(sv)
                        .vaccinated_patient(mockPatient[4])
                        .vaccinated_when(new GregorianCalendar(2021, 2, 17).getTime())
                        .build()
        );

        vaccinatedListRepository.save(
                VaccinatedList.builder()
                        .injected_vaccine(sv)
                        .vaccinated_patient(mockPatient[4])
                        .vaccinated_when(new GregorianCalendar(2021, 3, 6).getTime())
                        .build()
        );

        vaccinatedListRepository.save(
                VaccinatedList.builder()
                        .injected_vaccine(sv)
                        .vaccinated_patient(mockPatient[4])
                        .vaccinated_when(new GregorianCalendar(2021, 5, 1).getTime())
                        .build()
        );
    }

    private void addComment(){
        commentRepository.save(
                Comment.builder()
                        .comment_by(mockDoctor[0])
                        .comment_to(mockPatient[0])
                        .content("Hey you look good na")
                        .comment_when(new GregorianCalendar(2021, 10, 12).getTime())
                        .build()
        );

        commentRepository.save(
                Comment.builder()
                        .comment_by(mockDoctor[2])
                        .comment_to(mockPatient[2])
                        .content("You need to drink a lot of water")
                        .comment_when(new GregorianCalendar(2021, 10, 12).getTime())
                        .build()
        );

        commentRepository.save(
                Comment.builder()
                        .comment_by(mockDoctor[1])
                        .comment_to(mockPatient[3])
                        .content("Stop eating a fried thing ok.")
                        .comment_when(new GregorianCalendar(2021, 10, 1).getTime())
                        .build()
        );

        commentRepository.save(
                Comment.builder()
                        .comment_by(mockDoctor[2])
                        .comment_to(mockPatient[4])
                        .content("Ha ha you are going to die on this government I cannot help you wa")
                        .comment_when(new GregorianCalendar(2021, 10, 1).getTime())
                        .build()
        );
    }

    User mockNormalUser, mockNormalUser2,theAdmin;
    Patient[] mockPatient = new Patient[5];
    Doctor[] mockDoctor = new Doctor[3];
    PasswordEncoder encoder = new BCryptPasswordEncoder();
    private void addUser() {
        Authority normalUser = Authority.builder().name(AuthorityName.ROLE_USER).build();
        Authority patient = Authority.builder().name(AuthorityName.ROLE_PATIENT).build();
        Authority doctor = Authority.builder().name(AuthorityName.ROLE_DOCTOR).build();
        Authority admin = Authority.builder().name(AuthorityName.ROLE_ADMIN).build();
        List<String> tempUrl1 = new ArrayList<>();
        List<String> tempUrl2 = new ArrayList<>();
        tempUrl1.add("https://image.freepik.com/free-photo/korean-young-woman-s-half-length-portrait-female-model-white-shirt-showing-pointing-something-concept-human-emotions-facial-expression-front-view_155003-18248.jpg");
        tempUrl2.add("https://image.freepik.com/free-photo/shocked-bearded-man-recieves-unexpected-news-from-friend-clasps-hands-near-face-opens-mouth-widely-expresses-surprisement-isolated-white-wall_273609-16646.jpg");
        mockNormalUser = User.builder()
                .username("normalUser")
                .password(encoder.encode("normalUser"))
                .email("normalUser@normalUser.com")
                .sex("male")
                .firstname("Something")
                .lastname("ThingSome")
                .imageUrls(tempUrl1)
                .enabled(false)
                .verify(false)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .hometown("Someland, on land")
                .date_of_birth(new GregorianCalendar(2000, 10, 7).getTime()).build();

        mockNormalUser2 = User.builder()
                .username("normalUser2")
                .password(encoder.encode("normalUser2"))
                .email("normalUser2@normalUser2.com")
                .sex("female")
                .firstname("Female")
                .lastname("NormalUser")
                .imageUrls(tempUrl2)
                .enabled(true)
                .verify(false)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .hometown("On land, Something")
                .date_of_birth(new GregorianCalendar(2000, 10, 7).getTime()).build();

        theAdmin = User.builder()
                .username("pot561")
                .password(encoder.encode("Oralita2000"))
                .email("sahachan_t@cmu.ac.th.com")
                .sex("male")
                .firstname("Flowero")
                .lastname("Panomete")
                .enabled(true)
                .verify(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .hometown("Kamphanegphet, Thailand")
                .date_of_birth(new GregorianCalendar(2000, 10, 7).getTime())
                .build();

        addMockDoctor();
        addMockPatient();

        authorityRepository.save(normalUser);
        authorityRepository.save(admin);
        authorityRepository.save(patient);
        authorityRepository.save(doctor);

        mockNormalUser.getAuthorities().add(normalUser);
        mockNormalUser2.getAuthorities().add(normalUser);
        theAdmin.getAuthorities().add(admin);

        userRepository.save(mockNormalUser);
        userRepository.save(mockNormalUser2);
        userRepository.save(theAdmin);

        for (Patient value : mockPatient) {
            value.getAuthorities().add(patient);
            patientRepository.save(value);
        }

        for (Doctor value : mockDoctor) {
            value.getAuthorities().add(doctor);
            doctorRepository.save(value);
        }

    }

    private void addMockPatient(){
        for(int i=0;i<mockPatient.length;i++){
            mockPatient[i] = new Patient();
        }
        mockPatient[0].setUsername("oat431");
        mockPatient[0].setPassword(encoder.encode("Saha6462"));
        mockPatient[0].setEmail("oat431@gmail.com");
        mockPatient[0].setSex("male");
        mockPatient[0].setFirstname("Sahachan");
        mockPatient[0].setLastname("Tippimwong");
        mockPatient[0].getImageUrls().add("https://i.imgur.com/cpgnTGg.jpg");
        mockPatient[0].setEnabled(true);
        mockPatient[0].setVerify(true);
        mockPatient[0].setLastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        mockPatient[0].setDate_of_birth(new GregorianCalendar(2000, 11, 9).getTime());
        mockPatient[0].setHometown("Kamphanegphet, Thailand");
        mockPatient[0].setVaccinated_status(2);
        mockPatient[0].setTakeCare(mockDoctor[0]);

        mockPatient[1].setUsername("est123");
        mockPatient[1].setPassword(encoder.encode("Est4466"));
        mockPatient[1].setEmail("est@est.com");
        mockPatient[1].setSex("male");
        mockPatient[1].setFirstname("Essie");
        mockPatient[1].setLastname("Oneal");
        mockPatient[1].getImageUrls().add("https://image.freepik.com/free-photo/shocked-bearded-man-recieves-unexpected-news-from-friend-clasps-hands-near-face-opens-mouth-widely-expresses-surprisement-isolated-white-wall_273609-16646.jpg");
        mockPatient[1].setEnabled(true);
        mockPatient[1].setVerify(true);
        mockPatient[1].setLastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        mockPatient[1].setDate_of_birth(new GregorianCalendar(1998, 11, 6).getTime());
        mockPatient[1].setHometown("Earth, Solar System");
        mockPatient[1].setVaccinated_status(2);
        mockPatient[1].setTakeCare(mockDoctor[1]);

        mockPatient[2].setUsername("emma431");
        mockPatient[2].setPassword(encoder.encode("Emma555"));
        mockPatient[2].setEmail("emma123@emma.com");
        mockPatient[2].setSex("female");
        mockPatient[2].setFirstname("Emma");
        mockPatient[2].setLastname("Sexton");
        mockPatient[2].setEnabled(true);
        mockPatient[2].setVerify(true);
        mockPatient[2].getImageUrls().add("https://image.freepik.com/free-photo/happy-arab-woman-hijab-portrait-smiling-girl-pointing-camera-red-studio-background-young-emotional-woman-human-emotions-facial-expression-concept_155003-21757.jpg");
        mockPatient[2].setLastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        mockPatient[2].setDate_of_birth(new GregorianCalendar(2004, 12, 25).getTime());
        mockPatient[2].setHometown("Modesto, US");
        mockPatient[2].setVaccinated_status(2);
        mockPatient[2].setTakeCare(mockDoctor[2]);

        mockPatient[3].setUsername("josep111");
        mockPatient[3].setPassword(encoder.encode("JoJo563"));
        mockPatient[3].setEmail("Josep@josep.com");
        mockPatient[3].setSex("female");
        mockPatient[3].setFirstname("Josephine");
        mockPatient[3].setLastname("Charles");
        mockPatient[3].getImageUrls().add("https://image.freepik.com/free-photo/korean-young-woman-s-half-length-portrait-female-model-white-shirt-showing-pointing-something-concept-human-emotions-facial-expression-front-view_155003-18248.jpg");
        mockPatient[3].setEnabled(true);
        mockPatient[3].setVerify(true);
        mockPatient[3].setLastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        mockPatient[3].setDate_of_birth(new GregorianCalendar(2000, 8, 8).getTime());
        mockPatient[3].setHometown("Bankok, Thailand");
        mockPatient[3].setVaccinated_status(1);
        mockPatient[3].setTakeCare(mockDoctor[1]);

        mockPatient[4].setUsername("clay903");
        mockPatient[4].setPassword(encoder.encode("itmeclay333"));
        mockPatient[4].setEmail("clay@clay.com");
        mockPatient[4].setSex("male");
        mockPatient[4].setFirstname("Clay");
        mockPatient[4].setLastname("Leon");
        mockPatient[4].getImageUrls().add("https://image.freepik.com/free-photo/shocked-bearded-man-recieves-unexpected-news-from-friend-clasps-hands-near-face-opens-mouth-widely-expresses-surprisement-isolated-white-wall_273609-16646.jpg");
        mockPatient[4].setEnabled(true);
        mockPatient[4].setVerify(true);
        mockPatient[4].setLastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        mockPatient[4].setDate_of_birth(new GregorianCalendar(1983, 12, 5).getTime());
        mockPatient[4].setHometown("Beijing, China");
        mockPatient[4].setVaccinated_status(3);
        mockPatient[4].setTakeCare(mockDoctor[2]);
    }

    private void addMockDoctor(){
        for(int i=0;i<mockDoctor.length;i++){
            mockDoctor[i] = new Doctor();
        }
        mockDoctor[0].setUsername("Doctor");
        mockDoctor[0].setPassword(encoder.encode("doctor"));
        mockDoctor[0].setEmail("doctor@doctor.com");
        mockDoctor[0].setSex("male");
        mockDoctor[0].setFirstname("Doctor");
        mockDoctor[0].setLastname("Rotcod");
        mockDoctor[0].getImageUrls().add("https://images.unsplash.com/photo-1586770802838-e524ec9018a8?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=387&q=80");
        mockDoctor[0].setEnabled(true);
        mockDoctor[0].setVerify(true);
        mockDoctor[0].setLastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        mockDoctor[0].setHospital("Something, Hopistal");
        mockDoctor[0].setHometown("eiei");
        mockDoctor[0].setDate_of_birth(new GregorianCalendar(1998, 12, 1).getTime());

        mockDoctor[1].setUsername("Kim");
        mockDoctor[1].setPassword(encoder.encode("kim777"));
        mockDoctor[1].setEmail("kim@doctor.com");
        mockDoctor[1].setSex("female");
        mockDoctor[1].setFirstname("Kim");
        mockDoctor[1].setLastname("Rotcod");
        mockDoctor[1].getImageUrls().add("https://images.unsplash.com/photo-1622253692010-333f2da6031d?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=400&q=80");
        mockDoctor[1].setEnabled(true);
        mockDoctor[1].setVerify(true);
        mockDoctor[1].setLastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        mockDoctor[1].setHospital("Something, Hospital");
        mockDoctor[1].setHometown("Stakhome, Sweden");
        mockDoctor[1].setDate_of_birth(new GregorianCalendar(1998, 12, 1).getTime());

        mockDoctor[2].setUsername("Su");
        mockDoctor[2].setPassword(encoder.encode("susu888"));
        mockDoctor[2].setEmail("susu@doctor.com");
        mockDoctor[2].setSex("female");
        mockDoctor[2].setFirstname("Su Chan");
        mockDoctor[2].setLastname("Rotcod");
        mockDoctor[2].getImageUrls().add("https://images.unsplash.com/photo-1601583789200-96cd7f385315?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=334&q=80");
        mockDoctor[2].setEnabled(true);
        mockDoctor[2].setVerify(true);
        mockDoctor[2].setLastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        mockDoctor[2].setHospital("Something, Hospital");
        mockDoctor[2].setHometown("Dubai, UAE");
        mockDoctor[2].setDate_of_birth(new GregorianCalendar(1998, 12, 1).getTime());
    }
}
