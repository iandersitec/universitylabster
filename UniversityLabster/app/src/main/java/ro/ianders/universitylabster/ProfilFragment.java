package ro.ianders.universitylabster;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfilFragment extends Fragment {

    private FirebaseAuth firebaseAuth;
    private Button btnLogout;
    private Button btnEdit;
    private TextView etNume;
    private TextView etAn;
    private TextView etEmail;
    private TextView etFacultate;
    private TextView etUsername;
    private TextView etPrenume;
    private TextView etParola;


    public ProfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        firebaseAuth = FirebaseAuth.getInstance();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profil, container, false);

        etNume = (TextView) view.findViewById(R.id.etLastName);
        etAn = (TextView) view.findViewById(R.id.etYear);
        etFacultate = (TextView) view.findViewById(R.id.etFaculty);
        etEmail = (TextView) view.findViewById(R.id.etEmail);
        etParola = (TextView) view.findViewById(R.id.etPassword);
        etPrenume = (TextView) view.findViewById(R.id.etFirstName);
        etUsername = (TextView) view.findViewById(R.id.etUsername);

        btnLogout = (Button) view.findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                startActivity(new Intent(getContext(), LoginActivity.class));
                getActivity().finish();
            }
        });

        return view;
    }

}
