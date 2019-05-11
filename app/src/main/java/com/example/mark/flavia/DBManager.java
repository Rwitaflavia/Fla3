package com.example.mark.flavia;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {

    private MySQLiteHelper dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException {
        dbHelper = new MySQLiteHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String name, String desc) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(MySQLiteHelper.SUBJECT, name);
        contentValue.put(MySQLiteHelper.DESC, desc);
        database.insert(MySQLiteHelper.TABLE_NAME, null, contentValue);
    }

    public Cursor fetch() {
        String[] columns = new String[] { MySQLiteHelper._ID, MySQLiteHelper.SUBJECT, MySQLiteHelper.DESC };
        Cursor cursor = database.query(MySQLiteHelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(long _id, String name, String desc) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(MySQLiteHelper.SUBJECT, name);
        contentValues.put(MySQLiteHelper.DESC, desc);
        int i = database.update(MySQLiteHelper.TABLE_NAME, contentValues, MySQLiteHelper._ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {
        database.delete(MySQLiteHelper.TABLE_NAME, MySQLiteHelper._ID + "=" + _id, null);
    }

}
