package com.pontodigital.pontodigital;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by rafael on 24/01/18.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId("4aL9QCCEpdPVAPldGHMl9YFICvXookD2UjB2sV4N")
                .clientKey("Skd9epUuKsLMF63OAteezDKYDvZglQcl9IXvVNY1")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}
