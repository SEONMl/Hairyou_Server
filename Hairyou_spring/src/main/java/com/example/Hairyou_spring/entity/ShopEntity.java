package com.example.Hairyou_spring.entity;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.h2.util.json.JSONArray;
import org.h2.util.json.JSONObject;
import org.h2.util.json.JSONValue;

import javax.persistence.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


@Entity
@Getter
@NoArgsConstructor
@Table(name = "shop")
public class ShopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "shop_name", unique = true)
    private String shopName;
    private String info;
    private String address; // 주소
    private double latitude; // 위도
    private double longitude; // 경도


    @Builder
    public ShopEntity(String shopName, String info, String address, double latitude, double longitude) {
        this.shopName = shopName;
        this.info = info;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

}
