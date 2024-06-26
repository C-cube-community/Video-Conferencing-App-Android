package com.example.videoconferencingapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.customview.view.*;

import com.example.videoconferencingapp.R;
import com.example.videoconferencingapp.listeners.UsersListener;
import com.example.videoconferencingapp.models.User;

import java.util.List;

public class UsersAdapters extends RecyclerView.Adapter<UsersAdapters.UserViewHolder>{

    private List<User> users;
    private UsersListener usersListener;

    public UsersAdapters(List<User> users, UsersListener usersListener) {
        this.users = users;
        this.usersListener = usersListener;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new UserViewHolder(
                    LayoutInflater.from(parent.getContext()).inflate(
                            R.layout.item_container_user,
                            parent,false
                    )
            );
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.setUserData(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

     class UserViewHolder extends RecyclerView.ViewHolder{

        TextView textFirstChar, textUserName,textEmail;
        ImageView imageAudioCall,imageVideoCall;

         UserViewHolder(@NonNull View itemView){
            super(itemView);
            textFirstChar = itemView.findViewById(R.id.textFirstChar);
             textUserName = itemView.findViewById(R.id.textUserName);
             textEmail = itemView.findViewById(R.id.textEmail);
             imageAudioCall = itemView.findViewById(R.id.imageAudioCall);
             imageVideoCall = itemView.findViewById(R.id.imageVideoCall);
        }

        void setUserData (User user){
             textFirstChar.setText(user.firstName.substring(0,1));
            textUserName.setText(String.format("%s %s", user.firstName,user.lastName));
            textEmail.setText(user.email);
            imageAudioCall.setOnClickListener(v -> usersListener.initiateAudioMeeting(user));
            imageVideoCall.setOnClickListener(v -> usersListener.initiateVideoMeeting(user));
         }
    }
}
