package admin.emart.com.util;

import java.sql.Clob;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.StringTokenizer;

public class StringUtil {

    public StringUtil() {}

    public static String[] encode(String as[]) {
        if(as == null) {
        	return null;
        }
        for(int i = 0; i < as.length; i++) {
        	as[i] = encode(as[i]);
        }

        return as;
    }

    public static String encode(String s) {
        try {
            return new String(s.getBytes("KSC5601"), "8859_1");
        } catch(Exception exception) {
            return null;
        }
    }

    public static String encodeUTF8(String s) {
        try {
            return new String(s.getBytes("UTF-8"), "8859_1");
        } catch(Exception exception) {
            return null;
        }
    }

    public static String encode(String s, String enc) {
        try {
            return new String(s.getBytes("KSC5601"), enc);
        } catch(Exception exception) {
            return null;
        }
    }

    public static String decode(String s) {
        try {
        	if(s != null && !s.isEmpty()) {
        		return new String(s.getBytes("8859_1"), "KSC5601");
        	} else {
        		return "";
        	}
        } catch(Exception exception) {
            return null;
        }
    }

    public static String decodeUTF8(String s) {
        try {
        	if(s != null && !s.isEmpty()) {
        		return new String(s.getBytes("8859_1"), "UTF-8");
        	} else {
        		return "";
        	}
        } catch(Exception exception) {
            return null;
        }
    }

    public static String decodeEUCKR(String s) {
    	try {
    		if(s != null && !s.isEmpty()) {
    			return new String(s.getBytes("8859_1"), "EUC-KR");
    		} else {
    			return "";
    		}
    	} catch(Exception exception) {
    		return null;
    	}
    }

    public static String[] decode(String as[]) {
        if(as == null) {
        	return null;
        }

        for(int i = 0; i < as.length; i++) {
        	as[i] = decode(as[i]);
        }

        return as;
    }

    public static boolean isDefined(String s) {
        return s != null && s.length() != 0;
    }

    public static boolean isDefined(String as[]) {
        return as != null && as.length != 0;
    }

    public static String toUpperCase(String s) {
        if(!isDefined(s)) {
        	return s;
        } else {
        	return s.toUpperCase();
        }
    }

    public static String toLowerCase(String s) {
        if(!isDefined(s)) {
        	return s;
        } else {
        	return s.toLowerCase();
        }
    }

    public static String getNameByte(String s, int start, int end) throws Exception {
        int bytelen = getByte(s);
        if(start == 0 && end > bytelen) {
        	return s;
        }

        if(start < bytelen && (end < bytelen || end == bytelen)) {
        	return s.substring(start / 2, end / 2);
        } else {
        	return "";
        }
    }

    public static int getByte(String s) {
        int i = 1;
        if(s != null) {
            for(int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if(isHalf(c)) {
                	i++;
                } else {
                	i += 2;
                }
            }
        }
        return i;
    }

    private static boolean isHalf(char c)
    {
        return ' ' <= c && c < '\177';
    }

    public static String[] tokenize(String s, String s1)
    {
        if(s == null || s1 == null)
            return null;
        else
            return tokenize(new StringTokenizer(s, s1));
    }

    public static String[] tokenize(StringTokenizer stringtokenizer)
    {
        return tokenize(stringtokenizer, stringtokenizer.countTokens());
    }

    public static String[] tokenize(StringTokenizer stringtokenizer, int i)
    {
        String as[] = new String[i];
        for(int j = 0; j < i; j++)
            as[j] = stringtokenizer.hasMoreElements() ? stringtokenizer.nextToken().trim() : null;

        return as;
    }

    public static String toString(Collection c)
    {
        if(c == null)
            return "";
        StringBuffer sb = new StringBuffer();
        for(Iterator i = c.iterator(); i.hasNext();)
        {
            sb.append(i.next());
            if(i.hasNext())
                sb.append(", ");
        }

        return sb.toString();
    }

    public static String toString(Object object)
    {
        if(object != null)
            return object.toString();
        else
            return "";
    }

    public static String toString(int c)
    {
        return String.valueOf(c);
    }

    public static String toString(int c[])
    {
        if(c == null)
            return "";
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < c.length; i++)
        {
            sb.append(c[i]);
            if(i < c.length - 1)
                sb.append(", ");
        }

        return sb.toString();
    }

    public static String toString(double d)
    {
        return Double.toString(d);
    }

    public static String toString(String as[])
    {
        if(as == null)
            return "";
        StringBuffer stringbuffer = new StringBuffer();
        for(int i = 0; i < as.length; i++)
        {
            stringbuffer.append(as[i]);
            if(i < as.length - 1)
                stringbuffer.append(",");
        }

        return stringbuffer.toString();
    }

    public static String toString(List list, List list1)
    {
        if(list == null || list1 == null)
            return "";
        int i = list.size();
        int j = list1.size();
        if(i != j)
            return "";
        StringBuffer stringbuffer = new StringBuffer();
        for(int k = 0; k < i; k++)
        {
            stringbuffer.append(list.get(k)).append("=").append(list1.get(k));
            if(k < i - 1)
                stringbuffer.append(", ");
        }

        return stringbuffer.toString();
    }

    public static boolean contains(String s, String in)
    {
        if(!isDefined(s))
            return false;
        else
            return s.indexOf(in) > -1;
    }

    public static boolean contains(String s, String in[])
    {
        boolean flag = false;
        if(!isDefined(in))
            return false;
        for(int i = 0; i < in.length; i++)
        {
            if(!equals(s, in[i]))
                continue;
            flag = true;
            break;
        }

        return flag;
    }

    public static boolean equals(String s, String s1)
    {
        if(s == null && s1 == null)
            return true;
        if(s == null || s1 == null)
            return false;
        else
            return s.equals(s1);
    }

    public static boolean equalsIgnoreCase(String s, String s1)
    {
        if(s == null && s1 == null)
            return true;
        if(s == null || s1 == null)
            return false;
        else
            return s.equalsIgnoreCase(s1);
    }

    public static boolean equals(String s, Object s1)
    {
        if(s == null && s1 == null)
            return true;
        if(s == null || s1 == null)
            return false;
        else
            return s.equalsIgnoreCase(toString(s1));
    }

    public static boolean equalsIgnoreCase(String s, Object s1)
    {
        if(s == null && toString(s1) == null)
            return true;
        if(s == null || s1 == null)
            return false;
        else
            return s.equalsIgnoreCase(toString(s1));
    }

    public static boolean equals(int i, int j)
    {
        return i == j;
    }

    public static String trim(String s)
    {
        if(!isDefined(s))
            return s;
        else
            return s.trim();
    }

    public static String[] trim(String s[])
    {
        if(s == null)
            return null;
        String as[] = new String[s.length];
        for(int i = 0; i < s.length; i++)
            as[i] = trim(s[i]);

        return as;
    }

    public static int parseInt(String s)
    {
        return parseInt(s, 0);
    }

    public static int parseInt(Object o)
    {
        return parseInt(o, 0);
    }

    public static int parseInt(String s, int i)
    {
        try
        {
            return Integer.parseInt(s);
        }
        catch(NumberFormatException numberformatexception)
        {
            return i;
        }
    }

    public static int parseInt(Object o, int i)
    {
        try
        {
            return Integer.parseInt(toString(o));
        }
        catch(NumberFormatException numberformatexception)
        {
            return i;
        }
    }

    public static String normalizeNull(String s)
    {
        if(s == null)
            return "";
        if(equals(s, "null"))
            return "";
        if(equals(s, "undefined"))
            return "";
        else
            return s;
    }

    public static String escape(int i)
    {
        return escape(toString(i));
    }

    public static String escape(String s)
    {
        if(!isDefined(s))
        {
            return "";
        } else
        {
            String s1 = s;
            s1 = s1.replaceAll("&", "&amp;");
            s1 = s1.replaceAll("'", "&#039;");
            s1 = s1.replaceAll("\"", "&#34;");
            s1 = s1.replaceAll("<", "&lt;");
            s1 = s1.replaceAll(">", "&gt;");
            return s1;
        }
    }

    public static String normalizeSql(int i)
    {
        return normalizeSql(toString(i));
    }

    public static String normalizeSql(String s)
    {
        if(!isDefined(s))
        {
            return "";
        } else
        {
            s = s.replaceAll("/", "//");
            s = s.replaceAll("%", "/%");
            s = s.replaceAll("_", "/_");
            return s;
        }
    }

    public static String normalize(String s, String replace)
    {
        if(!isDefined(s))
            return normalizeNull(replace);
        else
            return s;
    }

    public static String normalize(String s)
    {
        if(s == null)
            return "";
        int i;
        for(int j = -1; (i = s.substring(j + 1).indexOf('&')) != -1; j = i)
        {
            i += j + 1;
            s = new String((new StringBuffer(s)).replace(i, i + 1, "&amp;"));
        }

        return normalizeLtGtQuot(s);
    }

    public static String normalizeLtGtQuot(String s)
    {
        if(s == null)
            return "";
        for(int i = -1; (i = s.indexOf('"')) != -1;)
            s = new String((new StringBuffer(s)).replace(i, i + 1, "&quot;"));

        int j;
        while((j = s.indexOf('<')) != -1)
            s = new String((new StringBuffer(s)).replace(j, j + 1, "&lt;"));
        while((j = s.indexOf('>')) != -1)
            s = new String((new StringBuffer(s)).replace(j, j + 1, "&gt;"));
        while((j = s.indexOf('&')) != -1)
            s = new String((new StringBuffer(s)).replace(j, j + 1, "&amp;"));
        return s;
    }

    public static String replace(String s, String s1, String s2)
    {
        if(s == null || s1 == null || s2 == null)
            return s;
        StringBuffer stringbuffer = new StringBuffer();
        int i = s1.length();
        int j = 0;
        for(int k = 0; (k = s.indexOf(s1, j)) != -1;)
        {
            stringbuffer.append(s.substring(j, k)).append(s2);
            j = k + i;
        }

        stringbuffer.append(s.substring(j));
        return stringbuffer.toString();
    }

    public static String format(Timestamp timestamp, String format)
    {
        if(timestamp == null)
            return "";
        else
            return (new SimpleDateFormat(format)).format(timestamp);
    }

    public static String getFormatToday(String format)
    {
        Date today = new Date();
        return (new SimpleDateFormat(format)).format(new Timestamp(today.getTime()));
    }

    public static String getFormatTodayK(String format)
    {
        Date today = new Date();
        return (new SimpleDateFormat(format,Locale.KOREAN)).format(new Timestamp(today.getTime()));
    }

    public static String formatToYYYYMMDD(String s)
    {
        if(s == null || s.length() < 8)
            return s;
        else
            return (new StringBuilder(String.valueOf(s.substring(0, 4)))).append("-").append(s.substring(4, 6)).append("-").append(s.substring(6, 8)).toString();
    }

    public static String formateDateInline(String s)
    {
        if(s == null)
            return s;
        String list[] = tokenize(s, "-");
        if(list != null && list.length > 0)
        {
            if(list.length > 2)
                return (new StringBuilder("(")).append(list[0]).append(")").append(list[1]).append("-").append(list[2]).toString();
            if(list.length > 1)
                return "";
        }
        return "";
    }

    public static String formatCurrency(String s)
    {
        if(!isDefined(s) || "null".equals(s))
        {
            return "";
        } else
        {
            Double currency = new Double(s);
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
            String currencyOut = currencyFormatter.format(currency);
            return replace(currencyOut.toString(), "\uFFE6", "");
        }
    }

    public static String fill(String s, String fill, int max)
    {
        if(s == null)
            return "";
        int len = s.length();
        for(int i = 0; i < max - len; i++)
            s = (new StringBuilder(String.valueOf(fill))).append(s).toString();

        return s;
    }

    public static String cut(String s, int max)
    {
        if(s == null)
            return "";
        if(s.length() > max)
            return (new StringBuilder(String.valueOf(s.substring(0, max)))).append("...").toString();
        else
            return s;
    }

    public static String URL_encode(String s)
    {
        StringBuffer stringbuffer = new StringBuffer();
        byte abyte0[];
        try
        {
            abyte0 = s.getBytes("KSC5601");
        }
        catch(Exception exception)
        {
            return "";
        }
        for(int i = 0; i < abyte0.length; i++)
            switch(abyte0[i])
            {
            case 32: // ' '
                stringbuffer.append("+");
                break;

            case 33: // '!'
                stringbuffer.append("%21");
                break;

            case 35: // '#'
                stringbuffer.append("%23");
                break;

            case 36: // '$'
                stringbuffer.append("%24");
                break;

            case 37: // '%'
                stringbuffer.append("%25");
                break;

            case 94: // '^'
                stringbuffer.append("%5E");
                break;

            case 38: // '&'
                stringbuffer.append("%26");
                break;

            case 40: // '('
                stringbuffer.append("%28");
                break;

            case 41: // ')'
                stringbuffer.append("%29");
                break;

            case 61: // '='
                stringbuffer.append("%3D");
                break;

            case 43: // '+'
                stringbuffer.append("%2B");
                break;

            case 91: // '['
                stringbuffer.append("%5B");
                break;

            case 93: // ']'
                stringbuffer.append("%5D");
                break;

            case 123: // '{'
                stringbuffer.append("%7B");
                break;

            case 125: // '}'
                stringbuffer.append("%7D");
                break;

            case 124: // '|'
                stringbuffer.append("%7C");
                break;

            case 92: // '\\'
                stringbuffer.append("%5C");
                break;

            case 58: // ':'
                stringbuffer.append("%3A");
                break;

            case 59: // ';'
                stringbuffer.append("%3B");
                break;

            case 34: // '"'
                stringbuffer.append("%22");
                break;

            case 39: // '\''
                stringbuffer.append("%27");
                break;

            case 60: // '<'
                stringbuffer.append("%3C");
                break;

            case 62: // '>'
                stringbuffer.append("%3E");
                break;

            case 44: // ','
                stringbuffer.append("%2C");
                break;

            case 63: // '?'
                stringbuffer.append("%3F");
                break;

            case 47: // '/'
                stringbuffer.append("%2F");
                break;

            case 126: // '~'
                stringbuffer.append("%7E");
                break;

            case 96: // '`'
                stringbuffer.append("%60");
                break;

            case 42: // '*'
            case 45: // '-'
            case 46: // '.'
            case 48: // '0'
            case 49: // '1'
            case 50: // '2'
            case 51: // '3'
            case 52: // '4'
            case 53: // '5'
            case 54: // '6'
            case 55: // '7'
            case 56: // '8'
            case 57: // '9'
            case 64: // '@'
            case 65: // 'A'
            case 66: // 'B'
            case 67: // 'C'
            case 68: // 'D'
            case 69: // 'E'
            case 70: // 'F'
            case 71: // 'G'
            case 72: // 'H'
            case 73: // 'I'
            case 74: // 'J'
            case 75: // 'K'
            case 76: // 'L'
            case 77: // 'M'
            case 78: // 'N'
            case 79: // 'O'
            case 80: // 'P'
            case 81: // 'Q'
            case 82: // 'R'
            case 83: // 'S'
            case 84: // 'T'
            case 85: // 'U'
            case 86: // 'V'
            case 87: // 'W'
            case 88: // 'X'
            case 89: // 'Y'
            case 90: // 'Z'
            case 95: // '_'
            case 97: // 'a'
            case 98: // 'b'
            case 99: // 'c'
            case 100: // 'd'
            case 101: // 'e'
            case 102: // 'f'
            case 103: // 'g'
            case 104: // 'h'
            case 105: // 'i'
            case 106: // 'j'
            case 107: // 'k'
            case 108: // 'l'
            case 109: // 'm'
            case 110: // 'n'
            case 111: // 'o'
            case 112: // 'p'
            case 113: // 'q'
            case 114: // 'r'
            case 115: // 's'
            case 116: // 't'
            case 117: // 'u'
            case 118: // 'v'
            case 119: // 'w'
            case 120: // 'x'
            case 121: // 'y'
            case 122: // 'z'
            default:
                if((abyte0[i] & 0x80) == 128)
                    stringbuffer.append((new StringBuilder("%")).append(Integer.toHexString(abyte0[i] & 0xff)).toString());
                else
                    stringbuffer.append((char)abyte0[i]);
                break;
            }

        return stringbuffer.toString();
    }

    public static String normalizeXml(int i)
    {
        return normalizeXml(toString(i));
    }

    public static String normalizeXml(long i)
    {
        return normalizeXml(toString(i));
    }

    public static String normalizeXml(String s)
    {
        if(!isDefined(s))
        {
            return "";
        } else
        {
            String s1 = replace(s, "&", "&amp;");
            s1 = s1.replaceAll("&", "&amp;");
            s1 = s1.replaceAll("'", "&#039;");
            s1 = s1.replaceAll("\"", "&#34;");
            s1 = s1.replaceAll("<", "&lt;");
            s1 = s1.replaceAll(">", "&gt;");
            return s1;
        }
    }

    public static String abnormalizeXml(String s)
    {
        if(!isDefined(s))
        {
            return "";
        } else
        {
            String s1 = replace(s, "&amp;", "&");
            s1 = s1.replaceAll("&amp;", "&");
            s1 = s1.replaceAll("&#039;", "'");
            s1 = s1.replaceAll("&#34;", "\"");
            s1 = s1.replaceAll("&lt;", "<");
            s1 = s1.replaceAll("&gt;", ">");
            return s1;
        }
    }

    /**
     * file 업로드 시 file 필드 에서 입력받은 파일의 전체 경로 중
     * 파일명만 반환 하는 함수
     * @param expr
     * @return String fileName
     */

    public static String getfileName(String expr)
	{
		String[] str=StringUtil.tokenize(expr, "\\");
		String rtnFileName="";

		if(str.length > 0)
			rtnFileName=str[str.length-1];

		return rtnFileName;
	}

    /**
     * 디비 반환 값이 List<HashMap<String,String>> 타입일 경우 리스트의 내용을 디코드하여
     * 리스트를 반환
     * @param List<HashMap<String,String>> mapList
     * @return List<HashMap<String,String>>
     */
    public static List<HashMap<String,String>> getHashMapListByDecode( List<HashMap<String,String>> mapList)
    {

    	List<HashMap<String, String>> tempList=new ArrayList();

		for (Iterator iterator = mapList.iterator(); iterator.hasNext();)
		{
			HashMap<String, String> hashMap = (HashMap<String, String>) iterator.next();

			HashMap<String, String> newMap=new HashMap<String, String>();

			for(int i=0;i < hashMap.keySet().toArray().length;i++)
			{
				String keyName=hashMap.keySet().toArray()[i].toString();

				Object valueObject=hashMap.get(keyName);
				String keyValue= "";

				if(valueObject != null) {
					keyValue=decode(valueObject.toString());
				}
				newMap.put(keyName, keyValue);

			}

			tempList.add(newMap);
		}

		return tempList;
    }

//    /**
//     * 디비 반환 값이 List<HashMap<String,String>> 타입일 경우 리스트의 내용을 디코드하여
//     * 리스트를 반환
//     * @param List<HashMap<String,String>> mapList
//     * @return List<HashMap<String,String>>
//     * @throws ClassNotFoundException
//     * @throws NoSuchMethodException
//     * @throws NoSuchFieldException
//     * @throws SecurityException
//     * @throws InvocationTargetException
//     * @throws IllegalArgumentException
//     * @throws IllegalAccessException
//     * @throws InstantiationException
//     */
//    @SuppressWarnings("unchecked")
//	public static List<HashMap> getObjectListByDecode(List<?> mapList) throws ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException
//    {
//    	List<HashMap> tempList=new ArrayList();
//
//    	HashMap<String, String> map= new HashMap<String, String>();
//
//		for (Iterator iterator = mapList.iterator(); iterator.hasNext();) {
//			Object object = (Object) iterator.next();
//
//			String valueObject="";
//			String keyValue="";
//
//
////			for(int i=0;i<object.getClass().getSuperclass().getDeclaredFields().length;i++)
////			Log.debug("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ object.getClass().getDeclaredFields()[i].getName() : "
////			+ object.getClass().getSuperclass().getDeclaredFields()[i].getName());
////
////		}
//			for(int i=0;i < object.getClass().getSuperclass().getDeclaredFields().length;i++)
//			{
//				valueObject=object.getClass().getSuperclass().getDeclaredFields()[i].getName();
//
//				Method[] methods = object.getClass().getMethods();
//
//				for(int j=0; j<methods.length; j++)
//				{
//                     if(methods[j].getName().equals(object.getClass().getSuperclass().getMethods()[i].getName()))
//                     {
//                         try {
//                                 if (methods[j].getReturnType().getName().equals("void"))
//                                 {
//                                	 methods[j].invoke(object, null);
//
//                                 } else
//                                 {
//                                     Object aa=methods[j].invoke(object, null);
//                                     keyValue = decode(aa.toString());
//
//                                     map.put(valueObject.toString(), keyValue);
//                                 }
//
//                                 break;
//                         }
//                         catch(IllegalAccessException lae)
//                         {
//                        	 System.out.println("LAE : " + lae.getMessage());
//                         }
//                         catch(InvocationTargetException ite)
//                         {
//                        	 System.out.println("ITE : " + ite.getMessage());
//                         }
//                     }
//				}
//
//				//Object returnValue = object.getClass().getMethods()[i].invoke(StringUtil,null);
//
//				//object.getClass().getMethods()[i].invoke(object, args)
//				//Method meth = cls.getMethod(object.getClass().getMethods()[i].toString(), partypes);
//
//				//Hashtable tbl=new Hashtable<K, V>(map);
//
//
//				//ArrayList<Object> newObj = new ArrayList<Object>(Arrays.asList(object));
//
//
//
//				//HashMap<String, String> col= new HashMap<String, String>();
//
//				//col.put(valueObject.toString(), keyValue);
//
//				//map.put(valueObject.toString(), col);
//
//				//tempList.add(map);
//
//				tempList.set(i, map);
//			}
//		}
//
//		return tempList;
//    }

    /**
     * 디비 반환 값이 HashMap<String,String> 타입일 경우 맵의 값을 디코드하여 반환
     *
     * @param HashMap<String,String>
     * @return HashMap<String,String>
     */
    public static HashMap<String,String> getHashMapByDecode( HashMap<String,String> map)
    {
    	HashMap<String, String> tempMap=new HashMap<String, String>();

		for(int i=0;i < map.keySet().toArray().length;i++)
		{
			String keyName=map.keySet().toArray()[i].toString();

			Object valueObject=map.get(keyName);
			String keyValue= "";

			if(valueObject != null) {
				keyValue = decode(valueObject.toString());
			}
			tempMap.put(keyName, keyValue);
		}

		return tempMap;
    }


    /**
     * 디비 반환 값이 List<HashMap<String,String>> 타입일 경우 리스트의 내용을 디코드하여
     * 리스트를 반환
     * @param List<HashMap<String,String>> mapList
     * @return List<HashMap<String,String>>
     */
    public static List<HashMap<String,String>> getHashMapListByDecodeUTF8( List<HashMap<String,String>> mapList)
    {

    	List<HashMap<String, String>> tempList=new ArrayList();

		for (Iterator iterator = mapList.iterator(); iterator.hasNext();)
		{
			HashMap<String, String> hashMap = (HashMap<String, String>) iterator.next();

			HashMap<String, String> newMap=new HashMap<String, String>();

			for(int i=0;i < hashMap.keySet().toArray().length;i++)
			{
				String keyName=hashMap.keySet().toArray()[i].toString();

				Object valueObject=hashMap.get(keyName);
				String keyValue= "";

				if(valueObject != null) {
					keyValue=decodeUTF8(valueObject.toString());
				}
				newMap.put(keyName, keyValue);

			}

			tempList.add(newMap);
		}

		return tempList;
    }

    /**
     * 디비 반환 값이 HashMap<String,String> 타입일 경우 맵의 값을 디코드하여 반환
     *
     * @param HashMap<String,String>
     * @return HashMap<String,String>
     */
    public static HashMap<String,String> getHashMapByDecodeUTF8( HashMap<String,String> map)
    {
    	HashMap<String, String> tempMap=new HashMap<String, String>();

		for(int i=0;i < map.keySet().toArray().length;i++)
		{
			String keyName=map.keySet().toArray()[i].toString();

			Object valueObject=map.get(keyName);
			String keyValue= "";

			if(valueObject != null) {
				keyValue = decodeUTF8(valueObject.toString());
			}
			tempMap.put(keyName, keyValue);
		}

		return tempMap;
    }

    public static String getMaskingString(String value) throws Exception{
		StringBuffer sb = new StringBuffer();
		if(value != null && !value.equals("")){
			int size = value.length();
			sb.append(value.substring(0,1));
			for(int i=0; i < (size-2); i++){
				sb.append("*");
			}
			sb.append(value.substring((size-1),size));
		}else return "";
		return sb.toString();

	}

    /**
     * 디비 반환 값이 HashMap<String,String> 타입일 경우 맵의 값을 디코드하여 반환
     *
     * @param HashMap<String,String>
     * @return HashMap<String,String>
     */
    public static String getRandomString(int length) {
    	String dummyString="1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijlmnopqrstuvwxyz";
    	Random random = new Random();
    	// char 48=0 65=A 90=Z 97=a 122=z
    	StringBuilder tempBuilder=new StringBuilder(100);
    	int randomInt;
    	char tempChar;
    	for(int i=0 ; i < length ; i++ ) {
    		randomInt = random.nextInt(61);
    		tempChar = dummyString.charAt(randomInt);
    		tempBuilder.append(tempChar);
    	}
    	return tempBuilder.toString();
    }

	public static String getClobConvertToStr(Clob clob) {
	   int size;
	   String str = "";

	   try {
	      if(clob == null) {
	         size = 0;
	      } else {
	         size = (int)clob.length();
	      }

	      if(size != 0) {
	         str = clob.getSubString(1, size);
	      } else {
	         str = "";
	      }
	   } catch(Exception se) {
	      return "";
	   }

	   return str;
	}

	public static void main(String[] args) {

		//1. 폴더 읽기 - 파일 포함 (.sql)

		//2. 파일 읽기 (한줄 씩)

		//3. 해당 파일 검색되면 파일명 출력하고 다음 파일



	}
}
