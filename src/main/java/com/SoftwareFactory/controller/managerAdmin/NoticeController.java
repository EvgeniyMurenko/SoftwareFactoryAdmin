package com.SoftwareFactory.controller.managerAdmin;

import com.SoftwareFactory.constant.MainPathEnum;
import com.SoftwareFactory.model.Notice;
import com.SoftwareFactory.service.NoticeService;
import com.SoftwareFactory.util.SaveFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
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
        ModelAndView modelAndView = new ModelAndView("managerAdminViews/noticesList");

        List<Notice> noticeList = noticeService.getAllNotices();
        modelAndView.addObject("noticeList", noticeList);

        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView addNewNotice() {
        ModelAndView noticeEdit = new ModelAndView("managerAdminViews/noticeEdit");

        noticeEdit.addObject("isNew", true);
        return noticeEdit;
    }

    @RequestMapping(value = "/{noticeId}/edit", method = RequestMethod.GET)
    public ModelAndView noticeEdit(@PathVariable int noticeId) {
        ModelAndView noticeEdit = new ModelAndView("managerAdminViews/noticeEdit");

        Notice notice = noticeService.getNoticeById((long) noticeId);

        noticeEdit.addObject("isNew", false);
        noticeEdit.addObject("notice", notice);

        return noticeEdit;
    }

    @RequestMapping(value = "/saveNotice", method = RequestMethod.POST)
    public
    @ResponseBody
    ModelAndView saveManager(@RequestParam(value = "id") String id,
                             @RequestParam("title") String title,
                             @RequestParam("text") String text,
                             @RequestParam(value = "activ", required = false) boolean isActiv,
                             @RequestParam("file[]") MultipartFile[] files) {

        Notice notice;

        System.out.println("=========files size " + files.length);

        if (id.equals("")) {
            notice = new Notice();
            notice.setTitle(title);
            notice.setNoticeText(text);
            notice.setActiv(isActiv);
            notice.setDataCreate(new Date());

            noticeService.addNewNotice(notice);

            if (!files[0].isEmpty()) {
                String pathToSaveFile = "/notice/" + notice.getId();
                SaveFile saveFile = new SaveFile(pathToSaveFile, files);
                saveFile.saveFile();
                notice.setFilePath(pathToSaveFile);
                noticeService.updateNotice(notice);
            }
        } else {
            notice = noticeService.getNoticeById(Long.parseLong(id));

            notice.setTitle(title);
            notice.setNoticeText(text);
            notice.setActiv(isActiv);
            notice.setDataCreate(new Date());

            if (!files[0].isEmpty()) {
                String pathToSaveFile = "/notice/" + notice.getId();
                SaveFile saveFile = new SaveFile(pathToSaveFile, files);
                saveFile.saveFile();
                notice.setFilePath(pathToSaveFile);
            }

        }
        noticeService.updateNotice(notice);


        return new ModelAndView("redirect:/notice/" + notice.getId() + "/edit");
    }

    @RequestMapping(value = "/noticeDelete/{notiesId}", method = RequestMethod.GET)
    public ModelAndView staffDelete(@PathVariable Long notiesId) {

        Notice notice = noticeService.getNoticeById(notiesId);
        if (notice.getFilePath() != null) {
            File directory = new File(MainPathEnum.mainPath + "" + notice.getFilePath());
            directory.delete();
        }
        noticeService.deleteNotice(notice);

        return new ModelAndView("redirect:/notice/");
    }

    @RequestMapping(value = "/delete-image-from-notice/{noticeId}/{imageIndex}", method = RequestMethod.GET)
    public ModelAndView deleteImageFromNotice(@PathVariable(value = "noticeId") Long noticeId,
                                              @PathVariable(value = "imageIndex") Integer imageIndex) {

        Notice notice = noticeService.getNoticeById(noticeId);

        File directory = new File(MainPathEnum.mainPath + "/" + notice.getFilePath());
        File[] files = directory.listFiles();

        if (files.length > imageIndex) {
            files[imageIndex].delete();
        }

        System.out.println("=======delete file: " + files[imageIndex].getName());

        return new ModelAndView("redirect:/notice/" + noticeId + "/edit");
    }


}
