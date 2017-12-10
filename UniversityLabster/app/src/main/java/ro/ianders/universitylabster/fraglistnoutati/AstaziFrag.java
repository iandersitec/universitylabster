package ro.ianders.universitylabster.fraglistnoutati;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.ContactsContract;
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

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.Date;

import ro.ianders.universitylabster.DataService.DataService;
import ro.ianders.universitylabster.R;
import ro.ianders.universitylabster.dataformat.Curs;
import ro.ianders.universitylabster.dataformat.OraFacultateAdapter;
import ro.ianders.universitylabster.dataformat.User;

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


       ArrayList<Curs> cursuri = new ArrayList<>();

        Curs c = new Curs("Intelligence 101", "Faculty of Intelligence", "Building of Intelligence", "1", "12:00", "Luni",
                "10:00", "", "Arnold Einstein");

        c.addCheckin("Iusztin");
        c.addCheckin("Iuonac");

        Curs c1 = new Curs("Intelligence 201", "Faculty of Intelligence", "Building of Intelligence", "2", "13:00", "Joi", "11:00",
                "alber@wiseu.edu", "Alberst Scwarzengger" );

        c1.addCheckin("Mihai");

        cursuri.add(c);
        cursuri.add(c1);

        DataService.getInstance().salvareCurs(cursuri);


        OraFacultateAdapter adapter = new OraFacultateAdapter(getContext(), DataService.getInstance().cursuri);

        for(Curs curs: DataService.getInstance().cursuri)
            Log.e("cuuuuuuuuuurs", curs.getNume());


        Log.e("end curs", "end");

        lvNoutatiAstazi.setAdapter(adapter);

        lvNoutatiAstazi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                ImageView iwChecking = view.findViewById(R.id.iwCheckin);

              /*  if (DataService.getInstance().cursuri.get(position).getCheckings().containsKey(
                        FirebaseAuth.getInstance().getCurrentUser().getEmail())) {

                    String key = FirebaseAuth.getInstance().getCurrentUser().getEmail().split("@")[0];

                    DataService.getInstance().cursuri.get(position).getCheckings().remove(key);
                    iwChecking.setBackgroundResource(R.drawable.cross);

                } else {

                    String key = FirebaseAuth.getInstance().getCurrentUser().getEmail().split("@")[0];
                    DataService.getInstance().cursuri.get(position).getCheckings().put(key, key);
                    iwChecking.setBackgroundResource(R.drawable.check);


                } */


              String[] numeCheckins = DataService.getInstance().cursuri.get(position).getCheckings().split("#");
              boolean esteCheckinuit = false;


                  for (String nume : numeCheckins)
                      for (User user : DataService.getInstance().useri)
                          if (nume.equals(user.getFirstName()) || nume.equals(user.getLastName()))
                              if (user.getEmail().equals(FirebaseAuth.getInstance().getCurrentUser().getEmail()))
                                  esteCheckinuit = true;

              //get user
                User currentUser = null;
                for(User user : DataService.getInstance().useri)
                    if(user.getEmail().equals(FirebaseAuth.getInstance().getCurrentUser().getEmail()))
                        currentUser = user;

              if(esteCheckinuit) {

                    String[] checkIns =  DataService.getInstance().cursuri.get(position).getCheckings().split("#");
                    StringBuilder wholeCheckin = new StringBuilder();

                    for(String s : checkIns)
                        if(currentUser != null)
                            if(!(s.equals(currentUser.getFirstName()) || s.equals(currentUser.getLastName())))
                                wholeCheckin.append(s).append("#");

                  DataService.getInstance().cursuri.get(position).addWholeCheckin(wholeCheckin.toString());

                  iwChecking.setBackgroundResource(R.drawable.cross); // il scoaten de la check in
              } else {

                  if(currentUser != null)
                      DataService.getInstance().cursuri.get(position).addCheckin(currentUser.getLastName());

                  iwChecking.setBackgroundResource(R.drawable.check); // il punem la check in
              }

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
