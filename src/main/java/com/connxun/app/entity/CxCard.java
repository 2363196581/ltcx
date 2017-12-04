package com.connxun.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author：luoxiaosheng
 * @Date：2017-11-12 21:51
 * @Description：名片
 */
@Data
@Entity
@Table(name = "cx_card")
public class CxCard implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String cardid;
  private String categoryid;
  private String storeid;
  private String name;
  private String servicemode;
  private String company;
  private String content;
  private String discount;
  private String pic;
  private Long pricemin;
  private Long pricemax;
  private Long price;
  private String isagree;
  private String pname;
  private String cname;
  private String couname;
  private String addr;
  private Long recommendvalue;
//  private String availtime;
  private String state;
  private java.sql.Timestamp createtime;
  private java.sql.Timestamp updatetime;
  private Long delflag;


  @JsonIgnore
  @ManyToOne(targetEntity = CxUser.class, fetch = FetchType.LAZY,
          cascade = {CascadeType.REFRESH, CascadeType.MERGE}, optional = true)
  @JoinColumn(name = "userid")
  private CxUser cxUser;


}
