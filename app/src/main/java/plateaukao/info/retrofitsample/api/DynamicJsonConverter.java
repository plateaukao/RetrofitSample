/*
* DynamicJsonConverter.java $version 2015. 08. 27.
*
* Copyright 2015 LINE Corporation. All rights Reserved. 
* LINE Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package plateaukao.info.retrofitsample.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

import retrofit.converter.ConversionException;
import retrofit.converter.Converter;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

/**
 * @author Daniel Kao
 */
public class DynamicJsonConverter implements Converter {

	private static String fromStream(InputStream in) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		StringBuilder out = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			out.append(line);

		}
		return out.toString();
	}

	@Override
	public Object fromBody(TypedInput typedInput, Type type) throws ConversionException {
		try {
			InputStream in = typedInput.in(); // convert the typedInput to String
			String string = fromStream(in);
			in.close(); // we are responsible to close the InputStream after use
			return string;

		} catch (Exception e) { // a lot may happen here, whatever happens
			throw new ConversionException(e); // wrap it into ConversionException so retrofit can process it
		}

	}

	@Override
	public TypedOutput toBody(Object object) { // not required
		return null;
	}
}
