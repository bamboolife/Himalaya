package com.sundy.common.config;

public interface Constants {
    /**
     * Token
     */
    String TOKEN_KEY="token";

    /**
     * 在线
     */
    int NET_ONLINE = 0;
    /**
     * 离线
     */
    int NET_OFFLINE = 1;

    String HOST_KEY = "HOST";
    /**
     * 主机1
     */
    String HOST1_VALUE = "Local";
    /**
     * 主机2
     */
    String HOST2_VALUE = "Other";

    /**
     * 标识使用主机1
     */
    String HEADER_HOST1 = HOST_KEY + ":" + HOST1_VALUE;
    /**
     * 标识使用主机2
     */
    String HEADER_HOST2 = HOST_KEY + ":" + HOST2_VALUE;

    /**
     * 第三方api
     */
    String BING_HOST="https://cn.bing.com/";
    String BING_URL="https://cn.bing.com/HPImageArchive.aspx";
    String GITHUB_URL="https://api.github.com/repos/TanZhiL/Zhumulangma";
    String REDIRECT_URL = "http://api.ximalaya.com/openapi-collector-app/get_access_token";
    String REFRESH_TOKEN_URL = "https://api.ximalaya.com/oauth2/refresh_token?";
    /**
     * 测试环境
     */
    String OFFLINE_HOST1 = "https://cn.bing.com/";
    String OFFLINE_HOST2 = "http://192.168.31.105:8767/";
    /**
     * 正式环境
     */
    String ONLINE_HOST1 = "https://cn.bing.com/";
    String ONLINE_HOST2 = "http://192.168.31.105:8767/";

    interface Router {

        interface Main {
            String F_MAIN = "/main/main";
            String A_MAIN = "/main/MainActivity";
        }

        interface Home {
            String F_MAIN = "/home/main";
            String F_SEARCH = "/home/search";
            String F_RANK = "/home/rank";
            String F_SEARCH_RESULT = "/home/search/result";
            String F_SEARCH_SUGGEST = "/home/search/suggest";
            String F_ALBUM_LIST = "/home/album/list";
            String F_TRACK_LIST = "/home/track/list";
            String F_ANNOUNCER_LIST = "/home/announcer/list";
            String F_RADIO_LIST = "/home/radio/list";
            String F_ALBUM_DETAIL = "/home/album/detail";
            String F_PLAY_TRACK = "/home/play/track";
            String F_PLAY_RADIIO = "/home/play/radio";
            String F_ANNOUNCER_DETAIL = "/home/announcer/detail";
            String F_BATCH_DOWNLOAD = "/home/batch/download";
            String F_SCAN = "/home/scan";
        }

        interface User {
            String F_MAIN = "/user/main";
            String F_MESSAGE = "/user/message";
        }

        interface Discover {
            String F_MAIN = "/discover/main";
            String F_WEB = "/discover/web";
        }

        interface Listen {
            String F_MAIN = "/listen/main";
            String F_DOWNLOAD = "/listen/download";
            String F_DOWNLOAD_DELETE = "/listen/download/delete";
            String F_DOWNLOAD_SORT = "/listen/download/sort";
            String F_DOWNLOAD_ALBUM = "/listen/download/album";
            String F_HISTORY = "/listen/history";
            String F_FAVORITE = "/listen/favorite";
        }

    }

    interface Third {
        //喜马拉雅
        String XIMALAYA_SECRET = "10297fe7f97d1360c624836da3bfbfa2";
        String TBOOK_KEY="c245b8f690162ef891ce58ef1c8b05b1";
        String PACK_ID="com.sundy.tbook";
        int XIMALAYA_NOTIFICATION = 10001;

    }

    interface SP {
        String USER = "user";
        String TOKEN = "token";
        String HOST = "host";
        String CITY_CODE = "city_code";
        String CITY_NAME = "city_name";
        String PROVINCE_CODE = "province_code";
        String PROVINCE_NAME = "province_name";

        String PLAY_SCHEDULE_TYPE = "play_schedule_type";
        String PLAY_SCHEDULE_TIME = "play_schedule_time";
        String AD_TIME = "ad_time";
        String AD_LABEL = "ad_label";
        String AD_URL = "ad_url";
    }

    interface Default {
        String CITY_CODE = "4301";
        String CITY_NAME = "长沙";
        String PROVINCE_CODE = "430000";
        String PROVINCE_NAME = "湖南";
        String AD_NAME = "/ad.jpg";
    }

    interface Cache {
        String FACE = "face";
    }

}
