package com.SoftwareFactoryAdmin.controller;

import com.SoftwareFactoryAdmin.comparator.FxmPostByDateComporator;
import com.SoftwareFactoryAdmin.constant.MainPathEnum;
import com.SoftwareFactoryAdmin.model.*;
import com.SoftwareFactoryAdmin.service.FxmPostService;
import com.SoftwareFactoryAdmin.service.ManagerInfoService;
import com.SoftwareFactoryAdmin.service.UserService;


import com.SoftwareFactoryAdmin.util.FxmPostFile;
import com.SoftwareFactoryAdmin.util.SaveFile;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.*;


@Controller
@RequestMapping("/group")
@SessionAttributes("roles")
public class GroupController {

    @Autowired
    ManagerInfoService managerInfoService;

    @Autowired
    UserService userService;

    @Autowired
    FxmPostService fxmPostService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getShowGroup() {

        ModelAndView getShowGroup = new ModelAndView("group");

        List<FxmPost> postList = fxmPostService.getAllFxmPosts();

        Collections.sort(postList, new FxmPostByDateComporator());

        List<FxmPostFile> fxmPostFileList = new ArrayList<>();

        for (FxmPost fxmPost: postList){
            FxmPostFile fxmPostFile = new FxmPostFile(fxmPost);
            fxmPostFileList.add(fxmPostFile);
        }

        getShowGroup.addObject("fxmPostFileList", fxmPostFileList);
        return getShowGroup;
    }


    @ResponseBody
    @RequestMapping(value = "/get-translate", method = RequestMethod.GET)
    public String getTranslateComment(@RequestParam("commentId") Long id) throws Exception {
        JSONObject myJsonObj = new JSONObject();

        StringBuilder stringBuilderTranslate = new StringBuilder();

        stringBuilderTranslate.append("<div class=\"horizontal-line text-translate mt10\" >");
        stringBuilderTranslate.append(" У меня есть вопрос ... в пятницу я попросил Ольгу загрузить SFCAFE веб-сайт на первую страницу. <br>");
        stringBuilderTranslate.append("Я хочу знать почему ее там нет. <br>");
        stringBuilderTranslate.append("</div>");

        myJsonObj.append("translateComment", stringBuilderTranslate);

        return myJsonObj.toString();
    }


    @RequestMapping(value = "/save-post", method = RequestMethod.POST)
    public ModelAndView saveNewPost(HttpSession httpSession, @RequestParam("postText") String postText,
                                    @RequestParam("file[]") MultipartFile[] files) {

        Long userId = (Long) httpSession.getAttribute("UserId");
        ManagerInfo managerInfo = managerInfoService.getManagerInfoById(userId);

        List<FxmComment> commentList = new ArrayList<>();

        FxmPost fxmPost = new FxmPost(managerInfo.getUser(), managerInfo.getName(), new Date(), postText, null, null, null, null, null, null, commentList);


        /*for (MultipartFile file : files) {
            System.out.println("==========Расширение файла: " + getFileExtension(file));
        }

        List <MultipartFile> multipartFiles = Arrays.asList(files);
        List<String> image = Arrays.asList("img", "png", "jpg", "bmp");

        String imageLink = "";

        for (MultipartFile file : multipartFiles){
            for (String val : image){
                if (getFileExtension(file).equals(val)){
                    imageLink += file.getOriginalFilename()+";#";
                }
            }
        }
        System.out.println("============="+imageLink);

        String[] pathArr = imageLink.split(";#");
        List<String> pathList = Arrays.asList(pathArr);

        pathList.forEach((String path) -> System.out.println("======="+path));*/



        fxmPostService.addNewFxmPost(fxmPost);

        //SAVE FILE
        SaveFile saveFile = new SaveFile(files);
        saveFile.savePostFilesToPost(fxmPost);
        fxmPostService.updateFxmPost(fxmPost);


        return new ModelAndView("redirect:/group/");
    }

    @RequestMapping(value = "/add-new-comment/{postId}", method = RequestMethod.POST)
    public ModelAndView saveNewComment(HttpSession httpSession, @PathVariable Long postId, @RequestParam("comment") String comment) {
        Long userId = (Long) httpSession.getAttribute("UserId");
        ManagerInfo managerInfo = managerInfoService.getManagerInfoById(userId);

        FxmPost fxmPost = fxmPostService.getFxmPostById(postId);
        List<FxmComment> commentList = fxmPost.getFxmComments();

        FxmComment fxmComment = new FxmComment(managerInfo.getUser(), managerInfo.getName(), new Date(), comment, fxmPost);

        commentList.add(fxmComment);

        fxmPostService.updateFxmPost(fxmPost);


        return new ModelAndView("redirect:/group/");
    }


    @ResponseBody
    @RequestMapping(value = "/get-post-text", method = RequestMethod.GET)
    public String getPostToTranslate(@RequestParam("postId") Long postId) throws Exception {
        JSONObject myJsonObj = new JSONObject();

        FxmPost fxmPost = fxmPostService.getFxmPostById(postId);

        StringBuilder stringBuilderTranslate = new StringBuilder();

        stringBuilderTranslate.append("<input type=\"hidden\" name=\"postId\" value=\"" + postId + "\">");

        myJsonObj.append("textToTranslate", fxmPost.getPostTextOriginal());
        myJsonObj.append("postId_json", stringBuilderTranslate);

        return myJsonObj.toString();
    }

    @RequestMapping(value = "/save-post-translate", method = RequestMethod.POST)
    public ModelAndView savePostTranslate(@RequestParam("postId") Long postId,
                                          @RequestParam("selectFrom") String selectFrom,
                                          @RequestParam("selectTo") String selectTo,
                                          @RequestParam("translateText") String translateText) {

        FxmPost fxmPost = fxmPostService.getFxmPostById(postId);
        if (fxmPost != null) {
            switch (selectFrom) {
                case "ru":
                    fxmPost.setPostTextRu(fxmPost.getPostTextOriginal());
                    break;
                case "en":
                    fxmPost.setPostTextEn(fxmPost.getPostTextOriginal());
                    break;
                case "ko":
                    fxmPost.setPostTextKo(fxmPost.getPostTextOriginal());
                    break;
            }

            switch (selectTo) {
                case "ru":
                    fxmPost.setPostTextRu(translateText);
                    break;
                case "en":
                    fxmPost.setPostTextRu(translateText);
                    break;
                case "ko":
                    fxmPost.setPostTextRu(translateText);
                    break;
            }

            fxmPostService.updateFxmPost(fxmPost);

        }

        return new ModelAndView("redirect:/group/");
    }

    private static String getFileExtension(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        // если в имени файла есть точка и она не является первым символом в названии файла
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            // то вырезаем все знаки после последней точки в названии файла, то есть ХХХХХ.txt -> txt
            return fileName.substring(fileName.lastIndexOf(".")+1);
            // в противном случае возвращаем заглушку, то есть расширение не найдено
        else return "";
    }

}
