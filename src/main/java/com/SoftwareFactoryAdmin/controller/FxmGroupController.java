package com.SoftwareFactoryAdmin.controller;

import com.SoftwareFactoryAdmin.constant.AppRequestEnum;
import com.SoftwareFactoryAdmin.converter.DtoConverter;
import com.SoftwareFactoryAdmin.dto.CommentDTO;
import com.SoftwareFactoryAdmin.dto.PostDTO;
import com.SoftwareFactoryAdmin.dto.base.ServerRequest;
import com.SoftwareFactoryAdmin.dto.base.ServerResponse;
import com.SoftwareFactoryAdmin.model.*;
import com.SoftwareFactoryAdmin.service.*;
import com.SoftwareFactoryAdmin.util.FxmPostFile;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jnlp.PersistenceService;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import static com.SoftwareFactoryAdmin.constant.AppRequestEnum.*;

@Controller
@SessionAttributes("roles")
public class FxmGroupController {

    @Autowired
    private FxmPostService fxmPostService;

    @Autowired
    private FxmCommentService fxmCommentService;

    @Autowired
    private PushNotificationService pushNotificationService;

    @Autowired
    private GoogleCloudKeyService googleCloudKeyService;

    @Autowired
    private ManagerInfoService managerInfoService;


    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/group-exchange", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    public String groupExchange(@RequestBody String request) throws IOException {


        System.out.println(request);

        //  get server request type
        ServerRequest serverRequest = new Gson().fromJson(request, ServerRequest.class);
        String requestType = serverRequest.getRequestType();


        // default server response ( FAIL_REQUEST )
        ServerResponse serverResponse = new ServerResponse(REQUEST_FAIL.getValue(), null);

        if (requestType.equals(LOAD_ALL_POSTS_REQUEST.toString())) {

            List<FxmPost> fxmPosts = fxmPostService.getAllFxmPosts();
            List<PostDTO> postDTOS = new ArrayList<>();

            for (FxmPost fxmPost : fxmPosts) {
                postDTOS.add(DtoConverter.postDTOConvert(fxmPost));
            }

            serverResponse = new ServerResponse(REQUEST_SUCCESS.getValue(), postDTOS);

        } else if (requestType.equals(LOAD_COMMENTS_REQUEST.toString())) {

            Type postIdType = new TypeToken<ServerRequest<Long>>() {
            }.getType();
            ServerRequest<Long> loadCommentsRequest = new Gson().fromJson(request, postIdType);

            Long postID = (Long) loadCommentsRequest.getDataTransferObject();

            FxmPost fxmPost = fxmPostService.getFxmPostById(postID);

            List<FxmComment> fxmComments = fxmPost.getFxmComments();
            List<CommentDTO> commentDTOS = new ArrayList<>();

            for (FxmComment fxmComment : fxmComments) {
                commentDTOS.add(DtoConverter.commentDTOConvert(fxmComment));
            }

            serverResponse = new ServerResponse(REQUEST_SUCCESS.getValue(), commentDTOS);

        } else if (requestType.equals(WRITE_POST_REQUEST.toString())) {

            Type postDTOType = new TypeToken<ServerRequest<PostDTO>>() {
            }.getType();

            ServerRequest<PostDTO> writePostRequest = new Gson().fromJson(request, postDTOType);

            PostDTO postDTO = (PostDTO) writePostRequest.getDataTransferObject();

            ManagerInfo managerInfo = managerInfoService.getManagerInfoById(postDTO.getUserID());

            FxmPost fxmPost = new FxmPost(managerInfo.getUser(), managerInfo.getName(), new Date(), postDTO.getPostTextOriginal(), postDTO.getPostTextRu(), postDTO.getPostTextEn(), postDTO.getPostTextKo(), null, null, null, new ArrayList<>());

            fxmPostService.addNewFxmPost(fxmPost);

            serverResponse = new ServerResponse(REQUEST_SUCCESS.getValue(), null);


            List<String> keys = googleCloudKeyService.findAllManagersKeys();
            pushNotificationService.pushNotificationToGCM(keys, postDTO.getPostTextOriginal(), "FXM Group post!", AppRequestEnum.GROUP_PUSH_TYPE.toString());

        } else if (requestType.equals(WRITE_COMMENT_REQUEST.toString())) {

            Type commentDTOType = new TypeToken<ServerRequest<CommentDTO>>() {
            }.getType();
            ServerRequest<CommentDTO> writeCommentRequest = new Gson().fromJson(request, commentDTOType);

            CommentDTO commentDTO = (CommentDTO) writeCommentRequest.getDataTransferObject();

            FxmPost fxmPost = fxmPostService.getFxmPostById(commentDTO.getPostID());

            ManagerInfo managerInfo = managerInfoService.getManagerInfoById(commentDTO.getUserID());

            FxmComment fxmComment = new FxmComment(managerInfo.getUser(), managerInfo.getName(), new Date(), commentDTO.getCommentText(), fxmPost);

            fxmCommentService.addFxmComment(fxmComment);

            serverResponse = new ServerResponse(REQUEST_SUCCESS.getValue(), null);

            List<String> keys = googleCloudKeyService.findAllManagersKeys();
            pushNotificationService.pushNotificationToGCM(keys, commentDTO.getCommentText(), "FXM Group comment!", AppRequestEnum.GROUP_PUSH_TYPE.toString());

        } else if (requestType.equals(DELETE_POST_REQUEST.toString())) {

            Type postIdType = new TypeToken<ServerRequest<Long>>() {
            }.getType();
            ServerRequest<Long> deletePostRequest = new Gson().fromJson(request, postIdType);

            Long postID = (Long) deletePostRequest.getDataTransferObject();

            FxmPost fxmPost = fxmPostService.getFxmPostById(postID);

            fxmPostService.deleteFxmPost(fxmPost);

            serverResponse = new ServerResponse(REQUEST_SUCCESS.getValue(), null);

        } else if (requestType.equals(DELETE_COMMENT_REQUEST.toString())) {

            Type commentIdType = new TypeToken<ServerRequest<Long>>() {
            }.getType();
            ServerRequest<Long> deleteCommentRequest = new Gson().fromJson(request, commentIdType);

            Long commentID = (Long) deleteCommentRequest.getDataTransferObject();

            FxmComment fxmComment = fxmCommentService.getFxmCommentById(commentID);

            fxmCommentService.deleteFxmComment(fxmComment);

            serverResponse = new ServerResponse(REQUEST_SUCCESS.getValue(), null);

        } else if (requestType.equals(UPDATE_POST_REQUEST.toString())) {

            Type postType = new TypeToken<ServerRequest<PostDTO>>() {
            }.getType();

            ServerRequest<PostDTO> updatePostRequest = new Gson().fromJson(request, postType);

            PostDTO postDTO = (PostDTO) updatePostRequest.getDataTransferObject();

            FxmPost fxmPost = fxmPostService.getFxmPostById(postDTO.getServerID());

            fxmPost.setPostTextOriginal(postDTO.getPostTextOriginal());

            fxmPost.setPostTextRu(postDTO.getPostTextRu());

            fxmPost.setPostTextEn(postDTO.getPostTextEn());

            fxmPost.setPostTextKo(postDTO.getPostTextKo());

            FxmPostFile fxmPostFile = new FxmPostFile(fxmPost);

            fxmPostFile.compareFilesFromDtoAndMakeChanges(postDTO);

            fxmPostService.updateFxmPost(fxmPost);

            serverResponse = new ServerResponse(REQUEST_SUCCESS.getValue(), null);

        } else if (requestType.equals(UPDATE_COMMENT_REQUEST.toString())) {

            Type commentType = new TypeToken<ServerRequest<CommentDTO>>() {
            }.getType();

            ServerRequest<CommentDTO> updateCommentRequest = new Gson().fromJson(request, commentType);

            CommentDTO commentDTO = (CommentDTO) updateCommentRequest.getDataTransferObject();

            FxmComment fxmComment = fxmCommentService.getFxmCommentById(commentDTO.getServerID());

            fxmComment.setCommentText(commentDTO.getCommentText());

            fxmCommentService.updateFxmComment(fxmComment);

            serverResponse = new ServerResponse(REQUEST_SUCCESS.getValue(), null);
        }

        String gsonResponse = new Gson().toJson(serverResponse);
        System.out.println("return " + gsonResponse);
        return gsonResponse;
    }
}


