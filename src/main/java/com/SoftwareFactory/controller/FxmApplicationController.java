package com.SoftwareFactory.controller;

import com.SoftwareFactory.dto.Authorization;
import com.SoftwareFactory.dto.base.ServerRequest;
import com.SoftwareFactory.dto.base.ServerResponse;

import com.SoftwareFactory.model.GoogleCloudKey;
import com.SoftwareFactory.model.MessageTask;
import com.SoftwareFactory.model.StaffInfo;
import com.SoftwareFactory.model.User;
import com.SoftwareFactory.service.GoogleCloudKeyService;
import com.SoftwareFactory.service.StaffInfoService;
import com.SoftwareFactory.service.UserService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.SoftwareFactory.constant.AppRequestEnum.AUTHORIZATION_REQUEST;
import static com.SoftwareFactory.constant.AppRequestEnum.REQUEST_FAIL;
import static com.SoftwareFactory.constant.AppRequestEnum.REQUEST_SUCCESS;


@Controller
@SessionAttributes("roles")
public class FxmApplicationController {

    @Autowired
    UserService userService;

    @Autowired
    StaffInfoService staffInfoService;

    @Autowired
    GoogleCloudKeyService googleCloudKeyService;

    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/app-exchange", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    public String authorization(@RequestBody String request) throws IOException {
        System.out.println(request);

        ServerRequest serverRequest = new Gson().fromJson(request, ServerRequest.class);
        String requestType = serverRequest.getRequestType();

        ServerResponse serverResponse;

        if (requestType.equals(AUTHORIZATION_REQUEST.toString())) {


            Type authorizationType = new TypeToken<ServerRequest<Authorization>>() {
            }.getType();

            ServerRequest<Authorization> authorizationServerRequest = new Gson().fromJson(request, authorizationType);

            Authorization authorization = (Authorization) authorizationServerRequest.getDataTransferObject();

            User staffUser = userService.findBySSO(authorization.getSsoId());

            StaffInfo staffInfo = staffInfoService.getStaffInfo((long)staffUser.getId());

            Set<MessageTask> messageTaskSet = null;
            if (staffUser != null && authorization.getPassword().equals(staffUser.getPassword())){

                List<GoogleCloudKey> googleCloudKeyList = new ArrayList<>(staffInfo.getGoogleCloudKeys());

                if (googleCloudKeyList.indexOf(authorization.getGoogleCloudKey())< 0){
                    GoogleCloudKey googleCloudKey = new GoogleCloudKey();
                    googleCloudKey.setStaffInfo(staffInfo);
                    googleCloudKey.setKey(authorization.getGoogleCloudKey());
                    googleCloudKeyList.add(googleCloudKey);

                    googleCloudKeyService.addGoogleCloudKey(googleCloudKey);
                }

                messageTaskSet = staffInfo.getMessageTasks();
            }

            System.out.println(staffInfo);
            System.out.println(messageTaskSet);

            serverResponse = new ServerResponse(REQUEST_SUCCESS.toString(), new Authorization("1" , "2" , "3"));
            String response = new Gson().toJson(serverResponse);

            System.out.print("response send succses");


        } else if (requestType.equals("")) {
            return "";


        }else {
            serverResponse = new ServerResponse(REQUEST_FAIL.toString() , null);
            System.out.print("response send fail");
        }

        String response = new Gson().toJson(serverResponse);
        return response;

    }



}
