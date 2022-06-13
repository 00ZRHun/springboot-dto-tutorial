package net.javaguides.springboot;

import net.javaguides.springboot.model.Location;
import net.javaguides.springboot.model.OccupationModel;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.LocationRepository;
import net.javaguides.springboot.repository.OccupationRepository;
import net.javaguides.springboot.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootDtoTutorialApplication implements CommandLineRunner {

	@Bean  // make/configure ModelMapper class as a spring bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDtoTutorialApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LocationRepository locationRepository;

	@Autowired
	private OccupationRepository occupationRepository;

	@Override
	public void run(String... args) throws Exception {

		Location location = new Location();
		location.setPlace("Prune");
		location.setDescription("Prune is a great place to live");
		location.setLongitude(40.5);
		location.setLatitude(30.6);
		locationRepository.save(location);

		OccupationModel occupation = new OccupationModel();
		occupation.setName("Software Engineer");
		occupation.setDescription("develop software system");
		occupationRepository.save(occupation);

		User user1 = new User();
		user1.setFirstName("Ramesh");
		user1.setLastName("Radatare");
		user1.setEmail("ramesh@gmail.com");
		user1.setPassword("secret");
		user1.setLocation(location);
		user1.setOccupation(occupation);
		userRepository.save(user1);

		/*User user2 = new User();
		user2.setFirstName("John");
		user2.setLastName("Cena");
		user2.setEmail("john@gmail.com");
		user2.setPassword("secret");
		user2.setLocation(location);
		user2.setOccupation(occupation);
		userRepository.save(user2);*/
	}
}
