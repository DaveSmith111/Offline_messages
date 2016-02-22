package com.example.asus.offline_messages;

/**
 * Created by Felix Schmidt on 21.02.2016.
 */
public class Message {
    //private variables
    int _id;
    String _msg;
    String _phone_number;
    String _time;
    String _sender;
    String _receiver;

    // Empty constructor
    public Message(){

    }
    // constructor
    public Message(int id, String msg, String phone_number, String time, String sender, String receiver){
        this._id = id;
        this._msg = msg;
        this._phone_number = phone_number;
        this._time = time;
        this._sender = sender;
        this._receiver = receiver;
    }

    // constructor
    public Message(String msg, String phone_number, String time, String sender, String receiver){
        this._msg = msg;
        this._phone_number = phone_number;
        this._time = time;
        this._sender = sender;
        this._receiver = receiver;
    }
    // getting ID
    public int getID(){
        return this._id;
    }

    // setting id
    public void setID(int id){
        this._id = id;
    }

    // getting name
    public String getMSG(){
        return this._msg;
    }

    // setting name
    public void setMSG(String msg){
        this._msg = msg;
    }

    // getting phone number
    public String getPhoneNumber(){
        return this._phone_number;
    }

    // setting phone number
    public void setPhoneNumber(String phone_number){
        this._phone_number = phone_number;
    }

    // getting sender
    public String getSender(){
        return this._sender;
    }

    // setting sender
    public void setSender(String sender){
        this._sender = sender;
    }

    // getting time
    public String getTime(){
        return this._time;
    }

    // setting time
    public void setTime(String time){
        this._time = time;
    }

    // getting receiver
    public String getReceiver(){
        return this._receiver;
    }

    // setting receiver
    public void setReceiver(String receiver){
        this._receiver = receiver;
    }

}
