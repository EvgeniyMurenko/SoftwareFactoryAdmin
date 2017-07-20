package com.SoftwareFactoryAdmin.util;

import com.SoftwareFactoryAdmin.constant.MainPathEnum;
import com.SoftwareFactoryAdmin.dto.PostDTO;
import com.SoftwareFactoryAdmin.model.FxmPost;

import java.io.File;
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
        return this.videoList;
    }

    public List<String> getImageList() {
        return this.imageList;
    }

    public List<String> getFileList() {
        return this.fileList;
    }

    public FxmPost getFxmPost() {
        return this.fxmPost;
    }

    public void compareFilesFromDtoAndMakeChanges(PostDTO postDTO) {

        List<String> dtoFiles = parserPathFile(postDTO.getLinksFile());
        List<String> dtoImages = parserPathFile(postDTO.getLinksImage());
        List<String> dtoVideos = parserPathFile(postDTO.getLinksVideo());

        for (String dtoFileName : dtoFiles) {
            for (String file : fileList) {
                if (dtoFileName.equals(file)) break;
            }
            deleteFileByName(dtoFileName);
        }
        for (String dtoImageName : dtoImages) {
            for (String file : fileList) {
                if (dtoImageName.equals(file)) break;
            }
            deleteFileByName(dtoImageName);
        }
        for (String dtoVideoName : dtoVideos) {
            for (String file : fileList) {
                if (dtoVideoName.equals(file)) break;
            }
            deleteFileByName(dtoVideoName);
        }

        fxmPost.setLinksFile(savePath(dtoFiles));
        fxmPost.setLinksImage(savePath(dtoImages));
        fxmPost.setLinksVideo(savePath(dtoVideos));

    }

    public void deleteFile(String fileName) {
        int index = -1;
        if (this.imageList.indexOf(fileName) > -1) {
            index = this.imageList.indexOf(fileName);
            this.imageList.set(index, "");
            this.fxmPost.setLinksImage(savePath(this.imageList));
        }

        if (this.videoList.indexOf(fileName) > -1) {
            index = this.videoList.indexOf(fileName);
            this.videoList.set(index, "");
            this.fxmPost.setLinksImage(savePath(this.videoList));
        }

        if (this.fileList.indexOf(fileName) > -1) {
            index = this.fileList.indexOf(fileName);
            this.fileList.set(index, "");
            this.fxmPost.setLinksImage(savePath(this.fileList));
        }

        if (index > -1) {
            File file = new File(MainPathEnum.mainPath + "/post/" + fileName);
            file.delete();
        }
    }

    public void deleteAllFileFromPost() {
        if (this.imageList.size() > 0) {
            for (String fileName : this.imageList) {
                deleteFileByName(fileName);
            }
        }
        System.out.println();
        if (this.videoList.size() > 0) {
            for (String fileName : this.videoList) {
                deleteFileByName(fileName);
            }
        }

        if (this.fileList.size() > 0) {
            for (String fileName : this.fileList) {
                deleteFileByName(fileName);
            }
        }
    }

    private String savePath(List<String> fileList) {
        String newFilePath = "";
        for (String strinfPath : fileList) {
            if (strinfPath != null && !"".equals(strinfPath)) {
                newFilePath += strinfPath + ";#";
            }
        }
        return newFilePath;
    }

    private List<String> parserPathFile(String path) {
        if (path != null && !"".equals(path)) {
            String[] pathArr = path.split(";#");
            List<String> pathList = new ArrayList(Arrays.asList(pathArr));
            return pathList;
        }
        return new ArrayList<>();
    }

    private void deleteFileByName(String fileName) {
        String filePath = MainPathEnum.mainPath + "/post/" + fileName;
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
    }
}
