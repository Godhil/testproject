package com.marennikov.app.testproject.controller;

import com.marennikov.app.testproject.entity.*;
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

    //Данный класс нужно доработать, так как при реализации авторизации в приложении из базы
    //данных поиск заявок необходимо осуществлять по ID муниципального образования
    //авторизававшегося пользователя
    //
    //Так как в данный момент авторизация не реализована
    //вместо ID муниципального образования везде используется ID пользователя равный 1

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

    //Список согласованных заявок, сюда id минуципального образования
    @RequestMapping(value = "/approved")
    public String approvedRequests(Model model) {
        model.addAttribute("requestList", requestsService.requestListByStatus("Согласовано"));
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
    //В поле id необходимо указать id авторизовавшегося пользователя
    @RequestMapping("new/{adPlaceId}/{adConstructionId}")
    public String newRequest(
            @PathVariable Integer adPlaceId,
            @PathVariable Integer adConstructionId,
            Integer id,
            Model model) {
        model.addAttribute("request", new Request());
        model.addAttribute("place", adPlaceService.getById(adPlaceId));
        model.addAttribute("construction", adConstructionService.getById(adConstructionId));

        model.addAttribute("user", userService.getById(1));
        return "request/new";
    }

    //Сохранение
    @RequestMapping(value = "/requests", method = RequestMethod.POST)
    public String saveRequest(Request request){
        if (request.getVersion() == null){
            request.setVersion(1);
        } else {
            request.setVersion(request.getVersion() + 1);
        }
        request.setCreateDate(dateNow());
        requestsService.saveRequest(request);

        return "redirect:/requests";
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

    @RequestMapping( value = "/reject", method = RequestMethod.POST)
    public String reject(
                         Integer userId,
                         Request request) {

        request.setAssignee(userService.getById(1));
        request.setVersion(request.getVersion() + 1);
        request.setProcessingDate(dateNow());
        request.setStatus("Отклонена");
        request.setProcessingDate(dateNow());
        requestsService.saveRequest(request);

        saveInArchive(request);

        return "redirect:/approval";
    }

    //Согласование заявки, сюда id редактора
    @RequestMapping("/approve/{id}")
    public String approval(
            @PathVariable Integer id,
            Integer userId) {

        Request request = requestsService.getById(id);
        request.setAssignee(userService.getById(1));
        request.setVersion(request.getVersion() + 1);
        request.setProcessingDate(dateNow());
        request.setRejected("");
        request.setStatus("Согласовано");
        request.setProcessingDate(dateNow());
        requestsService.saveRequest(request);

        saveInArchive(request);

        return "redirect:/approval";
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

    private RequestArchive saveInArchive(Request request) {
        AdPlace adPlace = adPlaceService.getById(request.getAdPlace().getId());
        AdConstruction adConstruction = adConstructionService.getById(request.getAdConstruction().getId());

        RequestArchive requestArchive = new RequestArchive();
        requestArchive.setAssignee(request.getAssignee());
        requestArchive.setVersion(request.getVersion());
        requestArchive.setStatus(request.getStatus());
        requestArchive.setAdPlaceOwner(adPlace.getOwner());
        requestArchive.setAdPlaceAddress(adPlace.getAddress());
        requestArchive.setAdConstructionOwner(adConstruction.getOwner());
        requestArchive.setAdConstructionNumber(adConstruction.getNumber());
        requestArchive.setAdConstructionStatus(adConstruction.getStatus());
        requestArchive.setAdConstructionType(adConstruction.getType());
        requestArchive.setCreateDate(request.getCreateDate());
        requestArchive.setProcessingDate(request.getProcessingDate());
        requestArchive.setRejected(request.getRejected());
        requestArchive.setRequester(request.getRequester());
        requestArchive.setRequest(request);

        return requestsArchiveService.saveRequestArchive(requestArchive);
    }
}
