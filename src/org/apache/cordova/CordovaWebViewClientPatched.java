   
   package org.apache.cordova;
   import java.io.IOException;
   import java.io.InputStream;
   import android.content.res.AssetManager;
   import android.net.Uri;
   import android.util.Log;
   import android.webkit.WebResourceResponse;
   import android.webkit.WebView;

   public class CordovaWebViewClientPatched extends CordovaWebViewClient {



	public CordovaWebViewClientPatched(DroidGap ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
		
	}
	
	public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
        if(url.contains("?")){
            return generateWebResourceResponse(url);
        } else {
            return super.shouldInterceptRequest(view, url);
        }
    }

    private WebResourceResponse generateWebResourceResponse(String url) {
        final String ANDROID_ASSET = "file:///android_asset/";
        if (url.startsWith(ANDROID_ASSET)) {
            String niceUrl = url;
            niceUrl = url.replaceFirst(ANDROID_ASSET, "");
            if(niceUrl.contains("?")){
                niceUrl = niceUrl.split("\\?")[0];
            }
            else if(niceUrl.contains("#"))
            {
                niceUrl = niceUrl.split("#")[0];
            }

            String mimetype = null;
            if(niceUrl.endsWith(".html")){
                mimetype = "text/html";
            }

            try {
                AssetManager assets = ctx.getAssets();
                Uri uri = Uri.parse(niceUrl);
                InputStream stream = assets.open(uri.getPath(), AssetManager.ACCESS_STREAMING);
                WebResourceResponse response = new WebResourceResponse(mimetype, "UTF-8", stream);
                return response;
            } catch (IOException e) {
                Log.e("generateWebResourceResponse", e.getMessage(), e);
            }
        }
        return null;
    }
    
   }
