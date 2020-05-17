package com.tensquare.friend.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="tb_friend")
@IdClass(Friend.class)
@Setter
@Getter
public class Friend implements Serializable {
    @Id
    private String userid;
    @Id
    private  String friendid;

    private String islike;


}
