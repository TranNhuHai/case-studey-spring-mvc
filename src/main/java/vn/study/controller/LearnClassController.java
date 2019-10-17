package vn.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.study.model.LearnClass;
import vn.study.model.Pupil;
import vn.study.service.LearnClassService;
import vn.study.service.PupilService;

@Controller
public class LearnClassController {
    @Autowired
    private LearnClassService learnClassService;
    @Autowired
    private PupilService pupilService;
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
    @GetMapping("/edit-class/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id) {
        LearnClass learnClass = learnClassService.findById(id);
        if (learnClass != null) {
            ModelAndView modelAndView = new ModelAndView("/class/edit");
            modelAndView.addObject("learnClass", learnClass);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-class")
    public ModelAndView updatePupil(@ModelAttribute("learnClass") LearnClass learnClass) {
        learnClassService.save(learnClass);
        ModelAndView modelAndView = new ModelAndView("/class/edit");
        modelAndView.addObject("learnClass", learnClass);
        modelAndView.addObject("message", " Updated successfully");
        return modelAndView;
    }
    @GetMapping("/delete-class/{id}")
    public ModelAndView showDeleteForm(@PathVariable Integer id){
        LearnClass learnClass = learnClassService.findById(id);
        if(learnClass != null) {
            ModelAndView modelAndView = new ModelAndView("/class/delete");
            modelAndView.addObject("learnClass", learnClass);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-class")
    public String deletePupil(@ModelAttribute("learnClass") LearnClass learnClass){
        learnClassService.remove(learnClass.getId());
        return "redirect:class";
    }
    @GetMapping("/view-class/{id}")
    public ModelAndView viewLearnClass(@PathVariable("id") int id){
        LearnClass learnClass = learnClassService.findById(id);
        if(learnClass == null){
            return new ModelAndView("/error.404");
        }

        Iterable<Pupil> pupils = pupilService.findAllByLearnClass(learnClass);

        ModelAndView modelAndView = new ModelAndView("/class/view");
        modelAndView.addObject("learnClass", learnClass);
        modelAndView.addObject("pupils", pupils);
        return modelAndView;
    }
}