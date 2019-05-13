package com.altimetrikpg.android.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VehicleImageData {

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    private Vehicle vehicle;


    public class Vehicle {

        @SerializedName("EXT020")
        @Expose
        private EXT020 eXT020;
        @SerializedName("INT1")
        @Expose
        private INT1 iNT1;

        public EXT020 getEXT020() {
            return eXT020;
        }

        public void setEXT020(EXT020 eXT020) {
            this.eXT020 = eXT020;
        }

        public INT1 getINT1() {
            return iNT1;
        }

        public void setINT1(INT1 iNT1) {
            this.iNT1 = iNT1;
        }

        public class INT1 {

            @SerializedName("imageSize")
            @Expose
            private String imageSize;
            @SerializedName("url")
            @Expose
            private String url;

            public String getImageSize() {
                return imageSize;
            }

            public void setImageSize(String imageSize) {
                this.imageSize = imageSize;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

        }

        public class EXT020 {

            @SerializedName("imageSize")
            @Expose
            private String imageSize;
            @SerializedName("url")
            @Expose
            private String url;

            public String getImageSize() {
                return imageSize;
            }

            public void setImageSize(String imageSize) {
                this.imageSize = imageSize;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

        }
    }
}
