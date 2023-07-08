var lastIndex = 0;
$(document).ready(function(){
    $(document).on("click","#addForm",function(){
        var target = $('.addResv')
        lastIndex += 1;
        var add_data = '';
        add_data+='<div class="row g-3" style="padding-top:20px; user-select: auto;">'
        add_data+='<div class="col-md-3" style="user-select: auto; display:inline">'
        add_data+='<p>'+lastIndex+'번 테이블</p>'
        add_data+='<div class="invalid-feedback" style="user-select: auto;"></div>'
        add_data+='</div>'
        add_data+='<div class="col-md-4" style="user-select: auto;">'
        add_data+='<label for="numberOfPeople" class="form-label" style="user-select: auto;">착석 인원</label> '
        add_data+='<select class="form-select" name="numberOfPeople" id="numberOfPeople" required="" style="user-select: auto;">'
        add_data+='<option value="" style="user-select: auto;">선택</option>'
        add_data+='<option value="1" style="user-select: auto;">1</option>'
        add_data+='<option value="2" style="user-select: auto;">2</option>'
        add_data+='<option value="3" style="user-select: auto;">3</option>'
        add_data+='<option value="4" style="user-select: auto;">4</option>'
        add_data+='</select>'
        add_data+='</div>'
        add_data+='<div class="col-md-5" style="user-select: auto;">'
        add_data+='<button class=\"remove\">삭제</button>'
        add_data+='</div>'
        add_data+='</div>'

        target.append(add_data);
    })
    $(document).on("click","#submit",function(){
        var target = $(this).parent().find('.form-select');
        var result = [];
        target.each(function(i,obj){
            result.push($(obj).val());
        })
        var sendData = {"tableInfo":result};
        $.ajax({
            url:"/manager/tableManage",
            type:'post',
            contentType:'application/json; charset=utf8',
            dataType:'json',
            data:JSON.stringify(sendData),
            success:function(data){
                console.log("hello");
                if(data){
                    alert("변경완료");
                }else{
                    alert("오류가 발생하였습니다. 다시 시도하여 주십시오.");
                }
            }
        })
    })
    $(document).on("click",".remove",function(){
        var result = confirm('테이블을 삭제하시겠습니까?');
        if(result){
            var target = $(this).parent().parent();
            target.remove();
        }
    })
})
    $(function(){
        $.ajax({

            url:'/manager/tableManage/getTableLists',
            type:'get',

            success:function(data){        
                var target = $('.addResv');        
                data.forEach(function(table,idx){
                    var add_data = '';
                    add_data+='<div class="row g-3" style="padding-top:20px; user-select: auto;">'
                    add_data+='<div class="col-md-3" style="user-select: auto; display:inline">'
                    add_data+='<p>'+table['tableNumber']+'번 테이블</p>'
                    add_data+='<div class="invalid-feedback" style="user-select: auto;"></div>'
                    add_data+='</div>'
                    add_data+='<div class="col-md-4" style="user-select: auto;">'
                    add_data+='<label for="numberOfPeople" class="form-label" style="user-select: auto;">착석 인원</label> '
                    add_data+='<select class="form-select" name="numberOfPeople" id="numberOfPeople_'+table['tableNumber']+'" required="" style="user-select: auto;">'
                    add_data+='<option value="" style="user-select: auto;">선택</option>'
                    add_data+='<option value="1" style="user-select: auto;">1</option>'
                    add_data+='<option value="2" style="user-select: auto;">2</option>'
                    add_data+='<option value="3" style="user-select: auto;">3</option>'
                    add_data+='<option value="4" style="user-select: auto;">4</option>'
                    add_data+='</select>'
                    add_data+='</div>'
                    add_data+='<div class="col-md-5" style="user-select: auto;">'
                    add_data+='<button class=\"remove\">삭제</button>'
                    add_data+='</div>'
                    add_data+='</div>'
                    
                    lastIndex = table['tableNumber'];
                    target.append(add_data);
                    var tempID = '#numberOfPeople_'+table['tableNumber'];
                    $(tempID).val(String(table['people'])).prop("selected",true);
                })
                
            }
            
        })
    })