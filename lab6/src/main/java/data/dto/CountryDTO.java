package data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


public class CountryDTO implements Serializable {
    private Long id;
    private String name;

    public CountryDTO(long id, String name) {
        this.id=id;
        this.name=name;
    }

    public CountryDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
