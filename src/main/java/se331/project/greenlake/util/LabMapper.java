package se331.project.greenlake.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import se331.project.greenlake.entity.*;
import se331.project.greenlake.entity.dto.*;
import se331.project.greenlake.security.entity.User;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(imports = Collectors.class)
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);

    UserDto getUserDto(User user);
    List<UserDto> getUserDto(List<User> users);

    PatientDto getPatientDto(Patient patient);
    List<PatientDto> getPatientDto(List<Patient> patients);

    DoctorDto getDoctorDto(Doctor doctor);
    List<DoctorDto> getDoctorDto(List<Doctor> doctors);

    DoctorAuthDto getDoctorAuthDto(Doctor doctor);
    List<DoctorAuthDto> getDoctorAuthDto(List<Doctor> doctors);

    @Mapping(target = "authorities", expression = "java(admin.getAuthorities().stream().map(auth -> auth.getName().name()).collect(Collectors.toList()))")
    AdminAuthDto getAdminAuthDTO(User admin);


}
