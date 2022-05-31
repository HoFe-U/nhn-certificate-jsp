package com.nhnacademy.certificate.entity.pk;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QHouseholdResidentPk is a Querydsl query type for HouseholdResidentPk
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QHouseholdResidentPk extends BeanPath<HouseholdResidentPk> {

    private static final long serialVersionUID = -1305993534L;

    public static final QHouseholdResidentPk householdResidentPk = new QHouseholdResidentPk("householdResidentPk");

    public final NumberPath<Integer> householdSerialNo = createNumber("householdSerialNo", Integer.class);

    public final NumberPath<Integer> residentSerialNo = createNumber("residentSerialNo", Integer.class);

    public QHouseholdResidentPk(String variable) {
        super(HouseholdResidentPk.class, forVariable(variable));
    }

    public QHouseholdResidentPk(Path<? extends HouseholdResidentPk> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHouseholdResidentPk(PathMetadata metadata) {
        super(HouseholdResidentPk.class, metadata);
    }

}

