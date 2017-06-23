package com.SoftwareFactoryAdmin.controller;

import com.SoftwareFactoryAdmin.converter.DtoConverter;
import com.SoftwareFactoryAdmin.dto.CommentDTO;
import com.SoftwareFactoryAdmin.dto.PostDTO;
import com.SoftwareFactoryAdmin.dto.base.ServerRequest;
import com.SoftwareFactoryAdmin.dto.base.ServerResponse;
import com.SoftwareFactoryAdmin.model.FxmComment;
import com.SoftwareFactoryAdmin.model.FxmPost;
import com.SoftwareFactoryAdmin.model.GoogleCloudKey;
import com.SoftwareFactoryAdmin.model.User;
import com.SoftwareFactoryAdmin.service.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.SoftwareFactoryAdmin.constant.AppRequestEnum.*;

@Controller
@SessionAttributes("roles")
public class FxmGroupController {

    @Autowired
    FxmPostService fxmPostService;

    @Autowired
    FxmCommentService fxmCommentService;

    @Autowired
    UserService userService;

    @Autowired
    PushNotificationService pushNotificationService;

    @Autowired
    GoogleCloudKeyService googleCloudKeyService;


    @RequestMapping(value = "/test-on" ,method = RequestMethod.GET)
    public ModelAndView test (){

        List<String> keys = googleCloudKeyService.findAllManagersKeys();

        for(String key : keys){
            System.out.println(key);
        }

        return new ModelAndView("404");
    }

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

            User user = userService.findById(postDTO.getUserID());

            FxmPost fxmPost = new FxmPost(user, new Date() , postDTO.getPostText(),new ArrayList<>());

            fxmPostService.addNewFxmPost(fxmPost);

            serverResponse = new ServerResponse(REQUEST_SUCCESS.getValue(), null);

            List<String> keys = googleCloudKeyService.findAllManagersKeys();
            pushNotificationService.pushNotificationToGCM(keys, postDTO.getPostText(), "New group post!");

        } else if (requestType.equals(WRITE_COMMENT_REQUEST.toString())) {

            Type commentDTOType = new TypeToken<ServerRequest<CommentDTO>>() {
            }.getType();
            ServerRequest<CommentDTO> writeCommentRequest = new Gson().fromJson(request, commentDTOType);

            CommentDTO commentDTO = (CommentDTO) writeCommentRequest.getDataTransferObject();

            FxmPost fxmPost = fxmPostService.getFxmPostById(commentDTO.getPostID());
            User user = userService.findById(commentDTO.getUserID());

            FxmComment fxmComment = new FxmComment(user , new Date() , commentDTO.getCommentText(), fxmPost);

            fxmCommentService.addFxmComment(fxmComment);

            serverResponse = new ServerResponse(REQUEST_SUCCESS.getValue(), null);

            List<String> keys = googleCloudKeyService.findAllManagersKeys();
            pushNotificationService.pushNotificationToGCM(keys, commentDTO.getCommentText(), "New group comment!");

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

            FxmPost fxmPost = fxmPostService.getFxmPostById(postDTO.getId());

            fxmPost.setPostText(postDTO.getPostText());

            fxmPostService.updateFxmPost(fxmPost);

            serverResponse = new ServerResponse(REQUEST_SUCCESS.getValue(), null);

        } else if (requestType.equals(UPDATE_COMMENT_REQUEST.toString())) {

            Type commentType = new TypeToken<ServerRequest<CommentDTO>>() {
            }.getType();
            ServerRequest<CommentDTO> updateCommentRequest = new Gson().fromJson(request, commentType);

            CommentDTO commentDTO = (CommentDTO) updateCommentRequest.getDataTransferObject();

            FxmComment fxmComment = fxmCommentService.getFxmCommentById(commentDTO.getId());

            fxmComment.setCommentText(commentDTO.getCommentText());

            fxmCommentService.updateFxmComment(fxmComment);

            serverResponse = new ServerResponse(REQUEST_SUCCESS.getValue(), null);
        }


        return new Gson().toJson(serverResponse);
    }
}

