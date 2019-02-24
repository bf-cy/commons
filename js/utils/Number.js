/**********************************************************************************
 * @Desc 
 * @author lzy
 * @date 2018年12月13日 下午4:12:08
 **********************************************************************************/
(function(window,undefined){
	var rootNumber,
	    Number=function(selector,context){
	    return Number.fn.init(selector,context,rootNumber);
	};
	
	Number.fn=Number.prototype={
	    constructor:Number,
	    init:function(selector,context,rootNumber){
	        //...
	    }
	};

	/**********************************************************************************
	 * @Desc 判断是否为整数
	 * 注意：空字符串、字符串类型数字、布尔true、空数组对1求余，结果都是true（因为他们都是对象，），所以要先判断对象是否为数字
	 * @author lzy
	 * @date 2018年12月13日 下午4:12:08
	 **********************************************************************************/
	Number.isInteger = function(obj){
		return typeof obj === 'number' && obj%1 === 0;      //是整数，则返回true，否则返回false
	}
	Number.fn.init.prototype=Number.prototype;
	rootNumber=Number(document);
	window.Number=window.$N=Number;
})(window);