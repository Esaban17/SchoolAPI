package com.saban.school.core.bs.dao;

import com.saban.school.core.eis.bo.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    User findByUsername(String username);
}
