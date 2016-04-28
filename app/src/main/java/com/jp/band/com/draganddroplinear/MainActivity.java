package com.jp.band.com.draganddroplinear;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jmedeisis.draglinearlayout.DragLinearLayout;

import org.w3c.dom.Text;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String ultimateCode ="//Code generated \n";
    View v;
    ImageView im;
    Button upload ;
    TextView gen;
    DragLinearLayout dragLinearLayout,dragLinearLayout2,dragLinearLayout3;
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        im = (ImageView)findViewById(R.id.ivTestDrag);
        View v = (View)findViewById(R.id.drag_handle);
        upload = (Button)findViewById(R.id.upload);
         gen = (TextView)findViewById(R.id.textViewUpload);
        findViewById(R.id.container).setOnDragListener(new MyDragListener());
        findViewById(R.id.struct).setOnDragListener(new MyDragListener());
        findViewById(R.id.struct2).setOnDragListener(new MyDragListener());
        findViewById(R.id.llr).setOnDragListener(new MyDragListener());


        findViewById(R.id.frame).setOnTouchListener(new MyOnTouchListener());
        findViewById(R.id.frame2).setOnTouchListener(new MyOnTouchListener());
        findViewById(R.id.content).setOnTouchListener(new MyOnTouchListener());
        findViewById(R.id.content2).setOnTouchListener(new MyOnTouchListener());



       // findViewById(R.id.ivTestOrange).setOnTouchListener(new MyOnTouchListener());

        dragLinearLayout2 = (DragLinearLayout) findViewById(R.id.struct) ;
        dragLinearLayout3 = (DragLinearLayout) findViewById(R.id.struct2) ;
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
                    ultimateCode += child.getTag() +"\n";
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
                        findViewById(R.id.llr).invalidate();

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
                        String fname = item.getText().toString();
                        Log.d("TESTEST", fname);
                        int id = getResources().getIdentifier(fname, "drawable", getPackageName());
                        Drawable drawable = getResources().getDrawable(id);

                       // i.setBackground(drawable);

                        dragLinearLayout.addDragView(i,i);
                        dragLinearLayout.setViewDraggable(i,i);*/





                       /* for(int i = 0; i < dragLinearLayout.getChildCount(); i++){
                           // View child = dragLinearLayout.getChildAt(i);
                            // the child will act as its own drag handle
                            ViewGroup child = (ViewGroup) dragLinearLayout.getChildAt(i);
                            // the child will act as its own drag handle
                            View vi = (View)findViewById(R.id.drag_handle);
                            dragLinearLayout.setViewDraggable(child.getChildAt(0),child.getChildAt(0));

                         }*/




                    }else if(v == findViewById(R.id.struct)) {
                        findViewById(R.id.llr).invalidate();

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
                        TextView tv  = (TextView)findViewById(R.id.tvdisap);
                        //tv.setVisibility(View.GONE);


                        /*ImageView  i  = new ImageView(MainActivity.this);
                        String fname = item.getText().toString();
                        Log.d("TESTEST", fname);
                        int id = getResources().getIdentifier(fname, "drawable", getPackageName());
                        Drawable drawable = getResources().getDrawable(id);

                       // i.setBackground(drawable);

                        dragLinearLayout.addDragView(i,i);
                        dragLinearLayout.setViewDraggable(i,i);*/



                      /*  for(int i = 0; i < dragLinearLayout2.getChildCount(); i++){
                            View child =  dragLinearLayout2.getChildAt(i);
                            // the child will act as its own drag handle
                           *//* View childFirst = child.getChildAt(0);
                            View childSecond = child.getChildAt(1);*//*
                            dragLinearLayout2.setViewDraggable(child, child);
                        }
*/




                }else if(v == findViewById(R.id.struct2)) {
                    findViewById(R.id.llr).invalidate();

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
                    TextView tv  = (TextView)findViewById(R.id.tvdisap2);
                        //tv.setVisibility(View.GONE);

                        /*ImageView  i  = new ImageView(MainActivity.this);
                        String fname = item.getText().toString();
                        Log.d("TESTEST", fname);
                        int id = getResources().getIdentifier(fname, "drawable", getPackageName());
                        Drawable drawable = getResources().getDrawable(id);

                       // i.setBackground(drawable);

                        dragLinearLayout.addDragView(i,i);
                        dragLinearLayout.setViewDraggable(i,i);*/



                   /* for(int i = 0; i < dragLinearLayout3.getChildCount(); i++){
                        View child = dragLinearLayout3.getChildAt(i);
                        // the child will act as its own drag handle

                        child.setOnTouchListener(new MyOnTouchListener());
                        dragLinearLayout3.setViewDraggable(child, child);
                    }
*/



                }
                    else  {

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
                    case R.id.frame:
                        ClipData data = ClipData.newPlainText("Label", "grasp");
                        View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                        view.startDrag(data, shadowBuilder, view, 0);
                        view.setVisibility(View.INVISIBLE);

                        break;
                    case R.id.frame2:
                        ClipData data2 = ClipData.newPlainText("Label", "orange");
                        View.DragShadowBuilder shadowBuilder2 = new View.DragShadowBuilder(view);
                        view.startDrag(data2, shadowBuilder2, view, 0);
                        view.setVisibility(View.INVISIBLE);

                        break;
                    case R.id.content:
                        ClipData data3 = ClipData.newPlainText("Label", "starfish");
                        View.DragShadowBuilder shadowBuilder3 = new View.DragShadowBuilder(view);
                        view.startDrag(data3, shadowBuilder3, view, 0);
                        view.setVisibility(View.INVISIBLE);

                        break;
                    case R.id.content2:
                        ClipData data4 = ClipData.newPlainText("Label", "starfish");
                        View.DragShadowBuilder shadowBuilder4 = new View.DragShadowBuilder(view);
                        view.startDrag(data4, shadowBuilder4, view, 0);
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
