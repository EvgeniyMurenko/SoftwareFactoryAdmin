"use strict";
jQuery(document).ready(function($) {

    // Notices
    $(".notice-box a").each(function () {
        var notice_id = $(this).attr('id');

        $("#" + notice_id).click(function() {
            if ( $("#" + notice_id).hasClass("active")) {
                $("#" + notice_id).removeClass("active");
                $("#" + notice_id + " i.fa").removeClass("fa-chevron-up");
                $("#" + notice_id + " i.fa").addClass("fa-chevron-down");
            } else {
                $("#" + notice_id).addClass("active");
                $("#" + notice_id + " i.fa").removeClass("fa-chevron-down");
                $("#" + notice_id + " i.fa").addClass("fa-chevron-up");
            }

            $("#box_" + notice_id).toggle();
        });
    });

    // Back to top
    var offset = 300,
        offset_opacity = 1200,
        scroll_top_duration = 700,
        $back_to_top = $('.cd-top');

    $(window).scroll(function(){
        ( $(this).scrollTop() > offset ) ? $back_to_top.addClass('cd-is-visible') : $back_to_top.removeClass('cd-is-visible cd-fade-out');
        if( $(this).scrollTop() > offset_opacity ) {
            $back_to_top.addClass('cd-fade-out');
        }
    });

    $back_to_top.on('click', function(event){
        event.preventDefault();
        $('body,html').animate({
                scrollTop: 0 ,
            }, scroll_top_duration
        );
    });

    // Portfolio slider
    $('#portfolio').carousel({
        interval: false,
    });

    // upload file
    $("#input-repl-2").fileinput({
        uploadUrl: "/file-upload-batch/2",
        autoReplace: true,
        maxFileCount: 5,
        //allowedFileExtensions: ["jpg", "jpeg", "png", "gif"]
    });
    $("#caseInput").fileinput({showCaption: false});
    $("#chat-upload").fileinput({showCaption: false});

    // table pagination
    $("div.holder").jPages({
        containerID : "itemContainer",
        perPage     : 10
    });

    // timeago
    $("time.timeago").timeago();

    // selectpicker
    $('.selectpicker').selectpicker({
        style: 'btn-info',
        size: 4
    });

    // datetimepicker
    $('#datetimepicker').datetimepicker({
        format: 'YYYY-MM-DD HH:mm',
        daysOfWeekDisabled: [0, 6],
    });

    // Don't use character in admin panel
    $('#case_id').keypress(function (e) {
        if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
            return false;
        }
    });


    // Authorization from validation
    $('#authorizationForm').formValidation({
        framework: 'bootstrap',
        excluded: ':disabled',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            email: {
                validators: {
                    notEmpty: {
                        message: '이메일은 필수 입력 항목 입니다.'
                    },
                    emailAddress: {
                        enabled: false,
                    },
                    regexp: {
                        regexp: /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i,
                        message: '이메일이 잘못 입력 되었습니다.'
                    },
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: '암호는 필수 입력 항목입니다. (공백은 허용하지 않습니다)'
                    },
                    stringLength: {
                        min: 3,
                        max: 20,
                        message: '암호는ㄴ 3자 이상 입력해야 하며 20자 입력 할 수 있습니다.'
                    },
                    regexp: {
                        regexp: /^[0-9_\.]+$/,
                        message: '암호는 알파벳, 숫자, 특수문자 (“.” , “_”)만 쓸 수 있습니다.'
                    }
                }
            }
        }
    });

    // Authorization from validation
    $('#estimationForm').formValidation({
        framework: 'bootstrap',
        excluded: ':disabled',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            email: {
                validators: {
                    notEmpty: {
                        message: '이메일은 필수 입력 항목 입니다.'
                    },
                    emailAddress: {
                        enabled: false,
                    },
                    regexp: {
                        regexp: /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i,
                        message: '이메일이 잘못 입력 되었습니다.'
                    },
                }
            },
            name: {
                validators: {
                    notEmpty: {
                        message: '항목을 채워 주세요 (이름 또는 별명)'
                    }
                }
            },
            phone: {
                validators: {
                    notEmpty: {
                        message: '입력-A 바랍니다 축.'
                    },
                    regexp: {
                        message: '올바른 형식으로 전화 번호를 입력하십시오.'
                    }
                }
            },
            message: {
                validators: {
                    notEmpty: {
                        message: '항목을 채워 주세요.'
                    }
                }
            },
            checkEstimation: {
                selector: '.checkEstimation',
                err: '#alertCheckboxMessage',
                validators: {
                    notEmpty: {
                        message: '체크 박스를 하나 이상 선택하십시오.'
                    }
                }
            }
        }
    });
});

// Change admin params
function checkParams() {
    var case_id = $('#case_id').val();
    var case_name = $('#case_name').val();
    var case_project_name = $('#case_project_name').val();

    if (case_id.length != 0) {
        $('#case_name').attr('disabled', 'disabled');
        $('#case_project_name').attr('disabled', 'disabled');
    } else if(case_name.length != 0 || case_project_name.length != 0) {
        $('#case_id').attr('disabled', 'disabled');
    } else {
        $('#case_id').removeAttr('disabled');
        $('#case_name').removeAttr('disabled');
        $('#case_project_name').removeAttr('disabled');
    }
}

var editor = CKEDITOR.replace('editor', {
    toolbar : 'Basic',
    width : '100%',
    height : '250',
});
editor.add;