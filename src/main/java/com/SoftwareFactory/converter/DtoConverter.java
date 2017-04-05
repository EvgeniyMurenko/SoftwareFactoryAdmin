package com.SoftwareFactory.converter;

import com.SoftwareFactory.dto.MessageTaskDTO;
import com.SoftwareFactory.dto.StaffInfoDTO;
import com.SoftwareFactory.model.MessageTask;
import com.SoftwareFactory.model.StaffInfo;

import java.util.*;


public class DtoConverter {

    public static StaffInfoDTO staffInfoDTOConverter(StaffInfo staffInfo) {

        List<MessageTaskDTO> messageTaskDTOLisy = messageTaskDTOConverter(staffInfo.getMessageTasks());

        StaffInfoDTO staffInfoDTO = new StaffInfoDTO(staffInfo.getName(), staffInfo.getPhone(), staffInfo.getEmail(), staffInfo.getBirthday(), messageTaskDTOLisy);

        return staffInfoDTO;
    }

    private static List<MessageTaskDTO> messageTaskDTOConverter(Set<MessageTask> messageTaskSet) {

        List<MessageTaskDTO> messageTaskDTOList = new ArrayList<>();

        Iterator<MessageTask> messageTaskIterator = messageTaskSet.iterator();

        while (messageTaskIterator.hasNext()) {
            MessageTask messageTask = messageTaskIterator.next();

            messageTaskDTOList.add(new MessageTaskDTO(messageTask.getTitle(), messageTask.getMessageText(), messageTask.getDate(), messageTask.getApprove()));

        }

        return messageTaskDTOList;
    }

}
