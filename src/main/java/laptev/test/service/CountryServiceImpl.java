package laptev.test.service;

import laptev.test.model.Country;
import laptev.test.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public void create(Country country) {
        countryRepository.save(country);
    }

    @Override
    public List<Country> readAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country read(int id) {
        return countryRepository.getById(id);
    }

    @Override
    public Country read(String code) {
        return countryRepository.getByCountryCode(code);
    }

    @Override
    public boolean update(Country country, int id) {
        if (countryRepository.existsById(id)) {
            country.setId(id);
            countryRepository.save(country);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (countryRepository.existsById(id)) {
            countryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
