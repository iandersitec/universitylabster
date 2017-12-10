package ro.ianders.universitylabster;


import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

import ro.ianders.universitylabster.DataService.DataService;
import ro.ianders.universitylabster.dataformat.User;


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


        String username = new String(), firstName = new String(), lastName = new String();
        String year = new String(), faculty = new String(), password = new String();
        String userID = new String();

        String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();

        for(User user: DataService.getInstance().useri){
            if(user.getEmail() == email){
                userID = user.getUserID();
                username = user.getUsername();
                firstName = user.getFirstName();
                lastName = user.getLastName();
                year = user.getYear();
                faculty = user.getFaculty();
                password = user.getPassword();
            }
        }


        etNume = (EditText) view.findViewById(R.id.etLastName);
        etNume.setEnabled(false);
        etNume.setText(lastName);

        etAn = (EditText) view.findViewById(R.id.etYear);
        etAn.setEnabled(false);
        etAn.setText(year);

        etFacultate = (EditText) view.findViewById(R.id.etFaculty);
        etFacultate.setEnabled(false);
        etFacultate.setText(faculty);

        etEmail = (EditText) view.findViewById(R.id.etEmail);
        etEmail.setEnabled(false);
        etEmail.setText(email);

        etParola = (EditText) view.findViewById(R.id.etPassword);
        etParola.setEnabled(false);
        etParola.setText(password);

        etPrenume = (EditText) view.findViewById(R.id.etFirstName);
        etPrenume.setEnabled(false);
        etPrenume.setText(firstName);


        etUsername = (EditText) view.findViewById(R.id.etUsername);
        etUsername.setEnabled(false);
        etUsername.setText(username);


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
                //etEmail.setEnabled(true);
                etFacultate.setEnabled(true);
                etParola.setEnabled(true);
                etPrenume.setEnabled(true);
                etUsername.setEnabled(true);
                btnEdit.setVisibility(View.INVISIBLE);
                btnSave.setVisibility(View.VISIBLE);
            }
        });

        btnSave = (Button) view.findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = new String(), firstName = new String(), lastName = new String();
                String year = new String(), faculty = new String(), password = new String();

                String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
                String userID = FirebaseAuth.getInstance().getCurrentUser().getUid();

                username = etNume.getText().toString();
                year = etAn.getText().toString();
                faculty = etFacultate.getText().toString();
                firstName = etPrenume.getText().toString();
                lastName = etNume.getText().toString();
                password = etParola.getText().toString();

                User user = new User(userID, email, password, username, firstName, lastName, year, faculty);
                DataService.getInstance().salvareUser(user);

                etNume.setEnabled(false);
                etAn.setEnabled(false);
                //etEmail.setEnabled(false);
                etFacultate.setEnabled(false);
                etParola.setEnabled(false);
                etPrenume.setEnabled(false);
                etUsername.setEnabled(false);

                btnEdit.setVisibility(View.VISIBLE);
                btnSave.setVisibility(View.INVISIBLE);
            }
        });
        return view;
    }

}
