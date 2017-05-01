/**
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
            }]
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
