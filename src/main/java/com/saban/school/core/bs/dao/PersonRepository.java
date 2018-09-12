package com.saban.school.core.bs.dao;

import com.saban.school.core.eis.bo.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
}
