package com.dmm.mylocation;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by waldekd on 2015-06-12.
 */
public class MenuListFragment extends ListFragment {

    IMenuList MenuListInterface;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            MenuListInterface = (IMenuList) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement IMenuList interface");
        }

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        MenuListInterface.onItemClick(position);

    }

    public interface IMenuList {
        void onItemClick(int position);
    }
}
