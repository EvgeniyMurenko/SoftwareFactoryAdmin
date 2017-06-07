package com.SoftwareFactoryAdmin.controller;

import com.SoftwareFactoryAdmin.dto.base.ServerRequest;
import com.SoftwareFactoryAdmin.dto.base.ServerResponse;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import static com.SoftwareFactoryAdmin.constant.AppRequestEnum.*;

@Controller
@SessionAttributes("roles")
public class FxmGroupController {



    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/group-exchange", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    public String groupExchange(@RequestBody String request) throws IOException {

        System.out.println(request);

        //  get server request type
        ServerRequest serverRequest = new Gson().fromJson(request, ServerRequest.class);
        String requestType = serverRequest.getRequestType();


        // default server response ( FAIL_REQUEST )
        ServerResponse serverResponse = new ServerResponse(REQUEST_FAIL.getValue() , null);

        if (requestType.equals(LOAD_ALL_POSTS_REQUEST.toString())) {

        } else if (requestType.equals(LOAD_COMMENTS_REQUEST.toString())) {

        } else if (requestType.equals(WRITE_POST_REQUEST.toString())) {

        } else if (requestType.equals(WRITE_COMMENT_REQUEST.toString())) {

        } else if (requestType.equals(DELETE_POST_REQUEST.toString())) {

        } else if (requestType.equals(DELETE_COMMENT_REQUEST.toString())) {

        } else if (requestType.equals(UPDATE_POST_REQUEST.toString())) {

        } else if (requestType.equals(UPDATE_COMMENT_REQUEST.toString())) {

        }


        String response = new Gson().toJson(serverResponse);
        return response;
    }
}

