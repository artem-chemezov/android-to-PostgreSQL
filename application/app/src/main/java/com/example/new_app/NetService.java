package com.example.new_app;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetService {

    private MessageApi msgApi;

    NetService() {

        Retrofit retr = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        this.msgApi = retr
                .create(MessageApi.class);
    }

    public MessageApi getMsgApi() {
        return msgApi;
    }

    public void setMsgApi(MessageApi msgApi) {
        this.msgApi = msgApi;
    }


}
