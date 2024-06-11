package com.acme.practica202301.platform.suscriptions.interfaces.rest.resources;

public record CreatePlanResource(String name, int maxUsers, int defaultStatus) {

        public CreatePlanResource {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("Name No puede ser nulo o vacío");
            }
            if(maxUsers <= 0){
                throw new IllegalArgumentException("Max users debe ser mayor que 0");
            }
            if (defaultStatus != 1 && defaultStatus != 0) {
                throw new IllegalArgumentException("Default status debe ser 1 o 0");
            }
        }
}
