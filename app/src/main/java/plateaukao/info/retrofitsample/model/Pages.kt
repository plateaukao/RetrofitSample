/*
* Pages.java $version 2015. 08. 27.
*
* Copyright 2015 LINE Corporation. All rights Reserved. 
* LINE Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package plateaukao.info.retrofitsample.model

import java.util.HashMap

/**
 * @author Daniel Kao
 */

public class Pages {

    private val additionalProperties = HashMap<String, Any>()

    public fun getAdditionalProperties(): Map<String, Any> {
        return this.additionalProperties
    }

    public fun setAdditionalProperty(name: String, value: Any) {
        this.additionalProperties.put(name, value)
    }

}