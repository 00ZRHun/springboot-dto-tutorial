package net.javaguides.springboot.service;

import net.javaguides.springboot.model.AUser;
import net.javaguides.springboot.repository.AUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
// implements UserDetailsService
public class AUserService {

    @Autowired
    private AUserRepository aUserRepo;

   /* @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        return new User("admin","password", new ArrayList<>());
    }*/

    // create new entry of aUser
    public AUser addAUser(AUser aUser) {
        return aUserRepo.save(aUser);
    }

/*    public List<AUserDto> getAllAUsers() {
      return aUserRepo.findAll()
              .stream()
              .map(this::convertToDto)
              .collect(Collectors.toList());
  }*/

    // read entry of aUser with particular id
    public AUser getAUser(Long id) {
        AUser aUserGet = aUserRepo.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "AUser with id " + id + " doesn't exist"));

        return aUserGet;
    }

    // update entry of aUser with particular id
    public AUser updateAUser(Long id, AUser aUser) {
        // check if a valid id
        if (!Objects.equals(id, aUser.getId())) {
            throw new IllegalArgumentException("IDs don't match");
        } else {
            aUserRepo.findById(id)
                    .orElseThrow(() -> new IllegalStateException(
                            "AUser with id " + id + " doesn't exist."));
        }

        aUser.setCreated(aUserRepo.findById(id)
                .get()
                .getCreated());
        aUser.setUpdated(LocalDateTime.now());
        aUserRepo.save(aUser);
        return aUser;
    }

    // delete entry of aUser with particular id
    public AUser deleteAUser(Long id) {
        AUser aUser = aUserRepo.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "AUser with id" + id + " doesn't exist."));
        aUserRepo.deleteById(id);

        return aUser;
    }

    public Page<AUser> getPage(Integer page, Integer size, Boolean enablePagination) {
        return aUserRepo.findAll(enablePagination ? PageRequest.of(page, size): Pageable.unpaged());
    }
}
