package com.example.videoconferencingapp.listeners;

import com.example.videoconferencingapp.models.User;

public interface UsersListener {

    void initiateVideoMeeting(User user);
    void initiateAudioMeeting(User user);


}
