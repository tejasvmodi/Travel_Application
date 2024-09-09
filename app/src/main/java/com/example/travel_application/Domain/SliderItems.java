package com.example.travel_application.Domain;

public class SliderItems {
    private  String url;

    public SliderItems(){

    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "SliderItems{" +
                "url='" + url + '\'' +
                '}';
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
