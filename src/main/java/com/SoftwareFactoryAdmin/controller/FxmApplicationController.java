package com.SoftwareFactoryAdmin.controller;

import com.SoftwareFactoryAdmin.converter.DtoConverter;
import com.SoftwareFactoryAdmin.dto.AppVersionDTO;
import com.SoftwareFactoryAdmin.dto.AuthorizationDTO;
import com.SoftwareFactoryAdmin.dto.CaseDTO;
import com.SoftwareFactoryAdmin.dto.ManagerInfoDTO;
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
    private UserService userService;

    @Autowired
    private ManagerInfoService managerInfoService;

    @Autowired
    private GoogleCloudKeyService googleCloudKeyService;

    @Autowired
    private AppVersionService appVersionService;

    @Autowired
    private CaseService caseService;

    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/app-exchange", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    public String authorization(@RequestBody String request) throws IOException {

        System.out.println(request);

        //  get server request type
        ServerRequest serverRequest = new Gson().fromJson(request, ServerRequest.class);
        String requestType = serverRequest.getRequestType();

        // default server response ( FAIL_REQUEST )
        ServerResponse serverResponse = new ServerResponse(REQUEST_FAIL.getValue(), null);

        if (requestType.equals(AUTHORIZATION_REQUEST.toString())) {

            Type authorizationType = new TypeToken<ServerRequest<AuthorizationDTO>>() {
            }.getType();

            ServerRequest<AuthorizationDTO> authorizationServerRequest = new Gson().fromJson(request, authorizationType);

            AuthorizationDTO authorizationDTO = (AuthorizationDTO) authorizationServerRequest.getDataTransferObject();

            User managerUser = userService.findBySSO(authorizationDTO.getSsoId());

            if (managerUser != null) {


             /*   BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
                if (bCryptPasswordEncoder.matches(authorizationDTO.getPassword() ,managerUser.getPassword())) {*/

                if (managerUser.getPassword().equals(authorizationDTO.getPassword())) {

                    List<GoogleCloudKey> googleCloudKeyList = new ArrayList<>(managerUser.getGoogleCloudKeys());

                    if (googleCloudKeyList.indexOf(authorizationDTO.getGoogleCloudKey()) < 0) {

                        GoogleCloudKey googleCloudKey = new GoogleCloudKey();
                        googleCloudKey.setUser(managerUser);
                        googleCloudKey.setKey(authorizationDTO.getGoogleCloudKey());
                        googleCloudKeyService.addGoogleCloudKey(googleCloudKey);

                    }


                    ManagerInfo managerInfo = managerInfoService.getManagerInfoById(managerUser.getId());


                    ManagerInfoDTO managerInfoDTO = DtoConverter.managerInfoDTOConverter(managerInfo);


                    serverResponse = new ServerResponse(REQUEST_SUCCESS.getValue(), managerInfoDTO);

                }
            }

        } else if (requestType.equals(GET_STAFF_INFO_REQUEST.toString())) {

            Type getStaffInfoType = new TypeToken<ServerRequest<Long>>() {
            }.getType();
            ServerRequest<Long> getManagerInfoServerRequest = new Gson().fromJson(request, getStaffInfoType);

            Long managerInfoId = (Long) getManagerInfoServerRequest.getDataTransferObject();

            if (managerInfoId != null) {
                ManagerInfo managerInfo = managerInfoService.getManagerInfoById(managerInfoId);
                ManagerInfoDTO managerInfoDTO = DtoConverter.managerInfoDTOConverter(managerInfo);
                serverResponse = new ServerResponse(REQUEST_SUCCESS.getValue(), managerInfoDTO);

            }

        }
        else if (requestType.equals(CHECK_VERSION.toString())) {
            Type authorizationType = new TypeToken<ServerRequest<String>>() {
            }.getType();

            System.out.println("===============CHECK_VERSION====================");

            ServerRequest<String> authorizationServerRequest = new Gson().fromJson(request, authorizationType);

            List<AppVersion> appVersionList = appVersionService.getAllAppVersion();
            AppVersion appVersion = appVersionList.get(appVersionList.size()-1);

            AppVersionDTO appVersionDTO = DtoConverter.appVersionDTO(appVersion);


            serverResponse = new ServerResponse(REQUEST_SUCCESS.getValue(), appVersionDTO);
        }
        else if (requestType.equals(GET_ALL_VERSIONS.toString())) {
           /* Type authorizationType = new TypeToken<ServerRequest<String>>() {
            }.getType();*/

            System.out.println("===============GET ALL VERSION====================");

            /*ServerRequest<String> authorizationServerRequest = new Gson().fromJson(request, authorizationType);
            String filter = (String) authorizationServerRequest.getDataTransferObject();

            System.out.println("===================filter============ " + filter);*/

            List<AppVersion> appVersionList = appVersionService.getAllAppVersion();
            List<AppVersionDTO> appVersionDTOList = new ArrayList<>();

            for (AppVersion appVersion : appVersionList){
                appVersionDTOList.add(DtoConverter.appVersionDTO(appVersion));
            }

            serverResponse = new ServerResponse(REQUEST_SUCCESS.getValue(), appVersionDTOList);
        }
        else if (requestType.equals(LOAD_ALL_CASES_REQUEST.toString())) {

            List<Case> cases = caseService.getCasesHundredLimit();

            List<CaseDTO> caseDTOS = DtoConverter.caseDTOConverter(cases);

            serverResponse = new ServerResponse(REQUEST_SUCCESS.getValue(), caseDTOS);

        }

        String response = new Gson().toJson(serverResponse);
        System.out.print(response);
        return response;

    }


}
