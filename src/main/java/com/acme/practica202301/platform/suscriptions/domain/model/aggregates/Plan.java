package com.acme.practica202301.platform.suscriptions.domain.model.aggregates;

import com.acme.practica202301.platform.suscriptions.domain.model.commands.CreatePlanCommand;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Plan extends AbstractAggregateRoot<Plan> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(nullable = false)
    @Getter
    private String name;

    @Column(nullable = false)
    @Getter
    private int maxUsers;

    @Column(nullable = false)
    @Getter
    private int defaultStatus;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Date updatedAt;

    protected Plan() {
    }

    public Plan(CreatePlanCommand command) {
        this.name = command.name();
        this.maxUsers = command.maxUsers();
        this.defaultStatus = command.defaultStatus();
    }

}
