package ro.ianders.universitylabster.fraglistnoutati;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

import ro.ianders.universitylabster.DataService.DataService;
import ro.ianders.universitylabster.R;
import ro.ianders.universitylabster.dataformat.Curs;
import ro.ianders.universitylabster.dataformat.OraFacultateAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class SeeCheckInFrag extends Fragment {

    private ListView lvCheckins;
    private ListView lvNumeChekins;

    public SeeCheckInFrag() {
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
        View view = inflater.inflate(R.layout.fragment_vazut_checkinuri, container, false);
        lvCheckins = view.findViewById(R.id.lvCheckinuri);
        lvNumeChekins = view.findViewById(R.id.lvNumeCheckinuri);




        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayAdapter<Curs> currentAdapter = new OraFacultateAdapter(getContext(), R.layout.linie_vazut_checkin, DataService.getInstance().cursuri);

        lvCheckins.setAdapter(currentAdapter);

        //pentru inceput daca exista cursuri afiseaza checkinurile de la primul curs
        if(DataService.getInstance().cursuri != null) {
            String[] checkins = DataService.getInstance().cursuri.get(0).getCheckings().split("#");
            List<String> arrayList = Arrays.asList(checkins);

            lvNumeChekins.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.select_dialog_item, arrayList));
        }

        lvCheckins.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String[] checkins = DataService.getInstance().cursuri.get(position).getCheckings().split("#");
                List<String> arrayList = Arrays.asList(checkins);

                lvNumeChekins.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.select_dialog_item, arrayList));

            }
        });



    }

}
