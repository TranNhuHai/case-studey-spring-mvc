package vn.study.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import vn.study.model.LearnClass;

public interface LearnClassRepository extends PagingAndSortingRepository<LearnClass, Integer> {
}
