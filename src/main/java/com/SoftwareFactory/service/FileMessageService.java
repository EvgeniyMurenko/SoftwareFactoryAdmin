package com.SoftwareFactory.service;

import com.SoftwareFactory.model.FileMessage;
import java.util.List;


public interface FileMessageService {
    void addNewFileMessage(FileMessage fileMessage);
    void updateFileMessage(FileMessage fileMessage);
    void deleteFileMessage(FileMessage fileMessage);
    List<FileMessage> getAllFileMessage();
    FileMessage getFileMessageById(Long id);
}
