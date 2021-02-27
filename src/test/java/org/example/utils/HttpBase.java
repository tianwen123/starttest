package org.example.utils;

import com.alibaba.fastjson.JSONArray;
import com.google.gson.JsonObject;
import okhttp3.*;
import org.testng.annotations.Test;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HttpBase {
    public static final MediaType JSON= MediaType.parse("application/json; charset=utf-8");
    public String httpGet(String url) {
        return httpGet(url,new HashMap());
    }
    public String httpGet(String url,Map<String,String> header) {
        Request.Builder builder = new Request.Builder();
        for(String key:header.keySet()){
            builder.header(key,header.get(key));
        }
        final Request request = builder
                .url(url)
                .build();
        return execute(request);
    }
    public String httpPost(String url, Map<String,String> header,Object params) {
        Object jsonObj = JSONArray.toJSON(params);
        RequestBody requestBody = RequestBody.create(JSON, jsonObj.toString());;
        OkHttpClient okHttpClient = new OkHttpClient();
        Request.Builder builder = new Request.Builder();
        for(String key:header.keySet()){
            builder.header(key,header.get(key));
        }
        final Request request = builder
                .url(url)
                .post(requestBody)
                .build();
        return execute(request);
    }
    public String httpFormPost(String url, Map<String,String> header,Map<String,Object> params) {
        RequestBody formBody = new FormBody.Builder()
                .add("platform", "android")
                .add("name", "bug")
                .add("subject", "XXXXXXXXXXXXXXX")
                .build();
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        return execute(request);
    }
    public String execute(Request request){
        OkHttpClient okHttpClient = new OkHttpClient();
        try{
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @Test
    public void tt() {
        String url="";
        url = "http://127.0.0.1:8080/asynchPeople/";
        HashMap<String, String> header = new HashMap<>();
        header.put("Cookie","screenResolution=1536x864; JSESSIONID.e04177a7=node09fax47wl6y5f13hwtpe3isn2v5.node0");
        String v=this.httpGet(url,header);
//        url="http://127.0.0.1:8080/j_spring_security_check";
//        httpPost(url);


    }
}
