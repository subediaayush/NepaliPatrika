package com.ramsar.nepalipatrika.http;

/**
 * Created by aayushsubedi on 9/4/17.
 */

public interface FetchCallback<T> {
	void onDataFetched(T data);
	void onDataFetchFailed(String message);
}
