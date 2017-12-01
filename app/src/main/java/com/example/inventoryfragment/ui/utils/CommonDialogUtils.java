package com.example.inventoryfragment.ui.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

import com.example.inventoryfragment.R;
import com.example.inventoryfragment.data.db.model.Dependency;
import com.example.inventoryfragment.ui.dependency.contract.ListDependencyContract;

/**
 * Created by usuario on 30/11/17.
 */

public class CommonDialogUtils {
    public static final String MESSAGE = "message";
    public static final String TITLE = "title";
    public static final String POSITION = "position";

    public static Dialog showConfirmDialog(final Bundle bundle,Context context, final ListDependencyContract.Presenter p) {
        final boolean[] isOkay = {false};
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(bundle.getString(MESSAGE))
                .setTitle(bundle.getString(TITLE))
                .setPositiveButton(R.string.btnOk, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        p.deleteDependency((Dependency) bundle.getParcelable(POSITION));
                        dialog.cancel();
                    }
                })
                .setNegativeButton(R.string.btnCancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        return builder.create();
    }
}
