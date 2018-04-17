package be.bouvy.orderdb.domain.addresses;

import be.bouvy.orderdb.domain.abstracts.AbstractEntity;
import com.neovisionaries.i18n.CountryCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "post_codes")
public class Location extends AbstractEntity{

    @Column(name = "post_code")
    @Size(min = 4, max = 4, message = "The postcode has to be a 4 digit number")
    private String postCode;

    @Column(name = "city")
    @NotNull(message = "Please provide a city")
    private String city;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Please provide a country")
    private CountryCode country;

    private Location() {
    }

    public Location(LocationBuilder locationBuilder) {
        super(locationBuilder.id);
        this.postCode = locationBuilder.postCode;
        this.city = locationBuilder.city;
        this.country = locationBuilder.country;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getCity() {
        return city;
    }

    public CountryCode getCountry() {
        return country;
    }

    public static class LocationBuilder {
        private String id;
        private String postCode;
        private String city;
        private CountryCode country;

        public static LocationBuilder postCode(){
            return new LocationBuilder();
        }

        public Location build(){
            return new Location(this);
        }

        public LocationBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public LocationBuilder withPostCode(String postCode) {
            this.postCode = postCode;
            return this;
        }

        public LocationBuilder withCity(String city) {
            this.city = city;
            return this;
        }

        public LocationBuilder withCountry(CountryCode country) {
            this.country = country;
            return this;
        }
    }
}
