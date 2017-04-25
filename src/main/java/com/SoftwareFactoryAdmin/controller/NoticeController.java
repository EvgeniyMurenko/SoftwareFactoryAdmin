package com.SoftwareFactoryAdmin.controller;

import com.SoftwareFactoryAdmin.constant.MainPathEnum;
import com.SoftwareFactoryAdmin.model.Notice;
import com.SoftwareFactoryAdmin.model.NoticeLink;
import com.SoftwareFactoryAdmin.service.NoticeLinkService;
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
import java.util.*;

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
        SaveFile saveFile = new SaveFile(imageFiles);

        if (id.equals("")) {
            notice = new Notice();
        } else {
            notice = noticeService.getNoticeById(Long.parseLong(id));
        }
        notice.setTitle(title);
        notice.setNoticeText(text);
        notice.setActiv(isActive);
        notice.setDataCreate(new Date());
        notice.setNoticeLinks(new HashSet<NoticeLink>());

        if (id.equals("")) {
            noticeService.addNewNotice(notice);
        }

        saveFile.saveNoticeFilesToNotice(notice);
        noticeService.updateNotice(notice);



        return new ModelAndView("redirect:/notice/" + notice.getId() + "/edit");
    }

    @RequestMapping(value = "/noticeDelete/{noticeId}", method = RequestMethod.GET)
    public ModelAndView staffDelete(@PathVariable Long noticeId) throws IOException {

        Notice notice = noticeService.getNoticeById(noticeId);

        Set <NoticeLink> noticeLinks = notice.getNoticeLinks();

        if (!noticeLinks.isEmpty()) {
            for (NoticeLink noticeLink : noticeLinks) {
                File noticeFile = new File(MainPathEnum.mainPath + "/notice/" + noticeLink.getFileUuidName());
                FileUtils.forceDelete(noticeFile);
            }
        }
        noticeService.deleteNotice(notice);

        return new ModelAndView("redirect:/notice/");
    }

    @Autowired
    NoticeLinkService noticeLinkService;

    @RequestMapping(value = "/delete-file-from-notice/{file-name}/{notice-id}/{file-link-id}", method = RequestMethod.GET)
    public ModelAndView deleteImageFromNotice(@PathVariable(value = "notice-id" ) Long noticeId,
                                              @PathVariable(value = "file-name") String fileName,
                                              @PathVariable(value = "file-link-id") Long fileLinkId) {

        String filePath =  MainPathEnum.mainPath +"/notice/" +fileName;

        File file = new File(filePath);

        if(file.exists()) {
            if (file.delete()){
                NoticeLink noticeLink = noticeLinkService.getNoticeLinkById(fileLinkId);
                noticeLinkService.deleteNoticeLink(noticeLink);
            }
        }

        return new ModelAndView("redirect:/notice/" + noticeId + "/edit");
    }



   /* private void saveVideo(MultipartFile[] videoFiles, Notice notice) {
        String pathToSaveFile = "/notice/" + notice.getId() + "/video";
        SaveFile saveFile = new SaveFile(pathToSaveFile, videoFiles);
        if (!videoFiles[0].isEmpty()) {
            saveFile.saveVideoFile();
        }
    }*/

}
