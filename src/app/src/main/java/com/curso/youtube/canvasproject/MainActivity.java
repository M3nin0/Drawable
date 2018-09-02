package com.curso.youtube.canvasproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AndroidCanvas canvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        canvas = new AndroidCanvas(this);
        canvas.setDrawingCacheEnabled(true);
        setContentView(canvas);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_canvas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.actionSalvar:
                boolean result = Savier.canvasToBitmap(canvas, this);
                if (result)
                    Toast.makeText(this, "Seu desenho foi salvo com sucesso =D", Toast.LENGTH_LONG).show();
                break;
            case R.id.actionCompartilhar:
                Intent intent = ShareBox.buildShareIntent(canvas, this);
                startActivity(intent);
                Toast.makeText(this, "Compartilhar", Toast.LENGTH_LONG).show();
                break;
            case R.id.actionLimpar:
                Toast.makeText(this, "Limpar", Toast.LENGTH_LONG).show();
                canvas.clearCanvas();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
