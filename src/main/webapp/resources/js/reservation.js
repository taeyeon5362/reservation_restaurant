$(function(){

    var myData;
    var lastIndex = 0;

    $('#addMenuButton').click(function(){
        var targetList = $('#menuSection_0').clone().attr('id','menuSection_'+lastIndex);
        targetList.find('#dishes_0').attr('id','dishes_'+lastIndex)
        targetList.find('#stockMenu_0').attr('id','stockMenu_'+lastIndex)
        lastIndex+=1;
        $('#addMenu').append(targetList);
        changeStock(myData);
        //var target = targetList[targetList.length-1];
        //console.log(target);
    })

    $('#removeButton').click(function(){
        var target = $('#menuSection_'+Number(lastIndex-1));
        target.remove();
        lastIndex-=1;
        //var target = targetList[targetList.length-1];
        //console.log(target);
    })

    $.ajax({
        url:'/reservations/new/menu',
        type:'get',

        success:function(data){
            myData = data;
            console.log(data);
            var target = $('#dishSection');
            var sel = '';
            data.forEach(function(menu,idx){
                if(idx==0){
                    sel += '<select class="form-select" name="dishes" id="dishes_'+idx+'\" required="" style="user-select: auto;">'
                }
                sel +='<option value=\''+menu.dish+'\' id=\'menu_'+idx+'\' class=\'menu_dish\'>'+menu.dish+'/'+menu.price+'</option>';
            })
            sel += '</select>'
            target.append(sel);

            target = $('#qntSection');
            sel = '';
            var idx = data[0].stock;
            for(var i=0;i<idx;i++){
                if(i==0){
                    sel += '<select class="form-select" name="stockMenu" id="stockMenu_'+lastIndex+'\" required="" style="user-select: auto;">';
                    lastIndex+=1
                }
                sel += '<option value=\''+Number(i+1)+'\' id=\'qnt_'+idx+'\' class=\'menu_qnt\'>'+Number(i+1)+'</option>';
            }
            sel += '</select>';
            target.append(sel);
            changeStock(data);
        },
        error:function(error){
            alert('error');
        }    
    })

    function changeStock(data){
        $('select[name=dishes]').change(function(){
            var myID = '#'+$(this).attr('id');
            var index = myID.charAt(myID.length-1);
            var idx = $(myID+' option').index($(myID+' option:selected'));
            var target = $('#stockMenu_'+index);
            target.empty();

            var newStock = myData[idx].stock;
            for(var i=0;i<newStock;i++){
                var qnt = '<option id=\'qnt_'+idx+'\' class=\'menu_qnt\'>'+Number(i+1)+'</option>';
                target.append(qnt);
            }
        })
    }

    $('#chooseTable').click(function(){
        var numberOfPeople = $('select[name="numberOfPeople"]');
        var nopSize = numberOfPeople.length;
        var peoples = [];
        var totalPeople = 0;
        numberOfPeople.each(function(idx,select){
            peoples.push(Number($(select).val()))
            totalPeople += Number($(select).val());
        })

        resInfo = {"peoples":peoples,"startDate":$('#startDate').val(),"startTime":$('#startTime').val()};
        $.ajax({
            url:'/reservations/validTables',
            type:'post',
            contentType:'application/json; charset=utf8',
            dataType:'json',
            data:JSON.stringify(resInfo),

            success:function(data){
                console.log(data);
                $('.tableImage').append('<img style="height:600px; width:750px" src=\'../../resources/image/Tables.jpg\'/>');
                var target = $('.tableSelector');
                target.append('<h4> * 테이블은 위쪽부터 1번입니다.</h4><br>');
                for (var i = 0; i < nopSize; i++) {
                    var times = i+1;
                    target.append('<h3>'+times+'번 예약</h3>');
                    data.forEach(function(bool,idx){
                        var num = idx+1;
                        var text = '<input value=\''+num+'\' style="margin:10px" type=\'checkbox\' class=\'tableCheck\' id=\'check_'+times+'_'+num+'\'>'+num+'번 테이블';
                        target.append(text);
                        if(!bool){
                            target_check = '#check_'+times+'_'+num;
                            $(target_check).attr('disabled',true);
                            $(target_check).addClass('never')
                    }
                    })
                    target.append('<br>');
                }
                target.append('<button class=\'my-4 w-100 btn btn-warning btn-primary btn-lg\' id=\'submit\' disabled>예약 완료</button>');
                sendDataListener();
                checkBoxEvent(); 
            }
        })
        
    })

    function sendDataListener(){
        $('#submit').on('click',function(){
            var numberOfPeople = $('select[name="numberOfPeople"]');
            var numberOfPeople = [];
            $('select[name="numberOfPeople"]').each(function(idx,target){
                numberOfPeople.push(Number($(target).val()))
            })
            var hasCar = $('#hasCar').val();
            var menu = [];
            $('select[name=dishes]').each(function(idx,target){
                menu.push($(target).val());
            })
            var dishCounts = [];
            $('select[name=stockMenu]').each(function(idx,target){
                dishCounts.push($(target).val());
            })
            var resDate = $('#startDate').val();
            var resTime = $('#startTime').val();
            var tables = [];
            $('input:checkbox').each(function(idx,target){
                if($(target).prop('checked')){
                    tables.push($(target).val());
                }
            })
            $.ajax({
                url:'/reservations/new',
                type:'post',
                contentType:'application/json; charset=utf8',
                dataType:'json',
                data:JSON.stringify({"peoples":numberOfPeople,"dishesList":menu,"startDate":resDate,"startTime":resTime,"tableNos":tables,"dishCountsLists":dishCounts,"hasCar":hasCar}),

                success:function(data){
                    if(data!=""){
                        alert('예약이 완료되었습니다.')
                        $(location).attr('href', '/')
                    }else{
                        alert('어라..?')
                    }
                },
                error:function(){
                    alert("시스템 에러가 발생하였습니다. 정보를 확인해주세요.");
                }

            })
        })
        
    }
    var checked = 0;
    function checkBoxEvent(){
        $('input:checkbox').on('click',function(){
            var numberOfPeople = $('select[name="numberOfPeople"]');
            var nopSize = numberOfPeople.length;
            var myID = $(this).attr('id');
            var myFirstIndex = myID.charAt(myID.length-3);
            var myLastIndex = myID.charAt(myID.length-1);
            var myClass = '.'+$(this).attr('class');
            var friends = $(this).parent().find(myClass);
            if(nopSize==1){
                if($(this).prop('checked')){
                    checked += 1;
                    var friends = $(this).parent().find(myClass);
                    friends.each(function(idx,target){
                        var yourLastIndex = $(target).attr('id').charAt($(target).attr('id').length-1);
                        if(myLastIndex!=yourLastIndex){
                            $(target).prop('disabled',true);
                        }
                    })
                    if(checked==nopSize){
                        $('#submit').attr('disabled',false);
                    }
                }
                else{
                    checked -= 1;
                    friends.each(function(idx,target){
                        var yourLastIndex = $(target).attr('id').charAt($(target).attr('id').length-1);
                        if(myLastIndex!=yourLastIndex && !$(target).hasClass('never')){
                            $(target).prop('disabled',false);
                        }
                    })
                    if(checked!=nopSize){
                        $('#submit').attr('disabled',true);
                    }
                }
                return;
            }
            
            if($(this).prop('checked')){
                checked += 1;
                friends.each(function(idx,target){
                    var yourFirstIndex = $(target).attr('id').charAt($(target).attr('id').length-3);
                    var yourLastIndex = $(target).attr('id').charAt($(target).attr('id').length-1);
                    if(myLastIndex==yourLastIndex && myFirstIndex!=yourFirstIndex){
                        $(target).prop('disabled',true);
                    }
                })
                if(checked==nopSize){
                    $('#submit').attr('disabled',false);
                }
            }
            else{
                checked -= 1;
                friends.each(function(idx,target){
                    var yourFirstIndex = $(target).attr('id').charAt($(target).attr('id').length-3);
                    var yourLastIndex = $(target).attr('id').charAt($(target).attr('id').length-1);
                    if(myLastIndex==yourLastIndex && myFirstIndex!=yourFirstIndex){
                        $(target).prop('disabled',false);
                    }
                })
                if(checked!=nopSize){
                    $('#submit').attr('disabled',true);
                }
            }
        })
    }
})