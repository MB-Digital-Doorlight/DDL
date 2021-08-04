package com.example.ddl.ui.hochladen;

import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;

public class UploadFile extends AsyncTask<Void, Void, Void> {
    HochladenFragment Context;
    LoadingDialog loadingDialog;
    Handler handler;
    Toast toast;
    Toast failedtoast;
    Boolean success = false;





     UploadFile(HochladenFragment myActivity, Handler handler2, Toast toast2, Toast toast3, LoadingDialog loadingDialog2){
        Context = myActivity;
        loadingDialog = loadingDialog2;
        handler = handler2;
        toast = toast2;
        failedtoast = toast3;


    }


    @Override
    protected Void doInBackground(Void... params) {
        FTPClient con = null;
        String sourceFileUri = "/data/data/com.example.ddl/app_imageDir/upload.png";

        try {
            con = new FTPClient();
            con.connect("10.3.141.1");
            if (con.login("max", "test")) {

                con.enterLocalPassiveMode(); // important!
                con.setFileType(FTP.BINARY_FILE_TYPE);
                //String data = "/data/data/com.example.ddl/app_imageDir/upload.png";
                FileInputStream in = new FileInputStream(new File(sourceFileUri));
                boolean result = con.storeFile("/upload.png", in);
                in.close();
                if (result) {
                    Log.v("upload result", "succeeded");
                    success = true;
                }
                con.logout();
                con.disconnect();

            }

        } catch (Exception e) {
            e.printStackTrace();
            Log.v("upload result", "failed");
        }
        return null;
    }


    @Override
    protected void onPostExecute(Void result) {
         if (!success)
         {
             loadingDialog.dismissDialog();
             failedtoast.show();
         }
         else
         {
             success = false;
             handler.postDelayed(new Runnable() {
                 @Override
                 public void run() {
                     loadingDialog.dismissDialog();
                     toast.show();
                 }
             }, 1000);

         }
    }

    @Override
    protected void onPreExecute() {
        loadingDialog.startLoadingDialog(Context);
        Log.v("upload result", "pending");
    }

    @Override
    protected void onProgressUpdate(Void... progress) {

    }

}

