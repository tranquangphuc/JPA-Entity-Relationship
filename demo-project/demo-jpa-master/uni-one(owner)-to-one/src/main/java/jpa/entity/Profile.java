package jpa.entity;

import javax.persistence.*;

@Entity
public class Profile {

    @Id
    @Column(name = "customer_id")
    private long customerId;

    @Column(name = "street_number")
    private String streetNumber;

    @Column(name = "street_name")
    private String streetName;

    private String district;

    private String city;

    @MapsId
    @OneToOne
    private Customer customer;

    public long getCustomerId() {
        return customerId;
    }

    //region Getters and Setters
    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    //endregion

    @Override
    public String toString() {
        return "Profile{" +
                "customerId=" + customerId +
                ", streetNumber='" + streetNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
