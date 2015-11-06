package com.inventarioweb.empresa.inventarioandroid.DataBase;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Henry on 5/11/15.
 */
public class DataBaseConfig extends OrmLiteConfigUtil {

    public static void main(String[] args) throws IOException, SQLException {
        writeConfigFile("ormlite_config.txt");
    }
}
