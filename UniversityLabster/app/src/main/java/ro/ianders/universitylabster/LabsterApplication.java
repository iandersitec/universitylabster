package ro.ianders.universitylabster;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by paul.iusztin on 10.12.2017.
 */

public class LabsterApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseDatabase.getInstance().getReference().child("start").setValue("ready");

    }
}
