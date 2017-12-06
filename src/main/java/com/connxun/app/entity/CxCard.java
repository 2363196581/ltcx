package com.connxun.app.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author：luoxiaosheng
 * @Date：2017-11-12 21:51
 * @Description：名片
 */
@Data
@Entity
@Table(name = "cx_card")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CxCard implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonIgnore
  private Long id;
  private String cardid;
//  private String userid;
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
  @JsonFormat(pattern = "##.00")
  private Long price;
  private String isagree;
  private String pname;
  private String cname;
  private String couname;
  private String addr;
  private Long recommendvalue;
//  private String availtime;
  private String state;
  @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
  @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
  private Date createtime;
  @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
  @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
  private Date updatetime;
  @JsonIgnore
  private Long delflag;


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


  @ManyToOne(targetEntity = CxUser.class, fetch = FetchType.EAGER,
          cascade = {CascadeType.REFRESH, CascadeType.MERGE}, optional = true)
  @JoinColumn(name = "userid")
  private CxUser cxUser;



}
