package com.SoftwareFactoryAdmin.dao;


import com.SoftwareFactoryAdmin.model.FxmPost;
import java.util.List;

public interface FxmPostDao {

    Long create(FxmPost fxmPost);

    FxmPost read(Long id);

    void update(FxmPost fxmPost);

    void delete(FxmPost fxmPost);

    List<FxmPost> findAll();

}
