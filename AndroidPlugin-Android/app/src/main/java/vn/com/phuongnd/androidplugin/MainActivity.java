package vn.com.phuongnd.androidplugin;

import android.os.Bundle;
import android.widget.Toast;

import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;

public class MainActivity extends UnityPlayerActivity {
    static MainActivity ma;
    private static int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ma = this;
    }

    public static void requestToast(final String message){
        ma.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(ma, message, Toast.LENGTH_SHORT).show();
                count++;
                callbackToUnity(count);
            }
        });
    }

    private static void callbackToUnity(int count){
        UnityPlayer.UnitySendMessage("AndroidPluginManager", "OnRequestToast", String.valueOf(count));
    }
}
