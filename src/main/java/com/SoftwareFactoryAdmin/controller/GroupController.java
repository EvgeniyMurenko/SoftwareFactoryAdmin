package com.SoftwareFactoryAdmin.controller;

import com.SoftwareFactoryAdmin.comparator.FxmPostByDateComporator;
import com.SoftwareFactoryAdmin.model.*;
import com.SoftwareFactoryAdmin.service.FxmCommentService;
import com.SoftwareFactoryAdmin.service.FxmPostService;
import com.SoftwareFactoryAdmin.service.ManagerInfoService;
import com.SoftwareFactoryAdmin.service.UserService;


import com.SoftwareFactoryAdmin.util.AppMethods;
import com.SoftwareFactoryAdmin.util.FxmPostFile;
import com.SoftwareFactoryAdmin.util.SaveFile;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
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

    @Autowired
    FxmCommentService fxmCommentService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getShowGroup() {

        ModelAndView getShowGroup = new ModelAndView("group");

        List<FxmPost> postList = fxmPostService.getAllFxmPosts();

        Collections.sort(postList, new FxmPostByDateComporator());

        List<FxmPostFile> fxmPostFileList = new ArrayList<>();

        for (FxmPost fxmPost : postList) {
            FxmPostFile fxmPostFile = new FxmPostFile(fxmPost);
            fxmPostFileList.add(fxmPostFile);
        }

        getShowGroup.addObject("fxmPostFileList", fxmPostFileList);
        return getShowGroup;
    }


    @ResponseBody
    @RequestMapping(value = "/get-translate-comment", method = RequestMethod.GET)
    public String getTranslateComment(@RequestParam("commentId") Long id) throws Exception {
        JSONObject myJsonObj = new JSONObject();

        FxmComment comment = fxmCommentService.getFxmCommentById(id);

        String translateComment = AppMethods.translate(comment.getCommentText(), "en");

        System.out.println("========================== " + translateComment);

        StringBuilder stringBuilderTranslate = new StringBuilder();

        stringBuilderTranslate.append("<div class=\"horizontal-line text-translate mt10\" >");
        stringBuilderTranslate.append(translateComment);
        stringBuilderTranslate.append("</div>");

        myJsonObj.append("translateComment", stringBuilderTranslate);

        return myJsonObj.toString();
    }

    @ResponseBody
    @RequestMapping(value = "/add-new-post", method = RequestMethod.GET)
    public String addNewPost() throws Exception {
        JSONObject myJsonObj = new JSONObject();

        StringBuilder stringBuilderAdd = new StringBuilder();

        stringBuilderAdd.append("<input type=\"hidden\" name=\"postId\" value=\"0\">");

        myJsonObj.append("stringBuilderAdd", stringBuilderAdd);

        return myJsonObj.toString();
    }


    @RequestMapping(value = "/save-post", method = RequestMethod.POST)
    public ModelAndView saveNewPost(HttpSession httpSession, @RequestParam("postId") Long postId,
                                    @RequestParam("postText") String postText,
                                    @RequestParam("file[]") MultipartFile[] files) {
        FxmPost fxmPost;
        if (postId > 0) {
            fxmPost = fxmPostService.getFxmPostById(postId);
            fxmPost.setPostTextOriginal(postText);

        } else {
            Long userId = (Long) httpSession.getAttribute("UserId");
            ManagerInfo managerInfo = managerInfoService.getManagerInfoById(userId);

            List<FxmComment> commentList = new ArrayList<>();
            fxmPost = new FxmPost(managerInfo.getUser(), managerInfo.getName(), new Date(), postText, null, null, null, null, null, null, commentList);

            fxmPostService.addNewFxmPost(fxmPost);
        }

        System.out.println("=================== file size " + files.length);
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


        FxmComment fxmComment = new FxmComment(managerInfo.getUser(), managerInfo.getName(), new Date(), comment, fxmPost);

        fxmCommentService.addFxmComment(fxmComment);


        return new ModelAndView("redirect:/group/");
    }

    @RequestMapping(value = "/delete-post/{postId}")
    public ModelAndView deletePost(HttpSession httpSession, @PathVariable Long postId) {
        System.out.println("================ delete post " + postId);

        FxmPost fxmPost = fxmPostService.getFxmPostById(postId);
        fxmCommentService.deleteAllCommentByPost(fxmPost);

        FxmPostFile fxmPostFile = new FxmPostFile(fxmPost);
        fxmPostFile.deleteAllFileFromPost();
        fxmPostService.deleteFxmPost(fxmPost);

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

    @ResponseBody
    @RequestMapping(value = "/get-post-edit", method = RequestMethod.GET)
    public String getPostToEdit(@RequestParam("postId") Long postId) throws Exception {
        JSONObject myJsonObj = new JSONObject();

        FxmPost fxmPost = fxmPostService.getFxmPostById(postId);

        StringBuilder stringBuilderPostId = new StringBuilder();
        stringBuilderPostId.append("<input type=\"hidden\" name=\"postId\" value=\"" + postId + "\">");

        StringBuilder stringBuilderFileAttach = new StringBuilder();
        FxmPostFile fxmPostFile = new FxmPostFile(fxmPost);

        stringBuilderFileAttach.append(addFileInstring(fxmPostFile.getImageList(), postId, "image"));
        stringBuilderFileAttach.append(addFileInstring(fxmPostFile.getVideoList(), postId, "video"));
        stringBuilderFileAttach.append(addFileInstring(fxmPostFile.getFileList(), postId, "file"));

        myJsonObj.append("stringBuilderPostId", stringBuilderPostId);
        myJsonObj.append("stringBuilderFileAttach", stringBuilderFileAttach);
        myJsonObj.append("postTextOriginal", fxmPost.getPostTextOriginal());

        return myJsonObj.toString();
    }

    @ResponseBody
    @RequestMapping(value = "/delete-file", method = RequestMethod.GET)
    public String deleteFileFromPost(@RequestParam("fileNmae") String fileNmae, @RequestParam("postId") Long postId) throws Exception {
        JSONObject myJsonObj = new JSONObject();

        FxmPost fxmPost = fxmPostService.getFxmPostById(postId);

        FxmPostFile fxmPostFile = new FxmPostFile(fxmPost);
        fxmPostFile.deleteFile(fileNmae);

        fxmPostService.updateFxmPost(fxmPost);

        myJsonObj.append("postId", postId);

        return myJsonObj.toString();
    }

    private StringBuilder addFileInstring(List<String> listFile, Long postId, String type) {
        StringBuilder stringBuilderFileAttach = new StringBuilder();
        if (listFile.size() > 0) {
            for (String fileName : listFile) {
                stringBuilderFileAttach.append("<div class=\"col-sm-2\">");
                stringBuilderFileAttach.append("<div class=\"small-thumbnail mb20\">");
                if (type.equals("image")){
                    stringBuilderFileAttach.append("<img class=\"img-responsive\" src=\"/get-file/post/" + fileName + "\" alt=\"\">");
                } else if(type.equals("video")){
                    stringBuilderFileAttach.append(" <a href=\"/get-file/post/" + fileName + "\" target=\"_blank\"><img class=\"img-responsive\" src=\"../../resources/images/video.png\" alt=\"\"></a>");
                } else {
                    stringBuilderFileAttach.append(" <a href=\"/get-file/post/" + fileName + "\" target=\"_blank\"><img class=\"img-responsive\" src=\"../../resources/images/file.png\" alt=\"\"></a>");
                }

                stringBuilderFileAttach.append("<a onclick=\"deleteFile('"+fileName+"', "+postId+")\" class=\"small-thumbnail-delete\"><i class=\"fa fa-times\" aria-hidden=\"true\"></i></a>");
                stringBuilderFileAttach.append("</div>");
                stringBuilderFileAttach.append("</div>");
            }
        }
        return stringBuilderFileAttach;

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

}
