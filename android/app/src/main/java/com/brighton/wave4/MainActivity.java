package com.brightonjosephkbj.wave4app;

import com.getcapacitor.BridgeActivity;
import android.os.Bundle;
import android.webkit.DownloadListener;
import android.content.Intent;
import android.net.Uri;

public class MainActivity extends BridgeActivity {
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    bridge.getWebView().setDownloadListener(
      new DownloadListener() {
        public void onDownloadStart(String url, String userAgent,
            String contentDisposition, String mimetype,
            long contentLength) {
          Intent intent = new Intent(Intent.ACTION_VIEW);
          intent.setData(Uri.parse(url));
          startActivity(intent);
        }
      }
    );
  }
}
