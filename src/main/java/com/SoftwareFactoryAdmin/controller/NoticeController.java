package com.SoftwareFactoryAdmin.controller;

import com.SoftwareFactoryAdmin.constant.MainPathEnum;
import com.SoftwareFactoryAdmin.model.Notice;
import com.SoftwareFactoryAdmin.service.NoticeService;
import com.SoftwareFactoryAdmin.util.SaveFile;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/notice")
@SessionAttributes("roles")
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView noticesList() {
        ModelAndView modelAndView = new ModelAndView("noticesList");

        List<Notice> noticeList = noticeService.getAllNotices();
        modelAndView.addObject("noticeList", noticeList);

        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView addNewNotice() {
        ModelAndView noticeEdit = new ModelAndView("noticeEdit");

        noticeEdit.addObject("isNew", true);
        return noticeEdit;
    }

    @RequestMapping(value = "/{noticeId}/edit", method = RequestMethod.GET)
    public ModelAndView noticeEdit(@PathVariable int noticeId) {
        ModelAndView noticeEdit = new ModelAndView("noticeEdit");

        Notice notice = noticeService.getNoticeById((long) noticeId);

        noticeEdit.addObject("isNew", false);
        noticeEdit.addObject("notice", notice);

        return noticeEdit;
    }

    @RequestMapping(value = "/saveNotice", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView saveNotice(@RequestParam(value = "id") String id,
                                   @RequestParam("title") String title,
                                   @RequestParam("text") String text,
                                   @RequestParam(value = "active", required = false) boolean isActive,
                                   @RequestParam("file[]") MultipartFile[] imageFiles
                             /*@RequestParam("video-file[]") MultipartFile[] videoFiles*/) {

        Notice notice;

        if (id.equals("")) {
            notice = new Notice();
        } else {
            notice = noticeService.getNoticeById(Long.parseLong(id));
        }
        notice.setTitle(title);
        notice.setNoticeText(text);
        notice.setActiv(isActive);
        notice.setDataCreate(new Date());

        if (id.equals("")) {
            noticeService.addNewNotice(notice);
            String pathToSaveFile = "/notice/" + notice.getId();
            notice.setFilePath(pathToSaveFile);
        }
        noticeService.updateNotice(notice);

        saveImage(imageFiles, notice);

        return new ModelAndView("redirect:/notice/" + notice.getId() + "/edit");
    }

    @RequestMapping(value = "/noticeDelete/{noticeId}", method = RequestMethod.GET)
    public ModelAndView staffDelete(@PathVariable Long noticeId) throws IOException {

        Notice notice = noticeService.getNoticeById(noticeId);
        if (notice.getFilePath() != null) {
            File directory = new File(MainPathEnum.mainPath + notice.getFilePath());
            FileUtils.deleteDirectory(directory);
        }
        noticeService.deleteNotice(notice);

        return new ModelAndView("redirect:/notice/");
    }

    @RequestMapping(value = "/delete-file-from-notice/{noticeId}/{fileIndex}/{type}", method = RequestMethod.GET)
    public ModelAndView deleteImageFromNotice(@PathVariable(value = "noticeId") Long noticeId,
                                              @PathVariable(value = "fileIndex") Integer fileIndex,
                                              @PathVariable(value = "type") String type) {

        Notice notice = noticeService.getNoticeById(noticeId);

        String directoryPath;
        if (type.equals("image")) {
            directoryPath = MainPathEnum.mainPath + "/" + notice.getFilePath();
        } else {
            directoryPath = MainPathEnum.mainPath + "/" + notice.getFilePath() + "/video";
        }

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        System.out.print("files lengt =" + files.length);

        if (files.length > fileIndex) {
            files[fileIndex].delete();
        }

        return new ModelAndView("redirect:/notice/" + noticeId + "/edit");
    }

    private void saveImage(MultipartFile[] imageFiles, Notice notice) {
        String pathToSaveFile = "/notice/" + notice.getId();
        SaveFile saveFile = new SaveFile(pathToSaveFile, imageFiles);
        if (imageFiles.length > 0 && !imageFiles[0].isEmpty()) {
            saveFile.saveFile();
        }
    }

    private void saveVideo(MultipartFile[] videoFiles, Notice notice) {
        String pathToSaveFile = "/notice/" + notice.getId() + "/video";
        SaveFile saveFile = new SaveFile(pathToSaveFile, videoFiles);
        if (!videoFiles[0].isEmpty()) {
            saveFile.saveVideoFile();
        }
    }

}
