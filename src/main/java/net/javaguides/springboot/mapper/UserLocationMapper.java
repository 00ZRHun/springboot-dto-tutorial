package net.javaguides.springboot.mapper;

import net.javaguides.springboot.dto.UserLocationDTO;
import net.javaguides.springboot.model.User;

import java.util.List;

public interface UserLocationMapper {
    UserLocationDTO toUserLocationDTO(User user);

    List<UserLocationDTO> toUserLocationDTOs(List<User> user);

    User toUser(UserLocationDTO userLocationDTO);
}
