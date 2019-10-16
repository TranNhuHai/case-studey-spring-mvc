package vn.study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import vn.study.model.Pupil;
import vn.study.repository.PupilRepository;
import vn.study.service.PupilService;

public class PupilServiceImpl implements PupilService {
    @Autowired
    private PupilRepository pupilRepository;
    @Override
    public Iterable<Pupil> findAll() {
        return pupilRepository.findAll();
    }

    @Override
    public Pupil findById(Long id) {
        return null;
    }

    @Override
    public void save(Pupil pupil) {

    }

    @Override
    public void remove(Long id) {

    }
}
