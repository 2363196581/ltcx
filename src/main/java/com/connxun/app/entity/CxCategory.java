package com.connxun.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author：luoxiaosheng
 * @Date：2017-11-16 16:02
 * @Description：一级分类
 */

@Data
@Entity
@Table(name = "cx_category")
public class CxCategory implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonIgnore
  private Integer id;
  private String categoryid;
//  private String parentid;
  private String name;
  private String picurl;
  private String centerpicurl;
  @JsonIgnore
  private String state;
  @JsonIgnore
  private java.sql.Timestamp createtime;
  @JsonIgnore
  private java.sql.Timestamp updatetime;
  @JsonIgnore
  private Long delflag;

  @JsonIgnore
  //mappedBy="order": 指明Order类为双向关系维护端，负责外键的更新
  @OneToMany(cascade = CascadeType.ALL, targetEntity = CxCategorySub.class ,
          fetch = FetchType.EAGER, mappedBy = "cxCategory")
  private List<CxCategorySub> cxCategorySubs = new ArrayList<CxCategorySub>();

  /**
   * 添加二级分类
   *
   * @param item 二级分类
   */
  public void addOrderItem(CxCategorySub item) {
    if (!this.cxCategorySubs.contains(item)) {
      this.cxCategorySubs.add(item);
      item.setCxCategory(this);
    }
  }

  /**
   * 删除二级分类
   *
   * @param item 二级分类
   */
  public void removeOrderItem(CxCategorySub item) {
    if (this.cxCategorySubs.contains(item)) {
      item.setCxCategory(null);
      this.cxCategorySubs.remove(item);
    }
  }

}
