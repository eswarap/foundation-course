package org.woven.foundation.course.codechef;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.java.Log;

@Getter
@Log
@ToString
public class Address {
    String street;
    String city;
    String postalCode;

    public Address(String street, String city, String postalCode) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
    }

    void displayAddress() {
       log.info("Street: " + street + ", City: " + city + ", Postal Code: " + postalCode);
    }
}
