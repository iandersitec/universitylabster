package ro.ianders.universitylabster;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

import ro.ianders.universitylabster.DataService.DataService;
import ro.ianders.universitylabster.dataformat.Link;
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

        userAdapter = new UserAdapter(getContext(), DataService.getInstance().useri);
        for(User user : DataService.getInstance().useri) {
            Log.e("taaaaaaag", user.getEmail());
        }
        Log.e("ssss", "ssssssss");
        setListAdapter(userAdapter);


    }


    @Override
    public void onListItemClick(ListView l, View view, final int position, long id) {
        userAdapter.apareInterfataTrimitereLink(ultimulIViewFolosit, view, position);
        //trimitere link

        ImageButton btnTrimite = (ImageButton) view.findViewById(R.id.btnTrimite);
        final EditText etLinkDeTrimis = (EditText) view.findViewById(R.id.etLinkDeTrimis);

        btnTrimite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mesaj = etLinkDeTrimis.getText().toString().trim();
                String expeditor = FirebaseAuth.getInstance().getCurrentUser().getEmail();
                String destinatar = DataService.getInstance().useri.get(position).getEmail();

                //Log.e("Link:","Mesaj: "+mesaj+", Expeditor: "+expeditor+", Destinatar:" + destinatar);

                ArrayList<Link> newLinkuri = new ArrayList<>();

                for(Link l : DataService.getInstance().linkuri){
                    newLinkuri.add(l);
                }
                newLinkuri.add(new Link(destinatar, expeditor, mesaj));

                DataService.getInstance().salvareLink(newLinkuri);

                Toast.makeText(getContext(),"Mesaj trimis!",Toast.LENGTH_SHORT).show();

            }
        });



        ultimulIViewFolosit = view; // salvam ultimul view
    }
}
