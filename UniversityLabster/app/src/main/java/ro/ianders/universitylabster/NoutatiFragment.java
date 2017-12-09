package ro.ianders.universitylabster;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ro.ianders.universitylabster.fraglistnoutati.AstaziFrag;
import ro.ianders.universitylabster.fraglistnoutati.LinkFrag;
import ro.ianders.universitylabster.fraglistnoutati.SaptamanaFrag;


/**
 * A simple {@link Fragment} subclass.
 */
public class NoutatiFragment extends Fragment {

    private TabLayout tabNoutati;
    private ViewPager viewPager;
    private FragmentPagerAdapter pagerAdapter;

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


        viewPager = view.findViewById(R.id.tabPager);
        pagerAdapter = new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {

                switch (position) {
                    case 0:
                        return new AstaziFrag();
                    case 1:
                        return new SaptamanaFrag();
                    case 2:
                        return new LinkFrag();
                }

                return null;
            }

            @Override
            public int getCount() {
                return 3; // numarul de view-uri valabile
            }
        };
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabNoutati));

        // Inflate the layout for this fragment
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final FragmentManager manager = getFragmentManager();

        // listener pentru tab
        tabNoutati.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
              /*) try {
                    switch (tab.getTag().toString()) {

                        case "astazi":
                            manager.beginTransaction()
                                    .replace(R.id.fragContainer, new AstaziFrag())
                                    .commit();
                            break;

                        case "saptamana":
                            manager.beginTransaction()
                                    .replace(R.id.fragContainer, new SaptamanaFrag())
                                    .commit();
                            break;


                        case "linkuri":
                            manager.beginTransaction()
                                    .replace(R.id.fragContainer, new LinkFrag())
                                    .commit();
                            break;

                    }



                } catch (NullPointerException e) {
                    Toast.makeText(getContext(), "Nu s-au putut deschide noutatile de astazi!", Toast.LENGTH_SHORT).show();
                } */


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    public TabLayout getTabNoutati() {
        return tabNoutati;
    }

}
