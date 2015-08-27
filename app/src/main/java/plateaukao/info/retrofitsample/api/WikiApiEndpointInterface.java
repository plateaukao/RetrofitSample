/*
* WikiApiEndpointInterface.java $version 2015. 08. 27.
*
* Copyright 2015 LINE Corporation. All rights Reserved. 
* LINE Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package plateaukao.info.retrofitsample.api;

import plateaukao.info.retrofitsample.model.WikiModel;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * @author Daniel Kao
 */
public interface WikiApiEndpointInterface {
	@GET("/w/api.php?format=json&action=query&prop=revisions&rvprop=content&rvsection=0&rvparse")
	void geAuthorContent(@Query("titles") String author ,Callback<String> cb);
}
