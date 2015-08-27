/*
* WikiModel.java $version 2015. 08. 27.
*
* Copyright 2015 LINE Corporation. All rights Reserved. 
* LINE Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package plateaukao.info.retrofitsample.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Daniel Kao
 */
public class WikiModel {

	private String batchcomplete;
	private Query query;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 *
	 * @return
	 * The batchcomplete
	 */
	public String getBatchcomplete() {
		return batchcomplete;
	}

	/**
	 *
	 * @param batchcomplete
	 * The batchcomplete
	 */
	public void setBatchcomplete(String batchcomplete) {
		this.batchcomplete = batchcomplete;
	}

	/**
	 *
	 * @return
	 * The query
	 */
	public Query getQuery() {
		return query;
	}

	/**
	 *
	 * @param query
	 * The query
	 */
	public void setQuery(Query query) {
		this.query = query;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
