package com.tensquare.base.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_label")
public class Label implements Serializable {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "labelname")
    private String labelname; //标签名称
    @Column(name = "state")
    private String state; //状态
    @Column(name = "count")
    private Long count; //使用数量
    @Column(name = "recommend")
    private String recommend; //是否推荐
    @Column(name = "fans")
    private Long fans; //关注数
}
