<%@ page import="com.connxun.util.session.UserSession" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="common/taglib.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>家政频道管理系统</title>
    <%@ include file="common/header.jsp" %>
    <link rel="stylesheet" href="${staticServer }/assets/components/jquery-ui/jquery-ui.css?version=${versionNo}"/>
    <link rel="stylesheet" href="${staticServer }/assets/highcharts/css/highcharts.css?version=${versionNo}"/>
</head>

<body class="no-skin">
<%@ include file="common/top.jsp" %>
<div class="main-container ace-save-state" id="main-container">
    <script type="text/javascript">
        try {
            ace.settings.check('main-container', 'fixed')
            ace.settings.loadState('main-container')
        } catch (e) {
        }


    </script>
    <%@ include file="common/menu.jsp" %>
    <div class="main-content">
        <div class="main-content-inner">
            <!-- #section:basics/content.breadcrumbs -->
            <div class="breadcrumbs" id="breadcrumbs">
                <script type="text/javascript">
                    try {
                        ace.settings.check('breadcrumbs', 'fixed')
                    } catch (e) {
                    }
                </script>

                <ul class="breadcrumb">
                    <li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">首页</a></li>
                </ul>
                <!-- /.breadcrumb -->

                <!-- /section:basics/content.searchbox -->
            </div>

            <!-- /section:basics/content.breadcrumbs -->
            <div class="page-content">


                <!-- /section:settings.box -->
                <div class="page-header">
                    <h1>
                        后台管理系统
                        <small><i class="ace-icon fa fa-angle-double-right"></i> 首页
                        </small>
                    </h1>
                </div>
                <!-- /.page-header -->
                <div class="row">
                    <div class="col-xs-12">
                        <div class="widget-box widget-color-blue">
                            <div class="widget-body">
                                <div class="widget-main">
                                    <table class="searchField" style="margin: 4px; padding: 4px;">
                                        <tr style="margin-top: 5px;">
                                            <td>起始日期:</td>
                                            <td><input type="text" id="startDate" class="form-control " placeholder=""
                                                       value=""></td>
                                            <td>结束日期:</td>
                                            <td><input type="text" id="endDate" class="form-control " placeholder=""
                                                       value=""></td>
                                            <td>
                                                <button class="btn btn-primary btn-sm" id="btnSearch">
                                                    <i class="ace-icon fa fa-search"></i> 查询
                                                </button>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- PAGE CONTENT BEGINS -->
                <div class="row">
                    <div class="col-xs-12">
                        <div id="container"></div>
                    </div>
                    <div class="col-xs-12">
                        <div id="container2"></div>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <!-- /.main-content -->
</div>
<!-- /.main-container -->
<%@ include file="common/js.jsp" %>
<script src="${staticServer }/assets/components/jquery-ui/jquery-ui.js"></script>
<script src="${staticServer }/assets/highcharts/js/highcharts.js"></script>
<script src="${staticServer }/assets/highcharts/js/highcharts-3d.js"></script>
<script src="${staticServer }/assets/highcharts/js/modules/exporting.js"></script>
<script src="${staticServer }/assets/components/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
<script src="${staticServer }/assets/components/bootstrap-datepicker/js/locales/bootstrap-datepicker.zh-CN.js"></script>
</body>
<script>
    $(function () {
        var $start = $("#startDate");
        var $end = $("#endDate");
        $start.datepicker({
            format: "yyyy-mm-dd ",
            autoclose: true,
            todayHighlight: true,
            language: "zh-CN",
            orientation: "bottom auto"
        });
        $end.datepicker({
            format: "yyyy-mm-dd",
            autoclose: true,
            todayHighlight: true,
            language: "zh-CN",
            orientation: "bottom auto"
        });

        $('#container2').highcharts({
            chart: {
                renderTo: 'container2',
                type: 'column',
                options3d: {
                    enabled: true,
                    alpha: 15,
                    beta: 15,
                    depth: 50,
                    viewDistance: 25
                }
            },
            title: {
                text: '流量统计图'
            },
            subtitle: {
                text: '最近一周统计图'
            },
            credits: {
                enabled: false
            },
            plotOptions: {
                column: {
                    pointPadding: 0.2,
                    borderWidth: 0,
                    dataLabels: {
                        enabled: true,
                        format: '{point.y}'
                    }
                },
                line: {
                    dataLabels: {
                        enabled: true,
                        format: '{point.y} %'
                    }
                }
            },
            xAxis: {
                categories: ["2017-03-02", "2017-03-03", "2017-03-04", "2017-03-05", "2017-03-06",
                    "2017-03-07", "2017-03-08", "2017-03-09", "2017-03-10",
                    "2017-03-11", "2017-03-12", "2017-03-13"]
            },
            series: [{
                name: '流量使用统计图',
                data: [29.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 0]
            }],
            lang: {
                contextButtonTitle: '导出按钮文字',
                decimalPoint: '小数点',
                downloadJPEG: '导出JPEG',
                downloadPDF: '导出PDF',
                downloadPNG: '导出PNG',
                downloadSVG: '导出SVG',
                drillUpText: '上钻',
                invalidDate: '无效的时间',
                loading: '加载中',
                months: '月份',
                noData: '没有数据',
                numericSymbolMagnitude: '国际单位符基数',
                numericSymbols: '国际单位符',
                printChart: '打印图表',
                resetZoom: '重置缩放比例',
                resetZoomTitle: '重置缩放标题',
                shortMonths: '月份缩写',
                shortWeekdays: '星期缩写',
                thousandsSep: '千分号',
                weekdays: '星期'
            }
        });

        $('#container').highcharts({
            chart: {
                type: 'column'
            },
            title: {
                text: '流量使用统计图'
            },
            subtitle: {
                text: '最近流量使用统计图'
            },
            xAxis: {
                categories: [
                    '一月',
                    '二月',
                    '三月',
                    '四月',
                    '五月',
                    '六月',
                    '七月',
                    '八月',
                    '九月',
                    '十月',
                    '十一月',
                    '十二月'
                ],
                crosshair: true
            },
            yAxis: {
                min: 0,
                title: {
                    text: '流量使用量 (M)'
                }
            },
            plotOptions: {
                column: {
                    pointPadding: 0.2,
                    borderWidth: 0
                }
            },
            series: [{
                name: '流量使用量',
                data: [5282, 7595, 6981, 5968, 4852, 5888, 6222, 6354, 6593, 6428, 7581, 3570]
            }],
            lang: {
                contextButtonTitle: '导出按钮文字',
                decimalPoint: '小数点',
                downloadJPEG: '导出JPEG',
                downloadPDF: '导出PDF',
                downloadPNG: '导出PNG',
                downloadSVG: '导出SVG',
                drillUpText: '上钻',
                invalidDate: '无效的时间',
                loading: '加载中',
                months: '月份',
                noData: '没有数据',
                numericSymbolMagnitude: '国际单位符基数',
                numericSymbols: '国际单位符',
                printChart: '打印图表',
                resetZoom: '重置缩放比例',
                resetZoomTitle: '重置缩放标题',
                shortMonths: '月份缩写',
                shortWeekdays: '星期缩写',
                thousandsSep: '千分号',
                weekdays: '星期'
            }
        });
    });
</script>
</html>
