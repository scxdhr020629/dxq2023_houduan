package com.example.testjpa.service;

import com.example.testjpa.entity.CommentEntity;
import com.example.testjpa.formbean.CommentFormBean;

import java.util.List;

public interface CommentService {
    public List<CommentFormBean> findByNoticeIid(Integer userIid);
    public void DeleteCommentByIid(Integer Iid);

    void AddComment(CommentEntity commentEntity);
}
