package com.example.asus.offline_messages;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText msg;
    private EditText phone;
    private EditText time;
    private EditText sender;
    private EditText receiver;

    public String mMsge;
    public String mPhonee;
    public String mTimee;
    public String mSendere;
    public String mReceivere;

    //Main
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initiating inputs
        button = (Button) findViewById(R.id.button);

        //insert data into db
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msg = (EditText) findViewById(R.id.msg);
                phone = (EditText) findViewById(R.id.phone);
                time = (EditText) findViewById(R.id.time);
                sender = (EditText) findViewById(R.id.sender);
                receiver = (EditText) findViewById(R.id.receiver);

                mMsge = msg.getText().toString();
                mPhonee = phone.getText().toString();
                mTimee = time.getText().toString();
                mSendere = sender.getText().toString();
                mReceivere = receiver.getText().toString();

                //db.addMessage(new Message("F", "f","f", "f","f"));
                tost();
            }
        });
    }

    public void tost(){

        DBHandler db = new DBHandler(this);
        db.addMessage(new Message(mMsge, mPhonee, mTimee, mSendere, mReceivere));
        Toast.makeText(this, mMsge,Toast.LENGTH_LONG).show();
        List<Message> messages = db.getAllMessages();

        for (Message cn : messages) {
            String d = cn.getMSG() + cn.getReceiver();
            //Toast.makeText(this, d,Toast.LENGTH_LONG).show();
            String log = "Id: " + cn.getID() + " ,Message: " + cn.getMSG() + " ,Phone: " + cn.getPhoneNumber() +
                    " ,Time: " + cn.getTime() + " ,Sender: " + cn.getSender() + " ,Receiver: " + cn.getReceiver();
            // Writing Contacts to log
            Log.d("Msg", log);
        }

    }
}
