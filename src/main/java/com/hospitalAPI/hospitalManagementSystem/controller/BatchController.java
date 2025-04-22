package ati.lims.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ati.lims.configure.bean.ControllerPathInfo;
import ati.lims.model.User;
import ati.lims.service.BatchService;
import ati.lims.service.IUserService;

@Controller
@RequestMapping(ControllerPathInfo.ROOT_PATH_BATCH_INFO)
public class BatchController {

    @Autowired
    private BatchService batchService;
    @Autowired
    private IUserService userService;
    @RequestMapping("/maintain")
    public ModelAndView maintainBatch(Map<String, Object> model) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.getCurrentUser();
        model.put("user", user);
        modelAndView.addObject("materialList", batchService.getAllProduct("F","Y"));
        modelAndView.addObject("infos", batchService.getAll(null));
        modelAndView.setViewName("production_dashboard/setup_info/batch_info");
        return modelAndView;
    }

    @RequestMapping("/maintainEdit")
    public ModelAndView maintainEdit() {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.getCurrentUser();
        modelAndView.addObject("user",user);
        modelAndView.addObject("materialList", batchService.getAllProduct("F","Y"));
        modelAndView.addObject("infos", batchService.getAll(null));
        modelAndView.setViewName("production_dashboard/setup_info/batch_info_edit");
        return modelAndView;
    }
    @ResponseBody
    @RequestMapping(value = "/save-batch-infos", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView saveBatchInfos(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        Map<String, String[]> requestMap = request.getParameterMap();
        batchService.saveBatchInfos(requestMap);
        modelAndView.addObject("materialList", batchService.getAllProduct("F","Y"));
        modelAndView.addObject("infos", batchService.getAll(null));
        modelAndView.setViewName("production_dashboard/setup_info/batch_info");
        return modelAndView;
    }

}
