package com.ramsar.nepalipatrika.http;

import android.os.AsyncTask;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Response;

/**
 * Created by aayushsubedi on 8/26/17.
 */

class HttpAsyncTask extends AsyncTask<Object, Object, Response> {
	
	private final OkHttpClient httpClient;
	private final okhttp3.Request request;
	private final HttpExecutorCallback callback;
	
	private okhttp3.Response response;
	
	
	public HttpAsyncTask(OkHttpClient client, okhttp3.Request request, HttpExecutorCallback callback) {
		this.httpClient = client;
		this.request = request;
		this.callback = callback;
	}
	
	
	@Override
	protected Response doInBackground(Object... params) {
		try {
			response = httpClient.newCall(request).execute();
			return response;
		} catch (IOException e) {
			return null;
		}
	}
	
	@Override
	protected void onPostExecute(Response result) {
		if (callback != null) {
			
			boolean success = false;
			String message = "";
			if (result != null) {
				success = result.isSuccessful();
				message = result.toString();
			}
			
			callback.onResult(success, message);
		}
	}
}
