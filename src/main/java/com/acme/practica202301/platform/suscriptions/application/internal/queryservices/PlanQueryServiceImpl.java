package com.acme.practica202301.platform.suscriptions.application.internal.queryservices;

import com.acme.practica202301.platform.suscriptions.domain.model.aggregates.Plan;
import com.acme.practica202301.platform.suscriptions.domain.model.queries.GetPlanByIdQuery;
import com.acme.practica202301.platform.suscriptions.domain.services.PlanQueryService;
import com.acme.practica202301.platform.suscriptions.infrastructure.persistence.jpa.PlanRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlanQueryServiceImpl implements PlanQueryService {
    private final PlanRepository planRepository;

    public PlanQueryServiceImpl(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }
    @Override
    public Optional<Plan> handle(GetPlanByIdQuery query) {
        return planRepository.findById(query.id());
    }
}
