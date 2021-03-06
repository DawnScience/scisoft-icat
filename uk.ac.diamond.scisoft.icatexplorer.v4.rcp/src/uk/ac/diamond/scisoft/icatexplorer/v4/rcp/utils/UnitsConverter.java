/*
 * Copyright 2012 Diamond Light Source Ltd.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.ac.diamond.scisoft.icatexplorer.v4.rcp.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UnitsConverter {

	private static final long K = 1024;
	private static final long M = K * K;
	private static final long G = M * K;
	private static final long T = G * K;
	
	private static final Logger logger = LoggerFactory.getLogger(UnitsConverter.class);


	public static String humanReadableByteCount(final long value) {
		final long[] dividers = new long[] { T, G, M, K, 1 };
		final String[] units = new String[] { "TB", "GB", "MB", "KB", "B" };
		if (value < 1)
			logger.error("Invalid file size: " + value);
			//throw new IllegalArgumentException("Invalid file size: " + value);
		String result = null;
		for (int i = 0; i < dividers.length; i++) {
			final long divider = dividers[i];
			if (value >= divider) {
				result = format(value, divider, units[i]);
				break;
			}
		}
		return result;
	}

	private static String format(final long value, final long divider,
			final String unit) {
		final double result = divider > 1 ? (double) value / (double) divider
				: (double) value;
		return new DecimalFormat("#,##0.#").format(result) + " " + unit;
	}


	/*
	 * convert from gregorian calendar to string
	 */
	public static String gregorianToString(XMLGregorianCalendar input) {
		// convert to java.util.Date and then to string
		java.util.Date dt = input.toGregorianCalendar().getTime();
		SimpleDateFormat dateformat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		StringBuilder result = new StringBuilder(dateformat.format(dt));

		return result.toString();
	}

	public static String gregorianToDate(XMLGregorianCalendar input) {
		// convert to java.util.Date and then to string
		if (input != null){
		java.util.Date dt = input.toGregorianCalendar().getTime();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		StringBuilder result = new StringBuilder(dateformat.format(dt));

		return result.toString();
		}else{
			return "uknown";
		}
	}
}
