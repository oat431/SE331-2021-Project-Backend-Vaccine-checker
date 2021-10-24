package se331.project.greenlake.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import se331.project.greenlake.entity.Patient;
import se331.project.greenlake.service.PatientService;
import se331.project.greenlake.util.LabMapper;

@Controller
public class PatientController {
    @Autowired
    PatientService patientService;

    @GetMapping("patient/{id}")
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
}
