package com.way.yahoo;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.way.common.util.SystemUtils;

public class App extends Application {
	private static App mApplication;
	private static RequestQueue mVolleyRequestQueue;

	public static synchronized RequestQueue getVolleyRequestQueue() {
		if (mVolleyRequestQueue == null)
			mVolleyRequestQueue = Volley.newRequestQueue(mApplication);
		return mVolleyRequestQueue;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		mApplication = this;
		SystemUtils.copyDB(this);// 程序第一次运行将数据库copy过去
	}
}
