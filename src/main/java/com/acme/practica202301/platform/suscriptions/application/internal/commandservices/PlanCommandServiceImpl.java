package com.acme.practica202301.platform.suscriptions.application.internal.commandservices;

import com.acme.practica202301.platform.suscriptions.domain.model.aggregates.Plan;
import com.acme.practica202301.platform.suscriptions.domain.model.commands.CreatePlanCommand;
import com.acme.practica202301.platform.suscriptions.domain.services.PlanCommandService;
import com.acme.practica202301.platform.suscriptions.infrastructure.persistence.jpa.PlanRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlanCommandServiceImpl implements PlanCommandService {

    private final PlanRepository planRepository;

    public PlanCommandServiceImpl(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    @Override
    public Optional<Plan> handle(CreatePlanCommand command) {
        Optional<Plan> existingPlan = planRepository.findPlanByName(command.name());
        if (existingPlan.isPresent()) {
            throw new IllegalArgumentException("Plan con el nombre " + command.name() + " ya existe");
        }
        var plan = new Plan(command);
        var createdPlan = planRepository.save(plan);
        return Optional.of(createdPlan);
    }
}
