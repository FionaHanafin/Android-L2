package com.fiona;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.provider.FontRequest;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.graphics.fonts.FontFamily;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.lang.reflect.Type;

public class MainActivity extends AppCompatActivity {
    TextView text;
    EditText edit;
    Button b;
    SeekBar seek;
    RadioButton r1, r2;
    CheckBox c1, c2;
    int progress2;
    boolean font= false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findAndSetElements();
        edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                text.setText(edit.getText());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                text.setTextSize(TypedValue.COMPLEX_UNIT_PT, progress + 12);
                progress2 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

        });
        r1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {text.setTextAppearance(R.style.Alegreya);font = false;}
                c1.setChecked(false);c2.setChecked(false);text.setTextSize(TypedValue.COMPLEX_UNIT_PT, progress2 + 12);}
        });
        r2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){ text.setTextAppearance(R.style.LobsterTwo);font = true;}
                c1.setChecked(false);c2.setChecked(false);text.setTextSize(TypedValue.COMPLEX_UNIT_PT, progress2 + 12);}});

        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setAppearance(c1.isChecked(),c2.isChecked());
                text.setTextSize(TypedValue.COMPLEX_UNIT_PT, progress2 + 12);
            }
        });
        c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setAppearance(c1.isChecked(),c2.isChecked());
                text.setTextSize(TypedValue.COMPLEX_UNIT_PT, progress2 + 12);
            }
        });
    }
    private void setAppearance(boolean bold, boolean italics){
        if (font) {
            if (bold && italics) {
                text.setTextAppearance(R.style.LobsterTwoBoldItailcs);
            }
            if (!bold && italics) {
                text.setTextAppearance(R.style.LobsterTwoItailcs);
            }
            if (bold && !italics) {
                text.setTextAppearance(R.style.LobsterTwoBold);
            }
            if (!bold && !italics) {
                text.setTextAppearance(R.style.LobsterTwo);
            }
        }else{
            if (bold && italics) {
                text.setTextAppearance(R.style.AlegreyaBoldItailcs);
            }
            if (!bold && italics) {
                text.setTextAppearance(R.style.AlegreyaItailcs);
            }
            if (bold && !italics) {
                text.setTextAppearance(R.style.AlegreyaBold);
            }
            if (!bold && !italics) {
                text.setTextAppearance(R.style.Alegreya);
            }
        }
        
    }
    private void findAndSetElements() {
        text = findViewById(R.id.textView);
        edit = findViewById(R.id.editText);
        seek = findViewById(R.id.seekBar);
        b = findViewById(R.id.button);
        c1 = findViewById(R.id.checkBox1);
        c2 = findViewById(R.id.checkBox2);
        r1 = findViewById(R.id.radioButton1);
        r2 = findViewById(R.id.radioButton2);
        r1.setChecked(true);
        c1.setChecked(false);
        c2.setChecked(false);
        text.setTextAppearance(R.style.Alegreya);
    }

    public void exit(View v) {
        this.finish();
        System.exit(0);
    }
}
