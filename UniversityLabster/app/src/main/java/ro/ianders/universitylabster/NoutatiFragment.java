package ro.ianders.universitylabster;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class NoutatiFragment extends ListFragment {


    public NoutatiFragment() {
        // Required empty public constructor
    }


   /* @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_noutati, container, false);
    } */


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, new String[] {"Paul", "Dani"}));

    }

}
