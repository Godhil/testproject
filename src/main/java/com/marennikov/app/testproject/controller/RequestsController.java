package com.marennikov.app.testproject.controller;

import com.marennikov.app.testproject.entity.Request;
import com.marennikov.app.testproject.entity.RequestArchive;
import com.marennikov.app.testproject.entity.User;
import com.marennikov.app.testproject.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
public class RequestsController {

    private IRequestService requestsService;

    private IUserService userService;

    private IAdPlaceService adPlaceService;

    private IAdConstructionService adConstructionService;

    private IRequestsArchiveService requestsArchiveService;

    @Autowired
    public void setRequestsService(IRequestService requestsService) {
        this.requestsService = requestsService;
    }

    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setAdPlaceService(IAdPlaceService adPlaceService) {
        this.adPlaceService = adPlaceService;
    }

    @Autowired
    public void setAdConstructionService(IAdConstructionService adConstructionService) {
        this.adConstructionService = adConstructionService;
    }

    @Autowired
    public void setRequestsArchiveService(IRequestsArchiveService requestsArchiveService) {
        this.requestsArchiveService = requestsArchiveService;
    }

    //Список заявок инициатора, сюда id инициатора
    @RequestMapping("/requests")
    public String requestListByRequesterId(Integer id, Model model) {
        model.addAttribute("requestList", requestsService.requestListByRequesterIdNotApproved(1, "Согласовано"));
        return "request/requests";
    }

    //Список заявок ожидающих согласования
    @RequestMapping(value = "/approval", method = RequestMethod.GET)
    public String waitApproval(Model model) {
        model.addAttribute("requestList", requestsService.requestListByStatus("Отправлена на согласование"));
        return "request/waitapproval";
    }

    //Список согласованных заявок, сюда id инициатора, не инициатора а минуципального образования
    @RequestMapping(value = "/approved")
    public String approvedRequests(Integer id, Model model) {
        model.addAttribute("requestList", requestsService.requestListByRequesterIdApproved(1, "Согласовано"));
        return "request/approved";
    }

    //Заявка + последняя версия заявки из архива
    @RequestMapping("/view/{id}")
    public String viewRequest(@PathVariable Integer id, Model model) {
        model.addAttribute("request", requestsService.getById(id));
        model.addAttribute("fromArchive", requestsArchiveService.getByRequesterIdWithLastVersion(id));
        return "request/view";
    }

    //Новая заявка
    @RequestMapping("new/{adPlaceId}/{adConstructionId}")
    public String newRequest(
            @PathVariable Integer adPlaceId,
            @PathVariable Integer adConstructionId,
            Integer id,
            Model model) {
        model.addAttribute("request", new Request());
        model.addAttribute("place", adPlaceService.getById(adPlaceId));
        model.addAttribute("construction", adConstructionService.getById(adConstructionId));
        //сюда юзера который зашел в приложение
        model.addAttribute("user", userService.getById(1));
        return "request/new";
    }

    //Сохранение
    @RequestMapping(value = "/requests", method = RequestMethod.POST)
    public String saveRequest(Request request){

        System.out.println(request.toString());
        System.out.println(request.getAdPlace().toString());
        System.out.println(request.getAdConstruction().toString());

        if (request.getVersion() == null){
            request.setVersion(1);
        } else {
            request.setVersion(request.getVersion() + 1);
        }

        request.setCreateDate(dateNow());
        requestsService.saveRequest(request);
        return "redirect:/requests";
    }

    //Согласование заявки, сюда id редактора
    @RequestMapping(value = "/approve", method = RequestMethod.POST)
    public String approvalRequest(
            Integer userId,
            Request request,
            RequestArchive requestArchive){

        request.setAssignee(userService.getById(1));
        int actualVersion = request.getVersion() + 1;
        request.setVersion(actualVersion);
        request.setProcessingDate(dateNow());
        requestsService.saveRequest(request);

        requestArchive.setAssignee(request.getAssignee());
        requestArchive.setVersion(request.getVersion());
        requestArchive.setStatus(request.getStatus());
        requestArchive.setAdConstructionId(request.getAdConstruction());
        requestArchive.setAdPlace(request.getAdPlace());
        requestArchive.setCreateDate(request.getCreateDate());
        requestArchive.setProcessingDate(request.getProcessingDate());
        requestArchive.setRejected(request.getRejected());
        requestArchive.setRequester(request.getRequester());
        requestArchive.setRequest(request);
        requestsArchiveService.saveRequestArchive(requestArchive);

        return "redirect:/approval";
    }


    //отключение(установить флаг "Delete")
    @RequestMapping(value = "/request/delete/{id}", method = RequestMethod.POST)
    public String setDelete(@PathVariable Integer id){
        Request request = requestsService.getById(id);
        requestsService.setDeleteActiveStatus(request);
        return "redirect:/requests";
    }

    //Отправить на согласование
    @RequestMapping("/send/{id}")
    public String toApproval(@PathVariable Integer id) {
        Request request = requestsService.getById(id);
        request.setStatus("Отправлена на согласование");
        request.setProcessingDate(dateNow());
        requestsService.saveRequest(request);
        return "redirect:/requests";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("request", requestsService.getById(id));
        return "request/edit";
    }


    private String dateNow(){
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        String reportDate = df.format(today);
        System.out.println(reportDate);

        return reportDate;
    }
}
