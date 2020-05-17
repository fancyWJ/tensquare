package com.tensquare.recruit.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table(name = "tb_recruit")
@Setter
@Getter
public class Recruit {
    @Id
    private String id;
    private String jobname;
    private String salary;
    private String condition;
    private String education;
    private String type;
    private String address;
    private String eid;
    private Date createtime;
    private String state;
    private  String url;
    private String label;
    private String content1;
    private String content2;
}
