package com.SoftwareFactoryAdmin.service;

import com.SoftwareFactoryAdmin.dao.FxmPostDao;
import com.SoftwareFactoryAdmin.model.FxmPost;
import com.SoftwareFactoryAdmin.model.Permission;
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
    public List<FxmPost> getAllFxmPosts(Permission permission) {
        String leader="false";
        String member="false";
        String staff="false";

        if (permission.getLeaderGroup()) leader = "leader";
        if (permission.getMemberGroup()) member = "member";
        if (permission.getStaffGroup()) staff = "staff";

        return fxmPostDao.findAll(member, leader, staff);
    }

    @Override
    public List<FxmPost> getAllFxmPostsByFilter(String filter) {
        return fxmPostDao.findAllByFilter(filter);
    }

    @Override
    public FxmPost getFxmPostById(Long id) {
        return fxmPostDao.read(id);
    }

}
