package com.chentir.ambiance.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ModelContainer;
import com.raizlabs.android.dbflow.annotation.OneToMany;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

/**
 * Created by achentir on 1/26/16.
 */
@ModelContainer
@Table(database = AmbianceDatabase.class)
public class CategoryModel extends BaseModel {
    List<QuoteModel> quoteModels;

    @PrimaryKey(autoincrement = true)
    long id;

    @Column
    String name;

    @OneToMany(methods = { OneToMany.Method.SAVE, OneToMany.Method.DELETE }, variableName = "quoteModels")
    public List<QuoteModel> getQuoteModels() {
        if ((quoteModels == null) || quoteModels.isEmpty()) {
            quoteModels = SQLite.select().from(QuoteModel.class)
                            .where(QuoteModel_Table.categoryModelForeignKeyContainer_id.eq(id)).queryList();
        }

        return quoteModels;
    }
}
