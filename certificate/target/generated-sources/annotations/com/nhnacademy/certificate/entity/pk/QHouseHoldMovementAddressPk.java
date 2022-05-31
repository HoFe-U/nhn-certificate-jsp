package com.nhnacademy.certificate.entity.pk;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QHouseHoldMovementAddressPk is a Querydsl query type for HouseHoldMovementAddressPk
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QHouseHoldMovementAddressPk extends BeanPath<HouseHoldMovementAddressPk> {

    private static final long serialVersionUID = -1446428215L;

    public static final QHouseHoldMovementAddressPk houseHoldMovementAddressPk = new QHouseHoldMovementAddressPk("houseHoldMovementAddressPk");

    public final NumberPath<Integer> houseHoldNo = createNumber("houseHoldNo", Integer.class);

    public final DatePath<java.time.LocalDate> houseMovementReportDate = createDate("houseMovementReportDate", java.time.LocalDate.class);

    public QHouseHoldMovementAddressPk(String variable) {
        super(HouseHoldMovementAddressPk.class, forVariable(variable));
    }

    public QHouseHoldMovementAddressPk(Path<? extends HouseHoldMovementAddressPk> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHouseHoldMovementAddressPk(PathMetadata metadata) {
        super(HouseHoldMovementAddressPk.class, metadata);
    }

}

