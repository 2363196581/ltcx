package com.connxun.app.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
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
  private Long id;
  private String userid;
  private String name;
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
  private java.sql.Timestamp createtime;
  private java.sql.Timestamp updatetime;
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



  //mappedBy="order": 指明Order类为双向关系维护端，负责外键的更新
  @OneToMany(cascade = CascadeType.ALL, targetEntity = CxCard.class ,
          fetch = FetchType.EAGER, mappedBy = "cxUser")
  private List<CxCard> cards = new ArrayList<CxCard>();

}
