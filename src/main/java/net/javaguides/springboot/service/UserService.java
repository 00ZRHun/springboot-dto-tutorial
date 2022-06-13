package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.UserLocationDTO;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserLocationDTO> getAllUsersLocation(){
        return userRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    // write code to manually convert User JPA entity to UserLocationDTO
    /*private UserLocationDTO convertEntityToDto(User user) {
        UserLocationDTO userLocationDTO = new UserLocationDTO();
        userLocationDTO.setUserId(user.getId());
        userLocationDTO.setEmail(user.getEmail());
        userLocationDTO.setPlace(user.getLocation().getPlace());
        userLocationDTO.setLongitude(user.getLocation().getLongitude());
        userLocationDTO.setLatitude(user.getLocation().getLatitude());
        return userLocationDTO;
    }*/

    // convert with only 1 LOC
    private UserLocationDTO convertEntityToDto(User user) {
        /*modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);  // lib can easily locate & match properties*/
        UserLocationDTO userLocationDTO = new UserLocationDTO();
        userLocationDTO = modelMapper.map(user, UserLocationDTO.class);
        return userLocationDTO;
    }
}
