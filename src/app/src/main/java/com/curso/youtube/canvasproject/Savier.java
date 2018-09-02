package com.curso.youtube.canvasproject;

import android.graphics.Bitmap;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

public class Savier {

    /**
     * Método criado para salvar o canvas em Bitmap
     *
     * @param canvas
     * @param context
     * @return
     */
    public static boolean canvasToBitmap(AndroidCanvas canvas, AppCompatActivity context) {
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
            osStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
