/**
 * Created by y-ok on 2017/04/30.
 */
$(document).ready(function () {
    var table = $('table#elements').DataTable({
        'ajax': '/data/elements',
        'serverSide': true,
        columns: [{
            data: 'id'
        }, {
            data: 'elementName'
        }, {
            data: 'elementUrl',
            "render": function (data, typpe, row, meta) {
                return '<a href="' + data + '">' + data + '</a>';
            }
        }]
    });
});
