package com.connxun.app.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author：luoxiaosheng
 * @Date：2017-12-01 15:43
 * @Description：二级分类
 */
@Data
@Entity
@Table(name = "cx_category_sub")
public class CxCategorySub implements Serializable {

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
    // optional=true：可选，表示此对象可以没有，可以为null；false表示必须存在
    @ManyToOne(targetEntity = CxCategory.class, fetch = FetchType.EAGER,
            cascade = {CascadeType.REFRESH, CascadeType.MERGE}, optional = true)
    @JoinColumn(name = "parentid")
    private CxCategory cxCategory;

}
