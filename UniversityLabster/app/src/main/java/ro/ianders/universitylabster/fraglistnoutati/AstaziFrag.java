package ro.ianders.universitylabster.fraglistnoutati;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

import ro.ianders.universitylabster.DataService.DataService;
import ro.ianders.universitylabster.R;
import ro.ianders.universitylabster.dataformat.Curs;
import ro.ianders.universitylabster.dataformat.OraFacultateAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class AstaziFrag extends Fragment {

    private ListView lvNoutatiAstazi;

    public AstaziFrag() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_astazi, container, false);

        lvNoutatiAstazi = view.findViewById(R.id.lvNoutatiAstazi);


        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        Curs[] cursuri = new Curs[2];

        Curs c = new Curs("Intelligence 101", "Faculty of Intelligence", "Building of Intelligence", "1", "12:00", "Luni",
                "Miercuri", "", "Arnold Einstein");

        Curs c1 = new Curs("Intelligence 201", "Faculty of Intelligence", "Building of Intelligence", "2", "13:00", "Joi", "11:00",
                "alber@wiseu.edu", "Alberst Scwarzengger" );

        cursuri[0] = c;
        cursuri[1] = c1;

        DataService.getInstance().salvareCurs(cursuri);


        OraFacultateAdapter adapter = new OraFacultateAdapter(getContext(), DataService.getInstance().cursuri);

        lvNoutatiAstazi.setAdapter(adapter);

        lvNoutatiAstazi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                ImageView iwChecking = view.findViewById(R.id.iwCheckin);



            }
        });



/*
      ArrayList<String> a = new ArrayList<>();

       a.add("Paul");

       lvNoutatiAstazi.setAdapter(new TestAdapter(getContext(), a));

       lvNoutatiAstazi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Toast.makeText(getContext(), "hello", Toast.LENGTH_SHORT).show();
           }
       });*/

    }

}
