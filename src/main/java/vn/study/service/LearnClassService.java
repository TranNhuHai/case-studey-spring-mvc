package vn.study.service;

import vn.study.model.LearnClass;

public interface LearnClassService {
    Iterable<LearnClass> findAll();

    LearnClass findById(Integer id);
    LearnClass findOne(Integer id);

    void save(LearnClass learnClass);

    void remove(int id);
}
