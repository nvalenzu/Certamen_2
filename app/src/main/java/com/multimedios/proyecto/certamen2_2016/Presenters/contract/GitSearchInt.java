package com.multimedios.proyecto.certamen2_2016.Presenters.contract;

/**
 * Created by nicolas on 02-11-2016.
 */
public interface GitSearchInt {

    void onGitFound(String username, String data);
    void searchGit(String username);
    void onGitNotFound(String username);
}
