
package com.example.ddl.ui.dashboard;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.ddl.Globals;
import com.example.ddl.R;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;


public class DashboardFragment extends Fragment {


    private Button button2;
    private Button button;
    private Button button3;
    private ImageView imageView;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        button2 = root.findViewById(R.id.button2);
        button = root.findViewById(R.id.button);
        button3 = root.findViewById(R.id.button3);
        imageView=root.findViewById(R.id.imageView2);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage(getContext());
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.stern);
                Globals.reset=true;
            }
        });

        return root;
    }


    @Override
    public void onResume() {
        super.onResume();
        if (Globals.firstVisit){
            Globals.firstVisit=false;
        }
        else {
            if (Globals.vorschau != null && Globals.reset==false) {
                imageView.setImageBitmap(Globals.vorschau);
            }
        }
    }


    public void selectImage(Context context) {
        final CharSequence[] options = { "Kamera", "Galerie","Zurück" };

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Motiv auswählen");

        builder.setItems(options, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int item) {

                if (options[item].equals("Kamera")) {
                    Intent takePicture = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(takePicture, 0);

                } else if (options[item].equals("Galerie")) {
                    Intent pickPhoto = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(pickPhoto , 1);

                } else if (options[item].equals("Zurück")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode != RESULT_CANCELED) {
            switch (requestCode) {
                case 0:
                    if (resultCode == RESULT_OK && data != null) {
                        Globals.vorschau = (Bitmap) data.getExtras().get("data");
                        imageView.setImageBitmap(Globals.vorschau);
                        Globals.reset=false;
                    }

                    break;
                case 1:
                    if (resultCode == RESULT_OK && data != null) {
                        Uri selectedImage =  data.getData();
                        String[] filePathColumn = {MediaStore.Images.Media.DATA};
                        if (selectedImage != null) {
                            Cursor cursor = getContext().getContentResolver().query(selectedImage,
                                    filePathColumn, null, null, null);
                            if (cursor != null) {
                                cursor.moveToFirst();
                                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                                String picturePath = cursor.getString(columnIndex);
                                Globals.vorschau=BitmapFactory.decodeFile(picturePath);
                                imageView.setImageBitmap(Globals.vorschau);
                                Globals.reset=false;
                                cursor.close();
                            }
                        }
                    }
                    break;
            }
        }
    }


}