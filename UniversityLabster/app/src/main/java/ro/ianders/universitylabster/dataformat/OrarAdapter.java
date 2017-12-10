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
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

import ro.ianders.universitylabster.DataService.DataService;
import ro.ianders.universitylabster.R;

/**
 * Created by paul.iusztin on 10.12.2017.
 */

public class OrarAdapter  extends ArrayAdapter<Curs>{


    private Context context;
    private ArrayList<Curs> ore;


    public OrarAdapter(@NonNull Context context, int layout, @NonNull ArrayList<Curs> objects) {
        super(context, R.layout.linie_orar, objects);
        this.context = context;
        ore = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View viewLinie = inflater.inflate(R.layout.linie_orar, parent, false);


        String resDinStringXmlCurs = "";
        String resDinStringXmlProfesor = "";


        // luam date din string.xml
        try {
            PackageManager manager = context.getPackageManager(); // aceasta metoda tine de un o activitte
            Resources resources = manager.getResourcesForApplication("ro.ianders.universitylabster");

            int resId = resources.getIdentifier("student_inainte_de_curs", "string", "ro.ianders.universitylabster");
            resDinStringXmlCurs = resources.getString(resId);

            resId = resources.getIdentifier("student_inainte_de_profesor", "string", "ro.ianders.universitylabster");
            resDinStringXmlProfesor =  resources.getString(resId);

        } catch (PackageManager.NameNotFoundException e) {
            resDinStringXmlCurs = "probleme cu baza de date";
            resDinStringXmlProfesor = "probleme cu baza de date";
        }

        TextView tvCursAcronim = viewLinie.findViewById(R.id.tvCursAcronimOrar);
        TextView tvCursLung = viewLinie.findViewById(R.id.tvCursLungOrar);

        String numeLung = ore.get(position).getName();
        String[] numeLungVector = numeLung.split(" ");
        StringBuilder acronim = new StringBuilder();

        for(String s : numeLungVector)
            if(s.charAt(0) == s.toUpperCase().charAt(0))
                acronim.append(s.charAt(0));


        tvCursAcronim.setText(acronim.toString());
        tvCursLung.setText(String.format("%s %s", resDinStringXmlCurs, numeLung));

        TextView tvOra = viewLinie.findViewById(R.id.tvOraOrar);
        tvOra.setText(String.format("%s-%s", ore.get(position).getStartTime(), ore.get(position).getEndTime()));

        TextView profesor = viewLinie.findViewById(R.id.tvProfesor);
        profesor.setText(String.format("%s %s",resDinStringXmlProfesor, ore.get(position).getNumeProfesor()));

        TextView incercari = viewLinie.findViewById(R.id.tvIncercari);
        incercari.setText(DataService.getInstance().cursuri.get(position).getIncercariPanaLaIntroducereInOrar());

       // if(DataService.getInstance().cursuri.get(position).getIncercariPanaLaIntroducereInOrar().equals("1")) {
            incercari.setVisibility(View.GONE);
      //  }

        return  viewLinie;
    }
}
