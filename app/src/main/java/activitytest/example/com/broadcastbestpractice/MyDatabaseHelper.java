package activitytest.example.com.broadcastbestpractice;

import android.content.Context;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.StringBuilderPrinter;
import android.widget.Toast;

/**
 * Created by Administrator on 2019/11/21.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final String CREATE_REGISTER="create table register("
            +"id integer primary key autoincrement,"
            +"account varchar,"
            +"password varchar,"
            +"sex varchar,"
            +"age integer,"
            +"mail varchar)";
    private Context mContext;
    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,int version){
        super(context,name,factory,version);
        mContext=context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_REGISTER);
        Toast.makeText(mContext, "Create succeeded", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
    }

}
