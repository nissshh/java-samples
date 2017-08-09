package com.sample.robo;

public class Position {

    int lat;
    int lng;
    int alt;

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public int getLng() {
        return lng;
    }

    public void setLng(int lng) {
        this.lng = lng;
    }

    public int getAlt() {
        return alt;
    }

    public void setAlt(int alt) {
        this.alt = alt;
    }

    @Override
    public String toString() {
        return "Position [lat=" + lat + ", lng=" + lng + ", alt=" + alt + "]";
    }

}
