package ro.ianders.universitylabster;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private Button btnLogout;
    private TextView tvProfilWelcome;

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

        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();
        tvProfilWelcome = (TextView) findViewById(R.id.profil_welcome);
        tvProfilWelcome.setText("Bine ai venit " + user.getEmail());

        //button logout din fragmentul profil
        btnLogout = (Button) findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });



        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        navigation.setSelectedItemId(0);
    }

}
