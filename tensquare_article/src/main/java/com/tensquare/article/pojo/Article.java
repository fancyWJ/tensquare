package com.tensquare.article.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_article")
@Setter
@Getter
public class Article implements Serializable {
    @Id
    private String id;
    private String columnid;
    private String userid;
    private String title;
    private String content;
    private String image;
    private Long ispublic;
    private LocalDateTime createtime;
    private LocalDateTime updatetime;
    private String istop;
    private  String visits;
    private  Integer thumbup;
    private  Integer comment;
    private  String state;
    private  String channelid;
    private  String url;
    private  String type;

}
