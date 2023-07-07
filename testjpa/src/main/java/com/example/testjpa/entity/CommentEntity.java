package com.example.testjpa.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "comment", schema = "dxq", catalog = "")
public class CommentEntity {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "iid")
    private int iid;

    @Basic
    @Column(name = "notice_iid")
    private Integer noticeIid;
    @Basic
    @Column(name = "user_iid")
    private Integer userIid;
    @Basic
    @Column(name = "content")
    private String content;
    @Basic
    @Column(name = "like_count")
    private Integer likeCount;

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public Integer getNoticeIid() {
        return noticeIid;
    }

    public void setNoticeIid(Integer noticeIid) {
        this.noticeIid = noticeIid;
    }

    public Integer getUserIid() {
        return userIid;
    }

    public void setUserIid(Integer userIid) {
        this.userIid = userIid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentEntity that = (CommentEntity) o;
        return iid == that.iid && Objects.equals(noticeIid, that.noticeIid) && Objects.equals(userIid, that.userIid) && Objects.equals(content, that.content) && Objects.equals(likeCount, that.likeCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iid, noticeIid, userIid, content, likeCount);
    }

}
