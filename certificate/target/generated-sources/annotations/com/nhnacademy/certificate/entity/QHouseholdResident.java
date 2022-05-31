package com.nhnacademy.certificate.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHouseholdResident is a Querydsl query type for HouseholdResident
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHouseholdResident extends EntityPathBase<HouseholdResident> {

    private static final long serialVersionUID = -1537490780L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QHouseholdResident householdResident = new QHouseholdResident("householdResident");

    public final QHousehold household;

    public final com.nhnacademy.certificate.entity.pk.QHouseholdResidentPk householdResidentPk;

    public final QResident resident;

    public QHouseholdResident(String variable) {
        this(HouseholdResident.class, forVariable(variable), INITS);
    }

    public QHouseholdResident(Path<? extends HouseholdResident> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QHouseholdResident(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QHouseholdResident(PathMetadata metadata, PathInits inits) {
        this(HouseholdResident.class, metadata, inits);
    }

    public QHouseholdResident(Class<? extends HouseholdResident> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.household = inits.isInitialized("household") ? new QHousehold(forProperty("household"), inits.get("household")) : null;
        this.householdResidentPk = inits.isInitialized("householdResidentPk") ? new com.nhnacademy.certificate.entity.pk.QHouseholdResidentPk(forProperty("householdResidentPk")) : null;
        this.resident = inits.isInitialized("resident") ? new QResident(forProperty("resident")) : null;
    }

}

