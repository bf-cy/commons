package lzy.commons.utils.time;

public class DateTimeRegularUtils {
	// ===================================时间和日期正则--------开始===========================================================//
	private final static String time_regular_prefix = "([01][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$";// 时间正则前缀
	private final static String date_regular_interval = "([-/.]?)";// 日期间隔字符串正则
	private final static String year = "(?!0000)[0-9]{4}";// 年份正则表前缀
	private final static String leap_year = "(?:[0-9]{2}(0[48]|[2468][048]|[13579][26])|(0[48]|[2468][048]|[13579][26])00)";// 闰年正则前缀，闰年规则：四年一闰年，百年不闰年
	private final static String month = "(?:0[1-9]|1[0-2])";// 月份正则前缀
	private final static String month_front_1_to_28_day = "(?:0[1-9]|1[0-9]|2[0-8])";// 所有月份的前1-28号正则前缀
	private final static String month_29_and_30_day = "(?:0[13-9]|1[0-2])" + date_regular_interval + "(29|30)";// 所有包含29和30号的月份日期正则前缀
	private final static String month_31_day = "(?:0[13578]|1[02])" + date_regular_interval + "31";// 所有包含29和30号的月份日期正则前缀
//		private final static String min_month_regular_prefix = "(0[469]|11)" + date_regular_interval + "(29|30)";// 小月包含29，30正则前缀（4，6，9，11）
//		private final static String max_month_regular_prefix = "(0[13578]|1[02])" + date_regular_interval + "(29|30|31))";// 大月包含29，30，31号正则前缀（1，3，5，7，8，10，12）
	private final static String leap_year_february_29_day = leap_year + date_regular_interval + "02"
			+ date_regular_interval + "29";// 闰年二月29号
	private final static String date_regular_prefix = "^(?:" + year + date_regular_interval + "(?:" + month
			+ date_regular_interval + month_front_1_to_28_day + "|" + month_29_and_30_day + "|" + month_31_day + ")"
			+ "|" + leap_year_february_29_day + ")";// 日期正则前缀

	public final static String date_regular = date_regular_prefix + "$";// 日期正则

	public final static String date_time_regular = date_regular_prefix + "\\s+" + time_regular_prefix + "$";// 日期时间正则

	public final static String time_regular = time_regular_prefix + "$";// 时间

	// ===================================时间和日期正则--------结束===========================================================//
}
