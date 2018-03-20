package com.ramsar.nepalipatrika.http;

import android.content.Context;

/**
 * Created by aayushsubedi on 3/14/18.
 */

public class HttpProvider {
	
	private static HttpCachedExecutor sExecutor;
	private static HttpCachelessExecutor sCachelessExecutor;
	
	public static HttpExecutor getExecutor(Context context) {
		if (sExecutor == null) {
			if (context == null) throw new UnsupportedOperationException("Need non null context to initialise http executor");
			sExecutor = new HttpCachedExecutor(context.getApplicationContext());
		}
		
		return sExecutor;
	}
	
	public static HttpExecutor getCachelessExecutor(Context context) {
		if (sCachelessExecutor == null) {
			if (context == null) throw new UnsupportedOperationException("Need non null context to initialise http executor");
			sCachelessExecutor = new HttpCachelessExecutor(context.getApplicationContext());
		}
		
		return sCachelessExecutor;
	}
	
	public static HttpExecutor getExecutor(boolean withCache) {
		if ()
	}
}
