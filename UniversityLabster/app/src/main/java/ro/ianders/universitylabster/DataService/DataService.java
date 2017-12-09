package ro.ianders.universitylabster.DataService;

import android.provider.ContactsContract;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

import ro.ianders.universitylabster.dataformat.Curs;
import ro.ianders.universitylabster.dataformat.User;
import ro.ianders.universitylabster.dataformat.UserAdapter;

/**
 * Created by paul.iusztin on 09.12.2017.
 */

public class DataService {

    private static  DataService instance = new DataService();

    public final ArrayList<User> useri;
    public final ArrayList<Curs> cursuri;
    public final ArrayList<String> linkuri;

    public DatabaseReference databaseReferenceUseri;
    public DatabaseReference databaseReferenceCursuri;
    public DatabaseReference databaseReferenceLinkuri;


    private DataService() {
        useri = new ArrayList<>();
        cursuri = new ArrayList<>();
        linkuri = new ArrayList<>();

        databaseReferenceUseri = FirebaseDatabase.getInstance().getReference("useri");
        databaseReferenceCursuri = FirebaseDatabase.getInstance().getReference("cursuri");
        databaseReferenceLinkuri = FirebaseDatabase.getInstance().getReference("linkuri");

    }

    public static DataService getInstance() {
        return instance;
    }


    public void initializereListneres() {

        databaseReferenceUseri.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                useri.clear();

                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    User user = dataSnapshot1.getValue(User.class);
                    useri.add(user);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        databaseReferenceCursuri.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        databaseReferenceLinkuri.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void salvareUser(User... useri) {


        String key;
        HashMap<String, Object> u = new HashMap<>(); // date de salvat

        for(User user : useri) {
            key = databaseReferenceUseri.push().getKey();
            u.put("useri/"+key, user.toMap());
        }

        databaseReferenceUseri.updateChildren(u); // salveaza useri
    }

}