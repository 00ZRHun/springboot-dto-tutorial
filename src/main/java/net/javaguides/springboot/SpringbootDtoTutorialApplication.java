package net.javaguides.springboot;

import net.javaguides.springboot.model.BLocation;
import net.javaguides.springboot.model.COccupationCategory;
import net.javaguides.springboot.model.AUser;
import net.javaguides.springboot.repository.BLocationRepository;
import net.javaguides.springboot.repository.COccupationCategoryRepository;
import net.javaguides.springboot.repository.AUserRepository;
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
	private AUserRepository userRepository;

	@Autowired
	private BLocationRepository locationRepository;

	@Autowired
	private COccupationCategoryRepository occupationRepository;

	@Override
	public void run(String... args) throws Exception {

		BLocation location = new BLocation();
		location.setPlace("Prune");
		location.setDescription("Prune is a great place to live");
		location.setLongitude(40.5);
		location.setLatitude(30.6);
		locationRepository.save(location);

		COccupationCategory occupation = new COccupationCategory();
		occupation.setName("Software Engineer");
		occupation.setDescription("develop software system");
		occupationRepository.save(occupation);

		AUser user1 = new AUser();
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
