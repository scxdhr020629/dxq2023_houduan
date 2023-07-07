package com.example.testjpa.controller;

import com.example.testjpa.entity.CommentEntity;
import com.example.testjpa.formbean.CommentFormBean;
import com.example.testjpa.result.ResponseData;
import com.example.testjpa.result.ResponseMsg;
import com.example.testjpa.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/findbyNoticeIid")
    public ResponseData findbyNoticeIid(@RequestBody Map<String,Integer> queryExample){
        List<CommentFormBean> ans = commentService.findByNoticeIid(queryExample.get("NoticeIid"));
        if(ans.size()!=0){
            return new ResponseData(ResponseMsg.SUCCESS,ans);
        }
        else{
            return new ResponseData(ResponseMsg.FAILED,null);
        }
    }
    @PostMapping("/add")
    public ResponseData AddComment(@RequestBody Map<String,String> queryExample){
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setNoticeIid(Integer.valueOf(queryExample.get("noticeIid")));
        commentEntity.setUserIid(Integer.valueOf(queryExample.get("userIid")));
        commentEntity.setContent(queryExample.get("Content"));
        commentEntity.setLikeCount(0);
        System.out.println(commentEntity.getContent());
        commentService.AddComment(commentEntity);
        return new ResponseData(ResponseMsg.SUCCESS);
    }
    @PostMapping("/delete")
    public ResponseData DeleteComment(@RequestBody Map<String,Integer> queryExample){
        commentService.DeleteCommentByIid(queryExample.get("Iid"));
        return new ResponseData(ResponseMsg.SUCCESS);
    }
}
