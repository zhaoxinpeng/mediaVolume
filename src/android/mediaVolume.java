package com.zxp.mediaVolume;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.provider.Settings;
import android.media.AudioManager;
import android.content.Context;
import android.os.Vibrator;

/**
 * This class echoes a string called from JavaScript.
 */
public class mediaVolume extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("getVol")) {
            this.getVol(callbackContext);
            return true;
        }
        else if(action.equals("setVol")) {
            this.setVol(args.getDouble(0));
            callbackContext.success();
            return true;
        } else {
            return false;
        }
    }

    private void setVol(double volume) {
        AudioManager am = (AudioManager) this.cordova.getActivity().getSystemService(Context.AUDIO_SERVICE);
        double vol = volume / 100;
        am.setStreamVolume(
            AudioManager.STREAM_MUSIC,
            (int) (am.getStreamMaxVolume(AudioManager.STREAM_MUSIC) * vol),
            0);
    }
    private void getVol(CallbackContext callbackContext) {
        try{
            AudioManager mAudioManager = (AudioManager) this.cordova.getActivity().getSystemService(Context.AUDIO_SERVICE);
            int max = mAudioManager.getStreamMaxVolume( AudioManager.STREAM_MUSIC );
            int current = mAudioManager.getStreamVolume( AudioManager.STREAM_MUSIC );
            JSONObject r = new JSONObject();
            r.put("max", max);
            r.put("current", current);
            callbackContext.success(r);
        }catch(Exception e){

        }
    }
}
