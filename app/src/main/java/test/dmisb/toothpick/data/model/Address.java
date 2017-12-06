package test.dmisb.toothpick.data.model;

import android.text.TextUtils;

public class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    public String getStreet() {
        return street;
    }

    public String getSuite() {
        return suite;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public Geo getGeo() {
        return geo;
    }

    public String getFullAddress() {
        StringBuilder builder = new StringBuilder("");
        if (!TextUtils.isEmpty(zipcode))
            builder.append(zipcode);
        if (!TextUtils.isEmpty(city))
            builder.append(", ").append(city);
        if (!TextUtils.isEmpty(street))
            builder.append(", ").append(street);
        if (!TextUtils.isEmpty(suite))
            builder.append(", ").append(suite);
        return builder.toString();
    }
}
