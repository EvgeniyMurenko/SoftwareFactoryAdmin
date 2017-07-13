package com.SoftwareFactoryAdmin.dao;

import com.SoftwareFactoryAdmin.model.FxmComment;
import com.SoftwareFactoryAdmin.model.FxmPost;

import java.util.List;


public interface FxmCommentDao {

    Long create(FxmComment fxmComment);

    FxmComment read(Long id);

    void update(FxmComment fxmComment);

    void delete(FxmComment fxmComment);

    void deleteAllCommentByPost(FxmPost fxmPost);

    List<FxmComment> findAll();

}
