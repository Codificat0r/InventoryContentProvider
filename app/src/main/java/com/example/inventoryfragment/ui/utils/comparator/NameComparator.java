package com.example.inventoryfragment.ui.utils.comparator;

import com.example.inventoryfragment.data.db.model.Dependency;

import java.util.Comparator;

/**
 * Created by usuario on 1/12/17.
 */

public class NameComparator implements Comparator<Dependency> {
    @Override
    public int compare(Dependency o1, Dependency o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
