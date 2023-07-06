package com.example.testjpa.service;

import com.example.testjpa.entity.NoticeEntity;

import java.util.List;

public interface NoticeService {
    List<NoticeEntity> findAllNotice();
    List<NoticeEntity> getAllNotices();

    NoticeEntity getNoticeById(int iid);
}
