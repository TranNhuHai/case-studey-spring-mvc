package vn.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.study.model.Pupil;
import vn.study.service.PupilService;

@Controller
public class PupilController {
    @Autowired
    private PupilService pupilService;

    @GetMapping("/pupils")
    public ModelAndView listPupils() {
        Iterable<Pupil> pupils = pupilService.findAll();

        ModelAndView modelAndView = new ModelAndView("/pupil/list");
        modelAndView.addObject("pupils", pupils);
        return modelAndView;
    }

    @GetMapping("/create-pupil")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/pupil/create");
        modelAndView.addObject("pupil", new Pupil());
        return modelAndView;
    }
}
