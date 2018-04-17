package be.bouvy.orderdb.domain.addresses;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Embeddable
public class Address {

    @Column(name = "street_name")
    @NotNull(message = "Please provide a street")
    private String streetName;

    @Column(name = "house_number")
    @NotNull(message = "Please provide a house number")
    private String houseNumber;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_post_code_id")
    @NotNull(message = "Please provide a post code")
    private Location location;

    private Address() {
    }

    public Address(AddressBuilder addressBuilder) {
        this.streetName = addressBuilder.streetName;
        this.houseNumber = addressBuilder.houseNumber;
        this.location = addressBuilder.location;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public Location getLocation() {
        return location;
    }

    public static class AddressBuilder{
        private String streetName;
        private String houseNumber;
        private Location location;

        public static AddressBuilder address(){
            return new AddressBuilder();
        }

        public Address build(){
            return new Address(this);
        }

        public AddressBuilder withStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public AddressBuilder withHouseNumber(String houseNumber) {
            this.houseNumber = houseNumber;
            return this;
        }

        public AddressBuilder withPostCode(Location location) {
            this.location = location;
            return this;
        }
    }
}
