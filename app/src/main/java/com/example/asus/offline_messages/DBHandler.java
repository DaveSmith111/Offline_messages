package com.example.asus.offline_messages;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

//p
/**
 * Created by Felix Schmidt on 21.02.2016.
 */
public class DBHandler extends SQLiteOpenHelper{
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Messagesass";

    // Contacts table name
    private static final String TABLE_MESSAGES = "messages";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_MSG = "msg";
    private static final String KEY_PH_NO = "phone_number";
    private static final String KEY_TIME ="time";
    private static final String KEY_SENDER ="sender";
    private static final String KEY_RECEIVER="receiver";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_MESSAGES_TABLE = "CREATE TABLE " + TABLE_MESSAGES + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_MSG + " TEXT,"
                + KEY_PH_NO + " TEXT,"
                + KEY_TIME + " TEXT,"
                + KEY_SENDER + " TEXT,"
                + KEY_RECEIVER + " TEXT" + ")";
        db.execSQL(CREATE_MESSAGES_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MESSAGES);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new contact
    void addMessage(Message message) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_MSG, message.getMSG()); // Message Message
        values.put(KEY_PH_NO, message.getPhoneNumber()); // Message Phone
        values.put(KEY_TIME, message.getTime()); // Message Time
        values.put(KEY_SENDER, message.getSender()); // Message Sender
        values.put(KEY_RECEIVER, message.getReceiver()); // Message Receiver

        // Inserting Row
        db.insert(TABLE_MESSAGES, null, values);
        db.close(); // Closing database connection
    }

    // Getting All Messages TODO change return type so I can insert the result into chats display arraylist
    public List<Message> getAllMessages() {
        List<Message> messagesList = new ArrayList<Message>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_MESSAGES; //+ " LIMIT 10";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToPosition(20)) {
            do {
                Message message = new Message();
                message.setID(Integer.parseInt(cursor.getString(0)));
                message.setMSG(cursor.getString(1));
                message.setPhoneNumber(cursor.getString(2));
                message.setTime(cursor.getString(3));
                message.setSender(cursor.getString(4));
                message.setReceiver(cursor.getString(5));
                // Adding contact to list
                messagesList.add(message);
            } while (cursor.moveToNext());
        }

        // return contact list
        return messagesList;
    }
}
