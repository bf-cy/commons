/*****************************************************************************************************************************************************
 * 
 * @author lzy 2019年8月5日 下午1:23:00
 *****************************************************************************************************************************************************/
package lzy.commons.emuns;

import lzy.commons.utils.StringUtils;

/*****************************************************************************************************************************************************
 * Desc: 响应状态枚举
 * @author lzy 2019年8月5日 下午1:23:00
 *****************************************************************************************************************************************************/
public enum ResponseStatus {
	

    SUCCESS(1000,"OK"),/** 添加成功 */
	FAIL(1001,"失败"),/** 失败 */
	EXCEPTION(1002,"异常"),/** 异常 */
	OBJECT_NULL(1003,"对象为空"),/** 对象为空 */
	ENTITY_NULL(1004,"实体对象为空"),/** 实体对象为空 */
	LIST_NULL(1005,"集合为空"),/** 集合为空 */
	MAP_NULL(1006,"map为空"),/** map为空 */
	NULL(1010,"空"),/** 空 */
    ADD_SUCCESS(1110,"添加成功"),/** 添加成功 */
    ADD_FAIL(1111,"添加失败"),/** 添加失败 */
    ADD_EXCEPTION(1112,"添加异常"),/** 添加异常 */
	DELETE_SUCCESS(1120,"删除成功"),/** 删除成功 */
	DELETE_FAIL(1121,"删除失败"),/** 删除失败 */
    DELETE_EXCEPTION(1122,"删除异常"),/** 添加异常 */
	UPDATE_SUCCESS(1130,"修改成功"),/** 修改成功 */
	UPDATE_FAIL(1131,"修改失败"),/** 修改失败 */
    UPDATE_EXCEPTION(1132,"修改异常"),/** 添加异常 */
	QUERY_SUCCESS(1140,"查询成功"),/** 查询成功*/
	QUERY_FAIL(1141,"查询失败"),/** 查询失败*/
	QUERY_EXCEPTION(1142,"查询异常"),/** 添加异常 */
	SEND_SUCCESS(1150,"发送发成功"),/** 发送成功 */
	SEND_FAIL(1151,"发送失败"),/** 发送失败 */
	SEND_EXCEPTION(1152,"发送异常");/** 添加异常 */

	/*****************************************************************************************************************************************************
	 * Desc: 状态码
	 * @author lzy @dateTime 2019年8月5日 下午1:40:48
	 *****************************************************************************************************************************************************/
	private int code;

	/*****************************************************************************************************************************************************
	 *  Desc: 状态码对应消息
	 * @author lzy @dateTime 2019年8月5日 下午1:41:06
	 *****************************************************************************************************************************************************/
	private String message;

	/*****************************************************************************************************************************************************
	 * Desc: 获取状态码
	 * @return 返回状态码
	 * @author lzy 2019年8月5日 下午1:41:25
	 *****************************************************************************************************************************************************/
	public int getCode() {
		return code;
	}

	/*****************************************************************************************************************************************************
	 * Desc: 设置状态码
	 * @param code 状态码
	 * @author lzy 2019年8月5日 下午1:41:48
	 *****************************************************************************************************************************************************/
	public void setCode(int code) {
		this.code = code;
	}

	/*****************************************************************************************************************************************************
	 * Desc: 设置状态码对应消息
	 * @return 状态码对应消息
	 * @author lzy 2019年8月5日 下午1:42:10
	 *****************************************************************************************************************************************************/
	public String getMessage() {
		return message;
	}

	/*****************************************************************************************************************************************************
	 * Desc: 设置状态码对应消息
	 * @param message 状态码对应消息
	 * @author lzy 2019年8月5日 下午1:42:29
	 *****************************************************************************************************************************************************/
	public void setMessage(String message) {
		this.message = message;
	}
	
	/*****************************************************************************************************************************************************
	 * Desc: 枚举构造函数
	 * @param code 状态吗
	 * @param message 状态对应消息
	 * @author lzy 2019年8月5日 下午1:39:57
	 *****************************************************************************************************************************************************/
	private ResponseStatus(int code, String message) {
		this.code = code;
		this.message = message;
	}
	

	/*****************************************************************************************************************************************************
	 * Desc: 根据状态码（code）获取状态信息（code值最好是从状态信息中获取，否则可能查询为空）
	 * @param code 状态码
	 * @return 状态信息存在返回状态信息，如果状态信息不存在返回空
	 * @author lzy 2019年8月5日 下午1:34:03
	 *****************************************************************************************************************************************************/
	public ResponseStatus getCode(int code) {
		for (ResponseStatus status : values()) {
			if (status.getCode()==code) {
				return status;
			}
		}
		return null;
	}

	/*****************************************************************************************************************************************************
	 * Desc: 根据状态消息（msg）获取状态信息 （msg值最好是从状态信息中获取，否则可能查询为空）
	 * @param message 消息内容
	 * @return 状态信息存在返回状态信息，如果状态信息不存在返回空
	 * @author lzy 2019年8月5日 下午1:34:03
	 *****************************************************************************************************************************************************/
	public ResponseStatus getMsg(String message) {
		if(StringUtils.isBlank(message)) {
			return null;
		}
		for (ResponseStatus status : values()) {
			if (status.getMessage().equals(message)) {
				return status;
			}
		}
		return null;
	}

}
