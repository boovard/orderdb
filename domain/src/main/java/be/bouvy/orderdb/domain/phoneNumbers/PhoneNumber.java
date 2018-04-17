package be.bouvy.orderdb.domain.phoneNumbers;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Pattern;

@Embeddable
public class PhoneNumber {

    @Column(name = "telephoneNumber")
    @Pattern(regexp="(^$|[0-9]{9})")
    private String telephoneNumber;

    @Column(name = "mobileNumber")
    @Pattern(regexp="(^$|[0-9]{10})")
    private String mobileNumber;

    private PhoneNumber() {
    }

    public PhoneNumber(PhoneNumberBuilder phoneNumberBuilder) {
        this.telephoneNumber = phoneNumberBuilder.telephoneNumber;
        this.mobileNumber = phoneNumberBuilder.mobileNumber;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public static class PhoneNumberBuilder{
        private String telephoneNumber;
        private String mobileNumber;

        public static PhoneNumberBuilder phoneNumber(){
            return new PhoneNumberBuilder();
        }

        public PhoneNumber build(){
            return new PhoneNumber(this);
        }

        public PhoneNumberBuilder withTelephoneNumber(String telephoneNumber) {
            this.telephoneNumber = telephoneNumber;
            return this;
        }

        public PhoneNumberBuilder withMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }
    }
}
