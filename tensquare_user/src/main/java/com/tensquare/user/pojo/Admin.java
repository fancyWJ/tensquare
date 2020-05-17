package com.tensquare.user.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_admin")
@Getter
@Setter
public class Admin {
    @Id
    private String id;
    private String loginname;
    private String password;
    private String state;


}
