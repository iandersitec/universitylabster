package ro.ianders.universitylabster;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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
    private Button btnSave;
    private EditText etNume;
    private EditText etAn;
    private EditText etEmail;
    private EditText etFacultate;
    private EditText etUsername;
    private EditText etPrenume;
    private EditText etParola;


    public ProfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        firebaseAuth = FirebaseAuth.getInstance();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profil, container, false);

        etNume = (EditText) view.findViewById(R.id.etLastName);
        etNume.setEnabled(false);

        etAn = (EditText) view.findViewById(R.id.etYear);
        etAn.setEnabled(false);

        etFacultate = (EditText) view.findViewById(R.id.etFaculty);
        etFacultate.setEnabled(false);

        etEmail = (EditText) view.findViewById(R.id.etEmail);
        etEmail.setEnabled(false);

        etParola = (EditText) view.findViewById(R.id.etPassword);
//        etParola.setEnabled(false);

        etPrenume = (EditText) view.findViewById(R.id.etFirstName);
        etPrenume.setEnabled(false);

        etUsername = (EditText) view.findViewById(R.id.etUsername);
        etUsername.setEnabled(false);

        btnLogout = (Button) view.findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                startActivity(new Intent(getContext(), LoginActivity.class));
                getActivity().finish();
            }
        });

        btnEdit = (Button) view.findViewById(R.id.btnEdit);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                etNume.setEnabled(true);
                etAn.setEnabled(true);
                etEmail.setEnabled(true);
                etFacultate.setEnabled(true);
               // etParola.setEnabled(true);
                etPrenume.setEnabled(true);
                etUsername.setEnabled(true);
                btnEdit.setVisibility(0);
                btnSave.setVisibility(1);
            }
        });

        btnSave = (Button) view.findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                etNume.setEnabled(false);
                etAn.setEnabled(false);
                etEmail.setEnabled(false);
                etFacultate.setEnabled(false);
               // etParola.setEnabled(false);
                etPrenume.setEnabled(false);
                etUsername.setEnabled(false);

                btnEdit.setVisibility(1);
                btnSave.setVisibility(0);
            }
        });
        return view;
    }

}
