package task1;

import lombok.Data;

@Data
public class Address {
    String street;
    String suite;
    String city;
    String zipcode;
    Geo geo;
}
