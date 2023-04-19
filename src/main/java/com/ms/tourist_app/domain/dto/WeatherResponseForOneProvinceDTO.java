package com.ms.tourist_app.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WeatherResponseForOneProvinceDTO {
    private String cod;
    private int message;
    private int cnt;
    private List<WeatherInfo> list;
    private City city;

    // getter/setter methods go here

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class WeatherInfo {
        private long dt;
        private MainInfo main;
        private List<Weather> weather;
        private Clouds clouds;
        private Wind wind;
        private int visibility;
        private double pop;
        private Sys sys;
        private Rain rain;
        private String dt_txt;

        // getter/setter methods go here

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Rain {

            @JsonProperty("0h")
            private Double zeroHours;

            @JsonProperty("3h")
            private Double threeHours;

            @JsonProperty("6h")
            private Double sixHour;

            @JsonProperty("9h")
            private Double nineHours;

            @JsonProperty("12h")
            private Double twelveHours;

            @JsonProperty("15h")
            private Double fifteenHours;

            @JsonProperty("18h")
            private Double eighteenHours;

            @JsonProperty("21h")
            private Double twentyOneHours;
        }

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class MainInfo {
            private double temp;
            private double feels_like;
            private double temp_min;
            private double temp_max;
            private int pressure;
            private int sea_level;
            private int grnd_level;
            private int humidity;
            private double temp_kf;

            // getter/setter methods go here
        }

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Weather {
            private int id;
            private String main;
            private String description;
            private String icon;

            // getter/setter methods go here
        }

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Clouds {
            private int all;

            // getter/setter methods go here
        }

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Wind {
            private double speed;
            private int deg;
            private double gust;

            // getter/setter methods go here
        }

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Sys {
            private String pod;

            // getter/setter methods go here
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class City {
        private int id;
        private String name;
        private Coord coord;
        private String country;
        private int population;
        private int timezone;
        private long sunrise;
        private long sunset;

        // getter/setter methods go here

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Coord {
            private double lat;
            private double lon;

            // getter/setter methods go here
        }
    }
}
