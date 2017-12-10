package ro.ianders.universitylabster;


import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import ro.ianders.universitylabster.DataService.DataService;
import ro.ianders.universitylabster.dataformat.Curs;
import ro.ianders.universitylabster.dataformat.OraFacultateAdapter;
import ro.ianders.universitylabster.dataformat.OrarAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class OrarFragment extends Fragment {

    private TabLayout tabOrar;
    private ListView lvOrar;

    private EditText etAdresa;
    private EditText etAn;
    private EditText etEmailProfesor;
    private EditText etTimp;
    private EditText etFacultate;
    private EditText etNume;
    private EditText etNumeProfesor;
    private EditText etZi;

    private Button btnAdaugaCurs;
    private Button btnSalveazaCurs;

    public OrarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_orar, container, false);

        tabOrar = view.findViewById(R.id.tabOrar);
        tabOrar.addTab(tabOrar.newTab().setText("L").setTag("luni"));
        tabOrar.addTab(tabOrar.newTab().setText("M").setTag("marti"));
        tabOrar.addTab(tabOrar.newTab().setText("M").setTag("miercuri"));
        tabOrar.addTab(tabOrar.newTab().setText("J").setTag("joi"));
        tabOrar.addTab(tabOrar.newTab().setText("V").setTag("vineri"));
        tabOrar.setTabGravity(TabLayout.GRAVITY_FILL); // setting tab bar pentru noutati

        etAdresa = view.findViewById(R.id.etAdresaCursNou);
        etAn = view.findViewById(R.id.etAnCursNou);
        etEmailProfesor = view.findViewById(R.id.etEmaiProfesorCursNou);
        etTimp = view.findViewById(R.id.etTimpCursNou);
        etFacultate = view.findViewById(R.id.etFacultateCursNou);
        etNume = view.findViewById(R.id.etNumeCursNou);
        etNumeProfesor = view.findViewById(R.id.etNumeProfesorCursNou);
        etZi = view.findViewById(R.id.etAZiCursNou);

        btnAdaugaCurs = view.findViewById(R.id.btnAdaugaCurs);
        btnSalveazaCurs = view.findViewById(R.id.btnSalveazaCurs);


        lvOrar = view.findViewById(R.id.lvOrar);

        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        /*ArrayList<Curs> cursuriLuni = new ArrayList<>();

        for(Curs curs : DataService.getInstance().cursuri)
            if(curs.getZi().equalsIgnoreCase("luni"))
                cursuriLuni.add(curs);

        ArrayAdapter<Curs> arrayAdapterLuni = new OraFacultateAdapter(getContext(), R.layout.linie_vazut_checkin, cursuriLuni);*/
        lvOrar.setAdapter(AdaptorPentruOZiSpecifica("luni"));



        tabOrar.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getTag().toString()) {
                    case "luni":
                        lvOrar.setAdapter(AdaptorPentruOZiSpecifica("luni"));
                        break;

                    case "marti":
                        lvOrar.setAdapter(AdaptorPentruOZiSpecifica("marti"));
                        break;

                    case "miercuri":
                        lvOrar.setAdapter(AdaptorPentruOZiSpecifica("miercuri"));
                        break;

                    case "joi":
                        lvOrar.setAdapter(AdaptorPentruOZiSpecifica("joi"));
                        break;

                    case "vineri":
                        lvOrar.setAdapter(AdaptorPentruOZiSpecifica("vineri"));
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



        btnAdaugaCurs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etAdresa.setVisibility(View.VISIBLE);
                etAn.setVisibility(View.VISIBLE);
                etEmailProfesor.setVisibility(View.VISIBLE);
                etTimp.setVisibility(View.VISIBLE);
                etFacultate.setVisibility(View.VISIBLE);
                etNume.setVisibility(View.VISIBLE);
                etNumeProfesor.setVisibility(View.VISIBLE);
                etZi.setVisibility(View.VISIBLE);

                btnSalveazaCurs.setVisibility(View.VISIBLE);


                lvOrar.setVisibility(View.GONE);

            }
        });

        btnSalveazaCurs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String adresa = etAdresa.getText().toString().trim();
                String an = etAn.getText().toString().trim();
                String emailProfesor = etEmailProfesor.getText().toString().trim();
                String timp = etTimp.getText().toString().trim();
                String facultate = etFacultate.getText().toString().trim();
                String nume = etNume.getText().toString().trim();
                String numeProfesor = etNumeProfesor.getText().toString().trim();
                String zi = etZi.getText().toString().trim();


                String endTime = timp.split("-")[1];
                String startTime = timp.split("-")[0];

                Curs newCurs = new Curs(nume, facultate, adresa, an, endTime, zi, startTime, emailProfesor, numeProfesor, "5");
                //newCurs.setIncercariPanaLaIntroducereInOrar();
                DataService.getInstance().cursuri.add(newCurs);

                if(adresa == null || an == null || emailProfesor == null || timp == null || facultate == null || nume == null || numeProfesor == null || zi == null) {
                    Toast.makeText(getContext(), "Introduceti toate datele!", Toast.LENGTH_SHORT).show();
                } else {

                    etAdresa.setVisibility(View.GONE);
                    etAn.setVisibility(View.GONE);
                    etEmailProfesor.setVisibility(View.GONE);
                    etTimp.setVisibility(View.GONE);
                    etFacultate.setVisibility(View.GONE);
                    etNume.setVisibility(View.GONE);
                    etNumeProfesor.setVisibility(View.GONE);
                    etZi.setVisibility(View.GONE);

                    btnSalveazaCurs.setVisibility(View.GONE);


                    lvOrar.setVisibility(View.VISIBLE);
                }
            }
        });


        lvOrar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView incercari = view.findViewById(R.id.tvIncercari);

                Curs currentCurs = DataService.getInstance().cursuri.get(position);
                currentCurs.scadePanaLaIntroducereInOrar();

                incercari.setText(currentCurs.getIncercariPanaLaIntroducereInOrar());

                if(currentCurs.getIncercariPanaLaIntroducereInOrar().equals("1")) {
                    incercari.setVisibility(View.GONE);
                }
            }
        });
    }


    private OrarAdapter AdaptorPentruOZiSpecifica(String zi) {

        ArrayList<Curs> cursuri = new ArrayList<>();

        for(Curs curs : DataService.getInstance().cursuri)
            if(curs.getZi().equalsIgnoreCase(zi))
                cursuri.add(curs);

        return new OrarAdapter(getContext(), R.layout.linie_vazut_checkin, cursuri);
    }
}
