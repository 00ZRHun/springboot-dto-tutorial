package net.javaguides.springboot.controller;

import net.javaguides.springboot.dto.AUserDto;
import net.javaguides.springboot.model.AUser;
import net.javaguides.springboot.service.AUserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user-profile")
public class AUserController {

    @Autowired
    private AUserService aUserService;

    @Autowired
    private ModelMapper modelMapper;

    //add aUser
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<AUserDto> addAUser(@RequestBody AUserDto aUserDto) {
        try {
            AUser aUser = convertToEntity(aUserDto);
            AUser aUserCreated = aUserService.addAUser(aUser);

            if (aUserCreated==null) {
                return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
            }

            return ResponseEntity.ok().body(convertToDto(aUserCreated));
        }
        catch (Exception e) {
            e.printStackTrace();
            // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            return ResponseEntity.internalServerError().build();   // ditto
        }
    }

//   Can't run, gOT BUG
    // Show and display all aUsers
  /*@GetMapping
  public ResponseEntity<List<AUserDto>> getAllAUsers() {
      List<AUserDto> aUserList = aUserService.getAllAUsers();
      if (aUserList.size()<=0) {
          return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
      }
      return ResponseEntity.of(Optional.of(aUserList));
  }*/

    // Get the aUser by id
    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<AUserDto> getAUser (@PathVariable("id") Long id) {
        try {
            AUser aUser = aUserService.getAUser(id);
            AUserDto aUserDto = convertToDto(aUser);

            if (aUserDto==null) {
                // return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                return ResponseEntity.notFound().build();   // ditto
            }

            return ResponseEntity.of(Optional.of(aUserDto));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    //update aUser
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AUserDto> updateAUser (@PathVariable("id") Long id, @RequestBody AUserDto aUserDto) {
        try {
            AUser aUser = convertToEntity(aUserDto);
            AUser aUserUpdated = aUserService.updateAUser(id, aUser);

            if (aUserUpdated==null) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok().body(convertToDto(aUserUpdated));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    //delete aUser
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<AUserDto> deleteAUser (@PathVariable("id") Long id) {
        try{
            AUser aUser = aUserService.deleteAUser(id);
            AUserDto aUserDto = convertToDto(aUser);

            if (aUserDto==null) {
                return ResponseEntity.notFound().build();
            }

            // return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            return ResponseEntity.ok().body(aUserDto);   // alternative
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    //adding pagination to the test order controller
    //enable the pagination to apply the feature
    //needed to comment the get method on line 36 to 44 to make sure it works
    //still in the making
    @GetMapping
    public ResponseEntity<Page<AUser>> getPage(@PathVariable("page")
                                                     @RequestParam(required = false, defaultValue = "0") Integer page,
                                                     @RequestParam(required = false, defaultValue = "10") Integer size,
                                                     @RequestParam(required = false, defaultValue = "false") Boolean enablePagination) {
        return ResponseEntity.ok(aUserService.getPage(page, size, enablePagination));
    }



    // === DTO ===
    // 1. JPA Entity Model to DTO
    private AUserDto convertToDto(AUser aUser) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);  // lib can easily locate & match properties
        AUserDto AUserDto = modelMapper.map(aUser, AUserDto.class);
        return AUserDto;
    }

    // 2. DTO to JPA Entity Model
    private AUser convertToEntity(AUserDto AUserDto) throws ParseException {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        AUser aUser = modelMapper.map(AUserDto, AUser.class);
        return aUser;
    }
}
