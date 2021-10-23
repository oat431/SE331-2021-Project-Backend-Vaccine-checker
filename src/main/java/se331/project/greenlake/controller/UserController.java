package se331.project.greenlake.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se331.project.greenlake.entity.*;
import se331.project.greenlake.security.entity.User;
import se331.project.greenlake.service.DoctorService;
import se331.project.greenlake.service.PatientService;
import se331.project.greenlake.service.UserService;
import se331.project.greenlake.service.VaccineService;
import se331.project.greenlake.util.LabMapper;
import se331.project.greenlake.util.form.TempPatientDoctor;
import se331.project.greenlake.util.form.TempVaccinatedList;

import javax.print.Doc;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    PatientService patientService;

    @Autowired
    VaccineService vaccineService;

    @Autowired
    DoctorService doctorService;

    @GetMapping("all-users")
    public ResponseEntity<?> getAllUsers(
            @RequestParam(value = "_limit", required = false) Integer perPage,
            @RequestParam(value = "_page", required = false) Integer page,
            @RequestParam(value = "title", required = false) String title
    ) {
        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        Page<User> pageOutput;
        if (title == null) {
            pageOutput = userService.getUsers(perPage, page);
        } else {
            pageOutput = userService.getUsers(title, PageRequest.of(page - 1, perPage));
        }
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getUserDto(pageOutput.getContent()), responseHeader, HttpStatus.OK);
    }

    @GetMapping("un-verify-users")
    public ResponseEntity<?> getUnVerifyUser(
            @RequestParam(value = "_limit", required = false) Integer perPage,
            @RequestParam(value = "_page", required = false) Integer page
    ){
        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        Page<User> pageOutput;
        pageOutput = userService.getUnVerifyUsers(PageRequest.of(page-1,perPage));
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getUserDto(pageOutput.getContent()), responseHeader, HttpStatus.OK);
    }

    @GetMapping("patients")
    public ResponseEntity<?> getPatients(
            @RequestParam(value = "_limit", required = false) Integer perPage,
            @RequestParam(value = "_page", required = false) Integer page,
            @RequestParam(value = "dose", required = false) Integer dose,
            @RequestParam(value = "title",required = false) String title
    ){
        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        Page<Patient> pageOutput;
        pageOutput = patientService.getPatients(perPage,page);

        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getPatientDto(pageOutput.getContent()), responseHeader, HttpStatus.OK);
    }

    @GetMapping("patients/{id}")
    public ResponseEntity<?> getPatient(
           @PathVariable("id") Long id
    ){
        Patient output = patientService.getPatient(id);
        if(output != null){
            return ResponseEntity.ok(LabMapper.INSTANCE.getPatientDto(output));
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }

    @GetMapping("doctors")
    public ResponseEntity<?> getDoctors(
            @RequestParam(value = "_limit", required = false) Integer perPage,
            @RequestParam(value = "_page", required = false) Integer page
    ){
        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        Page<Doctor> pageOutput;
        pageOutput = doctorService.getDoctors(perPage,page);

        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getDoctorDto(pageOutput.getContent()), responseHeader, HttpStatus.OK);
    }

    @GetMapping("doctors/{id}")
    public ResponseEntity<?> getDoctor(
            @PathVariable("id") Long id
    ){
        Doctor output = doctorService.getDoctor(id);
        if(output != null){
            return ResponseEntity.ok(LabMapper.INSTANCE.getDoctorDto(output));
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }

    @PostMapping("verify-user/{id}/patient")
    public ResponseEntity<?> VerifyUserAsPatient(
           @PathVariable("id") Long id
    ){
        User user = userService.getUser(id);
        Patient output = userService.getVerifyAsPatient(user) ;
        return ResponseEntity.ok(LabMapper.INSTANCE.getPatientDto(output));
    }

    @PostMapping("verify-user/{id}/doctor")
    public ResponseEntity<?> VerifyUserAsDoctor(
            @PathVariable("id") Long id
    ){
        User user = userService.getUser(id);
        Doctor output = userService.getVerifyAsDoctor(user) ;
        return ResponseEntity.ok(LabMapper.INSTANCE.getDoctorDto(output));
    }

    @PostMapping("update-vaccine")
    public ResponseEntity<?> UpdateVaccine(@RequestBody TempVaccinatedList tempVaccinatedList){
        Patient output = vaccineService.addUpdateVaccineToPatient(tempVaccinatedList.getVaccinated_when(), tempVaccinatedList.getPatient_id(), tempVaccinatedList.getVaccine_id());
        return ResponseEntity.ok(LabMapper.INSTANCE.getPatientDto(output));
    }

    @PostMapping("update-doctor")
    public ResponseEntity<?> UpdateDoctor(@RequestBody TempPatientDoctor tempPatientDoctor){
        Patient output = patientService.getDoctorToTakeCare(tempPatientDoctor.getDoctor_id(), tempPatientDoctor.getPatient_id());
        return ResponseEntity.ok(LabMapper.INSTANCE.getPatientDto(output));
    }
}
