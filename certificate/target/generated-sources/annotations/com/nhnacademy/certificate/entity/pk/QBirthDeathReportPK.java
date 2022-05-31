package com.nhnacademy.certificate.entity.pk;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBirthDeathReportPK is a Querydsl query type for BirthDeathReportPK
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QBirthDeathReportPK extends BeanPath<BirthDeathReportPK> {

    private static final long serialVersionUID = 413453612L;

    public static final QBirthDeathReportPK birthDeathReportPK = new QBirthDeathReportPK("birthDeathReportPK");

    public final StringPath birthDeathCode = createString("birthDeathCode");

    public final NumberPath<Integer> reportResidentNo = createNumber("reportResidentNo", Integer.class);

    public final NumberPath<Integer> residentNo = createNumber("residentNo", Integer.class);

    public QBirthDeathReportPK(String variable) {
        super(BirthDeathReportPK.class, forVariable(variable));
    }

    public QBirthDeathReportPK(Path<? extends BirthDeathReportPK> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBirthDeathReportPK(PathMetadata metadata) {
        super(BirthDeathReportPK.class, metadata);
    }

}

