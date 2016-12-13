package com.srbodroid.aicpchangelog;

import android.os.Build;

public class Util {
    String getSerial() {
        return Build.SERIAL;
    }

    String getModel() {
        return Build.MODEL;
    }

    String getID() {
        return Build.ID;
    }

    String getManufacturer() {
        return Build.MANUFACTURER;
    }

    String getBrand() {
        return Build.BRAND;
    }

    String getType() {
        return Build.TYPE;
    }

    String getUser() {
        return Build.USER;
    }

    String getBase() {
        return String.valueOf(Build.VERSION_CODES.BASE);
    }

    String getIncremental() {
        return Build.VERSION.INCREMENTAL;
    }

    String getSDK() {
        return Build.VERSION.SDK;
    }

    String getBoard() {
        return Build.BOARD;
    }

    String getHost() {
        return Build.HOST;
    }

    String getFingerprint() {
        return Build.FINGERPRINT;
    }

    String getVersionCode() {
        return Build.VERSION.RELEASE;
    }
}
