package vn.study.service;

import vn.study.model.LearnClass;

public interface LearnClassService {
    Iterable<LearnClass> findAll();

    LearnClass findById(int id);

    void save(LearnClass learnClass);

    void remove(int id);
}
