package vn.study.formatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import vn.study.model.LearnClass;
import vn.study.service.LearnClassService;

import java.text.ParseException;
import java.util.Locale;

@Component
public class LearnClassFormatter implements Formatter<LearnClass> {

    private LearnClassService learnClassService;

    @Autowired
    public LearnClassFormatter(LearnClassService learnClassService) {
        this.learnClassService = learnClassService;
    }

    @Override
    public LearnClass parse(String text, Locale locale) throws ParseException {
        return learnClassService.findById(Integer.parseInt(text));
    }

    @Override
    public String print(LearnClass object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }

}