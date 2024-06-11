package com.acme.practica202301.platform.suscriptions.domain.model.commands;

public record CreatePlanCommand(String name, int maxUsers, int defaultStatus) {

    public CreatePlanCommand {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if(maxUsers <= 0){
            throw new IllegalArgumentException("Max users must be greater than 0");
        }
        if (defaultStatus != 1 && defaultStatus != 0) {
            throw new IllegalArgumentException("Default status must be 1 or 0");
        }
    }

}
