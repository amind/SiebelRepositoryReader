/*******************************************************************************
 * Unpublished work, copyright (c) aMind Solutions LLC 2008-2013. All rights 
 * reserved. This software code and any commented materials or notations 
 * ("Materials") constitute proprietary and confidential  information of aMind 
 * Solutions LLC. The Materials (and any  or material derived therefrom) may not 
 * be reproduced or used, and may not be disclosed or otherwise  made available 
 * to any person, in whole or in part, except in accordance with a written 
 * agreement with aMind or as otherwise expressly authorized in writing by aMind
 ******************************************************************************/

package com.amind.common.domain;

import com.amind.common.util.StringUtils;

public class NamedEntity extends Entity {

	private static final long serialVersionUID = 3116575175780977039L;

	protected String name;

	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
    public String toString() {

        String buffer = 
                "name: "
                + StringUtils.makeEmptyIfNull(this.getName())
                + "\n"
                + "id: "
                + StringUtils.makeEmptyIfNull(this.getId())
                + "\n";

        return buffer;
    }	
	
}
