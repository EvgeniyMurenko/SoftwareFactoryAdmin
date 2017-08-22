package com.SoftwareFactoryAdmin.controller;

import com.SoftwareFactoryAdmin.model.AppVersion;
import com.SoftwareFactoryAdmin.service.AppVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/app-version")
@SessionAttributes("roles")
public class AppVersionController {

    @Autowired
    private AppVersionService appVersionService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getManagerCabinetCase() {

        ModelAndView managerAdminCabinetCase = new ModelAndView("appVersionList");
        List<AppVersion> appVersionList = appVersionService.getAllAppVersion();

        managerAdminCabinetCase.addObject("appVersionList", appVersionList);

        return managerAdminCabinetCase;
    }

    @RequestMapping(value = "/add-version", method = RequestMethod.GET)
    public ModelAndView addAppVersion() {

        ModelAndView addCustomer = new ModelAndView("appVersionListEdit");

        addCustomer.addObject("isNew", true);

        return addCustomer;
    }

    @RequestMapping(value = "/edit-version/{appVersionId}", method = RequestMethod.GET)
    public ModelAndView editCustomer(@PathVariable Long appVersionId) {

        ModelAndView editCustomer = new ModelAndView("appVersionListEdit");

       AppVersion appVersion = appVersionService.getAppVersionById(appVersionId);

        editCustomer.addObject("isNew", false);
        editCustomer.addObject("appVersion", appVersion);

        return editCustomer;
    }

    @RequestMapping(value = "/save-new-version", method = RequestMethod.POST)
    public ModelAndView saveNewCustomer(@RequestParam("versionName") String versionName,
                                        @RequestParam("versionCode") Integer versionCode,
                                        @RequestParam("title") String title,
                                        @RequestParam(value = "isImportant", required = false) boolean isImportant,
                                        @RequestParam("description") String description) {


        AppVersion appVersion = new AppVersion(title,description, new Date(), isImportant, versionName, versionCode);
        appVersionService.addNewAppVersion(appVersion);

        return new ModelAndView("redirect:/app-version/edit-version/" +appVersion.getId(), "isEditCreateSuccess", "true");
    }

    @RequestMapping(value = "/update-version/{appVersionId}", method = RequestMethod.POST)
    public ModelAndView updateCustomer(@PathVariable Long appVersionId,
                                       @RequestParam("versionName") String versionName,
                                       @RequestParam("versionCode") Integer versionCode,
                                       @RequestParam("title") String title,
                                       @RequestParam(value = "isImportant", required = false) boolean isImportant,
                                       @RequestParam("description") String description) {

        AppVersion appVersion = appVersionService.getAppVersionById(appVersionId);
        appVersion.setVersionName(versionName);
        appVersion.setVersionCode(versionCode);
        appVersion.setDescription(description);
        appVersion.setTitle(title);
        appVersion.setImportant(isImportant);

        appVersionService.updateAppVersion(appVersion);


        return new ModelAndView("redirect:/app-version/edit-version/" +appVersion.getId(), "isEditCreateSuccess", "true");
    }
}
