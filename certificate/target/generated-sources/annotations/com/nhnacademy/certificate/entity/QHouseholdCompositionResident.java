package com.nhnacademy.certificate.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHouseholdCompositionResident is a Querydsl query type for HouseholdCompositionResident
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHouseholdCompositionResident extends EntityPathBase<HouseholdCompositionResident> {

    private static final long serialVersionUID = -427204282L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QHouseholdCompositionResident householdCompositionResident = new QHouseholdCompositionResident("householdCompositionResident");

    public final QHousehold household;

    public final com.nhnacademy.certificate.entity.pk.QHouseholdCompositionResidentPK householdCompositionResidentPK;

    public final QResident resident;

    public QHouseholdCompositionResident(String variable) {
        this(HouseholdCompositionResident.class, forVariable(variable), INITS);
    }

    public QHouseholdCompositionResident(Path<? extends HouseholdCompositionResident> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QHouseholdCompositionResident(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QHouseholdCompositionResident(PathMetadata metadata, PathInits inits) {
        this(HouseholdCompositionResident.class, metadata, inits);
    }

    public QHouseholdCompositionResident(Class<? extends HouseholdCompositionResident> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.household = inits.isInitialized("household") ? new QHousehold(forProperty("household"), inits.get("household")) : null;
        this.householdCompositionResidentPK = inits.isInitialized("householdCompositionResidentPK") ? new com.nhnacademy.certificate.entity.pk.QHouseholdCompositionResidentPK(forProperty("householdCompositionResidentPK")) : null;
        this.resident = inits.isInitialized("resident") ? new QResident(forProperty("resident")) : null;
    }

}

