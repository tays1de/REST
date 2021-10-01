package com.example.REST.entity;


import javax.persistence.*;
import javax.validation.constraints.Size;


@Entity
@Table(name = "t_campaigns")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min=1, message = "Название компании не должно быть null")
    private String campaigns_name;

    private String  link_on_photo;

    private String target_countries;

    private String language;

    private String location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "advertiser_id")
    private Advertiser advertisers;

    public Company(){}

    public Company(Long id, String campaigns_name, String link_on_photo,
                   String target_countries, String language, String location, Advertiser advertisers) {
        this.id = id;
        this.campaigns_name = campaigns_name;
        this.link_on_photo = link_on_photo;
        this.target_countries = target_countries;
        this.language = language;
        this.location = location;
        this.advertisers = advertisers;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", campaigns_name='" + campaigns_name + '\'' +
                ", link_on_photo='" + link_on_photo + '\'' +
                ", target_countries='" + target_countries + '\'' +
                ", language='" + language + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCampaigns_name() {
        return campaigns_name;
    }

    public void setCampaigns_name(String campaigns_name) {
        this.campaigns_name = campaigns_name;
    }

    public String getLink_on_photo() {
        return link_on_photo;
    }

    public void setLink_on_photo(String link_on_photo) {
        this.link_on_photo = link_on_photo;
    }

    public String getTarget_countries() {
        return target_countries;
    }

    public void setTarget_countries(String target_countries) {
        this.target_countries = target_countries;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Advertiser getAdvertisers() {
        return advertisers;
    }

    public void setAdvertisers(Advertiser advertisers) {
        this.advertisers = advertisers;
    }
}
