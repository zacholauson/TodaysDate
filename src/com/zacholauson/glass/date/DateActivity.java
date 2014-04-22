package com.zacholauson.glass.date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.TextView;

import com.google.android.glass.app.Card;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateActivity extends Activity {
  TextView statusTextView;

  private TextToSpeech _speech;
  private Context _context = this;
  private String date_string = todaysDate();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    _speech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
      @Override
      public void onInit(int status) {
        _speech.speak(date_string, TextToSpeech.QUEUE_FLUSH, null);
      }
    });

    Card card = new Card(_context);
    card.setText(date_string);
    View view = card.getView();
    setContentView(view);

    statusTextView = (TextView)findViewById(R.id.status);
  }

  public String todaysDate() {
      DateFormat dateFormat = new SimpleDateFormat("MMMM d");
      Date date = new Date();
      return dateFormat.format(date);
  }
}
