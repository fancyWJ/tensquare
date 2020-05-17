package com.tensquare.recruit.pojo;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_enterprise")
@Setter
@Getter
public class Enterprise {
    @Id
    private String id;
    private String name;
    private String summary;
    private String address;
    private String labels;
    private String coordinate;
    private String ishot;
    private String logo;
    private Integer jobcount;
    private  String url;

}
