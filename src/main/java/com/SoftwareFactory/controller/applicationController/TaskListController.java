/*
package com.SoftwareFactory.controller.applicationController;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("roles")
public class TaskListController {

    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/cities", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    public String taskList(@RequestBody String body) {
        JSONObject responseJson = new JSONObject(body);


        return responseJson.toString();
    }


}
*/
