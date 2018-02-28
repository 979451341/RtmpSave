package com.ws.ffmpegandroidavfilter;

/**
 * Created by ZTH on 2018/2/26.
 */

public class NativePlayer {

    static {

        System.loadLibrary("native-lib");
    }



    public static native int saveRTMP(String in,String out);
}
