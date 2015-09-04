/*
* DynamicJsonConverter.java $version 2015. 08. 27.
*
* Copyright 2015 LINE Corporation. All rights Reserved. 
* LINE Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package plateaukao.info.retrofitsample.api

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.reflect.Type

import retrofit.converter.ConversionException
import retrofit.converter.Converter
import retrofit.mime.TypedInput
import retrofit.mime.TypedOutput

/**
 * @author Daniel Kao
 */
public class DynamicJsonConverter : Converter {

    throws(IOException::class)
    private fun fromStream(`in`: InputStream): String {
        val reader = BufferedReader(InputStreamReader(`in`))
        val out = StringBuilder()
        var line = reader.readLine()
        while (line != null) {
            out.append(line)
            line = reader.readLine()
        }
        return out.toString()
    }

    throws(ConversionException::class)
    override fun fromBody(typedInput: TypedInput, type: Type): Any {
        try {
            val `in` = typedInput.`in`() // convert the typedInput to String
            val string = fromStream(`in`)
            `in`.close() // we are responsible to close the InputStream after use
            return string

        } catch (e: Exception) {
            // a lot may happen here, whatever happens
            throw ConversionException(e) // wrap it into ConversionException so retrofit can process it
        }


    }

    override fun toBody(`object`: Any): TypedOutput? {
        // not required
        return null
    }
}
