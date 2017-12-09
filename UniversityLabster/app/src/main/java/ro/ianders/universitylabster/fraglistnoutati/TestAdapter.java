package ro.ianders.universitylabster.fraglistnoutati;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import ro.ianders.universitylabster.R;

/**
 * Created by paul.iusztin on 09.12.2017.
 */

public class TestAdapter extends ArrayAdapter<String> {

    Context context;

    public TestAdapter(@NonNull Context context, ArrayList<String> strings) {
        super(context, R.layout.test_line, strings);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View viewLinie = inflater.inflate(R.layout.test_line, parent, false);

        return viewLinie;
    }
}
