package com.SoftwareFactoryAdmin.util;

import com.SoftwareFactoryAdmin.model.FxmPost;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FxmPostFile {

    private List<String> videoList;
    private List<String> imageList;
    private List<String> fileList;
    private FxmPost fxmPost;

    public FxmPostFile(FxmPost fxmPost) {
        this.fxmPost = fxmPost;
        this.videoList = parserPathFile(fxmPost.getLinksVideo());
        this.imageList = parserPathFile(fxmPost.getLinksImage());
        this.fileList = parserPathFile(fxmPost.getLinksFile());

    }

    public List<String> getVideoList() {
        return videoList;
    }

    public List<String> getImageList() {
        return imageList;
    }

    public List<String> getFileList() {
        return fileList;
    }

    public FxmPost getFxmPost() {
        return fxmPost;
    }

    private List<String> parserPathFile(String path){
        if (path != null) {
            String[] pathArr = path.split(";#");
            List<String> pathList = Arrays.asList(pathArr);
            return pathList;
        }
        return new ArrayList<>();
    }
}
