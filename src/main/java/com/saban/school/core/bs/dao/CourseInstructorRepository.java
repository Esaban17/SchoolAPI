package com.saban.school.core.bs.dao;

import com.saban.school.core.eis.bo.CourseInstructor;
import com.saban.school.core.eis.bo.CourseInstructorId;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CourseInstructorRepository extends PagingAndSortingRepository<CourseInstructor, CourseInstructorId> {
}
