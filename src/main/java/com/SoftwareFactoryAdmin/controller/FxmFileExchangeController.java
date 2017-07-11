package com.SoftwareFactoryAdmin.controller;

import com.SoftwareFactoryAdmin.constant.AppRequestEnum;
import com.SoftwareFactoryAdmin.dto.base.ServerRequest;
import com.SoftwareFactoryAdmin.model.FxmPost;
import com.SoftwareFactoryAdmin.service.FxmPostService;
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


    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/file-exchange", method = RequestMethod.POST, consumes = {"multipart/form-data"}, produces = {"application/json"})
    public String fileExchange(MultipartHttpServletRequest multipartHttpServletRequest,
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

        }


        return AppRequestEnum.REQUEST_SUCCESS.toString();
    }



}
