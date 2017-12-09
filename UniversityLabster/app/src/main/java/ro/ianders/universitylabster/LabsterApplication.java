package ro.ianders.universitylabster;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

import ro.ianders.universitylabster.DataService.DataService;

/**
 * Created by paul.iusztin on 10.12.2017.
 */

public class LabsterApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

       // DataService.createInstance();
        FirebaseDatabase.getInstance().getReference().child("start").setValue("ready");

    }
}
