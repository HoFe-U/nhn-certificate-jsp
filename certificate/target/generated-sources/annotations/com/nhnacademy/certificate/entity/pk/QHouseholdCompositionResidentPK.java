package com.nhnacademy.certificate.entity.pk;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QHouseholdCompositionResidentPK is a Querydsl query type for HouseholdCompositionResidentPK
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QHouseholdCompositionResidentPK extends BeanPath<HouseholdCompositionResidentPK> {

    private static final long serialVersionUID = -1551166242L;

    public static final QHouseholdCompositionResidentPK householdCompositionResidentPK = new QHouseholdCompositionResidentPK("householdCompositionResidentPK");

    public final NumberPath<Integer> householdNo = createNumber("householdNo", Integer.class);

    public final NumberPath<Integer> residentNo = createNumber("residentNo", Integer.class);

    public QHouseholdCompositionResidentPK(String variable) {
        super(HouseholdCompositionResidentPK.class, forVariable(variable));
    }

    public QHouseholdCompositionResidentPK(Path<? extends HouseholdCompositionResidentPK> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHouseholdCompositionResidentPK(PathMetadata metadata) {
        super(HouseholdCompositionResidentPK.class, metadata);
    }

}

