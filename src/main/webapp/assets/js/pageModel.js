/**
 * Created by 高宇飞 on 2016/9/2.
 */
 var isvaild = 0;
 var maxCount = parseInt($("#inputcount").attr("data-maxpage"));
 var errorMsg = "请输入1-" + maxCount +"之间的页数";
 $("#inputcount").on("change",function(){
	    if(isNaN($(this).val())){
	    	reset();
	    	$("#inputcount").focus();
			return false;
	    }
	 	if($(this).val() > maxCount  || $(this).val() <0){
			return false;
	 	}
	 	$(this).attr("title","");
	 	isvaild =1;
 });
function pageHref() {
    var url = $("#inputcount").attr("data-url");
	if(isvaild == 1){
	    window.location.href = url + $("#inputcount").val();
	}else{
		$("#inputcount").tooltip({
	 					title : errorMsg,
						show: null,
						position: {
							my: "left top",
							at: "left bottom"
						},
						open: function( event, ui ) {
							ui.tooltip.animate({ top: ui.tooltip.position().top + 10 }, "fast" );
						}
		});
		$("#inputcount").focus();
	}
}
function reset() {
    $("#inputcount").val("");
}