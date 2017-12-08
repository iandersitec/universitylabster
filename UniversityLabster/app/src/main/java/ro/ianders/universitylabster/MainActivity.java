package ro.ianders.universitylabster;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {


    private LinearLayout linStudentiTabBar;
    private ImageButton btnTabAstaziNoutati;
    private ImageButton btnTabSaptamanaNoutati;
    private ImageButton btnTabLinkuri;

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

                     linStudentiTabBar.setVisibility(View.VISIBLE);

                    return true;
                case R.id.navigationProfil:
                    manager.beginTransaction()
                            .replace(R.id.linFragments, new ProfilFragment())
                            .commit();

                    if(linStudentiTabBar.getVisibility() == View.VISIBLE)
                        linStudentiTabBar.setVisibility(View.GONE);

                    return true;
                case R.id.navigationOrar:
                    manager.beginTransaction()
                            .replace(R.id.linFragments, new OrarFragment())
                            .commit();

                    if(linStudentiTabBar.getVisibility() == View.VISIBLE)
                        linStudentiTabBar.setVisibility(View.GONE);

                    return true;
                case R.id.navigationStudenti:
                    manager.beginTransaction()
                            .replace(R.id.linFragments, new StudentiFragment())
                            .commit();

                    if(linStudentiTabBar.getVisibility() == View.VISIBLE)
                        linStudentiTabBar.setVisibility(View.GONE);

                    return true;

            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        linStudentiTabBar = findViewById(R.id.linTabStudenti);
        btnTabAstaziNoutati = findViewById(R.id.btnNoutatiAstazi);
        btnTabSaptamanaNoutati = findViewById(R.id.btnNoutatiSaptamana);
        btnTabLinkuri = findViewById(R.id.btnLinkuriPrimite);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        navigation.setSelectedItemId(0);


    }

}
