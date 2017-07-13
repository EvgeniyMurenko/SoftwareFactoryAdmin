package com.SoftwareFactoryAdmin.controller;

import com.SoftwareFactoryAdmin.constant.AppRequestEnum;
import com.SoftwareFactoryAdmin.dto.base.ServerRequest;
import com.SoftwareFactoryAdmin.dto.base.ServerResponse;
import com.SoftwareFactoryAdmin.model.FxmPost;
import com.SoftwareFactoryAdmin.model.User;
import com.SoftwareFactoryAdmin.service.FxmPostService;
import com.SoftwareFactoryAdmin.service.UserService;
import com.SoftwareFactoryAdmin.util.SaveFile;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

@Controller
@SessionAttributes("roles")
public class FxmFileExchangeController {


    @Autowired
    private FxmPostService fxmPostService;

    @Autowired
    private UserService userService;


    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/file-exchange", method = RequestMethod.POST, consumes = {"multipart/form-data"}, produces = {"application/json"})
    public ServerResponse fileExchange(MultipartHttpServletRequest multipartHttpServletRequest,
                                       @RequestPart("serverRequest") String request) throws IOException, ServletException {


        System.out.println(request);


        // get server request type
        ServerRequest serverRequest = new Gson().fromJson(request, ServerRequest.class);
        String requestType = serverRequest.getRequestType();


        if (AppRequestEnum.ATTACH_LOAD_FXM_POST_FILES.toString().equals(requestType)) {

            Type postIdType = new TypeToken<ServerRequest<Long>>() {
            }.getType();

            ServerRequest<Long> attachLoadFxmPostFiles = new Gson().fromJson(request, postIdType);

            Long postID = (Long) attachLoadFxmPostFiles.getDataTransferObject();

            Map<String, MultipartFile> map = multipartHttpServletRequest.getFileMap();

            MultipartFile[] multipartFiles = map.values().toArray(new MultipartFile[map.values().size()]);

            SaveFile saveFile = new SaveFile(multipartFiles);

            FxmPost fxmPost = fxmPostService.getFxmPostById(postID);

            saveFile.savePostFilesToPost(fxmPost);

            fxmPostService.updateFxmPost(fxmPost);

            return new ServerResponse(AppRequestEnum.REQUEST_SUCCESS.toString(), null);

        } else if (AppRequestEnum.ATTACH_LOAD_USER_AVATAR.toString().equals(requestType)) {

            Type userIdType = new TypeToken<ServerRequest<Long>>() {
            }.getType();

            ServerRequest<Long> attachLoadUserAvatar = new Gson().fromJson(request, userIdType);

            Long userID = (Long) attachLoadUserAvatar.getDataTransferObject();

            Map<String, MultipartFile> map = multipartHttpServletRequest.getFileMap();

            MultipartFile[] multipartFiles = map.values().toArray(new MultipartFile[map.values().size()]);

            SaveFile saveFile = new SaveFile(multipartFiles);

            User user = userService.findById(userID);

            saveFile.saveAvatarToUser(user);

            userService.updateUser(user);

            System.out.println(user.getAvatarImage());

            return new ServerResponse(AppRequestEnum.REQUEST_SUCCESS.toString(), user.getAvatarImage());
        }


        return new ServerResponse(AppRequestEnum.REQUEST_FAIL.toString(), null);
    }


}
