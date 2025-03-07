package com.airtribe.user.news.aggregator.UserRepository;

import com.airtribe.user.news.aggregator.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
