package org.itri.html5webview;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;

public class TestHTML5WebView extends Activity {
	
	HTML5WebView mWebView;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mWebView = new HTML5WebView(this);
        
        if (savedInstanceState != null) {
        	mWebView.restoreState(savedInstanceState);
        } else {	
        	mWebView.loadUrl("http://freebsd.csie.nctu.edu.tw/~freedom/html5/");
           //mWebView.loadUrl("file:///android_asset/index.html");
           //mWebView.loadUrl("http://broken-links.com/tests/video/");

           

        }
        
        setContentView(mWebView.getLayout());
    }
    
    @Override
    public void onSaveInstanceState(Bundle outState) {
    	super.onSaveInstanceState(outState);
    	mWebView.saveState(outState);
    }
    
    @Override
    public void onStop() {
    	super.onStop();
    	mWebView.stopLoading();
    }
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
    	if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mWebView.inCustomView()) {
            	mWebView.hideCustomView();
            	return true;
            }
    	}
    	return super.onKeyDown(keyCode, event);
    }
}