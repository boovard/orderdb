package be.bouvy.orderdb.domain.emailAddresses;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Email;

@Embeddable
public class EmailAddress {

    @Column(name = "email_address")
    @Email (message = "Please provide a valid email address")
    private String emailAddress;

    private EmailAddress() {
    }

    public EmailAddress(EmailAddressBuilder emailAddressBuilder) {
        this.emailAddress = emailAddressBuilder.emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public static class EmailAddressBuilder{
        private String emailAddress;

        public static EmailAddressBuilder emailAddress(){
            return new EmailAddressBuilder();
        }

        public EmailAddress build(){
            return new EmailAddress(this);
        }

        public EmailAddressBuilder withEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }
    }
}
