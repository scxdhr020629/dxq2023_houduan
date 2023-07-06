package com.example.testjpa.service.impl;

import com.example.testjpa.entity.NoticeEntity;
import com.example.testjpa.repository.NoticeEntityRepository;
import com.example.testjpa.service.NoticeService;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeEntityRepository noticeEntityRepository;

    @Override
    public List<NoticeEntity> findAllNotice() {
        List<NoticeEntity> rawAns = noticeEntityRepository.findAll();
        return rawAns;
    }
    @Autowired
    public NoticeServiceImpl(NoticeEntityRepository noticeRepository) {
        this.noticeEntityRepository = noticeRepository;
    }

    @Override
    public List<NoticeEntity> getAllNotices() {
        return noticeEntityRepository.findAll();
    }

    @Override
    public NoticeEntity getNoticeById(int iid) {
        Optional<NoticeEntity> optionalNotice = noticeEntityRepository.findById(iid);
        return optionalNotice.orElse(null);
    }

}
