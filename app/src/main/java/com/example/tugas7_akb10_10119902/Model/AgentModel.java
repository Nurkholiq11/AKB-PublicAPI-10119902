package com.example.tugas7_akb10_10119902.Model;

import com.google.gson.annotations.SerializedName;

/**
 *
 * NIM                  : 10119902
 * Nama                 : Muhammad Nurkholiq
 *
 */

public class AgentModel {
    @SerializedName("displayName")
    public String displayName;
    @SerializedName("background")
    public String background;
    @SerializedName("fullPortraitV2")
    public String fullPortraitV2;

    public String getDisplayName() {return displayName;}
    public String getBackground() {return background;}
    public String getFullPortraitV2() {return fullPortraitV2;}
}
