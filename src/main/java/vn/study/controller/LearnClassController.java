package vn.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.study.model.LearnClass;
import vn.study.service.LearnClassService;

@Controller
public class LearnClassController {
    @Autowired
    private LearnClassService learnClassService;
    @GetMapping("/class")
    public ModelAndView listLearnClass(){
        Iterable<LearnClass> learnClasses = learnClassService.findAll();

        ModelAndView modelAndView = new ModelAndView("/class/list");
        modelAndView.addObject("learnClasses", learnClasses);
        return modelAndView;
    }

    @GetMapping("/create-class")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/class/create");
        modelAndView.addObject("learnClass", new LearnClass());
        return modelAndView;
    }

    @PostMapping("/create-class")
    public ModelAndView savePupil(@ModelAttribute("learnClass") LearnClass pupil) {
        learnClassService.save(pupil);
        ModelAndView modelAndView = new ModelAndView("/class/create");
        modelAndView.addObject("learnClass", new LearnClass());
        modelAndView.addObject("message", "add new successfully");
        return modelAndView;
    }
}