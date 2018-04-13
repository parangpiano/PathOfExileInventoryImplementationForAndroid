package com.paranpiano.pathofexileinventoryimplementation;

import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ImageView img70 = findViewById(R.id.imageView70);
//        img70.setOnLongClickListener(new LongClickListener());
        img70.setOnLongClickListener(
                new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        ClipData.Item item = new ClipData.Item(
                                (CharSequence) view.getTag());

                        String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};
                        ClipData data = new ClipData(view.getTag().toString(),
                                mimeTypes, item);
                        View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(
                                view);

                        view.startDrag(null, // data to be dragged
                                shadowBuilder, // drag shadow
                                view, // 드래그 드랍할  Vew
                                0 // 필요없은 플래그
                        );
                       // view.setVisibility(View.INVISIBLE);
                        return true;
                    }
                }
        );
        img70.setTag("Sample");

        img70.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("CLICK", "OnClickListener");
                    }
                }
        );

    }

    boolean b = true;

    private final class LongClickListener implements View.OnLongClickListener {

        public boolean onLongClick(View view) {

            if (b) {
                b = false;
                // 태그 생성
                ClipData.Item item = new ClipData.Item(
                        (CharSequence) view.getTag());

                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};
                ClipData data = new ClipData(view.getTag().toString(),
                        mimeTypes, item);
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(
                        view);

                view.startDrag(null, // data to be dragged
                        shadowBuilder, // drag shadow
                        view, // 드래그 드랍할  Vew
                        0 // 필요없은 플래그
                );
            }

            Log.d("MAIN", "called onLongClick");

            //view.setVisibility(View.INVISIBLE);
            return true;
        }
    }

}
