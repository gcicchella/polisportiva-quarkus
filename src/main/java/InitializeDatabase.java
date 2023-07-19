import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.example.Model.*;
import org.example.Repository.SportFacilityRepository;
import org.example.Repository.SportFieldRepository;
import org.example.Repository.UserRepository;

@ApplicationScoped
public class InitializeDatabase {

    @Inject
    UserRepository userRepository;

    @Inject
    SportFacilityRepository sportsFacilityRepository;

    @Inject
    SportFieldRepository sportsFieldRepository;

    @Transactional
    void onStart(@Observes StartupEvent ev) {
        User user = new User();
        user.setUsername("onfire");
        user.setPassword("onfire");
        user.setFirstName("Giuseppe");
        user.setLastName("Cicchella");
        user.setFiscalCode("GCCPEP98C23E271S");
        user.setEmail("g.cicchella@studenti.unina.it");

        Address address = new Address();
        address.setState("Italia");
        address.setCity("Acerra");
        address.setStreetName("Via Armando Diaz");
        address.setStreetNumber("32");
        address.setPostcode("80011");

        user.setAddress(address);

        SportFacility sportsFacility = new SportFacility();
        sportsFacility.setName("Barcelona Club");
        sportsFacility.setTotalSportsFields(2);
        sportsFacility.setPhone("789456123");
        sportsFacility.setUser(user);

        Address addressSportFacility = new Address();
        addressSportFacility.setState("Spagna");
        addressSportFacility.setCity("Barcellona");
        addressSportFacility.setStreetName("Rambla");
        addressSportFacility.setStreetNumber("0");
        addressSportFacility.setPostcode("60");

        sportsFacility.setAddress(addressSportFacility);

        SportField sportsField = new SportField();
        sportsField.setName("Barcelona Field");
        sportsField.setSport("volleball");
        sportsField.setIsIndoor(true);
        sportsField.setSportsFacility(sportsFacility);
        sportsField.setUser(user);

        PriceList priceList = new PriceList();
        priceList.setPricePerHour(10.0);

        sportsField.setPriceList(priceList);

        userRepository.persist(user);
        sportsFacilityRepository.persist(sportsFacility);
        sportsFieldRepository.persist(sportsField);
    }
}

