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

import java.util.ArrayList;

import ro.ianders.universitylabster.dataformat.User;
import ro.ianders.universitylabster.dataformat.UserAdapter;


public class StudentiFragment extends ListFragment {


    public StudentiFragment() {
        // Required empty public constructor
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<User> arrayListPentruTEST = new ArrayList<>();
        arrayListPentruTEST.add(new User("AC", "paul.iusztin@gmail.com", "Paul", "Iusztin", "PaulakaPaul", 2));
        arrayListPentruTEST.add(new User("AC", "dani.iuonac@gmail.com", "Dani", "Iuonac", "Lenox", 2));

        setListAdapter(new UserAdapter(this.getActivity(), arrayListPentruTEST));

    }
}
