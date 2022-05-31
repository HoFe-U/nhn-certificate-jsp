package com.nhnacademy.certificate.entity.pk;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QFamilyRelationShipPk is a Querydsl query type for FamilyRelationShipPk
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QFamilyRelationShipPk extends BeanPath<FamilyRelationShipPk> {

    private static final long serialVersionUID = 498666463L;

    public static final QFamilyRelationShipPk familyRelationShipPk = new QFamilyRelationShipPk("familyRelationShipPk");

    public final NumberPath<Integer> baseResidentNo = createNumber("baseResidentNo", Integer.class);

    public final NumberPath<Integer> familyResidentNo = createNumber("familyResidentNo", Integer.class);

    public QFamilyRelationShipPk(String variable) {
        super(FamilyRelationShipPk.class, forVariable(variable));
    }

    public QFamilyRelationShipPk(Path<? extends FamilyRelationShipPk> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFamilyRelationShipPk(PathMetadata metadata) {
        super(FamilyRelationShipPk.class, metadata);
    }

}

