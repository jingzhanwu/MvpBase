package com.jzw.mvp.demo.test;


import java.util.List;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * @anthor created by Administrator
 * @date 2017/11/15 0015
 * @change
 * @describe describe
 **/
public interface ApiService {


    @POST("")
    Call<ResultList<DispatchInfo>> getDispatchList(@Body RequestBody body);


    @Multipart
    @POST("")
    Observable<String> uploadFile(@Part List<MultipartBody.Part> partList);

    @POST("")
    Observable<String> uploadFile2(@Body MultipartBody body);

}
