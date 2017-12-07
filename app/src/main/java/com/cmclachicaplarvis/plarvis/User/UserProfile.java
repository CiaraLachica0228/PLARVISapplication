package com.cmclachicaplarvis.plarvis.User;

/**
 * Created by CMLachica on 07/12/2017.
 */

public class UserProfile {

    private String header;
    private String profileContent;


    public UserProfile(String header, String profileContent) {

        this.header = header;
        this.profileContent = profileContent;
    }

    public String getHeader() {
        return header;
    }

    public String getProfileContent() {
        return profileContent;
    }
}
