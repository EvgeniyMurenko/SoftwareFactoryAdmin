package com.SoftwareFactoryAdmin.controller;

import com.SoftwareFactoryAdmin.dto.ChangeNameDTO;
import com.SoftwareFactoryAdmin.dto.base.ServerRequest;
import com.SoftwareFactoryAdmin.dto.base.ServerResponse;
import com.SoftwareFactoryAdmin.model.*;
import com.SoftwareFactoryAdmin.service.ManagerInfoService;
import com.SoftwareFactoryAdmin.service.StaffInfoService;
import com.SoftwareFactoryAdmin.service.UserService;
import com.SoftwareFactoryAdmin.util.SaveFile;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Set;

import static com.SoftwareFactoryAdmin.constant.AppRequestEnum.*;

@Controller
@SessionAttributes("roles")
public class FxmSettingsController {


    @Autowired
    private UserService userService;


    @Autowired
    private ManagerInfoService managerInfoService;


    @Autowired
    private StaffInfoService staffInfoService;


    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/settings-exchange", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    public String settingsExchange(@RequestBody String request) throws IOException {


        System.out.println(request);

        //  get server request type
        ServerRequest serverRequest = new Gson().fromJson(request, ServerRequest.class);
        String requestType = serverRequest.getRequestType();


        // default server response ( FAIL_REQUEST )
        ServerResponse serverResponse = new ServerResponse(REQUEST_FAIL.getValue(), null);

        if (CHANGE_NAME_REQUEST.toString().equals(requestType)) {


            Type changeNameType = new TypeToken<ServerRequest<ChangeNameDTO>>() {
            }.getType();
            ServerRequest<ChangeNameDTO> changeNameRequest = new Gson().fromJson(request, changeNameType);

            ChangeNameDTO changeNameDTO = (ChangeNameDTO) changeNameRequest.getDataTransferObject();

            User user = userService.findById(changeNameDTO.getUserID());

            Set<UserProfile> userProfiles = user.getUserProfiles();
            UserProfile userProfile = userProfiles.iterator().next();

            if (userProfile.getType().equals("MANAGER")) {

                ManagerInfo managerInfo = managerInfoService.getManagerInfoById(changeNameDTO.getUserID());

                managerInfo.setName(changeNameDTO.getNewUserName());

                managerInfoService.updateManagerInfo(managerInfo);

            } else if (userProfile.getType().equals("STAFF")) {

                StaffInfo staffInfo = staffInfoService.getStaffInfoById(changeNameDTO.getUserID());

                staffInfo.setName(changeNameDTO.getNewUserName());

                staffInfoService.updateStaffInfo(staffInfo);
            }

            serverResponse = new ServerResponse(REQUEST_SUCCESS.getValue(), null);

        } else if (DELETE_AVATAR_REQUEST.toString().equals(requestType)) {

            Type deleteAvatarType = new TypeToken<ServerRequest<Long>>() {
            }.getType();
            ServerRequest<Long> deleteAvatarRequest = new Gson().fromJson(request, deleteAvatarType);

            Long userID = (Long) deleteAvatarRequest.getDataTransferObject();

            User user = userService.findById(userID);

            SaveFile.deleteAvatarFromUser(user);

            userService.updateUser(user);

            serverResponse = new ServerResponse(REQUEST_SUCCESS.getValue(), null);
        }


        String gsonResponse = new Gson().toJson(serverResponse);
        System.out.println("return " + gsonResponse);
        return gsonResponse;
    }
}