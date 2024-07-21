package com.example.basic.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

public class AccountListener<A extends Account> implements EntityListener<A> {
    /**
     * Function to be executed before deleting an entity     *
     */
    @Override
    public void preDelete(A a, PreDeleteContext<A> context) {

    }

    /**
     * Function to be executed before updating an entity
     */
    @Override
    public void preUpdate(A a, PreUpdateContext<A> context) {
        a.setUpdatedAt(new java.util.Date());
    }

    /**
     * Function to be executed before inserting an entity
     */
    @Override
    public void preInsert(A a, PreInsertContext<A> context) {
        a.setCreatedAt(new java.util.Date());
        a.setUpdatedAt(new java.util.Date());
    }
}
