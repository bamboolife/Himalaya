package com.sundy.common.bean;

import com.google.gson.Gson;
import com.ximalaya.ting.android.opensdk.model.album.Album;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.converter.PropertyConverter;

/**
 * 项目名称：Himalaya
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-01-17 21:32
 * 描述：
 */
public class SubscribeBean {
    @Id
    private
    long albumId;
    @Convert(converter = AlbumConverter.class,columnType = String.class)
    private
    Album album;
    private long datetime;


    public static class AlbumConverter implements PropertyConverter<Album, String> {
        @Override
        public Album convertToEntityProperty(String databaseValue) {
            if (databaseValue == null) {
                return null;
            }
            return new Gson().fromJson(databaseValue, Album.class);
        }

        @Override
        public String convertToDatabaseValue(Album entityProperty) {
            if (entityProperty == null) {
                return null;
            }
            return new Gson().toJson(entityProperty);
        }
    }
}
