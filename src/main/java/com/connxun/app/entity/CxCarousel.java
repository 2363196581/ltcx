package com.connxun.app.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author：luoxiaosheng
 * @Date：2017-12-01 15:43
 * @Description：轮播图
 */

@Data
@Entity
@Table(name = "cx_carousel")
public class CxCarousel implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonIgnore
  private Long id;
  private String carouselid;
  private String picurl;
  private String href;
  private String intervaltime;
  @JsonIgnore
  private String state;
  private Long carousevalue;
  @JsonIgnore
  private String type;
  @JsonIgnore
  private java.sql.Timestamp starttime;
  @JsonIgnore
  private java.sql.Timestamp endtime;
  @JsonIgnore
  private java.sql.Timestamp createtime;
  @JsonIgnore
  private java.sql.Timestamp updatetime;
  @JsonIgnore
  private Long delflag;

}
