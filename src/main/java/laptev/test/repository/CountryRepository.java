package laptev.test.repository;

import laptev.test.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    Country getByCountryCode(String countryCode);
}
