/**
 * elements_for_form.js
 * Created by y-ok on 2017/05/15.
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
        $('#temperature option').remove();
        $('#specificHeat option').remove();
        $('#entropy option').remove();
        $('#gibbs option').remove();

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
                $('#temperature option').remove();
                $('#specificHeat option').remove();
                $('#entropy option').remove();
                $('#gibbs option').remove();

                var id = $("select#formula option:selected").val();
                $.ajax({
                    type: 'GET',
                    url: '/data/thermochemical-data/' + id,
                    contentType: 'application/json',
                    dataType: 'json',
                    cache: false
                }).done(function (data) {
                    console.log(JSON.stringify(data, undefined, 4));
                    $('#temperature option').remove();
                    $.each(data, function (i, value) {
                        $('#temperature').append($('<option>').text(value.temperature).attr('value', i));

                    });

                    $('#temperature').change(function () {
                        $('#specificHeat option').remove();
                        $('#entropy option').remove();
                        $('#gibbs option').remove();

                        var selectedIndex = $("#temperature option:selected").val();
                        $('#specificHeat').append($('<option>').text(data[selectedIndex].specificHeat).attr('value', data[selectedIndex].elementThermoChemicalDataInfoId));
                        $('#entropy').append($('<option>').text(data[selectedIndex].entropy).attr('value', data[selectedIndex].elementThermoChemicalDataInfoId));
                        $('#gibbs').append($('<option>').text(data[selectedIndex].gibbs).attr('value', data[selectedIndex].elementThermoChemicalDataInfoId));
                    })

                });
            });
        }).fail(function () {
            alert('Error!!');
        });
    });

}).fail(function (data) {
    alert('Error!!');
});
