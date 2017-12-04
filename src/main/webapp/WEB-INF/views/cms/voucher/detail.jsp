<%--
  Created by IntelliJ IDEA.
  User: 1553280431@qq.com
  Date: 2017/5/25
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>

<%@ include file="../../common/taglib.jsp" %>
<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>${webTitle }-代金券使用详情</title>
    <%@ include file="../../common/header.jsp" %>
    <link rel="stylesheet" href="${staticServer}/assets/bootstrap-datetimepicker/bootstrap-datetimepicker.min.css"/>
    <link rel="stylesheet"
          href="${staticServer}/assets/components/bootstrap-multiselect/dist/css/bootstrap-multiselect.css"/>
    <link rel="stylesheet" href="${staticServer}/assets/select2/select2.css"/>
</head>

<body class="no-skin">
<%@ include file="../../common/top.jsp" %>
<div class="main-container" id="main-container">
    <%@ include file="../../common/menu.jsp" %>
    <div class="main-content">
        <div class="main-content-inner">
            <!-- #section:basics/content.breadcrumbs -->
            <div class="breadcrumbs  breadcrumbs-fixed" id="breadcrumbs">
            </div>
            <!-- /section:basics/content.breadcrumbs -->
            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <div class="widget-box" id="widget-box-search">
                            <div class="widget-header">
                                <div class="widget-toolbar">
                                    <a href="#" data-action="collapse">
                                        <i class="ace-icon fa fa-chevron-up"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="widget-body">
                                <div class="widget-main no-padding">
                                    <form:form action="/" method="post"
                                               cssClass="form-horizontal"
                                               cssStyle="padding-top: 10px;">
                                        <input type="hidden" id="voucherId" name="voucherId" value="${voucherId}">
                                        <div class="row">
                                            <div class="col-xs-3">
                                                <div class="form-group">
                                                    <label class="control-label col-xs-6 col-lg-5">代金券编号：</label>
                                                    <div class="col-xs-6 col-lg-7">
                                                        <input type="text" id="CodeSearch"
                                                               class="col-xs-12 col-sm-12 col-lg-10"
                                                               value="" title=""/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xs-3">
                                                <div class="form-group">
                                                    <label class="control-label col-xs-6 col-lg-5">使用状态：</label>
                                                    <div class="col-xs-6 col-lg-7">
                                                        <select name="StateSearch" id="StateSearch" class="col-sm-12 col-lg-7" title="">
                                                            <option value="" selected="selected">请选择</option>
                                                            <option value="0">未使用</option>
                                                            <option value="1">已使用</option>
                                                            <option value="2">已作废</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xs-3">
                                                <div class="form-group">
                                                    <label class="control-label col-xs-6 col-lg-5">用户手机号：</label>
                                                    <div class="col-xs-6 col-lg-7">
                                                        <input type="text" id="TelephoneSearch"
                                                               class="col-xs-12 col-sm-12 col-lg-10"
                                                               value="" title=""/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xs-3">
                                                <div class="form-group">
                                                    <button type="button" class="btn btn-primary btn-sm"
                                                            id="btn-search">
                                                        <i class="ace-icon fa fa-search"></i> 查询
                                                    </button>
                                                    &nbsp;&nbsp;
                                                        <%--<a href="#modal-import" class="btn btn-warning btn-sm"
                                                           data-toggle="modal">
                                                            <i class="ace-icon fa fa-file-excel-o"></i>导入</a>--%>
                                                </div>
                                            </div>
                                        </div>
                                    </form:form>
                                </div>
                            </div>
                        </div>
                        <div class="hr hr-18 dotted hr-double"></div>
                        <div class="row">
                            <div class="col-xs-12">
                                <table id="lwInvitation" class="table table-striped table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>
                                            <input type="checkbox" class="checkall" />
                                        </th>
                                        <th style="background-color: #E5E5E5">代金券编码</th>
                                        <th style="background-color: #E5E5E5">用户手机号</th>
                                        <th style="background-color: #E5E5E5">状态</th>

                                        <th style="background-color: #E5E5E5">使用时间</th>
                                        <th style="background-color: #E5E5E5">操作</th>
                                    </tr>
                                    </thead>
                                </table>
                            </div>
                            <!-- /.span -->
                        </div>
                    </div>
                    <!-- /.span -->
                </div>
            </div>
            <!-- /.main-content -->
        </div>
        <!-- /.main-container -->
    </div>
</div>


<%@ include file="../../common/js.jsp" %>
<script src="${staticServer }/assets/js/jquery.form.js"></script>
<script src="${staticServer }/assets/js/jquery.validation/jquery.validate.js"></script>
<script src="${staticServer }/assets/js/jquery.validation/jquery.validate.zh-CN.js"></script>

<script>
    window.UEDITOR_HOME_URL = '${staticServer}/assets/ueditor1.4.3/';
</script>
<script src="${staticServer}/assets/ueditor1.4.3/ueditor.config.js"></script>
<script src="${staticServer}/assets/ueditor1.4.3/ueditor.all.min.js"></script>
<script src="${staticServer}/assets/ueditor1.4.3/lang/zh-cn/zh-cn.js"></script>
<script src="${staticServer}/assets/components/fuelux/js/spinbox.js"></script>
<script src="${staticServer}/assets/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
<script src="${staticServer}/assets/select2/select-topic-tags.js"></script>
<script src="${staticServer}/assets/select2/select2.full.js"></script>
<script>
    $(function () {
        /*把要初始化的table的对象赋值*/
        var $table_id = $("#lwInvitation");

        /*自定义查询参数*/
        var userParam = {
            getQueryCondition: function (data) {
                var param = {};
                param.voucherId =$("#voucherId").val()
                param.code = $("#CodeSearch").val();
                param.telephone = $("#TelephoneSearch").val();
                param.state = $("#StateSearch").val();
                param.page = data.start;
                param.length = data.length;
                return param;
            }
        };
        //object可以如下初始化表格
        window.table = $table_id.DataTable({
            dom: '<".table_area_top" B and >t<".table_area_bottom" pi>',
            Filter: false, //列筛序功能
            searching: false,//本地搜索
            ordering: false, //排序功能
            Info: true,//页脚信息
            lengthMenu: [15],
            scrollY: "auto",
            Paginate: true, //翻页功能
            sortable: false,
            processing: true,
            serverSide: true,
            ajax: function (data, callback) {//ajax配置为function,手动调用异步查询
                $.ajax({
                    type: "GET",
                    url: '${dynamicServer}/cms/voucherLog/getList.do',//请求数据的参数
                    data: userParam.getQueryCondition(data),
                    cache: false,  //禁用缓存
                    dataType: "json",
                    success: function (result) {
                        callback(result);
                    }
                });
            },
            //使用对象数组，一定要配置columns，告诉 DataTables 每列对应的属性
            //data 这里是固定不变的，id，name，age，sex等为你数据里对应的属性
            columns: [
                {
                    sClass: "text-center",
                    data: "id",
                    render: function (data, type, full, meta) {
                        return '<input type="checkbox"  class="checkchild"  value="' + data + '" />';
                    },
                    bSortable: false
                },
                {
                    data: "code",
                    render: function (data) {
                        return data || "";
                    }
                },
                {
                    data: "telephone",
                    render: function (data) {
                        return data || "";
                    }
                },
                {
                    data: "state",
                    render: function (data) {
                        var state = "";
                        switch (data) {
                            case 0:
                                state = "未使用";
                                break;
                            case 1:
                                state = "已使用";
                                break;
                            case 2:
                                state = "已作废";
                                break;
                            default :
                                state = "未使用";
                                break;
                        }
                        return state;
                    }
                },
                {
                    data: "usingDate",
                    render: function (data) {
                        return data!=null? dateFormat(data) : "" ;
//                        return dateFormat(data) || "";
                    }
                },
                {
                    data: "id",
                    width: "175px",
                    render: function (data, type, row) {
                        var button = '';
                        if (row.state == 0 ||row.state==null) {
                            button += '&nbsp;&nbsp;<a class="btn btn-sm btn-warning" onclick="cancelVoucher(\'' + data  + '\', 2)">' +
                                '<i class="ace-icon fa fa-pencil-square-o "></i>作废</a>';
                        } else if (row.state == 2) {
                            button += '&nbsp;&nbsp;<a class="btn btn-sm btn-success" onclick="cancelVoucher(\'' + data  + '\', 0 )">' +
                                '<i class="ace-icon fa fa-pencil-square-o "></i>恢复</a>';
                        }
                        if (row.state == 1|| row.state == 2) {
                            button += '&nbsp;&nbsp;' +
                                '<a class="btn btn-sm btn-danger" onclick="delInvitation(\'' + data + '\')">' +
                                '<i class="ace-icon fa fa-pencil-square-o "></i>删除</a>';
                        }
                        return button;

                    }
                }


            ],
            language: { //国际语言转化
                aria: {
                    sortAscending: " - click/return to sort ascending",
                    sortDescending: " - click/return to sort descending"
                },
                lengthMenu: "显示 _MENU_ 记录",
                zeroRecords: "对不起，查询不到任何相关数据",
                emptyTable: "未有相关数据",
                loadingRecords: "正在加载数据-请等待...",
                info: "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录。",
                infoEmpty: "当前显示0到0条，共0条记录",
                infoFiltered: "（数据库中共为 _MAX_ 条记录）",
                processing: " 正在加载数据...",
                //多语言配置文件，可将oLanguage的设置放在一个txt文件中，例：Javascript/datatable/dtCH.txt
                paginate: {
                    first: "首页",
                    previous: " 上一页 ",
                    next: " 下一页 ",
                    last: " 尾页 "
                }
            }
        });

        /*全选*/
        $(".checkall").click(function () {
            var check = $(this).prop("checked");
            $(".checkchild").prop("checked", check);
        });
        $(".coursecheckall").click(function () {
            var check = $(this).prop("checked");
            $(".coursecheckchild").prop("checked", check);
        });

        /*日期*/
        var date = dateFormatHour(new Date());
        $(".datetimepicker").val(date);

        $.fn.datetimepicker.dates['zh'] = {
            days: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"],
            daysShort: ["日", "一", "二", "三", "四", "五", "六", "日"],
            daysMin: ["日", "一", "二", "三", "四", "五", "六", "日"],
            months: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
            monthsShort: ["一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"],
            meridiem: ["上午", "下午"],
            today: "今天"
        };

        $('#startDate').datetimepicker({
            language: 'zh',
            autoclose: true,
            todayBtn: "linked"
        });
        $('#endDate').datetimepicker({
            language: 'zh',
            autoclose: true,
            todayBtn: "linked"
        });
        $('#beginDate').datetimepicker({
            language: 'zh',
            autoclose: true,
            todayBtn: "linked"
        });
        $('#stopDate').datetimepicker({
            language: 'zh',
            autoclose: true,
            todayBtn: "linked"
        });
        $('#applyBeginDate').datetimepicker({
            language: 'zh',
            autoclose: true,
            todayBtn: "linked"
        });
        $('#applyStopDate').datetimepicker({
            language: 'zh',
            autoclose: true,
            todayBtn: "linked"
        });

        /*限时申领开始和结束时间隐藏*/
        $("#applyBeginDate").parent().parent().hide();
        $("#applyStopDate").parent().parent().hide();

        /*限时申领*/
        $("#type").on("change", function () {
            if($('#type').val()==1){
                $("#applyBeginDate").parent().parent().show();
                $("#applyStopDate").parent().parent().show();
            }else{
                $("#applyBeginDate").parent().parent().hide();
                $("#applyStopDate").parent().parent().hide();
            }
        });

        /*条件查询*/
        $("#btn-search").on("click", function () {
            table.draw();
        });
        /*validate验证*/
        $("#lwInvitationForm").validate({
            errorElement: "label",
            errorClass: "validError",
            errorPlacement: function (error, element) {
                error.appendTo($("#" + element.attr('id') + "Tip"));
            },
            rules: {
                userNum: {
                    required: true,
                    maxlength: 255
                }
            },
            submitHandler: function (form) {
                $("#lwInvitationForm").ajaxSubmit({
                    success: function () {
                        $('#modal-edit').modal('hide');
                        table.draw();
                    }
                });
            }
        });

        /*代金券发送 validate验证*/
        $("#lwVoucherForm").validate({
            errorElement: "label",
            errorClass: "validError",
            errorPlacement: function (error, element) {
                error.appendTo($("#" + element.attr('id') + "Tip"));
            },
            rules: {
                telephone: {
                    required: true
                }
            },
            submitHandler: function (form) {
                $("#lwVoucherForm").ajaxSubmit({
                    success: function () {
                        $('#modal-dispatcher').modal('hide');
                        table.draw();
                    }
                });
            }
        });
    });

    /*新增时清空表单数据*/
    function flushForm() {
        $("#lwInvitationForm").find("input").each(function () {
            var id = $(this).attr("id");
            $("#" + id).val("");
        });
        $.ajax({
            type: "get",
            url: "${dynamicServer}/cms/voucherLog/findAll.do",
            contentType: "application/json",
            success: function (data) {

            }
        })
    }

    /*代金券发放*/
    function dispatcher() {
//        $("#lwInvitationForm").find("input").each(function () {
//            var id = $(this).attr("id");
//            $("#" + id).val("");
//        });
        $.ajax({
            type: "get",
            url: "${dynamicServer}/cms/voucher/findAllByState.do",
            data: {
                "state": 1
            },
            contentType: "application/json",
            success: function (data) {
                var voucherId = $("#voucherId");
                voucherId.empty();
                var str = '';
//                var data = eval("("+text+")");
                for(var o in data) {
                    str += '<option value="'+data[o].id+'">'+data[o].name+'</option>';
                }
                voucherId.append(str);
            }
        })
    }

    /*作废/恢复*/
    function cancelVoucher(id,state) {
        var altStr;
        if(state!=2){
            altStr=("确定要恢复该活动？");
        }else{
            altStr=("确定要作废该活动？");
        }
        bootbox.confirm("<a style='font-size: 17px;color: red'>"+altStr+"</a>", function (result) {
            if (result) {
                $.ajax({
                    type: "GET",
                    url: "${dynamicServer}/cms/voucherLog/cancelVoucher.do",
                    data: {
                        "id": id,
                        "state":state
                    },
                    contentType: 'application/json',
                    success: function () {
                        table.draw();
                    }
                });
            }
        });
    }

    /*修改时需要回显数据*/
    function updateInvitation(id) {
        flushForm();
        $.ajax({
            type: "GET",
            url: "${dynamicServer}/cms/voucherLog/findOne.do",
            data: {
                "id": id
            },
            contentType: 'application/json',
            success: function (data) {
                for (var key in data) {
                    $("#" + key).val(data[key]);
                }

            }
        });
    }

    /*删除*/
    function delInvitation(id) {
        bootbox.confirm("<a style='font-size: 17px;color: red'>确定要删除该注冊信息？</a>", function (result) {
            if (result) {
                $.ajax({
                    type: "GET",
                    url: "${dynamicServer}/cms/voucherLog/delete.do",
                    data: {
                        "id": id
                    },
                    contentType: 'application/json',
                    success: function () {
                        table.draw();
                    }
                });
            }
        });
    }
    function stateOption(data) {
        var x = "";
        <%--//0正常 1删除  2 禁用 3 审核中--%>
        console.log(data);
        switch (data) {
            case 0:
                x = "正常";
                break;
            case 1:
                x = "删除";
                break;
            case 2:
                x = "禁用";
                break;
            case 3:
                x = "审核中";
                break;
            case 4 :
                x = "审核通过";
                break;
        }
        return x;
    }

    function isApp(data) {
        var x = "";
//        1 是0 否
        switch (data) {
            case 0:
                x = "否";
                break;
            case 1:
                x = "是";
                break;

        }
        return x;

    }

    //活动图片
    $('#icon-input').ace_file_input({
        style: 'well',
        btn_choose: '点击选择',
        btn_change: null,
        no_icon: 'ace-icon fa fa-picture-o',
        droppable: false,
        allowExt: ["jpeg", "jpg", "png", "gif", "bmp"],
        allowMime: ["image/jpg", "image/jpeg", "image/png", "image/gif", "image/bmp"],
        thumbnail: 'large',
        maxSize: 1024000,
        before_remove: function () {
            return true;
        }
    }).on('change', function () {
        var $icon_input = $('#icon-input');
        if ($icon_input.val() == '') {
            $icon_input.ace_file_input('reset_input');
        }
    }).on('file.error.ace', function (ev, info) {
        if (info.error_count['ext'] || info.error_count['mime'])
            $.notify({message: "请选择图片!", z_index: 1051});
        if (info.error_count['size'])
            $.notify({message: "图片大小不超过1M!!", z_index: 1051});
    });
    var $icon_form = $("#icon-form");
    $icon_form.on('submit', function () {
        var imgcheck = $("#icon-input").val();
        if (imgcheck === '') {
            return false;
        }
        $icon_form.ajaxSubmit({
            type: 'post', // 提交方式 get/post
            url: $icon_form.attr('action'),
            dataType: 'json',
            success: function (result) {
                if (result && result.success) {
                    var img_path = result.createFilePath;
                    $("#closeicon-modal").click();
                    $("[name=actPhoto]").val(img_path);
                    var img_url = '${imageServer}' + img_path;

                    var $icon_img = $("#icon-img");
                    if ($icon_img.attr("src") != '') {
                        $.ajax({
                            url: '${uploadServer}/common/delFile',
                            data: {
                                path: $icon_img.attr("data-path")
                            },
                            type: 'post',
                            success: function (result) {
                                if (result.success) {
                                    $icon_img.attr("src", img_url);
                                    $icon_img.attr("data-path", img_path);
                                    $("#imageUl").removeClass("hidden");
                                } else {
                                    $.notify({message: "文件路径错误!", z_index: 15111});
                                }
                            }
                        })
                    } else {
                        $icon_img.attr("src", img_url);
                        $icon_img.attr("data-path", img_path);
                        $("#imageUl").removeClass("hidden");
                        $('#iconTip').html('');
                    }
                    return;
                }

                alert((result && result.message) || '上传失败');
            }
        });
        return false;
    });
    $("#imageUl").on('click', '.delPic', function () {
        var that = $(this);
        var path = that.closest("li").find("img").attr("data-path");
        $.ajax({
            url: '${uploadServer}/common/delFile.do',
            data: {
                path: path
            },
            type: 'GET',
            success: function (result) {
                if (result.success) {
                    $("#iconTip").html('');
                    $("#imageUl").addClass("hidden");
                    $("[name=actPhoto]").val('');
                    $("#icon-img").attr("src", "");
                } else {
                    $.notify({message: "文件路径错误!", z_index: 15111});
                }
            }
        })
    });

    //操作分享图片
    $('#shareUrl-input').ace_file_input({
        style: 'well',
        btn_choose: '点击选择',
        btn_change: null,
        no_icon: 'ace-icon fa fa-picture-o',
        droppable: false,
        allowExt: ["jpeg", "jpg", "png", "gif", "bmp"],
        allowMime: ["image/jpg", "image/jpeg", "image/png", "image/gif", "image/bmp"],
        thumbnail: 'large',
        maxSize: 1024000,
        before_remove: function () {
            return true;
        }
    }).on('change', function () {
        var $shareUrl_input = $('#shareUrl-input');
        if ($shareUrl_input.val() == '') {
            $shareUrl_input.ace_file_input('reset_input');
        }
    }).on('file.error.ace', function (ev, info) {
        if (info.error_count['ext'] || info.error_count['mime'])
            $.notify({message: "请选择图片!", z_index: 1051});
        if (info.error_count['size'])
            $.notify({message: "图片大小不超过1M!!", z_index: 1051});
    });
    var $shareUrl_form = $("#shareUrl-form");
    $shareUrl_form.on('submit', function () {
        var shareUrlcheck = $("#shareUrl-input").val();
        if (shareUrlcheck === '') {
            return false;
        }
        $shareUrl_form.ajaxSubmit({
            type: 'post', // 提交方式 get/post
            url: $shareUrl_form.attr('action'),
            dataType: 'json',
            success: function (result) {
                if (result && result.success) {
                    var img_path = result.createFilePath;
                    $("#closeShareUrl-modal").click();
                    $("[name=sharePhoto]").val(img_path);
                    var img_url = '${imageServer}' + img_path;

                    var $shareUrl_img = $("#shareUrl-img");
                    if ($shareUrl_img.attr("src") != '') {
                        $.ajax({
                            url: '${uploadServer}/common/delFile',
                            data: {
                                path: $shareUrl_img.attr("data-path")
                            },
                            type: 'post',
                            success: function (result) {
                                if (result.success) {
                                    $shareUrl_img.attr("src", img_url);
                                    $shareUrl_img.attr("data-path", img_path);
                                    $("#shareUrlUl").removeClass("hidden");
                                } else {
                                    $.notify({message: "文件路径错误!", z_index: 15111});
                                }
                            }
                        })
                    } else {
                        $shareUrl_img.attr("src", img_url);
                        $shareUrl_img.attr("data-path", img_path);
                        $("#shareUrlUl").removeClass("hidden");
                    }
                    return;
                }

                alert((result && result.message) || '上传失败');
            }
        });
        return false;
    });
    $("#shareUrlUl").on('click', '.delPic', function () {
        var that = $(this);
        var path = that.closest("li").find("img").attr("data-path");
        $.ajax({
            url: '${uploadServer}/common/delFile.do',
            data: {
                path: path
            },
            type: 'GET',
            success: function (result) {
                if (result.success) {
                    $("#shareUrlUl").addClass("hidden");
                    $("[name=sharePhoto]").val('');
                    $("#shareUrl-img").attr("src", "");
                } else {
                    $.notify({message: "文件路径错误!", z_index: 15111});
                }
            }
        })
    });
</script>
</body>
</html>


