package com.chentir.ambiance.model;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by achentir on 1/26/16.
 */
@Database(name = AmbianceDatabase.NAME, version = AmbianceDatabase.VERSION)
public class AmbianceDatabase {
    public static final String NAME = "ambiance_db";
    public static final int VERSION = 1;
}
