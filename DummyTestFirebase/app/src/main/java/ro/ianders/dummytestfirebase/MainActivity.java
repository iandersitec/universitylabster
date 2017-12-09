package ro.ianders.dummytestfirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("a");

       // myRef.setValue("world");


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                DoubleData doubleData = dataSnapshot.getValue(DoubleData.class);
                Log.e("data", doubleData.getA());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


       // myRef.child("b").setValue("am reusit");
        /*
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.setValue("world");
        String key = mDatabase.child("a").push().getKey();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("a/" + "b", "pppp");
        hashMap.put("a/a", "mmmm");
        mDatabase.updateChildren(hashMap);
      */

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

        String key = mDatabase.child("a").push().getKey();
        DoubleData doubleData = new DoubleData("1", "2");
        DoubleData doubleData1 = new DoubleData("3", "cc");
        HashMap<String, Object> m = new HashMap<>();

        m.put("a/" + key, doubleData.toMap());
        key = mDatabase.child("a").push().getKey();
        m.put("a/" + key, doubleData1.toMap());

        mDatabase.updateChildren(m);

    }
}
