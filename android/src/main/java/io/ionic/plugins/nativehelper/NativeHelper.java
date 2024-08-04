package com.delkeda.signicia;

import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.getcapacitor.JSObject;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;

import static android.content.Context.MODE_PRIVATE;

import java.util.Locale;


@NativePlugin()
public class NativeHelper extends Plugin {
    @PluginMethod()
    public void toastMe(PluginCall call) {
        Toast.makeText(getContext(), "toastText", Toast.LENGTH_LONG).show();
        call.success();
    }
    public SharedPreferences sharedPreferences;

    @PluginMethod()
    public void moveToBackground(PluginCall call) {
        ((MainActivity)getActivity()).moveTaskToBack(true);
        call.success();
    }

    @PluginMethod()
    public void startClipService(PluginCall call) {
       ((MainActivity)getActivity()).startService();
        call.success();
    }

    @PluginMethod()
    public void stopClipService(PluginCall call) {
        ((MainActivity)getActivity()).stopService();
        call.success();
    }

    @PluginMethod()
    public void storeInSharedPrefs(PluginCall call) {
        sharedPreferences = this.getContext().getSharedPreferences("data", MODE_PRIVATE);
        String key = call.getString("key");
        String value = call.getString("value");

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();

        call.resolve();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @PluginMethod()
    public void getOverlayPermissionStatus(PluginCall call) {
        boolean status = ((MainActivity)getActivity()).getOverlayPermissionStatus();
        JSObject ret = new JSObject();
        ret.put("result", status);
        call.resolve(ret);
    }

    @PluginMethod()
    public void getNotificationPermissionStatus(PluginCall call) {
        boolean status = ((MainActivity)getActivity()).getNotificationPermissionStatus();
        JSObject ret = new JSObject();
        ret.put("result", status);
        call.resolve(ret);
    }

    @PluginMethod()
    public void getSystemLanguage(PluginCall call) {
        Locale myLocale = Resources.getSystem().getConfiguration().locale;
        String language = myLocale.getLanguage();
        JSObject ret = new JSObject();
        ret.put("value", language);
        call.resolve(ret);
    }

    @PluginMethod()
    public void getVersionName(PluginCall call) {
        PackageManager pm = getContext().getPackageManager();
        String pkgName = getContext().getPackageName();
        PackageInfo pkgInfo = null;
        try {
            pkgInfo = pm.getPackageInfo(pkgName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        String ver = pkgInfo.versionName;
        JSObject ret = new JSObject();
        ret.put("versionName", ver);
        call.resolve(ret);
    }
    
    @PluginMethod()
    public void requestOverlayPermission(PluginCall call) {
        ((MainActivity)getActivity()).requestOverlayPermission();
        call.success();
    }

    @PluginMethod()
    public void goToNotificationSettings(PluginCall call) {
        ((MainActivity)getActivity()).goToNotificationSettings();
        call.success();
    }


//    @PluginMethod()
//    public void setLanguage(PluginCall call) {
//        String appLang = call.getString("language");
//        Locale myLocale;
//
//        if (appLang.equals("default")) {
//            myLocale = Resources.getSystem().getConfiguration().locale;
//        } else {
//            myLocale = new Locale(appLang);
//        }
//
//        Resources res = getActivity().getResources();
//        DisplayMetrics dm = res.getDisplayMetrics();
//        Configuration conf = res.getConfiguration();
//        conf.locale = myLocale;
//        Locale.setDefault(myLocale);
//        conf.setLayoutDirection(myLocale);
//        res.updateConfiguration(conf, dm);
//
//        Log.d("notify_", "Changed app default language");
//
//        call.success();
//    }

}
