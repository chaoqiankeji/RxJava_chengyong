// (c)2016 Flipboard Inc, All Rights Reserved.

package com.rengwuxian.rxjavasamples.network.api;

import com.rengwuxian.rxjavasamples.model.ZhuangbiImage;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface INetAPI {
//    @GET("search")
//    Call<List<ZhuangbiImage>> search(@Query("q") String query);
    @GET("search")
    Observable<List<ZhuangbiImage>> search(@Query("q") String query);
}
