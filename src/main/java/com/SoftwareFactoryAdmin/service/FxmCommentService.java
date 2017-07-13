package com.SoftwareFactoryAdmin.service;


import com.SoftwareFactoryAdmin.model.FxmComment;
import com.SoftwareFactoryAdmin.model.FxmPost;

import java.util.List;

public interface FxmCommentService {

    void addFxmComment(FxmComment fxmComment);

    void updateFxmComment(FxmComment fxmComment);

    void deleteFxmComment(FxmComment fxmComment);

    void deleteAllCommentByPost(FxmPost fxmPost);

    List<FxmComment> getAllFxmComments();

    FxmComment getFxmCommentById(Long id);

}
