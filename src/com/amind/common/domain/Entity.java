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

import java.io.Serializable;

public class Entity implements Serializable {
	
	private static final long serialVersionUID = -697038815357659961L;
	
	protected String id;

	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
}
