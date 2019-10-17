package vn.study.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import vn.study.model.LearnClass;
import vn.study.model.Pupil;

public interface PupilRepository extends PagingAndSortingRepository<Pupil, Long> {
    Iterable<Pupil> findAllByLearnClass(LearnClass learnClass);

 //   Page<Pupil> findAllByNameContaining(String name, Pageable pageable);
}