package vn.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/create-pupil")
    public ModelAndView savePupil(@ModelAttribute("pupil") Pupil pupil) {
        pupilService.save(pupil);
        ModelAndView modelAndView = new ModelAndView("/pupil/create");
        modelAndView.addObject("pupil", new Pupil());
        modelAndView.addObject("message", "add new successfully");
        return modelAndView;
    }

    @GetMapping("/edit-pupil/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Pupil pupil = pupilService.findById(id);
        if (pupil != null) {
            ModelAndView modelAndView = new ModelAndView("/pupil/edit");
            modelAndView.addObject("pupil", pupil);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-pupil")
    public ModelAndView updatePupil(@ModelAttribute("pupil") Pupil pupil) {
        pupilService.save(pupil);
        ModelAndView modelAndView = new ModelAndView("/pupil/edit");
        modelAndView.addObject("pupil", pupil);
        modelAndView.addObject("message", " Updated successfully");
        return modelAndView;
    }
    @GetMapping("/delete-pupil/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Pupil pupil = pupilService.findById(id);
        if(pupil != null) {
            ModelAndView modelAndView = new ModelAndView("/pupil/delete");
            modelAndView.addObject("pupil", pupil);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-pupil")
    public String deletePupil(@ModelAttribute("pupil") Pupil pupil){
        pupilService.remove(pupil.getId());
        return "redirect:pupils";
    }
}
