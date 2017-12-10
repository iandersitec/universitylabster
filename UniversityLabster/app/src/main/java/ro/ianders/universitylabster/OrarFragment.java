package ro.ianders.universitylabster;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
    }


    private OrarAdapter AdaptorPentruOZiSpecifica(String zi) {

        ArrayList<Curs> cursuri = new ArrayList<>();

        for(Curs curs : DataService.getInstance().cursuri)
            if(curs.getZi().equalsIgnoreCase(zi))
                cursuri.add(curs);

        return new OrarAdapter(getContext(), R.layout.linie_vazut_checkin, cursuri);
    }
}
