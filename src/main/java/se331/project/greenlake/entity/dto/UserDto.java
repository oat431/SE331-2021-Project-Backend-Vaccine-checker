package se331.project.greenlake.entity.dto;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    Long id;
    String sex;
    String firstname;
    String lastname;
    Date date_of_birth;
    String hometown;
    List<String> imageUrls;
}