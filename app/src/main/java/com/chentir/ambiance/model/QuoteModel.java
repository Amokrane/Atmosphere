package com.chentir.ambiance.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.container.ForeignKeyContainer;

/**
 * Created by achentir on 1/26/16.
 */
@Table(database = AmbianceDatabase.class)
public class QuoteModel extends BaseModel {

    @PrimaryKey(autoincrement = true)
    long id;

    @Column
    String content;

    @Column
    String title;

    @Column
    @ForeignKey(saveForeignKeyModel = false)
    ForeignKeyContainer<CategoryModel> categoryModelForeignKeyContainer;

    public void associateQuoteModel(CategoryModel categoryModel) {
        categoryModelForeignKeyContainer = FlowManager.getContainerAdapter(CategoryModel.class)
                        .toForeignKeyContainer(categoryModel);
    }
}