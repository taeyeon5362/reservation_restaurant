$(function () {
    $('#chooseTable').click(function () {
        var numberOfPeople = $('select[name="numberOfPeople"]');
        var nopSize = numberOfPeople.length;
        var peoples = [];
        var totalPeople = 0;
        numberOfPeople.each(function (idx, select) {
            peoples.push(Number($(select).val()))
            totalPeople += Number($(select).val());
        })

        walkInInfo = {
            "peoples": peoples
        };
        $.ajax({
            url: '/walkIn/validTables',
            type: 'post',
            contentType: 'application/json; charset=utf8',
            dataType: 'json',
            data: JSON.stringify(walkInInfo),

            success: function (data) {
                $('.tableImage').append('<img style="height:600px; width:750px" src=\'../../resources/image/Tables.jpg\'/>');
                var target = $('.tableSelector');
                target.append('<h4> * 테이블은 위쪽부터 1번입니다.</h4><br>');
                for (var i = 0; i < nopSize; i++) {
                    var times = i + 1;
                    target.append('<h3>' + times + '번 예약</h3>');
                    data.forEach(function (bool, idx) {
                        var num = idx + 1;
                        var text = '<input value=\'' + num + '\' style="margin:10px" type=\'checkbox\' ' +
                                'class=\'tableCheck\' id=\'check_' + times + '_' + num + '\'>' + num +
                                '번 테이블';
                        target.append(text);
                        if (!bool) {
                            target_check = '#check_' + times + '_' + num;
                            $(target_check).attr('disabled', true);
                            $(target_check).addClass('never')
                        }
                    })
                    target.append('<br>');
                }
                
                target.append(
                    '<button class=\'my-4 w-100 btn btn-warning btn-primary btn-lg\' id=\'submit\' ' +
                    'disabled>워크인 등록</button>'
                );
                sendDataListener();
                checkBoxEvent();
            }
        })

    })

    function sendDataListener() {
        $('#submit').on('click', function () {
            var numberOfPeople = [];
            $('select[name="numberOfPeople"]').each(function (idx, target) {
                numberOfPeople.push(Number($(target).val()))
            })
            var tables = [];
            $('input:checkbox').each(function (idx, target) {
                if ($(target).prop('checked')) {
                    tables.push($(target).val());
                }
            })
            $.ajax({
                url: '/walkIn/new',
                type: 'post',
                contentType: 'application/json; charset=utf8',
                dataType: 'json',
                data: JSON.stringify({"peoples": numberOfPeople, "tableNos": tables}),

                success: function (data) {
                    if (data != "") {
                        alert('워크인 등록이 완료되었습니다.')
                        $(location).attr('href', '/')
                    } else {
                        alert('어라..?')
                    }
                },
                error: function () {
                    alert("시스템 에러가 발생하였습니다. 정보를 확인해주세요.");
                }

            })
        })
    }

    var checked = 0;
    function checkBoxEvent() {
        $('input:checkbox').on('click', function () {
            var numberOfPeople = $('select[name="numberOfPeople"]');
            var nopSize = numberOfPeople.length;
            var itsMe = $(this);
            var myID = $(this).attr('id');
            var myFirstIndex = myID.charAt(myID.length - 3);
            var myLastIndex = myID.charAt(myID.length - 1);
            var myClass = '.' + $(this).attr('class');
            var friends = $(this)
                .parent()
                .find(myClass);
            if (nopSize == 1) {
                if ($(this).prop('checked')) {
                    checked += 1;
                    var friends = $(this)
                        .parent()
                        .find(myClass);
                    friends.each(function (idx, target) {
                        var yourLastIndex = $(target)
                            .attr('id')
                            .charAt($(target).attr('id').length - 1);
                        if (myLastIndex != yourLastIndex) {
                            $(target).prop('disabled', true);
                        }
                    })
                    if (checked == nopSize) {
                        $('#submit').attr('disabled', false);
                    }
                } else {
                    checked -= 1;
                    friends.each(function (idx, target) {
                        var yourLastIndex = $(target)
                            .attr('id')
                            .charAt($(target).attr('id').length - 1);
                        if (myLastIndex != yourLastIndex && !$(target).hasClass('never')) {
                            $(target).prop('disabled', false);
                        }
                    })
                    if (checked != nopSize) {
                        $('#submit').attr('disabled', true);
                    }
                }
                return;
            }

            if ($(this).prop('checked')) {
                checked += 1;
                friends.each(function (idx, target) {
                    var yourFirstIndex = $(target)
                        .attr('id')
                        .charAt($(target).attr('id').length - 3);
                    var yourLastIndex = $(target)
                        .attr('id')
                        .charAt($(target).attr('id').length - 1);
                    if (myLastIndex == yourLastIndex && myFirstIndex != yourFirstIndex) {
                        $(target).prop('disabled', true);
                    }
                })
                if (checked == nopSize) {
                    $('#submit').attr('disabled', false);
                }
            } else {
                checked -= 1;
                friends.each(function (idx, target) {
                    var yourFirstIndex = $(target)
                        .attr('id')
                        .charAt($(target).attr('id').length - 3);
                    var yourLastIndex = $(target)
                        .attr('id')
                        .charAt($(target).attr('id').length - 1);
                    if (myLastIndex == yourLastIndex && myFirstIndex != yourFirstIndex) {
                        $(target).prop('disabled', false);
                    }
                })
                if (checked != nopSize) {
                    $('#submit').attr('disabled', true);
                }
            }
        })
    }
})