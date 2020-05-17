package com.tensquare.user.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_user")
@Getter
@Setter
public class User {
    @Id
    private String id;
    private String mobile;
    private String password;
    private String nickname;
    private String sex;
    private LocalDateTime birthday;
    private LocalDateTime regdate;
    private LocalDateTime updatedate;
    private LocalDateTime lastdate;
    private String avatar;
    private String email;
    private String interest;
    private String personality;
    private Long online;
    private Integer fanscount;
    private Integer followcount;
}
