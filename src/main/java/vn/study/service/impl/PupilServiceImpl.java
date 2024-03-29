package vn.study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import vn.study.model.LearnClass;
import vn.study.model.Pupil;
import vn.study.repository.LearnClassRepository;
import vn.study.repository.PupilRepository;
import vn.study.service.PupilService;

public class PupilServiceImpl implements PupilService {
    @Autowired
    private PupilRepository pupilRepository;
    @Autowired
    private LearnClassRepository learnClassRepository;

    @Override
    public Iterable<Pupil> findAll() {
        return pupilRepository.findAll();
    }

    @Override
    public Pupil findById(Long id) {
        return pupilRepository.findOne(id);
    }

    @Override
    public void save(Pupil pupil) {
        pupilRepository.save(pupil);
    }

    @Override
    public void remove(Long id) {
        pupilRepository.delete(id);

    }

    @Override
    public Iterable<Pupil> findAllByLearnClass(LearnClass learnClass) {
        return pupilRepository.findAllByLearnClass(learnClass);
    }


}
