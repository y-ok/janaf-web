/**
 *
 * Created by y-ok on 2017/04/30.
 */
$(document).ready(function () {
    var id = $('div.container').attr('id');
    var table = $('table#thermochemical-data').DataTable({
        "sAjaxSource": '/data/thermochemical-data/' + id,
        "sAjaxDataProp": "",
        "order": [[0, "asc"]],
        "aoColumns": [
            {
                "mData": "elementThermoChemicalDataInfoId"
            },
            {
                "mData": "temperature"
            },
            {
                "mData": "specificHeat"
            },
            {
                "mData": "entropy"
            },
            {
                "mData": "gibbs"
            },
            {
                "mData": "enthalpy"
            },
            {
                "mData": 'updateTime',
                "render": function (data) {
                    return moment(data).format('YYYY/MM/DD HH:mm:ss');
                }
            }],
        "language": {
            "emptyTable" : "データが登録されていません。",
            "info" : "_TOTAL_ 件中 _START_ 件から _END_ 件までを表示",
            "infoEmpty" : "",
            "infoFiltered" : "(_MAX_ 件からの絞り込み表示)",
            "infoPostFix" : "",
            "thousands" : ",",
            "lengthMenu" : "1ページあたりの表示件数: _MENU_",
            "loadingRecords" : "ロード中",
            "processing" : "処理中...",
            "search" : "検索",
            "zeroRecords" : "該当するデータが見つかりませんでした。",
            "paginate" : {
                "first" : "先頭",
                "previous" : "前へ",
                "next" : "次へ",
                "last" : "末尾"
            }
        }
    });

    $('#thermochemical-data tfoot th#search').each(function () {
        var title = $(this).text();
        $(this).html('<input type="text" placeholder="Search ' + title + '" />');
    });

    // DataTable
    var table = $('#thermochemical-data').DataTable();

    // Apply the search
    table.columns().every(function () {
        var that = this;

        $('input', this.footer()).on('keyup change', function () {
            if (that.search() !== this.value) {
                that.search(this.value)
                    .draw();
            }
        });
    });
});
