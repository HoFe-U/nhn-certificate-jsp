package com.nhnacademy.certificate.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBirthDeathReport is a Querydsl query type for BirthDeathReport
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBirthDeathReport extends EntityPathBase<BirthDeathReport> {

    private static final long serialVersionUID = 674754964L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBirthDeathReport birthDeathReport = new QBirthDeathReport("birthDeathReport");

    public final DatePath<java.time.LocalDate> birthDeathReportDate = createDate("birthDeathReportDate", java.time.LocalDate.class);

    public final com.nhnacademy.certificate.entity.pk.QBirthDeathReportPK birthDeathReportPK;

    public final StringPath birthQualificationCode = createString("birthQualificationCode");

    public final StringPath deathQualificationCode = createString("deathQualificationCode");

    public final StringPath emailAddress = createString("emailAddress");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final QResident resident;

    public QBirthDeathReport(String variable) {
        this(BirthDeathReport.class, forVariable(variable), INITS);
    }

    public QBirthDeathReport(Path<? extends BirthDeathReport> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBirthDeathReport(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBirthDeathReport(PathMetadata metadata, PathInits inits) {
        this(BirthDeathReport.class, metadata, inits);
    }

    public QBirthDeathReport(Class<? extends BirthDeathReport> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.birthDeathReportPK = inits.isInitialized("birthDeathReportPK") ? new com.nhnacademy.certificate.entity.pk.QBirthDeathReportPK(forProperty("birthDeathReportPK")) : null;
        this.resident = inits.isInitialized("resident") ? new QResident(forProperty("resident")) : null;
    }

}

