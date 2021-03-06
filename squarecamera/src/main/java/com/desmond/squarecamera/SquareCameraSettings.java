package com.desmond.squarecamera;

import android.os.Environment;
import android.support.annotation.ColorRes;

import java.io.File;

/**
 * Created by stephan on 18/12/15.
 */
public class SquareCameraSettings {

    File imageFolder;
    @ColorRes int okColor;
    @ColorRes int cancelColor;
    @ColorRes int redoColor;

    private static SquareCameraSettings sSquareCameraSettings = SquareCameraSettings.defaultSettings();


    public static class Builder {

        private SquareCameraSettings mSquareCameraSettings = SquareCameraSettings.defaultSettings();


        public Builder imageFolder(File _location) {
            mSquareCameraSettings.imageFolder = _location;
            return this;
        }

        public Builder okColor(@ColorRes int _colorResource) {
            mSquareCameraSettings.okColor = _colorResource;
            return this;
        }

        public Builder cancelColor(@ColorRes int _colorResource) {
            mSquareCameraSettings.cancelColor = _colorResource;
            return this;
        }

        public Builder redoColor(@ColorRes int _colorResource) {
            mSquareCameraSettings.redoColor = _colorResource;
            return this;
        }


        public SquareCameraSettings build() {
            return mSquareCameraSettings;
        }


    }


    public static void setCustomSettings(SquareCameraSettings _squareCameraSettings) {
        sSquareCameraSettings = _squareCameraSettings;
    }


    static SquareCameraSettings getCurrentSetting() {
        return sSquareCameraSettings;
    }

    public static SquareCameraSettings defaultSettings() {

        SquareCameraSettings settings = new SquareCameraSettings();

        settings.imageFolder = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath() +
                File.separator + "squarePictures");
        settings.okColor = R.color.squarecamera__white;
        settings.cancelColor = R.color.squarecamera__white;
        settings.redoColor = R.color.squarecamera__white;
        return settings;
    }

}
