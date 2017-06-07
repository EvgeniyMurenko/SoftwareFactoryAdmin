package com.SoftwareFactoryAdmin.converter;

import com.SoftwareFactoryAdmin.dto.*;

import com.SoftwareFactoryAdmin.model.*;

import java.io.File;
import java.util.*;


public class DtoConverter {


    public static ManagerInfoDTO managerInfoDTOConverter(ManagerInfo managerInfo) {

        /*List<MessageTaskDTO> messageTaskDTOList = messageTaskDTOConverter(staffInfo.getMessageTasks());*/

        ArrayList<String> permissions = new ArrayList<>();

        ManagerInfoDTO managerInfoDTO = new ManagerInfoDTO(managerInfo.getId(), managerInfo.getName(), managerInfo.getPhone(), managerInfo.getEmail(), managerInfo.getBirthday(), permissions);

        return managerInfoDTO;
    }

    public static List<CaseDTO> caseDTOConverter(List<Case> caseList) {

        List<CaseDTO> caseDTOList = new ArrayList<>();

        Iterator<Case> caseIterator = caseList.iterator();

        while (caseIterator.hasNext()) {
            Case aCase = caseIterator.next();
            caseDTOList.add(new CaseDTO(aCase.getProjectTitle(), aCase.getStatus(), aCase.getCreationDate(), messageDTOSConverter(aCase.getMessages())));

        }

        return caseDTOList;

    }

    private static List<MessageDTO> messageDTOSConverter(Set<Message> messageSet) {

        List<MessageDTO> messageDTOS = new ArrayList<>();

        Iterator<Message> messageIterator = messageSet.iterator();

        while (messageIterator.hasNext()) {

            Message message = messageIterator.next();

            UserProfile userProfile = message.getUser().getUserProfiles().iterator().next();
            if (userProfile.getType().equals("CUSTOMER")) {

                Set<String> filesUrl = new HashSet<>();


                messageDTOS.add(new MessageDTO(message.getMessageTime(), message.getMessageText(), message.getIsRead(), filesUrl));
            }
        }


        return messageDTOS;
    }


    public static PostDTO postDTOConvert(FxmPost fxmPost) {
        return new PostDTO(fxmPost.getId(), fxmPost.getUser().getId(), fxmPost.getDate(), fxmPost.getPostText());
    }


    public static CommentDTO commentDTOConvert(FxmComment fxmComment) {
        return new CommentDTO(fxmComment.getId(), fxmComment.getUser().getId(), fxmComment.getDate(), fxmComment.getCommentText(), fxmComment.getFxmPost().getId());
    }


}