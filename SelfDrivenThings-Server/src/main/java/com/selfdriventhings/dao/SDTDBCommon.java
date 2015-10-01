/*
 * Copyright 2002-2008 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.selfdriventhings.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository("sdtDBCommon")
public class SDTDBCommon  extends AbstractDao {
	
	public SDTDBCommon(){
		super();
	}
   
	 @SuppressWarnings("rawtypes")
	 public List selectList(String id, HashMap hm) throws Exception {
		 return list(id, hm);
	 }
	/*
    @DataSource(DatasourceType.Aero)
    public List searchFlightInfo(HashMap<String, String> phmLogDreamFareParam) throws Exception {
    	DatabaseContextHolder.setDatasourceType(DatasourceType.Aero);	// 사용할 DataBase지정
    	List ticketList = new LinkedList();

		try {
			ticketList = defaultDAO.list("com.jeju.aero.common.getFlightInfoOfDEG",  phmLogDreamFareParam);

		} catch (Exception e) {
			//logger.error("IbeDBCommon searchDreamFareMasterLogInfo failed!", e);
		}

		return ticketList;
	}
    */
}
