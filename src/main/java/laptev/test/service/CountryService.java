package laptev.test.service;

import laptev.test.model.Country;

import java.util.List;

public interface CountryService {
    void create(Country country);

    List<Country> readAll();

    Country read(int id);

    Country read(String code);

    boolean update(Country country, int id);

    boolean delete(int id);
}
