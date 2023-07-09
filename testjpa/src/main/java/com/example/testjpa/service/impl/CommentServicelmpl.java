package com.example.testjpa.service.impl;

import com.example.testjpa.entity.CommentEntity;
import com.example.testjpa.entity.UserInfoEntity;
import com.example.testjpa.formbean.CommentFormBean;
import com.example.testjpa.repository.CommentEntityRepository;
import com.example.testjpa.repository.UserInfoEntityRepository;
import com.example.testjpa.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CommentServicelmpl implements CommentService {
    private final CommentEntityRepository commentEntityRepository;
    private final UserInfoEntityRepository userInfoEntityRepository;

    public CommentServicelmpl(CommentEntityRepository commentEntityRepository, UserInfoEntityRepository userInfoEntityRepository) {
        this.commentEntityRepository = commentEntityRepository;
        this.userInfoEntityRepository = userInfoEntityRepository;
    }

    @Override
    public List<CommentFormBean> findByNoticeIid(Integer Iid) {
        List<CommentFormBean> finalAns = new ArrayList<>();
        List<CommentEntity> oldans = commentEntityRepository.findAllByNoticeIid(Iid);
        for(CommentEntity commentEntity : oldans){
            UserInfoEntity userInfoEntity = userInfoEntityRepository.findUserInfoEntityByIid(commentEntity.getUserIid());
            CommentFormBean commentFormBean = new CommentFormBean();
            commentFormBean.setUserRealName(userInfoEntity.getUserRealName());
            // test
            commentFormBean.setIid(commentEntity.getIid());
            commentFormBean.setContent(commentEntity.getContent());
            commentFormBean.setLike(commentEntity.getLikeCount());
            finalAns.add(commentFormBean);
        }
        return finalAns;
    }

    public void DeleteCommentByIid(Integer Iid) {
        commentEntityRepository.deleteById(Iid);
    }

    public void AddComment(CommentEntity commentEntity) {
        commentEntityRepository.save(commentEntity);
    }
}
