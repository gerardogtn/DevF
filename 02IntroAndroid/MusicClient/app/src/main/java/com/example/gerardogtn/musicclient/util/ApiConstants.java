package com.example.gerardogtn.musicclient.util;

/**
 * Created by gerardogtn on 7/14/15.
 */
public class ApiConstants {

    public static final String URL_BASE = "http://ws.audioscrobbler.com";

    public static final String PATH_VERSION = "/2.0";

    public static final String PARAM_KEY = "api_key";
    public static final String PARAM_METHOD = "method";
    public static final String PARAM_FORMAT = "format";

    public static final String VALUE_TOP_TRACKS = "chart.gettoptracks";
    public static final String VALUE_TOP_ARTISTS = "chart.gettopartists";
    public static final String VALUE_JSON = "json";

    public static final String URL_TOP_TRACKS = PATH_VERSION + "?" + PARAM_METHOD + "=" + VALUE_TOP_TRACKS
            + "&" + PARAM_FORMAT + "=" + VALUE_JSON;

    public static final String URL_TOP_ARTISTS = PATH_VERSION + "?" + PARAM_METHOD + "=" + VALUE_TOP_ARTISTS
            + "&" + PARAM_FORMAT + "=" + VALUE_JSON;


    public static String buildTopLink(String value){
        final String output = PATH_VERSION + "?" + PARAM_METHOD + "=" + value
                + "&" + PARAM_FORMAT + "=" + VALUE_JSON;

        return output;
    }

}
