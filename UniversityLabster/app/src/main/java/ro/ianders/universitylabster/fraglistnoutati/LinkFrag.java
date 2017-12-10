package ro.ianders.universitylabster.fraglistnoutati;


import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

import ro.ianders.universitylabster.DataService.DataService;
import ro.ianders.universitylabster.R;
import ro.ianders.universitylabster.dataformat.Link;

/**
 * A simple {@link Fragment} subclass.
 */
public class LinkFrag extends Fragment {

    private ListView lvNoutatiLinkuri ;

    public LinkFrag() {
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
        View view = inflater.inflate(R.layout.fragment_link, container, false);

        lvNoutatiLinkuri = view.findViewById(R.id.lvNoutatiLinkuri);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        /*ArrayList<String> a = new ArrayList<String>() {{
            add("Paul Link");
            }
        };*/

        String destinatar = FirebaseAuth.getInstance().getCurrentUser().getEmail().trim();
        ArrayList<String> mesages = new ArrayList<>();

        for(Link l: DataService.getInstance().linkuri){
            if(l.getDestinatar().trim().equals(destinatar)){
                mesages.add(l.getMesaj());
            }
        }

        lvNoutatiLinkuri.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, mesages));
    }

}
