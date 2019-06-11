$("select#paisD").change(function()){
    var countryVal = $("#paisD").val();
    $.ajax({
        url:'/municipios/'+countryVal,
        method: 'GET',
    }),
    sucess:function(depa){
        var stateSelect = $('#depaD');
        stateSelect.find('option').remove();
        for(i=0;i<stateSelect.length;i++){
            stateSelect.append("<option th:value= \""$\{depa[i].pkDepartamento\}\"")
        }
    }
}