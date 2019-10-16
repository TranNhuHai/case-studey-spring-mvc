package vn.study.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import vn.study.model.Pupil;

public interface PupilRepository extends PagingAndSortingRepository<Pupil, Long> {}