package com.example.REST.entity;


import javax.persistence.*;

@Entity
@Table(name = "t_advertiser")
public class Advertiser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "advertiser_name")
    private String advertiserName;

    @Column(name="phone_number")
    private String phoneNumber;



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

  // public Collection<Company> getCompanies() {
  //      return companies;
  //  }

//    public void setCompanies(Collection<Company> companies) {
//        this.companies = companies;
 //   }

    public Advertiser() {
    }

    public Advertiser(Long id, String advertiser_name, String phone_number) {
        this.id = id;
        this.advertiserName = advertiser_name;
        this.phoneNumber = phone_number;
    }

    public String getAdvertiser_name() {
        return advertiserName;
    }

    public void setAdvertiser_name(String advertiser_name) {
        this.advertiserName = advertiser_name;
    }

    public String getPhone_number() {
        return phoneNumber;
    }

    public void setPhone_number(String phone_number) {
        this.phoneNumber = phone_number;
    }

    @Override
    public String toString() {
        return "Advertiser{" +
                "id=" + id +
                ", advertiser_name='" + advertiserName + '\'' +
                ", phone_number='" + phoneNumber + '\'' +
                '}';
    }
}
