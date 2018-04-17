package be.bouvy.orderdb.domain.customers;

import be.bouvy.orderdb.domain.abstracts.AbstractEntity;
import be.bouvy.orderdb.domain.addresses.Address;
import be.bouvy.orderdb.domain.emailAddresses.EmailAddress;
import be.bouvy.orderdb.domain.phoneNumbers.PhoneNumber;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer extends AbstractEntity{

    @Column(name = "first_name")
    @NotNull(message = "Please provide a first name")
    private String firstName;

    @Column(name = "last_name")
    @NotNull(message = "Please provide a last name")
    private String lastName;

    @Embedded
    @NotNull(message = "Please provide an email address")
    private EmailAddress emailAddress;

    @Embedded
    @NotNull(message = "Please provide an address")
    private Address address;

    @Embedded
    private List<@NotEmpty PhoneNumber> phoneNumbers;

    public Customer() {
    }

    public Customer(CustomerBuilder customerBuilder) {
        super(customerBuilder.id);
        this.firstName = customerBuilder.firstName;
        this.lastName = customerBuilder.lastName;
        this.emailAddress = customerBuilder.emailAddress;
        this.address = customerBuilder.address;
        this.phoneNumbers = customerBuilder.phoneNumbers;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public EmailAddress getEmailAddress() {
        return emailAddress;
    }

    public Address getAddress() {
        return address;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public static class CustomerBuilder{
        private String id;
        private String firstName;
        private String lastName;
        private EmailAddress emailAddress;
        private Address address;
        private List<PhoneNumber> phoneNumbers;

        public static CustomerBuilder customer(){
            return new CustomerBuilder();
        }

        public Customer build(){
            return new Customer(this);

        }

        public CustomerBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public CustomerBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public CustomerBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public CustomerBuilder withEmailAddress(EmailAddress emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public CustomerBuilder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public CustomerBuilder withPhoneNumbers(List<PhoneNumber> phoneNumbers) {
            this.phoneNumbers = phoneNumbers;
            return this;
        }
    }
}
