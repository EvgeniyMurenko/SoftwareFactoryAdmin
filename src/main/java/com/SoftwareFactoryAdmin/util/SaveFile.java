package com.SoftwareFactoryAdmin.util;

import com.SoftwareFactoryAdmin.constant.GlobalEnum;
import com.SoftwareFactoryAdmin.constant.MainPathEnum;
import com.SoftwareFactoryAdmin.model.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class SaveFile {

    private String pathForSaveFile;
    private MultipartFile[] files;

    private List<String> imageExpansion = Arrays.asList("img", "png", "jpg", "bmp");
    private List<String> videoExpansion = Arrays.asList("mp4");


    public SaveFile(MultipartFile[] files) {
        if (files.length > 0) {
            this.files = files;
        } else {
            this.files = new MultipartFile[0];
        }
    }


    public void saveNoticeFilesToNotice(Notice notice) {

        if (files.length < 1) return;
        if (files[0].isEmpty()) return;


        pathForSaveFile = MainPathEnum.mainPath + "/notice/";

        Set<NoticeLink> noticeLinks = notice.getNoticeLinks();

        for (MultipartFile file : this.files) {
            try {
                String name = file.getOriginalFilename();
                String generatedName = generateUUIDname(name);
                String link = GlobalEnum.webRoot + "/get-file/notice/" + generatedName;
                saveFile(generatedName, file);
                NoticeLink noticeLink = new NoticeLink(notice, link, name, generatedName);
                noticeLinks.add(noticeLink);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveMessageFilesToMessage(Message message) {

        if (files.length < 1) return;
        if (files[0].isEmpty()) return;


        pathForSaveFile = MainPathEnum.mainPath + "/message/";

        Set<MessageLink> messageLinks = message.getMessageLinks();

        if (!this.files[0].isEmpty()) {
            for (MultipartFile file : this.files) {
                try {
                    String name = file.getOriginalFilename();
                    String generatedName = generateUUIDname(name);
                    String link = GlobalEnum.webRoot + "/get-file/message/" + generatedName;
                    saveFile(generatedName, file);
                    MessageLink messageLink = new MessageLink(message, link, name, generatedName);
                    messageLinks.add(messageLink);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void saveToTaskMessageFiles(TaskMessage taskMessage) {

        if (files.length < 1) return;
        if (files[0].isEmpty()) return;

        pathForSaveFile = MainPathEnum.mainPath + "/task-message/";

        List<TaskMessageLink> messageLinks = taskMessage.getTaskMessageLinks();


        for (MultipartFile file : this.files) {
            try {
                String name = file.getOriginalFilename();
                String generatedName = generateUUIDname(name);
                String link = GlobalEnum.webRoot + "/get-file/task-message/" + generatedName;
                saveFile(generatedName, file);
                TaskMessageLink taskMessageLink = new TaskMessageLink(taskMessage, link, name, generatedName);
                messageLinks.add(taskMessageLink);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String saveFileAndReturnName() {

        if (files.length < 1) return null;
        if (files[0].isEmpty()) return null;

        pathForSaveFile = MainPathEnum.mainPath + "/general/";

        for (MultipartFile file : this.files) {
            try {
                String name = file.getOriginalFilename();
                String generatedName = generateUUIDname(name);
                saveFile(generatedName, file);
                return generatedName;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void deleteFileByName(String name) {

        String filePath = MainPathEnum.mainPath + "/general/" + name;

        File file = new File(filePath);
        file.delete();

    }

    public void savePostFilesToPost(FxmPost fxmPost) {

        if (files.length < 1) return;
        if (files[0].isEmpty()) return;


        pathForSaveFile = MainPathEnum.mainPath + "/post/";


        if (!this.files[0].isEmpty()) {
            String images = "";
            String videos = "";
            String files = "";

            for (MultipartFile file : this.files) {

                String name = file.getOriginalFilename();

                String generatedName = generateUUIDname(name);

                if (this.imageExpansion.indexOf(getFileExtension(file)) > -1) {
                    images += generatedName + ";#";
                } else if (this.videoExpansion.indexOf(getFileExtension(file)) > -1) {
                    videos += generatedName + ";#";
                } else {
                    files += generatedName + ";#";
                }

                try {
                    saveFile(generatedName, file);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            fxmPost.setLinksImage(images);
            fxmPost.setLinksVideo(videos);
            fxmPost.setLinksFile(files);

        }
    }

    public static void deleteAvatarFromUser(User user) {


        String filePath = MainPathEnum.mainPath + "/avatar/" + user.getAvatarImage();

        try {
            File oldAvatar = new File(filePath);
            oldAvatar.delete();
            user.setAvatarImage("");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void saveAvatarToUser(User user) {

        if (files.length < 1) return;
        if (files[0].isEmpty()) return;

        pathForSaveFile = MainPathEnum.mainPath + "/avatar/";

        if (!this.files[0].isEmpty()) {


            for (MultipartFile file : this.files) {

                String name = file.getOriginalFilename();

                String generatedName = generateUUIDname(name);

                try {
                    String oldAvatarImage = user.getAvatarImage();
                    if (!"".equals(oldAvatarImage) && oldAvatarImage != null) {
                        File oldAvatar = new File(pathForSaveFile + oldAvatarImage);
                        oldAvatar.delete();
                    }

                    saveFile(generatedName, file);
                    user.setAvatarImage(generatedName);

                } catch (IOException e) {
                    e.printStackTrace();
                }

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

    private static String getFileExtension(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }


}



