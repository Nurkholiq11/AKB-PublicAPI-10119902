package com.example.tugas7_akb10_10119902.API;

import com.example.tugas7_akb10_10119902.Model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 *
 * NIM                  : 10119902
 * Nama                 : Muhammad Nurkholiq
 *
 */

public interface ApiService {
    @GET("v1/agents") Call<ResponseModel> getAgent();
}
