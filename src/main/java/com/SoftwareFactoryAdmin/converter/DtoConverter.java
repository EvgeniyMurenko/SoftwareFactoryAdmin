package com.SoftwareFactoryAdmin.converter;

import com.SoftwareFactoryAdmin.dto.ManagerInfoDTO;
import com.SoftwareFactoryAdmin.dto.MessageDTO;
import com.SoftwareFactoryAdmin.dto.MessageTaskDTO;

import com.SoftwareFactoryAdmin.dto.CaseDTO;
import com.SoftwareFactoryAdmin.model.*;

import java.io.File;
import java.util.*;


public class DtoConverter {



    public static ManagerInfoDTO managerInfoDTOConverter(ManagerInfo managerInfo) {

        /*List<MessageTaskDTO> messageTaskDTOList = messageTaskDTOConverter(staffInfo.getMessageTasks());*/

        ArrayList<String> permissions = new ArrayList<>();

        ManagerInfoDTO managerInfoDTO = new ManagerInfoDTO(managerInfo.getId(),  managerInfo.getName(), managerInfo.getPhone(), managerInfo.getEmail(), managerInfo.getBirthday(), permissions);

        return managerInfoDTO;
    }


   /* private static List<MessageTaskDTO> messageTaskDTOConverter(Set<MessageTask> messageTaskSet) {

        List<MessageTaskDTO> messageTaskDTOList = new ArrayList<>();

        Iterator<MessageTask> messageTaskIterator = messageTaskSet.iterator();

        while (messageTaskIterator.hasNext()) {
            MessageTask messageTask = messageTaskIterator.next();

            messageTaskDTOList.add(new MessageTaskDTO(messageTask.getId(),messageTask.getTitle(), messageTask.getMessageText(), messageTask.getDate(), messageTask.getApprove()));

        }

        return messageTaskDTOList;
    }*/

  public static List<CaseDTO> caseDTOConverter (List<Case> caseList){

      List<CaseDTO> caseDTOList = new ArrayList<>();

      Iterator<Case> caseIterator = caseList.iterator();

      while (caseIterator.hasNext()) {
          Case aCase = caseIterator.next();
          caseDTOList.add(new CaseDTO(aCase.getProjectTitle() , aCase.getStatus() , aCase.getCreationDate() ,messageDTOSConverter(aCase.getMessages())));

      }

      return caseDTOList;

  }

  private static List<MessageDTO> messageDTOSConverter (Set<Message> messageSet){

      List<MessageDTO> messageDTOS = new ArrayList<>();

      Iterator<Message> messageIterator = messageSet.iterator();

      while (messageIterator.hasNext()){

          Message message = messageIterator.next();

          UserProfile userProfile = message.getUser().getUserProfiles().iterator().next();
          if (userProfile.getType().equals("CUSTOMER")) {

              Set<String> filesUrl = new HashSet<>();

             /* if (message.getMessagePath() !=null) {
                  File dir = new File(message.getMessagePath());

                  File[] files = dir.listFiles();
                  if (files != null)
                      for (File file : files) {
                          String fileUrl = "/download/" + message.getId() + "/" + file.getName() + "/";
                          filesUrl.add(fileUrl);
                      }

              }*/

              messageDTOS.add(new MessageDTO(message.getMessageTime() , message.getMessageText() ,message.getIsRead() , filesUrl));
          }
      }


      return messageDTOS;
  }

}
