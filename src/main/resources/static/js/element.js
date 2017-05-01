/**
 * Created by y-ok on 2017/04/30.
 */
$(document).ready(function () {
    var id = $('div.container').attr('id');
    var table = $('table#element').DataTable({
        "sAjaxSource": '/data/elements/' + id,
        "sAjaxDataProp": "",
        "order": [[0, "asc"]],
        "aoColumns": [
            {
                "mData": "elementDetailInfoId",
                "render": function(data) {
                    return '<a href="/thermochemical-data?id='+ data + '">' + data + '</a>';
                }
            },
            {
                "mData": "casNumber"
            },
            {
                "mData": "formula"
            },
            {
                "mData": "name"
            },
            {
                "mData": "state"
            },
            {
                "mData": "JANAFTableUrl",
                "render": function (data) {
                    return '<a href="' + data + '">' + data + '</a>';
                }
            },
            {
                "mData": 'updateTime',
                "render": function (data) {
                    return moment(data).format('YYYY/MM/DD HH:mm:ss');
                }
            }]
    });

    $('#elements tfoot th#search').each(function () {
        var title = $(this).text();
        $(this).html('<input type="text" placeholder="Search ' + title + '" />');
    });

    // DataTable
    var table = $('#elements').DataTable();

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
