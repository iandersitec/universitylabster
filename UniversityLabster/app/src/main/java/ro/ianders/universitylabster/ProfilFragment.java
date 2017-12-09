package ro.ianders.universitylabster;


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

   // private FirebaseAuth firebaseAuth;
    private Button btnLogout;
    private TextView tvNume;
    private TextView tvAn;
    private TextView tvGrupa;
    private TextView tvFacultate;
    private TextView tvSectie;
    private TextView tvSubgrupa;
    private TextView tvDContact;


    public ProfilFragment() {
        // Required empty public constructor
        //firebaseAuth = firebase;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profil, container, false);

        tvNume = (TextView) view.findViewById(R.id.tvNume);
        tvAn = (TextView) view.findViewById(R.id.tvAn);
        tvFacultate = (TextView) view.findViewById(R.id.tvFacultate);
        tvSectie = (TextView) view.findViewById(R.id.tvSectie);
        tvGrupa = (TextView) view.findViewById(R.id.tvGrupa);
        tvDContact = (TextView) view.findViewById(R.id.tvDContact);
        tvSubgrupa = (TextView) view.findViewById(R.id.tvSubgrupa);

        btnLogout = (Button) view.findViewById(R.id.btnLogout);
       /* btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
            }
        });
*/
        return view;
    }

}
