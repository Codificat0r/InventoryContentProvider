package com.example.inventoryfragmentcontentprovider.ui.utils.comparator;

import com.example.inventoryfragmentcontentprovider.data.db.model.Dependency;

import java.util.Comparator;

/**
 * Created by usuario on 1/12/17.
 */

public class IdComparator implements Comparator<Dependency> {
    @Override
    public int compare(Dependency o1, Dependency o2) {
        if (o1.get_ID() > o2.get_ID())
            return 1;
        if (o1.get_ID() == o2.get_ID())
            return 0;
        else
            return -1;
    }
}
