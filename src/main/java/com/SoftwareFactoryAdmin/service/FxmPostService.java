package com.SoftwareFactoryAdmin.service;


import com.SoftwareFactoryAdmin.model.FxmPost;
import com.SoftwareFactoryAdmin.model.Permission;

import java.util.List;

public interface FxmPostService {

    void addNewFxmPost(FxmPost fxmPost);

    void updateFxmPost(FxmPost fxmPost);

    void deleteFxmPost(FxmPost fxmPost);

    List<FxmPost> getAllFxmPosts(Permission permission);

    List<FxmPost> getAllFxmPostsByFilter(String filter);

    FxmPost getFxmPostById(Long id);

}
