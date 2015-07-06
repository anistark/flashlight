package co.anitech.flashlight;

import android.app.Application;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Anirudha on 07/07/15.
 */
public class Flashlight extends Fragment implements OnClickListener{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.flashlight, container, false);

        Button b = (Button) v.findViewById(R.id.toggleButton);
        b.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toggleButton:
                Log.d("toggle for = ", String.valueOf(R.id.toggleButton));
                break;
        }
    }
}