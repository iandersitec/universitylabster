package ro.ianders.universitylabster;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import ro.ianders.universitylabster.dataformat.User;
import ro.ianders.universitylabster.dataformat.UserAdapter;


public class StudentiFragment extends ListFragment {


    private UserAdapter userAdapter;
    private View ultimulIViewFolosit = null; // la inceput nu a fost folosit nici un item din adapter


    public StudentiFragment() {
        // Required empty public constructor
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


      //  userAdapter = new UserAdapter(this.getActivity(), arrayListPentruTEST);
       // setListAdapter(userAdapter);

    }


    @Override
    public void onListItemClick(ListView l, View view, int position, long id) {
        userAdapter.apareInterfataTrimitereLink(ultimulIViewFolosit, view, position);
        ultimulIViewFolosit = view; // salvam ultimul view
    }
}
