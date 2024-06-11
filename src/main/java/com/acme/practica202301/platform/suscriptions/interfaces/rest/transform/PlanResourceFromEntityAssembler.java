package com.acme.practica202301.platform.suscriptions.interfaces.rest.transform;

import com.acme.practica202301.platform.suscriptions.domain.model.aggregates.Plan;
import com.acme.practica202301.platform.suscriptions.interfaces.rest.resources.PlanResource;

public class PlanResourceFromEntityAssembler {
    public static PlanResource toResourceFromEntity(Plan entity) {
        return new PlanResource(entity.getId(), entity.getName(), entity.getMaxUsers());
    }
}
