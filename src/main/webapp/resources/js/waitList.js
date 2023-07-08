
$(document).ready(function(){
            $(document).on("click","button",function(){
                var button = $(this);
                var tr = $(this).parent().parent();
                var td = tr.children();
                var cid = td.eq(0).text();
                var resDate = td.eq(6).text();
                var dishes = td.eq(7).text();
                var dishCounts = td.eq(8).text();
                var resInfo={"customerID":cid,"reservationDate":resDate,"dishes":dishes,"dishCounts":dishCounts};
                $.ajax({
                    url:"/waitList",
                    type:'post',
                    contentType:'application/json; charset=utf8',
                    dataType:'json',
                    data:JSON.stringify(resInfo),
                    success:function(data){
                        console.log(data)
                        if(data){
                            alert("도착이 확인되었습니다.");
                            button.prop("disabled",true);
                        }else{
                            alert("오류가 발생하였습니다. 다시 시도하여 주십시오.");
                        }
                    }
                })
            })
        })
        $(function(){
            $.ajax({
                url:'/waitList/getList',
                type:'get',

                success:function(data){
                    var targetTable = $('#tableBody');
                    data.forEach(function(item,idx){
                        console.log(item);
                        var add_data='';
                        add_data +='<tr id="tr_'+idx+"\">"
                        
                        add_data +='<td>';
                        add_data += item['customerID']
                        add_data +='</td>';

                        add_data +='<td>';
                        add_data += item['tableNo']
                        add_data +='</td>';

                        add_data +='<td>';
                        add_data += item['numberOfPeople']
                        add_data +='</td>';

                        add_data +='<td>';
                        add_data += item['customerName']
                        add_data +='</td>';

                        add_data +='<td>';
                        add_data += item['customerEmail']
                        add_data +='</td>';

                        add_data +='<td>';
                        add_data += item['hasCar']
                        add_data +='</td>';

                        add_data +='<td>';
                        add_data += item['reservationDate']
                        add_data +='</td>';

                        add_data +='<td style="display:none">';
                        add_data += item['dishes']
                        add_data +='</td>';

                        add_data +='<td style="display:none">';
                        add_data += item['dishCounts']
                        add_data +='</td>';

                        add_data +='<td>';
                        add_data += '<button class=\"tr-button\" id="tr_'+idx+"_button\"style=\"width=100%\">도착 확인</button>";
                        add_data +='</td>';

                        targetTable.append(add_data);
                    })
                }
            
            })
        })