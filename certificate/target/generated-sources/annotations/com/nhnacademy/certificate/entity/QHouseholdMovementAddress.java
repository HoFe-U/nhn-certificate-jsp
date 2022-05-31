package com.nhnacademy.certificate.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHouseholdMovementAddress is a Querydsl query type for HouseholdMovementAddress
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHouseholdMovementAddress extends EntityPathBase<HouseholdMovementAddress> {

    private static final long serialVersionUID = 1445643889L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QHouseholdMovementAddress householdMovementAddress = new QHouseholdMovementAddress("householdMovementAddress");

    public final com.nhnacademy.certificate.entity.pk.QHouseHoldMovementAddressPk holdMovementAddress;

    public final QHousehold household;

    public final StringPath houseMovementAddress = createString("houseMovementAddress");

    public final StringPath lastAddress = createString("lastAddress");

    public QHouseholdMovementAddress(String variable) {
        this(HouseholdMovementAddress.class, forVariable(variable), INITS);
    }

    public QHouseholdMovementAddress(Path<? extends HouseholdMovementAddress> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QHouseholdMovementAddress(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QHouseholdMovementAddress(PathMetadata metadata, PathInits inits) {
        this(HouseholdMovementAddress.class, metadata, inits);
    }

    public QHouseholdMovementAddress(Class<? extends HouseholdMovementAddress> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.holdMovementAddress = inits.isInitialized("holdMovementAddress") ? new com.nhnacademy.certificate.entity.pk.QHouseHoldMovementAddressPk(forProperty("holdMovementAddress")) : null;
        this.household = inits.isInitialized("household") ? new QHousehold(forProperty("household"), inits.get("household")) : null;
    }

}

