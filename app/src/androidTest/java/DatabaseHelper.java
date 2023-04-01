import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Name und Version der Datenbank
    private static final String DATABASE_NAME = "fitness.db";
    private static final int DATABASE_VERSION = 1;

    // Konstruktor der Klasse
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Methode zum Erstellen der Tabellen der Datenbank
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Tabelle für die Übungen erstellen
        db.execSQL("CREATE TABLE exercises (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, sets INTEGER, reps INTEGER, weight REAL, time INTEGER)");

        // Tabelle für die Workouts erstellen
        db.execSQL("CREATE TABLE workouts (_id INTEGER PRIMARY KEY AUTOINCREMENT, date DATE)");

        // Tabelle für die Übungen in den Workouts erstellen
        db.execSQL("CREATE TABLE workout_exercises (workout_id INTEGER, exercise_id INTEGER, FOREIGN KEY(workout_id) REFERENCES workouts(_id), FOREIGN KEY(exercise_id) REFERENCES exercises(_id))");
    }

    // Methode zum Aktualisieren der Datenbank
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Hier implementieren Sie den Code, um Ihre Datenbank zu aktualisieren, falls die Versionsnummer erhöht wird
    }
}
