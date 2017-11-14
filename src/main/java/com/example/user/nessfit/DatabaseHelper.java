package mobapde.machineproject.nessfit;
//package com.example.user.nessfit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper{
    public static final String SCHEMA = "nessfit";
    public static final int VERSION = 1;

    public DatabaseHelper(Context context){
        super(context, "nessfit", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createExerciseTableSQL = "CREATE TABLE " + Exercise.TABLE_NAME + "(" +
                Exercise.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Exercise.COLUMN_NAME + " TEXT, " +
                Exercise.COLUMN_DESC + " TEXT, " +
                Exercise.COLUMN_PHOTO + " INTEGER, " +
                Exercise.COLUMN_CATEGORY + " TEXT, " +
                Exercise.COLUMN_DIFFICULTY + " TEXT " +
                ");";
        String createRoutineTableSQL = "CREATE TABLE " + Routine.TABLE_NAME + "(" +
                Routine.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Routine.COLUMN_DAY + " TEXT, " +
                Routine.COLUMN_EXERCISE_ID + " INTEGER " +
                ");";
        String createUserTableSQL = "CREATE TABLE " + User.TABLE_NAME + "(" +
                User.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                User.COLUMN_NAME + " TEXT, " +
                User.COLUMN_TRAINING_LEVEL + " TEXT, " +
                User.COLUMN_WEIGHT + " TEXT, " +
                User.COLUMN_GENDER + " TEXT " +
                ");";

        sqLiteDatabase.execSQL(createExerciseTableSQL);
        sqLiteDatabase.execSQL(createRoutineTableSQL);
        sqLiteDatabase.execSQL(createUserTableSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String dropExerciseTableSQL = "DROP TABLE IF EXISTS " + Exercise.TABLE_NAME + ";";
        String dropRoutineTableSQL = "DROP TABLE IF EXISTS " + Routine.TABLE_NAME + ";";

        sqLiteDatabase.execSQL(dropExerciseTableSQL);
        sqLiteDatabase.execSQL(dropRoutineTableSQL);

        onCreate(sqLiteDatabase);
    }

    // IN CASE THERE IS SOMETHING WRONG WITH THE TABLES
    public void resetTable(int mode){
        SQLiteDatabase db = getWritableDatabase();

        if(mode == 1){
            String dropExerciseTableSQL = "DROP TABLE IF EXISTS " + Exercise.TABLE_NAME + ";";
            db.execSQL(dropExerciseTableSQL);

            String createExerciseTableSQL = "CREATE TABLE " + Exercise.TABLE_NAME + "(" +
                    Exercise.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    Exercise.COLUMN_NAME + " TEXT, " +
                    Exercise.COLUMN_DESC + " TEXT, " +
                    Exercise.COLUMN_PHOTO + " INTEGER, " +
                    Exercise.COLUMN_CATEGORY + " TEXT, " +
                    Exercise.COLUMN_DIFFICULTY + " TEXT " +
                    ");";

            db.execSQL(createExerciseTableSQL);
            db.close();
        }

        else if(mode == 2){
            String dropRoutineTableSQL = "DROP TABLE IF EXISTS " + Routine.TABLE_NAME + ";";
            db.execSQL(dropRoutineTableSQL);

            String createRoutineTableSQL = "CREATE TABLE " + Routine.TABLE_NAME + "(" +
                    Routine.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    Routine.COLUMN_DAY + " TEXT, " +
                    Routine.COLUMN_EXERCISE_ID + " INTEGER " +
                    ");";

            db.execSQL(createRoutineTableSQL);
            db.close();
        }

        else if(mode == 3){
            String dropUserTableSQL = "DROP TABLE IF EXISTS " + User.TABLE_NAME + ";";
            db.execSQL(dropUserTableSQL);

            String createUserTableSQL = "CREATE TABLE " + User.TABLE_NAME + "(" +
                    User.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    User.COLUMN_NAME + " TEXT, " +
                    User.COLUMN_TRAINING_LEVEL + " TEXT, " +
                    User.COLUMN_WEIGHT + " TEXT, " +
                    User.COLUMN_GENDER + " TEXT " +
                    ");";

            db.execSQL(createUserTableSQL);
            db.close();
        }
    }

    //////// EXERCISE CRUD OPERATIONS ///////

    public boolean addExercise(Exercise e){
        //todo transactions
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Exercise.COLUMN_NAME, e.getName());
        contentValues.put(Exercise.COLUMN_DESC, e.getDescription());
        contentValues.put(Exercise.COLUMN_PHOTO, e.getPhoto_url()); //todo validate this solution
        contentValues.put(Exercise.COLUMN_CATEGORY, e.getCategory());
        contentValues.put(Exercise.COLUMN_DIFFICULTY, e.getDifficulty());

        long newID = db.insert(Exercise.TABLE_NAME, null, contentValues);
        db.close();
        return (newID != -1);
    }

    public boolean deleteExercise(long currID){
        //todo transactions
        SQLiteDatabase db = getWritableDatabase();
        int rows = db.delete(Exercise.TABLE_NAME, Exercise.COLUMN_ID + "=?", new String[]{currID + ""});
        db.close();
        return (rows > 0);
    }

    public boolean updateExercise(long currID, Exercise e){
        //todo transactions
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Exercise.COLUMN_NAME, e.getName());
        contentValues.put(Exercise.COLUMN_DESC, e.getDescription());
        contentValues.put(Exercise.COLUMN_PHOTO, e.getPhoto_url()); //todo validate this solution
        contentValues.put(Exercise.COLUMN_CATEGORY, e.getCategory());
        contentValues.put(Exercise.COLUMN_DIFFICULTY, e.getDifficulty());

        int rows = db.update(Exercise.TABLE_NAME, contentValues, Exercise.COLUMN_ID + "=?", new String[]{currID + ""});
        db.close();
        return (rows > 0);
    }

    public Exercise getExercise(long currID){
        //todo transactions
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(Exercise.TABLE_NAME, null, Exercise.COLUMN_ID + " = ?",
                new String[]{currID + ""}, null, null, null);

        Exercise e = null;
        if(c.moveToFirst()){
            e = new Exercise();

            String name = c.getString(c.getColumnIndex(Exercise.COLUMN_NAME));
            String description = c.getString(c.getColumnIndex(Exercise.COLUMN_DESC));
            int photo_url = c.getInt(c.getColumnIndex(Exercise.COLUMN_PHOTO)); //todo validate this solution
            String category = c.getString(c.getColumnIndex(Exercise.COLUMN_CATEGORY));
            String difficulty = c.getString(c.getColumnIndex(Exercise.COLUMN_DIFFICULTY));

            e.setId(currID);
            e.setName(name);
            e.setDescription(description);
            e.setPhoto_url(photo_url);
            e.setCategory(category);
            e.setDifficulty(difficulty);
        }

        c.close();
        db.close();
        return e;
    }

    public ArrayList<Exercise> getAllExercises(){
        //todo transactions
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(Exercise.TABLE_NAME, null, null, null, null, null, null);

        ArrayList<Exercise> exercises = null;
        if(c.moveToFirst()){
            exercises = new ArrayList<>();

            do{
                Exercise e = new Exercise();

                long id = c.getLong(c.getColumnIndex(Exercise.COLUMN_ID));
                String name = c.getString(c.getColumnIndex(Exercise.COLUMN_NAME));
                String description = c.getString(c.getColumnIndex(Exercise.COLUMN_DESC));
                int photo_url = c.getInt(c.getColumnIndex(Exercise.COLUMN_PHOTO)); //todo validate this solution
                String category = c.getString(c.getColumnIndex(Exercise.COLUMN_CATEGORY));
                String difficulty = c.getString(c.getColumnIndex(Exercise.COLUMN_DIFFICULTY));

                e.setId(id);
                e.setName(name);
                e.setDescription(description);
                e.setPhoto_url(photo_url);
                e.setCategory(category);
                e.setDifficulty(difficulty);

                exercises.add(e);

            }while(c.moveToNext());
        }

        c.close();
        db.close();
        return exercises;
    }

    public Cursor getAllExercisesCursor(){
        SQLiteDatabase db = getReadableDatabase();
        return db.query(Exercise.TABLE_NAME, null, null, null, null, null, null);
    }

    public Cursor getExercisesByCondition(String difficulty, String category){
        SQLiteDatabase db = getReadableDatabase();
        return db.query(Exercise.TABLE_NAME, null, Exercise.COLUMN_DIFFICULTY + "=? AND " + Exercise.COLUMN_CATEGORY + "=?", new String[]{difficulty, category}, null, null, null);
    }

    public Cursor getExercisesByCondition(String category){
        SQLiteDatabase db = getReadableDatabase();
        return db.query(Exercise.TABLE_NAME, null, Exercise.COLUMN_CATEGORY + "=?", new String[]{category}, null, null, null);
    }



    //////// ROUTINE CRUD OPERATIONS ///////

    public boolean addRoutine(Routine r){
        //todo transactions
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Routine.COLUMN_DAY, r.getDay());
        contentValues.put(Routine.COLUMN_EXERCISE_ID, r.getExercise_id());

        long confirm = db.insert(Routine.TABLE_NAME, null, contentValues);
        db.close();
        return (confirm != -1);
    }

    public boolean deleteRoutine(long currID){
        //todo transactions
        SQLiteDatabase db = getWritableDatabase();
        int rows = db.delete(Routine.TABLE_NAME, Routine.COLUMN_ID + "= ?", new String[]{currID + ""});
        db.close();
        return (rows > 0);
    }

    public ArrayList<Routine> getAllRoutines(){
        //todo transactions
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(Routine.TABLE_NAME, null, null, null, null, null, null);

        ArrayList<Routine> routines = null;
        if(c.moveToFirst()){
            routines = new ArrayList<>();
            do{
                Routine r = new Routine();

                long id = c.getLong(c.getColumnIndex(Routine.COLUMN_ID));
                long exercise_id = c.getLong(c.getColumnIndex(Routine.COLUMN_EXERCISE_ID));
                String day = c.getString(c.getColumnIndex(Routine.COLUMN_DAY));

                r.setId(id);
                r.setExercise_id(exercise_id);
                r.setDay(day);

                routines.add(r);

            }while(c.moveToNext());
        }

        c.close();
        db.close();
        return routines;
    }

    public Cursor getAllRoutinesCursor(){
        SQLiteDatabase db = getReadableDatabase();
        return db.query(Routine.TABLE_NAME, null, null, null, null, null, null);
    }



    //////// USER CRUD OPERATIONS ///////

    public boolean addUser(User u){
        //todo transactions
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(User.COLUMN_NAME, u.getName());
        contentValues.put(User.COLUMN_WEIGHT, u.getWeight());
        contentValues.put(User.COLUMN_TRAINING_LEVEL, u.getTrainingLevel());
        contentValues.put(User.COLUMN_GENDER, u.getGender());

        long newID = db.insert(User.TABLE_NAME, null, contentValues);
        db.close();

        return (newID != -1);
    }

    public User getUser(long currID){
        //todo transactions
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(User.TABLE_NAME, null, User.COLUMN_ID + " = ?",
                new String[]{currID + ""}, null, null, null);

        User u = null;
        if(c.moveToFirst()){
            u = new User();

            long id = c.getLong(c.getColumnIndex(User.COLUMN_ID));
            String name = c.getString(c.getColumnIndex(User.COLUMN_NAME));
            String trainingLevel = c.getString(c.getColumnIndex(User.COLUMN_TRAINING_LEVEL));
            String gender = c.getString(c.getColumnIndex(User.COLUMN_GENDER));
            float weight = c.getFloat(c.getColumnIndex(User.COLUMN_WEIGHT));

            u.setId(id);
            u.setName(name);
            u.setTrainingLevel(trainingLevel);
            u.setGender(gender);
            u.setWeight(weight);
        }

        c.close();
        db.close();
        return u;
    }

    public boolean updateUser(User u){
        //todo transactions
        SQLiteDatabase db= getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(User.COLUMN_ID, u.getId());
        contentValues.put(User.COLUMN_NAME, u.getName());
        contentValues.put(User.COLUMN_GENDER, u.getGender());
        contentValues.put(User.COLUMN_TRAINING_LEVEL, u.getTrainingLevel());
        contentValues.put(User.COLUMN_WEIGHT, u.getWeight());

        int rows = db.update(User.TABLE_NAME, contentValues, User.COLUMN_ID + "=?", new String[]{u.getId() + ""});
        db.close();
        return (rows > 0);
    }
}
