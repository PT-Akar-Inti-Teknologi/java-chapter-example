package org.ait.project.aitboilerplate.shared.dto.transform;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Mapper(componentModel = "spring")
public interface GeneralTransform {

    @Named("passwordEncoder")
    default String passwordExtractor(String password){
        return new BCryptPasswordEncoder().encode(password);
    }
}
