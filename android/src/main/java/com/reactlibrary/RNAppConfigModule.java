
package com.reactlibrary;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.provider.Settings;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

public class RNAppConfigModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNAppConfigModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNAppConfig";
  }

  private String getBuildType() {
    switch (BuildConfig.BUILD_TYPE.toLowerCase()) {
        case "debug": return "dev";
        case "release": return "release";
    }

    return "release";
  }

   @Override
    public @Nullable
    Map<String, Object> getConstants() {
        HashMap<String, Object> constants = new HashMap<String, Object>();

        PackageManager packageManager = this.reactContext.getPackageManager();
        String packageName = this.reactContext.getPackageName();

        constants.put("appVersion", "unknown");

        try {
            PackageInfo info = packageManager.getPackageInfo(packageName, 0);
            if (info.versionName != null && !info.versionName.isEmpty())
                constants.put("appVersion", info.versionName);
        } catch (PackageManager.NameNotFoundException ignored) {
        }

        constants.put("uniqueId", Settings.Secure.getString(this.reactContext.getContentResolver(), Settings.Secure.ANDROID_ID));
        constants.put("buildType",getBuildType());

        return constants;
    }
}
