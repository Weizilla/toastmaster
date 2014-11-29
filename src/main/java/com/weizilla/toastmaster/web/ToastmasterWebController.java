package com.weizilla.toastmaster.web;

import com.weizilla.toastmaster.controller.ToastmasterController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ToastmasterWebController
{
    private static final Logger logger = LoggerFactory.getLogger(ToastmasterWebController.class);

    @Autowired
    private ToastmasterController controller;

    @RequestMapping(value = "/tableTopics", method = RequestMethod.GET)
    public String tableTopics(Model model)
    {
        model.addAttribute("topics", controller.getTableTopics());
        return "topics";
    }

    @RequestMapping(value = "/tableTopics/create", method = RequestMethod.POST)
    public String createTableTopic(Model model, @RequestParam String topic)
    {
        controller.createTableTopic(topic);
        return tableTopics(model);
    }

    @RequestMapping(value = "/tableTopics/update", method = RequestMethod.POST)
    public String updateTableTopic(Model model, @RequestParam int id, @RequestParam String topic)
    {
        controller.updateTopic(id, topic);
        return tableTopics(model);
    }

    @RequestMapping(value = "/tableTopics/delete", method = RequestMethod.POST)
    public String deleteTableTopic(Model model, @RequestParam int id)
    {
        controller.deleteTopic(id);
        return tableTopics(model);
    }
}
