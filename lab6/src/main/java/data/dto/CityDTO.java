package data.dto;

import java.io.Serializable;


public class CityDTO implements Serializable {
    private Long id;
    private Long countryId;
    private String name;
    private Long population;

    public CityDTO(long id, Long countryId, String name, Long population) {
        this.id = id;
        this.countryId = countryId;
        this.name = name;
        this.population = population;
    }

    public CityDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }
}
