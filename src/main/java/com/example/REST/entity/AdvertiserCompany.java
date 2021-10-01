package com.example.REST.entity;


import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "t_advertiser_company")
public class AdvertiserCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min=1, message = "Название компании не должно быть null")
    private String link_for_presentation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "advertiser_id")
    private Advertiser advertisers;

    public AdvertiserCompany(){

    }

    public AdvertiserCompany(Long id, String link_for_presentation, Advertiser advertisers) {
        this.id = id;
        this.link_for_presentation = link_for_presentation;
        this.advertisers = advertisers;
    }

    @Override
    public String toString() {
        return "AdvertiserCompany{" +
                "id=" + id +
                ", link_for_presentation='" + link_for_presentation + '\'' +
                ", advertisers=" + advertisers +
                '}';
    }

    public Advertiser getAdvertisers() {
        return advertisers;
    }

    public void setAdvertisers(Advertiser advertisers) {
        this.advertisers = advertisers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink_for_presentation() {
        return link_for_presentation;
    }

    public void setLink_for_presentation(String link_for_presentation) {
        this.link_for_presentation = link_for_presentation;
    }
}
