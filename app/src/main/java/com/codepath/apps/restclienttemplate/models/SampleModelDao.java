package com.codepath.apps.restclienttemplate.models;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SampleModelDao {

<<<<<<< HEAD

=======
    // @Query annotation requires knowing SQL syntax
    // See http://www.sqltutorial.org/
>>>>>>> 96778e4f552e9ac9fd32ad2dcc9db51cf26b5e96
    
    @Query("SELECT * FROM SampleModel WHERE id = :id")
    SampleModel byId(long id);

    @Query("SELECT * FROM SampleModel ORDER BY ID DESC LIMIT 300")
    List<SampleModel> recentItems();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertModel(SampleModel... sampleModels);
}
