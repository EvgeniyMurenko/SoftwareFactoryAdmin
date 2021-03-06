package com.SoftwareFactoryAdmin.converter;

import com.SoftwareFactoryAdmin.dto.*;

import com.SoftwareFactoryAdmin.model.*;
import com.google.gson.Gson;

import java.util.*;


public class DtoConverter {


    public static ManagerInfoDTO managerInfoDTOConverter(ManagerInfo managerInfo) {

        Permission permission = managerInfo.getManagerInfoPermissions();

        ManagerInfoDTO managerInfoDTO = new ManagerInfoDTO(managerInfo.getId(), managerInfo.getName(), managerInfo.getPhone(), managerInfo.getEmail(), managerInfo.getBirthday(), managerInfo.getUser().getAvatarImage(), new PermissionDTO(permission.getSuperAdminPermission(), permission.getEstimatePermission(), permission.getCasePermission(), permission.getCustomerPermission(), permission.getProjectsPermission(), permission.getStaffPermission(), permission.getNoticePermission(), permission.getPermissionManagement(), permission.getTranslatePermission(), permission.getLeaderGroup(), permission.getMemberGroup(), permission.getStaffGroup()));

        return managerInfoDTO;
    }

    public static List<CaseDTO> caseDTOConverter(List<Case> caseList) {

        List<CaseDTO> caseDTOList = new ArrayList<>();

        for (Case aCase : caseList) {
            caseDTOList.add(new CaseDTO(aCase.getProjectTitle(), aCase.getStatus(), aCase.getCreationDate(), messageDTOSConverter(aCase.getMessages())));
        }

        return caseDTOList;
    }

    private static List<MessageDTO> messageDTOSConverter(Set<Message> messageSet) {

        List<MessageDTO> messageDTOS = new ArrayList<>();

        for (Message message : messageSet) {

            UserProfile userProfile = message.getUser().getUserProfiles().iterator().next();
            if (userProfile.getType().equals("CUSTOMER")) {

                Set<String> filesUrl = new HashSet<>();
                messageDTOS.add(new MessageDTO(message.getMessageTime(), message.getMessageText(), message.getIsRead(), filesUrl));
            }
        }

        return messageDTOS;
    }


    public static PostDTO postDTOConvert(FxmPost fxmPost) {
        return new PostDTO(fxmPost.getId(), fxmPost.getId(), fxmPost.getUser().getId(), fxmPost.getUserName(), fxmPost.getDate(), fxmPost.getPostTextOriginal(), fxmPost.getPostTextRu(),fxmPost.getPostTextEn(),fxmPost.getPostTextKo() ,fxmPost.getLinksFile(),  fxmPost.getLinksImage() ,fxmPost.getLinksVideo()  ,fxmPost.getUser().getAvatarImage(), fxmPost.getGroupType());
    }

    public static CommentDTO commentDTOConvert(FxmComment fxmComment) {
        return new CommentDTO(fxmComment.getId() , fxmComment.getId(), fxmComment.getUser().getId(),  fxmComment.getUserName(),fxmComment.getDate(), fxmComment.getCommentText(), fxmComment.getFxmPost().getId(), fxmComment.getUser().getAvatarImage());
    }

    public static AppVersionDTO appVersionDTO(AppVersion appVersion) {
        return new AppVersionDTO(appVersion.getId(), appVersion.getId(), appVersion.getTitle(), appVersion.getDescription(), appVersion.getDate(), appVersion.getImportant(), appVersion.getVersionName(), appVersion.getVersionCode());
    }
}