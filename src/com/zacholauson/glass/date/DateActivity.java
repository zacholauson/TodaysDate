package com.zacholauson.glass.date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.KeyEvent;
import android.widget.TextView;

import com.google.android.glass.app.Card;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateActivity extends Activity {

  private Card _card;
  private View _cardView;
  private TextView _statusTextView;

  private TextToSpeech _speech;

  private Context _context = this;

  private String _date_string = todaysDate();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    _speech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
      @Override
      public void onInit(int status) {
        _speech.speak(_date_string, TextToSpeech.QUEUE_FLUSH, null);
      }
    });

    _card = new Card(_context);
    _card.setText(_date_string);
    _cardView = _card.toView();
    setContentView(_cardView);

    //setContentView(R.layout.layout_date); // use xml layout
    _statusTextView = (TextView)findViewById(R.id.status);
  }

  @Override
  public boolean onKeyDown(int keyCode, KeyEvent event) {
    return super.onKeyDown(keyCode, event);
  }

  @Override
  public void onResume() {
    super.onResume();
  }

  @Override
  public void onPause() {
    super.onPause();
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
  }

  public String todaysDate() {
      DateFormat dateFormat = new SimpleDateFormat("MMMMM d");
      Date date = new Date();
      return dateFormat.format(date);
  }
}
