package com.tensquare.problem.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "tb_problem")
@Setter
@Getter
public class Problem {
    @Id
    private String id;
    private String title;
    private String content;
    private LocalDateTime updatetime;
    private String userid;
    private String nickname;
    private Long visits;
    private LocalDateTime createtime;
    private Long thumbup;
    private  Long reply;
    private  String solve;
    private  String replyname;
    private LocalDateTime replytime;
}
