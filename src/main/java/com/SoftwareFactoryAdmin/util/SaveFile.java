package com.SoftwareFactoryAdmin.util;

import com.SoftwareFactoryAdmin.constant.GlobalEnum;
import com.SoftwareFactoryAdmin.constant.MainPathEnum;
import com.SoftwareFactoryAdmin.model.Notice;
import com.SoftwareFactoryAdmin.model.NoticeLink;
import org.springframework.web.multipart.MultipartFile;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class SaveFile {

    private String pathForSaveFile;
    private MultipartFile[] files;

    public SaveFile() {
    }

    public SaveFile(MultipartFile[] files) {
        this.files = files;
    }


    public void saveNoticeFilesToNotice(Notice notice) {

        pathForSaveFile = MainPathEnum.mainPath + "/notice/";

        Set<NoticeLink> noticeLinks = notice.getNoticeLinks();


        for (int i = 0; i < this.files.length; i++) {
            MultipartFile file = this.files[i];

            try {
                String name = file.getOriginalFilename();
                String generatedName = generateUUIDname(name);
                String link = GlobalEnum.webRoot + "/get-file/notice/" + generatedName;
                saveFile(generatedName, file);
                NoticeLink noticeLink = new NoticeLink(notice, link, name , generatedName);
                noticeLinks.add(noticeLink);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveFile(String name, MultipartFile file) throws IOException {

        byte[] bytes = file.getBytes();
        File directory = new File(this.pathForSaveFile);
        directory.setReadable(true, false);
        directory.setExecutable(true, false);
        directory.setWritable(true, false);
        if (!directory.exists()) {
            directory.mkdirs();
            System.out.println("==========CREATE DIR" + directory.getAbsolutePath());
        }
        // Create the file on server
        File serverFile = new File(directory.getAbsolutePath() + "/" + name);

        serverFile.setReadable(true, false);
        serverFile.setExecutable(true, false);
        serverFile.setWritable(true, false);

        serverFile.createNewFile();
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
        stream.write(bytes);
        stream.close();
    }


    private String generateUUIDname(String originalFileName) {

        String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
        String generatedUUIDname = (java.util.UUID.randomUUID() + fileExtension);
        return generatedUUIDname;

    }

}

    /*    public void saveVideoFile() {


        String[] extensions = {".mp4", ".avi"};

        for (int i = 0; i < this.files.length; i++) {

            MultipartFile file = this.files[i];
            String name = file.getOriginalFilename();
            String fileExtension = name.substring(name.lastIndexOf('.'), name.length());

            for (String extension : extensions) {
                if (extension.equals(fileExtension)) {
                    saveFile(name, file);
                    System.out.println(name);
                }
            }
        }
    }*/

