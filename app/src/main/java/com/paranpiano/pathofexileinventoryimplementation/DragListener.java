package com.paranpiano.pathofexileinventoryimplementation;

import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;

public class DragListener implements View.OnDragListener {

    private static final String TAG = "DragListener";

    @Override
    public boolean onDrag(View view, DragEvent dragEvent) {


        //iv.setImageDrawable();

        Log.d(TAG, "onDraged");

        // 이벤트 시작
        switch (dragEvent.getAction()) {

            // 이미지를 드래그 시작될때
            case DragEvent.ACTION_DRAG_STARTED:
                Log.d("DragClickListener", "ACTION_DRAG_STARTED");
                break;

            // 드래그한 이미지를 옮길려는 지역으로 들어왔을때
            case DragEvent.ACTION_DRAG_ENTERED:
                Log.d("DragClickListener", "ACTION_DRAG_ENTERED");
                // 이미지가 들어왔다는 것을 알려주기 위해 배경이미지 변경
                break;

            // 드래그한 이미지가 영역을 빠져 나갈때
            case DragEvent.ACTION_DRAG_EXITED:
                Log.d("DragClickListener", "ACTION_DRAG_EXITED");
                break;

            // 이미지를 드래그해서 드랍시켰을때
            case DragEvent.ACTION_DROP:
                Log.d("DragClickListener", "ACTION_DROP");

                ImageView slot = (ImageView) view;
                ImageView itemView = (ImageView) dragEvent.getLocalState();
                slot.setImageDrawable(itemView.getDrawable());
                itemView.setVisibility(View.INVISIBLE);

                break;

            case DragEvent.ACTION_DRAG_ENDED:
                Log.d("DragClickListener", "ACTION_DRAG_ENDED");

            default:
                break;
        }

        return true;
    }
}
