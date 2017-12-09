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
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import ro.ianders.universitylabster.R;

/**
 * Created by paul.iusztin on 09.12.2017.
 */

public class OraFacultateAdapter extends ArrayAdapter<OraFacultate> {

    private Context context;
    private ArrayList<OraFacultate> ore;

    public OraFacultateAdapter(@NonNull Context context, @NonNull ArrayList<OraFacultate> objects) {
        super(context, R.layout.linie_curs_checkin, objects);
        this.context = context;
        ore = objects;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View viewLinie = inflater.inflate(R.layout.linie_curs_checkin, parent, false);

        TextView tvCursAcronim = viewLinie.findViewById(R.id.tvCursAcronim);
        TextView tvCursLung = viewLinie.findViewById(R.id.tvCursLung);

        String numeLung = ore.get(position).getName();
        String[] numeLungVector = numeLung.split(" ");
        StringBuilder acronim = new StringBuilder();

        for(String s : numeLungVector)
            if(s.charAt(0) == s.toUpperCase().charAt(0))
            acronim.append(s.charAt(0));


        tvCursAcronim.setText(acronim.toString());
        tvCursLung.setText(numeLung);

        TextView tvOra = viewLinie.findViewById(R.id.tvOra);
        tvOra.setText(String.format("%s-%s", ore.get(position).getSchedules().get(0).getStartTime(), ore.get(position).getSchedules().get(0).getEndTime()));


        return  viewLinie;
    }


}
