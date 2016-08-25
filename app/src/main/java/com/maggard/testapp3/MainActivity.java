package com.maggard.testapp3;

import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    //define widget variables
    private ImageView imageView;

    //define scale gesture
    private ScaleGestureDetector sgd;

    //define matrix
    private Matrix matrix = new Matrix();
    private float scale = 1f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get reference to your widget
        imageView = (ImageView) findViewById(R.id.imageView);

        sgd = new ScaleGestureDetector(this, new ScaleListener());
    }

    public boolean onTouchEvent (MotionEvent ev){
        sgd.onTouchEvent(ev);
        return true;
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener{
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            scale *= detector.getScaleFactor();
            scale = Math.max(0.1f,Math.min(scale, 5.0f));

            matrix.setScale(scale,scale);
            imageView.setImageMatrix(matrix);
            return true;
        }
    }

}
