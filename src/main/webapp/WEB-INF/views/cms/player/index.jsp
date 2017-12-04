<%@ include file="../../common/taglib.jsp" %>
<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>${webTitle }-主播管理</title>
    <%@ include file="../../common/header.jsp" %>
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
                                        <div class="row">
                                            <div class="col-xs-3">
                                                <div class="form-group">
                                                    <label class="control-label col-xs-6 col-lg-5"
                                                           style="line-height: 15px">主播名称：</label>
                                                    <div class="col-xs-6 col-lg-7">
                                                        <input type="text" id="playerNameSearch"
                                                               class="col-xs-12 col-sm-12 col-lg-10"
                                                               value="" title=""/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xs-3">
                                                <div class="form-group">
                                                    <label class="control-label col-xs-6 col-lg-5"
                                                           style="line-height: 15px">频道名称：</label>
                                                    <div class="col-xs-6 col-lg-7">
                                                        <input type="text" id="channelNameSearch"
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
                                                    <a type="button" class="btn btn-success btn-sm"
                                                       href="#modal-edit" data-toggle="modal"
                                                       data-backdrop="static" onclick="addTeacher()"
                                                       id="btn-add">
                                                        <i class="ace-icon fa fa-plus"></i> 新增主播
                                                    </a>

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
                                <table id="lwTeacher" style="width: 100%"
                                       class="table table-striped table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th style="background-color: #E5E5E5">主播姓名</th>
                                        <th style="background-color: #E5E5E5">频道名称</th>
                                        <th style="background-color: #E5E5E5">群组名称</th>
                                        <th style="background-color: #E5E5E5">有效时间</th>
                                        <th style="background-color: #E5E5E5">主播状态</th>
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
<script src="${staticServer }/assets/components/jquery-ui/jquery-ui.js"></script>


<script>


    function addTeacher() {
        window.location.href = "${dynamicServer}/cms/player/toAdd";
    }

    function updateTeacher(id) {
        window.location.href = "${dynamicServer}/cms/player/toUpdate?id=" + id;
    }


</script>
<script>


    $(function () {

        /*把要初始化的table的对象赋值*/
        var $table_id = $("#lwTeacher");

        /*自定义查询参数*/
        var userParam = {
            getQueryCondition: function (data) {
                var param = {};
                param.playerName = $("#playerNameSearch").val();
                param.channelName = $("#channelNameSearchSearch").val();
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
            width: "auto",
            Paginate: true, //翻页功能
            sortable: false,
            processing: true,
            serverSide: true,
            ajax: function (data, callback) {//ajax配置为function,手动调用异步查询
                $.ajax({
                    type: "GET",
                    url: '${dynamicServer}/cms/player/getList',//请求数据的参数
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

//                {
//                    data: "icon",
//                    render: function (data) {
//                        var img = '<img src="http://www.932edu.net/lwgk/upload' + data + '"  alt="图像" style="height: 150px;width: 150px" />';
//                        return img || "";
//                    }
//                },

                {
                    data: "playerName",
                    render: function (data) {
                        return data || "无";
                    }
                },

                {
                    data: "channelName",
                    render: function (data) {
                        return data || "无";
                    }
                },
                {
                    data: "groupName",
                    render: function (data) {
                        return data || "无";
                    }
                },
                {
                    data: "expireDate",
                    render: function (data) {
                        return data != null ? dateFormat(data) : "";
                    }
                },
                {
                    data: "status",
                    render: function (data) {
                        var state = "";
                        switch (data) {
                            case 0:
                                state = "正常";
                                break;
                            case 1:
                                state = "封禁";
                                break;
                            default :
                                state = "正常";
                                break;
                        }
                        return state;
                    }
                },
                {
                    data: "id",
                    width: "155px",
                    render: function (data, type, row) {
                        var button = '<a class="btn  btn-sm btn-info" href="#modal-edit" data-toggle="modal"  data-backdrop="static" ' +
                            'onclick="updateTeacher(\'' + data + '\')">' +
                            '<i class="ace-icon fa fa-pencil-square-o "></i>修改</a>';
                        button += '&nbsp;&nbsp;' +
                            '<a class="btn btn-sm btn-danger" onclick="delUser(\'' + data + '\')">' +
                            '<i class="ace-icon fa fa-pencil-square-o "></i>删除</a>';
                        return button
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
        /*条件查询*/
        $("#btn-search").on("click", function () {
            table.draw();
        });


        /*添加手机号验证方法*/
        jQuery.validator.addMethod("phone", function (value, element) {
            var length = value.length;
            var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
            return this.optional(element) || (length == 11 && mobile.test(value));
        }, "请正确填写您的手机号码");

        /*validate验证*/
        $("#lwTeacherForm").validate({
            errorElement: "label",
            errorClass: "validError",
            errorPlacement: function (error, element) {
                error.appendTo($("#" + element.attr('id') + "Tip"));
            },
            rules: {

                phone: {
                    required: true,
                    maxlength: 255
                }

            },
            submitHandler: function (form) {
                $("#lwTeacherForm").ajaxSubmit({
                    success: function () {
                        $('#modal-edit').modal('hide');
                        table.draw();
                    }
                });
            }
        });
    })
    ;

    /*新增时清空表单数据*/
    function flushForm() {
        $("#lwTeacherForm").find("input").each(function () {
            var id = $(this).attr("id");
            $("#" + id).val("");
        });
        $.ajax({
            type: "get",
            url: "${dynamicServer}/cms/player/findAll",
            contentType: "application/json",
            success: function (data) {

            }
        })
    }
    /*修改时需要回显数据*/
    function updateUser(id) {
        flushForm();
        $.ajax({
            type: "GET",
            url: "${dynamicServer}/cms/player/findOne",
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
    function delUser(id) {
        bootbox.confirm("<a style='font-size: 17px;color: red'>确定要删除该主播信息？</a>", function (result) {
            if (result) {
                $.ajax({
                    type: "GET",
                    url: "${dynamicServer}/cms/player/delete",
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


</script>
</body>
</html>


