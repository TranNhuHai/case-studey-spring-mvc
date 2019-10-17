package vn.study.service;

import vn.study.model.LearnClass;
import vn.study.model.Pupil;

public interface PupilService {

    Iterable<Pupil> findAll();

    Pupil findById(Long id);

    void save(Pupil pupil);

    void remove(Long id);


    Iterable<Pupil> findAllByLearnClass(LearnClass learnClass);
}
