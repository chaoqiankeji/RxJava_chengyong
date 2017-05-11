// (c)2016 Flipboard Inc, All Rights Reserved.

package com.rengwuxian.rxjavasamples.network;

import com.rengwuxian.rxjavasamples.model.ZhuangbiImage;
import com.rengwuxian.rxjavasamples.network.api.INetAPI;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {
    private static INetAPI INetAPI;
    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();

    public static INetAPI getZhuangbiApiForRetrofit() {
        //获取实例
        Retrofit retrofit = new Retrofit.Builder()
                //设置OKHttpClient,如果不设置会提供一个默认的
                .client(new OkHttpClient())
                //设置baseUrl
                .baseUrl("http://www.zhuangbi.info/")
                //添加Gson转换器
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        INetAPI service = retrofit.create(INetAPI.class);

        //同步请求
//        Call<List<ZhuangbiImage>> call = service.search("octocat");
//        try {
//            Response<List<ZhuangbiImage>> repos = call.enqueue(new Callback<List<ZhuangbiImage>>() {
//                @Override
//                public void onResponse(Call<List<ZhuangbiImage>> call, Response<List<ZhuangbiImage>> response) {
//
//                }
//
//                @Override
//                public void onFailure(Call<List<ZhuangbiImage>> call, Throwable t) {
//
//                }
//            });
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return service;
    }



    public static INetAPI getINetAPIByRX() {
        if (INetAPI == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl("http://www.zhuangbi.info/")
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            INetAPI = retrofit.create(INetAPI.class);
        }
        return INetAPI;
    }

}
