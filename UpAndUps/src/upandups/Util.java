package upandups;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.DatatypeConverter;

public class Util {

	public static String convertToMD5(String source) {

		//ハッシュ生成前にバイト配列に置き換える際のCharset
		Charset charset = StandardCharsets.UTF_8;
		//ハッシュアルゴリズム
		String algorithm = "MD5";

		//ハッシュ生成処理
		try {
			byte[] bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
			String result = DatatypeConverter.printHexBinary(bytes);

			return result;

		}catch(NoSuchAlgorithmException e) {
			System.out.println(e);
			return null;
		}

	}

	// String型の日付をDate型に変換
	public static Date getDateBirthDate(String d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
        Date formatDate = sdf.parse(d);
        return formatDate;
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return null;
		}
    }

	//yyyy年MM月dd日でフォーマットした生年月日を返す
		public static String birth_date_format(String birth_date) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date formatBirthDate;
			try {
				formatBirthDate = sdf.parse(birth_date);
				String str = new SimpleDateFormat("MM月dd日").format(formatBirthDate);
				return str;
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
		}

}
