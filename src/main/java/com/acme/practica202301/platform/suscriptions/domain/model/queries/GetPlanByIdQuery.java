package com.acme.practica202301.platform.suscriptions.domain.model.queries;

public record GetPlanByIdQuery(Long id) {
    public GetPlanByIdQuery {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Id must be greater than 0");
        }
    }
}
