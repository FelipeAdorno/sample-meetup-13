package br.com.meetup.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RepositoryTest implements ApplicationRunner {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {

        countryRepository.save(createCountry("Brazil", "São Paulo", 11111));
        countryRepository.save(createCountry("EUA", "New York", 22222));
        countryRepository.save(createCountry("Russian", "Moscow", 33333));

        Country brazil = countryRepository.findOne(1L);
        System.err.println("========== FIND ONE ============");
        System.err.println(brazil);

        System.err.println("========== FIND ALL ============");
        List<Country> countries = countryRepository.findAll();
        countries.forEach(System.err::println);

        System.err.println("========== FIND PAGINATION ============");
        Page<Country> page = countryRepository.findAll(new PageRequest(0, 1));
        System.err.println("TOTAL DE ELEMENTOS " + page.getTotalElements());
        System.err.println("TOTAL DE PAGINAS " + page.getTotalPages());
        System.err.println("PAGINA ATUAL " + page.getNumber());
        System.err.println("QUANTIDADE POR PAGINA " + page.getSize());
        page.forEach(System.err::println);

        System.err.println("========== SORT ============");
        List<Country> countrySorted = countryRepository.findAll(new Sort(Sort.Direction.DESC, "name"));
        countrySorted.forEach(System.err::println);


        Country russian = countryRepository.findByName("Russian");
        System.err.println("========== FIND BY NAME ============");
        System.err.println(russian);

    }

    private Country createCountry(String name, String mainCity, Integer population) {
        Country country = new Country();
        country.setName(name);
        country.setMainCity(mainCity);
        country.setPeople(population);
        return country;
    }
}
