package com.saban.school.core.bs.dao;

import com.saban.school.core.eis.bo.StudentGrade;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentGradeRepository extends PagingAndSortingRepository<StudentGrade, Long> {
}
