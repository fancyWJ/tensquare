package com.tensquare.base.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tb_label")
@Setter
@Getter
public class Label implements Serializable {
    @Id
    private String id;
    private String labelname;
    private String state;
    private Long count;
    private String recommend;

}
