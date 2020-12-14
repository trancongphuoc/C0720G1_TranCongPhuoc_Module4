package com.codegym.util;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.List;

public class WebUntil {


    public static String toString(User user) {
        StringBuilder sb = new StringBuilder();

        sb.append("Username: ").append(user.getUsername());

        Collection<GrantedAuthority> grantedAuthorityList = user.getAuthorities();

        if (grantedAuthorityList != null) {
            sb.append(" (");

            boolean flag = true;
            for (GrantedAuthority authority: grantedAuthorityList) {
                if (flag) {
                    sb.append(authority.getAuthority());
                    flag = false;
                } else {
                    sb.append(", ").append(authority.getAuthority());
                }
            }
            sb.append(")");
        }

        return sb.toString();
    }
}
