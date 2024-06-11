package com.acme.practica202301.platform.suscriptions.domain.services;

import com.acme.practica202301.platform.suscriptions.domain.model.aggregates.Plan;
import com.acme.practica202301.platform.suscriptions.domain.model.queries.GetPlanByIdQuery;

import java.util.Optional;

public interface PlanQueryService {
    Optional<Plan> handle(GetPlanByIdQuery query);
}
