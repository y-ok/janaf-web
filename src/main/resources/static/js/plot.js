/**
 * plot.js
 * Created by y-ok on 2017/05/22.
 */
$.ajax({
    type: 'GET',
    url: '/data/elements',
    contentType: 'application/json',
    dataType: 'json',
    cache: 'false'
}).done(function (data) {
    $('#element_name option').remove();
    $.each(data, function (i, value) {
        $('#element_name').append($('<option>').text(value.elementName).attr('value', value.id));
    });

    $('#element_name').change(function () {
        $('#formula option').remove();
        var id = $("select#element_name option:selected").val();
        $.ajax({
            type: 'GET',
            url: '/data/elements/' + id,
            contentType: 'application/json',
            dataType: 'json',
            cache: false
        }).done(function (data) {
            $('#formula option').remove();
            $.each(data, function (i, value) {
                $('#formula').append($('<option>').text(value.formula + ', ' + value.state).attr('value', value.elementDetailInfoId));
            });

            $('#formula').change(function () {
                var id = $("select#formula option:selected").val();
                $.ajax({
                    type: 'GET',
                    url: '/data/thermochemical-data/' + id,
                    contentType: 'application/json',
                    dataType: 'json',
                    cache: false
                }).done(function (data) {
                    //console.log(JSON.stringify(data, undefined, 4));
                    makePlot(data)
                });
            });
        }).fail(function () {
            alert('Error!!');
        });
    });

}).fail(function () {
    alert('Error!!');
});

/**
 * プロットを表示します
 * @param data
 */
function makePlot(data) {
    var chart = AmCharts.makeChart("chartdiv", {
        "type": "serial",
        "legend": {
            "equalWidths": false,
            "useGraphSettings": true,
            "valueAlign": "left",
            "valueWidth": 120
        },
        "synchronizeGrid": true,
        "categoryField": "temperature",
        "valueAxes": [
            {
                "id": "specificHeatAxis",
                "position": "left",
                "title": "specificHeat",
                "axisColor": "#FF6600",
                "axisThickness": 2,
                "axisAlpha": 1
            },
            {
                "id": "entropyAxis",
                "position": "right",
                "title": "entropy",
                "axisColor": "#FCD202",
                "axisThickness": 2,
                "axisAlpha": 1
            },
            {
                "id": "gibbsAxis",
                "position": "left",
                "title": "gibbs",
                "axisColor": "#B0DE09",
                "axisThickness": 2,
                "gridAlpha": 0,
                "offset": 60,
                "axisAlpha": 1
            },
            {
                "id": "enthalpyAxis",
                "position": "right",
                "title": "enthalpy",
                "axisColor": "#0D8ECF",
                "axisThickness": 2,
                "gridAlpha": 0,
                "offset": 60,
                "axisAlpha": 1
            }
        ],
        "graphs": [
            {
                "balloonText": "specificHeat:[[value]]",
                "bullet": "square",
                "bulletBorderAlpha": 1,
                "useLineColorForBulletBorder": true,
                "bulletColor": "#FFFFFF",
                "valueField": "specificHeat",
                "title": "比熱",
                "valueAxis": "specificHeatAxis",
                "fillAlphas": 0
            },
            {
                "balloonText": "entropy:[[value]]",
                "bullet": "round",
                "bulletBorderAlpha": 1,
                "useLineColorForBulletBorder": true,
                "bulletColor": "#FFFFFF",
                "valueField": "entropy",
                "title": "エントロピー",
                "valueAxis": "entropyAxis",
                "fillAlphas": 0
            },
            {
                "balloonText": "gibbs:[[value]]",
                "bullet": "triangleUp",
                "bulletBorderAlpha": 1,
                "useLineColorForBulletBorder": true,
                "bulletColor": "#FFFFFF",
                "valueField": "gibbs",
                "title": "ギブス",
                "valueAxis": "gibbsAxis",
                "fillAlphas": 0
            },
            {
                "balloonText": "enthalpy:[[value]]",
                "bullet": "triangleDown",
                "bulletBorderAlpha": 1,
                "useLineColorForBulletBorder": true,
                "bulletColor": "#FFFFFF",
                "valueField": "enthalpy",
                "title": "エンタルピー",
                "valueAxis": "enthalpyAxis",
                "fillAlphas": 0
            }

        ],
        "chartScrollbar": {},
        "chartCursor": {
            "cursorPosition": "mouse"
        },
        "export": {
            "enabled": true,
            "position": "bottom-right"
        }
    });

    chart.dataProvider = data;
    chart.validateNow();
    chart.validateData();
}