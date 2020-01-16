package com.sundy.greendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 项目名称：Himalaya
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-01-14 17:47
 * 描述：
 */
@Entity
public class FavoriteBean {
    @Id(autoincrement = true)//设置自增长
    private Long id;

    @Index(unique = true)//设置唯一性
    private String perNo;//人员编号

    private String name;//人员姓名

    private String sex;//人员姓名

    @Generated(hash = 355599334)
    public FavoriteBean(Long id, String perNo, String name, String sex) {
        this.id = id;
        this.perNo = perNo;
        this.name = name;
        this.sex = sex;
    }

    @Generated(hash = 653294794)
    public FavoriteBean() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPerNo() {
        return this.perNo;
    }

    public void setPerNo(String perNo) {
        this.perNo = perNo;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
