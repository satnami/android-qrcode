package com.qr.demo;

import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.dlazaro66.qrcodereaderview.QRCodeReaderView;

public class MainActivity extends AppCompatActivity implements QRCodeReaderView.OnQRCodeReadListener {

    private TextView resultTextView;
    private QRCodeReaderView qrDecoderView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = (TextView) findViewById(R.id.resultTextView);

        qrDecoderView = (QRCodeReaderView) findViewById(R.id.qrDecoderView);
        qrDecoderView.setOnQRCodeReadListener(this);

        qrDecoderView.setQRDecodingEnabled(true);

        qrDecoderView.setTorchEnabled(true);

        qrDecoderView.setBackCamera();
    }

    @Override
    public void onQRCodeRead(String text, PointF[] points) {
        resultTextView.setText("QR: " + text);
    }

    @Override
    protected void onResume() {
        super.onResume();
        qrDecoderView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        qrDecoderView.stopCamera();
    }
}
