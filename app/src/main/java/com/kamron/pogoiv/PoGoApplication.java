package com.kamron.pogoiv;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import timber.log.Timber;

public class PoGoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            CrashlyticsWrapper.init(getApplicationContext());

            Timber.plant(new CrashlyticsWrapper.CrashReportingTree(this));
        }

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

        // Fonts overriding application wide
        FontsOverride.setDefaultFont(this, "DEFAULT", "fonts/Lato-Medium.ttf");
        FontsOverride.setDefaultFont(this, "SANS_SERIF", "fonts/Lato-Medium.ttf");
    }
}
