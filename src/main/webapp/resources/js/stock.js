$(function () {

    $('#addButton').on('click',function(){
        var target = $('#addStock');
        var dish = '<div class="row g-3" style="padding-top:20px; user-select: auto;"> <div class="col-md-4" style="user-select: auto; margin-top: 6.3%;"> <div class="input-group mb-3"> <div class="input-group-prepend"> <span class="input-group-text" id="basic-addon'+lastIndex+'\">메뉴명</span> </div> <input type="text"class="form-control" id="basic-url'+lastIndex+'" aria-describedby="basic-addon'+lastIndex+'\"> </div> </div><div class="col-md-4" style="user-select: auto;"> <label for="numberOfdish" class="form-label" style="user-select: auto;">월별 재입고량</label> <input type="text" class="form-control" id="basic-restock'+lastIndex+'\" aria-describedby="basic-addon3"></div> <div class="invalid-feedback" style="user-select: auto;"></div> </div>  <div class="input-group mb-3"> <div class="input-group-prepend"> <span class="input-group-text">$</span> </div> <input id="basic-price'+lastIndex+'\" type="text" class="form-control" aria-label="Amount (to the nearest dollar)"> <div class="input-group-append"> <span class="input-group-text">.00</span> </div> </div> </div> </div> </div>'
        target.append(dish);
        lastIndex+=1;
    })

    $('#removeButton').on('click',function(){
        var dish = prompt('삭제할 음식을 입력해주세요');
        $('#addStock').find('.form-control').each(function(idx,content){
            console.log($(content).val())
            if(dish==$(content).val()){
                $(content).parent().parent().parent().remove();
            }
        })
    })

    var lastIndex = 0;
    $.ajax({
        url: '/manager/stock/getStock',
        type: 'get',

        success: function (data) {
            var target = $('#addStock');
            data.forEach(function (menu, idx) {
                var dish = '<div class="row g-3" style="padding-top:20px; user-select: auto;"> <div class="col-md-4" style="user-select: auto; margin-top: 6.3%;"> <div class="input-group mb-3"> <div class="input-group-prepend"> <span class="input-group-text" id="basic-addon'+idx+'\">메뉴명</span> </div> <input type="text"class="form-control" id="basic-url'+idx+'" aria-describedby="basic-addon'+idx+'\"> </div> </div><div class="col-md-4" style="user-select: auto;"> <label for="numberOfdish" class="form-label" style="user-select: auto;">월별 재입고량</label> <input type="text" class="form-control" id="basic-restock'+idx+'\" aria-describedby="basic-addon3"></div> <div class="invalid-feedback" style="user-select: auto;"></div> </div>  <div class="input-group mb-3"> <div class="input-group-prepend"> <span class="input-group-text">$</span> </div> <input id="basic-price'+idx+'\" type="text" class="form-control" aria-label="Amount (to the nearest dollar)"> <div class="input-group-append"> <span class="input-group-text">.00</span> </div> </div> </div> </div> </div>'
                target.append(dish);
                lastIndex+=1;
                $('#basic-url'+idx).val(menu.dish)
                $('#basic-restock'+idx).val(menu.restockRate)
                $('#basic-price'+idx).val(menu.price)
            })
        },
        error: function (error) {
            alert('error');
        }
    })
})

