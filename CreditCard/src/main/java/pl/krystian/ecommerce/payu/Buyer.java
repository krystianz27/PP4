package pl.krystian.ecommerce.payu;

public class Buyer {
    String email;
    String phone;
    String firstName;
    String lastName;
    String language;

    public Buyer setEmail(String email) {
        this.email = email;
        return this;
    }

    public Buyer setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Buyer setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Buyer setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Buyer setLanguage(String language) {
        this.language = language;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLanguage() {
        return language;
    }
}
