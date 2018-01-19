package com.example.inventoryfragmentcontentprovider.ui.about;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.inventoryfragmentcontentprovider.R;

import mehdi.sakout.aboutpage.AboutPage;

/**
 * Created by usuario on 2/11/17.
 */

public class AboutActivity extends AppCompatActivity{

    View view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view = new AboutPage(this)
                .isRTL(false)
                .setImage(R.drawable.user)
                .addGroup("Connect with us")
                .addEmail("elmehdi.sakout@gmail.com")
                .addWebsite("http://medyo.github.io/")
                .addFacebook("the.medy")
                .addTwitter("medyo80")
                .addYoutube("UCdPQtdWIsg7_pi4mrRu46vA")
                .addPlayStore("com.ideashower.readitlater.pro")
                .addGitHub("medyo")
                .addInstagram("medyo80")
                .create();

        setContentView(view);
    }
}
