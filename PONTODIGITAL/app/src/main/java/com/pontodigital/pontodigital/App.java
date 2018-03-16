package com.pontodigital.pontodigital;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;

/**
 * Created by rafael on 24/01/18.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Habilite armazenamento local.
        Parse.enableLocalDatastore(this);

        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId("4aL9QCCEpdPVAPldGHMl9YFICvXookD2UjB2sV4N")
                .clientKey("mpo3SWODlMFlPXN2JFxFfKUlnH6ACip9gAaMU44e")
                .server("https://parseapi.back4app.com/")
                .build()
        );

        //ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        // Optionally enable public read access.
        defaultACL.setPublicReadAccess(true);
        //ParseACL.setDefaultACL(defaultACL, true);
    }
}
