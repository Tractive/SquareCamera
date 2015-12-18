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

    private static SquareCameraSettings mSquareCameraSettings = SquareCameraSettings.defaultSettings();

    public static class Builder {

        private SquareCameraSettings mSquareCameraSettings = new SquareCameraSettings();


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


    public void setCustomSettings(SquareCameraSettings _squareCameraSettings) {
        mSquareCameraSettings = _squareCameraSettings;
    }


    static SquareCameraSettings getCurrentSetting() {
        return mSquareCameraSettings;
    }

    public static SquareCameraSettings defaultSettings() {
        return new Builder()
                .imageFolder(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath() +
                                File.separator + "squarePictures"))
                .okColor(R.color.squarecamera__white)
                .cancelColor(R.color.squarecamera__white)
                .redoColor(R.color.squarecamera__white)
                .build();
    }

}
