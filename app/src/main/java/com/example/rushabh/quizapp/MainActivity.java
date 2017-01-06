package com.example.rushabh.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static String TAG="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public int op1=0;
    public int op2=0;
    public int op3=0;
    public void nextPage(View view)
    {
        //EditText button= (EditText)findViewById(RadioGroup.get)

            RadioButton rb1,rb2,rb3,rb4,rb5,rb6,rb7,rb8,rb9,rb10,rb11,rb12;
            rb1 = (RadioButton) findViewById(R.id.radioButton);
            rb2 = (RadioButton) findViewById(R.id.radioButton2);
            rb3 = (RadioButton) findViewById(R.id.radioButton3);

            rb4 = (RadioButton) findViewById(R.id.radioButton4);
            rb5 = (RadioButton) findViewById(R.id.radioButton5);
            rb6 = (RadioButton) findViewById(R.id.radioButton6);

            rb7 = (RadioButton) findViewById(R.id.radioButton7);
            rb8 = (RadioButton) findViewById(R.id.radioButton8);
            rb9 = (RadioButton) findViewById(R.id.radioButton9);

            rb10 = (RadioButton) findViewById(R.id.radioButton10);
            rb11 = (RadioButton) findViewById(R.id.radioButton11);
            rb12 = (RadioButton) findViewById(R.id.radioButton12);

        if(rb1.isChecked())
        {
            op1++;
        }
        if(rb4.isChecked())
        {
            op1++;
        }
        if(rb7.isChecked())
        {
            op1++;
        }
        if(rb10.isChecked())
        {
            op1++;
        }

        if(rb2.isChecked())
        {
            op2++;
        }
        if(rb5.isChecked())
        {
            op2++;
        }
        if(rb8.isChecked())
        {
            op2++;
        }
        if(rb11.isChecked())
        {
            op2++;
        }

        if(rb3.isChecked())
        {
            op3++;
        }
        if(rb6.isChecked())
        {
            op3++;
        }
        if(rb9.isChecked())
        {
            op3++;
        }
        if(rb12.isChecked())
        {
            op3++;
        }

        Toast.makeText(this,op1+" "+op2+" "+op3,Toast.LENGTH_SHORT).show();
        Log.d(TAG,"Op1 "+op1+"Op2 "+op2+"Op3 "+op3);
        Intent nextPage=new Intent(MainActivity.this,resultActivity.class);
        //Bundle extras = new Bundle();
        //extras.putString("Option 1",R.id.radioButton);
        //nextPage.putExtras(extras);
        nextPage.putExtra("Option 1",op1);
        nextPage.putExtra("Option 2",op2);
        nextPage.putExtra("Option 3",op3);
        //nextPage.putExtra("Option 2",op2);
        //nextPage.putExtra("Option 3",op3);
        startActivity(nextPage);
        op1=0;
        op2=0;
        op3=0;
    }

    public void onRadioButtonClicked(View view)
    {
        /*int op1=0;
        int op2=0;
        int op3=0;*/
//        boolean checked= ((RadioButton)view).isChecked();
        /*switch(view.getId())
        {
            case R.id.radioButton:
                if(checked)
                    op1++;break;
            case R.id.radioButton2:
                if (checked)
                    op2++;break;
            case R.id.radioButton3:
                if (checked)
                    op3++;break;

        }*/


    }
}
