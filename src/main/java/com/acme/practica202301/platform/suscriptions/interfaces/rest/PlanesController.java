package com.acme.practica202301.platform.suscriptions.interfaces.rest;

import com.acme.practica202301.platform.suscriptions.domain.model.aggregates.Plan;
import com.acme.practica202301.platform.suscriptions.domain.model.queries.GetPlanByIdQuery;
import com.acme.practica202301.platform.suscriptions.domain.services.PlanCommandService;
import com.acme.practica202301.platform.suscriptions.domain.services.PlanQueryService;
import com.acme.practica202301.platform.suscriptions.interfaces.rest.resources.CreatePlanResource;
import com.acme.practica202301.platform.suscriptions.interfaces.rest.resources.PlanResource;
import com.acme.practica202301.platform.suscriptions.interfaces.rest.transform.CreatePlanCommandFromResourceAssembler;
import com.acme.practica202301.platform.suscriptions.interfaces.rest.transform.PlanResourceFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/planes")
public class PlanesController {
    private final PlanCommandService planCommandService;
    private final PlanQueryService planQueryService;

    public PlanesController(PlanCommandService planCommandService, PlanQueryService planQueryService) {
        this.planCommandService = planCommandService;
        this.planQueryService = planQueryService;
    }
    @PostMapping
    public ResponseEntity<PlanResource> createPlan(@RequestBody CreatePlanResource resource) {
       Optional<Plan> Plan= planCommandService.handle(CreatePlanCommandFromResourceAssembler.toCommandFromResource(resource));
        return Plan.map(plan -> new ResponseEntity<>(PlanResourceFromEntityAssembler.toResourceFromEntity(plan),CREATED)).
                orElseGet(()-> ResponseEntity.badRequest().build());
    }

    @GetMapping("{id}")
    public ResponseEntity<PlanResource> getPlanById(@PathVariable Long id) {
        Optional<Plan> Plan = planQueryService.handle(new GetPlanByIdQuery(id));
        return Plan.map(source -> ResponseEntity.ok(PlanResourceFromEntityAssembler.
                        toResourceFromEntity(source))).
                orElseGet(() -> ResponseEntity.notFound().build());
    }


}

    /**
     *    @PostMapping
     *     public ResponseEntity<PlanResource>
     *             createPlan(@RequestBody CreatePlanResource resource) {
     *         Optional<Plan> Plan = PlanCommandService.
     *                 handle(CreatePlanCommandFromResourceAssembler.toCommandFromResource(resource));
     *         return Plan.map(source -> new ResponseEntity<>(
     *                 PlanResourceFromEntityAssembler.toResourceFromEntity(source),CREATED)).
     *                 orElseGet(()-> ResponseEntity.badRequest().build());
     *     }
     */

