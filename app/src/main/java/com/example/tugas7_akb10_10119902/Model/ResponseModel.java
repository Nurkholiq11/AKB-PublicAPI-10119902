package com.example.tugas7_akb10_10119902.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * NIM                  : 10119902
 * Nama                 : Muhammad Nurkholiq
 *
 */

public class ResponseModel {
    @SerializedName("status")
    public String status;
    @SerializedName("data")
    public List<AgentModel> agentList = new ArrayList<>();

    public String getStatus() {return status;}

}
