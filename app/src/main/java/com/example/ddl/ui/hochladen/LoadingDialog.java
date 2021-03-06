package com.example.ddl.ui.hochladen;

import android.app.AlertDialog;
import android.view.LayoutInflater;

import com.example.ddl.R;

public class LoadingDialog {
    AlertDialog dialog;


    void startLoadingDialog(HochladenFragment Context){
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(Context.getActivity());
        LayoutInflater inflater = Context.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.custom_dialog, null));
        builder.setCancelable(false);

        dialog = builder.create();
        dialog.show();
    }
    void dismissDialog(){
        dialog.dismiss();
    }
}

