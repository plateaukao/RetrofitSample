/*
* WikiAPI.java $version 2015. 08. 27.
*
* Copyright 2015 LINE Corporation. All rights Reserved. 
* LINE Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package plateaukao.info.retrofitsample.api

import retrofit.RestAdapter

/**
 * @author Daniel Kao
 */
public object WikiService {
    public val WIKI_API_URL: String = "https://zh.wikipedia.org"
    public val DICT_API_URL: String = "https://zh.wiktionary.org"

    private var restAdapter: RestAdapter? = null
    private var interfaceInstance: WikiApiEndpointInterface? = null

    public fun getWikiApiEndpointInterface(): WikiApiEndpointInterface {
        if (restAdapter == null) {
            restAdapter = RestAdapter.Builder()
                                    .setEndpoint(WIKI_API_URL)
                                    .setLogLevel(RestAdapter.LogLevel.FULL)
                                    .setConverter(DynamicJsonConverter())
                                    .build()
            interfaceInstance = restAdapter!!.create(javaClass<WikiApiEndpointInterface>())
        }
        return interfaceInstance!!
    }

    public fun getDictApiEndpointInterface(): WikiApiEndpointInterface {
        if (restAdapter == null) {
            restAdapter = RestAdapter.Builder()
                    .setEndpoint(DICT_API_URL)
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setConverter(DynamicJsonConverter())
                    .build()
            interfaceInstance = restAdapter!!.create(javaClass<WikiApiEndpointInterface>())
        }
        return interfaceInstance!!
    }
}

