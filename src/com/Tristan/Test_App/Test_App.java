
    package com.Tristan.Test_App;

    import android.os.Bundle;
    import android.webkit.WebView;
    import org.apache.cordova.*;

    public class Test_App extends DroidGap
    {
        public void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            super.setBooleanProperty("loadInWebView", true);
            super.loadUrl("file:///android_asset/www/index.html");
        }
        
        
        public void init()
        {
          init(new WebView(this), new CordovaWebViewClientPatched(this), new CordovaChromeClient(this));
        }
        
    }

