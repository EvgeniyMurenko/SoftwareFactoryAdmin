package com.SoftwareFactoryAdmin.service;

import com.SoftwareFactoryAdmin.dao.FxmCommentDao;
import com.SoftwareFactoryAdmin.model.FxmComment;
import com.SoftwareFactoryAdmin.model.FxmPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("fxmCommentService")
public class FxmCommentServiceImpl implements FxmCommentService {

    private FxmCommentDao fxmCommentDao;

    @Autowired(required = true)
    public void setFxmCommentDao(FxmCommentDao fxmCommentDao) {
        this.fxmCommentDao = fxmCommentDao;
    }


    @Override
    public void addFxmComment(FxmComment fxmComment) {
        fxmCommentDao.create(fxmComment);
    }

    @Override
    public void updateFxmComment(FxmComment fxmComment) {
        fxmCommentDao.update(fxmComment);
    }

    @Override
    public void deleteFxmComment(FxmComment fxmComment) {
        fxmCommentDao.delete(fxmComment);
    }

    @Override
    public void deleteAllCommentByPost(FxmPost fxmPost) {
        fxmCommentDao.deleteAllCommentByPost(fxmPost);
    }

    @Override
    public List<FxmComment> getAllFxmComments() {
        return fxmCommentDao.findAll();
    }

    @Override
    public FxmComment getFxmCommentById(Long id) {
        return fxmCommentDao.read(id);
    }


}
