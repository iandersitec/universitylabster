package ro.ianders.universitylabster.fraglistnoutati;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import ro.ianders.universitylabster.R;
import ro.ianders.universitylabster.dataformat.Link;
import ro.ianders.universitylabster.dataformat.User;

/**
 * Created by daniel on 12/10/17.
 */

public class LinkAdapter extends ArrayAdapter<Link> {

    private final Context context;
    private final ArrayList<Link> links;

    public LinkAdapter(Context context, ArrayList<Link> links){
        super(context, R.layout.link_view, links);
        this.context = context;
        this.links = new ArrayList<>(links);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.link_view, parent, false);

        TextView tvExpeditor = view.findViewById(R.id.tvExpeditor);
        TextView tvMesaj = view.findViewById(R.id.tvMesaj);
        TextView tvEmail = view.findViewById(R.id.tvEmail);

        tvExpeditor.setText(String.format("%s", links.get(position).getDestinatar()));
        tvEmail.setText(String.format("%s", links.get(position).getExpeditor()));
        tvMesaj.setText(String.format("%s", links.get(position).getMesaj()));

        return view;
    }
}
