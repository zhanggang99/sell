package com.zg.sell.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "mood")
public class Mood implements Serializable {
    @Id
    private String id;
    private String content;
    private String userId;
    private Integer praiseNum;
    private Date publicTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(Integer praiseNum) {
        this.praiseNum = praiseNum;
    }

    public Date getPublicTime() {
        return publicTime;
    }

    public void setPublicTime(Date publicTime) {
        this.publicTime = publicTime;
    }

    public Mood(String id, String content, String userId, Integer praiseNum, Date publicTime) {
        this.id = id;
        this.content = content;
        this.userId = userId;
        this.praiseNum = praiseNum;
        this.publicTime = publicTime;
    }

    public Mood() {
    }

    @Override
    public String toString() {
        return "Mood{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", userId='" + userId + '\'' +
                ", praiseNum=" + praiseNum +
                ", publicTime=" + publicTime +
                '}';
    }
}
