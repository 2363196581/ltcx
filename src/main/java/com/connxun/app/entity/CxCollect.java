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
 * @Date：2017-12-01 20:29
 * @Description：收藏热门
 */
@Data
@Entity
@Table(name = "cx_collect")
@JsonIgnoreProperties(ignoreUnknown = true)
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
  @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
  @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
  private Date createtime;
  @JsonIgnore
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
}
