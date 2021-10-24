package se331.project.greenlake.entity.dto;

import lombok.*;
import se331.project.greenlake.entity.Doctor;
import se331.project.greenlake.entity.Patient;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

    DoctorDto comment_by;
    String content;
    Date comment_when;

}