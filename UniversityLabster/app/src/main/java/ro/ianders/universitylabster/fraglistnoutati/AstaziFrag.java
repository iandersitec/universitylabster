package ro.ianders.universitylabster.fraglistnoutati;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ro.ianders.universitylabster.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AstaziFrag extends Fragment {

    private int fragVal;


    public AstaziFrag() {
        // Required empty public constructor
    }

    public static AstaziFrag init(int val) {
        AstaziFrag frag = new AstaziFrag();

        Bundle args = new Bundle(); // dictionar cu chei stringuri
        args.putInt("val", val);
        frag.setArguments(args); // ia argumente ca si bundle
        return frag;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragVal = getArguments() != null ? getArguments().getInt("val") : 1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_astazi, container, false);
    }

}
