
package com.desmond.squarecamera;

import com.tbruyelle.rxpermissions.RxPermissions;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import rx.functions.Action1;


public class CameraActivity extends AppCompatActivity {


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        setTheme(R.style.squarecamera__CameraFullScreenTheme);
        super.onCreate(savedInstanceState);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.squarecamera__activity_camera);

        RxPermissions.getInstance(this)
                .request(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(new Action1<Boolean>() {
                    @Override
                    public void call(Boolean _granted) {
                        if (_granted) {

                            if (savedInstanceState == null) {
                                getSupportFragmentManager()
                                        .beginTransaction()
                                        .replace(R.id.fragment_container, CameraFragment.newInstance(), CameraFragment.TAG)
                                        .commit();
                            }
                        } else {
                            failPermissionCheck();
                        }
                    }
                });


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
    }



    private void failPermissionCheck() {
        Intent data = new Intent();
        if (getParent() == null) {
            setResult(RESULT_CANCELED, data);
        } else {
            getParent().setResult(RESULT_CANCELED, data);
        }
        finish();
    }

    public void returnPhotoUri(Uri uri) {
        Intent data = new Intent();
        data.setData(uri);

        if (getParent() == null) {
            setResult(RESULT_OK, data);
        } else {
            getParent().setResult(RESULT_OK, data);
        }

        finish();
    }


    public void onCancel(View view) {
        getSupportFragmentManager().popBackStack();
    }
}
