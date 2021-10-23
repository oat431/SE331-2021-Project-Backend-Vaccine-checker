package se331.project.greenlake.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se331.project.greenlake.entity.Doctor;
import se331.project.greenlake.entity.Patient;
import se331.project.greenlake.service.DoctorService;
import se331.project.greenlake.service.PatientService;
import se331.project.greenlake.util.LabMapper;
import se331.project.greenlake.util.form.CommentForm;

@Controller
public class DoctorController {
    @Autowired
    PatientService patientService;

    @Autowired
    DoctorService doctorService;

    @GetMapping("get-patients/{id}")
    public ResponseEntity<?> getDoctor(
            @PathVariable("id") Long id
    ){
        Doctor output = doctorService.getDoctor(id);
        if(output != null){
            return ResponseEntity.ok(LabMapper.INSTANCE.getDoctorAuthDto(output));
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }

    @PostMapping("comment")
    public ResponseEntity<?> postComment(@RequestBody CommentForm commentForm){
        Patient comment_to = patientService.getPatient(commentForm.getComment_to());
        Doctor comment_by = doctorService.getDoctor(commentForm.getComment_by());
        Patient output = doctorService.giveComment(commentForm.getContent(),comment_by,comment_to);
        return ResponseEntity.ok(LabMapper.INSTANCE.getPatientDto(output));
    }
}
