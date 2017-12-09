package ro.ianders.universitylabster;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabNoutati;

    private BottomNavigationView.OnNavigationItemSelectedListener
            mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            FragmentManager manager = getSupportFragmentManager();

            switch (item.getItemId()) {
                 case R.id.navigationNoutati:
                     manager.beginTransaction()
                             .replace(R.id.linFragments, new NoutatiFragment())
                             .commit();


                    return true;
                case R.id.navigationProfil:
                    manager.beginTransaction()
                            .replace(R.id.linFragments, new ProfilFragment())
                            .commit();


                    return true;
                case R.id.navigationOrar:
                    manager.beginTransaction()
                            .replace(R.id.linFragments, new OrarFragment())
                            .commit();

                  return true;
                case R.id.navigationStudenti:
                    manager.beginTransaction()
                            .replace(R.id.linFragments, new StudentiFragment())
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

        tabNoutati = findViewById(R.id.tabNoutati);
        tabNoutati.addTab(tabNoutati.newTab().setIcon(R.drawable.orar_patrat));
        tabNoutati.addTab(tabNoutati.newTab().setIcon(R.drawable.orar_patrat));
        tabNoutati.addTab(tabNoutati.newTab().setIcon(R.drawable.orar_patrat));
        tabNoutati.setTabGravity(TabLayout.GRAVITY_FILL); // setting tab bar pentru noutati

        //cautat listener pentru tab

        navigation.setSelectedItemId(0);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       toolbar.inflateMenu(R.menu.tab_menu);
       return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) { // pentru optiuni meniu
       /* int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item); */
       return true;
    }
}
