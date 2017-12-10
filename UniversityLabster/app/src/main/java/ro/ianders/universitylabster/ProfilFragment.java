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

import java.util.ArrayList;

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





        etNume = (EditText) view.findViewById(R.id.etLastName);


        etAn = (EditText) view.findViewById(R.id.etYear);


        etFacultate = (EditText) view.findViewById(R.id.etFaculty);


        etEmail = (EditText) view.findViewById(R.id.etEmail);


        etParola = (EditText) view.findViewById(R.id.etPassword);


        etPrenume = (EditText) view.findViewById(R.id.etFirstName);



        etUsername = (EditText) view.findViewById(R.id.etUsername);

        update_profil();

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

                username = etUsername.getText().toString().trim();
                year = etAn.getText().toString().trim();
                faculty = etFacultate.getText().toString().trim();
                firstName = etPrenume.getText().toString().trim();
                lastName = etNume.getText().toString().trim();
                password = etParola.getText().toString().trim();

                User user = new User(userID, email, password, username, firstName, lastName, year, faculty);

                ArrayList<User> newUserList = new ArrayList<>();

                for(User u: DataService.getInstance().useri)
                    if(!u.equals(user))
                        newUserList.add(u);
                newUserList.add(user);

                DataService.getInstance().salvareUser(newUserList);

                update_profil();
                /*etNume.setEnabled(false);
                etAn.setEnabled(false);
                etFacultate.setEnabled(false);
                etParola.setEnabled(false);
                etPrenume.setEnabled(false);
                etUsername.setEnabled(false);*/

                btnEdit.setVisibility(View.VISIBLE);
                btnSave.setVisibility(View.INVISIBLE);
            }
        });
        return view;
    }
    private void update_profil(){
        String username = new String(), firstName = new String(), lastName = new String();
        String year = new String(), faculty = new String(), password = new String();


        String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        User u = new User("testid",email,"password");

        for(User user: DataService.getInstance().useri){
            if(user.equals(u)){
                username = user.getUsername();
                firstName = user.getFirstName();
                lastName = user.getLastName();
                year = user.getYear();
                faculty = user.getFaculty();
                password = user.getPassword();
            }
        }

        etNume.setEnabled(false);
        etNume.setText(lastName);

        etAn.setEnabled(false);
        etAn.setText(year);

        etFacultate.setEnabled(false);
        etFacultate.setText(faculty);

        etEmail.setEnabled(false);
        etEmail.setText(email);

        etPrenume.setEnabled(false);
        etPrenume.setText(firstName);

        etParola.setEnabled(false);
        etParola.setText(password);

        etUsername.setEnabled(false);
        etUsername.setText(username);
    }

}
