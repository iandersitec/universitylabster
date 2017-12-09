package ro.ianders.universitylabster.fraglistnoutati;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ro.ianders.universitylabster.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SaptamanaFrag extends Fragment {


    public SaptamanaFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_saptamana, container, false);
    }

}
