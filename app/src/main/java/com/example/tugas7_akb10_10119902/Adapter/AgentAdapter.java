package com.example.tugas7_akb10_10119902.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tugas7_akb10_10119902.Model.AgentModel;
import com.example.tugas7_akb10_10119902.R;

import java.util.List;

/**
 *
 * NIM                  : 10119902
 * Nama                 : Muhammad Nurkholiq
 *
 */

public class AgentAdapter extends RecyclerView.Adapter<AgentAdapter.MyHolder> {
    List<AgentModel> mList;
    Context context;

    public AgentAdapter(Context context, List<AgentModel> mList){
        this.mList = mList;
        this.context = context;
    }

    @Override
    public AgentAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_agent, parent, false);
        AgentAdapter.MyHolder holder = new AgentAdapter.MyHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(AgentAdapter.MyHolder holder, final int position) {
        AgentModel agentModel = mList.get(position);

        holder.diplayName.setText(agentModel.getDisplayName());

        Glide.with(context)
                .load(agentModel.getBackground())
                .placeholder(R.drawable.agent_bg)
                .error(R.drawable.agent_bg)
                .into(holder.background);

        Glide.with(context)
                .load(agentModel.getFullPortraitV2())
                .placeholder(R.drawable.agent_image)
                .error(R.drawable.agent_image)
                .into(holder.fullPortraitV2);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView diplayName;
        ImageView fullPortraitV2, background;

        public MyHolder(View v) {
            super(v);

            diplayName = (TextView) v.findViewById(R.id.agentName);
            background = (ImageView) v.findViewById(R.id.agentBackground);
            fullPortraitV2 = (ImageView) v.findViewById(R.id.agentImage);
        }
    }
}
