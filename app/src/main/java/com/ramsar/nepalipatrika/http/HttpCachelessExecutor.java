package com.ramsar.nepalipatrika.http;

import android.content.Context;

import okhttp3.OkHttpClient;

/**
 * Created by aayushsubedi on 8/8/17.
 */

public class HttpCachelessExecutor extends HttpExecutor {
	
	protected HttpCachelessExecutor(Context context) {
		super(context);
	}
	
	@Override
	protected OkHttpClient createClient(Context context) {
		return new OkHttpClient.Builder()
				.cache(createCache(context))
				.addNetworkInterceptor(new Interceptors.ResponseCacheInterceptor())
				.addInterceptor(new Interceptors.CurlLoggingInterceptor())
				.build();
	}
	
}
