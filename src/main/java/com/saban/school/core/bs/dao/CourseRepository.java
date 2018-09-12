package com.saban.school.core.bs.dao;

import com.saban.school.core.eis.bo.Course;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {
}
