/*******************************************************************************
 * Unpublished work, copyright (c) aMind Solutions LLC 2008-2013. All rights 
 * reserved. This software code and any commented materials or notations 
 * ("Materials") constitute proprietary and confidential  information of aMind 
 * Solutions LLC. The Materials (and any  or material derived therefrom) may not 
 * be reproduced or used, and may not be disclosed or otherwise  made available 
 * to any person, in whole or in part, except in accordance with a written 
 * agreement with aMind or as otherwise expressly authorized in writing by aMind
 ******************************************************************************/

/**
 * @author gia
 *
 */
package com.amind.common.domain;

import com.amind.common.domain.EntityState;

public abstract class BaseEntity extends NamedEntity {

	private static final long serialVersionUID = 5600709702421532600L;

	protected String primaryId = null;

    protected String integrationId = null;

    private EntityState updateState;

    public BaseEntity() {
        updateState = EntityState.UNCHANGED;
    }

    public void setParent(BaseEntity parent) {
        return;
    }
    
    public BaseEntity getParent() {
        return null;
    }

    public boolean needsCurrencyCode() {
        return false;
    }

    public String getCurrencyCode() {
        return null;
    }
    
    public void setCurrencyCode(String currencyCode) {
        return;
    }
    
    public void setId(String id) {
        this.id = id;

        if (primaryId == null)
            primaryId = id;

        //if (integrationId == null)
        //    integrationId = id;
    }

    public String getIntegrationId() {
        return integrationId;
    }

    public void setIntegrationId(String integrationId) {
        this.integrationId = integrationId;
    }

    public String getPrimaryId() {
        return primaryId;
    }

    public void setPrimaryId(String primaryId) {
        this.primaryId = primaryId;
    }

    public EntityState getUpdateState() {
        return updateState;
    }

    public void setUpdateState(EntityState updateState) {
        this.updateState = updateState;
    }

    protected String indent = "";

    public String toString() {

        String buffer = indent
                + "name: "
                + (this.getName() != null ? this.getName() : "")
                + "\n"
                + indent
                + "id: "
                + (this.getId() != null ? this.getId().toString() : "")
                + "\n"
                + indent
                + "primaryId: "
                + (this.getPrimaryId() != null ? this.getPrimaryId() : "")
                + "\n"
                + indent
                + "integrationId: "
                + (this.getIntegrationId() != null ? this.getIntegrationId()
                        : "")
                + "\n"
                + indent
                + "updateState:"
                + (this.getUpdateState() != null ? this.getUpdateState()
                        .toString() : "") + "\n";

        return buffer;

    }

    public void indent(String indent) {
        this.indent = indent + "\t";
    }

    public void indent() {
        indent = indent + "\t";
    }

    public String getIndent() {
        return indent;
    }

    public void setIndent(String indent) {
        this.indent = indent;
    }

}
