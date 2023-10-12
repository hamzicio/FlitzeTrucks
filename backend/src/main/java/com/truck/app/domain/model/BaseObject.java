package com.truck.app.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
@NoArgsConstructor
public abstract class BaseObject implements Serializable {

    @CreationTimestamp
    protected Date createTimestamp = new Date();

    @UpdateTimestamp
    protected Date lastEditTimestamp;
}
