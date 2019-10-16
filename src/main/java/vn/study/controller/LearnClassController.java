package vn.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import vn.study.service.LearnClassService;

@Controller
public class LearnClassController {
    @Autowired
    private LearnClassService learnClassService;
}
