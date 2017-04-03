package com.SoftwareFactory.controller;

import com.SoftwareFactory.dto.Authorization;
import com.SoftwareFactory.dto.base.ServerRequest;
import com.SoftwareFactory.dto.base.ServerResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.Type;

import static com.SoftwareFactory.constant.AppRequestEnum.AUTHORIZATION_REQUEST;



@Controller
@SessionAttributes("roles")
public class FxmApplicationController {

    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/app-exchange", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    public String authorization(@RequestBody String request) throws IOException {
        System.out.println(request);

        ServerRequest serverRequest = new Gson().fromJson(request, ServerRequest.class);
        String requestType = serverRequest.getRequestType();



        if (requestType.equals(AUTHORIZATION_REQUEST.toString())) {


            Type authorizationType = new TypeToken<ServerRequest<Authorization>>() {
            }.getType();

            ServerRequest<Authorization> authorizationServerRequest = new Gson().fromJson(request, authorizationType);


            ServerResponse serverResponse = new ServerResponse("status" , new Authorization("1" , "2" , "3"));
            String response = new Gson().toJson(serverResponse);

            System.out.print("response send");
            return response;

        } else if (requestType.equals("")) {
            return "";


        }
        return "";
    }

}
