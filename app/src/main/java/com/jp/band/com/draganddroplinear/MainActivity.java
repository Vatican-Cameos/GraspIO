package com.jp.band.com.draganddroplinear;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jmedeisis.draglinearlayout.DragLinearLayout;

public class MainActivity extends AppCompatActivity {
    String ultimateCode ="//Code generated \n";
    ImageView im;
    Button upload ;
    TextView gen;
    DragLinearLayout dragLinearLayout;
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        im = (ImageView)findViewById(R.id.ivTestDrag);
        upload = (Button)findViewById(R.id.upload);
         gen = (TextView)findViewById(R.id.textViewUpload);
        findViewById(R.id.container).setOnDragListener(new MyDragListener());
        im.setOnTouchListener(new MyOnTouchListener());
        findViewById(R.id.ivTestfish).setOnTouchListener(new MyOnTouchListener());
        findViewById(R.id.ivTestOrange).setOnTouchListener(new MyOnTouchListener());

        dragLinearLayout = (DragLinearLayout) findViewById(R.id.container);
       /* for(int i = 0; i < dragLinearLayout.getChildCount(); i++){
            View child = dragLinearLayout.getChildAt(i);
            // the child will act as its own drag handle
            dragLinearLayout.setViewDraggable(child, child);
        }*/



        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ultimateCode = "//Code Generated \n";
                for(int i = 0; i < dragLinearLayout.getChildCount(); i++) {
                    View child = dragLinearLayout.getChildAt(i);
                    // the child will act as its own drag handle
                    ultimateCode += child.getTag();
                    gen.setText(ultimateCode);
                }
            }
        });



        dragLinearLayout.setOnViewSwapListener(new DragLinearLayout.OnViewSwapListener() {
            @Override
            public void onSwap(View firstView, int firstPosition,
                               View secondView, int secondPosition) {

            }
        });
    }


    private class MyDragListener implements View.OnDragListener {
        @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int action = event.getAction();
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    // do nothing
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:

                    break;
                case DragEvent.ACTION_DRAG_EXITED:

                    break;
                case DragEvent.ACTION_DROP:
                    if(v == findViewById(R.id.container)) {
                        // Dropped, reassign View to ViewGroup
                        View view = (View) event.getLocalState();
                        ViewGroup owner = (ViewGroup) view.getParent();
                        owner.removeView(view);
                        LinearLayout container = (LinearLayout) v;
                        //RelativeLayout container = (RelativeLayout) v;
                        container.addView(view);
                        view.setVisibility(View.VISIBLE);
                        ClipData.Item item = event.getClipData().getItemAt(0);
                        ultimateCode += item.getText().toString();
                        /*ImageView  i  = new ImageView(MainActivity.this);

                        i.setBackgroundResource(R.drawable.grasp);
                        dragLinearLayout.addDragView(i,i);*/




                        for(int i = 0; i < dragLinearLayout.getChildCount(); i++){
                            View child = dragLinearLayout.getChildAt(i);
                            // the child will act as its own drag handle


                            dragLinearLayout.setViewDraggable(child, child);
                         }


                    }else {

                        // Dropped, reassign View to ViewGroup
                        View view = (View) event.getLocalState();
                        ViewGroup owner = (ViewGroup) view.getParent();
                        owner.removeView(view);
                        LinearLayout container = (LinearLayout) v;
                        container.addView(view);
                        view.setVisibility(View.VISIBLE);

                    }
                    break;
                case DragEvent.ACTION_DRAG_ENDED:

                default:
                    break;
            }
            return true;
        }
    }



    private class MyOnTouchListener implements View.OnTouchListener {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                switch (view.getId()) {
                    case R.id.ivTestDrag:
                        ClipData data = ClipData.newPlainText("Label", "if(){   } else {  }\n");
                        View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                        view.startDrag(data, shadowBuilder, view, 0);
                        view.setVisibility(View.INVISIBLE);

                        break;
                    case R.id.ivTestOrange:
                        ClipData data2 = ClipData.newPlainText("Label", "while\n");
                        View.DragShadowBuilder shadowBuilder2 = new View.DragShadowBuilder(view);
                        view.startDrag(data2, shadowBuilder2, view, 0);
                        view.setVisibility(View.INVISIBLE);

                        break;
                    case R.id.ivTestfish:
                        ClipData data3 = ClipData.newPlainText("Label", "struct\n");
                        View.DragShadowBuilder shadowBuilder3 = new View.DragShadowBuilder(view);
                        view.startDrag(data3, shadowBuilder3, view, 0);
                        view.setVisibility(View.INVISIBLE);

                        break;

                }
                return true;
            } else {
                return false;
            }
        }
    }

}
