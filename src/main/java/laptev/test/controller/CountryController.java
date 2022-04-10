package laptev.test.controller;

import laptev.test.model.Country;
import laptev.test.model.Route;
import laptev.test.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    //
    // Не сделал построение маршрута
    //

    @GetMapping(value = "/countries/routing/{from}/{to}")
    public ResponseEntity<List<String>> routing(@PathVariable(name = "from") String codeFrom,
                                                @PathVariable(name = "to") String codeTo) {
        Country countryFrom = countryService.read(codeFrom);
        Country countryTo = countryService.read(codeTo);

        Route route = new Route(countryFrom, countryTo);

        List<String> str = route.routing(countryService);

        return new ResponseEntity<>(str, HttpStatus.OK);
    }

    @PostMapping(value = "/countries/create")
    public ResponseEntity<?> create(@RequestBody Country country) {
        countryService.create(country);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/countries/read")
    public ResponseEntity<List<Country>> read() {
        final List<Country> countries = countryService.readAll();

        return countries != null && !countries.isEmpty()
                ? new ResponseEntity<>(countries, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/countries/read/{id}")
    public ResponseEntity<Country> read(@PathVariable(name = "id") int id) {
        final Country country = countryService.read(id);

        return country != null
                ? new ResponseEntity<>(country, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/countries/update/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Country country) {
        final boolean updated = countryService.update(country, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "countries/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = countryService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
