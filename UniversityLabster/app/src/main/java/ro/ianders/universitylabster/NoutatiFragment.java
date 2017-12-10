package ro.ianders.universitylabster;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import ro.ianders.universitylabster.fraglistnoutati.AstaziFrag;
import ro.ianders.universitylabster.fraglistnoutati.LinkFrag;
import ro.ianders.universitylabster.fraglistnoutati.SeeCheckInFrag;


/**
 * A simple {@link Fragment} subclass.
 */
public class NoutatiFragment extends Fragment {

    private TabLayout tabNoutati;


    public NoutatiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_noutati, container, false);


        tabNoutati = view.findViewById(R.id.tabNoutati);
        tabNoutati.addTab(tabNoutati.newTab().setIcon(R.drawable.orar_patrat).setTag("astazi"));
        tabNoutati.addTab(tabNoutati.newTab().setIcon(R.drawable.orar_patrat).setTag("saptamana"));
        tabNoutati.addTab(tabNoutati.newTab().setIcon(R.drawable.orar_patrat).setTag("linkuri"));
        tabNoutati.setTabGravity(TabLayout.GRAVITY_FILL); // setting tab bar pentru noutati


        // Inflate the layout for this fragment
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        final FragmentManager manager = getFragmentManager();
        manager.beginTransaction()
                .replace(R.id.fragContainerNoutatiInlocuit, new AstaziFrag())
                .commit(); // sa se deschida cu ceva initial

        // listener pentru tab
        tabNoutati.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                 try {
                    switch (tab.getTag().toString()) {

                        case "astazi":
                                manager.beginTransaction()
                                        .replace(R.id.fragContainerNoutatiInlocuit, new AstaziFrag())
                                        .commit();
                            break;

                        case "saptamana":
                            manager.beginTransaction()
                                    .replace(R.id.fragContainerNoutatiInlocuit, new SeeCheckInFrag())
                                    .commit();
                            break;


                        case "linkuri":
                            manager.beginTransaction()
                                    .replace(R.id.fragContainerNoutatiInlocuit, new LinkFrag())
                                    .commit();
                            break;

                    }



                } catch (NullPointerException e) {
                    Toast.makeText(getContext(), "Nu s-au putut deschide noutatile de astazi!", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }


}
