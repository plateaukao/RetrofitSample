/*
* WikiAPI.java $version 2015. 08. 27.
*
* Copyright 2015 LINE Corporation. All rights Reserved. 
* LINE Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package plateaukao.info.retrofitsample.api;

import retrofit.RestAdapter;

/**
 * @author Daniel Kao
 */
public class WikiService {
	public static final String API_URL = "https://zh.wikipedia.org";

	private static RestAdapter restAdapter;
	private static WikiApiEndpointInterface interfaceInstance;

	public static WikiApiEndpointInterface getWikiApiEndpointInterface() {
		if(restAdapter==null) {
			restAdapter = new RestAdapter.Builder()
					.setEndpoint(API_URL)
					.setLogLevel(RestAdapter.LogLevel.FULL)
					.setConverter(new DynamicJsonConverter())
					.build();
			interfaceInstance = restAdapter.create(WikiApiEndpointInterface.class);
		}
		return interfaceInstance;
	}
}

