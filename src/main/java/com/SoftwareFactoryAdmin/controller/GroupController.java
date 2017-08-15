package com.SoftwareFactoryAdmin.controller;

import com.SoftwareFactoryAdmin.comparator.FxmPostByDateComporator;
import com.SoftwareFactoryAdmin.constant.AppRequestEnum;
import com.SoftwareFactoryAdmin.model.*;
import com.SoftwareFactoryAdmin.service.*;


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

    @Autowired
    private PushNotificationService pushNotificationService;

    @Autowired
    private GoogleCloudKeyService googleCloudKeyService;


    @RequestMapping(value = "/{groupType}/", method = RequestMethod.GET)
    public ModelAndView getShowGroup(HttpSession httpSession, @PathVariable String groupType) {

        ModelAndView getShowGroup = new ModelAndView("group");

        List<FxmPost> postList = fxmPostService.getAllFxmPostsByFilter(groupType);

        Collections.sort(postList, new FxmPostByDateComporator());
        List<FxmPostFile> fxmPostFileList = new ArrayList<>();

        for (FxmPost fxmPost : postList) {
            FxmPostFile fxmPostFile = new FxmPostFile(fxmPost);
            fxmPostFileList.add(fxmPostFile);
        }

        getShowGroup.addObject("fxmPostFileList", fxmPostFileList);
        getShowGroup.addObject("groupType", groupType);
        return getShowGroup;
    }


    @ResponseBody
    @RequestMapping(value = "/get-translate-comment", method = RequestMethod.GET)
    public String getTranslateComment(@RequestParam("commentId") Long id) throws Exception {
        JSONObject myJsonObj = new JSONObject();

        FxmComment comment = fxmCommentService.getFxmCommentById(id);

        String translateComment = AppMethods.translate(comment.getCommentText(), "en");

        StringBuilder stringBuilderTranslate = new StringBuilder();

        stringBuilderTranslate.append("<div class=\"horizontal-line mb10 mt10\" >");
        stringBuilderTranslate.append(translateComment);
        stringBuilderTranslate.append("</div>");

        myJsonObj.append("translateComment", stringBuilderTranslate);

        return myJsonObj.toString();
    }

    @ResponseBody
    @RequestMapping(value = "/add-new-post/{groupType}", method = RequestMethod.GET)
    public String addNewPost(@PathVariable String groupType) throws Exception {
        JSONObject myJsonObj = new JSONObject();

        StringBuilder stringBuilderAdd = new StringBuilder();

        stringBuilderAdd.append("<input type=\"hidden\" name=\"postId\" value=\"0\">");
        stringBuilderAdd.append("<input type=\"hidden\" name=\"groupType\" value=\""+groupType+"\">");

        myJsonObj.append("stringBuilderAdd", stringBuilderAdd);

        return myJsonObj.toString();
    }


    @RequestMapping(value = "/save-post", method = RequestMethod.POST)
    public ModelAndView saveNewPost(HttpSession httpSession, @RequestParam("postId") Long postId,
                                    @RequestParam("groupType") String groupType,
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
            fxmPost = new FxmPost(managerInfo.getUser(), managerInfo.getName(), new Date(), postText, null, null, null, null, null, null, groupType, commentList);

            fxmPostService.addNewFxmPost(fxmPost);

            List<String> keys = googleCloudKeyService.findAllKeysByFilter(groupType, userId);
            pushNotificationService.pushNotificationToGCM(keys, fxmPost.getPostTextOriginal(), "FXM Group post!" , AppRequestEnum.GROUP_PUSH_TYPE.toString());
        }

        //SAVE FILE
        SaveFile saveFile = new SaveFile(files);
        saveFile.savePostFilesToPost(fxmPost);

        fxmPostService.updateFxmPost(fxmPost);

        return new ModelAndView("redirect:/group/"+groupType+"/");
    }

    @RequestMapping(value = "/add-new-comment/{postId}", method = RequestMethod.POST)
    public ModelAndView saveNewComment(HttpSession httpSession, @PathVariable Long postId, @RequestParam("comment") String comment) {
        Long userId = (Long) httpSession.getAttribute("UserId");
        ManagerInfo managerInfo = managerInfoService.getManagerInfoById(userId);

        FxmPost fxmPost = fxmPostService.getFxmPostById(postId);

        FxmComment fxmComment = new FxmComment(managerInfo.getUser(), managerInfo.getName(), new Date(), comment, fxmPost);

        fxmCommentService.addFxmComment(fxmComment);

        List<String> keys = googleCloudKeyService.findAllManagerWithOutOne(managerInfo.getId());
        pushNotificationService.pushNotificationToGCM(keys, fxmComment.getCommentText(), "FXM Group comment!" , AppRequestEnum.GROUP_PUSH_TYPE.toString());

        return new ModelAndView("redirect:/group/"+fxmPost.getGroupType()+"/");
    }

    @RequestMapping(value = "/delete-post/{postId}")
    public ModelAndView deletePost(HttpSession httpSession, @PathVariable Long postId) {

        FxmPost fxmPost = fxmPostService.getFxmPostById(postId);
        fxmCommentService.deleteAllCommentByPost(fxmPost);

        FxmPostFile fxmPostFile = new FxmPostFile(fxmPost);
        fxmPostFile.deleteAllFileFromPost();
        fxmPostService.deleteFxmPost(fxmPost);

        return new ModelAndView("redirect:/group/"+fxmPost.getGroupType()+"/");
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
        stringBuilderPostId.append("<input type=\"hidden\" name=\"groupType\" value=\""+fxmPost.getGroupType()+"\">");

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

    @ResponseBody
    @RequestMapping(value = "/delete-comment", method = RequestMethod.GET)
    public String deleteComment(@RequestParam("commentId") Long commentId) throws Exception {
        JSONObject myJsonObj = new JSONObject();

        FxmComment fxmComment = fxmCommentService.getFxmCommentById(commentId);

        FxmPost fxmPost = fxmComment.getFxmPost();

        StringBuilder stringBuilderCountComments = new StringBuilder();


        if (fxmComment != null){
            fxmCommentService.deleteFxmComment(fxmComment);
            stringBuilderCountComments.append("<div class=\"row data-comment\" align=\"centre\" id=\"oldCountComments-"+fxmPost.getId()+"\">");
            stringBuilderCountComments.append("<i class=\"fa fa-commenting\" aria-hidden=\"true\"></i> Comments: "+fxmPost.getFxmComments().size()+1+" ");
            stringBuilderCountComments.append("</div>");
        }
        myJsonObj.append("countComments", stringBuilderCountComments);
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
                                          @RequestParam("selectTo") String selectTo,
                                          @RequestParam("translateText") String translateText) {

        FxmPost fxmPost = fxmPostService.getFxmPostById(postId);
        if (fxmPost != null) {
            switch (selectTo) {
                case "ru": fxmPost.setPostTextRu(translateText); break;
                case "en": fxmPost.setPostTextEn(translateText); break;
                case "ko": fxmPost.setPostTextKo(translateText); break;
            }

            fxmPostService.updateFxmPost(fxmPost);

        }

        return new ModelAndView("redirect:/group/"+fxmPost.getGroupType()+"/");
    }

    @ResponseBody
    @RequestMapping(value = "/get-comment-text-to-edit", method = RequestMethod.GET)
    public String getCommentTextToEdit(@RequestParam("commentId") Long commentId) throws Exception {
        JSONObject myJsonObj = new JSONObject();

        FxmComment fxmComment = fxmCommentService.getFxmCommentById(commentId);

        StringBuilder stringBuilderTextComment = new StringBuilder();

        stringBuilderTextComment.append("<input class=\"form-control\" type=\"text\" id=\"newCommentText"+commentId+"\" value=\""+fxmComment.getCommentText()+"\">");

        myJsonObj.append("stringBuilderTextComment",stringBuilderTextComment);

        return myJsonObj.toString();

    }


    @ResponseBody
    @RequestMapping(value = "/update-comment", method = RequestMethod.GET)
    public String saveNewCommentText(@RequestParam("commentId") Long commentId,
                                     @RequestParam("newTextComment") String newTextComment) throws Exception {
        JSONObject myJsonObj = new JSONObject();

        FxmComment fxmComment = fxmCommentService.getFxmCommentById(commentId);
        fxmComment.setCommentText(newTextComment);
        fxmCommentService.updateFxmComment(fxmComment);

        myJsonObj.append("succes", "succes");

        return myJsonObj.toString();

    }

}
