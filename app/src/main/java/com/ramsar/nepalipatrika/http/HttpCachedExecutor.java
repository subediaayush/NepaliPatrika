package com.ramsar.nepalipatrika.http;

import android.content.Context;

import okhttp3.OkHttpClient;

/**
 * Created by aayushsubedi on 8/8/17.
 */

public class HttpCachedExecutor extends HttpExecutor {
	
	protected HttpCachedExecutor(Context context) {
		super(context);
	}
	
	@Override
	protected OkHttpClient createClient(Context context) {
		return new OkHttpClient.Builder()
				.cache(createCache(context))
				.addNetworkInterceptor(new Interceptors.ResponseCacheInterceptor())
				.addInterceptor(new Interceptors.OfflineResponseCacheInterceptor(context))
				.addInterceptor(new Interceptors.CurlLoggingInterceptor())
				.build();
	}
	
}
