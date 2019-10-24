package com.ndtlg.dzb;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;

import com.ab.util.AbDateUtil;
import com.ab.util.AbMd5;
import com.google.gson.Gson;
import com.mdx.framework.Frame;

import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class F {
    public static double latitude = 0;
    public static double longitude = 0;
    public static String locationAddress = "";
    public static String deviceid = "";
    public static String mclass = "/api/v1/mclass/" + deviceid;
    public static String mIndexClassInfo = "/api/v1/mclass/" + deviceid + "/mIndexClassInfo";
    public static String mSectionList = "/api/v1/mclass/" + deviceid + "/mSectionList";
    public static String mUserInfo = "/api/v1/mUserInfo/" + deviceid + "/";
    public static String mmoral = "/api/v1/mclass/mmoral/" + deviceid + "/";
    public static String symNewsList = "/api/v1/mindex/mNewsList/" + deviceid + "/";
    public static String mClassStyleList = "/api/v1/mindex/mClassStyleList/" + deviceid;
    public static String mClassList = "/api/v1/mindex/mClassList/" + deviceid;
    public static String mStudyList = "/api/v1/mindex/mStudyList/" + deviceid;
    public static String mNewsList = "/api/v1/mnews/mNewsList/" + deviceid + "/";
    public static String mnews = "/api/v1/mnews/";
    public static String MIndexWeather = "/api/v1/mindex/MIndexWeather";
    public static String xcmClassStyleList = "/api/v1/mclass/mClassStyleList/" + deviceid + "/";
    public static String mClassStyleDetail = "/api/v1/mclass/mClassStyleDetail/";
    public static String mStudyCircleList = "/api/v1/mclass/mStudyCircleList/" + deviceid + "/";
    public static String mCategoryList = "/api/v1/mclass/mCategoryList/" + deviceid;
    public static String mDeviceidOk = "/api/v1/mclass/mDeviceidOk/" + deviceid;

    public static String getUserJson(String key) {
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(Frame.CONTEXT);
        return sp.getString(key, "");
    }

    //根据身份证号输出年龄
    public static int IdNOToAge(String IdNO) {
        int leh = IdNO.length();
        String dates = "";
        if (leh == 18) {
            int se = Integer.valueOf(IdNO.substring(leh - 1)) % 2;
            dates = IdNO.substring(6, 10);
            SimpleDateFormat df = new SimpleDateFormat("yyyy");
            String year = df.format(new Date());
            int u = Integer.parseInt(year) - Integer.parseInt(dates);
            return u;
        } else {
            dates = IdNO.substring(6, 8);
            return Integer.parseInt(dates);
        }

    }

    public static void saveUserJson(String json, String key) {
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(Frame.CONTEXT);
        sp.edit().putString(key, json).commit();
    }

    public static String changeTime(String date) {
        try {
            return AbDateUtil.getStringByFormat(AbDateUtil.getDateByFormat(date, "yyyyMMddHHmmss"), "yyyy-MM-dd HH:mm");
        } catch (Exception e) {
            return date;
        }

    }

    public static String changeDate(String date) {
        try {
            return AbDateUtil.getStringByFormat(AbDateUtil.getDateByFormat(date, "yyyyMMdd"), "yyyy-MM-dd");
        } catch (Exception e) {
            return date;
        }

    }

    public static String getUserId() {
        return "10000";
    }

    public static String getVersionCode() {
        try {
            // 获取packagemanager的实例
            PackageManager packageManager = Frame.CONTEXT.getPackageManager();
            // getPackageName()是你当前类的包名，0代表是获取版本信息
            PackageInfo packInfo = packageManager.getPackageInfo(
                    Frame.CONTEXT.getPackageName(), 0);
            String version = packInfo.versionCode + "";
            return version;
        } catch (Exception e) {

        }
        return "1";
    }

    public static Date getMonthStart(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int index = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.add(Calendar.DATE, (1 - index));
        return calendar.getTime();
    }

    public static Date getMonthEnd(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        int index = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.add(Calendar.DATE, (-index));
        return calendar.getTime();
    }

    public static Date getNext(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        return calendar.getTime();
    }

    /**
     * 通过Base32将Bitmap转换成Base64字符串
     *
     * @return
     */
    public static String Bitmap2StrByBase64(String picpathcrop) {
        return Base64.encodeToString(bitmap2Byte(picpathcrop), Base64.DEFAULT);
    }


    public static byte[] bitmap2Byte(String picpathcrop) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        com.mdx.framework.utility.BitmapRead.decodeSampledBitmapFromFile(
                picpathcrop, 480, 0).compress(Bitmap.CompressFormat.JPEG, 80,
                out);
        try {
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return out.toByteArray();
    }

    public static boolean isSameDate(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        boolean isSameYear = cal1.get(Calendar.YEAR) == cal2
                .get(Calendar.YEAR);
        boolean isSameMonth = isSameYear
                && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
        boolean isSameDate = isSameMonth
                && cal1.get(Calendar.DAY_OF_MONTH) == cal2
                .get(Calendar.DAY_OF_MONTH);
        return isSameDate;
    }

    public static boolean isHzorPy(char hanzi) {
        HanyuPinyinOutputFormat hanyuPinyin = new HanyuPinyinOutputFormat();
        hanyuPinyin.setToneType(HanyuPinyinToneType.WITH_TONE_MARK);
        hanyuPinyin.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);
        String[] pinyinArray = null;
        try {
            // 是否在汉字范围内
            if (hanzi >= 0x4e00 && hanzi <= 0x9fa5) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Pattern p = Pattern.compile("[a-zA-Z]");
        Matcher m = p.matcher(String.valueOf(hanzi));
        if (m.matches()) {
            return true;
        }
        return false;
    }

    public static boolean isSameDateY(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        boolean isSameYear = cal1.get(Calendar.YEAR) == cal2
                .get(Calendar.YEAR);
        boolean isSameMonth = isSameYear
                && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
        return isSameMonth;
    }

    public static String getTime(String time) {
        if (!TextUtils.isEmpty(time)) {
            String data = "";
            DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            try {
                Date d2 = df.parse(time);
                long diff = d2.getTime() - new Date().getTime();// 这样得到的差值是微秒级别
                long days = diff / (1000 * 60 * 60 * 24);

                long hours = (diff - days * (1000 * 60 * 60 * 24))
                        / (1000 * 60 * 60);
                long minutes = (diff - days * (1000 * 60 * 60 * 24) - hours
                        * (1000 * 60 * 60))
                        / (1000 * 60);
                long miao = (diff - days * 1000 * 60 * 60 * 24 - hours * 1000
                        * 60 * 60 - minutes * 1000 * 60) / 1000;
                data = "" + days + "天" + hours + "小时" + minutes + "分" + miao
                        + "秒";
            } catch (Exception e) {
                e.printStackTrace();
            }
            return data;
        } else {
            return "";
        }
    }

    public static void init() {
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(Frame.CONTEXT);
        deviceid = sp.getString("deviceid", "");

        mclass = "/api/v1/mclass/" + deviceid;
        mIndexClassInfo = "/api/v1/mclass/" + deviceid + "/mIndexClassInfo";
        mSectionList = "/api/v1/mclass/" + deviceid + "/mSectionList";
        mUserInfo = "/api/v1/mUserInfo/" + deviceid + "/";
        mmoral = "/api/v1/mclass/mmoral/" + deviceid + "/";
        symNewsList = "/api/v1/mindex/mNewsList/" + deviceid + "/";
        mClassStyleList = "/api/v1/mindex/mClassStyleList/" + deviceid;
        mClassList = "/api/v1/mindex/mClassList/" + deviceid;
        mStudyList = "/api/v1/mindex/mStudyList/" + deviceid;
        mNewsList = "/api/v1/mnews/mNewsList/" + deviceid + "/";
        mnews = "/api/v1/mnews/";
        MIndexWeather = "/api/v1/mindex/MIndexWeather";
        xcmClassStyleList = "/api/v1/mclass/mClassStyleList/" + deviceid + "/";
        mClassStyleDetail = "/api/v1/mclass/mClassStyleDetail/";
        mStudyCircleList = "/api/v1/mclass/mStudyCircleList/" + deviceid + "/";
        mCategoryList = "/api/v1/mclass/mCategoryList/" + deviceid;
        mDeviceidOk = "/api/v1/mclass/mDeviceidOk/" + deviceid;
    }

    public static void saveDeviceid(String did) {
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(Frame.CONTEXT);
        sp.edit().putString("deviceid", did).commit();
        init();
    }


    public static byte[] bitmap2Byte(Bitmap bitmap) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 80,
                out);
        try {
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return out.toByteArray();
    }


    public static void getUrl(final String url, final String from, final int type) {
        try {
            new Thread() {
                @Override
                public void run() {
                    Bitmap bitmap = null;
                    try {
                        URL pictureUrl = new URL(url);
                        HttpURLConnection con = (HttpURLConnection) pictureUrl
                                .openConnection();
                        InputStream in = con.getInputStream();
                        bitmap = BitmapFactory.decodeStream(in);
                        in.close();
                        Frame.HANDLES.sentAll(from, type, Base64.encodeToString(bitmap2Byte(bitmap), Base64.DEFAULT));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String getSharedPreferValue(String key, String defValue) {
        SharedPreferences sp = Frame.CONTEXT.getSharedPreferences("apikey_and_token", Context.MODE_PRIVATE);
        return sp.getString(key, defValue);
    }

    /**
     * 将每三个数字加上逗号处理（通常使用金额方面的编辑）
     *
     * @param str 需要处理的字符串
     * @return 处理完之后的字符串
     */
    public static String addComma(String str) {
        try {
            DecimalFormat decimalFormat = new DecimalFormat("##,###");
            if (str.contains(".")) {
                String end = String.format("%.2f", Float.valueOf(str.substring(str.indexOf("."))));
                return decimalFormat.format(Double.parseDouble(str.substring(0, str.indexOf(".")))) + end.substring(end.indexOf("."));
            } else {
                return decimalFormat.format(Double.parseDouble(str));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String changeKh(String code) {
        if (!TextUtils.isEmpty(code) && code.length() > 8) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < code.length(); i++) {
                char c = code.charAt(i);
                if (i >= 4 && i < code.length() - 4) {
                    sb.append('*');
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
        return code;
    }

    public static String changePhone(String code) {
        if (!TextUtils.isEmpty(code) && code.length() == 11) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < code.length(); i++) {
                char c = code.charAt(i);
                if (i >= 3 && i < code.length() - 4) {
                    sb.append('*');
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
        return code;
    }

    public static String changeSFZ(String code) {
        if (!TextUtils.isEmpty(code) && code.length() > 10) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < code.length(); i++) {
                char c = code.charAt(i);
                if (i >= 6 && i < code.length() - 4) {
                    sb.append('*');
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
        return code;
    }

    public static Object json2Model(String json, Class<?> mclass) {
        return new Gson().fromJson(json, mclass);
    }

    public static String getVersionName() {
        try {
            // 获取packagemanager的实例
            PackageManager packageManager = Frame.CONTEXT.getPackageManager();
            // getPackageName()是你当前类的包名，0代表是获取版本信息
            PackageInfo packInfo = packageManager.getPackageInfo(
                    Frame.CONTEXT.getPackageName(), 0);
            String version = packInfo.versionName;
            return version;
        } catch (Exception e) {

        }
        return "1.0";
    }

    /**
     * 用来遍历对象属性和属性值
     */
    public static String readClassAttr(Object tb) {
        HashMap map = new HashMap();
        List<String> list = new ArrayList<>();
        String str = "";
        try {
            Field[] fields = tb.getClass().getDeclaredFields();
            System.out.println(fields.length);
            for (Field field : fields) {
                field.setAccessible(true);
                if (!field.getName().equals("sign") && !TextUtils.isEmpty(field.get(tb).toString())) {
                    map.put(field.getName(), TextUtils.isEmpty(field.get(tb).toString()) ? "" : field.get(tb).toString());
                    list.add(field.getName());
                }
            }
            if (tb.getClass().getSuperclass() != null && (tb.getClass().getSuperclass().getSimpleName().equals("BeanBase") || tb.getClass().getSuperclass().getSimpleName().equals("BeanListBase"))) {
                Field[] fields_father = tb.getClass().getSuperclass().getDeclaredFields();
                for (Field field : fields_father) {
                    field.setAccessible(true);
                    if (!field.getName().equals("sign") && !TextUtils.isEmpty(field.get(tb).toString())) {
                        map.put(field.getName(), TextUtils.isEmpty(field.get(tb).toString()) ? "" : field.get(tb).toString());
                        list.add(field.getName());
                    }
                }
            }
            Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
            for (String key : list) {
                str += key + "=" + map.get(key) + "&";
            }
            str += "key=XiaoFeiJinRong6a6a877f144a05934";
            Log.i("sign=", str);
            return AbMd5.md5(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String readClassByJson(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            String str = "";
            List<String> list = new ArrayList<>();
            HashMap map = new HashMap();
            Iterator iterator = jsonObject.keys();                       // joData是JSONObject对象
            while (iterator.hasNext()) {
                String key = iterator.next() + "";
                if (!key.equals("sign") && !TextUtils.isEmpty(jsonObject.optString(key))) {
                    map.put(key, jsonObject.optString(key));
                    list.add(key);
                }
            }
            Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
            for (String key : list) {
                str += key + "=" + map.get(key) + "&";
            }
            str += "key=XiaoFeiJinRong6a6a877f144a05934";
            Log.i("sign=", str);
            return AbMd5.md5(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    /**
     * 判断是否是银行卡号
     *
     * @param cardId
     * @return
     */
    public static boolean checkBankCard(String cardId) {
        char bit = getBankCardCheckCode(cardId
                .substring(0, cardId.length() - 1));
        if (bit == 'N') {
            return false;
        }
        return cardId.charAt(cardId.length() - 1) == bit;
    }

    public static char getBankCardCheckCode(String nonCheckCodeCardId) {
        if (nonCheckCodeCardId == null
                || nonCheckCodeCardId.trim().length() == 0
                || !nonCheckCodeCardId.matches("\\d+")) {
            // 如果传的不是数据返回N
            return 'N';
        }
        char[] chs = nonCheckCodeCardId.trim().toCharArray();
        int luhmSum = 0;
        for (int i = chs.length - 1, j = 0; i >= 0; i--, j++) {
            int k = chs[i] - '0';
            if (j % 2 == 0) {
                k *= 2;
                k = k / 10 + k % 10;
            }
            luhmSum += k;
        }
        return (luhmSum % 10 == 0) ? '0' : (char) ((10 - luhmSum % 10) + '0');
    }
}
