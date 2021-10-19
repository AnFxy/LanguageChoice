package jp.co.cte.kyuzin;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * 课题号（GORASA-XXXX)
 * 类或接口的描述信息
 *
 * @author
 * @date 2021/10/18
 */
public class PrefUtil {
    private final static SharedPreferences.Editor sp = ContextAll.getContext().getSharedPreferences(Constants.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE).edit();
    private final static SharedPreferences spGet = ContextAll.getContext().getSharedPreferences(Constants.SHARED_PREFERENCE_NAME,Context.MODE_PRIVATE);

    public static void writeInt(String key, int value){
        try{
            sp.putInt(key, value);
            sp.apply();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void writeBoolean(String key, boolean value){
        try{
            sp.putBoolean(key, value);
            sp.apply();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void writeString(String key, String value){
        try{
            sp.putString(key, value);
            sp.apply();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void writeFloat(String key, float value){
        try{
            sp.putFloat(key, value);
            sp.apply();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void writeLong(String key, long value){
        try{
            sp.putLong(key, value);
            sp.apply();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // get sharepreference value from location data;
    public static int readInt(String key, int failValue){
        try{
            return spGet.getInt(key, failValue);
        }catch (Exception e){
            e.printStackTrace();
            return failValue;
        }
    }

    public static boolean readBoolean(String key, boolean failValue){
        try{
            return spGet.getBoolean(key, failValue);
        }catch (Exception e){
            e.printStackTrace();
            return failValue;
        }
    }

    public static String readString(String key, String failValue){
        try{
            return spGet.getString(key, failValue);
        }catch (Exception e){
            e.printStackTrace();
            return failValue;
        }
    }

    public static Float readFloat(String key, float failValue){
        try{
            return spGet.getFloat(key, failValue);
        }catch (Exception e){
            e.printStackTrace();
            return failValue;
        }
    }

    public static long readLong(String key, long failValue){
        try{
            return spGet.getLong(key, failValue);
        }catch (Exception e){
            e.printStackTrace();
            return failValue;
        }
    }


}
