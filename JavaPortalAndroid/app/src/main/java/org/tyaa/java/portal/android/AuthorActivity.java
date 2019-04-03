package org.tyaa.java.portal.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;
import org.tyaa.java.portal.android.fetchr.IFetchedDataHandler;
import org.tyaa.java.portal.android.fetchr.JsonFetchr;
//import org.tyaa.java.portal.model.Author;
import org.tyaa.java.portal.android.model.Author;

import java.util.List;

public class AuthorActivity extends Activity implements IFetchedDataHandler {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);
        Intent intent = getIntent();
        //Author author =
        //        (Author) intent.getSerializableExtra(MainActivity.SELECTED_AUTHOR);
        //Log.d("my - AuthorActivity", author.getAbout());
        try {
            new JsonFetchr(this)
                    //.fetchOne((Integer)intent.getSerializableExtra(MainActivity.SELECTED_AUTHOR));
                    .fetchOne((Long)intent.getSerializableExtra(MainActivity.SELECTED_AUTHOR));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onAuthorsFetched(List authorList) {

    }

    @Override
    public void onAuthorFetched(Author author) {
        TextView aboutTextView = findViewById(R.id.authorTextView);
        aboutTextView.setText(author.getAbout());
    }

    @Override
    public void onActionCompleted(String status) {

    }
}
