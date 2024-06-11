package com.acme.practica202301.platform.suscriptions.domain.services;

import com.acme.practica202301.platform.suscriptions.domain.model.aggregates.Plan;
import com.acme.practica202301.platform.suscriptions.domain.model.commands.CreatePlanCommand;

import java.util.Optional;

public interface PlanCommandService {
    Optional<Plan> handle(CreatePlanCommand command);
}
