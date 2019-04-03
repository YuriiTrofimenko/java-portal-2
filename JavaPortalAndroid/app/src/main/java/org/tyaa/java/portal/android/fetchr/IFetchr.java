package org.tyaa.java.portal.android.fetchr;

import org.json.JSONException;
//import org.tyaa.java.portal.model.Author;
import org.tyaa.java.portal.android.model.Author;

public interface IFetchr {
    void fetch();
    //void fetchOne(Integer id) throws JSONException;
    void fetchOne(Long id) throws JSONException;
    void createAuthor(Author author) throws JSONException;
    //void deleteAuthor(Integer id);
    void deleteAuthor(Long id);
}
