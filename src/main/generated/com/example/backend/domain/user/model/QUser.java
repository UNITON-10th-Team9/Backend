package com.example.backend.domain.user.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -948234476L;

    public static final QUser user = new QUser("user");

    public final NumberPath<Integer> annual = createNumber("annual", Integer.class);

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath introduce = createString("introduce");

    public final StringPath name = createString("name");

    public final StringPath organization = createString("organization");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final EnumPath<Position> position = createEnum("position", Position.class);

    public final StringPath profileImageUrl = createString("profileImageUrl");

    public final StringPath profileUrl = createString("profileUrl");

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

