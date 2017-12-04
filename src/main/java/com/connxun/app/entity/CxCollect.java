package com.connxun.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author：luoxiaosheng
 * @Date：2017-12-01 20:29
 * @Description：收藏热门
 */
@Data
@Entity
@Table(name = "cx_collect")
public class CxCollect implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonIgnore
  private Long id;
  private String collectid;
  private String userid;
  private String cardid;
  @JsonIgnore
  private String state;
  @JsonIgnore
  private java.sql.Timestamp createtime;
  @JsonIgnore
  private java.sql.Timestamp updatetime;
  @JsonIgnore
  private Long delflag;

}
