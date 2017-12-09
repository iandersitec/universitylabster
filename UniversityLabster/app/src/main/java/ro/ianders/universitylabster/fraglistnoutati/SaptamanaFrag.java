package ro.ianders.universitylabster.fraglistnoutati;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import ro.ianders.universitylabster.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SaptamanaFrag extends Fragment {

    ListView lvNoutatiSaptamana;

    public SaptamanaFrag() {
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
        View view = inflater.inflate(R.layout.fragment_saptamana, container, false);
        lvNoutatiSaptamana = view.findViewById(R.id.lvNoutatiSaptamana);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<String> a = new ArrayList<String>() {{
            add("Paul Saptamana"); }};
        lvNoutatiSaptamana.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, a));
    }

}
