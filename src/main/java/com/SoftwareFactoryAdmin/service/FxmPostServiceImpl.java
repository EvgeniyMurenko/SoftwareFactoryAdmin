package com.SoftwareFactoryAdmin.service;

import com.SoftwareFactoryAdmin.dao.FxmPostDao;
import com.SoftwareFactoryAdmin.model.FxmPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("fxmPostService")
public class FxmPostServiceImpl implements FxmPostService {


    private FxmPostDao fxmPostDao;

    @Autowired(required = true)
    public void setFxmPostDao(FxmPostDao fxmPostDao) {
        this.fxmPostDao = fxmPostDao;
    }

    @Override
    public void addNewFxmPost(FxmPost fxmPost) {
        fxmPostDao.create(fxmPost);
    }

    @Override
    public void updateFxmPost(FxmPost fxmPost) {
        fxmPostDao.update(fxmPost);
    }

    @Override
    public void deleteFxmPost(FxmPost fxmPost) {
        fxmPostDao.delete(fxmPost);
    }

    @Override
    public List<FxmPost> getAllFxmPosts() {
        return fxmPostDao.findAll();
    }

    @Override
    public FxmPost getFxmPostById(Long id) {
        return fxmPostDao.read(id);
    }

}
