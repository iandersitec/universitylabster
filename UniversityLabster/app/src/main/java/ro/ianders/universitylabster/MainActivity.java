package ro.ianders.universitylabster;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import ro.ianders.universitylabster.DataService.DataService;
import ro.ianders.universitylabster.dataformat.Curs;
import ro.ianders.universitylabster.dataformat.User;
import ro.ianders.universitylabster.dataformat.UserAdapter;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private BottomNavigationView.OnNavigationItemSelectedListener
            mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            FragmentManager manager = getSupportFragmentManager();

            switch (item.getItemId()) {
                 case R.id.navigationNoutati:
                     manager.beginTransaction()
                             .replace(R.id.frameMainReplaceFrag, new NoutatiFragment())
                             .commit();

                    return true;
                case R.id.navigationProfil:
                    manager.beginTransaction()
                            .replace(R.id.frameMainReplaceFrag, new ProfilFragment())
                            .commit();

                    return true;
                case R.id.navigationOrar:
                    manager.beginTransaction()
                            .replace(R.id.frameMainReplaceFrag, new OrarFragment())
                            .commit();

                  return true;
                case R.id.navigationStudenti:
                    manager.beginTransaction()
                            .replace(R.id.frameMainReplaceFrag, new StudentiFragment())
                            .commit();

                    return true;

            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);


        toolbar =  findViewById(R.id.tbMeniu);
        setSupportActionBar(toolbar); // setting menu/tool bar

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener); // setting bottom navigation view

        navigation.setSelectedItemId(R.id.navigationProfil); // selectam primul element

    }

    @Override
    protected void onStart() {
        super.onStart();

        DataService.getInstance().initializereListneres();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       toolbar.inflateMenu(R.menu.tab_menu);
       return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) { // pentru optiuni meniu

        if (item.getItemId() == R.id.menuRefresh) {

        DataService.getInstance().salvareCurs(DataService.getInstance().cursuri);
        DataService.getInstance().salvareUser(DataService.getInstance().useri);

        }

       return true;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        DataService.getInstance().salvareCurs(DataService.getInstance().cursuri);
        DataService.getInstance().salvareUser(DataService.getInstance().useri);

    }
}
