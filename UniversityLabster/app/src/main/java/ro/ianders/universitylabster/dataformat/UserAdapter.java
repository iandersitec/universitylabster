package ro.ianders.universitylabster.dataformat;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import ro.ianders.universitylabster.R;

/**
 * Created by paul.iusztin on 08.12.2017.
 */

public class UserAdapter extends ArrayAdapter<User> {

    private final Context context;
    private final ArrayList<User> useri;

    public UserAdapter(@NonNull Context context, ArrayList<User> useri) {
        super(context, R.layout.student_linie, useri);
        this.context = context;
        this.useri = new ArrayList<>(useri);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View viewLinie = inflater.inflate(R.layout.student_linie, parent, false);

        TextView tvNume = viewLinie.findViewById(R.id.tvNume);
        TextView tvEmail = viewLinie.findViewById(R.id.tvEmail);

        LinearLayout linLinkDeTrimis = viewLinie.findViewById(R.id.linLinkDeTrimis);
        linLinkDeTrimis.setVisibility(View.GONE); // apare doar cand apasam un element din lista pentru a trimite linkul

        tvNume.setText(String.format("%s %s", useri.get(position).getProfil().getPrenume(), useri.get(position).getProfil().getNumeFamilie()));

        String resDinStringXml;


        // luam date din string.xml
        try {
            PackageManager manager = context.getPackageManager(); // aceasta metoda tine de un o activitte
            Resources resources = manager.getResourcesForApplication("ro.ianders.universitylabster");

            int resId = resources.getIdentifier("student_inainte_de_email", "string", "ro.ianders.universitylabster");
            resDinStringXml = resources.getString(resId);

        } catch (PackageManager.NameNotFoundException e) {
            resDinStringXml = "probleme cu baza de date";
        }


        tvEmail.setText(String.format("%s %s", resDinStringXml, useri.get(position).getProfil().getEmail()));

        return  viewLinie;
    }
}
