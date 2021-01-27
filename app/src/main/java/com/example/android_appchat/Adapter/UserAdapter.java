package com.example.android_appchat.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.android_appchat.Model.User;
import com.example.android_appchat.R;

import java.security.PublicKey;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private Context mContext;
    private List<User> mUsers;

    public UserAdapter(Context mContext, List<User> mUsers) {
        this.mUsers = mUsers;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_user, parent, false);
        return new UserAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = mUsers.get(position);
        holder.txt_Username.setText(user.getUsername());
        if (user.getImageURL().equals("default")) {
            holder.profile_Image.setImageResource(R.mipmap.user);
        }else {
            Glide.with(mContext).load(user.getImageURL()).into(holder.profile_Image);
        }
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txt_Username;
        public CircleImageView profile_Image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_Username = itemView.findViewById(R.id.txt_Username);
            profile_Image = itemView.findViewById(R.id.profile_Image);
        }
    }
}
