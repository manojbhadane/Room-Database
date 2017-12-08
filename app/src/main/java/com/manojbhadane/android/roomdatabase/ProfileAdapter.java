package com.manojbhadane.android.roomdatabase;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by manoj.bhadane on 08-12-2017.
 */
public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder>
{
    private Context mContext;
    private ArrayList<Profile> arrayList;

    public ProfileAdapter(Context context, ArrayList<Profile> arrayList)
    {
        mContext = context;
        this.arrayList = arrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(mContext).inflate(R.layout.listitem_profile, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        holder.mTxtProfile.setText(arrayList.get(position).getProfileName());
    }

    @Override
    public int getItemCount()
    {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView mTxtProfile;

        public ViewHolder(View itemView)
        {
            super(itemView);
            mTxtProfile = (TextView) itemView.findViewById(R.id.txtProfile);
        }
    }
}
