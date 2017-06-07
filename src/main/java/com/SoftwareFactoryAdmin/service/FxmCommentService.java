package com.SoftwareFactoryAdmin.service;


import com.SoftwareFactoryAdmin.model.FxmComment;

import java.util.List;

public interface FxmCommentService {

    void addFxmComment(FxmComment fxmComment);

    void updateFxmComment(FxmComment fxmComment);

    void deleteFxmComment(FxmComment fxmComment);

    List<FxmComment> getAllFxmComments();

    FxmComment getFxmCommentById(Long id);

}
