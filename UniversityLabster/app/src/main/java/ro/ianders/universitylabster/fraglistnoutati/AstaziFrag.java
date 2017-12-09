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
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

import ro.ianders.universitylabster.R;
import ro.ianders.universitylabster.dataformat.Curs;
import ro.ianders.universitylabster.dataformat.OraFacultate;
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

        ArrayList<OraFacultate> ore = new ArrayList<>();

        Curs c = new Curs("Programarea Orientata pe Obiecte");
        ore.add(c);
        c.addSchedule(new Date(), "10:00", "8:00");

        c = new Curs("Arhitectura Calculatoarelor");
        ore.add(c);
        c.addSchedule(new Date(), "20:00", "18:00");

        OraFacultateAdapter adapter = new OraFacultateAdapter(getContext(), ore);

        lvNoutatiAstazi.setAdapter(adapter);

        lvNoutatiAstazi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "hello", Toast.LENGTH_SHORT).show();
               /* CheckBox cbCheckin = view.findViewById(R.id.cbCheckin);

                if(cbCheckin.isChecked())
                    Toast.makeText(getContext(), "checked", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getContext(), "unchecked", Toast.LENGTH_SHORT).show();

                Log.e("                      ", "you are in");
             //  cbCheckin.setBackground(getResources().getDrawable(R.drawable.noutati_patrat, null)); */
                Toast.makeText(getContext(), "hello", Toast.LENGTH_SHORT).show();

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
