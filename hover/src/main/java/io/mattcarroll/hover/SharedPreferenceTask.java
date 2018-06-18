package io.mattcarroll.hover;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;

public class SharedPreferenceTask extends AsyncTask<Void, Void, SharedPreferences> {

    private static final String PREFS_FILE = "hover";

    private final TaskInterface mTaskInterface;

    SharedPreferenceTask(TaskInterface listener) {
        mTaskInterface = listener;
    }

    @Override
    protected SharedPreferences doInBackground(Void... params) {
        return mTaskInterface.getContext().getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
    }

    @Override
    protected void onPostExecute(SharedPreferences result) {
        super.onPostExecute(result);

        if (mTaskInterface != null) {
            mTaskInterface.onFinished(result);
        }
    }

    public interface TaskInterface {
        void onFinished(SharedPreferences result);
        Context getContext();
    }
}
