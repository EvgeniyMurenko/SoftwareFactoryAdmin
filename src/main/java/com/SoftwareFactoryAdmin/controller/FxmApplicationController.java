/*
package com.SoftwareFactoryAdmin.controller;

import com.SoftwareFactoryAdmin.converter.DtoConverter;
import com.SoftwareFactoryAdmin.dto.AuthorizationDTO;
import com.SoftwareFactoryAdmin.dto.CaseDTO;
import com.SoftwareFactoryAdmin.dto.StaffInfoDTO;
import com.SoftwareFactoryAdmin.dto.base.ServerRequest;
import com.SoftwareFactoryAdmin.dto.base.ServerResponse;

import com.SoftwareFactoryAdmin.model.*;
import com.SoftwareFactoryAdmin.service.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static com.SoftwareFactoryAdmin.constant.AppRequestEnum.*;


@Controller
@SessionAttributes("roles")
public class FxmApplicationController {

    @Autowired
    UserService userService;

    @Autowired
    StaffInfoService staffInfoService;

    @Autowired
    GoogleCloudKeyService googleCloudKeyService;

    @Autowired
    MessageTaskService messageTaskService;

    @Autowired
    CaseService caseService;

    @Autowired
    UserDetailsService userDetailsService;

    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/app-exchange", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    public String authorization(@RequestBody String request) throws IOException {
        System.out.println(request);

        //  get server request type
        ServerRequest serverRequest = new Gson().fromJson(request, ServerRequest.class);
        String requestType = serverRequest.getRequestType();

        // default server response ( FAIL_REQUEST )
        ServerResponse serverResponse = new ServerResponse(REQUEST_FAIL.getValue() , null);

        if (requestType.equals(AUTHORIZATION_REQUEST.toString())) {

            Type authorizationType = new TypeToken<ServerRequest<AuthorizationDTO>>() {
            }.getType();

            ServerRequest<AuthorizationDTO> authorizationServerRequest = new Gson().fromJson(request, authorizationType);

            AuthorizationDTO authorizationDTO = (AuthorizationDTO) authorizationServerRequest.getDataTransferObject();

            User staffUser = userService.findBySSO(authorizationDTO.getSsoId());

            if (staffUser != null) {
                StaffInfo staffInfo = staffInfoService.getStaffInfo((long) staffUser.getId());

                BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

                if (bCryptPasswordEncoder.matches(authorizationDTO.getPassword() ,staffUser.getPassword())) {

                    List<GoogleCloudKey> googleCloudKeyList = new ArrayList<>(staffInfo.getGoogleCloudKeys());

                    if (googleCloudKeyList.indexOf(authorizationDTO.getGoogleCloudKey()) < 0) {

                        GoogleCloudKey googleCloudKey = new GoogleCloudKey();
                        googleCloudKey.setStaffInfo(staffInfo);
                        googleCloudKey.setKey(authorizationDTO.getGoogleCloudKey());
                        googleCloudKeyService.addGoogleCloudKey(googleCloudKey);

                    }

                    StaffInfoDTO staffInfoDTO = DtoConverter.staffInfoDTOConverter(staffInfo);

                    serverResponse = new ServerResponse(REQUEST_SUCCESS.getValue(), staffInfoDTO);

                }
            }

        } else if (requestType.equals(GET_STAFF_INFO_REQUEST.toString())) {
            Type getStaffInfoType = new TypeToken<ServerRequest<Long>>() {
            }.getType();
            ServerRequest<Long> getStaffInfoServerRequest = new Gson().fromJson(request, getStaffInfoType);

            Long staffInfoId = (Long) getStaffInfoServerRequest.getDataTransferObject();

            if (staffInfoId != null) {
                StaffInfo staffInfo = staffInfoService.getStaffInfo(staffInfoId);
                StaffInfoDTO staffInfoDTO = DtoConverter.staffInfoDTOConverter(staffInfo);
                serverResponse = new ServerResponse(REQUEST_SUCCESS.getValue(), staffInfoDTO);

            }

        } else if (requestType.equals(SET_READ_MESSAGE_TASK_REQUEST.toString())) {
            Type setReadMessageTaskType = new TypeToken<ServerRequest<Long>>() {
            }.getType();
            ServerRequest<Long> setReadMessageTaskServerRequest = new Gson().fromJson(request, setReadMessageTaskType);

            Long messageTaskId = (Long) setReadMessageTaskServerRequest.getDataTransferObject();

            if (messageTaskId != null) {
                MessageTask messageTask = messageTaskService.getMessageTask(messageTaskId);
                messageTask.setApprove(true);
                messageTaskService.updateMessageTask(messageTask);
                serverResponse = new ServerResponse(REQUEST_SUCCESS.getValue(), null);
            }

        } else if (requestType.equals(LOAD_ALL_CASES_REQUEST.toString())) {

            List<Case> cases = caseService.getCasesHundredLimit();

            List<CaseDTO> caseDTOS = DtoConverter.caseDTOConverter(cases);

            serverResponse = new ServerResponse(REQUEST_SUCCESS.getValue(), caseDTOS);

        }

        String response = new Gson().toJson(serverResponse);
        return response;

    }


}
*/
