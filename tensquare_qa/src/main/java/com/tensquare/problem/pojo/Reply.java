package com.tensquare.problem.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "reply")
@Setter
@Getter
public class Reply {
    @Id
    private String id;
    private String problemid;
    private String content;
    private LocalDateTime updatetime;
    private String userid;
    private String nickname;
    private LocalDateTime createtime;
}
