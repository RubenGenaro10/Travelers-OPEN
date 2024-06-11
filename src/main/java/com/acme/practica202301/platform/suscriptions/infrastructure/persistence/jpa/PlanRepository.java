package com.acme.practica202301.platform.suscriptions.infrastructure.persistence.jpa;

import com.acme.practica202301.platform.suscriptions.domain.model.aggregates.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlanRepository extends JpaRepository<Plan, Long> {
    Optional<Plan> findPlanByName(String name);
}
