package com.example.REST.entity;


import javax.persistence.*;

@Entity
@Table(name = "t_advertiser")
public class Advertiser  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String advertiser_name;

    private String  phone_number;

    public Advertiser(){
    }

    public Advertiser(long id, String advertiser_name,String phone_number){
        this.id=id;
        this.advertiser_name=advertiser_name;
        this.phone_number=phone_number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAdvertiser_name() {
        return advertiser_name;
    }

    public void setAdvertiser_name(String advertiser_name) {
        this.advertiser_name = advertiser_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "Advertiser{" +
                "id=" + id +
                ", advertiser_name='" + advertiser_name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }
}
