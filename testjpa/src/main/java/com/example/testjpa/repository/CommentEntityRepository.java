package com.example.testjpa.repository;

import com.example.testjpa.entity.CommentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentEntityRepository extends CrudRepository<CommentEntity,Integer> {
    List<CommentEntity> findAllByNoticeIid(Integer noticeIid);

}
