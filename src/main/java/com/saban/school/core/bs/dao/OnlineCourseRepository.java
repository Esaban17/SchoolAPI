package com.saban.school.core.bs.dao;

import com.saban.school.core.eis.bo.OnlineCourse;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OnlineCourseRepository extends PagingAndSortingRepository<OnlineCourse, Long> {
}
