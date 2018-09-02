package com.curso.youtube.canvasproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

public class ShareBox {

    public static Intent buildShareIntent(AndroidCanvas canvas, AppCompatActivity context) {

        Bitmap bitmap = canvas.getDrawingCache();
        String imageName = "image_" + new Random().nextInt() + ".png";
        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
        File file = new File(context.getFilesDir(), imageName);

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream osStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, osStream);
            osStream.flush();
            osStream.close();
            file.setReadable(true, false);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
        intent.setType("image/png");
        return intent;
    }
}
