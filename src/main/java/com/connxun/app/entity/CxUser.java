package com.connxun.app.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @Author：luoxiaosheng
 * @Date：2017-11-11 14:22
 * @Description：用户
 */
@Data
@Entity
@Table(name = "cx_user")
public class CxUser implements Serializable{

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonIgnore
  private Long id;
  private String userid;
  private String name;
  @JsonIgnore
  private String password;
  private String sex;
  private String creditcard;
  private String identitycard;
  private String email;
  private String phone;
  private String tel;
  private String address;
  private String token;
  private String qq;
  private String headpic;
  // 0 QQ登陆 1微信登陆  2新浪微博登陆  3账号登录
  private String type;
  private String sinaid;
  private String wxid;
  private String qqid;
  private String qwspic;
  // 用户类型 0买家 1卖家 2管理员
  private String usertype;
  private String state;
  @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
  @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
  private Date createtime;
  @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
  @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
  private Date updatetime;
  private Long delflag;
  private String idcardpicfront;
  private String idcardpicback;
  private String qqaccount;
  private String wxaccount;
  private String sinaaccount;
  private String alipayaccount;
  private String certifystate;
  private String credentialnum;
  private String licensepic;

  /**
   * 新增时执行的函数
   */
  @PrePersist
  void preInsert() {
    if (createtime == null) {
      createtime = new Date();
    }
    if (updatetime == null) {
      updatetime = new Date();
    }
  }

  /**
   * 修改时执行的函数
   */
  @PreUpdate
  void preUpdate() {
    if (updatetime == null) {
      updatetime = new Date();
    }
  }


  @JsonIgnore
  //mappedBy="order": 指明Order类为双向关系维护端，负责外键的更新
  @OneToMany(targetEntity = CxCard.class ,fetch = FetchType.LAZY,
          cascade = CascadeType.ALL, mappedBy = "cxUser")
  private List<CxCard> cards = new ArrayList<CxCard>();

  @JsonIgnore
  //mappedBy="order": 指明Order类为双向关系维护端，负责外键的更新
  @OneToMany(targetEntity = CxStore.class ,fetch = FetchType.LAZY,
          cascade = CascadeType.ALL, mappedBy = "cxUser")
  private List<CxStore> cxStores = new ArrayList<CxStore>();

}
