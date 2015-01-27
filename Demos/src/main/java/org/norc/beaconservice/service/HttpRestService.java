package org.norc.beaconservice.service;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * 	This is an HTTPRest client used to register the player against the beaconwebservice server
 * 	http://loopj.com/android-async-http/
 * 	Alternative is to use AsyncTask
 * 	http://www.vogella.com/tutorials/AndroidBackgroundProcessing/article.html
 */
public class HttpRestService {
	
	private String base_url = null;
	
	public HttpRestService(String base_url){
		this.base_url = base_url;
	}

	private AsyncHttpClient client = new AsyncHttpClient();

	public void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
		client.get(getAbsoluteUrl(url), params, responseHandler);
	}

	public void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
		client.post(getAbsoluteUrl(url), params, responseHandler);
	}

	private String getAbsoluteUrl(String relativeUrl) {
		return base_url + relativeUrl;
	}
}
