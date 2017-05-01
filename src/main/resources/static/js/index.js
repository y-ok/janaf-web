/**
 * Created by y-ok on 2017/04/30.
 */
$(document).ready(function () {
    var table = $('table#elements').DataTable({
        "sAjaxSource": '/data/elements',
        "sAjaxDataProp": "",
        "order": [[0, "asc"]],
        "aoColumns": [
            {
                "mData": "id",
                "render": function(data) {
                    return '<a href="/element?id='+ data + '">' + data + '</a>';
                }
            },
            {
                "mData": "elementName"
            },
            {
                "mData": "elementUrl",
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
