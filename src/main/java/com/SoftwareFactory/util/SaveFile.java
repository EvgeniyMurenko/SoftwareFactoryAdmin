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
        if (files[0].isEmpty()){
            System.out.println("================NOT FILE ATTACH");
        } else {
            /*String rootPath = System.getProperty("catalina.home");*/
            for (int i = 0; i < this.files.length; i++) {
                MultipartFile file = this.files[i];
                String name = file.getOriginalFilename();
                try {
                    byte[] bytes = file.getBytes();
                    /*String absolutePath = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
                    absolutePath = absolutePath.substring(0, absolutePath.lastIndexOf("/"));*/
                    //String homeDir = System.getProperty("catalina.home");
                    File dir = new File("opt/tomcat/webapps/softwarefactory/"+ getPathForSaveFile());
                    dir.setReadable(true, false);
                    dir.setExecutable(true, false);
                    dir.setWritable(true, false);
                    if (!dir.exists()) {
                        dir.mkdirs();
                        System.out.println("==========CREATE DIR" + dir.getAbsolutePath());
                    }
                    // Create the file on server
                    File serverFile = new File(dir.getAbsolutePath()+"/"+ name);

                    serverFile.setReadable(true, false);
                    serverFile.setExecutable(true, false);
                    serverFile.setWritable(true, false);

                    serverFile.createNewFile();
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
