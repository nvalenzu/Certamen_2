package com.multimedios.proyecto.certamen2_2016.Presenters;

import android.content.Intent;
import android.os.Bundle;

import com.multimedios.proyecto.certamen2_2016.GitListActivity;
import com.multimedios.proyecto.certamen2_2016.MainActivity;
import com.multimedios.proyecto.certamen2_2016.Presenters.contract.GitSearchInt;

/**
 * Created by nicolas on 31-10-2016.
 */
public class GitSearch implements GitSearchInt {

    private MainActivity mActivity;

    public GitSearch(MainActivity mainActivity) {

        mActivity = mainActivity;
    }


    @Override
    public void onGitFound(String user, String data) {
        Intent i = new Intent(mActivity, GitListActivity.class);
        Bundle b = new Bundle();
        b.putString("info", data);
        b.putString("username", user);
        i.putExtras(b);
        mActivity.startActivity(i);
    }

    @Override
    public void searchGit(String username) {


    }

    @Override
    public void onGitNotFound(String username) {

    }

}
