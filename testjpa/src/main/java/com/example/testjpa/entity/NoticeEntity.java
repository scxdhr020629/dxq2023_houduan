package com.example.testjpa.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "notice", schema = "dxq", catalog = "")
public class NoticeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "iid")
    private int iid;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "content")
    private String content;
    @Basic
    @Column(name = "pubdate")
    private Date pubdate;
    @Basic
    @Column(name = "imgurl")
    private String imgurl;

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoticeEntity that = (NoticeEntity) o;
        return iid == that.iid && Objects.equals(title, that.title) && Objects.equals(content, that.content) && Objects.equals(pubdate, that.pubdate) && Objects.equals(imgurl, that.imgurl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iid, title, content, pubdate, imgurl);
    }
}
