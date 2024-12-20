package org.sh.plans.repository;

import org.sh.plans.entity.Monthly;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonthlyRepository extends JpaRepository<Monthly, Long> {
}
