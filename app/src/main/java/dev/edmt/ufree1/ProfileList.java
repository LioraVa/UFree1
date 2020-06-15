package dev.edmt.ufree1;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ProfileList extends ArrayAdapter<Profile>{
    private Activity context;
    private List<Profile> profileList;

    public ProfileList(@NonNull Activity context, List<Profile> profileList) {
        super(context, R.layout.list_layout, profileList);
        this.context = context;
        this.profileList = profileList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);

        TextView textView1 = (TextView) listViewItem.findViewById(R.id.textView1);
        TextView textView2 = (TextView) listViewItem.findViewById(R.id.textView2);
//        ImageView imageView = listViewItem.findViewById(R.id.image1);

        Profile profile = profileList.get(position);

        textView1.setText(profile.getName());
        textView2.setText(profile.getFiled());
//        imageView.setImageDrawable(context.getResources().getDrawable(profile.getProfilePic()));


        return listViewItem;
    }
}
