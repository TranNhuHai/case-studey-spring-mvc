package vn.study.formatter;

import org.springframework.format.Formatter;
import vn.study.model.LearnClass;
import vn.study.service.LearnClassService;

import java.text.ParseException;
import java.util.Locale;

public class LearnClassFormatter implements Formatter<LearnClass> {
    private LearnClassService learnClassService;

    public LearnClassFormatter(LearnClassService learnClassService) {
        this.learnClassService = learnClassService;

    }

    @Override
    public LearnClass parse(String text, Locale locale) throws ParseException {
        return learnClassService.findById(Integer.parseInt(text));
    }

    @Override
    public String print(LearnClass object, Locale locale) {
        return "[" + object.getId() + "," + object.getName() + "]";
    }
}