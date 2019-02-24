/**********************************************************************************
 * @Desc 
 * @author lzy
 * @date 2018年12月20日 下午1:40:11
 **********************************************************************************/
var img = new Object();
function isHasImg(pathImg) {
	var ImgObj = new Image();
	ImgObj.src = pathImg;
	if (ImgObj.fileSize > 0 || (ImgObj.width > 0 && ImgObj.height > 0)) {
		return true;
	} else {
		return false;
	}
}

function reSetImgUrl(imgObj, imgSrc, maxErrorNum) {
	if (maxErrorNum > 0) {
		imgObj.onerror = function() {
			reSetImgUrl(imgObj, imgSrc, maxErrorNum - 1);
		};
		setTimeout(function() {
			imgObj.src = imgSrc;
		}, 500);
	} else {
		imgObj.onerror = null;
		imgObj.src = "<%=basePath%>images/noImg.png";
	}

}