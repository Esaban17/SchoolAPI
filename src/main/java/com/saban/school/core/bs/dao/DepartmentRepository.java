package com.saban.school.core.bs.dao;

import com.saban.school.core.eis.bo.Department;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DepartmentRepository extends PagingAndSortingRepository<Department, Long> {
}
