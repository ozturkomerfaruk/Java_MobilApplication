package com.ozturkomerfaruk.a31aralik;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class AppController {
    private static AppController mInstance;
    private static Context mCtx;
    private RequestQueue mRequestQueue;

    private AppController (Context context) {
        mCtx = context;
        mRequestQueue = getRequestQueue();
    }

    public static synchronized AppController getInstance(Context context) {
        if(mInstance == null) {
            mInstance = new AppController(context);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if(mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return  mRequestQueue;
    }

    public<T> void addToRequestQueue(final Request<T> request) {
        getRequestQueue().add(request);
    }
}
