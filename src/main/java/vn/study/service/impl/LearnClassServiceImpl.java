package vn.study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import vn.study.model.LearnClass;
import vn.study.repository.LearnClassRepository;
import vn.study.service.LearnClassService;

public class LearnClassServiceImpl implements LearnClassService {
    @Autowired
    LearnClassRepository learnClassRepository;

    @Override
    public Iterable<LearnClass> findAll() {
        return learnClassRepository.findAll();
    }

    @Override
    public LearnClass findById(Integer id) {
        return learnClassRepository.findOne(id);
    }

    @Override
    public LearnClass findOne(Integer id) {
        return learnClassRepository.findOne(id);
    }

    @Override
    public void save(LearnClass learnClass) {
        learnClassRepository.save(learnClass);
    }

    @Override
    public void remove(int id) {
        learnClassRepository.delete(id);
    }
}
