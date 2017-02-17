package com.SoftwareFactory.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by adm on 2/13/2017.
 */
public class SaveFile {
    private String pathForSaveFile;
    private MultipartFile[] files;

    public SaveFile() {
    }

    public SaveFile(String pathForSaveFile, MultipartFile[] files) {
        this.pathForSaveFile = pathForSaveFile;
        this.files = files;
    }

    public void saveFile(){
        System.out.println("============SAVE FILE=============");
        //===================================================
        if (this.files.length == 0){
            System.out.println("================NOT FILE ATTACH");
        } else {
            String rootPath = System.getProperty("catalina.home");
            for (int i = 0; i < this.files.length; i++) {
                MultipartFile file = this.files[i];
                String name = file.getOriginalFilename();
                try {
                    byte[] bytes = file.getBytes();
                    File dir = new File(rootPath + getPathForSaveFile());
                    if (!dir.exists()) {
                        dir.mkdirs();
                        System.out.println("==========CREATE DIR" + dir.getAbsolutePath());
                    }
                    // Create the file on server
                    File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                    stream.write(bytes);
                    stream.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public String getPathForSaveFile() {
        return pathForSaveFile;
    }

    public void setPathForSaveFile(String pathForSaveFile) {
        this.pathForSaveFile = pathForSaveFile;
    }

    public MultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }
}
