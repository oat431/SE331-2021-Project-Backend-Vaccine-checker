package se331.project.greenlake.entity.dto;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    Long Userid;
    String name;
    String surname;
    String dateOfBirth;
    String hometown;
}