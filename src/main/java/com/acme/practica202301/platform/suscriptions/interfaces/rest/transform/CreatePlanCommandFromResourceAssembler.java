package com.acme.practica202301.platform.suscriptions.interfaces.rest.transform;

import com.acme.practica202301.platform.suscriptions.domain.model.commands.CreatePlanCommand;
import com.acme.practica202301.platform.suscriptions.interfaces.rest.resources.CreatePlanResource;

public class CreatePlanCommandFromResourceAssembler {
    public static CreatePlanCommand toCommandFromResource(CreatePlanResource resource) {
        return new CreatePlanCommand(resource.name(), resource.maxUsers(), resource.defaultStatus());
    }
}
