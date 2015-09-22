package co.anitech.flashlight;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

/**
 * Created by Anirudha on 07/07/15.
 */
public class FlashlightActivity extends Activity {
    FrameLayout frmLayout;

    //flag to detect flash is on or off
    private boolean isLighOn = false;

    private Camera camera;

    private Button button;

    @Override
    protected void onStop() {
        super.onStop();

        if (camera != null) {
            camera.release();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flashlight);
        Log.d("hello","in");

        frmLayout = (FrameLayout) findViewById(R.id.flashframe);

        button = (Button) findViewById(R.id.toggleflash);

        Context context = this;
        PackageManager pm = context.getPackageManager();

        // if device support camera?
        if (!pm.hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            Log.d("err", "Device has no camera!");
            return;
        }

        camera = Camera.open();
        final Camera.Parameters p = camera.getParameters();

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                if (isLighOn) {

                    Log.d("info", "torch is turn off!");

                    p.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                    camera.setParameters(p);
                    camera.stopPreview();
                    isLighOn = false;

                } else {

                    Log.d("info", "torch is turn on!");

                    p.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);

                    camera.setParameters(p);
                    camera.startPreview();
                    isLighOn = true;

                }

            }
        });

    }
}
